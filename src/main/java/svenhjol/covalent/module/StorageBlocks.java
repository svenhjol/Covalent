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
    public static BambooDoorBlock BAMBOO_DOOR;
    public static BambooLadderBlock BAMBOO_LADDER;
    public static BambooPlanksBlock BAMBOO_PLANKS;
    public static BambooSlabBlock BAMBOO_SLAB;
    public static BambooStairsBlock BAMBOO_STAIRS;
    public static BambooTrapdoorBlock BAMBOO_TRAPDOOR;
    public static BambooFenceBlock BAMBOO_FENCE;
    public static BambooFenceGateBlock BAMBOO_FENCE_GATE;
    public static RottenFleshBlock ROTTEN_FLESH;
    public static WheatSeedsBlock WHEAT_SEEDS;

    @Config(name = "Bamboo bundle", description = "If true, adds bamboo storage blocks.")
    public static boolean bamboo = true;

    @Config(name = "Rotten Flesh bundle", description = "If true, adds rotten flesh storage blocks.")
    public static boolean rottenFlesh = true;

    @Config(name = "Wheat Seed sack", description = "If true, adds wheat seed storage blocks.")
    public static boolean wheatSeeds = true;
    public static boolean bamboo_planks;

    @Override
    public void register() {
        // bamboo
        BAMBOO = new BambooBlock(this);
        BAMBOO_DOOR = new BambooDoorBlock(this);
        BAMBOO_LADDER = new BambooLadderBlock(this);
        BAMBOO_PLANKS = new BambooPlanksBlock(this);
        BAMBOO_SLAB = new BambooSlabBlock(this);
        BAMBOO_STAIRS = new BambooStairsBlock(this);
        BAMBOO_TRAPDOOR = new BambooTrapdoorBlock(this);
        BAMBOO_FENCE = new BambooFenceBlock(this);
        BAMBOO_FENCE_GATE = new BambooFenceGateBlock(this);

        // rotten flesh
        ROTTEN_FLESH = new RottenFleshBlock(this);

        // wheat
        WHEAT_SEEDS = new WheatSeedsBlock(this);
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> remove = new ArrayList<>();
        String prefix = "storage_blocks";

        if (!bamboo) {
            remove.addAll(Arrays.asList(
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo"),
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo_door"),
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo_ladder"),
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo_planks"),
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo_slab"),
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo_stairs"),
                new Identifier(Covalent.MOD_ID, prefix + "/bamboo_trapdoor"),
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
