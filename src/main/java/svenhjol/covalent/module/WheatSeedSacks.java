package svenhjol.covalent.module;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.WheatSeedSackBlock;

@Module(mod = Covalent.MOD_ID, description = "Wheat seed sacks.")
public class WheatSeedSacks extends CharmModule {
    public static WheatSeedSackBlock WHEAT_SEED_SACK_BLOCK;

    @Override
    public void register() {
        WHEAT_SEED_SACK_BLOCK = new WheatSeedSackBlock(this);
    }
}
