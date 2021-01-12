package svenhjol.covalent.block;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.block.VariantTrappedChestBlock;
import svenhjol.covalent.blockentity.CovalentTrappedChestBlockEntity;
import svenhjol.covalent.module.Chests;

import javax.annotation.Nullable;

public class CovalentTrappedChestBlock extends VariantTrappedChestBlock {
    private final String belongsToMod;

    public CovalentTrappedChestBlock(CharmModule module, String belongsToMod, IVariantMaterial type) {
        super(module, type, Settings.copy(Blocks.TRAPPED_CHEST), () -> Chests.TRAPPED_BLOCK_ENTITY);
        this.belongsToMod = belongsToMod;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView worldIn) {
        return new CovalentTrappedChestBlockEntity();
    }

    @Override
    public boolean enabled() {
        return super.enabled() && ModHelper.isLoaded(belongsToMod);
    }
}
