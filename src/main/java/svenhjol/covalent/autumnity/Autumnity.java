package svenhjol.covalent.autumnity;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.BookcaseBlock;
import svenhjol.charm.block.CrateBlock;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.covalent.Covalent;

@Module(mod = Covalent.MOD_ID, description = "Autumnity integration")
public class Autumnity extends CharmModule {
    public static VariantBarrelBlock MAPLE_BARREL;
    public static BookcaseBlock MAPLE_BOOKCASE;
    public static CrateBlock MAPLE_CRATE;

    @Override
    public void register() {
        IVariantMaterial maple = AutumnityMaterial.MAPLE;

        MAPLE_BARREL = new VariantBarrelBlock(this, maple);
        MAPLE_BOOKCASE = new BookcaseBlock(this, maple);
        MAPLE_CRATE = new CrateBlock(this, maple);
    }

    @Override
    public boolean depends() {
        return ModHelper.isLoaded("autumnity");
    }
}
