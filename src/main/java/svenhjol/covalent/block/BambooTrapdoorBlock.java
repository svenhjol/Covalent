package svenhjol.covalent.block;

import net.minecraft.block.TrapdoorBlock;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class BambooTrapdoorBlock extends TrapdoorBlock implements ICharmBlock {
    private final CharmModule module;

    public BambooTrapdoorBlock(CharmModule module) {
        super(Settings.copy(StorageBlocks.BAMBOO));

        this.module = module;
        this.register(module, "bamboo_trapdoor");
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.bamboo;
    }
}
