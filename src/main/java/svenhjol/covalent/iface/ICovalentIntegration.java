package svenhjol.covalent.iface;

import svenhjol.charm.base.enums.IVariantMaterial;

public interface ICovalentIntegration {
    String getModId();

    IVariantMaterial[] getMaterials();

    default boolean doBarrels() { return true; }

    default boolean doBookcases() { return true; }

    default boolean doBookshelves() { return true; }

    default boolean doChests() { return true; }

    default boolean doCrates() { return true; }
}
