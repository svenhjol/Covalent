package svenhjol.covalent.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChainBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;

public class PurpurChainsBlock extends ChainBlock implements ICharmBlock {
    private final CharmModule module;

    public PurpurChainsBlock(CharmModule module) {
        super(AbstractBlock.Settings.copy(Blocks.CHAIN));
        this.module = module;
        this.register(module, "purpur_chain");
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.DECORATIONS;
    }

    @Override
    public void addStacksForDisplay(ItemGroup group, DefaultedList<ItemStack> items) {
        if (enabled())
            super.addStacksForDisplay(group, items);
    }

    @Override
    public boolean enabled() {
        return module.enabled;
    }
}
