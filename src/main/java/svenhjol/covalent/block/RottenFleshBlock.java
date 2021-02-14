package svenhjol.covalent.block;

import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class RottenFleshBlock extends CharmBlock {
    public RottenFleshBlock(CharmModule module) {
        super(module, "rotten_flesh_bundle", Settings.copy(Blocks.SLIME_BLOCK));
    }

    @Override
    public boolean enabled() {
        return super.enabled() && StorageBlocks.rottenFlesh;
    }
}
