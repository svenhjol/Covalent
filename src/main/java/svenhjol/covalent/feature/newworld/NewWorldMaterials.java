package svenhjol.covalent.feature.newworld;


import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import svenhjol.charmony_api.iface.IVariantWoodMaterial;

import java.util.function.Supplier;

public class NewWorldMaterials {
    static class Fir implements IVariantWoodMaterial {
        static final String ID = NewWorld.MOD_ID + "_fir";
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
