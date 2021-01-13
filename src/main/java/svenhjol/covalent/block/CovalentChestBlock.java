package svenhjol.covalent.block;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.block.VariantChestBlock;
import svenhjol.covalent.blockentity.CovalentChestBlockEntity;
import svenhjol.covalent.module.CovalentChests;

import javax.annotation.Nullable;

public class CovalentChestBlock extends VariantChestBlock {
    public CovalentChestBlock(CharmModule module, IVariantMaterial type, String... loadedMods) {
        super(module, type, Settings.copy(Blocks.CHEST), () -> CovalentChests.NORMAL_BLOCK_ENTITY, loadedMods);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockView worldIn) {
        return new CovalentChestBlockEntity();
    }
}
