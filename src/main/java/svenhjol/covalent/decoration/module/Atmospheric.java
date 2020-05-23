package svenhjol.covalent.decoration.module;

import svenhjol.charm.base.CharmCategories;
import svenhjol.charm.decoration.block.BookshelfChestBlock;
import svenhjol.charm.decoration.block.CrateOpenBlock;
import svenhjol.charm.decoration.block.CrateSealedBlock;
import svenhjol.charm.decoration.block.CustomBarrelBlock;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.base.ExtraWoodTypes;
import svenhjol.meson.MesonModule;
import svenhjol.meson.enums.IWoodType;
import svenhjol.meson.helper.ForgeHelper;
import svenhjol.meson.iface.Module;

@Module(mod = Covalent.MOD_ID, category = CharmCategories.DECORATION,
    description = "Adds barrels and crates for Atmospheric.")
public class Atmospheric extends MesonModule {
    public static CustomBarrelBlock barrelBlock;
    public static CrateOpenBlock crateOpenBlock;
    public static CrateSealedBlock crateSealedBlock;
    public static BookshelfChestBlock bookshelfChestBlock;

    @Override
    public void init() {
        super.init();
        IWoodType wood = ExtraWoodTypes.ROSEWOOD;

        barrelBlock = new CustomBarrelBlock(this, wood);
        crateOpenBlock = new CrateOpenBlock(this, wood);
        crateSealedBlock = new CrateSealedBlock(this, wood);
        bookshelfChestBlock = new BookshelfChestBlock(this, wood);
    }

    @Override
    public boolean shouldRunSetup() {
        return ForgeHelper.isModLoaded("atmospheric");
    }
}
