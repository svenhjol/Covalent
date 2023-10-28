package svenhjol.covalent.integration.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.impl.builders.FieldBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.network.chat.Component;
import svenhjol.charmony.annotation.Configurable;
import svenhjol.charmony.base.CharmonyConfig;
import svenhjol.charmony.base.DefaultFeature;
import svenhjol.charmony.base.Log;
import svenhjol.charmony.base.Mods;
import svenhjol.charmony.client.ClientFeature;
import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.helper.TextHelper;
import svenhjol.charmony.iface.IClientMod;
import svenhjol.charmony.iface.ICommonMod;
import svenhjol.charmony.iface.ILog;
import svenhjol.covalent.Covalent;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Use Charm's ModMenuPlugin as the default.
 * ModMenuConfig v1.0.1
 */
public class CovalentModMenuPlugin<F extends DefaultFeature> implements ModMenuApi {
    public String modId() {
        return Covalent.ID;
    }

    public Optional<IClientMod> client() {
        return Mods.optionalClient(modId());
    }

    public Optional<ICommonMod> common() {
        return Mods.optionalCommon(modId());
    }

    public ILog log() {
        return Mods.optionalCommon(modId()).map(ICommonMod::log).orElse(new Log(modId()));
    }

    @SuppressWarnings("unchecked")
    public List<F> getFeatures() {
        List<DefaultFeature> features = new ArrayList<>();

        common().ifPresent(m -> features.addAll(m.loader().getFeatures()));
        client().ifPresent(m -> features.addAll(m.loader().getFeatures()));

        features.sort(Comparator.comparing(DefaultFeature::name));
        return (List<F>) features;
    }

    @SuppressWarnings("unchecked")
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            var builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(TextHelper.translatable("cloth." + modId() + ".title"));

            var features = new LinkedList<>(getFeatures());
            features.sort(Comparator.comparing(F::name));

            // Serialise the config into the config file. This is called after all variables are updated.
            builder.setSavingRunnable(() -> {
                List<CommonFeature> commonFeatures = new LinkedList<>();
                List<ClientFeature> clientFeatures = new LinkedList<>();

                for (F feature : features) {
                    if (feature instanceof CommonFeature common) {
                        commonFeatures.add(common);
                    } else if (feature instanceof ClientFeature client) {
                        clientFeatures.add(client);
                    }
                }

                common().ifPresent(m -> m.config().writeConfig(commonFeatures));
                client().ifPresent(m -> m.config().writeConfig(clientFeatures));
            });

            var category = builder.getOrCreateCategory(TextHelper.translatable("cloth.category." + modId() + ".title"));

            for (var feature : features) {
                SubCategoryBuilder subcategory = null;
                var enabled = false;
                var name = feature.name();
                var description = feature.description();
                var properties = getFeatureConfigProperties(feature);

                if (feature.canBeDisabled()) {
                    subcategory = startSubcategory(builder, name, description);

                    var toggleFeatureName = TextHelper.translatable("cloth.category." + modId() + ".feature_enabled", name);
                    var defaultValue = feature.isEnabledByDefault();
                    enabled = feature.isEnabledInConfig();

                    var featureEntryBuilder = builder.entryBuilder()
                        .startBooleanToggle(toggleFeatureName, enabled)
                        .setDefaultValue(() -> defaultValue)
                        .setSaveConsumer(feature::setEnabledInConfig);

                    if (featureEntryBuilder != null) {
                        featureEntryBuilder.requireRestart();
                        subcategory.add(featureEntryBuilder.build());
                    }
                }

                for (Map.Entry<Field, Object> entry : properties.entrySet()) {
                    if (subcategory == null) {
                        subcategory = startSubcategory(builder, name, description);
                    }

                    var prop = entry.getKey();
                    var value = entry.getValue();

                    var annotation = prop.getDeclaredAnnotation(Configurable.class);
                    var propName = TextHelper.literal(annotation.name());
                    var propDescription = TextHelper.literal(TextHelper.splitOverLines(annotation.description()));
                    var requireRestart = annotation.requireRestart();

                    FieldBuilder<?, ?, ?> fieldBuilder = null;

                    if (value instanceof Boolean) {
                        fieldBuilder = builder.entryBuilder()
                            .startBooleanToggle(propName, (Boolean)value)
                            .setDefaultValue(() -> (Boolean)tryGetDefault(prop))
                            .setTooltip(propDescription)
                            .setSaveConsumer(val -> trySetProp(prop, val));
                    } else if (value instanceof Integer) {
                        fieldBuilder = builder.entryBuilder()
                            .startIntField(propName, (Integer)value)
                            .setDefaultValue(() -> (Integer)tryGetDefault(prop))
                            .setTooltip(propDescription)
                            .setSaveConsumer(val -> trySetProp(prop, val));
                    } else if (value instanceof Double) {
                        fieldBuilder = builder.entryBuilder()
                            .startDoubleField(propName, (Double)value)
                            .setDefaultValue(() -> (Double)tryGetDefault(prop))
                            .setTooltip(propDescription)
                            .setSaveConsumer(val -> trySetProp(prop, val));
                    } else if (value instanceof Float) {
                        fieldBuilder = builder.entryBuilder()
                            .startFloatField(propName, (Float)value)
                            .setDefaultValue(() -> (Float)tryGetDefault(prop))
                            .setTooltip(propDescription)
                            .setSaveConsumer(val -> trySetProp(prop, val));
                    } else if (value instanceof String) {
                        fieldBuilder = builder.entryBuilder()
                            .startTextField(propName, (String)value)
                            .setDefaultValue(() -> (String)tryGetDefault(prop))
                            .setTooltip(propDescription)
                            .setSaveConsumer(val -> trySetProp(prop, val));
                    } else if (value instanceof List) {
                        fieldBuilder = builder.entryBuilder()
                            .startStrList(propName, (List<String>)value)
                            .setDefaultValue(() -> (List<String>)tryGetDefault(prop))
                            .setTooltip(propDescription)
                            .setSaveConsumer(val -> trySetProp(prop, val));
                    }

                    if (fieldBuilder != null) {
                        fieldBuilder.requireRestart(requireRestart);
                        subcategory.add(fieldBuilder.build());
                    }
                }

                if (subcategory != null) {
                    category.addEntry(subcategory.build());
                }
            }

            return builder.build();
        };
    }

    private Map<Field, Object> getFeatureConfigProperties(F feature) {
        Map<Field, Object> properties = new LinkedHashMap<>();

        // Get and set feature config options
        var classFields = new ArrayList<>(Arrays.asList(feature.getClass().getDeclaredFields()));
        classFields.forEach(prop -> {
            try {
                Configurable annotation = prop.getDeclaredAnnotation(Configurable.class);
                if (annotation == null) return;

                Object value = prop.get(null);
                properties.put(prop, value);

            } catch (Exception e) {
                log().error(getClass(), "Failed to read config property " + prop.getName() + " in " + feature.name());
            }
        });

        return properties;
    }

    private void trySetProp(Field prop, Object val) {
        try {
            prop.set(null, val);
        } catch (IllegalAccessException e) {
            log().error(getClass(), e.getMessage());
        }
    }

    private Object tryGetDefault(Field prop) {
        return CharmonyConfig.
            getDefaultFieldValues()
            .getOrDefault(prop, null);
    }

    private SubCategoryBuilder startSubcategory(ConfigBuilder builder, String name, String description) {
        var subcategory = builder.entryBuilder().startSubCategory(Component.literal(name));
        subcategory.add(builder.entryBuilder()
            .startTextDescription(Component.literal(description))
            .build());

        return subcategory;
    }
}
