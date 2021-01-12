package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.BookcaseBlock;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.integration.Coranthemum;
import svenhjol.covalent.integration.Terrestria;
import svenhjol.covalent.integration.Traverse;
import svenhjol.covalent.integration.WildExplorer;

@Module(mod = Covalent.MOD_ID, description = "Bookcases for all supported Minecraft mods.")
public class Bookcases extends CharmModule {
    @Override
    public void register() {

        // coranthemum
        for (Coranthemum.Materials material : Coranthemum.Materials.values()) {
            new BookcaseBlock(this, material, Coranthemum.MOD_ID);
        }

        // terrestria
        for (Terrestria.Materials material : Terrestria.Materials.values()) {
            new BookcaseBlock(this, material, Terrestria.MOD_ID);
        }

        // traverse
        for (Traverse.Materials material : Traverse.Materials.values()) {
            new BookcaseBlock(this, material, Traverse.MOD_ID);
        }

        // wild_explorer
        for (WildExplorer.Materials material : WildExplorer.Materials.values()) {
            new BookcaseBlock(this, material, WildExplorer.MOD_ID);
        }

    }
}
