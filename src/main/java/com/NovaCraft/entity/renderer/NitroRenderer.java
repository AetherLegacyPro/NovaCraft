package com.NovaCraft.entity.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityNitro;
import com.NovaCraft.entity.models.NitroModel;

@SideOnly(Side.CLIENT)
public class NitroRenderer extends RenderLiving
{
    private static final ResourceLocation armor;
    private static final ResourceLocation chaotic1;
    private static final ResourceLocation chaotic2;
    private static final ResourceLocation chaotic3;
    private static final ResourceLocation chaotic4;
    private static final ResourceLocation chaotic5;
    private static final ResourceLocation chaotic6;

    private ModelBase creeperModel = new NitroModel(2.0F);

    public NitroRenderer()
    {
        super(new NitroModel(), 0.5F);
        this.setRenderPassModel((ModelBase)new NitroModel());
    }

    protected void preRenderCallback(EntityNitro p_77041_1_, float p_77041_2_)
    {
        float f1 = p_77041_1_.getCreeperFlashIntensity(p_77041_2_);
        float f2 = 1.0F + MathHelper.sin(f1 * 100.0F) * f1 * 0.01F;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        if (f1 > 1.0F)
        {
            f1 = 1.0F;
        }

        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0F + f1 * 0.4F) * f2;
        float f4 = (1.0F + f1 * 0.1F) / f2;
        GL11.glScalef(f3, f4, f3);
    }

    protected int getColorMultiplier(EntityNitro p_77030_1_, float p_77030_2_, float p_77030_3_)
    {
        float f2 = p_77030_1_.getCreeperFlashIntensity(p_77030_3_);

        if ((int)(f2 * 10.0F) % 2 == 0)
        {
            return 0;
        }
        else
        {
            int i = (int)(f2 * 0.2F * 255.0F);

            if (i < 0)
            {
                i = 0;
            }

            if (i > 255)
            {
                i = 255;
            }

            short short1 = 255;
            short short2 = 255;
            short short3 = 255;
            return i << 24 | short1 << 16 | short2 << 8 | short3;
        }
    }

    protected int shouldRenderPass(EntityNitro p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
    	if (p_77032_2_ != 0) {
            return -1;
        }
        if (p_77032_1_.getPowered())
        {
            if (p_77032_1_.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            if (p_77032_2_ == 1)
            {
                float f1 = (float)p_77032_1_.ticksExisted + p_77032_3_;
                this.bindTexture(NitroRenderer.armor);
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                float f2 = f1 * 0.01F;
                float f3 = f1 * 0.01F;
                GL11.glTranslatef(f2, f3, 0.0F);
                this.setRenderPassModel(this.creeperModel);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_BLEND);
                float f4 = 0.5F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
                return 1;
            }

            if (p_77032_2_ == 2)
            {
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_BLEND);
            }
        }
        
        int rand = (int)(1 + Math.random() * 6);
		switch (rand)
        {
          case 1:
        	this.bindTexture(NitroRenderer.chaotic2);
          case 2:
          	this.bindTexture(NitroRenderer.chaotic2);
          case 3:
          	this.bindTexture(NitroRenderer.chaotic3);
          case 4:
            this.bindTexture(NitroRenderer.chaotic4);
          case 5:
            this.bindTexture(NitroRenderer.chaotic5);
          case 6:
            this.bindTexture(NitroRenderer.chaotic6);
        }

        return 1;
    }

    protected int inheritRenderPass(EntityNitro p_77035_1_, int p_77035_2_, float p_77035_3_)
    {
        return -1;
    }

    protected ResourceLocation getEntityTexture(EntityNitro p_110775_1_)
    {
        return NitroRenderer.chaotic1;
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.preRenderCallback((EntityNitro)p_77041_1_, p_77041_2_);
        GL11.glScalef(1.1F, 1.1F, 1.1F);
    }

    protected int getColorMultiplier(EntityLivingBase p_77030_1_, float p_77030_2_, float p_77030_3_)
    {
        return this.getColorMultiplier((EntityNitro)p_77030_1_, p_77030_2_, p_77030_3_);
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityNitro)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected int inheritRenderPass(EntityLivingBase p_77035_1_, int p_77035_2_, float p_77035_3_)
    {
        return this.inheritRenderPass((EntityNitro)p_77035_1_, p_77035_2_, p_77035_3_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityNitro)p_110775_1_);
    }
    
    static {
		 armor = new ResourceLocation("nova_craft", "textures/entity/nitro/nitro_armor.png");
		 chaotic1 = new ResourceLocation("nova_craft", "textures/entity/nitro/nitro.png");
		 chaotic2 = new ResourceLocation("nova_craft", "textures/entity/nitro/2.png");
		 chaotic3 = new ResourceLocation("nova_craft", "textures/entity/nitro/3.png");
		 chaotic4 = new ResourceLocation("nova_craft", "textures/entity/nitro/4.png");
		 chaotic5 = new ResourceLocation("nova_craft", "textures/entity/nitro/5.png");
		 chaotic6 = new ResourceLocation("nova_craft", "textures/entity/nitro/6.png");
	    }
}
