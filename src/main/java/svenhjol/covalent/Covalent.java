package svenhjol.covalent;

import net.minecraftforge.fml.common.Mod;
import svenhjol.covalent.modules.*;
import svenhjol.meson.MesonMod;
import svenhjol.meson.MesonModule;

import java.util.Arrays;
import java.util.List;

@Mod(Covalent.MOD_ID)
public class Covalent extends MesonMod {
    public static final String MOD_ID = "covalent";

    public Covalent() {
        super(MOD_ID);
    }

    @Override
    protected List<Class<? extends MesonModule>> getModules() {
        return Arrays.asList(
            Atmospheric.class,
            Autumnity.class,
            BambooBlocks.class,
            Bloomful.class,
            Endergetic.class,
            Swampexpansion.class,
            UpgradeAquatic.class
        );
    }
}
