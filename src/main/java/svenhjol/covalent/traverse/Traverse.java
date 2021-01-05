package svenhjol.covalent.traverse;

import svenhjol.charm.base.CharmModule;
import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.charm.base.iface.Module;
import svenhjol.charm.block.BookcaseBlock;
import svenhjol.charm.block.CrateBlock;
import svenhjol.charm.block.VariantBarrelBlock;
import svenhjol.covalent.Covalent;

@Module(mod = Covalent.MOD_ID, description = "Traverse integration")
public class Traverse extends CharmModule {

    public static VariantBarrelBlock FIR_BARREL;
    public static BookcaseBlock FIR_BOOKCASE;
    public static CrateBlock FIR_CRATE;

    @Override
    public void register() {
        IVariantMaterial fir = TraverseMaterial.FIR;

        FIR_BARREL = new VariantBarrelBlock(this, fir);
        FIR_BOOKCASE = new BookcaseBlock(this, fir);
        FIR_CRATE = new CrateBlock(this, fir);
    }
    @Override
    public boolean depends() {
        return ModHelper.isLoaded("traverse");
    }
}
