package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.covalent.module.StorageBlocks;
import svenhjol.meson.MesonModule;
import svenhjol.meson.block.MesonBlock;

public class BeetrootBlock extends MesonBlock {
    public BeetrootBlock(MesonModule module) {
        super(module, "beetroot_block", AbstractBlock.Settings.copy(Blocks.HAY_BLOCK));
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.beetroot;
    }
}
