package svenhjol.covalent.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.block.VariantTrappedChestBlock;
import svenhjol.covalent.blockentity.CovalentTrappedChestBlockEntity;
import svenhjol.covalent.module.CovalentChests;

import javax.annotation.Nullable;

public class CovalentTrappedChestBlock extends VariantTrappedChestBlock {

    public CovalentTrappedChestBlock(CharmModule module, IVariantMaterial type, String... loadedMods) {
        super(module, type, Settings.copy(Blocks.TRAPPED_CHEST), () -> CovalentChests.TRAPPED_BLOCK_ENTITY, loadedMods);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CovalentTrappedChestBlockEntity(pos, state);
    }
}
