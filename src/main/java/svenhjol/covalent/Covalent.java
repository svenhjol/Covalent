package svenhjol.covalent;

import net.fabricmc.api.ModInitializer;
import svenhjol.charm.base.handler.ModuleHandler;
import svenhjol.covalent.module.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Covalent implements ModInitializer {
    public static final String MOD_ID = "covalent";

    @Override
    public void onInitialize() {
        ModuleHandler.AVAILABLE_MODULES.put(Covalent.MOD_ID, new ArrayList<>(Arrays.asList(
            BambooBundles.class,
            BeetrootCrates.class,
            CarrotCrates.class,
            EggCrates.class,
            PotatoCrates.class,
            RottenFleshBundles.class,
            WheatSeedSacks.class
        )));
    }
}
