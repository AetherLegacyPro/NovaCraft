package com.NovaCraft.TileEntity;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.models.DeepOneEggModel;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TileEntityDeepOneEggActivatedRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation Textures;
    private DeepOneEggModel model;
    
    public TileEntityDeepOneEggActivatedRenderer() {
        this.model = new DeepOneEggModel();
    }
    
    public void renderTileEntityAt(final TileEntity tile, final double d, final double d1, final double d2, final float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d1 + 1.5f, (float)d2 + 0.5f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        this.bindTexture(TileEntityDeepOneEggActivatedRenderer.Textures);
        GL11.glPushMatrix();
        this.model.renderAll();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
    
    static {
    	Textures = new ResourceLocation("nova_craft", "textures/entity/deepoid_dragon/deepoid_dragon_egg_activated.png");
    }
}
