package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.models.IceologerModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class IceologerRenderer extends RenderBiped
{
	private static final ResourceLocation texture = new ResourceLocation("nova_craft", "textures/entity/iceologer/iceologer.png");
	protected ModelBiped field_82437_k; 
	protected ModelBiped field_82435_l; 
	
	public IceologerRenderer() {
		super(new IceologerModel(), 0.5f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return IceologerRenderer.texture;
	}
	
	
}
