package svenhjol.covalent.block;

import net.minecraft.block.LadderBlock;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class BambooLadderBlock extends LadderBlock implements ICharmBlock {
    private final CharmModule module;

    public BambooLadderBlock(CharmModule module) {
        super(Settings.copy(StorageBlocks.BAMBOO));

        this.module = module;
        this.register(module, "bamboo_ladder");
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.bamboo;
    }
}
