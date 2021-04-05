package svenhjol.covalent.client;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import svenhjol.charm.base.CharmClientModule;
import svenhjol.charm.base.CharmModule;
import svenhjol.covalent.module.PurpurChains;

public class PurpurChainsClient extends CharmClientModule {
    public PurpurChainsClient(CharmModule module) {
        super(module);
    }

    @Override
    public void register() {
        BlockRenderLayerMap.INSTANCE.putBlock(PurpurChains.PURPUR_CHAIN, RenderLayer.getCutout());
    }
}
