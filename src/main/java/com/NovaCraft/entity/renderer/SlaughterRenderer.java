package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class SlaughterRenderer extends RenderBiped
{
	public static final ResourceLocation texture;
	public static final ResourceLocation textureOverlay;
	protected ModelBiped field_82437_k; 
	protected ModelBiped field_82435_l; 
	
	public SlaughterRenderer() {
		super(new ModelSkeleton(), 0.4f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return SlaughterRenderer.texture;
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
	    GL11.glScalef(1.25F, 1.25F, 1.25F);
	}
	
	static {
		texture = new ResourceLocation("nova_craft","textures/entity/slaughter/slaughter.png");
		textureOverlay = new ResourceLocation("textures/entity/skeleton/stray_overlay.png");
	}
}
