package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;

@Module(mod = Covalent.MOD_ID, description = "Terrestria integration")
public class TerrestriaIntegration extends CharmModule {
    @Override
    public boolean depends() {
        return ModHelper.isLoaded("terrestria");
    }
}
