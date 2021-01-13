package svenhjol.covalent.module;

import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.BookcaseBlock;
import svenhjol.charm.module.Bookcases;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.CovalentIntegration;

import java.util.ArrayList;
import java.util.List;

@Module(mod = Covalent.MOD_ID, description = "Bookcases for all supported Minecraft integration.")
public class CovalentBookcases extends CharmModule {
    @Override
    public void register() {
        CovalentIntegration.MODS.forEach((mod, materials) -> {
            for (IVariantMaterial material : materials) {
                Bookcases.BOOKCASE_BLOCKS.put(material, new BookcaseBlock(this, material, mod));
            }
        });
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> recipes = new ArrayList<>();

        for (IVariantMaterial material : CovalentIntegration.getMaterialsToRemove()) {
            recipes.add(new Identifier(Covalent.MOD_ID, "covalent_bookcases/" + material.asString() + "_bookcase"));
        }

        return recipes;
    }
}
