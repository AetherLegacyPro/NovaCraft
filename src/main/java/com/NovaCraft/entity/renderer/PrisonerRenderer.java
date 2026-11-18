package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntityPrisoner;
import com.NovaCraft.entity.models.PrisonerModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class PrisonerRenderer extends RenderLiving {
	private static final ResourceLocation TEXTURE = new ResourceLocation("nova_craft", "textures/entity/prisoner/prisoner.png");
	private static final ResourceLocation EYES = new ResourceLocation("nova_craft", "textures/entity/prisoner/eye.png");
	private static final ResourceLocation[] OVERLAYS = {
			new ResourceLocation("nova_craft", "textures/entity/prisoner/prisoner_overlay_1.png"),
			new ResourceLocation("nova_craft", "textures/entity/prisoner/prisoner_overlay_2.png"),
			new ResourceLocation("nova_craft", "textures/entity/prisoner/prisoner_overlay_3.png")
	};

	public PrisonerRenderer() {
		super(new PrisonerModel(), 0.5F);
		this.setRenderPassModel(this.mainModel);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float partialTicks) {
		GL11.glScalef(3.0F, 3.0F, 3.0F);
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase living, int pass, float partialTicks) {
		EntityPrisoner prisoner = (EntityPrisoner)living;
		if (pass == 0) {
			this.bindTexture(EYES);
			this.prepareGlowPass(prisoner);
			return 1;
		}

		if (pass == 1) {
			int frame = (prisoner.ticksExisted / 2 + prisoner.getEntityId()) % OVERLAYS.length;
			this.bindTexture(OVERLAYS[frame]);
			this.prepareGlowPass(prisoner);
			return 1;
		}

		if (pass == 2) {
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthMask(true);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			int brightness = prisoner.getBrightnessForRender(partialTicks);
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)(brightness & 65535), (float)(brightness >>> 16));
		}

		return -1;
	}

	private void prepareGlowPass(EntityPrisoner prisoner) {
		this.setRenderPassModel(this.mainModel);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		GL11.glDepthMask(!prisoner.isInvisible());

		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TEXTURE;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		EntityPrisoner prisoner = (EntityPrisoner)entity;
		if (prisoner.isEntityAlive()) {
			BossStatus.setBossStatus(prisoner, true);
		}

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
}