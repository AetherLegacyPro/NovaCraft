package com.NovaCraft.renderer;

import com.NovaCraftBlocks.ores.BlockReinforcedVanite;
import com.NovaCraftBlocks.potion.BlockLavaVaniteCauldron;
import com.NovaCraftBlocks.potion.BlockPotionVaniteCauldron;
import com.NovaCraftBlocks.potion.BlockVaniteCauldron;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockLavaVaniteCauldronRenderer implements ISimpleBlockRenderingHandler {

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        BlockLavaVaniteCauldron cauldron = (BlockLavaVaniteCauldron) block;
        Tessellator tessellator = Tessellator.instance;

        renderer.renderStandardBlock(block, x, y, z);

        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));

        int color = block.colorMultiplier(world, x, y, z);
        float r = (color >> 16 & 255) / 255.0F;
        float g = (color >> 8 & 255) / 255.0F;
        float b = (color & 255) / 255.0F;

        tessellator.setColorOpaque_F(r, g, b);

        IIcon side = cauldron.side;
        float f4 = 0.125F;

        renderer.renderFaceXPos(block, x - 1 + f4, y, z, side);
        renderer.renderFaceXNeg(block, x + 1 - f4, y, z, side);
        renderer.renderFaceZPos(block, x, y, z - 1 + f4, side);
        renderer.renderFaceZNeg(block, x, y, z + 1 - f4, side);

        IIcon inner = cauldron.inner;
        renderer.renderFaceYPos(block, x, y - 1 + 0.25F, z, inner);
        renderer.renderFaceYNeg(block, x, y + 1 - 0.75F, z, inner);

        // liquid level
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 0) {
        }

        if (meta == 1) {
            IIcon liquid = BlockLavaVaniteCauldron.Lava;
            float level = 0.99F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 2) {
            IIcon liquid = BlockLavaVaniteCauldron.Healing_PotionII;
            float level = 0.33F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 3) {
            IIcon liquid = BlockLavaVaniteCauldron.Healing_PotionII;
            float level = 0.66F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 4) {
            IIcon liquid = BlockLavaVaniteCauldron.Healing_PotionII;
            float level = 0.99F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 5) {
            IIcon liquid = BlockLavaVaniteCauldron.Relik_Potion;
            float level = 0.33F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 6) {
            IIcon liquid = BlockLavaVaniteCauldron.Relik_Potion;
            float level = 0.66F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 7) {
            IIcon liquid = BlockLavaVaniteCauldron.Relik_Potion;
            float level = 0.99F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 8) {
            IIcon liquid = BlockLavaVaniteCauldron.Ender_Potion;
            float level = 0.33F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 9) {
            IIcon liquid = BlockLavaVaniteCauldron.Ender_Potion;
            float level = 0.66F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 10) {
            IIcon liquid = BlockLavaVaniteCauldron.Ender_Potion;
            float level = 0.99F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 11) {
            IIcon liquid = BlockLavaVaniteCauldron.Completed_Potion;
            float level = 0.33F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 12) {
            IIcon liquid = BlockLavaVaniteCauldron.Completed_Potion;
            float level = 0.66F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 13) {
            IIcon liquid = BlockLavaVaniteCauldron.Completed_Potion;
            float level = 0.99F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 14) {
            IIcon liquid = BlockPotionVaniteCauldron.Static_Blend_Potion;
            float level = 0.66F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        if (meta == 15) {
            IIcon liquid = BlockPotionVaniteCauldron.Static_Blend_Potion;
            float level = 0.99F;
            renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
        }

        return true;
    }


    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return false;
    }

    @Override
    public int getRenderId() {
        return RenderIDs.LAVA_VANITE_CAULDRON;
    }
}
