package svenhjol.covalent.mixin.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagLoader;
import net.minecraft.util.DependencySorter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import svenhjol.covalent.feature.tags.Tags;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mixin(TagLoader.class)
public class TagLoaderMixin {
    @Shadow @Final private String directory;
    @Unique
    private static String currentDirectory = ""; // Capture the current tags directory.

    @Inject(
        method = "build(Ljava/util/Map;)Ljava/util/Map;",
        at = @At("HEAD")
    )
    private <T> void hookBuild(Map<ResourceLocation, List<TagLoader.EntryWithSource>> map, CallbackInfoReturnable<Map<ResourceLocation, Collection<T>>> cir) {
        currentDirectory = directory;
    }

    @Inject(
        method = "method_51477",
        at = @At("HEAD"),
        cancellable = true,
        locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void filterEntries(DependencySorter<ResourceLocation, TagLoader.SortingEntry> dependencySorter, ResourceLocation root, List<TagLoader.EntryWithSource> entries, CallbackInfo ci) {
        var newEntries = Tags.filterList(currentDirectory, root, entries);
        if (newEntries.size() != entries.size()) {
            dependencySorter.addEntry(root, new TagLoader.SortingEntry(newEntries));
            ci.cancel();
        }
    }
}
