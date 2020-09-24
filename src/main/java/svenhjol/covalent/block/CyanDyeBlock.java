package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.covalent.module.StorageBlocks;
import svenhjol.meson.MesonModule;
import svenhjol.meson.block.MesonBlock;

public class CyanDyeBlock extends MesonBlock {
    public CyanDyeBlock(MesonModule module) {
        super(module, "cyan_dye_block", AbstractBlock.Settings.copy(Blocks.GLASS));
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.cyanDye;
    }
}
