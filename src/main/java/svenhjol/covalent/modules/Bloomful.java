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

public class Bloomful extends MesonModule {

    public static VariantBarrelBlock BLOOMFUL_BARREL;
    public static CrateBlock BLOOMFUL_CRATE;
    public static BookcaseBlock BLOOMFUL_BOOKCASE;

    @Module(description = "Adds barrels, crates and bookcases for Bloomful.")
    public Bloomful() {}

    @Override
    public void init() {
        IStorageMaterial wisteria = ExtraStorageMaterial.WISTERIA;

        BLOOMFUL_BARREL = new VariantBarrelBlock(this, wisteria);
        BLOOMFUL_CRATE = new CrateBlock(this, wisteria);
        BLOOMFUL_BOOKCASE = new BookcaseBlock(this, wisteria);
    }

    @Override
    public boolean test() {
        return Meson.enabled("charm:variant_barrels")
            && ModHelper.present("bloomful");
    }
}
