package svenhjol.covalent.base;

import svenhjol.charmony.base.Mods;
import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.common.CommonLoader;
import svenhjol.charmony_api.iface.*;
import svenhjol.covalent.Covalent;

import java.util.List;

public abstract class BaseDataProvider implements
    IConditionalRecipeProvider,
    IConditionalAdvancementProvider
{
    protected abstract Class<? extends CommonFeature> featureClass();

    protected abstract String featurePrefix();

    @Override
    public List<IConditionalAdvancement> getAdvancementConditions() {
        return List.of(
            new IConditionalAdvancement() {
                @Override
                public boolean test() {
                    return Covalent.isVariantWoodEnabled() && loader().isEnabled(featureClass());
                }

                @Override
                public List<String> advancements() {
                    return List.of(
                        "variant_wood/*" + featurePrefix() + "_*"
                    );
                }
            }
        );
    }

    @Override
    public List<IConditionalRecipe> getRecipeConditions() {
        return List.of(
            new IConditionalRecipe() {
                @Override
                public boolean test() {
                    return Covalent.isVariantWoodEnabled() && loader().isEnabled(featureClass());
                }

                @Override
                public List<String> recipes() {
                    return List.of(
                        "variant_wood/*" + featurePrefix() + "_*"
                    );
                }
            }
        );
    }

    protected static CommonLoader loader() {
        return Mods.common(Covalent.ID).loader();
    }
}
