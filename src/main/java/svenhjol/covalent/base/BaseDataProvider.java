package svenhjol.covalent.base;

import svenhjol.charmony.base.Mods;
import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.common.CommonLoader;
import svenhjol.charmony_api.iface.*;
import svenhjol.covalent.Covalent;

import java.util.List;
import java.util.Map;

public abstract class BaseDataProvider implements
    IConditionalRecipeProvider,
    IConditionalAdvancementProvider,
    IConditionalTagProvider
{
    protected abstract Class<? extends CommonFeature> featureClass();

    protected abstract String featurePrefix();

    @Override
    public List<IConditionalAdvancement> getAdvancementConditions() {
        return List.of(
            new IConditionalAdvancement() {
                @Override
                public boolean test() {
                    return loader().isEnabled(featureClass());
                }

                @Override
                public List<String> advancements() {
                    return List.of(
                        "variant_wood/*" + featurePrefix() + "_*"
                    );
                }
            }
        );
    }

    @Override
    public List<IConditionalRecipe> getRecipeConditions() {
        return List.of(
            new IConditionalRecipe() {
                @Override
                public boolean test() {
                    return loader().isEnabled(featureClass());
                }

                @Override
                public List<String> recipes() {
                    return List.of(
                        "variant_wood/*" + featurePrefix() + "_*"
                    );
                }
            }
        );
    }

    @Override
    public List<IConditionalTag> getTagConditions() {
        return List.of(
            new IConditionalTag() {
                @Override
                public boolean test() {
                    return loader().isEnabled(featureClass());
                }

                @Override
                public Map<String, List<String>> resources() {
                    var prefix = featurePrefix();

                    return Map.of(
                        "charm:tags/blocks/chests/normal", List.of("*" + prefix + "_*"),
                        "charm:tags/blocks/chests/trapped", List.of("*" + prefix + "_*"),
                        "charm:tags/blocks/chests/wooden", List.of("*" + prefix + "_*"),
                        "charm:tags/blocks/barrels", List.of("*" + prefix + "_*"),
                        "charm:tags/blocks/bookshelves", List.of("*" + prefix + "_*"),
                        "charm:tags/blocks/chiseled_bookshelves", List.of("*" + prefix + "_*"),
                        "charm:tags/blocks/ladders", List.of("*" + prefix + "_*")
                    );
                }
            }
        );
    }

    protected static CommonLoader loader() {
        return Mods.common(Covalent.ID).loader();
    }
}
