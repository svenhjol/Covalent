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

public class Atmospheric extends MesonModule {

    public static VariantBarrelBlock ROSEWOOD_BARREL;
    public static CrateBlock ROSEWOOD_CRATE;
    public static BookcaseBlock ROSEWOOD_BOOKCASE;

    public static VariantBarrelBlock YUCCA_BARREL;
    public static CrateBlock YUCCA_CRATE;
    public static BookcaseBlock YUCCA_BOOKCASE;

    @Module(description = "Adds barrels, crates and bookcases for Atmospheric.")
    public Atmospheric() {}

    @Override
    public void init() {
        IStorageMaterial rosewood = ExtraStorageMaterial.ROSEWOOD;
        IStorageMaterial yucca = ExtraStorageMaterial.YUCCA;

        ROSEWOOD_BARREL = new VariantBarrelBlock(this, rosewood);
        ROSEWOOD_CRATE = new CrateBlock(this, rosewood);
        ROSEWOOD_BOOKCASE = new BookcaseBlock(this, rosewood);

        YUCCA_BARREL = new VariantBarrelBlock(this, yucca);
        YUCCA_CRATE = new CrateBlock(this, yucca);
        YUCCA_BOOKCASE = new BookcaseBlock(this, yucca);
    }

    @Override
    public boolean test() {
        return Meson.enabled("charm:variant_barrels")
            && ModHelper.present("atmospheric");
    }
}
