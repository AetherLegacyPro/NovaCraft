package com.NovaCraft.entity.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityCrystalGolem;
import com.NovaCraft.entity.models.CrystalGolemModel;

public class CrystalGolemRenderer extends RenderLiving {

	private static final ResourceLocation TEXTURE_COPARTZ  = new ResourceLocation("nova_craft", "textures/entity/crystal_golem/crystal_golem_copartz.png");

	private static final ResourceLocation TEXTURE_LARIMAR = new ResourceLocation("nova_craft", "textures/entity/crystal_golem/crystal_golem_larimar.png");
	
	private static final ResourceLocation TEXTURE_TSAVOROKITE = new ResourceLocation("nova_craft", "textures/entity/crystal_golem/crystal_golem_tsavorokite.png");
	
	private static final ResourceLocation TEXTURE_YTTRLINISTE = new ResourceLocation("nova_craft", "textures/entity/crystal_golem/crystal_golem_yttrliniste.png");
	
	private static final ResourceLocation TEXTURE_AMETHYST = new ResourceLocation("nova_craft", "textures/entity/crystal_golem/crystal_golem_amethyst.png");

	public CrystalGolemRenderer()
	{
		super(new CrystalGolemModel(), 0.3F);
	}

	protected int shouldRenderPass(EntityCrystalGolem entity, int pass, float particleTicks)
	{
		if (entity.isInvisible())
		{
			return 0;
		}
		else if (pass == 0)
		{
			this.setRenderPassModel(new CrystalGolemModel());
			GL11.glEnable(GL11.GL_NORMALIZE);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			return 1;
		}
		else
		{
			if (pass == 1)
			{
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}

			return -1;
		}
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase young_zephyr, float partialTickTime) {
	  	GL11.glScalef(0.5F, 0.5F, 0.5F);
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
	{
		return this.shouldRenderPass((EntityCrystalGolem)p_77032_1_, p_77032_2_, p_77032_3_);
	}

	@Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        return new ResourceLocation("nova_craft", "textures/entity/crystal_golem/" + ((EntityCrystalGolem)entity).getType() + ".png");
    }
	
}
