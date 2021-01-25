package svenhjol.covalent.integration;

import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.covalent.iface.ICovalentIntegration;

public class Covalent implements ICovalentIntegration {

    @Override
    public String getModId() {
        return svenhjol.covalent.Covalent.MOD_ID;
    }

    @Override
    public IVariantMaterial[] getMaterials() {
        return Materials.values();
    }

    public enum Materials implements IVariantMaterial {
        BAMBOO
    }
}
