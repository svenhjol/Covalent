package svenhjol.covalent;

import net.minecraftforge.fml.common.Mod;
import svenhjol.meson.MesonInstance;
import svenhjol.meson.handler.LogHandler;

@Mod(Covalent.MOD_ID)
public class Covalent extends MesonInstance {
    public static final String MOD_ID = "covalent";
    public static final LogHandler LOG = new LogHandler(Covalent.MOD_ID);

    public Covalent() {
        super(Covalent.MOD_ID, LOG);
    }
}
