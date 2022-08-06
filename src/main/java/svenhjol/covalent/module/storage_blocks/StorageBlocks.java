package svenhjol.covalent.module.storage_blocks;

import svenhjol.charm.annotation.CommonModule;
import svenhjol.charm.annotation.Config;
import svenhjol.charm.loader.CharmModule;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.module.storage_blocks.block.BambooStorageBlock;

@CommonModule(mod = Covalent.MOD_ID)
public class StorageBlocks extends CharmModule {
    public static BambooStorageBlock BAMBOO_STORAGE_BLOCK;

    @Config(name = "Bamboo bundle", description = "If true, the Bamboo Bundle block will be craftable.")
    public static boolean enableBambooBundle = true;

    @Override
    public void register() {
        BAMBOO_STORAGE_BLOCK = new BambooStorageBlock(this);
    }
}
