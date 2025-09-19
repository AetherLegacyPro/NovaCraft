package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntitySoloid;
import com.NovaCraft.entity.models.SoloidModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class SoloidRenderer extends RenderLiving
{
    private static final ResourceLocation EyesTextures;
    private static final ResourceLocation mobTextures;

    public SoloidRenderer(final SoloidModel model, float par2) {
        super(model, par2);
        this.setRenderPassModel((ModelBase)new SoloidModel());
    }

    public void doRender(final Entity par1Entity, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.doRender((EntityLiving)par1Entity, par2, par3, par4, par5, par6);
    }

    public void doRender(final EntityLivingBase par1EntityLivingBase, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.doRender((EntityLiving)par1EntityLivingBase, par2, par3, par4, par5, par6);
    }

    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return this.getEntityTexture((EntitySoloid)par1Entity);
    }

    protected ResourceLocation getEntityTexture(final EntitySoloid par1EntitySoloid) {
        return SoloidRenderer.mobTextures;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
        GL11.glScalef(0.8F, 0.8F, 0.8F);
    }

    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntitySoloid)par1EntityLivingBase, par2, par3);
    }

    protected int shouldRenderPass(final EntitySoloid par1EntitySoloid, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        this.bindTexture(SoloidRenderer.EyesTextures);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (par1EntitySoloid.isInvisible()) {
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
        EyesTextures = new ResourceLocation("nova_craft", "textures/entity/deepoid/soloid_glow.png");
        mobTextures = new ResourceLocation("nova_craft", "textures/entity/deepoid/soloid.png");
    }


}

