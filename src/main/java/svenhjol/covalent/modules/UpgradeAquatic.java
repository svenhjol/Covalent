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

public class UpgradeAquatic extends MesonModule {

    public static VariantBarrelBlock DRIFTWOOD_BARREL;
    public static CrateBlock DRIFTWOOD_CRATE;
    public static BookcaseBlock DRIFTWOOD_BOOKCASE;

    @Module(description = "Adds barrels, crates and bookcases for Upgrade Aquatic.")
    public UpgradeAquatic() {}

    @Override
    public void init() {
        IStorageMaterial willow = ExtraStorageMaterial.DRIFTWOOD;

        DRIFTWOOD_BARREL = new VariantBarrelBlock(this, willow);
        DRIFTWOOD_CRATE = new CrateBlock(this, willow);
        DRIFTWOOD_BOOKCASE = new BookcaseBlock(this, willow);
    }

    @Override
    public boolean depends() {
        return ModHelper.present("upgrade_aquatic");
    }
}
