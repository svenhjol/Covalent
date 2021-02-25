package svenhjol.covalent.module;

import svenhjol.covalent.Covalent;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.block.PrismarineChainsBlock;
import svenhjol.covalent.client.PrismarineChainsClient;

@Module(mod = Covalent.MOD_ID, client = PrismarineChainsClient.class, description = "Prismarine version of the vanilla chain.")
public class PrismarineChains extends CharmModule {
    public static PrismarineChainsBlock PRISMARINE_CHAIN;

    @Override
    public void register() {
        PRISMARINE_CHAIN = new PrismarineChainsBlock(this);
    }
}

