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
public class CreakingRenderer extends RenderLiving {
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[EnumCreakingType.values().length];

    static {
        for (EnumCreakingType type : EnumCreakingType.values()) {
            TEXTURES[type.ordinal()] = new ResourceLocation("textures/entity/creaking/" + type + ".png");
        }
    }
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

    public void doRender(EntityCreaking entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        super.doRender((EntityLiving)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected void rotateCorpse(EntityCreaking entity, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        super.rotateCorpse(entity, p_77043_2_, p_77043_3_, p_77043_4_);

        if ((double)entity.limbSwingAmount >= 0.01D)
        {
            float f3 = 13.0F;
            float f4 = entity.limbSwing - entity.limbSwingAmount * (1.0F - p_77043_4_) + 6.0F;
            float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
            GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
        }
    }
    
    protected int shouldRenderPass(EntityCreaking entity, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ != 0)
        {
            return -1;
        }
        else
        {
        	if (((EntityCreaking)entity).getType() == EnumCreakingType.OAK) {
        		this.bindTexture(OAK_eyes);
        	}
        	else if (((EntityCreaking)entity).getType() == EnumCreakingType.SPRUCE) {
                this.bindTexture(SPRUCE_eyes);
        	}
        	else if (((EntityCreaking)entity).getType() == EnumCreakingType.BIRCH) {
                this.bindTexture(BIRCH_eyes);
        	}
        	else if (((EntityCreaking)entity).getType() == EnumCreakingType.JUNGLE) {
                this.bindTexture(JUNGLE_eyes);
        	}
        	else if (((EntityCreaking)entity).getType() == EnumCreakingType.DARK_OAK) {
                this.bindTexture(DARK_OAK_eyes);
        	}
        	else if (((EntityCreaking)entity).getType() == EnumCreakingType.LUMINANT) {
                this.bindTexture(LUMINANT_eyes);
        	}
            float f1 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            //GL11.glDisable(GL11.GL_ALPHA_TEST);
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

	protected int shouldRenderPass(EntityLivingBase entity, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityCreaking)entity, p_77032_2_, p_77032_3_);
    }

    public void doRender(EntityLiving entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCreaking)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected void rotateCorpse(EntityLivingBase entity, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        this.rotateCorpse((EntityCreaking)entity, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    public void doRender(EntityLivingBase entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCreaking)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    @Override
	protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
	  	GL11.glScalef(1.00F, 1.00F, 1.00F);
	}

	@Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        return TEXTURES[((EntityCreaking)entity).getType().ordinal()];
    }
	
    public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCreaking)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
