package com.NovaCraft.renderer;

import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.ores.BlockReinforcedVanite;
import com.NovaCraftBlocks.potion.BlockMoltenVanite;
import com.NovaCraftBlocks.potion.BlockMoltenVaniteCauldron;
import com.NovaCraftBlocks.potion.BlockMoltenVaniteCrystalCauldron;
import com.NovaCraftBlocks.potion.BlockVaniteCauldron;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockMoltenCrystalCauldronRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		BlockMoltenVaniteCrystalCauldron cauldron = (BlockMoltenVaniteCrystalCauldron) block;

        IIcon side = cauldron.side;
        IIcon bottom = cauldron.bottom;
        IIcon inner = cauldron.inner;

        double wallHeight = 1.0D;
        double wallThickness = 0.125D;

        double innerMin = wallThickness;
        double innerMax = 1.0D - wallThickness;
        double innerBottomY = wallThickness;

        final double epsilon = 0.002D;

        //Outer bottom
        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, wallThickness, 1.0D);
        //renderer.renderFaceYNeg(block, x, y, z, bottom); //bottom
        renderer.renderFaceYPos(block, x, y, z, side);
        renderer.renderFaceXNeg(block, x, y, z, side);
        renderer.renderFaceXPos(block, x, y, z, side);
        renderer.renderFaceZNeg(block, x, y, z, side);
        renderer.renderFaceZPos(block, x, y, z, side);

        //Outer walls
        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, wallThickness, wallHeight, 1.0D); //west
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(1.0D - wallThickness, 0.0D, 0.0D, 1.0D, wallHeight, 1.0D); //east
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(wallThickness, 0.0D, 0.0D, 1.0D - wallThickness, wallHeight, wallThickness); //north
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(wallThickness, 0.0D, 1.0D - wallThickness, 1.0D - wallThickness, wallHeight, 1.0D); //south
        renderer.renderStandardBlock(block, x, y, z);

        //Inner bottom
        renderer.setRenderBounds(innerMin, innerBottomY, innerMin, innerMax, innerBottomY + 0.001D, innerMax);
        renderer.renderFaceYPos(block, x, y + innerBottomY, z, inner);

        //Inner vertical walls
        renderer.setRenderBounds(innerMin + epsilon, innerBottomY, innerMin, innerMin + epsilon * 2, 1.0D, innerMax);
        renderer.renderFaceXPos(block, x, y, z, inner);

        renderer.setRenderBounds(innerMax - epsilon * 2, innerBottomY, innerMin, innerMax - epsilon, 1.0D, innerMax);
        renderer.renderFaceXNeg(block, x, y, z, inner);

        renderer.setRenderBounds(innerMin, innerBottomY, innerMin + epsilon, innerMax, 1.0D, innerMin + epsilon * 2);
        renderer.renderFaceZPos(block, x, y, z, inner);

        renderer.setRenderBounds(innerMin, innerBottomY, innerMax - epsilon * 2, innerMax, 1.0D, innerMax - epsilon);
        renderer.renderFaceZNeg(block, x, y, z, inner);
        
        //Liquid in Cauldron
        IIcon vanite = BlockMoltenVanite.MoltenVaniteCrystal;
        double level = 0.9375D;
        renderer.setRenderBounds(innerMin, level, innerMin, innerMax, level + 0.001D, innerMax);
        renderer.renderFaceYPos(block, x, y, z, vanite);
        
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return RenderIDs.MOLTEN_VANITE_CRYSTAL_CAULDRON;
	}

}
