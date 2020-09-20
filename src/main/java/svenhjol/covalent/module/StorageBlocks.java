package svenhjol.covalent.module;

import net.minecraft.util.Identifier;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.WheatSeedBlock;
import svenhjol.covalent.block.RottenFleshBlock;
import svenhjol.meson.MesonModule;
import svenhjol.meson.block.MesonBlock;
import svenhjol.meson.iface.Config;
import svenhjol.meson.iface.Module;

import java.util.ArrayList;
import java.util.List;

@Module(description = "Adds storage blocks.")
public class StorageBlocks extends MesonModule {
    public static List<MesonBlock> STORAGE_BLOCKS = new ArrayList<>();

    @Config(name = "Wheat seed sack")
    public static boolean wheatSeeds = true;
    @Config(name = "Rotten Flesh Bundle")
    public static boolean rottenflesh = true;

    @Override
    public void register() {
        STORAGE_BLOCKS.add(new WheatSeedBlock(this));
        STORAGE_BLOCKS.add(new RottenFleshBlock(this));

    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> recipes = new ArrayList<>();
        if (!wheatSeeds) {
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/wheat_seed_block_from_wheat_seeds"));
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/wheat_seeds_from_wheat_seed_block"));
            if (!rottenflesh) {
                recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/rotten_flesh_block_from_rotten_flesh"));
                recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/rotten_flesh_from_rotten_flesh_block"));
            }
            return recipes;
        }
        return recipes;
    }}
