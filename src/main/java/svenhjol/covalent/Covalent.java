package svenhjol.covalent;

import net.fabricmc.api.ModInitializer;
import svenhjol.charm.Charm;
import svenhjol.charm.base.CharmLoader;
import svenhjol.covalent.module.*;

import java.util.Arrays;

public class Covalent implements ModInitializer {
    public static final String MOD_ID = "covalent";

    @Override
    public void onInitialize() {
        Charm.runFirst();

        new CharmLoader(MOD_ID, Arrays.asList(
            AquaticLanterns.class,
            Barrels.class,
            Bookcases.class,
            Chests.class,
            Crates.class
        ));
    }
}
