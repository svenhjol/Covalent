package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.covalent.module.StorageBlocks;
import svenhjol.meson.MesonModule;
import svenhjol.meson.block.MesonBlock;

public class CarrotBlock extends MesonBlock {
    public CarrotBlock(MesonModule module) {
        super(module, "carrot_block", AbstractBlock.Settings.copy(Blocks.HAY_BLOCK));
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.carrot;
    }
}
