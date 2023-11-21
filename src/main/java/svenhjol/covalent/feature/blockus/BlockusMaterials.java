package svenhjol.covalent.feature.blockus;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import svenhjol.charmony_api.iface.IVariantWoodMaterial;

import java.util.function.Supplier;

public class BlockusMaterials {
    static class Charred implements IVariantWoodMaterial {
        static final String ID = Blockus.MOD_ID + "_charred";
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

    static class Legacy implements IVariantWoodMaterial {
        static final String ID = Blockus.MOD_ID + "_legacy";
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

    static class RawBamboo implements IVariantWoodMaterial {
        static final String ID = Blockus.MOD_ID + "_raw_bamboo";
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

    static class WhiteOak implements IVariantWoodMaterial {
        static final String ID = Blockus.MOD_ID + "_white_oak";
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
