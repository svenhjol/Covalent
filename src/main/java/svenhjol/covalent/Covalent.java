package svenhjol.covalent;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.common.CommonMod;
import svenhjol.covalent.feature.bumblezone.Bumblezone;
import svenhjol.covalent.feature.terrestria.Terrestria;

import java.util.List;

public class Covalent extends CommonMod {
    public static final String ID = "covalent";

    @Override
    public String modId() {
        return ID;
    }

    @Override
    public List<Class<? extends CommonFeature>> features() {
        return List.of(
            Bumblezone.class,
            Terrestria.class
        );
    }
}
