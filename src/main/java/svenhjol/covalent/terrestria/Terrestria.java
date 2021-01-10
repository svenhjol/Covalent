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

    public static VariantBarrelBlock YUCCA_PALM_BARREL;
    public static BookcaseBlock YUCCA_PALM_BOOKCASE;
    public static CrateBlock YUCCA_PALM_CRATE;

    public static VariantBarrelBlock WILLOW_BARREL;
    public static BookcaseBlock WILLOW_BOOKCASE;
    public static CrateBlock WILLOW_CRATE;

    public static VariantBarrelBlock SAKURA_BARREL;
    public static BookcaseBlock SAKURA_BOOKCASE;
    public static CrateBlock SAKURA_CRATE;

    public static VariantBarrelBlock RUBBER_BARREL;
    public static BookcaseBlock RUBBER_BOOKCASE;
    public static CrateBlock RUBBER_CRATE;

    public static VariantBarrelBlock REDWOOD_BARREL;
    public static BookcaseBlock REDWOOD_BOOKCASE;
    public static CrateBlock REDWOOD_CRATE;

    public static VariantBarrelBlock HEMLOCK_BARREL;
    public static BookcaseBlock HEMLOCK_BOOKCASE;
    public static CrateBlock HEMLOCK_CRATE;

    public static VariantBarrelBlock CYPRESS_BARREL;
    public static BookcaseBlock CYPRESS_BOOKCASE;
    public static CrateBlock CYPRESS_CRATE;

    public static VariantBarrelBlock RAINBOW_EUCALYPTUS_BARREL;
    public static BookcaseBlock RAINBOW_EUCALYPTUS_BOOKCASE;
    public static CrateBlock RAINBOW_EUCALYPTUS_CRATE;

    @Override
    public void register() {
        IVariantMaterial japanese_maple = TerrestriaMaterial.JAPANESE_MAPLE;
        IVariantMaterial yucca_palm = TerrestriaMaterial.YUCCA_PALM;
        IVariantMaterial willow = TerrestriaMaterial.WILLOW;
        IVariantMaterial sakura = TerrestriaMaterial.SAKURA;
        IVariantMaterial rubber = TerrestriaMaterial.RUBBER;
        IVariantMaterial redwood = TerrestriaMaterial.REDWOOD;
        IVariantMaterial rainbow_eucalyptus = TerrestriaMaterial.RAINBOW_EUCALYPTUS;
        IVariantMaterial hemlock = TerrestriaMaterial.HEMLOCK;
        IVariantMaterial cypress = TerrestriaMaterial.CYPRESS;

        JAPANESE_MAPLE_BARREL = new VariantBarrelBlock(this, japanese_maple);
        JAPANESE_MAPLE_BOOKCASE = new BookcaseBlock(this, japanese_maple);
        JAPANESE_MAPLE_CRATE = new CrateBlock(this, japanese_maple);

        YUCCA_PALM_BARREL = new VariantBarrelBlock(this, yucca_palm);
        YUCCA_PALM_BOOKCASE = new BookcaseBlock(this, yucca_palm);
        YUCCA_PALM_CRATE = new CrateBlock(this, yucca_palm);

        WILLOW_BARREL = new VariantBarrelBlock(this, willow);
        WILLOW_BOOKCASE = new BookcaseBlock(this, willow);
        WILLOW_CRATE = new CrateBlock(this, willow);

        SAKURA_BARREL = new VariantBarrelBlock(this, sakura);
        SAKURA_BOOKCASE = new BookcaseBlock(this, sakura);
        SAKURA_CRATE = new CrateBlock(this, sakura);

        RUBBER_BARREL = new VariantBarrelBlock(this, rubber);
        RUBBER_BOOKCASE = new BookcaseBlock(this, rubber);
        RUBBER_CRATE = new CrateBlock(this, rubber);

        REDWOOD_BARREL = new VariantBarrelBlock(this, redwood);
        REDWOOD_BOOKCASE = new BookcaseBlock(this, redwood);
        REDWOOD_CRATE = new CrateBlock(this, redwood);

        RAINBOW_EUCALYPTUS_BARREL = new VariantBarrelBlock(this, rainbow_eucalyptus);
        RAINBOW_EUCALYPTUS_BOOKCASE = new BookcaseBlock(this, rainbow_eucalyptus);
        RAINBOW_EUCALYPTUS_CRATE = new CrateBlock(this, rainbow_eucalyptus);

        HEMLOCK_BARREL = new VariantBarrelBlock(this, hemlock);
        HEMLOCK_BOOKCASE = new BookcaseBlock(this, hemlock);
        HEMLOCK_CRATE = new CrateBlock(this, hemlock);

        CYPRESS_BARREL = new VariantBarrelBlock(this, cypress);
        CYPRESS_BOOKCASE = new BookcaseBlock(this, cypress);
        CYPRESS_CRATE = new CrateBlock(this, cypress);

    }
    @Override
    public boolean depends() {return ModHelper.isLoaded("terrestria");
    }
}
