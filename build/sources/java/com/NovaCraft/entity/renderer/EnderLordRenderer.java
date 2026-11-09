package com.NovaCraft.entity.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import com.NovaCraft.entity.EntityEnderLord;
import com.NovaCraft.entity.models.EnderLordModel;

@SideOnly(Side.CLIENT)
public class EnderLordRenderer extends RenderLiving
{
    private static final ResourceLocation endermanEyesTexture = new ResourceLocation("nova_craft","textures/entity/ender_brute/ender_brute_eyes.png");
    private static final ResourceLocation endermanTextures = new ResourceLocation("nova_craft","textures/entity/ender_brute/ender_brute.png");
    private EnderLordModel endermanModel;
    private Random rnd = new Random();

    public EnderLordRenderer()
    {
        super(new EnderLordModel(), 0.5F);
        this.endermanModel = (EnderLordModel)super.mainModel;
        this.setRenderPassModel(this.endermanModel);
    }

    public void doRender(EntityEnderLord entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {

        if (entity.isScreaming())
        {
            double d3 = 0.02D;
            p_76986_2_ += this.rnd.nextGaussian() * d3;
            p_76986_6_ += this.rnd.nextGaussian() * d3;
        }

        super.doRender((EntityLiving)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(EntityEnderLord entity)
    {
        return endermanTextures;
    }

    protected void renderEquippedItems(EntityEnderLord entity, float p_77029_2_)
    {
        super.renderEquippedItems(entity, p_77029_2_);

        if (entity.func_146080_bZ().getMaterial() != Material.air)
        {
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glPushMatrix();
            float f1 = 0.5F;
            GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
            f1 *= 1.0F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-f1, -f1, f1);
            int i = entity.getBrightnessForRender(p_77029_2_);
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.bindTexture(TextureMap.locationBlocksTexture);
            this.field_147909_c.renderBlockAsItem(entity.func_146080_bZ(), entity.getCarryingData(), 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        }
    }

    protected int shouldRenderPass(EntityEnderLord entity, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ != 0)
        {
            return -1;
        }
        else
        {
            this.bindTexture(endermanEyesTexture);
            float f1 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDisable(GL11.GL_LIGHTING);

            if (entity.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }
    
    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
        GL11.glScalef(1.25F, 1.25F, 1.25F);
    }

    public void doRender(EntityLiving entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityEnderLord)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected int shouldRenderPass(EntityLivingBase entity, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityEnderLord)entity, p_77032_2_, p_77032_3_);
    }

    protected void renderEquippedItems(EntityLivingBase entity, float p_77029_2_)
    {
        this.renderEquippedItems((EntityEnderLord)entity, p_77029_2_);
    }

    public void doRender(EntityLivingBase entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityEnderLord)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityEnderLord)entity);
    }

    public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityEnderLord)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}