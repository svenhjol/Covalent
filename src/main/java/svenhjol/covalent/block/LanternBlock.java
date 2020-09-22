package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.covalent.module.StorageBlocks;
import svenhjol.meson.MesonModule;
import svenhjol.meson.block.MesonBlock;

public class LanternBlock extends MesonBlock {
    public LanternBlock(MesonModule module) {
        super(module, "lantern_block", AbstractBlock.Settings.copy(Blocks.LANTERN));
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.egg;
    }
}
