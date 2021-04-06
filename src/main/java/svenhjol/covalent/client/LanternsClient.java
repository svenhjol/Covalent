package svenhjol.covalent.client;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import svenhjol.charm.base.CharmClientModule;
import svenhjol.charm.base.CharmModule;
import svenhjol.covalent.module.Lanterns;

public class LanternsClient extends CharmClientModule {
    public LanternsClient(CharmModule module) {
        super(module);
    }

    @Override
    public void register() {
        BlockRenderLayerMap.INSTANCE.putBlock(Lanterns.AQUATIC_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lanterns.PURPUR_LANTERN, RenderLayer.getCutout());
    }
}
