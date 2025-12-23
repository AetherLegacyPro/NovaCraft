package com.NovaCraft.entity.renderer.illager;

import com.NovaCraft.entity.models.IllagerTraderModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class IllagerTraderRenderer extends RenderBiped
{
	private static final ResourceLocation texture = new ResourceLocation("nova_craft","textures/entity/vindicator_settler/cultist.png");
	protected ModelBiped field_82437_k; 
	protected ModelBiped field_82435_l; 
	
	public IllagerTraderRenderer() {
		super(new IllagerTraderModel(), 0.5f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return IllagerTraderRenderer.texture;
	}
	
}
