package svenhjol.covalent.mixin;

import svenhjol.charmony.base.CharmonyMixinConfigPlugin;
import svenhjol.covalent.Covalent;

public class MixinConfigPlugin extends CharmonyMixinConfigPlugin {
    @Override
    protected String modId() {
        return Covalent.ID;
    }
}
