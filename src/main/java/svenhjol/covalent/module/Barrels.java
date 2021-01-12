package svenhjol.covalent.module;

import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.handler.RegistryHandler;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.integration.Coranthemum;
import svenhjol.covalent.integration.Terrestria;
import svenhjol.covalent.integration.Traverse;
import svenhjol.covalent.integration.WildExplorer;

@Module(mod = Covalent.MOD_ID, description = "Barrels for all supported minecraft mods.")
public class Barrels extends CharmModule {
    public static final Identifier ID = new Identifier(Covalent.MOD_ID, "barrel");
    public static BlockEntityType<BarrelBlockEntity> BLOCK_ENTITY;

    @Override
    public void register() {

        // coranthemum
        for (Coranthemum.Materials material : Coranthemum.Materials.values()) {
            new VariantBarrelBlock(this, material, Coranthemum.MOD_ID);
        }

        // terrestria
        for (Terrestria.Materials material : Terrestria.Materials.values()) {
            new VariantBarrelBlock(this, material, Terrestria.MOD_ID);
        }

        // traverse
        for (Traverse.Materials material : Traverse.Materials.values()) {
            new VariantBarrelBlock(this, material, Traverse.MOD_ID);
        }

        // wild_explorer
        for (WildExplorer.Materials material : WildExplorer.Materials.values()) {
            new VariantBarrelBlock(this, material, WildExplorer.MOD_ID);
        }


        BLOCK_ENTITY = RegistryHandler.blockEntity(ID, BarrelBlockEntity::new);
    }
}
