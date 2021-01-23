package svenhjol.covalent;

import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.covalent.integration.*;
import svenhjol.covalent.integration.Covalent;

import java.util.*;

public class CovalentIntegration {
    public static Map<String, IVariantMaterial[]> MODS = new HashMap<>();

    public static void init() {
        MODS.put(Covalent.MOD_ID, Covalent.Materials.values());
        MODS.put(Coranthemum.MOD_ID, Coranthemum.Materials.values());
        MODS.put(Terrestria.MOD_ID, Terrestria.Materials.values());
        MODS.put(Traverse.MOD_ID, Traverse.Materials.values());
        MODS.put(WildExplorer.MOD_ID, WildExplorer.Materials.values());
        MODS.put(BetterEnd.MOD_ID, BetterEnd.Materials.values());
    }

    public static List<IVariantMaterial> getMaterialsToRemove() {
        List<IVariantMaterial> materialsToRemove = new ArrayList<>();

        CovalentIntegration.MODS.forEach((mod, materials) -> {
            if (!ModHelper.isLoaded(mod))
                materialsToRemove.addAll(Arrays.asList(materials));
        });

        return materialsToRemove;
    }
}
