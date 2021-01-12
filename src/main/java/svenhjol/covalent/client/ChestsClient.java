package svenhjol.covalent.client;

import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmClientModule;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.block.VariantChestBlock;
import svenhjol.charm.block.VariantTrappedChestBlock;
import svenhjol.charm.event.BlockItemRenderCallback;
import svenhjol.charm.event.TextureStitchCallback;
import svenhjol.charm.render.VariantChestBlockEntityRenderer;
import svenhjol.covalent.blockentity.CovalentChestBlockEntity;
import svenhjol.covalent.blockentity.CovalentTrappedChestBlockEntity;
import svenhjol.covalent.module.CovalentChests;

import java.util.Set;

public class ChestsClient extends CharmClientModule {
    private final CovalentChestBlockEntity CACHED_NORMAL_CHEST = new CovalentChestBlockEntity();
    private final CovalentTrappedChestBlockEntity CACHED_TRAPPED_CHEST = new CovalentTrappedChestBlockEntity();

    public ChestsClient(CharmModule module) {
        super(module);
    }

    @Override
    public void register() {
        BlockEntityRendererRegistry.INSTANCE.register(CovalentChests.NORMAL_BLOCK_ENTITY, VariantChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(CovalentChests.TRAPPED_BLOCK_ENTITY, VariantChestBlockEntityRenderer::new);

        TextureStitchCallback.EVENT.register(this::handleTextureStitch);
        BlockItemRenderCallback.EVENT.register(this::handleBlockItemRender);
    }

    private void handleTextureStitch(SpriteAtlasTexture atlas, Set<Identifier> textures) {
        if (atlas.getId().toString().equals("minecraft:textures/atlas/chest.png")) {
            CovalentChests.NORMAL_CHEST_BLOCKS.keySet().forEach(type -> {
                addChestTexture(textures, type, ChestType.LEFT);
                addChestTexture(textures, type, ChestType.RIGHT);
                addChestTexture(textures, type, ChestType.SINGLE);
            });
        }
    }

    // TODO: abstract this
    private BlockEntity handleBlockItemRender(Block block) {
        if (block instanceof VariantChestBlock) {
            VariantChestBlock chest = (VariantChestBlock)block;
            CACHED_NORMAL_CHEST.setMaterialType(chest.getMaterialType());
            return CACHED_NORMAL_CHEST;

        } else if (block instanceof VariantTrappedChestBlock) {
            VariantTrappedChestBlock chest = (VariantTrappedChestBlock)block;
            CACHED_TRAPPED_CHEST.setMaterialType(chest.getMaterialType());
            return CACHED_TRAPPED_CHEST;
        }

        return null;
    }

    // TODO: abstract this
    private void addChestTexture(Set<Identifier> textures, IVariantMaterial variant, ChestType chestType) {
        String chestTypeName = chestType != ChestType.SINGLE ? "_" + chestType.asString().toLowerCase() : "";
        String[] bases = {"trapped", "normal"};

        for (String base : bases) {
            Identifier id = new Identifier(module.mod, "entity/chest/" + variant.asString() + "_" + base + chestTypeName);
            VariantChestBlockEntityRenderer.addTexture(variant, chestType, id, base.equals("trapped"));
            textures.add(id);
        }
    }
}
