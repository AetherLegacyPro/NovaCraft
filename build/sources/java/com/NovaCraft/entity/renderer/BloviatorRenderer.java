package com.NovaCraft.entity.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.EntityBloviator;
import com.NovaCraft.entity.models.BloviatorModel;

@SideOnly(Side.CLIENT)
public class BloviatorRenderer extends RenderLiving
{
    private static final ResourceLocation ghastTextures = new ResourceLocation("nova_craft", "textures/entity/bloviator/bloviator.png");
    private static final ResourceLocation ghastShootingTextures = new ResourceLocation("nova_craft", "textures/entity/bloviator/bloviator_fire.png");

    public BloviatorRenderer()
    {
        super(new BloviatorModel(), 2.0F);
    }

    protected ResourceLocation getEntityTexture(EntityBloviator entity)
    {
        return entity.func_110182_bF() ? ghastShootingTextures : ghastTextures;
    }

    protected void preRenderCallback(EntityBloviator entity, float p_77041_2_)
    {
        float f1 = ((float)entity.prevAttackCounter + (float)(entity.attackCounter - entity.prevAttackCounter) * p_77041_2_) / 20.0F;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        f1 = 1.0F / (f1 * f1 * f1 * f1 * f1 * 2.0F + 1.0F);
        float f2 = (8.0F + f1) / 2.0F;
        float f3 = (8.0F + 1.0F / f1) / 2.0F;
        GL11.glScalef(f3, f2, f3);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    protected void preRenderCallback(EntityLivingBase entity, float p_77041_2_)
    {
        this.preRenderCallback((EntityBloviator)entity, p_77041_2_);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
    }
    
    public void doRender(EntityBloviator entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        BossStatus.setBossStatus(entity, true);

        super.doRender((EntityLiving)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    public void doRender(EntityLiving entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityBloviator)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
 
    public void doRender(EntityLivingBase entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityBloviator)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
 	}
 
    public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityBloviator)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityBloviator)entity);
    }
}