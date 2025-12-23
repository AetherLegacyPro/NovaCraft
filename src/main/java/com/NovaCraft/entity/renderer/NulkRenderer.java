package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.EntityNulk;
import com.NovaCraft.entity.models.NulkModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class NulkRenderer extends RenderLiving
{
	private static final ResourceLocation texture;
	private static final ResourceLocation overlay_1;
	private static final ResourceLocation overlay_2;
	private static final ResourceLocation overlay_3;
	
	public NulkRenderer() {
		super(new NulkModel(), 0.5f);
		this.setRenderPassModel((ModelBase)new NulkModel());
	}
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityNulk)par1EntityLivingBase, par2, par3);
    }
    
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        GL11.glScalef(0.8F, 0.8F, 0.8F);
    }
	
	protected int shouldRenderPass(final EntityNulk nulk, final int par2, final float par3) {
		if (par2 != 0) {
            return -1;
        }
        
        int rand = (int)(1 + Math.random() * 3);
		switch (rand)
        {
          case 1:
        	this.bindTexture(NulkRenderer.overlay_1);
        	break;
          case 2:
          	this.bindTexture(NulkRenderer.overlay_2);
          	break;
          case 3:
          	this.bindTexture(NulkRenderer.overlay_3);
          	break;
        }
        return 1;
    }
	
	@Override
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return NulkRenderer.texture;
	}
	
	 public void doRender(EntityNulk p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {     

	        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }

	 public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
	        this.doRender((EntityNulk)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }
	 
	 public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
	        this.doRender((EntityNulk)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }
	 
	 public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
	        this.doRender((EntityNulk)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	 }
	 
	 static {
		 texture = new ResourceLocation("nova_craft", "textures/entity/nulk/nulk.png");	
		 overlay_1 = new ResourceLocation("nova_craft", "textures/entity/nulk/nulk_overlay_1.png");
		 overlay_2 = new ResourceLocation("nova_craft", "textures/entity/nulk/nulk_overlay_2.png");
		 overlay_3 = new ResourceLocation("nova_craft", "textures/entity/nulk/nulk_overlay_3.png");
	    }
	
}
