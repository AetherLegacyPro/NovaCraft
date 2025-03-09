package com.NovaCraft.entity.renderer;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityRealityDistorter;
import com.NovaCraft.entity.models.RealityDistorterModel;

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

public class RealityDistorterRenderer extends RenderLiving
{
	private static final ResourceLocation texture;	
	private static final ResourceLocation eyes;
	private static final ResourceLocation eyes2;
	private static final ResourceLocation eyes3;
	
	public RealityDistorterRenderer() {
		super(new RealityDistorterModel(), 0.5f);
		this.setRenderPassModel((ModelBase)new RealityDistorterModel());
	}
	
	@Override
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return RealityDistorterRenderer.texture;
	}
	
	protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityRealityDistorter)par1EntityLivingBase, par2, par3);
    }
    
    protected int shouldRenderPass(final EntityRealityDistorter entity, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        int rand = (int)(1 + Math.random() * 3);
		switch (rand)
        {
          case 1:
        	this.bindTexture(RealityDistorterRenderer.eyes);
        	break;
          case 2:
          	this.bindTexture(RealityDistorterRenderer.eyes2);
          	break;
          case 3:
          	this.bindTexture(RealityDistorterRenderer.eyes3);
          	break;
        }
        return 1;
    }
	 
	 static {
		 texture = new ResourceLocation("nova_craft", "textures/entity/reality_distorter/reality_distorter.png");
		 eyes = new ResourceLocation("nova_craft", "textures/entity/reality_distorter/reality_distorter_eyes.png");
		 eyes2 = new ResourceLocation("nova_craft", "textures/entity/reality_distorter/reality_distorter_eyes2.png");
		 eyes3 = new ResourceLocation("nova_craft", "textures/entity/reality_distorter/reality_distorter_eyes3.png");
	    }
	
}
