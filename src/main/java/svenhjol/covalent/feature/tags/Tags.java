package svenhjol.covalent.feature.tags;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagLoader;
import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.helper.ApiHelper;
import svenhjol.charmony.helper.ResourceLocationHelper;
import svenhjol.charmony_api.event.ClientStartEvent;
import svenhjol.charmony_api.iface.IConditionalTagProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tags extends CommonFeature {
    static final Map<String, List<String>> FUZZY_REMOVES = new HashMap<>();
    static final Map<String, List<String>> EXACT_REMOVES = new HashMap<>();

    @Override
    public String description() {
        return """
            Filter tags when Charmony-mod features or settings are disabled.
            Disabling this feature may cause unexpected behavior and potential world load failure.""";
    }

    @Override
    public void runWhenEnabled() {
        ClientStartEvent.INSTANCE.handle(this::handleClientStart);
    }

    /**
     * Calculate tags to remove on client start.
     */
    private void handleClientStart(Minecraft minecraft) {
        ApiHelper.consume(IConditionalTagProvider.class,
            provider -> provider.getTagConditions().forEach(filter -> {
                if (filter.test()) return;
                filter.resources().forEach((root, entries) -> {
                    EXACT_REMOVES.computeIfAbsent(root, l -> new ArrayList<>());
                    FUZZY_REMOVES.computeIfAbsent(root, l -> new ArrayList<>());
                    entries.forEach(remove -> {
                        if (remove.contains("*") || !remove.contains(":")) {
                            FUZZY_REMOVES.get(root).add(remove);
                        } else {
                            EXACT_REMOVES.get(root).add(remove);
                        }
                    });
                });
            }));
    }

    public static List<TagLoader.EntryWithSource> filterList(String directory, ResourceLocation root, List<TagLoader.EntryWithSource> entries) {
        List<TagLoader.EntryWithSource> newEntries = new ArrayList<>();
        var match = root.getNamespace() + ":" + directory + "/" + root.getPath();
        var fuzzyRemoves = FUZZY_REMOVES.getOrDefault(match, List.of());
        var exactRemoves = EXACT_REMOVES.getOrDefault(match, List.of());

        for (var entry : entries) {
            if (!fuzzyRemoves.isEmpty() || !exactRemoves.isEmpty()) {
                var id = new ResourceLocation(entry.entry().toString());
                if (ResourceLocationHelper.match(id, exactRemoves, fuzzyRemoves)) {
                    continue;
                }
            }

            newEntries.add(entry);
        }

        return newEntries;
    }
}
