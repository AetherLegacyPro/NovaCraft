package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.models.SculkSymbioteModel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class SculkSymbioteRenderer extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("nova_craft","textures/entity/sculk_symbiote/sculk_symbiote.png");

	public SculkSymbioteRenderer() {
		super(new SculkSymbioteModel(), 0.3F);
	}

	@Override
	protected float getDeathMaxRotation(EntityLivingBase entity) {
		return 180.0F;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
