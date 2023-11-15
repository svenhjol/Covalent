package svenhjol.covalent.feature.promenade;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony_api.iface.IConditionalAdvancementProvider;
import svenhjol.charmony_api.iface.IConditionalRecipeProvider;
import svenhjol.covalent.base.BaseDataProvider;

public class PromenadeDataProvider extends BaseDataProvider implements
    IConditionalRecipeProvider,
    IConditionalAdvancementProvider
{
    @Override
    protected Class<? extends CommonFeature> featureClass() {
        return Promenade.class;
    }

    @Override
    protected String modId() {
        return Promenade.MOD_ID;
    }
}
