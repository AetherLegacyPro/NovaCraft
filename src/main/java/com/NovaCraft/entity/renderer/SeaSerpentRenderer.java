package com.NovaCraft.entity.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class SeaSerpentRenderer extends RenderLiving
{
    private static final ResourceLocation texture;
    
    public SeaSerpentRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return SeaSerpentRenderer.texture;
    }
    
    @Override
	protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
	    GL11.glScalef(0.5F, 0.5F, 0.5F);
	}
    
    static {
        texture = new ResourceLocation("nova_craft", "textures/entity/serpent/sea_serpent.png");
    }
}
