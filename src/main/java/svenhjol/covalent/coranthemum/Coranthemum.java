package svenhjol.covalent.coranthemum;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.BookcaseBlock;
import svenhjol.charm.block.CrateBlock;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.covalent.Covalent;

@Module(mod = Covalent.MOD_ID, description = "Storage Variants")
public class Coranthemum extends CharmModule {
    public static VariantBarrelBlock PRISMARINE_BARREL;
    public static CrateBlock PRISMARINE_CRATE;
   //public static BookcaseBlock ROSEWOOD_BOOKCASE;

    @Override
    public void register() {
        IVariantMaterial prismarine = CoranthemumMaterial.PRISMARINE;

        PRISMARINE_BARREL = new VariantBarrelBlock(this, prismarine);
        PRISMARINE_CRATE = new CrateBlock(this, prismarine);
     // ROSEWOOD_BOOKCASE = new BookcaseBlock(this, rosewood);
    }

}
