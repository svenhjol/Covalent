package svenhjol.covalent.feature.variant_wood;

import svenhjol.charmony.base.Mods;
import svenhjol.charmony.common.CommonFeature;
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
}
