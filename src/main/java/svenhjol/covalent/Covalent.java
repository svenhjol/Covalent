package svenhjol.covalent;
import svenhjol.covalent.atmospheric.Atmospheric;
import net.fabricmc.api.ModInitializer;
import svenhjol.charm.base.handler.ModuleHandler;
import svenhjol.covalent.endergetic.Endergetic;
import svenhjol.covalent.terrestria.Terrestria;

import java.util.Arrays;

public class Covalent implements ModInitializer {
    public static final String MOD_ID = "covalent";

    @Override
    public void onInitialize() {
        ModuleHandler.INSTANCE.registerFabricMod(MOD_ID, Arrays.asList(
            Endergetic.class,
            Terrestria.class,
            Atmospheric.class
        ));
    }
}
