package svenhjol.covalent.biomesoplenty;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.BookcaseBlock;
import svenhjol.charm.block.CrateBlock;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.covalent.Covalent;

@Module(mod = Covalent.MOD_ID, description = "Biomes O Plenty integration")
public class Biomesoplenty extends CharmModule {

    public static VariantBarrelBlock CHERRY_BARREL;
    public static BookcaseBlock CHERRY_BOOKCASE;
    public static CrateBlock CHERRY_CRATE;

    public static VariantBarrelBlock DEAD_BARREL;
    public static BookcaseBlock DEAD_BOOKCASE;
    public static CrateBlock DEAD_CRATE;

    public static VariantBarrelBlock FIR_BARREL;
    public static BookcaseBlock FIR_BOOKCASE;
    public static CrateBlock FIR_CRATE;

    public static VariantBarrelBlock HELLBARK_BARREL;
    public static BookcaseBlock HELLBARK_BOOKCASE;
    public static CrateBlock HELLBARK_CRATE;

    public static VariantBarrelBlock JACARANDA_BARREL;
    public static BookcaseBlock JACARANDA_BOOKCASE;
    public static CrateBlock JACARANDA_CRATE;

    public static VariantBarrelBlock MAGIC_BARREL;
    public static BookcaseBlock MAGIC_BOOKCASE;
    public static CrateBlock MAGIC_CRATE;

    public static VariantBarrelBlock MAHOGANY_BARREL;
    public static BookcaseBlock MAHOGANY_BOOKCASE;
    public static CrateBlock MAHOGANY_CRATE;

    public static VariantBarrelBlock PALM_BARREL;
    public static BookcaseBlock PALM_BOOKCASE;
    public static CrateBlock PALM_CRATE;

    public static VariantBarrelBlock REDWOOD_BARREL;
    public static BookcaseBlock REDWOOD_BOOKCASE;
    public static CrateBlock REDWOOD_CRATE;

    public static VariantBarrelBlock UMBRAN_BARREL;
    public static BookcaseBlock UMBRAN_BOOKCASE;
    public static CrateBlock UMBRAN_CRATE;

    public static VariantBarrelBlock WILLOW_BARREL;
    public static BookcaseBlock WILLOW_BOOKCASE;
    public static CrateBlock WILLOW_CRATE;

    @Override
    public void register() {
        IVariantMaterial cherry = BiomesoplentyMaterial.CHERRY;
        IVariantMaterial dead = BiomesoplentyMaterial.DEAD;
        IVariantMaterial fir = BiomesoplentyMaterial.FIR;
        IVariantMaterial hellbark = BiomesoplentyMaterial.HELLBARK;
        IVariantMaterial jacaranda = BiomesoplentyMaterial.JACARANDA;
        IVariantMaterial magic = BiomesoplentyMaterial.MAGIC;
        IVariantMaterial mahogany = BiomesoplentyMaterial.MAHOGANY;
        IVariantMaterial palm = BiomesoplentyMaterial.PALM;
        IVariantMaterial redwood = BiomesoplentyMaterial.REDWOOD;
        IVariantMaterial umbran = BiomesoplentyMaterial.UMBRAN;
        IVariantMaterial willow = BiomesoplentyMaterial.WILLOW;

        CHERRY_BARREL = new VariantBarrelBlock(this, cherry);
        CHERRY_BOOKCASE = new BookcaseBlock(this, cherry);
        CHERRY_CRATE = new CrateBlock(this, cherry);

        DEAD_BARREL = new VariantBarrelBlock(this, dead);
        DEAD_BOOKCASE = new BookcaseBlock(this, dead);
        DEAD_CRATE = new CrateBlock(this, dead);

        FIR_BARREL = new VariantBarrelBlock(this, fir);
        FIR_BOOKCASE = new BookcaseBlock(this, fir);
        FIR_CRATE = new CrateBlock(this, fir);

        HELLBARK_BARREL = new VariantBarrelBlock(this, hellbark);
        HELLBARK_BOOKCASE = new BookcaseBlock(this, hellbark);
        HELLBARK_CRATE = new CrateBlock(this, hellbark);

        JACARANDA_BARREL = new VariantBarrelBlock(this, jacaranda);
        JACARANDA_BOOKCASE = new BookcaseBlock(this, jacaranda);
        JACARANDA_CRATE = new CrateBlock(this, jacaranda);

        MAGIC_BARREL = new VariantBarrelBlock(this, magic);
        MAGIC_BOOKCASE = new BookcaseBlock(this, magic);
        MAGIC_CRATE = new CrateBlock(this,magic);

        MAHOGANY_BARREL = new VariantBarrelBlock(this, mahogany);
        MAHOGANY_BOOKCASE = new BookcaseBlock(this, mahogany);
        MAHOGANY_CRATE = new CrateBlock(this, mahogany);

        PALM_BARREL = new VariantBarrelBlock(this, palm);
        PALM_BOOKCASE = new BookcaseBlock(this, palm);
        PALM_CRATE = new CrateBlock(this, palm);

        REDWOOD_BARREL = new VariantBarrelBlock(this, redwood);
        REDWOOD_BOOKCASE = new BookcaseBlock(this, redwood);
        REDWOOD_CRATE = new CrateBlock(this, redwood);

        UMBRAN_BARREL = new VariantBarrelBlock(this, umbran);
        UMBRAN_BOOKCASE = new BookcaseBlock(this, umbran);
        UMBRAN_CRATE = new CrateBlock(this, umbran);

        WILLOW_BARREL = new VariantBarrelBlock(this, willow);
        WILLOW_BOOKCASE = new BookcaseBlock(this, willow);
        WILLOW_CRATE = new CrateBlock(this, willow);

    }

    @Override
    public boolean depends() {
        return ModHelper.isLoaded("biomesoplenty");
    }
}
