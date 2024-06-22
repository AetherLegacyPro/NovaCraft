package com.NovaCraft.entity.renderer;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityDestitumite;
import com.NovaCraft.entity.models.DestitumiteModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class DestitumiteRenderer extends RenderLiving
{
	private static final ResourceLocation texture;	
	
	public DestitumiteRenderer() {
		super(new DestitumiteModel(), 0.5f);
		this.setRenderPassModel((ModelBase)new DestitumiteModel());
	}
	
	@Override
	protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
		return DestitumiteRenderer.texture;
	}
	 
	 static {
		 texture = new ResourceLocation("nova_craft", "textures/entity/destitumite/destitumite.png");
	    }
	
}
