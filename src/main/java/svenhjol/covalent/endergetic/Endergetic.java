package svenhjol.covalent.endergetic;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.covalent.Covalent;

@Module(mod = Covalent.MOD_ID, description = "Endergetic Expansion integration")
public class Endergetic extends CharmModule {
    public static VariantBarrelBlock POISE_BARREL;

    @Override
    public void register() {
        IVariantMaterial poise = EndergeticMaterial.POISE;

        POISE_BARREL = new VariantBarrelBlock(this, poise);
    }

    @Override
    public boolean depends() {
        return ModHelper.isLoaded("endergetic");
    }
}
