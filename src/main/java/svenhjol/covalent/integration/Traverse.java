package svenhjol.covalent.integration;

import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.covalent.iface.ICovalentIntegration;

public class Traverse implements ICovalentIntegration {

    @Override
    public String getModId() {
        return "traverse";
    }

    @Override
    public IVariantMaterial[] getMaterials() {
        return Materials.values();
    }

    public enum Materials implements IVariantMaterial {
        FIR
    }
}
