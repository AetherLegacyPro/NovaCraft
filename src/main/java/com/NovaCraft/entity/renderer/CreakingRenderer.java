package com.NovaCraft.entity.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.EntityCreaking;
import com.NovaCraft.entity.misc.EnumCreakingType;
import com.NovaCraft.entity.models.CreakingModel;

@SideOnly(Side.CLIENT)
public class CreakingRenderer extends RenderLiving
{
	private static final ResourceLocation TEXTURE_OAK  = new ResourceLocation("textures/entity/creaking/OAK.png");
	private static final ResourceLocation TEXTURE_SPRUCE = new ResourceLocation("textures/entity/creaking/SPRUCE.png");
	private static final ResourceLocation TEXTURE_BIRCH = new ResourceLocation("textures/entity/creaking/BIRCH.png");	
	private static final ResourceLocation TEXTURE_JUNGLE = new ResourceLocation("textures/entity/creaking/JUNGLE.png");
	private static final ResourceLocation TEXTURE_DARK_OAK = new ResourceLocation("textures/entity/creaking/DARK_OAK.png");
	private static final ResourceLocation LUMINANT = new ResourceLocation("textures/entity/creaking/LUMINANT.png");
	
	private static final ResourceLocation OAK_eyes = new ResourceLocation("textures/entity/creaking/OAK_eyes.png");
	private static final ResourceLocation BIRCH_eyes = new ResourceLocation("textures/entity/creaking/BIRCH_eyes.png");
	private static final ResourceLocation SPRUCE_eyes = new ResourceLocation("textures/entity/creaking/SPRUCE_eyes.png");
	private static final ResourceLocation JUNGLE_eyes = new ResourceLocation("textures/entity/creaking/JUNGLE_eyes.png");
	private static final ResourceLocation DARK_OAK_eyes = new ResourceLocation("textures/entity/creaking/DARK_OAK_eyes.png");
	private static final ResourceLocation LUMINANT_eyes = new ResourceLocation("textures/entity/creaking/LUMINANT_eyes.png");
    
    private final CreakingModel CreakingModel;

    public CreakingRenderer()
    {
        super(new CreakingModel(), 0.5F);
        this.CreakingModel = (CreakingModel)this.mainModel;
        this.setRenderPassModel(this.CreakingModel);
    }

    public void doRender(EntityCreaking p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected void rotateCorpse(EntityCreaking p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        super.rotateCorpse(p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);

        if ((double)p_77043_1_.limbSwingAmount >= 0.01D)
        {
            float f3 = 13.0F;
            float f4 = p_77043_1_.limbSwing - p_77043_1_.limbSwingAmount * (1.0F - p_77043_4_) + 6.0F;
            float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
            GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
        }
    }
    
    protected int shouldRenderPass(EntityCreaking p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ != 0)
        {
            return -1;
        }
        else
        {
        	if (((EntityCreaking)p_77032_1_).getType() == EnumCreakingType.OAK) {
        		this.bindTexture(OAK_eyes);
        	}
        	else if (((EntityCreaking)p_77032_1_).getType() == EnumCreakingType.SPRUCE) {
                this.bindTexture(SPRUCE_eyes);
        	}
        	else if (((EntityCreaking)p_77032_1_).getType() == EnumCreakingType.BIRCH) {
                this.bindTexture(BIRCH_eyes);
        	}
        	else if (((EntityCreaking)p_77032_1_).getType() == EnumCreakingType.JUNGLE) {
                this.bindTexture(JUNGLE_eyes);
        	}
        	else if (((EntityCreaking)p_77032_1_).getType() == EnumCreakingType.DARK_OAK) {
                this.bindTexture(DARK_OAK_eyes);
        	}
        	else if (((EntityCreaking)p_77032_1_).getType() == EnumCreakingType.LUMINANT) {
                this.bindTexture(LUMINANT_eyes);
        	}
            float f1 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            //GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDisable(GL11.GL_LIGHTING);

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
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }

	protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityCreaking)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCreaking)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        this.rotateCorpse((EntityCreaking)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCreaking)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    @Override
	protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
	  	GL11.glScalef(1.00F, 1.00F, 1.00F);
	}

	@Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        return new ResourceLocation("textures/entity/creaking/" + ((EntityCreaking)entity).getType() + ".png");
    }
	
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCreaking)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
