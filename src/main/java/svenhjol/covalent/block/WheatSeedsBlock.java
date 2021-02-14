package svenhjol.covalent.block;

import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class WheatSeedsBlock extends CharmBlock {
    public WheatSeedsBlock(CharmModule module) {
        super(module, "wheat_seeds_bundle", Settings.copy(Blocks.HAY_BLOCK));
    }

    @Override
    public boolean enabled() {
        return super.enabled() && StorageBlocks.wheatSeeds;
    }
}
