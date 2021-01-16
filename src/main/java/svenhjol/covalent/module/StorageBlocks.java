package svenhjol.covalent.module;

import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Config;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Module(mod = Covalent.MOD_ID, description = "Storage blocks.")
public class StorageBlocks extends CharmModule {
    public static BambooBlock BAMBOO;
    public static BambooSlabBlock BAMBOO_SLAB;
    public static BambooStairsBlock BAMBOO_STAIRS;
    public static BambooWallBlock BAMBOO_WALL;
    public static RottenFleshBlock ROTTEN_FLESH;
    public static WheatSeedsBlock WHEAT_SEEDS;

    @Config(name = "Bamboo bundle", description = "If true, adds bamboo storage blocks.")
    public static boolean bamboo = true;

    @Config(name = "Rotten Flesh bundle", description = "If true, adds rotten flesh storage blocks.")
    public static boolean rottenFlesh = true;

    @Config(name = "Wheat Seed sack", description = "If true, adds wheat seed storage blocks.")
    public static boolean wheatSeeds = true;

    @Override
    public void register() {
        BAMBOO = new BambooBlock(this);
        BAMBOO_SLAB = new BambooSlabBlock(this);
        BAMBOO_STAIRS = new BambooStairsBlock(this);
        BAMBOO_WALL = new BambooWallBlock(this);
        ROTTEN_FLESH = new RottenFleshBlock(this);
        WHEAT_SEEDS = new WheatSeedsBlock(this);
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> remove = new ArrayList<>();
        String prefix = "storage_blocks";

        if (!bamboo) {
            remove.addAll(Arrays.asList(
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo"),
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo_slab"),
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo_stairs"),
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo_wall")
            ));
        }

        if (!rottenFlesh)
            remove.add(new Identifier(Covalent.MOD_ID, prefix + "/rotten_flesh"));

        if (!wheatSeeds)
            remove.add(new Identifier(Covalent.MOD_ID, prefix + "/wheat_seeds"));

        return remove;
    }
}
