package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;

public class EggCrateBlock extends CharmBlock {
    public EggCrateBlock(CharmModule module) {
        super(module, "egg_crate", AbstractBlock.Settings.copy(Blocks.SOUL_SAND));
    }
}
