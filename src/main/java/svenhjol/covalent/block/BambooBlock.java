package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.covalent.module.StorageBlocks;
import svenhjol.meson.MesonModule;
import svenhjol.meson.block.MesonBlock;

public class BambooBlock extends MesonBlock {
    public BambooBlock(MesonModule module) {
        super(module, "bamboo_block", AbstractBlock.Settings.copy(Blocks.SOUL_SAND));
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.bamboo;
    }
}
