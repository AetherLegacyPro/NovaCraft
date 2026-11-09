package com.NovaCraft.entity.renderer;

import java.util.Random;
import com.NovaCraft.entity.EntityWardling;
import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.models.WardlingModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class WardlingRenderer extends RenderLiving
{
	protected Random rand;
	private static final ResourceLocation texture = new ResourceLocation("nova_craft", "textures/entity/warden_vessel/wardling.png");
	
	protected ModelBiped field_82437_k; 
	protected ModelBiped field_82435_l; 
	
	public WardlingRenderer() {
		super(new WardlingModel(), 0.5f);
		this.setRenderPassModel((ModelBase)new WardlingModel());
	}
    
    protected int shouldRenderPass(final EntityLivingBase entity, final int par2, final float par3) {
        return this.shouldRenderPass((EntityWardling)entity, par2, par3);
    }
    
    protected int shouldRenderPass2(final EntityLivingBase entity, final int par2, final float par3) {
        return this.shouldRenderPass2((EntityWardling)entity, par2, par3);
    }
	
	protected int shouldRenderPass(final EntityWardling warden, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        {
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (warden.isInvisible()) {
            GL11.glDepthMask(false);
        }
        else {
            GL11.glDepthMask(true);
        }
        final char c0 = '\uf0f0';
        final int j = 61680;
        final int k = 0;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0f, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return 1;
        }
    }
	
	protected int shouldRenderPass2(final EntityWardling warden, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        {
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (warden.isInvisible()) {
            GL11.glDepthMask(false);
        }
        else {
            GL11.glDepthMask(true);
        }
        final char c0 = '\uf0f0';
        final int j = 61680;
        final int k = 0;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0f, 0.0f);
        GL11.glColor4f(0.3f, 0.3f, 0.3f, 0.3f);
        return 1;
        }
    }
	
	@Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
		return WardlingRenderer.texture;
	}
	
	 public void doRender(EntityWardling entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {

	        super.doRender((EntityLiving)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }

	 public void doRender(EntityLiving entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
	        this.doRender((EntityWardling)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }
	 
	 public void doRender(EntityLivingBase entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
	        this.doRender((EntityWardling)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }
	 
	 public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
	        this.doRender((EntityWardling)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }
	
}
