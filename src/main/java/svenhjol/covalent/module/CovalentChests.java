package svenhjol.covalent.module;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.handler.RegistryHandler;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.CovalentIntegration;
import svenhjol.covalent.block.CovalentChestBlock;
import svenhjol.covalent.block.CovalentTrappedChestBlock;
import svenhjol.covalent.blockentity.CovalentChestBlockEntity;
import svenhjol.covalent.blockentity.CovalentTrappedChestBlockEntity;
import svenhjol.covalent.client.CovalentChestsClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Module(mod = Covalent.MOD_ID, client = CovalentChestsClient.class, description = "Chests for all supported Minecraft integration.")
public class CovalentChests extends CharmModule {
    public static final Identifier NORMAL_ID = new Identifier(Covalent.MOD_ID, "chest");
    public static final Identifier TRAPPED_ID = new Identifier(Covalent.MOD_ID, "trapped_chest");

    public static final Map<IVariantMaterial, CovalentChestBlock> NORMAL_CHEST_BLOCKS = new HashMap<>();
    public static final Map<IVariantMaterial, CovalentTrappedChestBlock> TRAPPED_CHEST_BLOCKS = new HashMap<>();

    public static BlockEntityType<CovalentChestBlockEntity> NORMAL_BLOCK_ENTITY;
    public static BlockEntityType<CovalentTrappedChestBlockEntity> TRAPPED_BLOCK_ENTITY;

    @Override
    public void register() {

        // iterate all integrations and create chest blocks
        CovalentIntegration.MODS.forEach(mod -> {
            if (mod.doChests()) {
                for (IVariantMaterial material : mod.getMaterials()) {
                    CovalentChests.NORMAL_CHEST_BLOCKS.put(material, new CovalentChestBlock(this, material, mod.getModId()));
                    CovalentChests.TRAPPED_CHEST_BLOCKS.put(material, new CovalentTrappedChestBlock(this, material, mod.getModId()));
                }
            }
        });

        // register covalent block entities
        NORMAL_BLOCK_ENTITY = RegistryHandler.blockEntity(NORMAL_ID, CovalentChestBlockEntity::new, NORMAL_CHEST_BLOCKS.values().toArray(new Block[0]));
        TRAPPED_BLOCK_ENTITY = RegistryHandler.blockEntity(TRAPPED_ID, CovalentTrappedChestBlockEntity::new, TRAPPED_CHEST_BLOCKS.values().toArray(new Block[0]));
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> recipes = new ArrayList<>();

        for (IVariantMaterial material : CovalentIntegration.getMaterialsToRemove()) {
            recipes.add(new Identifier(Covalent.MOD_ID, "covalent_chests/" + material.asString() + "_chest"));
        }

        return recipes;
    }
}
