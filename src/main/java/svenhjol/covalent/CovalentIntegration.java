package svenhjol.covalent;

import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.covalent.integration.Coranthemum;
import svenhjol.covalent.integration.Terrestria;
import svenhjol.covalent.integration.Traverse;
import svenhjol.covalent.integration.WildExplorer;

import java.util.*;

public class CovalentIntegration {
    public static Map<String, IVariantMaterial[]> MODS = new HashMap<>();

    public static void init() {
        MODS.put(Coranthemum.MOD_ID, Coranthemum.Materials.values());
        MODS.put(Terrestria.MOD_ID, Terrestria.Materials.values());
        MODS.put(Traverse.MOD_ID, Traverse.Materials.values());
        MODS.put(WildExplorer.MOD_ID, WildExplorer.Materials.values());
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
