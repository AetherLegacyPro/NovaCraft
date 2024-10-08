package com.NovaCraft.entity.renderer;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityPrisoner;
import com.NovaCraft.entity.models.PrisonerModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class PrisonerRenderer extends RenderLiving
{
	protected Random rand;
	private static final ResourceLocation texture;	
	private static final ResourceLocation eyes;
	private static final ResourceLocation eyes2;
	private static final ResourceLocation eyes3;
	
	protected ModelBiped field_82437_k; 
	protected ModelBiped field_82435_l; 
	
	public PrisonerRenderer() {
		super(new PrisonerModel(), 0.5f);
		this.setRenderPassModel((ModelBase)new PrisonerModel());
	}
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityPrisoner)par1EntityLivingBase, par2, par3);
    }
    
    protected int shouldRenderPass2(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass2((EntityPrisoner)par1EntityLivingBase, par2, par3);
    }
	
	protected int shouldRenderPass(final EntityPrisoner warden, final int par2, final float par3) {
		if (par2 != 0) {
            return -1;
        }
        int rand = (int)(1 + Math.random() * 3);
		switch (rand)
        {
          case 1:
        	this.bindTexture(PrisonerRenderer.eyes);
        	break;
          case 2:
          	this.bindTexture(PrisonerRenderer.eyes2);
          	break;
          case 3:
          	this.bindTexture(PrisonerRenderer.eyes3);
          	break;
        }
        return 1;
    }
	
	protected int shouldRenderPass2(final EntityPrisoner warden, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        {
        //this.bindTexture(PrisonerRenderer.bioluminescent);
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
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return PrisonerRenderer.texture;
	}
	
	 public void doRender(EntityPrisoner p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
	        BossStatus.setBossStatus(p_76986_1_, true);	        

	        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }

	 public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
	        this.doRender((EntityPrisoner)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }
	 
	 public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
	        this.doRender((EntityPrisoner)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }
	 
	 public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
	        this.doRender((EntityPrisoner)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }
	 
	 static {
		 texture = new ResourceLocation("nova_craft", "textures/entity/prisoner/prisoner.png");	
		 eyes = new ResourceLocation("nova_craft", "textures/entity/prisoner/prisoner_overlay_1.png");
		 eyes2 = new ResourceLocation("nova_craft", "textures/entity/prisoner/prisoner_overlay_2.png");
		 eyes3 = new ResourceLocation("nova_craft", "textures/entity/prisoner/prisoner_overlay_3.png");
	    }
	
}
