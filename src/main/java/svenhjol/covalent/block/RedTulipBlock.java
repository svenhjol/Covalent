
package svenhjol.covalent.block;

        import net.minecraft.block.AbstractBlock;
        import net.minecraft.block.Blocks;
        import svenhjol.covalent.module.StorageBlocks;
        import svenhjol.meson.MesonModule;
        import svenhjol.meson.block.MesonBlock;

        public class RedTulipBlock extends MesonBlock {
            public RedTulipBlock(MesonModule module) {
        super(module, "red_tulip_block", AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK));
        }

        @Override
        public boolean enabled() {
        return module.enabled && StorageBlocks.redTulip;
        }
        }
