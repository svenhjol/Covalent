package svenhjol.covalent.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import svenhjol.charm.blockentity.VariantChestBlockEntity;
import svenhjol.covalent.module.CovalentChests;

public class CovalentChestBlockEntity extends VariantChestBlockEntity {
    public CovalentChestBlockEntity(BlockPos pos, BlockState state) {
        super(CovalentChests.NORMAL_BLOCK_ENTITY, pos, state);
    }
}