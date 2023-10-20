package svenhjol.covalent.feature.promenade;

import svenhjol.charmony.annotation.Feature;
import svenhjol.charmony.base.CharmonyFeature;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;
import svenhjol.charmony_api.iface.*;
import svenhjol.covalent.Covalent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.promenade.PromenadeMaterials.*;

@Feature(mod = Covalent.MOD_ID, description = "Adds chests, barrels, bookshelves and ladders for Promenade woods.")
public class Promenade extends CharmonyFeature implements
    IVariantBarrelProvider,
    IVariantBookshelfProvider,
    IVariantChestProvider,
    IVariantChiseledBookshelfProvider,
    IVariantLadderProvider
{
    static final DarkAmaranth DARK_AMARANTH = new DarkAmaranth();
    static final Maple MAPLE = new Maple();
    static final Palm PALM = new Palm();
    static final Sakura SAKURA = new Sakura();
    static final List<IVariantMaterial> TYPES = new ArrayList<>();

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded("promenade"));
    }

    @Override
    public void register() {
        // We don't register anything if the mod is missing.
        if (!isEnabled()) return;

        var registry = Covalent.instance().registry();

        DARK_AMARANTH.blockSetType = registry.blockSetType(DARK_AMARANTH);
        DARK_AMARANTH.woodType = registry.woodType(DARK_AMARANTH.getSerializedName(), DARK_AMARANTH);

        MAPLE.blockSetType = registry.blockSetType(MAPLE);
        MAPLE.woodType = registry.woodType(MAPLE.getSerializedName(), MAPLE);

        PALM.blockSetType = registry.blockSetType(PALM);
        PALM.woodType = registry.woodType(PALM.getSerializedName(), PALM);

        SAKURA.blockSetType = registry.blockSetType(SAKURA);
        SAKURA.woodType = registry.woodType(SAKURA.getSerializedName(), SAKURA);

        TYPES.addAll(List.of(DARK_AMARANTH, MAPLE, PALM, SAKURA));

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
