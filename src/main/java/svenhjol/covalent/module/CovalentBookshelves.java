package svenhjol.covalent.module;

import net.minecraft.util.Identifier;
import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.VariantBookshelfBlock;
import svenhjol.charm.module.VariantBookshelves;
import svenhjol.covalent.Covalent;
import svenhjol.covalent.CovalentIntegration;

import java.util.ArrayList;
import java.util.List;

@Module(mod = Covalent.MOD_ID, description = "Bookshelves for all supported Minecraft integration.")
public class CovalentBookshelves extends CharmModule {
    @Override
    public void register() {
        CovalentIntegration.MODS.forEach(mod -> {
            if (mod.doBookshelves()) {
                for (IVariantMaterial material : mod.getMaterials()) {
                    VariantBookshelves.BOOKSHELF_BLOCKS.put(material, new VariantBookshelfBlock(this, material, mod.getModId()));
                }
            }
        });
    }

    @Override
    public List<Identifier> getRecipesToRemove() {
        List<Identifier> recipes = new ArrayList<>();

        for (IVariantMaterial material : CovalentIntegration.getMaterialsToRemove()) {
            recipes.add(new Identifier(Covalent.MOD_ID, "covalent_bookshelves/" + material.asString() + "_bookshelf"));
        }

        return recipes;
    }
}
