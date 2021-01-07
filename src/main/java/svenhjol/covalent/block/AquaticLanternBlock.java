package svenhjol.covalent.block;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.block.BaseLanternBlock;

public class AquaticLanternBlock extends BaseLanternBlock {
    public AquaticLanternBlock(CharmModule module, String name) {
        super(module, name, AbstractBlock.Settings.copy(Blocks.LANTERN));
    }
}
