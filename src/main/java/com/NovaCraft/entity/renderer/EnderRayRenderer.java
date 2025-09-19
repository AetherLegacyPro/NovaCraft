package com.NovaCraft.entity.renderer;

import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityEnderRay;
import com.NovaCraft.entity.models.EnderRayModel;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;

public class EnderRayRenderer extends RenderLiving
{
	 private static final ResourceLocation enderRayScarsGlow = new ResourceLocation("nova_craft","textures/entity/ender_ray/ender_ray_scars_glow.png");
	 private static final ResourceLocation enderRayGlow = new ResourceLocation("nova_craft","textures/entity/ender_ray/ender_ray_glow.png");
	 private static final ResourceLocation enderRay = new ResourceLocation("nova_craft","textures/entity/ender_ray/ender_ray.png");
	
    public EnderRayRenderer() {
        super((ModelBase)new EnderRayModel(), 1.0f);
        this.setRenderPassModel(super.mainModel);
    }
    
    @Override
    protected void preRenderCallback(EntityLivingBase young_zephyr, float partialTickTime) {
        GL11.glScalef(3.00F, 3.00F, 3.00F);
    }
    
    protected int setGlowstuffBrightness(final EntityEnderRay par1EntityRay, final int par2, final float par3) {
        if (par2 != 0) {
            GL11.glDepthMask(true);
            return -1;
        }
        if (par1EntityRay.hasSpecialTexture) {
            this.bindTexture(enderRayScarsGlow);
        }
        else {
            this.bindTexture(enderRayGlow);
        }
        final float var4 = 1.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        final char var5 = '\u00f0';
        final int var6 = var5 % 65536;
        final int var7 = var5 / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, var6 / 1.0f, var7 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, var4);
        GL11.glDepthMask(false);
        return 1;
    }
    
    protected int shouldRenderPass(final EntityLiving par1EntityLiving, final int par2, final float par3) {
        return this.setGlowstuffBrightness((EntityEnderRay)par1EntityLiving, par2, par3);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		
		return enderRay;
	}
}

