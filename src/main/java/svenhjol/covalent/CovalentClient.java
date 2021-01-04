package svenhjol.covalent;

import net.fabricmc.api.ClientModInitializer;
import svenhjol.charm.base.CharmClientLoader;

public class CovalentClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        new CharmClientLoader(Covalent.MOD_ID);
    }
}
