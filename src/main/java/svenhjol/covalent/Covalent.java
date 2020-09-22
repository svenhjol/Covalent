package svenhjol.covalent;

import svenhjol.covalent.module.StorageBlocks;
import svenhjol.covalent.module.VariantLanterns;
import svenhjol.meson.MesonMod;
import svenhjol.meson.MesonModule;

import java.util.Arrays;
import java.util.List;

public class Covalent extends MesonMod {
    public static String MOD_ID = "covalent";

    @Override
    public void onInitialize() {
        super.init(MOD_ID);
    }

    @Override
    protected List<Class<? extends MesonModule>> getModules() {
        return Arrays.asList(
            StorageBlocks.class,
            VariantLanterns.class
        );
    }
}
