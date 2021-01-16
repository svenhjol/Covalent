package svenhjol.covalent.module;

import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Config;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.BambooBundleBlock;
import svenhjol.covalent.block.RottenFleshBundleBlock;
import svenhjol.covalent.block.WheatSeedSackBlock;

import java.util.ArrayList;
import java.util.List;

@Module(mod = Covalent.MOD_ID, description = "Storage blocks.")
public class StorageBlocks extends CharmModule {
    public static BambooBundleBlock BAMBOO_BUNDLE;
    public static RottenFleshBundleBlock ROTTEN_FLESH_BUNDLE;
    public static WheatSeedSackBlock WHEAT_SEED_SACK;

    @Config(name = "Bamboo bundle", description = "If true, adds bamboo storage blocks.")
    public static boolean bamboo = true;

    @Config(name = "Rotten Flesh bundle", description = "If true, adds rotten flesh storage blocks.")
    public static boolean rottenFlesh = true;

    @Config(name = "Wheat Seed sack", description = "If true, adds wheat seed storage blocks.")
    public static boolean wheatSeeds = true;

    @Override
    public void register() {
        BAMBOO_BUNDLE = new BambooBundleBlock(this);
        ROTTEN_FLESH_BUNDLE = new RottenFleshBundleBlock(this);
        WHEAT_SEED_SACK = new WheatSeedSackBlock(this);
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> remove = new ArrayList<>();

        if (!bamboo) remove.add(new Identifier(Covalent.MOD_ID, "storage_blocks/bamboo_bundle"));
        if (!rottenFlesh) remove.add(new Identifier(Covalent.MOD_ID, "storage_blocks/rotten_flesh_bundle"));
        if (!wheatSeeds) remove.add(new Identifier(Covalent.MOD_ID, "storage_blocks/wheat_seed_sack"));

        return remove;
    }
}
