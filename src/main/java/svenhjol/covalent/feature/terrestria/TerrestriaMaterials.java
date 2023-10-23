package svenhjol.covalent.feature.terrestria;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import svenhjol.charmony_api.iface.IVariantWoodMaterial;

import java.util.function.Supplier;

public class TerrestriaMaterials {
    static class Rubber implements IVariantWoodMaterial {
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
            return "rubber";
        }
    }

    static class Sakura implements IVariantWoodMaterial {
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
            return "sakura";
        }
    }

    static class YuccaPalm implements IVariantWoodMaterial {
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
            return "yucca_palm";
        }
    }

    static class Willow implements IVariantWoodMaterial {
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
            return "willow";
        }
    }

    static class Cypress implements IVariantWoodMaterial {
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
            return "cypress";
        }
    }

    static class Hemlock implements IVariantWoodMaterial {
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
            return "hemlock";
        }
    }

    static class Redwood implements IVariantWoodMaterial {
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
            return "redwood";
        }
    }

    static class JapaneseMaple implements IVariantWoodMaterial {
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
            return "japanese_maple";
        }
    }

    static class RainbowEucalyptus implements IVariantWoodMaterial {
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
            return "rainbow_eucalyptus";
        }
    }
}