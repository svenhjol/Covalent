package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.EggCrateBlock;

@Module(mod = Covalent.MOD_ID, description = "Egg crates.")
public class EggCrates extends CharmModule {
    public static EggCrateBlock EGG_CRATE_BLOCK;

    @Override
    public void register() {
        EGG_CRATE_BLOCK = new EggCrateBlock(this);
    }
}
