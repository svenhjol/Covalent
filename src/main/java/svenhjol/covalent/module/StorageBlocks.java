package svenhjol.covalent.module;

import net.minecraft.util.Identifier;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.WheatSeedBlock;
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

    @Override
    public void register() {
        STORAGE_BLOCKS.add(new WheatSeedBlock(this));
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> recipes = new ArrayList<>();
        if (!wheatSeeds) {
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/wheat_seed_block_from_wheat_seeds"));
            recipes.add(new Identifier(Covalent.MOD_ID, "storage_blocks/wheat_seeds_from_wheat_seed_block"));
        }
        return recipes;
    }
}
