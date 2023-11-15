package svenhjol.covalent.feature.wilderwild;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony_api.iface.IConditionalAdvancementProvider;
import svenhjol.charmony_api.iface.IConditionalRecipeProvider;
import svenhjol.covalent.base.BaseDataProvider;
import svenhjol.covalent.feature.cinderscapes.Cinderscapes;

public class WilderWildDataProvider extends BaseDataProvider implements
    IConditionalRecipeProvider,
    IConditionalAdvancementProvider
{
    @Override
    protected Class<? extends CommonFeature> featureClass() {
        return WilderWild.class;
    }

    @Override
    protected String featurePrefix() {
        return "wilderwild";
    }
}
