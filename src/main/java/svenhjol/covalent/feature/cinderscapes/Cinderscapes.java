package svenhjol.covalent.feature.cinderscapes;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;
import svenhjol.charmony_api.iface.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.cinderscapes.CinderscapesMaterials.*;

public class Cinderscapes extends CommonFeature implements
    IVariantBarrelProvider,
    IVariantBookshelfProvider,
    IVariantChestProvider,
    IVariantChiseledBookshelfProvider,
    IVariantLadderProvider
{
    static final Scorched SCORCHED = new Scorched();
    static final Umbral UMBRAL = new Umbral();
    static final List<IVariantMaterial> TYPES = new ArrayList<>();

    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for Cinderscapes woods.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded("cinderscapes"));
    }

    @Override
    public void register() {
        // We don't register anything if the mod is missing.
        if (!isEnabled()) return;

        var registry = mod().registry();

        SCORCHED.blockSetType = registry.blockSetType(SCORCHED);
        SCORCHED.woodType = registry.woodType(SCORCHED.getSerializedName(), SCORCHED);

        UMBRAL.blockSetType = registry.blockSetType(UMBRAL);
        UMBRAL.woodType = registry.woodType(UMBRAL.getSerializedName(), UMBRAL);


        TYPES.addAll(List.of(SCORCHED, UMBRAL));

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