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

public class BambooBlocks extends MesonModule {

    public static VariantBarrelBlock BAMBOO_BARREL;
    public static CrateBlock BAMBOO_CRATE;
    public static BookcaseBlock BAMBOO_BOOKCASE;

    @Module(description = "Adds barrels, crates and bookcases for Bamboo Blocks.")
    public BambooBlocks() {}

    @Override
    public void init() {
        IStorageMaterial bamboo = ExtraStorageMaterial.BAMBOO;

        BAMBOO_BARREL = new VariantBarrelBlock(this, bamboo);
        BAMBOO_CRATE = new CrateBlock(this, bamboo);
        BAMBOO_BOOKCASE = new BookcaseBlock(this, bamboo);
    }

    @Override
    public boolean test() {
        return Meson.enabled("charm:variant_barrels")
            && ModHelper.present("bamboo_blocks");
    }
}
