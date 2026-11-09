package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.misc.EnumCrystalSlimeType;
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
public class CrystalSlimeRenderer extends RenderLiving {
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[EnumCrystalSlimeType.values().length];

    static {
        for (EnumCrystalSlimeType type : EnumCrystalSlimeType.values()) {
            TEXTURES[type.ordinal()] = new ResourceLocation("nova_craft", "textures/entity/crystal_slime/" + type + ".png");
        }
    }

    private ModelBase scaleAmount;

    public CrystalSlimeRenderer(ModelBase p_i1267_1_, ModelBase p_i1267_2_, float p_i1267_3_)
    {
        super(p_i1267_1_, p_i1267_3_);
        this.scaleAmount = p_i1267_2_;
    }

    protected int shouldRenderPass(EntityCrystalSlime entity, int p_77032_2_, float p_77032_3_)
    {
        if (entity.isInvisible())
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

    protected void preRenderCallback(EntityCrystalSlime entity, float p_77041_2_)
    {
        float f1 = (float)entity.getSlimeSize();
        float f2 = (entity.prevSquishFactor + (entity.squishFactor - entity.prevSquishFactor) * p_77041_2_) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    protected void preRenderCallback(EntityLivingBase entity, float p_77041_2_)
    {
        this.preRenderCallback((EntityCrystalSlime)entity, p_77041_2_);
    }

    protected int shouldRenderPass(EntityLivingBase entity, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityCrystalSlime)entity, p_77032_2_, p_77032_3_);
    }

    @Override
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return TEXTURES[((EntityCrystalSlime)entity).getType().ordinal()];
    }

    public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityCrystalSlime)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
