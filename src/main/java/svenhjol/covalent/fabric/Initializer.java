package svenhjol.covalent.fabric;

import net.fabricmc.api.ModInitializer;
import svenhjol.charmony.base.Mods;
import svenhjol.covalent.Covalent;

public class Initializer implements ModInitializer {
    @Override
    public void onInitialize() {
        svenhjol.charmony.fabric.Initializer.initCharmony();

        var instance = Mods.common(Covalent.ID, Covalent::new);
        var loader = instance.loader();

        loader.init(instance.features());
        loader.run();
    }
}
