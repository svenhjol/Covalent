package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;

public class BeetrootCrateBlock extends CharmBlock {
    public BeetrootCrateBlock(CharmModule module) {
        super(module, "beetroot_crate", AbstractBlock.Settings.copy(Blocks.HAY_BLOCK));
    }
}
