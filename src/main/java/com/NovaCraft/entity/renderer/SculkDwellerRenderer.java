package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntitySculkDweller;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class SculkDwellerRenderer extends RenderBiped
{
	public static final ResourceLocation texture;
	private float scale;
	protected ModelBiped field_82437_k; //modelArmourChestplate
	protected ModelBiped field_82435_l; //modelArmor
	
	public SculkDwellerRenderer() {
		super(new ModelZombie(), 0.4f);
		this.scale = 1.0f; //1.1
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		if ((par1EntityLiving instanceof EntitySculkDweller)) {
			GL11.glScalef(this.scale, this.scale, this.scale);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return texture;
	}
	static {
		texture = new ResourceLocation("nova_craft", "textures/entity/sculk_dweller/sculk_dweller.png");
	}
}

