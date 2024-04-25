package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.models.VindicatorModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class VindicatorRenderer extends RenderBiped
{
	//public static final ResourceLocation texture;
	//public static final ResourceLocation textureOverlay;
	private static final ResourceLocation texture = new ResourceLocation("textures/entity/vindicator/vindicator.png");
	protected ModelBiped field_82437_k; 
	protected ModelBiped field_82435_l; 
	
	public VindicatorRenderer() {
		super(new VindicatorModel(), 0.5f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return VindicatorRenderer.texture;
	}
	
	//@Override
	//protected void preRenderCallback(EntityLivingBase young_zephyr, float partialTickTime) {
	 //   GL11.glScalef(1.25F, 1.25F, 1.25F);
	//}
	
}
