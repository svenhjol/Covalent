package svenhjol.covalent.block;

import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;

public class RottenFleshBundleBlock extends CharmBlock {
    public RottenFleshBundleBlock(CharmModule module) {
        super(module, "rotten_flesh_bundle", Settings.copy(Blocks.SLIME_BLOCK));
    }
}
