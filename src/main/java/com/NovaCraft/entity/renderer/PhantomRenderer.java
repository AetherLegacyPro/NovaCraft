package com.NovaCraft.entity.renderer;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import com.NovaCraft.entity.EntityPhantom;
import com.NovaCraft.entity.models.PhantomModel;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class PhantomRenderer extends RenderLiving
{
    private static final ResourceLocation EntityTexture;
    private static final ResourceLocation OverlayTexture;
    
    public PhantomRenderer(final PhantomModel mainModel, final PhantomModel renderPassModel, final float shadowSize) {
        super((ModelBase)mainModel, shadowSize);
        this.setRenderPassModel((ModelBase)renderPassModel);
    }
    
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return PhantomRenderer.EntityTexture;
    }
    
    protected int setMobTextureGlow(final EntityPhantom entity, final int pass, final float partialTickTime) {
        final float flap = MathHelper.sin((entity.ticksExisted + partialTickTime) * 0.5f) * 0.6f;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.0f - flap * 0.5f, 0.0f);
        GL11.glPopMatrix();
        if (pass == 1) {
            final char c0 = '\uf0f0';
            final int j = c0 % 65536;
            final int k = c0 / 65536;
            this.bindTexture(PhantomRenderer.OverlayTexture);
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
        return this.setMobTextureGlow((EntityPhantom)entity, pass, partialTickTime);
    }
    
    static {
        EntityTexture = new ResourceLocation("textures/entity/phantom/phantom.png");
        OverlayTexture = new ResourceLocation("textures/entity/phantom/phantom_eyes.png");
    }
}
