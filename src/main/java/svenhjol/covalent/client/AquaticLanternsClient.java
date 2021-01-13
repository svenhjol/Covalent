package svenhjol.covalent.client;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import svenhjol.charm.base.CharmClientModule;
import svenhjol.charm.base.CharmModule;
import svenhjol.covalent.module.AquaticLanterns;

public class AquaticLanternsClient extends CharmClientModule {
    public AquaticLanternsClient(CharmModule module) {
        super(module);
    }

    @Override
    public void register() {
        BlockRenderLayerMap.INSTANCE.putBlock(AquaticLanterns.AQUATIC_LANTERN, RenderLayer.getCutout());
    }
}
