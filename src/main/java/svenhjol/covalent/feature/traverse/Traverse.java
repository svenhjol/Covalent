package svenhjol.covalent.feature.traverse;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.covalent.feature.variant_wood.VariantWood;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;

import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.traverse.TraverseMaterials.Fir;

public class Traverse extends CommonFeature {
    public static final String MOD_ID = "traverse";
    static final Fir FIR = new Fir();

    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for Traverse woods.";
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

        CharmonyApi.registerProvider(this);
        CharmonyApi.registerProvider(new TraverseDataProvider());
    }
}