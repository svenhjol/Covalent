package svenhjol.covalent.feature.traverse;

import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony_api.iface.IConditionalAdvancementProvider;
import svenhjol.charmony_api.iface.IConditionalRecipeProvider;
import svenhjol.covalent.base.BaseDataProvider;

public class TraverseDataProvider extends BaseDataProvider implements
    IConditionalRecipeProvider,
    IConditionalAdvancementProvider
{
    @Override
    protected Class<? extends CommonFeature> featureClass() {
        return Traverse.class;
    }

    @Override
    protected String featurePrefix() {
        return "traverse";
    }
}
