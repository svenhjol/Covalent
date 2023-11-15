package svenhjol.covalent.feature.cinderscapes;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.feature.variant_wood.VariantWood;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.CharmonyApi;

import java.util.List;
import java.util.function.BooleanSupplier;

import static svenhjol.covalent.feature.cinderscapes.CinderscapesMaterials.Scorched;
import static svenhjol.covalent.feature.cinderscapes.CinderscapesMaterials.Umbral;

public class Cinderscapes extends CommonFeature {
    static final Scorched SCORCHED = new Scorched();
    static final Umbral UMBRAL = new Umbral();

    @Override
    public String description() {
        return "Adds chests, barrels, bookshelves and ladders for Cinderscapes woods.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(() -> ConfigHelper.isModLoaded("cinderscapes"));
    }

    @Override
    public void register() {
        var registry = mod().registry();

        SCORCHED.blockSetType = registry.blockSetType(SCORCHED);
        SCORCHED.woodType = registry.woodType(SCORCHED.getSerializedName(), SCORCHED);
        VariantWood.registerWood(registry, SCORCHED);

        UMBRAL.blockSetType = registry.blockSetType(UMBRAL);
        UMBRAL.woodType = registry.woodType(UMBRAL.getSerializedName(), UMBRAL);
        VariantWood.registerWood(registry, UMBRAL);

        CharmonyApi.registerProvider(new CinderscapesDataProvider());
    }
}