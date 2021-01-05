package svenhjol.covalent.wild_explorer;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.BookcaseBlock;
import svenhjol.charm.block.CrateBlock;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.covalent.Covalent;

@Module(mod = Covalent.MOD_ID, description = "WildExplorer integration")
public class WildExplorer extends CharmModule {

    public static VariantBarrelBlock CHERRY_OAK_BARREL;
    public static BookcaseBlock CHERRY_OAK_BOOKCASE;
    public static CrateBlock CHERRY_OAK_CRATE;

    public static VariantBarrelBlock PALM_BARREL;
    public static BookcaseBlock PALM_BOOKCASE;
    public static CrateBlock PALM_CRATE;

    public static VariantBarrelBlock DARK_AMARANTH_BARREL;
    public static BookcaseBlock DARK_AMARANTH_BOOKCASE;
    public static CrateBlock DARK_AMARANTH_CRATE;
    @Override
    public void register() {
        IVariantMaterial cherry_oak = WildExplorerMaterial.CHERRY_OAK;
        IVariantMaterial palm = WildExplorerMaterial.PALM;
        IVariantMaterial dark_amaranth = WildExplorerMaterial.DARK_AMARANTH;

        CHERRY_OAK_BARREL = new VariantBarrelBlock(this, cherry_oak);
        CHERRY_OAK_BOOKCASE = new BookcaseBlock(this, cherry_oak);
        CHERRY_OAK_CRATE = new CrateBlock(this, cherry_oak);

        PALM_BARREL = new VariantBarrelBlock(this, palm);
        PALM_BOOKCASE = new BookcaseBlock(this, palm);
        PALM_CRATE = new CrateBlock(this, palm);

        DARK_AMARANTH_BARREL = new VariantBarrelBlock(this, dark_amaranth);
        DARK_AMARANTH_BOOKCASE = new BookcaseBlock(this, dark_amaranth);
        DARK_AMARANTH_CRATE = new CrateBlock(this, dark_amaranth);
    }
    @Override
    public boolean depends() {
        return ModHelper.isLoaded("wild_explorer");
    }
}
