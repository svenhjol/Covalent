package svenhjol.covalent.block;

import net.minecraft.block.StairsBlock;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class BambooStairsBlock extends StairsBlock implements ICharmBlock {
    private final CharmModule module;

    public BambooStairsBlock(CharmModule module) {
        super(StorageBlocks.BAMBOO.getDefaultState(), Settings.copy(StorageBlocks.BAMBOO));
        this.register(module, "bamboo_stairs");
        this.module = module;
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.bamboo;
    }
}
