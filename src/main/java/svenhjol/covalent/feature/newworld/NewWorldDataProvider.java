package svenhjol.covalent.feature.newworld;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony_api.iface.IConditionalAdvancementProvider;
import svenhjol.charmony_api.iface.IConditionalRecipeProvider;
import svenhjol.covalent.base.BaseDataProvider;
import svenhjol.covalent.feature.newworld.NewWorld;

public class NewWorldDataProvider extends BaseDataProvider implements
        IConditionalRecipeProvider,
        IConditionalAdvancementProvider
{
    @Override
    protected Class<? extends CommonFeature> featureClass() {
        return NewWorld.class;
    }

    @Override
    protected String modId() {
        return NewWorld.MOD_ID;
    }
}
