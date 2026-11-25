package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.models.NotImportantModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class NotImportantRenderer extends RenderLiving {
    private static final ResourceLocation ENTITY_TEXTURE = new ResourceLocation("nova_craft", "textures/entity/hardmode/eyes.png");

    public NotImportantRenderer(NotImportantModel mainModel, NotImportantModel renderPassModel, float shadowSize) {
        super(mainModel, shadowSize);
        this.setRenderPassModel(renderPassModel != null ? renderPassModel : mainModel);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return ENTITY_TEXTURE;
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase entity, int pass, float partialTicks) {
        if (pass == 0) {
            this.bindTexture(ENTITY_TEXTURE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
            GL11.glDepthMask(!entity.isInvisible());
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            return 1;
        }

        if (pass == 1) {
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDepthMask(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            int brightness = entity.getBrightnessForRender(partialTicks);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)(brightness & 65535), (float)(brightness >>> 16));
        }

        return -1;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTicks) {
        GL11.glScalef(1.20F, 1.20F, 1.20F);
    }
}