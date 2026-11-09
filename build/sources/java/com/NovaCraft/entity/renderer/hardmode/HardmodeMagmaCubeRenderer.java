package com.NovaCraft.entity.renderer.hardmode;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.hardmode.EntityHardmodeMagmaCube;
import com.NovaCraft.entity.models.hardmode.HardmodeMagmaCubeModel;

@SideOnly(Side.CLIENT)
public class HardmodeMagmaCubeRenderer extends RenderLiving
{
    private static final ResourceLocation magmaCubeTextures = new ResourceLocation("nova_craft", "textures/entity/hardmode/hardmode_magmacube.png");

    public HardmodeMagmaCubeRenderer()
    {
        super(new HardmodeMagmaCubeModel(), 0.25F);
    }

    protected ResourceLocation getEntityTexture(EntityHardmodeMagmaCube entity)
    {
        return magmaCubeTextures;
    }

    protected void preRenderCallback(EntityHardmodeMagmaCube entity, float p_77041_2_)
    {
        int i = entity.getSlimeSize();
        float f1 = (entity.prevSquishFactor + (entity.squishFactor - entity.prevSquishFactor) * p_77041_2_) / ((float)i * 0.5F + 1.0F);
        float f2 = 1.0F / (f1 + 1.0F);
        float f3 = (float)i;
        GL11.glScalef(f2 * f3, 1.0F / f2 * f3, f2 * f3);
    }

    protected void preRenderCallback(EntityLivingBase entity, float p_77041_2_)
    {
        this.preRenderCallback((EntityHardmodeMagmaCube)entity, p_77041_2_);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityHardmodeMagmaCube)entity);
    }
}
