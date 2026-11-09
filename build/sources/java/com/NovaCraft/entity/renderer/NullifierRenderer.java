package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntityNullifier;
import com.NovaCraft.entity.models.NullifierModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class NullifierRenderer extends RenderLiving {
    private static final ResourceLocation ARMORED_TEXTURE = new ResourceLocation("nova_craft", "textures/entity/nullifier/nullifier_armor.png");
    private static final ResourceLocation BASE_TEXTURE = new ResourceLocation("nova_craft", "textures/entity/nullifier/nullifier.png");
    private static final ResourceLocation GLOW_TEXTURE = new ResourceLocation("nova_craft", "textures/entity/nullifier/glow.png");

    private static final float SPAZ_YAW_AMOUNT = 25.0F;
    private static final float SPAZ_PITCH_AMOUNT = 15.0F;

    private final ModelBase creeperModel = new NullifierModel(2.0F);

    public NullifierRenderer() {
        super(new NullifierModel(), 0.5F);
    }

    protected void preRenderCallback(EntityNullifier entity, float partialTicks) {
        float flashIntensity = entity.getCreeperFlashIntensity(partialTicks);
        float pulse = 1.0F + MathHelper.sin(flashIntensity * 100.0F) * flashIntensity * 0.01F;

        if (flashIntensity < 0.0F) {
            flashIntensity = 0.0F;
        }

        if (flashIntensity > 1.0F) {
            flashIntensity = 1.0F;
        }

        flashIntensity *= flashIntensity;
        flashIntensity *= flashIntensity;

        float horizontalScale = (1.0F + flashIntensity * 0.4F) * pulse;
        float verticalScale = (1.0F + flashIntensity * 0.1F) / pulse;

        GL11.glScalef(horizontalScale, verticalScale, horizontalScale);
    }

    /**
     * Applies a render-only twitch while the entity is actively swelling.
     *
     * The creeper state is stored in a DataWatcher, so it is available on
     * the client. This does not alter server rotation, navigation, or AI.
     */
    @Override
    protected void rotateCorpse(EntityLivingBase living, float ageInTicks, float rotationYaw, float partialTicks) {
        EntityNullifier entity = (EntityNullifier)living;
        if (entity.getCreeperState() > 0) {
            float yawShake = MathHelper.sin(ageInTicks * 4.7F) * SPAZ_YAW_AMOUNT;
            yawShake += MathHelper.sin(ageInTicks * 9.3F) * 8.0F;
            rotationYaw += yawShake;
        }

        super.rotateCorpse(living, ageInTicks, rotationYaw, partialTicks);

        if (entity.getCreeperState() > 0) {
            float pitchShake = MathHelper.sin(ageInTicks * 6.1F) * SPAZ_PITCH_AMOUNT;
            GL11.glRotatef(pitchShake, 1.0F, 0.0F, 0.0F);
        }
    }

    protected int getColorMultiplier(EntityNullifier entity, float lightBrightness, float partialTicks) {
        float flashIntensity = entity.getCreeperFlashIntensity(partialTicks);

        if ((int)(flashIntensity * 10.0F) % 2 == 0) {
            return 0;
        }

        int alpha = (int)(flashIntensity * 0.2F * 255.0F);

        if (alpha < 0) {
            alpha = 0;
        }

        if (alpha > 255) {
            alpha = 255;
        }

        return alpha << 24 | 255 << 16 | 255 << 8 | 255;
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase living, int pass, float partialTicks) {
        EntityNullifier entity = (EntityNullifier)living;

        if (pass == 0) {
            this.setRenderPassModel(this.mainModel);
            this.bindTexture(GLOW_TEXTURE);

            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDepthMask(!entity.isInvisible());

            int fullBrightness = 61680;
            int low = fullBrightness % 65536;
            int high = fullBrightness / 65536;

            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)low, (float)high);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            return 1;
        }

        if (pass == 1 && entity.getPowered()) {
            float time = (float)entity.ticksExisted + partialTicks;

            this.setRenderPassModel(this.creeperModel);
            this.bindTexture(ARMORED_TEXTURE);

            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glLoadIdentity();
            GL11.glTranslatef(time * 0.01F, time * 0.01F, 0.0F);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);

            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDepthMask(!entity.isInvisible());
            GL11.glColor4f(0.5F, 0.5F, 0.5F, 1.0F);

            return 1;
        }

        if (pass == 2 && entity.getPowered()) {
            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(GL11.GL_MODELVIEW);

            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDepthMask(true);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }

        return -1;
    }

    protected int inheritRenderPass(EntityNullifier entity, int pass, float partialTicks) {
        return -1;
    }

    protected ResourceLocation getEntityTexture(EntityNullifier entity) {
        return BASE_TEXTURE;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTicks) {
        this.preRenderCallback((EntityNullifier)entity, partialTicks);
    }

    @Override
    protected int getColorMultiplier(EntityLivingBase entity, float lightBrightness, float partialTicks) {
        return this.getColorMultiplier((EntityNullifier)entity, lightBrightness, partialTicks);
    }

    @Override
    protected int inheritRenderPass(EntityLivingBase entity, int pass, float partialTicks) {
        return this.inheritRenderPass((EntityNullifier)entity, pass, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityNullifier)entity);
    }
}