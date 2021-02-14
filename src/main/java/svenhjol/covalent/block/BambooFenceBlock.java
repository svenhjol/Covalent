package svenhjol.covalent.block;

import net.minecraft.block.FenceBlock;
import net.minecraft.block.Material;
import net.minecraft.block.WallBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class BambooFenceBlock extends FenceBlock implements ICharmBlock {
    private final CharmModule module;

    public BambooFenceBlock(CharmModule module) {
        super(Settings.of(Material.WOOD, StorageBlocks.BAMBOO_PLANKS.getDefaultMaterialColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
        this.register(module, "bamboo_fence");
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
