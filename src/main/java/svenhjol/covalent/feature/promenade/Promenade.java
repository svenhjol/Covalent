package svenhjol.covalent.feature.promenade;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;
import svenhjol.covalent.feature.variant_wood.VariantWood;

import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.promenade.PromenadeMaterials.*;

public class Promenade extends CommonFeature {
    public static final String MOD_ID = "promenade";
    static final DarkAmaranth DARK_AMARANTH = new DarkAmaranth();
    static final Maple MAPLE = new Maple();
    static final Palm PALM = new Palm();
    static final Sakura SAKURA = new Sakura();

    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for Promenade woods.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded(MOD_ID));
    }

    @Override
    public void register() {
        var registry = mod().registry();

        DARK_AMARANTH.blockSetType = registry.blockSetType(DARK_AMARANTH);
        DARK_AMARANTH.woodType = registry.woodType(DARK_AMARANTH.getSerializedName(), DARK_AMARANTH);

        MAPLE.blockSetType = registry.blockSetType(MAPLE);
        MAPLE.woodType = registry.woodType(MAPLE.getSerializedName(), MAPLE);

        PALM.blockSetType = registry.blockSetType(PALM);
        PALM.woodType = registry.woodType(PALM.getSerializedName(), PALM);

        SAKURA.blockSetType = registry.blockSetType(SAKURA);
        SAKURA.woodType = registry.woodType(SAKURA.getSerializedName(), SAKURA);

        VariantWood.registerWood(DARK_AMARANTH);
        VariantWood.registerWood(MAPLE);
        VariantWood.registerWood(PALM);
        VariantWood.registerWood(SAKURA);

        CharmonyApi.registerProvider(new PromenadeDataProvider());
    }
}
