package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.CarrotCrateBlock;

@Module(mod = Covalent.MOD_ID, description = "Carrot crates.")
public class CarrotCrates extends CharmModule {
    public static CarrotCrateBlock CARROT_CRATE_BLOCK;

    @Override
    public void register() {
        CARROT_CRATE_BLOCK = new CarrotCrateBlock(this);
    }
}
