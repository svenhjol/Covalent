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

public class Endergetic extends MesonModule {

    public static VariantBarrelBlock POISE_BARREL;
    public static CrateBlock POISE_CRATE;
    public static BookcaseBlock POISE_BOOKCASE;

    @Module(description = "Adds barrels, crates and bookcases for Endergetic Expansion.")
    public Endergetic() {}

    @Override
    public void init() {
        IStorageMaterial poise = ExtraStorageMaterial.POISE;

        POISE_BARREL = new VariantBarrelBlock(this, poise);
        POISE_CRATE = new CrateBlock(this, poise);
        POISE_BOOKCASE = new BookcaseBlock(this, poise);
    }

    @Override
    public boolean test() {
        return Meson.enabled("charm:variant_barrels")
            && ModHelper.present("endergetic");
    }
}
