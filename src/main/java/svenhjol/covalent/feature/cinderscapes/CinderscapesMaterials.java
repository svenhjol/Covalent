package svenhjol.covalent.feature.cinderscapes;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import svenhjol.charmony_api.iface.IVariantWoodMaterial;

import java.util.function.Supplier;

public class CinderscapesMaterials {
    static class Scorched implements IVariantWoodMaterial {
        static final String ID = "cinderscapes_scorched";
        public Supplier<BlockSetType> blockSetType;
        public Supplier<WoodType> woodType;

        @Override
        public BlockSetType getBlockSetType() {
            return blockSetType.get();
        }

        @Override
        public WoodType getWoodType() {return woodType.get();
        }

        @Override
        public SoundType soundType() {return SoundType.WOOD;
        }

        @Override
        public String getSerializedName() {
            return ID;
        }
    }

    static class Umbral implements IVariantWoodMaterial {
        static final String ID = "cinderscapes_umbral";
        public Supplier<BlockSetType> blockSetType;
        public Supplier<WoodType> woodType;

        @Override
        public BlockSetType getBlockSetType() {
            return blockSetType.get();
        }

        @Override
        public WoodType getWoodType() {
            return woodType.get();
        }

        @Override
        public SoundType soundType() {
            return SoundType.WOOD;
        }

        @Override
        public String getSerializedName() {
            return ID;
        }
    }
}
  