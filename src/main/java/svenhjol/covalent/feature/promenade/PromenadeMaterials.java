package svenhjol.covalent.feature.promenade;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import svenhjol.charmony_api.iface.IVariantWoodMaterial;

import java.util.function.Supplier;

public class PromenadeMaterials {
    static class DarkAmaranth implements IVariantWoodMaterial {
        static final String ID = Promenade.MOD_ID + "_dark_amaranth";
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

    static class Maple implements IVariantWoodMaterial {
        static final String ID = Promenade.MOD_ID + "_maple";
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

    static class Palm implements IVariantWoodMaterial {
        static final String ID = Promenade.MOD_ID + "_palm";
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

    static class Sakura implements IVariantWoodMaterial {
        static final String ID = Promenade.MOD_ID + "_sakura";
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
