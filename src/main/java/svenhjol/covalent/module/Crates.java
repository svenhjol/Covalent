package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.CrateBlock;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.integration.Coranthemum;
import svenhjol.covalent.integration.Terrestria;
import svenhjol.covalent.integration.Traverse;
import svenhjol.covalent.integration.WildExplorer;

import java.util.ArrayList;
import java.util.List;

@Module(mod = Covalent.MOD_ID, description = "Crates for all supported Minecraft mods.")
public class Crates extends CharmModule {
    public static List<CrateBlock> CRATES = new ArrayList<>();

    @Override
    public void register() {

        // coranthemum
        for (Coranthemum.Materials material : Coranthemum.Materials.values()) {
            CRATES.add(new CrateBlock(this, material, Coranthemum.MOD_ID));
        }

        // terrestria
        for (Terrestria.Materials material : Terrestria.Materials.values()) {
            CRATES.add(new CrateBlock(this, material, Terrestria.MOD_ID));
        }

        // traverse
        for (Traverse.Materials material : Traverse.Materials.values()) {
            CRATES.add(new CrateBlock(this, material, Traverse.MOD_ID));
        }

        // wild_explorer
        for (WildExplorer.Materials material : WildExplorer.Materials.values()) {
            CRATES.add(new CrateBlock(this, material, WildExplorer.MOD_ID));
        }
    }
}
