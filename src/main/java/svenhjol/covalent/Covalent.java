package svenhjol.covalent;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.common.CommonMod;
import svenhjol.covalent.feature.blockus.Blockus;
import svenhjol.covalent.feature.bumblezone.Bumblezone;
import svenhjol.covalent.feature.cinderscapes.Cinderscapes;
import svenhjol.covalent.feature.promenade.Promenade;
import svenhjol.covalent.feature.terrestria.Terrestria;
import svenhjol.covalent.feature.traverse.Traverse;
import svenhjol.covalent.feature.variant_wood.VariantWood;
import svenhjol.covalent.feature.wilderwild.WilderWild;

import java.util.List;

public class Covalent extends CommonMod {
    public static final String ID = "covalent";
    public static final String CHARMONY_ID = "charmony";
    public static final String CHARM_ID = "charm";

    @Override
    public String modId() {
        return ID;
    }

    @Override
    public List<Class<? extends CommonFeature>> features() {
        return List.of(
            Blockus.class,
            Bumblezone.class,
            Cinderscapes.class,
            Promenade.class,
            Terrestria.class,
            Traverse.class,
            VariantWood.class,
            WilderWild.class
        );
    }
}
