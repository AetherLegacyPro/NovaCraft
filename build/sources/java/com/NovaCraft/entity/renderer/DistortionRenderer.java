package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntityDistortion;
import com.NovaCraft.entity.models.DistortionModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DistortionRenderer extends RenderLiving {
    private static final ResourceLocation EntityTexture;
    private static final ResourceLocation Overlay_1;
    private static final ResourceLocation Overlay_2;
    private static final ResourceLocation Overlay_3;

    public DistortionRenderer(final DistortionModel mainModel, final DistortionModel renderPassModel, final float shadowSize) {
        super((ModelBase)mainModel, shadowSize);
        this.setRenderPassModel((ModelBase)renderPassModel);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return DistortionRenderer.EntityTexture;
    }

    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityDistortion)par1EntityLivingBase, par2, par3);
    }

    protected int shouldRenderPass(final EntityDistortion distortion, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }

        int rand = (int)(1 + Math.random() * 3);
        switch (rand)
        {
            case 1:
                this.bindTexture(DistortionRenderer.Overlay_1);
                break;
            case 2:
                this.bindTexture(DistortionRenderer.Overlay_2);
                break;
            case 3:
                this.bindTexture(DistortionRenderer.Overlay_3);
                break;
        }
        return 1;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase mob, float partialTickTime) {
        GL11.glScalef(1.20F, 1.20F, 1.20F);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
        EntityDistortion distortion = (EntityDistortion) entity;
        BossStatus.setBossStatus(distortion, true);

        super.doRender(entity, x, y, z, yaw, partialTicks);
    }

    static {
        EntityTexture = new ResourceLocation("nova_craft", "textures/entity/distortion/distortion.png");
        Overlay_1 = new ResourceLocation("nova_craft", "textures/entity/distortion/overlay_1.png");
        Overlay_2 = new ResourceLocation("nova_craft", "textures/entity/distortion/overlay_2.png");
        Overlay_3 = new ResourceLocation("nova_craft", "textures/entity/distortion/overlay_3.png");
    }
}
