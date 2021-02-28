package svenhjol.covalent.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import svenhjol.charm.blockentity.VariantTrappedChestBlockEntity;
import svenhjol.covalent.module.CovalentChests;

public class CovalentTrappedChestBlockEntity extends VariantTrappedChestBlockEntity {
    public CovalentTrappedChestBlockEntity(BlockPos pos, BlockState state) {
        super(CovalentChests.TRAPPED_BLOCK_ENTITY, pos, state);
    }
}
