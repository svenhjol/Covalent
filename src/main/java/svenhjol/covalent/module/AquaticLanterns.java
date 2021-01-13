package svenhjol.covalent.module;

import svenhjol.covalent.Covalent;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.block.AquaticLanternBlock;
import svenhjol.covalent.client.AquaticLanternsClient;

@Module(mod = Covalent.MOD_ID, client = AquaticLanternsClient.class, description = "Aquatic variant of vanilla lanterns.")
public class AquaticLanterns extends CharmModule {
    public static AquaticLanternBlock AQUATIC_LANTERN;

    @Override
    public void register() {
        AQUATIC_LANTERN = new AquaticLanternBlock(this, "aquatic_lantern");
    }
}
