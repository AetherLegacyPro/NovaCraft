package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntityPhantomized;
import com.NovaCraft.entity.models.PhantomizedModel;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class PhantomizedRenderer extends RenderLiving {
    private static final ResourceLocation Entity;
    private static final ResourceLocation glow;

    public PhantomizedRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.setRenderPassModel((ModelBase)new PhantomizedModel());
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entityliving, float f) {
        float f1 = 1.25F;
        GL11.glScalef(f1, f1, f1);
    }

    protected int renderEyeGlow(EntityPhantomized entity, int pass, float particleTicks) {
        if (pass == 0 && entity.isAwake()) {
            this.bindTexture(glow);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

            if (entity.isInvisible()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
        }

        return -1;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
        EntityPhantomized phantomized = (EntityPhantomized) entity;
        if (phantomized.isAwake()) {
            BossStatus.setBossStatus(phantomized, true);
        }

        super.doRender(entity, x, y, z, yaw, partialTicks);
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase entity, int pass, float particleTicks) {
        return this.renderEyeGlow((EntityPhantomized) entity, pass, particleTicks);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return !((EntityPhantomized) entity).isAwake() ? Entity : glow;
    }

    static {
        Entity = new ResourceLocation("nova_craft","textures/entity/phantomized/phantomized_off.png");
        glow = new ResourceLocation("nova_craft","textures/entity/phantomized/phantomized_on.png");
    }
}
