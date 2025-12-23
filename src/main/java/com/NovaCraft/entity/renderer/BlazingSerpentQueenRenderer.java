package com.NovaCraft.entity.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.EntityBlazingSerpentQueen;
import com.NovaCraft.entity.models.BlazingSerpentQueenModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class BlazingSerpentQueenRenderer extends RenderLiving
{
    private static final ResourceLocation texture;
    private static final ResourceLocation eyes;
    
    public BlazingSerpentQueenRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.setRenderPassModel((ModelBase)new BlazingSerpentQueenModel());
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return BlazingSerpentQueenRenderer.texture;
    }
    
    @Override
	protected void preRenderCallback(EntityLivingBase living, float partialTickTime) {
	    GL11.glScalef(1.25F, 1.25F, 1.25F);
	}
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityBlazingSerpentQueen)par1EntityLivingBase, par2, par3);
    }
    
    protected int shouldRenderPass(final EntityBlazingSerpentQueen serpent, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        this.bindTexture(BlazingSerpentQueenRenderer.eyes);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (serpent.isInvisible()) {
            GL11.glDepthMask(false);
        }
        else {
            GL11.glDepthMask(true);
        }
        final char c0 = '\uf0f0';
        final int j = 61680;
        final int k = 0;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0f, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return 1;
    }
    
    public void doRender(EntityBlazingSerpentQueen p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        BossStatus.setBossStatus(p_76986_1_, true);	        

        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	}

    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityBlazingSerpentQueen)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
 
    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
    	this.doRender((EntityBlazingSerpentQueen)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityBlazingSerpentQueen)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    static {
        texture = new ResourceLocation("nova_craft", "textures/entity/serpent/blazing_serpent_queen.png");
        eyes = new ResourceLocation("nova_craft", "textures/entity/serpent/eye_queen.png");
    }
}
