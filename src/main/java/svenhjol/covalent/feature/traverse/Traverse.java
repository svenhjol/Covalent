package svenhjol.covalent.feature.traverse;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;
import svenhjol.charmony_api.iface.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.traverse.TraverseMaterials.*;

public class Traverse extends CommonFeature implements
        IVariantBarrelProvider,
        IVariantBookshelfProvider,
        IVariantChestProvider,
        IVariantChiseledBookshelfProvider,
        IVariantLadderProvider
{
    static final Fir FIR = new Fir();
    static final List<IVariantMaterial> TYPES = new ArrayList<>();

    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for Traverse woods.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded("traverse"));
    }

    @Override
    public void register() {
        // We don't register anything if the mod is missing.
        if (!isEnabled()) return;

        var registry = mod().registry();

        FIR.blockSetType = registry.blockSetType(FIR);
        FIR.woodType = registry.woodType(FIR.getSerializedName(), FIR);

        TYPES.add(FIR);

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