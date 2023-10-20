package svenhjol.covalent;

import svenhjol.charmony.base.DefaultMod;

public class Covalent extends DefaultMod {
    public static final String MOD_ID = "covalent";
    private static Covalent instance;

    public static Covalent instance() {
        if (instance == null) {
            instance = new Covalent();
        }
        return instance;
    }

    @Override
    public String modId() {
        return MOD_ID;
    }
}
