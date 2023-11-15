package svenhjol.covalent.feature.terrestria;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.covalent.feature.variant_wood.VariantWood;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;

import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.terrestria.TerrestriaMaterials.*;

public class Terrestria extends CommonFeature {
    public static final String MOD_ID = "terrestria";
    static final Cypress CYPRESS = new Cypress();
    static final Hemlock HEMLOCK = new Hemlock();
    static final JapaneseMaple JAPANESE_MAPLE = new JapaneseMaple();
    static final RainbowEucalyptus RAINBOW_EUCALYPTUS = new RainbowEucalyptus();
    static final Redwood REDWOOD = new Redwood();
    static final Rubber RUBBER = new Rubber();
    static final Sakura SAKURA = new Sakura();
    static final Willow WILLOW = new Willow();
    static final YuccaPalm YUCCA_PALM = new YuccaPalm();

    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for Terrestria woods.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded(MOD_ID));
    }

    @Override
    public void register() {
        var registry = mod().registry();

        CYPRESS.blockSetType = registry.blockSetType(CYPRESS);
        CYPRESS.woodType = registry.woodType(CYPRESS.getSerializedName(), CYPRESS);

        HEMLOCK.blockSetType = registry.blockSetType(HEMLOCK);
        HEMLOCK.woodType = registry.woodType(HEMLOCK.getSerializedName(), HEMLOCK);

        JAPANESE_MAPLE.blockSetType = registry.blockSetType(JAPANESE_MAPLE);
        JAPANESE_MAPLE.woodType = registry.woodType(JAPANESE_MAPLE.getSerializedName(), JAPANESE_MAPLE);

        RAINBOW_EUCALYPTUS.blockSetType = registry.blockSetType(RAINBOW_EUCALYPTUS);
        RAINBOW_EUCALYPTUS.woodType = registry.woodType(RAINBOW_EUCALYPTUS.getSerializedName(), RAINBOW_EUCALYPTUS);

        REDWOOD.blockSetType = registry.blockSetType(REDWOOD);
        REDWOOD.woodType = registry.woodType(REDWOOD.getSerializedName(), REDWOOD);

        RUBBER.blockSetType = registry.blockSetType(RUBBER);
        RUBBER.woodType = registry.woodType(RUBBER.getSerializedName(), RUBBER);

        SAKURA.blockSetType = registry.blockSetType(SAKURA);
        SAKURA.woodType = registry.woodType(SAKURA.getSerializedName(), SAKURA);

        WILLOW.blockSetType = registry.blockSetType(WILLOW);
        WILLOW.woodType = registry.woodType(WILLOW.getSerializedName(), WILLOW);

        YUCCA_PALM.blockSetType = registry.blockSetType(YUCCA_PALM);
        YUCCA_PALM.woodType = registry.woodType(YUCCA_PALM.getSerializedName(), YUCCA_PALM);

        VariantWood.registerWood(CYPRESS);
        VariantWood.registerWood(HEMLOCK);
        VariantWood.registerWood(JAPANESE_MAPLE);
        VariantWood.registerWood(RAINBOW_EUCALYPTUS);
        VariantWood.registerWood(REDWOOD);
        VariantWood.registerWood(RUBBER);
        VariantWood.registerWood(SAKURA);
        VariantWood.registerWood(WILLOW);
        VariantWood.registerWood(YUCCA_PALM);

        CharmonyApi.registerProvider(new TerrestriaDataProvider());
    }
}