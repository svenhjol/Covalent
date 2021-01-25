package svenhjol.covalent;

import svenhjol.charm.base.enums.IVariantMaterial;
import svenhjol.charm.base.helper.ModHelper;
import svenhjol.covalent.iface.ICovalentIntegration;
import svenhjol.covalent.integration.Covalent;
import svenhjol.covalent.integration.*;

import java.util.*;

public class CovalentIntegration {
    public static List<ICovalentIntegration> MODS = new ArrayList<>();

    public static void init() {
        MODS.add(new Covalent());
        MODS.add(new Coranthemum());
        MODS.add(new Terrestria());
        MODS.add(new Traverse());
        MODS.add(new WildExplorer());
        MODS.add(new BetterEnd());
    }

    public static List<IVariantMaterial> getMaterialsToRemove() {
        List<IVariantMaterial> materialsToRemove = new ArrayList<>();

        CovalentIntegration.MODS.forEach(mod -> {
            if (!ModHelper.isLoaded(mod.getModId()))
                materialsToRemove.addAll(Arrays.asList(mod.getMaterials()));
        });

        return materialsToRemove;
    }
}
