package svenhjol.covalent.decoration.module;

import svenhjol.charm.base.CharmCategories;
import svenhjol.charm.base.module.Debug;
import svenhjol.charm.decoration.block.BookshelfChestBlock;
import svenhjol.charm.decoration.block.CrateOpenBlock;
import svenhjol.charm.decoration.block.CrateSealedBlock;
import svenhjol.charm.decoration.block.CustomBarrelBlock;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.base.ExtraChestMaterialTypes;
import svenhjol.meson.Meson;
import svenhjol.meson.MesonModule;
import svenhjol.meson.enums.IChestMaterialType;
import svenhjol.meson.helper.ForgeHelper;
import svenhjol.meson.iface.Module;

@Module(mod = Covalent.MOD_ID, category = CharmCategories.DECORATION,
    description = "Adds barrels and crates for Atmospheric.")
public class Atmospheric extends MesonModule {
    // rosewood types
    public static CustomBarrelBlock rosewoodBarrelBlock;
    public static CrateOpenBlock rosewoodCrateOpenBlock;
    public static CrateSealedBlock rosewoodCrateSealedBlock;
    public static BookshelfChestBlock rosewoodBookshelfChestBlock;

    // yucca types
    public static CustomBarrelBlock yuccaBarrelBlock;
    public static CrateOpenBlock yuccaCrateOpenBlock;
    public static CrateSealedBlock yuccaCrateSealedBlock;
    public static BookshelfChestBlock yuccaBookshelfChestBlock;

    @Override
    public void init() {
        super.init();
        IChestMaterialType rosewood = ExtraChestMaterialTypes.ROSEWOOD;
        IChestMaterialType yucca = ExtraChestMaterialTypes.YUCCA;

        rosewoodBarrelBlock = new CustomBarrelBlock(this, rosewood);
        rosewoodCrateOpenBlock = new CrateOpenBlock(this, rosewood);
        rosewoodCrateSealedBlock = new CrateSealedBlock(this, rosewood);
        rosewoodBookshelfChestBlock = new BookshelfChestBlock(this, rosewood);

        yuccaBarrelBlock = new CustomBarrelBlock(this, yucca);
        yuccaCrateOpenBlock = new CrateOpenBlock(this, yucca);
        yuccaCrateSealedBlock = new CrateSealedBlock(this, yucca);
        yuccaBookshelfChestBlock = new BookshelfChestBlock(this, yucca);
    }

    @Override
    public boolean shouldRunSetup() {
        return Meson.isModuleEnabled("charm:debug") || ForgeHelper.isModLoaded("atmospheric");
    }
}
