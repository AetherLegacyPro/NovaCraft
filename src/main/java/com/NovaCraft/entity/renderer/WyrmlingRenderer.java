package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntityWyrmling;
import com.NovaCraft.entity.models.WyrmlingModel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class WyrmlingRenderer extends RenderLiving
{
    private static final ResourceLocation EntityTexture;
    private static final ResourceLocation OverlayTexture1;
    private static final ResourceLocation OverlayTexture2;
    private static final ResourceLocation OverlayTexture3;
    private static final ResourceLocation OverlayTexture4;
    private static final ResourceLocation OverlayTexture5;
    private static final ResourceLocation OverlayTexture6;
    private static final ResourceLocation OverlayTexture7;

    public WyrmlingRenderer(final WyrmlingModel mainModel, final WyrmlingModel renderPassModel, final float shadowSize) {
        super((ModelBase)mainModel, shadowSize);
        this.setRenderPassModel((ModelBase)renderPassModel);
    }

    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return WyrmlingRenderer.EntityTexture;
    }

    protected int setMobTextureGlow(final EntityWyrmling entity, final int pass, final float partialTickTime) {
        final float flap = MathHelper.sin((entity.ticksExisted + partialTickTime) * 0.5f) * 0.6f;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.0f - flap * 0.5f, 0.0f);
        GL11.glPopMatrix();
        if (pass == 1) {
            final char c0 = '\uf0f0';
            final int j = c0 % 65536;
            final int k = c0 / 65536;
            int rand = (int)(1 + Math.random() * 7);
            switch (rand) {
                case 1:
                    this.bindTexture(WyrmlingRenderer.OverlayTexture1);
                    break;
                case 2:
                    this.bindTexture(WyrmlingRenderer.OverlayTexture2);
                    break;
                case 3:
                    this.bindTexture(WyrmlingRenderer.OverlayTexture3);
                    break;
                case 4:
                    this.bindTexture(WyrmlingRenderer.OverlayTexture4);
                    break;
                case 5:
                    this.bindTexture(WyrmlingRenderer.OverlayTexture5);
                    break;
                case 6:
                    this.bindTexture(WyrmlingRenderer.OverlayTexture6);
                    break;
                case 7:
                    this.bindTexture(WyrmlingRenderer.OverlayTexture7);
                    break;
            }
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
        return this.setMobTextureGlow((EntityWyrmling)entity, pass, partialTickTime);
    }

    static {
        EntityTexture = new ResourceLocation("nova_craft", "textures/entity/wyrmling/wyrmling.png");
        OverlayTexture1 = new ResourceLocation("nova_craft", "textures/entity/wyrmling/red_overlay.png");
        OverlayTexture2 = new ResourceLocation("nova_craft", "textures/entity/wyrmling/orange_overlay.png");
        OverlayTexture3 = new ResourceLocation("nova_craft", "textures/entity/wyrmling/yellow_overlay.png");
        OverlayTexture4 = new ResourceLocation("nova_craft", "textures/entity/wyrmling/light_green_overlay.png");
        OverlayTexture5 = new ResourceLocation("nova_craft", "textures/entity/wyrmling/green_overlay.png");
        OverlayTexture6 = new ResourceLocation("nova_craft", "textures/entity/wyrmling/blue_overlay.png");
        OverlayTexture7 = new ResourceLocation("nova_craft", "textures/entity/wyrmling/violet_overlay.png");
    }
}
