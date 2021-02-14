package svenhjol.covalent.block;

import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class BambooBlock extends CharmBlock {
    public BambooBlock(CharmModule module) {
        super(module, "bamboo_bundle", Settings.copy(Blocks.HAY_BLOCK));
    }

    @Override
    public boolean enabled() {
        return super.enabled() && StorageBlocks.bamboo;
    }
}
