package svenhjol.covalent.atmospheric;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.BookcaseBlock;
import svenhjol.charm.block.CrateBlock;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.covalent.Covalent;

@Module(mod = Covalent.MOD_ID, description = "Atmospheric integration")
public class Atmospheric extends CharmModule {
    public static VariantBarrelBlock ROSEWOOD_BARREL;
    public static BookcaseBlock ROSEWOOD_BOOKCASE;
    public static CrateBlock ROSEWOOD_CRATE;
    public static CrateBlock YUCCA_CRATE;
    public static VariantBarrelBlock YUCCA_BARREL;
    public static BookcaseBlock YUCCA_BOOKCASE;


    @Override
    public void register() {
        IVariantMaterial rosewood = AtmosphericMaterial.ROSEWOOD;
        IVariantMaterial yucca = AtmosphericMaterial.YUCCA;

        ROSEWOOD_BARREL = new VariantBarrelBlock(this, rosewood);
        ROSEWOOD_BOOKCASE = new BookcaseBlock(this, rosewood);
        ROSEWOOD_CRATE = new CrateBlock(this, rosewood);
        YUCCA_CRATE = new CrateBlock(this, yucca);
        YUCCA_BARREL = new VariantBarrelBlock(this, yucca);
        YUCCA_BOOKCASE = new BookcaseBlock(this, yucca);
    }

    @Override
    public boolean depends() {
        return ModHelper.isLoaded("atmospheric");
    }
}
