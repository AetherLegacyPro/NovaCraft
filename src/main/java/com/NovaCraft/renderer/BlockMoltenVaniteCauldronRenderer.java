package com.NovaCraft.renderer;

import com.NovaCraftBlocks.potion.BlockMoltenVanite;
import com.NovaCraftBlocks.potion.BlockMoltenVaniteCauldron;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockMoltenVaniteCauldronRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		BlockMoltenVaniteCauldron cauldron = (BlockMoltenVaniteCauldron) block;
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

		// outer walls (same as vanilla)
		renderer.renderFaceXPos(block, x - 1 + f4, y, z, side);
		renderer.renderFaceXNeg(block, x + 1 - f4, y, z, side);
		renderer.renderFaceZPos(block, x, y, z - 1 + f4, side);
		renderer.renderFaceZNeg(block, x, y, z + 1 - f4, side);

		// inner
		IIcon inner = cauldron.inner;
		renderer.renderFaceYPos(block, x, y - 1 + 0.25F, z, inner);
		renderer.renderFaceYNeg(block, x, y + 1 - 0.75F, z, inner);

		// liquid level
		//int meta = world.getBlockMetadata(x, y, z);
		//if (meta == 0)
		//{
			IIcon liquid = BlockMoltenVanite.MoltenVaniteStillIcon;
			float level = 0.95F; //+ //meta * 0.1875F;
			renderer.renderFaceYPos(block, x, y - 1 + level, z, liquid);
		//}

		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return RenderIDs.MOLTEN_VANITE_CAULDRON;
	}

}
