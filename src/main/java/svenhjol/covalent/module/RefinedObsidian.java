package svenhjol.covalent.module;

import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.handler.ModuleHandler;
import svenhjol.charm.base.iface.Module;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.block.RefinedObsidianBlock;
import svenhjol.covalent.block.RefinedObsidianSlabBlock;
import svenhjol.covalent.block.RefinedObsidianStairsBlock;
import svenhjol.covalent.block.RefinedObsidianWallBlock;

import java.util.ArrayList;
import java.util.List;

@Module(mod = Covalent.MOD_ID, description = "Decorative block made by smelting obsidian.")
public class RefinedObsidian extends CharmModule {
    public static RefinedObsidianBlock REFINED_OBSIDIAN;
    public static RefinedObsidianStairsBlock REFINED_OBSIDIAN_STAIRS;
    public static RefinedObsidianWallBlock REFINED_OBSIDIAN_WALL;
    public static RefinedObsidianSlabBlock REFINED_OBSIDIAN_SLAB;

    @Override
    public void register() {
        REFINED_OBSIDIAN = new RefinedObsidianBlock(this);
        REFINED_OBSIDIAN_STAIRS = new RefinedObsidianStairsBlock(this);
        REFINED_OBSIDIAN_WALL = new RefinedObsidianWallBlock(this);
        REFINED_OBSIDIAN_SLAB = new RefinedObsidianSlabBlock(this);
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> remove = new ArrayList<>();

        if (!ModuleHandler.enabled("charm:kilns"))
            remove.add(new Identifier(Covalent.MOD_ID, "refined_obsidian/refined_obsidian_from_firing"));

        return remove;
    }
}
