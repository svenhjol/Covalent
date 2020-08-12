package svenhjol.covalent.modules;

import svenhjol.charm.block.BookcaseBlock;
import svenhjol.charm.block.CrateBlock;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.covalent.base.ExtraStorageMaterial;
import svenhjol.meson.Meson;
import svenhjol.meson.MesonModule;
import svenhjol.meson.enums.IStorageMaterial;
import svenhjol.meson.helper.ModHelper;
import svenhjol.meson.iface.Module;

public class Swampexpansion extends MesonModule {

    public static VariantBarrelBlock WILLOW_BARREL;
    public static CrateBlock WILLOW_CRATE;
    public static BookcaseBlock WILLOW_BOOKCASE;

    @Module(description = "Adds barrels, crates and bookcases for Swamp Expansion.")
    public Swampexpansion() {}

    @Override
    public void init() {
        IStorageMaterial willow = ExtraStorageMaterial.WILLOW;

        WILLOW_BARREL = new VariantBarrelBlock(this, willow);
        WILLOW_CRATE = new CrateBlock(this, willow);
        WILLOW_BOOKCASE = new BookcaseBlock(this, willow);
    }

    @Override
    public boolean depends() {
        return ModHelper.present("swampexpansion");
    }
}
