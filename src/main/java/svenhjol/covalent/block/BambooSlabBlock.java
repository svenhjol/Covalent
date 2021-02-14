package svenhjol.covalent.block;

import net.minecraft.block.SlabBlock;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class BambooSlabBlock extends SlabBlock implements ICharmBlock {
    private final CharmModule module;

    public BambooSlabBlock(CharmModule module) {
        super(Settings.copy(StorageBlocks.BAMBOO_PLANKS));
        this.register(module, "bamboo_slab");
        this.module = module;
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.bamboo;
    }
}
