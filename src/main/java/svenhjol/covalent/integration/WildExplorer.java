package svenhjol.covalent.integration;

import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.covalent.iface.ICovalentIntegration;

public class WildExplorer implements ICovalentIntegration {

    @Override
    public String getModId() {
        return "wild_explorer";
    }

    @Override
    public IVariantMaterial[] getMaterials() {
        return Materials.values();
    }

    public enum Materials implements IVariantMaterial {
        CHERRY_OAK,
        DARK_AMARANTH,
        PALM
    }
}
