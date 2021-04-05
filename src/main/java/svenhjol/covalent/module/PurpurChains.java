package svenhjol.covalent.module;

import svenhjol.covalent.Covalent;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.block.PurpurChainsBlock;
import svenhjol.covalent.client.PurpurChainsClient;

@Module(mod = Covalent.MOD_ID, client = PurpurChainsClient.class, description = "Purpur version of the vanilla chain.")
public class PurpurChains extends CharmModule {
    public static PurpurChainsBlock PURPUR_CHAIN;

    @Override
    public void register() {
        PURPUR_CHAIN = new PurpurChainsBlock(this);
    }
}

