package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.misc.EnumGolemType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.EntityCrystalGolem;
import com.NovaCraft.entity.models.CrystalGolemModel;

@SideOnly(Side.CLIENT)
public class CrystalGolemRenderer extends RenderLiving {
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[EnumGolemType.values().length];

    static
    {
        for (EnumGolemType type : EnumGolemType.values())
        {
            TEXTURES[type.ordinal()] = new ResourceLocation("nova_craft", "textures/entity/crystal_golem/" + type + ".png");
        }
    }

    private final CrystalGolemModel crystalGolemModel;

    public CrystalGolemRenderer()
    {
        super(new CrystalGolemModel(), 0.5F);
        this.crystalGolemModel = (CrystalGolemModel)this.mainModel;
    }

    public void doRender(EntityCrystalGolem entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        super.doRender((EntityLiving)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected void rotateCorpse(EntityCrystalGolem entity, float p_77043_2_, float p_77043_3_, float p_77043_4_)
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

    public void doRender(EntityLiving entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCrystalGolem)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected void rotateCorpse(EntityLivingBase entity, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        this.rotateCorpse((EntityCrystalGolem)entity, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    public void doRender(EntityLivingBase entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCrystalGolem)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    @Override
	protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
	  	GL11.glScalef(1.05F, 1.05F, 1.05F);
	}

	@Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        return TEXTURES[((EntityCrystalGolem)entity).getType().ordinal()];
    }
	
    public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCrystalGolem)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
