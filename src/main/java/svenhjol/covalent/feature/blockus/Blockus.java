package svenhjol.covalent.feature.blockus;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;
import svenhjol.covalent.feature.variant_wood.VariantWood;

import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.blockus.BlockusMaterials.*;

public class Blockus extends CommonFeature {
    public static final String MOD_ID = "blockus";
    static final Charred CHARRED = new Charred();
    static final Legacy LEGACY = new Legacy();
    static final RawBamboo RAW_BAMBOO = new RawBamboo();
    static final WhiteOak WHITE_OAK = new WhiteOak();

    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for Blockus woods.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded(MOD_ID));
    }

    @Override
    public void register() {
        var registry = mod().registry();

        CHARRED.blockSetType = registry.blockSetType(CHARRED);
        CHARRED.woodType = registry.woodType(CHARRED.getSerializedName(), CHARRED);

        LEGACY.blockSetType = registry.blockSetType(LEGACY);
        LEGACY.woodType = registry.woodType(LEGACY.getSerializedName(), LEGACY);

        RAW_BAMBOO.blockSetType = registry.blockSetType(RAW_BAMBOO);
        RAW_BAMBOO.woodType = registry.woodType(RAW_BAMBOO.getSerializedName(), RAW_BAMBOO);

        WHITE_OAK.blockSetType = registry.blockSetType(WHITE_OAK);
        WHITE_OAK.woodType = registry.woodType(WHITE_OAK.getSerializedName(), WHITE_OAK);

        VariantWood.registerWood(CHARRED);
        VariantWood.registerWood(LEGACY);
        VariantWood.registerWood(RAW_BAMBOO);
        VariantWood.registerWood(WHITE_OAK);

        CharmonyApi.registerProvider(new BlockusDataProvider());
    }
}
