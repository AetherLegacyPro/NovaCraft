package com.NovaCraft.entity.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntitySculkHunger;
import com.NovaCraft.entity.models.SculkHungerModel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;

public class SculkHungerRenderer extends RenderLiving
{
    private static final ResourceLocation EntityTexture;
    private static final ResourceLocation OverlayTexture;
    
    public SculkHungerRenderer(final SculkHungerModel mainModel, final SculkHungerModel renderPassModel, final float shadowSize) {
        super((ModelBase)mainModel, shadowSize);
        this.setRenderPassModel((ModelBase)renderPassModel);
    }
    
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return SculkHungerRenderer.EntityTexture;
    }
    
    protected int setMobTextureGlow(final EntitySculkHunger entity, final int pass, final float partialTickTime) {
        final float flap = MathHelper.sin((entity.ticksExisted + partialTickTime) * 0.5f) * 0.6f;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.0f - flap * 0.5f, 0.0f);
        GL11.glPopMatrix();
        if (pass == 1) {
            final char c0 = '\uf0f0';
            final int j = c0 % 65536;
            final int k = c0 / 65536;
            this.bindTexture(SculkHungerRenderer.OverlayTexture);
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
    
    @Override
    protected void preRenderCallback(EntityLivingBase young_zephyr, float partialTickTime) {
        GL11.glScalef(0.8F, 0.8F, 0.8F);
    }
    
    protected int shouldRenderPass(final EntityLivingBase entity, final int pass, final float partialTickTime) {
        return this.setMobTextureGlow((EntitySculkHunger)entity, pass, partialTickTime);
    }
    
    static {
        EntityTexture = new ResourceLocation("nova_craft","textures/entity/sculk_hunger/sculk_hunger.png");
        OverlayTexture = new ResourceLocation("nova_craft","textures/entity/sculk_hunger/sculk_hunger_glow.png");
    }
}
