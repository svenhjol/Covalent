package svenhjol.covalent.block;

import net.minecraft.block.WallBlock;
import net.minecraft.item.ItemGroup;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.block.ICharmBlock;
import svenhjol.covalent.module.RefinedObsidian;

public class RefinedObsidianWallBlock extends WallBlock implements ICharmBlock {
    private final CharmModule module;

    public RefinedObsidianWallBlock(CharmModule module) {
        super(Settings.copy(RefinedObsidian.REFINED_OBSIDIAN));
        this.register(module, "refined_obsidian_wall");
        this.module = module;
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.DECORATIONS;
    }

    @Override
    public boolean enabled() {
        return module.enabled;
    }
}
