package com.NovaCraft.entity.renderer;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;

import com.NovaCraft.entity.EntityFirefly;
import com.NovaCraft.entity.models.FireflyModel;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class FireflyRenderer extends RenderLiving
{
    private static final ResourceLocation EntityTexture;
    private static final ResourceLocation OverlayTexture;
    
    public FireflyRenderer(final FireflyModel mainModel, final FireflyModel renderPassModel, final float shadowSize) {
        super((ModelBase)mainModel, shadowSize);
        this.setRenderPassModel((ModelBase)renderPassModel);
    }
    
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return FireflyRenderer.EntityTexture;
    }
    
    protected int setMobTextureGlow(final EntityFirefly entity, final int pass, final float partialTickTime) {
        final float flap = MathHelper.sin((entity.ticksExisted + partialTickTime) * 0.5f) * 0.6f;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.0f - flap * 0.5f, 0.0f);
        GL11.glPopMatrix();
        if (pass == 1) {
            final char c0 = '\uf0f0';
            final int j = c0 % 65536;
            final int k = c0 / 65536;
            this.bindTexture(FireflyRenderer.OverlayTexture);
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
        GL11.glScalef(0.5F, 0.5F, 0.5F);
    }
    
    protected int shouldRenderPass(final EntityLivingBase entity, final int pass, final float partialTickTime) {
        return this.setMobTextureGlow((EntityFirefly)entity, pass, partialTickTime);
    }
    
    static {
        EntityTexture = new ResourceLocation("nova_craft","textures/entity/firefly/firefly.png");
        OverlayTexture = new ResourceLocation("nova_craft","textures/entity/firefly/firefly_light.png");
    }
}
