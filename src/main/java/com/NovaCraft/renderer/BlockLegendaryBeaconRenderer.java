package com.NovaCraft.renderer;

import cpw.mods.fml.client.registry.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import org.lwjgl.opengl.*;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.world.*;

public class BlockLegendaryBeaconRenderer implements ISimpleBlockRenderingHandler
{
    public void renderInventoryBlock(final Block block, final int meta, final int modelID, final RenderBlocks renderer) {
        final Tessellator tessellator = Tessellator.instance;
        for (int k = 0; k < 3; ++k) {
            if (k == 0) {
                renderer.setRenderBounds(0.125, 0.0, 0.125, 0.875, 0.1875, 0.875);
                renderer.setOverrideBlockTexture(renderer.getBlockIcon(NovaCraftBlocks.crystallized_end));
            }
            //else if (k == 1) {
                //renderer.setRenderBounds(0.1875, 0.1875, 0.1875, 0.8125, 0.875, 0.8125);
               // renderer.setOverrideBlockTexture(renderer.getBlockIcon(NovaCraftBlocks.legendary_beacon));
            //}
            else if (k == 2) {
                renderer.setRenderBounds(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
                renderer.setOverrideBlockTexture(renderer.getBlockIcon(NovaCraftBlocks.vanite_glass));
            }
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            renderer.renderFaceYNeg(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSideAndMetadata(block, 0, meta));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            renderer.renderFaceYPos(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSideAndMetadata(block, 1, meta));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            renderer.renderFaceZNeg(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSideAndMetadata(block, 2, meta));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            renderer.renderFaceZPos(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSideAndMetadata(block, 3, meta));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            renderer.renderFaceXNeg(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSideAndMetadata(block, 4, meta));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            renderer.renderFaceXPos(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSideAndMetadata(block, 5, meta));
            tessellator.draw();
            GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        }
        renderer.setRenderBounds(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        renderer.clearOverrideBlockTexture();
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        final float f = 0.1875f;
        renderer.setOverrideBlockTexture(renderer.getBlockIcon(NovaCraftBlocks.vanite_glass));
        renderer.setRenderBounds(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.renderAllFaces = true;
        renderer.setOverrideBlockTexture(renderer.getBlockIcon(NovaCraftBlocks.crystallized_end));
        renderer.setRenderBounds(0.125, 0.0062500000931322575, 0.125, 0.875, (double)f, 0.875);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.renderAllFaces = false;
        renderer.clearOverrideBlockTexture();
        return true;
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
    
    public int getRenderId() {
        return RenderIDs.LEGENDARY_BEACON;
    }
}
