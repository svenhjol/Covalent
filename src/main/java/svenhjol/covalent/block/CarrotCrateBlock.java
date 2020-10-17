package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;

public class CarrotCrateBlock extends CharmBlock {
    public CarrotCrateBlock(CharmModule module) {
        super(module, "carrot_crate", AbstractBlock.Settings.copy(Blocks.HAY_BLOCK));
    }
}
