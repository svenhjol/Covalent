package svenhjol.covalent.module;

import svenhjol.covalent.Covalent;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.block.PrismarineChainsBlock;
import svenhjol.covalent.block.PurpurChainsBlock;
import svenhjol.covalent.client.ChainsClient;

@Module(mod = Covalent.MOD_ID, client = ChainsClient.class, description = "Prismarine and Purpur versions of the vanilla chain.")
public class Chains extends CharmModule {
    public static PrismarineChainsBlock PRISMARINE_CHAIN;
    public static PurpurChainsBlock PURPUR_CHAIN;

    @Override
    public void register() {
        PRISMARINE_CHAIN = new PrismarineChainsBlock(this);
        PURPUR_CHAIN = new PurpurChainsBlock(this);
    }
}

