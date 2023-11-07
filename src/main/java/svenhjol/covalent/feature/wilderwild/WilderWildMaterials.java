package svenhjol.covalent.feature.wilderwild;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import svenhjol.charmony_api.iface.IVariantWoodMaterial;

import java.util.function.Supplier;

public class WilderWildMaterials {
    static class Baobab implements IVariantWoodMaterial {
        static final String ID = "wilderwild_baobab";
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

    static class Cypress implements IVariantWoodMaterial {
        static final String ID = "wilderwild_cypress";
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
        static final String ID = "wilderwild_palm";
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
