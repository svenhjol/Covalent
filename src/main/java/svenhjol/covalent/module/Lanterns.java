package svenhjol.covalent.module;

import svenhjol.covalent.Covalent;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.block.AquaticLanternBlock;
import svenhjol.covalent.block.PurpurLanternBlock;
import svenhjol.covalent.client.LanternsClient;

@Module(mod = Covalent.MOD_ID, client = LanternsClient.class, description = "Aquatic variant of vanilla lanterns.")
public class Lanterns extends CharmModule {
    public static AquaticLanternBlock AQUATIC_LANTERN;
    public static PurpurLanternBlock PURPUR_LANTERN;

    @Override
    public void register() {
        AQUATIC_LANTERN = new AquaticLanternBlock(this, "aquatic_lantern");
        PURPUR_LANTERN = new PurpurLanternBlock(this, "purpur_lantern");
    }
}
