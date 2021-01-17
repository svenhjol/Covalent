package svenhjol.covalent.block;

import net.minecraft.block.DoorBlock;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class BambooDoorBlock extends DoorBlock implements ICharmBlock {
    private final CharmModule module;

    public BambooDoorBlock(CharmModule module) {
        super(Settings.copy(StorageBlocks.BAMBOO));

        this.module = module;
        this.register(module, "bamboo_door");
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.bamboo;
    }
}
