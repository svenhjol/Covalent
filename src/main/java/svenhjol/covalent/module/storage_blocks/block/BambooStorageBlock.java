package svenhjol.covalent.module.storage_blocks.block;

import net.minecraft.world.level.block.Blocks;
import svenhjol.charm.block.CharmBlock;
import svenhjol.charm.loader.CharmModule;
import svenhjol.covalent.module.storage_blocks.StorageBlocks;

public class BambooStorageBlock extends CharmBlock {
    public BambooStorageBlock(CharmModule module) {
        super(module, "bamboo_storage", Properties.copy(Blocks.HAY_BLOCK));
    }

    @Override
    public boolean enabled() {
        return super.enabled() && StorageBlocks.enableBambooBundle;
    }
}
