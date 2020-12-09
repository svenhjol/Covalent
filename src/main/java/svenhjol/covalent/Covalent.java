package svenhjol.covalent;

import net.fabricmc.api.ModInitializer;
import svenhjol.charm.base.handler.ModuleHandler;
import svenhjol.covalent.module.TerrestriaIntegration;

import java.util.Arrays;

public class Covalent implements ModInitializer {
    public static final String MOD_ID = "covalent";

    @Override
    public void onInitialize() {
        ModuleHandler.INSTANCE.registerFabricMod(MOD_ID, Arrays.asList(
            TerrestriaIntegration.class
        ));
    }
}
