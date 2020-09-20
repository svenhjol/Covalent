package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.covalent.module.StorageBlocks;
import svenhjol.meson.MesonModule;
import svenhjol.meson.block.MesonBlock;

public class RottenFleshBlock extends MesonBlock {
    public RottenFleshBlock(MesonModule module) {
        super(module, "rotten_flesh_block", AbstractBlock.Settings.copy(Blocks.SLIME_BLOCK));
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.rottenflesh;
    }
}
