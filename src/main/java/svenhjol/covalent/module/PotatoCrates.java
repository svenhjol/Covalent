package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.PotatoCrateBlock;

@Module(mod = Covalent.MOD_ID, description = "Potato crates.")
public class PotatoCrates extends CharmModule {
    public static PotatoCrateBlock POTATO_CRATE_BLOCK;

    @Override
    public void register() {
        POTATO_CRATE_BLOCK = new PotatoCrateBlock(this);
    }
}
