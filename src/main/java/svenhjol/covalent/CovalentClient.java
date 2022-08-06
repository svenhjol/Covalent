package svenhjol.covalent;

import net.fabricmc.api.ClientModInitializer;
import svenhjol.charm.loader.CharmModule;
import svenhjol.charm.loader.ClientLoader;
import svenhjol.charm.loader.CommonLoader;

public class CovalentClient implements ClientModInitializer {
    public static ClientLoader<CharmModule, CommonLoader<CharmModule>> LOADER
        = new ClientLoader<>(Covalent.MOD_ID, Covalent.LOADER, "svenhjol.covalent.module");

    @Override
    public void onInitializeClient() {
        LOADER.init();
    }
}
