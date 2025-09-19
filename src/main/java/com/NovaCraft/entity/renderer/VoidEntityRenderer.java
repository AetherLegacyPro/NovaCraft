package com.NovaCraft.entity.renderer;

import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityVoidEntity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderBiped;

@SideOnly(Side.CLIENT)
public class VoidEntityRenderer extends RenderBiped
{
    private static final ResourceLocation demiGodEyesTextures;
    private static final ResourceLocation mobTextures;
    
    public VoidEntityRenderer(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2, 1.0f);
        this.setRenderPassModel((ModelBase)new ModelBiped());
    }
    
    public void doRender(final Entity par1Entity, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.doRender((EntityLiving)par1Entity, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final EntityLivingBase par1EntityLivingBase, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.doRender((EntityLiving)par1EntityLivingBase, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return this.getEntityTexture((EntityVoidEntity)par1Entity);
    }
    
    protected ResourceLocation getEntityTexture(final EntityVoidEntity entity) {
        return VoidEntityRenderer.mobTextures;
    }
    
    protected void renderEquippedItems(final EntityLivingBase par1EntityLivingBase, final float par2) {
        this.renderEquippedItems((EntityLiving)par1EntityLivingBase, par2);
    }
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityVoidEntity)par1EntityLivingBase, par2, par3);
    }
    
    protected int shouldRenderPass(final EntityVoidEntity entity, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        this.bindTexture(VoidEntityRenderer.demiGodEyesTextures);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (entity.isInvisible()) {
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
    
    static {
        demiGodEyesTextures = new ResourceLocation("nova_craft", "textures/entity/void_entity/void_entity_eyes.png");
        mobTextures = new ResourceLocation("nova_craft", "textures/entity/void_entity/void_entity.png");
    }
}


