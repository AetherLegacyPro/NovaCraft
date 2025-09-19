package com.NovaCraft.entity.renderer;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import org.lwjgl.opengl.GL11;

import com.NovaCraft.TileEntity.TileEntityDeepOneEggActivated;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.renderer.RenderBlocks;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class DeepOneEggActivatedRenderer implements ISimpleBlockRenderingHandler
{
    final int renderID;
    private final TileEntityDeepOneEggActivated egg;
    
    public DeepOneEggActivatedRenderer(final int var1) {
        this.egg = new TileEntityDeepOneEggActivated();
        this.renderID = var1;
    }
    
    public void renderEgg(final RenderBlocks renderBlocks, final IBlockAccess iblockaccess, final Block par1Block, final int par2, final int par3, final int par4) {
        renderBlocks.overrideBlockTexture = par1Block.getIcon(iblockaccess, par2, par3, par4, 0);
        renderBlocks.setRenderBounds(0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
        renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
        renderBlocks.clearOverrideBlockTexture();
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -1.5f, -0.5f);
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        TileEntityRendererDispatcher.instance.renderTileEntityAt((TileEntity)this.egg, 0.0, 1.0, 0.0, 0.0f);
        GL11.glEnable(32826);
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        this.renderEgg(renderer, world, block, x, y, z);
        return true;
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
    
    public int getRenderId() {
        return this.renderID;
    }
}
