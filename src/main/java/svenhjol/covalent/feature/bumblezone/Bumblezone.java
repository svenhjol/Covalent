package svenhjol.covalent.feature.bumblezone;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import svenhjol.charmony.common.CommonFeature;
import svenhjol.charmony.helper.ConfigHelper;
import svenhjol.charmony_api.enums.EventResult;
import svenhjol.charmony_api.event.SugarDissolveEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BooleanSupplier;

public class Bumblezone extends CommonFeature {
    static final String MOD_ID = "the_bumblezone";
    static final ResourceLocation FLUID_ID = new ResourceLocation(MOD_ID, "sugar_water_block");
    static Block bumblezoneFluid = null;

    @Override
    public String description() {
        return "This allows water to be replaced with sugar water when a Charm sugar block is dissolved.";
    }

    @Override
    public List<BooleanSupplier> checks() {
        return List.of(
            () -> ConfigHelper.isModLoaded(MOD_ID));
    }

    @Override
    public void runWhenEnabled() {
        bumblezoneFluid = BuiltInRegistries.BLOCK.get(FLUID_ID);

        // The priority must be higher than Charm's for this to function.
        SugarDissolveEvent.INSTANCE.handle(this::handleSugarDissolve, 10);
    }

    private EventResult handleSugarDissolve(Level level, BlockPos pos) {
        level.setBlock(pos, bumblezoneFluid.defaultBlockState(), 3);

        // Find all water blocks in contact recursively. Uses a set since we do not need duplicate positions
        Set<BlockPos> positionsToChange = recursiveReplaceWater(level, pos, 0, 3, new HashSet<>());

        // Now change to sugar water after we found all water in range. Prevents weird shapes from being made when we delay this
        positionsToChange.forEach(waterPos -> level.setBlock(waterPos, bumblezoneFluid.defaultBlockState(), 3));

        // Don't let Charm do any further processing on this.
        return EventResult.CANCEL;
    }

    /**
     * Will recursively track down and replace touching water blocks with bumblezone fluid.
     * Do not set the maxDepth too high!
     * @return - waterPos
     */
    public static Set<BlockPos> recursiveReplaceWater(Level level, BlockPos pos, int depth, int maxDepth, HashSet<BlockPos> waterPos){
        // exit when we hit as far as we wanted
        if (depth == maxDepth) {
            return waterPos;
        }

        // Find the touching water blocks, replace them, and call this method on those blocks
        BlockPos.MutableBlockPos neighborPos = new BlockPos.MutableBlockPos();
        for (var facing : Direction.values()) {
            neighborPos.set(pos).move(facing);
            var neighborBlock = level.getBlockState(neighborPos);

            // Found watery block to replace, store the position of the water
            if (!neighborBlock.getBlock().equals(bumblezoneFluid)
                && neighborBlock.is(Blocks.WATER)
                && neighborBlock.getFluidState().isSource())
            {
                waterPos.add(neighborPos.immutable());
                recursiveReplaceWater(level, neighborPos, depth + 1, maxDepth, waterPos);
            }
        }

        return waterPos;
    }
}
