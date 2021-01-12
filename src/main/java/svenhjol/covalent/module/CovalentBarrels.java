package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.charm.module.VariantBarrels;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.integration.Coranthemum;
import svenhjol.covalent.integration.Terrestria;
import svenhjol.covalent.integration.Traverse;
import svenhjol.covalent.integration.WildExplorer;

@Module(mod = Covalent.MOD_ID, description = "Barrels for all supported minecraft integration.")
public class CovalentBarrels extends CharmModule {
    @Override
    public void register() {

        // coranthemum
        for (Coranthemum.Materials material : Coranthemum.Materials.values()) {
            VariantBarrels.BARREL_BLOCKS.put(material, new VariantBarrelBlock(this, material, Coranthemum.MOD_ID));
        }

        // terrestria
        for (Terrestria.Materials material : Terrestria.Materials.values()) {
            VariantBarrels.BARREL_BLOCKS.put(material, new VariantBarrelBlock(this, material, Terrestria.MOD_ID));
        }

        // traverse
        for (Traverse.Materials material : Traverse.Materials.values()) {
            VariantBarrels.BARREL_BLOCKS.put(material, new VariantBarrelBlock(this, material, Traverse.MOD_ID));
        }

        // wild_explorer
        for (WildExplorer.Materials material : WildExplorer.Materials.values()) {
            VariantBarrels.BARREL_BLOCKS.put(material, new VariantBarrelBlock(this, material, WildExplorer.MOD_ID));
        }
    }
}
