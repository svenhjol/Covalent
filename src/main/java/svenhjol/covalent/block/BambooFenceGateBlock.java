package svenhjol.covalent.block;

import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class BambooFenceGateBlock extends FenceGateBlock implements ICharmBlock {
    private final CharmModule module;

    public BambooFenceGateBlock(CharmModule module) {
        super(Settings.of(Material.WOOD, StorageBlocks.BAMBOO_PLANKS.getDefaultMapColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
        this.register(module, "bamboo_fence_gate");
        this.module = module;
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.DECORATIONS;
    }

    @Override
    public boolean enabled() {
        return module.enabled && StorageBlocks.bamboo;
    }
}
