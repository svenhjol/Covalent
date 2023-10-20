package svenhjol.covalent;

import svenhjol.charmony.base.DefaultClientMod;

public class CovalentClient extends DefaultClientMod {
    public static final String MOD_ID = "covalent";
    private static CovalentClient instance;

    public static CovalentClient instance() {
        if (instance == null) {
            instance = new CovalentClient();
        }
        return instance;
    }

    @Override
    public String modId() {
        return MOD_ID;
    }
}
