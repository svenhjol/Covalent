package svenhjol.covalent.feature.terrestria;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony_api.iface.IConditionalAdvancementProvider;
import svenhjol.charmony_api.iface.IConditionalRecipeProvider;
import svenhjol.covalent.base.BaseDataProvider;

public class TerrestriaDataProvider extends BaseDataProvider implements
    IConditionalRecipeProvider,
    IConditionalAdvancementProvider
{
    @Override
    protected Class<? extends CommonFeature> featureClass() {
        return Terrestria.class;
    }

    @Override
    protected String modId() {
        return Terrestria.MOD_ID;
    }
}
