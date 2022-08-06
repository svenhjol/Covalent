package svenhjol.covalent;

import net.fabricmc.api.ModInitializer;
import svenhjol.charm.Charm;
import svenhjol.charm.helper.LogHelper;
import svenhjol.charm.loader.CharmModule;
import svenhjol.charm.loader.CommonLoader;

public class Covalent implements ModInitializer {
    public static final String MOD_ID = "covalent";
    public static CommonLoader<CharmModule> LOADER = new CommonLoader<>(MOD_ID, "svenhjol.covalent.module");
    private static boolean hasInit = false;

    @Override
    public void onInitialize() {
        // always start Charm first
        Charm.init();

        // setup Covalent afterwards
        Covalent.init();
    }

    public static void init() {
        if (hasInit) return;

        LOADER.init();

        hasInit = true;
    }

    public static void debug(Class<?> className, String message) {
        LogHelper.debug(Covalent.MOD_ID, className, message);
    }
}
