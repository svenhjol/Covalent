package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.covalent.module.StorageBlocks;
import svenhjol.meson.MesonModule;
import svenhjol.meson.block.MesonBlock;

public class WheatSeedBlock extends MesonBlock {
    public WheatSeedBlock(MesonModule module) {
        super(module, "wheat_seed_block", AbstractBlock.Settings.copy(Blocks.NETHER_WART));
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.wheatSeeds;
    }
}
