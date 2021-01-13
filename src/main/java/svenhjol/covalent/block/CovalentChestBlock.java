package svenhjol.covalent.block;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.block.VariantChestBlock;
import svenhjol.covalent.blockentity.CovalentChestBlockEntity;
import svenhjol.covalent.module.CovalentChests;

import javax.annotation.Nullable;

public class CovalentChestBlock extends VariantChestBlock {
    private final String belongsToMod;

    public CovalentChestBlock(CharmModule module, String belongsToMod, IVariantMaterial type) {
        super(module, type, Settings.copy(Blocks.CHEST), () -> CovalentChests.NORMAL_BLOCK_ENTITY);
        this.belongsToMod = belongsToMod;
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockView worldIn) {
        return new CovalentChestBlockEntity();
    }

    @Override
    public boolean enabled() {
        return super.enabled() && ModHelper.isLoaded(belongsToMod);
    }
}
