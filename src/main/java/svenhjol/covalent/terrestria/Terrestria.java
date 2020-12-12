package svenhjol.covalent.terrestria;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.BookcaseBlock;
import svenhjol.charm.block.CrateBlock;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.covalent.Covalent;

@Module(mod = Covalent.MOD_ID, description = "Terrestria integration")
public class Terrestria extends CharmModule {

    public static VariantBarrelBlock JAPANESE_MAPLE_BARREL;
    public static BookcaseBlock JAPANESE_MAPLE_BOOKCASE;
    public static CrateBlock JAPANESE_MAPLE_CRATE;

    @Override
    public void register() {
        IVariantMaterial japanese_maple = TerrestriaMaterial.JAPANESE_MAPLE;

        JAPANESE_MAPLE_BARREL = new VariantBarrelBlock(this, japanese_maple);
        JAPANESE_MAPLE_BOOKCASE = new BookcaseBlock(this, japanese_maple);
        JAPANESE_MAPLE_CRATE = new CrateBlock(this, japanese_maple);
    }
    @Override
    public boolean depends() {
        return ModHelper.isLoaded("terrestria");
    }
}
