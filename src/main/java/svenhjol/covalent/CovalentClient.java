package svenhjol.covalent;

import net.fabricmc.api.ClientModInitializer;
import svenhjol.charm.base.handler.ClientHandler;

public class CovalentClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientHandler.INSTANCE.registerFabricMod(Covalent.MOD_ID);
    }
}
