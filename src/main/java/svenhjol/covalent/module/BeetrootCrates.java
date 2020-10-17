package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.BeetrootCrateBlock;

@Module(mod = Covalent.MOD_ID, description = "Beetroot crates.")
public class BeetrootCrates extends CharmModule {
    public static BeetrootCrateBlock BEETROOT_CRATE_BLOCK;

    @Override
    public void register() {
        BEETROOT_CRATE_BLOCK = new BeetrootCrateBlock(this);
    }
}
