package com.NovaCraft.renderer;

import java.util.Random;

import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.plants.end.BlockLacunaLog;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

@SideOnly(Side.CLIENT)
public class BlockEndiumPlantRenderer extends BlockEndiumLogRenderer {

	private final Random rand = new Random();

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		renderer.renderAllFaces = true;

		long seed = x * 3129871L ^ y * 116129781L ^ z;
		seed = seed * seed * 42317861L + seed * 11L;
		rand.setSeed(seed);

		int noConUp = rand.nextInt(5);
		int noConDown = rand.nextInt(5);
		int noConWest = rand.nextInt(5);
		int noConEast = rand.nextInt(5);
		int noConNorth = rand.nextInt(5);
		int noConSouth = rand.nextInt(5);

		Block neighbourUp = world.getBlock(x, y + ForgeDirection.UP.offsetY, z);
		Block neighbourDown = world.getBlock(x, y + ForgeDirection.DOWN.offsetY, z);
		Block neighbourWest = world.getBlock(x + ForgeDirection.WEST.offsetX, y, z);
		Block neighbourEast = world.getBlock(x + ForgeDirection.EAST.offsetX, y, z);
		Block neighbourNorth = world.getBlock(x, y, z + ForgeDirection.NORTH.offsetZ);
		Block neighbourSouth = world.getBlock(x, y, z + ForgeDirection.SOUTH.offsetZ);
		
		boolean connectUp = BlockLacunaLog.canPlaceOn(neighbourUp);
		boolean connectDown = BlockLacunaLog.canPlaceOn(neighbourDown);
		boolean connectWest = BlockLacunaLog.canPlaceOn(neighbourWest);
		boolean connectEast = BlockLacunaLog.canPlaceOn(neighbourEast);
		boolean connectNorth = BlockLacunaLog.canPlaceOn(neighbourNorth);
		boolean connectSouth = BlockLacunaLog.canPlaceOn(neighbourSouth);
		float conWidth = 4 / 16F;

		if (neighbourUp == NovaCraftBlocks.lacuna_fruit || connectUp || neighbourUp == block) {
			renderer.setRenderBounds(conWidth, 1 - conWidth, conWidth, 1 - conWidth, 1, 1 - conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConUp == 2 || noConUp == 3) {
			renderer.setRenderBounds(conWidth, 1 - conWidth, conWidth, 1 - conWidth, 13 / 16F, 1 - conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConUp == 4) {
			renderer.setRenderBounds(5 / 16F, 1 - conWidth, 5 / 16F, 11 / 16F, 1 - 2 / 16F, 11 / 16F);
			renderer.renderStandardBlock(block, x, y, z);
		}

		if (neighbourDown == NovaCraftBlocks.lacuna_fruit || connectDown || neighbourDown == block) {
			renderer.setRenderBounds(conWidth, 0, conWidth, 1 - conWidth, conWidth, 1 - conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConDown == 2 || noConDown == 3) {
			renderer.setRenderBounds(conWidth, 3 / 16F, conWidth, 1 - conWidth, conWidth, 1 - conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConDown == 4) {
			renderer.setRenderBounds(5 / 16F, 2 / 16F, 5 / 16F, 11 / 16F, conWidth, 11 / 16F);
			renderer.renderStandardBlock(block, x, y, z);
		}

		if (neighbourWest == NovaCraftBlocks.lacuna_fruit || connectWest || neighbourWest == block) {
			renderer.setRenderBounds(0, conWidth, conWidth, conWidth, 1 - conWidth, 1 - conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConWest == 2 || noConWest == 3) {
			renderer.setRenderBounds(3 / 16F, conWidth, conWidth, conWidth, 1 - conWidth, 1 - conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConWest == 4) {
			renderer.setRenderBounds(2 / 16F, 5 / 16F, 5 / 16F, conWidth, 11 / 16F, 11 / 16F);
			renderer.renderStandardBlock(block, x, y, z);
		}

		if (neighbourEast == NovaCraftBlocks.lacuna_fruit || connectEast || neighbourEast == block) {
			renderer.setRenderBounds(1 - conWidth, conWidth, conWidth, 1, 1 - conWidth, 1 - conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConEast == 2 || noConEast == 3) {
			renderer.setRenderBounds(1 - conWidth, conWidth, conWidth, 13 / 16F, 1 - conWidth, 1 - conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConEast == 4) {
			renderer.setRenderBounds(1 - conWidth, 5 / 16F, 5 / 16F, 1 - 2 / 16F, 11 / 16F, 11 / 16F);
			renderer.renderStandardBlock(block, x, y, z);
		}

		if (neighbourNorth == NovaCraftBlocks.lacuna_fruit || connectNorth || neighbourNorth == block) {
			renderer.setRenderBounds(conWidth, conWidth, 0, 1 - conWidth, 1 - conWidth, conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConNorth == 2 || noConNorth == 3) {
			renderer.setRenderBounds(conWidth, conWidth, 3 / 16F, 1 - conWidth, 1 - conWidth, conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConNorth == 4) {
			renderer.setRenderBounds(5 / 16F, 5 / 16F, 2 / 16F, 11 / 16F, 11 / 16F, conWidth);
			renderer.renderStandardBlock(block, x, y, z);
		}

		if (neighbourSouth == NovaCraftBlocks.lacuna_fruit || connectSouth || neighbourSouth == block) {
			renderer.setRenderBounds(conWidth, conWidth, 1 - conWidth, 1 - conWidth, 1 - conWidth, 1);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConSouth == 2 || noConSouth == 3) {
			renderer.setRenderBounds(conWidth, conWidth, 1 - conWidth, 1 - conWidth, 1 - conWidth, 13 / 16F);
			renderer.renderStandardBlock(block, x, y, z);
		} else if (noConSouth == 4) {
			renderer.setRenderBounds(5 / 16F, 5 / 16F, 1 - conWidth, 11 / 16F, 11 / 16F, 1 - 2 / 16F);
			renderer.renderStandardBlock(block, x, y, z);
		}

		renderer.setRenderBounds(conWidth, conWidth, conWidth, 1 - conWidth, 1 - conWidth, 1 - conWidth);
		renderer.renderStandardBlock(block, x, y, z);

		renderer.renderAllFaces = false;

		return true;
	}

	@Override
	public int getRenderId() {
		return RenderIDs.ENDIUM_PLANT;
	}
}
