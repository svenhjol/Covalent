package svenhjol.covalent.feature.newworld;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;
import svenhjol.covalent.feature.variant_wood.VariantWood;

import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.newworld.NewWorldMaterials.*;

public class NewWorld extends CommonFeature {
    public static final String MOD_ID = "newworld";
    static final Fir FIR = new Fir();
    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for New World woods.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded(MOD_ID));
    }

    @Override
    public void register() {
        var registry = mod().registry();

        FIR.blockSetType = registry.blockSetType(FIR);
        FIR.woodType = registry.woodType(FIR.getSerializedName(), FIR);
        
        VariantWood.registerWood(FIR);

        CharmonyApi.registerProvider(new NewWorldDataProvider());
    }
}