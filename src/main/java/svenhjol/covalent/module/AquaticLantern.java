package svenhjol.covalent.module;

import svenhjol.covalent.Covalent;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.block.AquaticLanternBlock;
import svenhjol.covalent.client.AquaticLanternClient;

@Module(mod = Covalent.MOD_ID, client = AquaticLanternClient.class, description = "Aquatic variant of vanilla lanterns.")
public class AquaticLantern extends CharmModule {
    public static AquaticLanternBlock AQUATIC_LANTERN;

    @Override
    public void register() {
        AQUATIC_LANTERN = new AquaticLanternBlock(this, "aquatic_lantern");

    }
}
