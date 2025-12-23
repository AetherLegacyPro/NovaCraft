package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.models.DestitumiteNewModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class DestitumiteRenderer extends RenderLiving
{
	private static final ResourceLocation texture;	
	
	public DestitumiteRenderer() {
		super(new DestitumiteNewModel(), 0.5f);
		this.setRenderPassModel((ModelBase)new DestitumiteNewModel());
	}
	
	@Override
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return DestitumiteRenderer.texture;
	}
	 
	 static {
		 texture = new ResourceLocation("nova_craft", "textures/entity/destitumite/destitumite.png");
	    }
	
}
