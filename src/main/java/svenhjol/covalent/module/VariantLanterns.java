package svenhjol.covalent.module;

import net.minecraft.client.render.RenderLayer;
import svenhjol.covalent.block.LanternBlock;
import svenhjol.meson.MesonModule;
import svenhjol.meson.iface.Module;
import svenhjol.meson.mixin.accessor.RenderLayersAccessor;

@Module(description = "Variant lanterns")
public class VariantLanterns extends MesonModule {
    public static LanternBlock LANTERN;

    @Override
    public void register() {
        LANTERN = new LanternBlock(this);
    }

    @Override
    public void clientRegister() {
        RenderLayersAccessor.getBlocks().put(LANTERN, RenderLayer.getTranslucent());
    }
}
