package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;

public class BambooBundleBlock extends CharmBlock {
    public BambooBundleBlock(CharmModule module) {
        super(module, "bamboo_bundle", AbstractBlock.Settings.copy(Blocks.HAY_BLOCK));
    }
}
