package com.NovaCraft.entity.renderer.hardmode;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.hardmode.EntityHardmodeSpider;
import com.NovaCraft.entity.models.hardmode.HardmodeSpiderModel;

@SideOnly(Side.CLIENT)
public class HardmodeSpiderRenderer extends RenderLiving
{
    private static final ResourceLocation spiderEyesTextures = new ResourceLocation("nova_craft", "textures/entity/hardmode/hardmore_spider_eyes.png");
    private static final ResourceLocation spiderTextures = new ResourceLocation("nova_craft", "textures/entity/hardmode/hardmore_spider.png");

    public HardmodeSpiderRenderer()
    {
        super(new HardmodeSpiderModel(), 1.0F);
        this.setRenderPassModel(new HardmodeSpiderModel());
    }

    protected float getDeathMaxRotation(EntityHardmodeSpider p_77037_1_)
    {
        return 180.0F;
    }

    protected int shouldRenderPass(EntityHardmodeSpider p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ != 0)
        {
            return -1;
        }
        else
        {
            this.bindTexture(spiderEyesTextures);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

            if (p_77032_1_.isInvisible())
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
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
        }
    }

    protected ResourceLocation getEntityTexture(EntityHardmodeSpider p_110775_1_)
    {
        return spiderTextures;
    }

    protected float getDeathMaxRotation(EntityLivingBase p_77037_1_)
    {
        return this.getDeathMaxRotation((EntityHardmodeSpider)p_77037_1_);
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityHardmodeSpider)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityHardmodeSpider)p_110775_1_);
    }
}
