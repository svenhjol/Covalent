package svenhjol.covalent.integration;

import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.covalent.iface.ICovalentIntegration;

public class Terrestria implements ICovalentIntegration {

    @Override
    public String getModId() {
        return "terrestria";
    }

    @Override
    public IVariantMaterial[] getMaterials() {
        return Materials.values();
    }

    public enum Materials implements IVariantMaterial {
        CYPRESS,
        HEMLOCK,
        JAPANESE_MAPLE,
        RAINBOW_EUCALYPTUS,
        REDWOOD,
        RUBBER,
        SAKURA,
        WILLOW,
        YUCCA_PALM
    }
}


