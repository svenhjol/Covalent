package svenhjol.covalent.block;

import net.minecraft.block.WallBlock;
import net.minecraft.item.ItemGroup;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.covalent.module.StorageBlocks;

public class BambooWallBlock extends WallBlock implements ICharmBlock {
    private final CharmModule module;

    public BambooWallBlock(CharmModule module) {
        super(Settings.copy(StorageBlocks.BAMBOO));
        this.register(module, "bamboo_wall");
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
