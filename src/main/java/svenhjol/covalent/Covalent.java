package svenhjol.covalent;
import svenhjol.charm.Charm;
import svenhjol.charm.base.CharmLoader;
import net.fabricmc.api.ModInitializer;
import svenhjol.covalent.terrestria.Terrestria;
import svenhjol.covalent.traverse.Traverse;
import svenhjol.covalent.wild_explorer.WildExplorer;

import java.util.Arrays;

public class Covalent implements ModInitializer {
    public static final String MOD_ID = "covalent";

    @Override
    public void onInitialize() {
        Charm.runFirst();

        new CharmLoader(MOD_ID, Arrays.asList(
            Terrestria.class,
            Traverse.class,
            WildExplorer.class
        ));
    }
}
