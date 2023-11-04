package svenhjol.covalent.feature.wilderwild;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;
import svenhjol.charmony_api.iface.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.wilderwild.WilderWildMaterials.*;

public class WilderWild extends CommonFeature implements
        IVariantBarrelProvider,
        IVariantBookshelfProvider,
        IVariantChestProvider,
        IVariantChiseledBookshelfProvider,
        IVariantLadderProvider
{   
    static final Baobab BAOBAB = new Baobab();
    static final Cypress CYPRESS = new Cypress();
    static final Palm PALM = new Palm();
    static final List<IVariantMaterial> TYPES = new ArrayList<>();

    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for Wilder Wild woods.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded("WilderWild"));
    }

    @Override
    public void register() {
        // We don't register anything if the mod is missing.
        if (!isEnabled()) return;

        var registry = mod().registry();

        BAOBAB.blockSetType = registry.blockSetType(BAOBAB);
        BAOBAB.woodType = registry.woodType(BAOBAB.getSerializedName(), BAOBAB);

        CYPRESS.blockSetType = registry.blockSetType(CYPRESS);
        CYPRESS.woodType = registry.woodType(CYPRESS.getSerializedName(), CYPRESS);

        PALM.blockSetType = registry.blockSetType(PALM);
        PALM.woodType = registry.woodType(PALM.getSerializedName(), PALM);


        TYPES.addAll(List.of(CYPRESS, PALM, BAOBAB));

        CharmonyApi.registerProvider(this);
    }

    @Override
    public List<IVariantMaterial> getVariantBarrels() {
        return TYPES;
    }

    @Override
    public List<IVariantMaterial> getVariantBookshelves() {
        return TYPES;
    }

    @Override
    public List<IVariantMaterial> getVariantChests() {
        return TYPES;
    }

    @Override
    public List<IVariantMaterial> getVariantChiseledBookshelves() {
        return TYPES;
    }

    @Override
    public List<IVariantMaterial> getVariantLadders() {
        return TYPES;
    }
}