package svenhjol.covalent;

import svenhjol.charmony.client.ClientFeature;
import svenhjol.charmony.client.ClientMod;

import java.util.List;

public class CovalentClient extends ClientMod {
    @Override
    public String modId() {
        return Covalent.ID;
    }

    @Override
    public List<Class<? extends ClientFeature>> features() {
        return List.of();
    }
}
