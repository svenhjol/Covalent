package svenhjol.covalent;

import svenhjol.charmony.base.Mods;
import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.common.CommonMod;
import svenhjol.covalent.feature.bumblezone.Bumblezone;
import svenhjol.covalent.feature.cinderscapes.Cinderscapes;
import svenhjol.covalent.feature.terrestria.Terrestria;
import svenhjol.covalent.feature.traverse.Traverse;

import java.util.List;

public class Covalent extends CommonMod {
    public static final String ID = "covalent";
    public static final String CHARM_ID = "charm";

    @Override
    public String modId() {
        return ID;
    }

    @Override
    public List<Class<? extends CommonFeature>> features() {
        return List.of(
            Bumblezone.class,
            Cinderscapes.class,
            Terrestria.class,
            Traverse.class
        );
    }

    public static boolean isVariantWoodEnabled() {
        return Mods.optionalCommon(Covalent.CHARM_ID).map(
            charm -> charm.loader().isEnabled("VariantWood")).orElse(false);
    }
}
