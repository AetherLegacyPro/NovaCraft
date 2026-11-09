package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.EntityOutsider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class OutsiderRenderer extends RenderBiped
{
	private float scale;
	public static final ResourceLocation texture;
	private static final ResourceLocation overlay_1;
	private static final ResourceLocation overlay_2;
	private static final ResourceLocation overlay_3;
	protected ModelBiped field_82437_k;
	protected ModelBiped field_82435_l;
	
	public OutsiderRenderer() {
		super(new ModelZombie(), 0.4f);
		this.setRenderPassModel((ModelBase)new ModelZombie());
		this.scale = 1.0f;
	}
	
	protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityOutsider)par1EntityLivingBase, par2, par3);
    }
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		if ((par1EntityLiving instanceof EntityOutsider)) {
			GL11.glScalef(this.scale, this.scale, this.scale);
		}
	}
	
	protected int shouldRenderPass(final EntityOutsider outsider, final int par2, final float par3) {
		if (par2 != 0) {
            return -1;
        }
        
        int rand = (int)(1 + Math.random() * 3);
		switch (rand)
        {
          case 1:
        	this.bindTexture(OutsiderRenderer.overlay_1);
        	break;
          case 2:
          	this.bindTexture(OutsiderRenderer.overlay_2);
          	break;
          case 3:
          	this.bindTexture(OutsiderRenderer.overlay_3);
          	break;
        }
        return 1;
    }
	
	@Override
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return OutsiderRenderer.texture;
	}
	
	static {
		texture = new ResourceLocation("nova_craft", "textures/entity/outsider/outsider_entity.png");
		overlay_1 = new ResourceLocation("nova_craft", "textures/entity/outsider/outsider_entity_overlay_1.png");
		overlay_2 = new ResourceLocation("nova_craft", "textures/entity/outsider/outsider_entity_overlay_2.png");
		overlay_3 = new ResourceLocation("nova_craft", "textures/entity/outsider/outsider_entity_overlay_3.png");
	}
}
