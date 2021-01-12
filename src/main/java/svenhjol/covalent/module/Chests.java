package svenhjol.covalent.module;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.handler.RegistryHandler;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.CovalentChestBlock;
import svenhjol.covalent.block.CovalentTrappedChestBlock;
import svenhjol.covalent.blockentity.CovalentChestBlockEntity;
import svenhjol.covalent.blockentity.CovalentTrappedChestBlockEntity;
import svenhjol.covalent.client.ChestsClient;
import svenhjol.covalent.integration.Coranthemum;
import svenhjol.covalent.integration.Terrestria;
import svenhjol.covalent.integration.Traverse;
import svenhjol.covalent.integration.WildExplorer;

import java.util.HashMap;
import java.util.Map;

@Module(mod = Covalent.MOD_ID, client = ChestsClient.class, description = "Chests for all supported Minecraft mods.")
public class Chests extends CharmModule {
    public static final Identifier NORMAL_ID = new Identifier("covalent_chest");
    public static final Identifier TRAPPED_ID = new Identifier(Covalent.MOD_ID, "covalent_trapped_chest");

    public static final Map<IVariantMaterial, CovalentChestBlock> NORMAL_CHEST_BLOCKS = new HashMap<>();
    public static final Map<IVariantMaterial, CovalentTrappedChestBlock> TRAPPED_CHEST_BLOCKS = new HashMap<>();

    public static BlockEntityType<CovalentChestBlockEntity> NORMAL_BLOCK_ENTITY;
    public static BlockEntityType<CovalentTrappedChestBlockEntity> TRAPPED_BLOCK_ENTITY;

    @Override
    public void register() {

        // coranthemum
        for (Coranthemum.Materials material : Coranthemum.Materials.values()) {
            Chests.NORMAL_CHEST_BLOCKS.put(material, new CovalentChestBlock(this, Coranthemum.MOD_ID, material));
            Chests.TRAPPED_CHEST_BLOCKS.put(material, new CovalentTrappedChestBlock(this, Coranthemum.MOD_ID, material));
        }

        // terrestria
        for (Terrestria.Materials material : Terrestria.Materials.values()) {
            Chests.NORMAL_CHEST_BLOCKS.put(material, new CovalentChestBlock(this, Terrestria.MOD_ID, material));
            Chests.TRAPPED_CHEST_BLOCKS.put(material, new CovalentTrappedChestBlock(this, Terrestria.MOD_ID, material));
        }

        // traverse
        for (Traverse.Materials material : Traverse.Materials.values()) {
            Chests.NORMAL_CHEST_BLOCKS.put(material, new CovalentChestBlock(this, Traverse.MOD_ID, material));
            Chests.TRAPPED_CHEST_BLOCKS.put(material, new CovalentTrappedChestBlock(this, Traverse.MOD_ID, material));
        }

        // wild_explorer
        for (WildExplorer.Materials material : WildExplorer.Materials.values()) {
            Chests.NORMAL_CHEST_BLOCKS.put(material, new CovalentChestBlock(this, WildExplorer.MOD_ID, material));
            Chests.TRAPPED_CHEST_BLOCKS.put(material, new CovalentTrappedChestBlock(this, WildExplorer.MOD_ID, material));
        }

        // register covalent block entities
        NORMAL_BLOCK_ENTITY = RegistryHandler.blockEntity(NORMAL_ID, CovalentChestBlockEntity::new, NORMAL_CHEST_BLOCKS.values().toArray(new Block[0]));
        TRAPPED_BLOCK_ENTITY = RegistryHandler.blockEntity(TRAPPED_ID, CovalentTrappedChestBlockEntity::new, TRAPPED_CHEST_BLOCKS.values().toArray(new Block[0]));
    }
}
