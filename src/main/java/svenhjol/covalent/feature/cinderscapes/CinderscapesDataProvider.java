package svenhjol.covalent.feature.cinderscapes;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony_api.iface.IConditionalAdvancementProvider;
import svenhjol.charmony_api.iface.IConditionalRecipeProvider;
import svenhjol.covalent.base.BaseDataProvider;

public class CinderscapesDataProvider extends BaseDataProvider implements
    IConditionalRecipeProvider,
    IConditionalAdvancementProvider
{
    @Override
    protected Class<? extends CommonFeature> featureClass() {
        return Cinderscapes.class;
    }

    @Override
    protected String featurePrefix() {
        return "cinderscapes";
    }
}
