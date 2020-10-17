package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.RottenFleshBundleBlock;

@Module(mod = Covalent.MOD_ID, description = "Rotten flesh bundles.")
public class RottenFleshBundles extends CharmModule {
    public static RottenFleshBundleBlock ROTTEN_FLESH_BUNDLE_BLOCK;

    @Override
    public void register() {
        ROTTEN_FLESH_BUNDLE_BLOCK = new RottenFleshBundleBlock(this);
    }
}
