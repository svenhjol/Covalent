package svenhjol.covalent.block;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.CharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class BambooPlanksBlock extends CharmBlock {
    public BambooPlanksBlock(CharmModule module) {
        super(module, "bamboo_planks", Settings.copy(Blocks.OAK_PLANKS));
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.BUILDING_BLOCKS;
    }

    @Override
    public boolean enabled() {
        return super.enabled() && StorageBlocks.bamboo;
    }
}
