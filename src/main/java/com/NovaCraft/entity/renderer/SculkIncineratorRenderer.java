package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.EntitySculkIncinerator;
import com.NovaCraft.entity.models.SculkIncineratorModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class SculkIncineratorRenderer extends RenderLiving {

	private static final ResourceLocation texture;
	private static final ResourceLocation eyes;

	 public SculkIncineratorRenderer(final SculkIncineratorModel mainModel, final SculkIncineratorModel renderPassModel, final float shadowSize) {
	        super((ModelBase)mainModel, shadowSize);
	        this.setRenderPassModel((ModelBase)renderPassModel);
	    }
	    
	    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
	        return SculkIncineratorRenderer.texture;
	    }
	    
	    protected int setTextureGlow(final EntitySculkIncinerator entity, final int pass, final float partialTickTime) {
	        final float flap = MathHelper.sin((entity.ticksExisted + partialTickTime) * 0.5f) * 0.6f;
	        GL11.glPushMatrix();
	        GL11.glTranslatef(0.0f, 0.0f - flap * 0.5f, 0.0f);
	        GL11.glPopMatrix();
	        if (pass == 1) {
	            final char c0 = '\uf0f0';
	            final int j = c0 % 65536;
	            final int k = c0 / 65536;
	                      
	            this.bindTexture(SculkIncineratorRenderer.eyes);
	    		
	            final float var4 = 1.0f;
	            GL11.glEnable(3042);
	            GL11.glBlendFunc(1, 771);
	            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0f, k / 1.0f);
	            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	            GL11.glColor4f(1.0f, 1.0f, 1.0f, var4);
	            return 1;
	        }
	        if (pass == 2) {
	            GL11.glDisable(3042);
	        }
	        return -1;
	    }
	    
	    protected int shouldRenderPass(final EntityLivingBase entity, final int pass, final float partialTickTime) {
	        return this.setTextureGlow((EntitySculkIncinerator)entity, pass, partialTickTime);
	    }
	    
	    @Override
		protected void preRenderCallback(EntityLivingBase mob, float partialTickTime) {
		    GL11.glScalef(1.01F, 1.01F, 1.01F);
		}
	    
	    static {
	    	texture = new ResourceLocation("nova_craft", "textures/entity/sculk_incinerator/sculk_incinerator.png");
	        eyes = new ResourceLocation("nova_craft", "textures/entity/sculk_incinerator/glow.png");
	    }
	}
