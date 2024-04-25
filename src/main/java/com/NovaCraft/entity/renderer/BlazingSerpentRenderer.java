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
public class BlazingSerpentRenderer extends RenderLiving
{
    private static final ResourceLocation texture;
    
    public BlazingSerpentRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return BlazingSerpentRenderer.texture;
    }
    
    @Override
	protected void preRenderCallback(EntityLivingBase young_zephyr, float partialTickTime) {
	    GL11.glScalef(1.75F, 1.75F, 1.75F);
	}
    
    static {
        texture = new ResourceLocation("nova_craft", "textures/entity/serpent/blazing_serpent.png");
    }
}

