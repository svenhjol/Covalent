package svenhjol.covalent.feature.wilderwild;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.feature.variant_wood.VariantWood;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;

import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.wilderwild.WilderWildMaterials.*;

public class WilderWild extends CommonFeature {
    static final Baobab BAOBAB = new Baobab();
    static final Cypress CYPRESS = new Cypress();
    static final Palm PALM = new Palm();

    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for Wilder Wild woods.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded("wilderwild"));
    }

    @Override
    public void register() {
        var registry = mod().registry();

        BAOBAB.blockSetType = registry.blockSetType(BAOBAB);
        BAOBAB.woodType = registry.woodType(BAOBAB.getSerializedName(), BAOBAB);
        VariantWood.registerWood(registry, BAOBAB);

        CYPRESS.blockSetType = registry.blockSetType(CYPRESS);
        CYPRESS.woodType = registry.woodType(CYPRESS.getSerializedName(), CYPRESS);
        VariantWood.registerWood(registry, CYPRESS);

        PALM.blockSetType = registry.blockSetType(PALM);
        PALM.woodType = registry.woodType(PALM.getSerializedName(), PALM);
        VariantWood.registerWood(registry, PALM);

        CharmonyApi.registerProvider(new WilderWildDataProvider());
    }
}