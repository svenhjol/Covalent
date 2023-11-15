package svenhjol.covalent.feature.wilderwild;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;
import svenhjol.covalent.feature.variant_wood.VariantWood;

import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.wilderwild.WilderWildMaterials.*;

public class WilderWild extends CommonFeature {
    public static final String MOD_ID = "wilderwild";
    static final Baobab BAOBAB = new Baobab();
    static final Cypress CYPRESS = new Cypress();
    static final Palm PALM = new Palm();

    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for Wilder Wild woods.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded(MOD_ID));
    }

    @Override
    public void register() {
        var registry = mod().registry();

        BAOBAB.blockSetType = registry.blockSetType(BAOBAB);
        BAOBAB.woodType = registry.woodType(BAOBAB.getSerializedName(), BAOBAB);

        CYPRESS.blockSetType = registry.blockSetType(CYPRESS);
        CYPRESS.woodType = registry.woodType(CYPRESS.getSerializedName(), CYPRESS);

        PALM.blockSetType = registry.blockSetType(PALM);
        PALM.woodType = registry.woodType(PALM.getSerializedName(), PALM);

        VariantWood.registerWood(BAOBAB);
        VariantWood.registerWood(CYPRESS);
        VariantWood.registerWood(PALM);

        CharmonyApi.registerProvider(new WilderWildDataProvider());
    }
}