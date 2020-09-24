package svenhjol.covalent.module;

import net.minecraft.util.Identifier;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.BambooBlock;
import svenhjol.covalent.block.EggBlock;
import svenhjol.covalent.block.RottenFleshBlock;
import svenhjol.covalent.block.WheatSeedBlock;
import svenhjol.covalent.block.CyanDyeBlock;
import svenhjol.meson.MesonModule;
import svenhjol.meson.block.MesonBlock;
import svenhjol.meson.iface.Config;
import svenhjol.meson.iface.Module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Module(description = "Adds storage blocks.")
public class StorageBlocks extends MesonModule {
    public static WheatSeedBlock WHEAT_SEED_BLOCK;
    public static RottenFleshBlock ROTTEN_FLESH_BLOCK;
    public static BambooBlock BAMBOO_BLOCK;
    public static EggBlock EGG_BLOCK;
    public static CyanDyeBlock CYAN_DYE_BLOCK;

    public static List<MesonBlock> STORAGE_BLOCKS = new ArrayList<>();

    @Config(name = "Wheat seed sack")
    public static boolean wheatSeeds = true;

    @Config(name = "Rotten Flesh bundle")
    public static boolean rottenflesh = true;

    @Config(name = "Bamboo bundle")
    public static boolean bamboo = true;

    @Config(name = "Egg crate")
    public static boolean egg = true;

    @Config(name = "Jar of Cyan Dye")
    public static boolean cyanDye = true;

    @Override
    public void register() {
        WHEAT_SEED_BLOCK = new WheatSeedBlock(this);
        ROTTEN_FLESH_BLOCK = new RottenFleshBlock(this);
        BAMBOO_BLOCK = new BambooBlock(this);
        EGG_BLOCK = new EggBlock(this);
        CYAN_DYE_BLOCK = new CyanDyeBlock(this);

        STORAGE_BLOCKS.addAll(Arrays.asList(
            WHEAT_SEED_BLOCK,
            ROTTEN_FLESH_BLOCK,
            CYAN_DYE_BLOCK,
            BAMBOO_BLOCK,
            EGG_BLOCK
        ));
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> recipes = new ArrayList<>();
        if (!wheatSeeds) {
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/wheat_seed_block_from_wheat_seeds"));
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/wheat_seeds_from_wheat_seed_block"));
        }

        if (!rottenflesh) {
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/rotten_flesh_block_from_rotten_flesh"));
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/rotten_flesh_from_rotten_flesh_block"));
        }

        if (!bamboo) {
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/bamboo_block_from_bamboo"));
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/bamboo_from_bamboo_block"));
        }

        if (!egg) {
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/egg_block_from_egg"));
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/eggs_from_egg_block"));
        }

        if (!cyanDye) {
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/cyan_dye_block_from_cyan_dye"));
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/cyan_dye_from_cyan_dye_block"));
        }

        return recipes;
    }
}
