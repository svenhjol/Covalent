package svenhjol.covalent.feature.variant_wood;

import svenhjol.charmony.base.Mods;
import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony_api.iface.IVariantWoodMaterial;
import svenhjol.covalent.Covalent;

public class VariantWood extends CommonFeature {
    @Override
    public boolean canBeDisabled() {
        return false;
    }

    @Override
    public int priority() {
        return 10;
    }

    @Override
    public void register() {
        var variantWoodEnabled = Mods.optionalCommon(Covalent.CHARMONY_ID).map(
            charmony -> charmony.loader().isEnabled("VariantWood")).orElse(false);

        setEnabled(variantWoodEnabled);
    }

    /**
     * This is just a passthrough to Charmony's VariantWood so that features don't need to pass a registry reference.
     */
    public static void registerWood(IVariantWoodMaterial material) {
        var registry = Mods.common(Covalent.ID).registry();
        svenhjol.charmony.feature.variant_wood.VariantWood.registerWood(registry, material);
    }
}
