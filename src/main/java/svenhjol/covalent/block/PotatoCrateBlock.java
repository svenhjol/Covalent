package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;

public class PotatoCrateBlock extends CharmBlock {
    public PotatoCrateBlock(CharmModule module) {
        super(module, "potato_crate", AbstractBlock.Settings.copy(Blocks.HAY_BLOCK));
    }
}
