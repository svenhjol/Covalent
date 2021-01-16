package svenhjol.covalent.block;

import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;

public class WheatSeedSackBlock extends CharmBlock {
    public WheatSeedSackBlock(CharmModule module) {
        super(module, "wheat_seed_sack", Settings.copy(Blocks.HAY_BLOCK));
    }
}
