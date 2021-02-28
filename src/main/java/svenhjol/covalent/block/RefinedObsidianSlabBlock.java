package svenhjol.covalent.block;

import net.minecraft.block.SlabBlock;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.covalent.module.RefinedObsidian;

public class RefinedObsidianSlabBlock extends SlabBlock implements ICharmBlock {
    private final CharmModule module;

    public RefinedObsidianSlabBlock(CharmModule module) {
        super(Settings.copy(RefinedObsidian.REFINED_OBSIDIAN));
        this.register(module, "refined_obsidian_slab");
        this.module = module;
    }

    @Override
    public boolean enabled() {
        return module.enabled;
    }
}
