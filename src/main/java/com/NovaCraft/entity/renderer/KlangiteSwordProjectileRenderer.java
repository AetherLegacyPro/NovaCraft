package com.NovaCraft.entity.renderer;

import net.minecraft.util.MathHelper;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.misc.KlangiteSwordProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;

@SideOnly(Side.CLIENT)
public class KlangiteSwordProjectileRenderer extends Render
{
    private static final ResourceLocation swordProjectile;
    
    public void doRender(final Entity entity, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.doRender((KlangiteSwordProjectile)entity, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final KlangiteSwordProjectile par1KlangiteSwordProjectile, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.bindEntityTexture((Entity)par1KlangiteSwordProjectile);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par3, (float)par4);
        GL11.glRotatef(par1KlangiteSwordProjectile.prevRotationYaw + (par1KlangiteSwordProjectile.rotationYaw - par1KlangiteSwordProjectile.prevRotationYaw) * par6 - 90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(par1KlangiteSwordProjectile.prevRotationPitch + (par1KlangiteSwordProjectile.rotationPitch - par1KlangiteSwordProjectile.prevRotationPitch) * par6, 0.0f, 0.0f, 1.0f);
        final Tessellator tessellator = Tessellator.instance;
        final byte b0 = 0;
        final float f2 = 0.0f;
        final float f3 = 0.5f;
        final float f4 = (0 + b0 * 10) / 32.0f;
        final float f5 = (5 + b0 * 10) / 32.0f;
        final float f6 = 0.0f;
        final float f7 = 0.15625f;
        final float f8 = (5 + b0 * 10) / 32.0f;
        final float f9 = (10 + b0 * 10) / 32.0f;
        final float f10 = 0.05625f;
        GL11.glEnable(32826);
        final float f11 = par1KlangiteSwordProjectile.arrowShake - par6;
        if (f11 > 0.0f) {
            final float f12 = -MathHelper.sin(f11 * 3.0f) * f11;
            GL11.glRotatef(f12, 0.0f, 0.0f, 1.0f);
        }
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(f10, f10, f10);
        GL11.glTranslatef(-4.0f, 0.0f, 0.0f);
        GL11.glNormal3f(f10, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-7.0, -2.0, -2.0, (double)f6, (double)f8);
        tessellator.addVertexWithUV(-7.0, -2.0, 2.0, (double)f7, (double)f8);
        tessellator.addVertexWithUV(-7.0, 2.0, 2.0, (double)f7, (double)f9);
        tessellator.addVertexWithUV(-7.0, 2.0, -2.0, (double)f6, (double)f9);
        tessellator.draw();
        GL11.glNormal3f(-f10, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-7.0, 2.0, -2.0, (double)f6, (double)f8);
        tessellator.addVertexWithUV(-7.0, 2.0, 2.0, (double)f7, (double)f8);
        tessellator.addVertexWithUV(-7.0, -2.0, 2.0, (double)f7, (double)f9);
        tessellator.addVertexWithUV(-7.0, -2.0, -2.0, (double)f6, (double)f9);
        tessellator.draw();
        for (int i = 0; i < 4; ++i) {
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glNormal3f(0.0f, 0.0f, f10);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-8.0, -2.0, 0.0, (double)f2, (double)f4);
            tessellator.addVertexWithUV(8.0, -2.0, 0.0, (double)f3, (double)f4);
            tessellator.addVertexWithUV(8.0, 2.0, 0.0, (double)f3, (double)f5);
            tessellator.addVertexWithUV(-8.0, 2.0, 0.0, (double)f2, (double)f5);
            tessellator.draw();
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }
    
    protected void preRenderCallback(EntityLivingBase entityLivingBase, float partialTickTime) {
  	    GL11.glScalef(0.5F, 0.5F, 0.5F);
  	}
    
    protected ResourceLocation getArrowTextures(final KlangiteSwordProjectile par1KlangiteSwordProjectile) {
        return KlangiteSwordProjectileRenderer.swordProjectile;
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return this.getArrowTextures((KlangiteSwordProjectile)entity);
    }
    
    static {
        swordProjectile = new ResourceLocation("nova_craft", "textures/entity/xancium_pellet.png");
    }
}
