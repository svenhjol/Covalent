package svenhjol.covalent.terrestria;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;

@Module(mod = Covalent.MOD_ID, description = "Terrestria integration")
public class Terrestria extends CharmModule {
    @Override
    public boolean depends() {
        return ModHelper.isLoaded("terrestria");
    }
}
