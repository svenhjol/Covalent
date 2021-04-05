package svenhjol.covalent.module;

import svenhjol.covalent.Covalent;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.block.PurpurLanternBlock;
import svenhjol.covalent.client.PurpurLanternsClient;

@Module(mod = Covalent.MOD_ID, client = PurpurLanternsClient.class, description = "Purpur variant of vanilla lanterns.")
public class PurpurLanterns extends CharmModule {
    public static PurpurLanternBlock PURPUR_LANTERN;

    @Override
    public void register() {PURPUR_LANTERN = new PurpurLanternBlock(this, "purpur_lantern");
    }
}
