package svenhjol.covalent.module;

import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.handler.ModuleHandler;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.SmoothGlowstoneBlock;

import java.util.ArrayList;
import java.util.List;

@Module(mod = Covalent.MOD_ID, description = "Smelt glowstone to get smooth glowstone.")
public class SmoothGlowstone extends CharmModule {
    public static SmoothGlowstoneBlock SMOOTH_GLOWSTONE;

    @Override
    public void register() {
        SMOOTH_GLOWSTONE = new SmoothGlowstoneBlock(this);
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> remove = new ArrayList<>();

        if (!ModuleHandler.enabled("charm:kilns"))
            remove.add(new Identifier(Covalent.MOD_ID, "smooth_glowstone/smooth_glowstone_from_firing"));

        return remove;
    }
}
