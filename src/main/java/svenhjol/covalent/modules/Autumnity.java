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

public class Autumnity extends MesonModule {

    public static VariantBarrelBlock MAPLE_BARREL;
    public static CrateBlock MAPLE_CRATE;
    public static BookcaseBlock MAPLE_BOOKCASE;

    @Module(description = "Adds barrels, crates and bookcases for Autumnity.")
    public Autumnity() {}

    @Override
    public void init() {
        IStorageMaterial maple = ExtraStorageMaterial.MAPLE;

        MAPLE_BARREL = new VariantBarrelBlock(this, maple);
        MAPLE_CRATE = new CrateBlock(this, maple);
        MAPLE_BOOKCASE = new BookcaseBlock(this, maple);
    }

    @Override
    public boolean test() {
        return Meson.enabled("charm:variant_barrels")
            && ModHelper.present("autumnity");
    }
}
