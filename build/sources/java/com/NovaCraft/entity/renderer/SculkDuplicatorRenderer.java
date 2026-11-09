package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.models.SculkSymbioteModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class SculkDuplicatorRenderer extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("nova_craft","textures/entity/sculk_symbiote/sculk_duplicater.png");

	public SculkDuplicatorRenderer() {
		super(new SculkSymbioteModel(), 0.3F);
	}

	@Override
	protected float getDeathMaxRotation(EntityLivingBase entity) {
		return 180.0F;
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
	    GL11.glScalef(1.80F, 1.80F, 1.80F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
