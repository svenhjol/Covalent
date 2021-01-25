package svenhjol.covalent.integration;

import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.covalent.iface.ICovalentIntegration;

public class BetterEnd implements ICovalentIntegration {

    @Override
    public String getModId() {
        return "better-end";
    }

    @Override
    public IVariantMaterial[] getMaterials() {
        return Materials.values();
    }

    @Override
    public boolean doBarrels() {
        return false;
    }

    @Override
    public boolean doBookshelves() {
        return false;
    }

    @Override
    public boolean doChests() {
        return false;
    }

    public enum Materials implements IVariantMaterial {
        MOSSY_GLOWSHROOM,
        TENANEA,
        END_LOTUS,
        LACUGROVE,
        HELIX_TREE,
        DRAGON_TREE,
        PYTHADENDRON,
        UMBRELLA_TREE
    }
}


