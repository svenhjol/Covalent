package svenhjol.covalent.feature.blockus;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony_api.iface.IConditionalAdvancementProvider;
import svenhjol.charmony_api.iface.IConditionalRecipeProvider;
import svenhjol.covalent.base.BaseDataProvider;

public class BlockusDataProvider extends BaseDataProvider implements
        IConditionalRecipeProvider,
        IConditionalAdvancementProvider
{
    @Override
    protected Class<? extends CommonFeature> featureClass() {
        return Blockus.class;
    }

    @Override
    protected String modId() { return Blockus.MOD_ID; }
}
