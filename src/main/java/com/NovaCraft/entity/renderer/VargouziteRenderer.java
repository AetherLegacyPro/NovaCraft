package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.EntityVargouzite;
import com.NovaCraft.entity.models.VargouziteModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class VargouziteRenderer extends RenderLiving
{
	private static final ResourceLocation EyesTextures;
    private static final ResourceLocation mobTextures;
    
    public VargouziteRenderer(final VargouziteModel model, float par2) {
        super(model, par2);
        this.setRenderPassModel((ModelBase)new VargouziteModel());
    }

	public void doRender(final Entity par1Entity, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.doRender((EntityLiving)par1Entity, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final EntityLivingBase par1EntityLivingBase, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.doRender((EntityLiving)par1EntityLivingBase, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return this.getEntityTexture((EntityVargouzite)par1Entity);
    }
    
    protected ResourceLocation getEntityTexture(final EntityVargouzite par1EntityVargouzite) {
        return VargouziteRenderer.mobTextures;
    }
    
    @Override
  	protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
  	    GL11.glScalef(0.8F, 0.8F, 0.8F);
  	}
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityVargouzite)par1EntityLivingBase, par2, par3);
    }
    
    protected int shouldRenderPass(final EntityVargouzite par1XCEntityVargouzite, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        this.bindTexture(VargouziteRenderer.EyesTextures);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (par1XCEntityVargouzite.isInvisible()) {
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
    	EyesTextures = new ResourceLocation("nova_craft", "textures/entity/deepoid/vargouzite_skin.png");
        mobTextures = new ResourceLocation("nova_craft", "textures/entity/deepoid/vargouzite.png");
    }
	
	
}
