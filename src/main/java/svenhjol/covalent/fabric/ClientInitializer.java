package svenhjol.covalent.fabric;

import net.fabricmc.api.ClientModInitializer;
import svenhjol.charmony.base.Mods;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.CovalentClient;

public class ClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        svenhjol.charmony.fabric.ClientInitializer.initCharmony();

        var instance = Mods.client(Covalent.ID, CovalentClient::new);
        var loader = instance.loader();

        loader.init(instance.features());
        loader.run();
    }
}
