package svenhjol.covalent.module;

import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.charm.module.VariantBarrels;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.CovalentIntegration;

import java.util.ArrayList;
import java.util.List;

@Module(mod = Covalent.MOD_ID, description = "Barrels for all supported minecraft integration.")
public class CovalentBarrels extends CharmModule {
    @Override
    public void register() {
        CovalentIntegration.MODS.forEach(mod -> {
            if (mod.doBarrels()) {
                for (IVariantMaterial material : mod.getMaterials()) {
                    VariantBarrels.BARREL_BLOCKS.put(material, new VariantBarrelBlock(this, material, mod.getModId()));
                }
            }
        });
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> recipes = new ArrayList<>();

        for (IVariantMaterial material : CovalentIntegration.getMaterialsToRemove()) {
            recipes.add(new Identifier(Covalent.MOD_ID, "covalent_barrels/" + material.asString() + "_barrel"));
        }

        return recipes;
    }
}
