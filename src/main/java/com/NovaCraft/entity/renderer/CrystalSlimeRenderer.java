package com.NovaCraft.entity.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.EntityCrystalSlime;

@SideOnly(Side.CLIENT)
public class CrystalSlimeRenderer extends RenderLiving
{
    private static final ResourceLocation TEXTURE_IRON  = new ResourceLocation("nova_craft", "textures/entity/crystal_slime/crystal_slime_iron.png");
    private static final ResourceLocation TEXTURE_GOLD = new ResourceLocation("nova_craft", "textures/entity/crystal_slime/crystal_slime_gold.png");
    private static final ResourceLocation TEXTURE_LAPIS = new ResourceLocation("nova_craft", "textures/entity/crystal_slime/crystal_slime_lapis.png");
    private static final ResourceLocation TEXTURE_EMERALD = new ResourceLocation("nova_craft", "textures/entity/crystal_slime/crystal_slime_emerald.png");
    private static final ResourceLocation TEXTURE_DIAMOND = new ResourceLocation("nova_craft", "textures/entity/crystal_slime/crystal_slime_diamond.png");
    private static final ResourceLocation TEXTURE_VANITE = new ResourceLocation("nova_craft", "textures/entity/crystal_slime/crystal_slime_vanite.png");
    private static final ResourceLocation TEXTURE_IRIDIUM = new ResourceLocation("nova_craft", "textures/entity/crystal_slime/crystal_slime_iridium.png");
    private static final ResourceLocation TEXTURE_CRYSTAL = new ResourceLocation("nova_craft", "textures/entity/crystal_slime/crystal_slime_crystal.png");
    private ModelBase scaleAmount;

    public CrystalSlimeRenderer(ModelBase p_i1267_1_, ModelBase p_i1267_2_, float p_i1267_3_)
    {
        super(p_i1267_1_, p_i1267_3_);
        this.scaleAmount = p_i1267_2_;
    }

    protected int shouldRenderPass(EntityCrystalSlime p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_1_.isInvisible())
        {
            return 0;
        }
        else if (p_77032_2_ == 0)
        {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            return 1;
        }
        else
        {
            if (p_77032_2_ == 1)
            {
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            return -1;
        }
    }

    protected void preRenderCallback(EntityCrystalSlime p_77041_1_, float p_77041_2_)
    {
        float f1 = (float)p_77041_1_.getSlimeSize();
        float f2 = (p_77041_1_.prevSquishFactor + (p_77041_1_.squishFactor - p_77041_1_.prevSquishFactor) * p_77041_2_) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.preRenderCallback((EntityCrystalSlime)p_77041_1_, p_77041_2_);
    }

    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityCrystalSlime)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    @Override
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return new ResourceLocation("nova_craft", "textures/entity/crystal_slime/" + ((EntityCrystalSlime)entity).getType() + ".png");
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCrystalSlime)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
