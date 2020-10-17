package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.BambooBundleBlock;

@Module(mod = Covalent.MOD_ID, description = "Bamboo bundles.")
public class BambooBundles extends CharmModule {
    public static BambooBundleBlock BAMBOO_BUNDLE_BLOCK;

    @Override
    public void register() {
        BAMBOO_BUNDLE_BLOCK = new BambooBundleBlock(this);
    }
}
