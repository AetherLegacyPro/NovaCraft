package com.NovaCraft.entity.renderer.hardmode;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.NovaCraft.entity.hardmode.EntityHardmodeSkeleton;
import com.NovaCraft.entity.models.hardmode.HardmodeSkeletonModel;

@SideOnly(Side.CLIENT)
public class HardmodeSkeletonRenderer extends RenderBiped
{
    private static final ResourceLocation skeletonTextures = new ResourceLocation("nova_craft", "textures/entity/hardmode/hardmode_skeleton.png");
    private static final ResourceLocation witherSkeletonTextures = new ResourceLocation("nova_craft", "textures/entity/hardmode/hardmode_meele_skeleton.png");

    public HardmodeSkeletonRenderer()
    {
        super(new HardmodeSkeletonModel(), 0.5F);
    }

    protected void preRenderCallback(EntityHardmodeSkeleton entity, float p_77041_2_)
    {
        if (entity.getSkeletonType() == 1)
        {
            GL11.glScalef(1.2F, 1.2F, 1.2F);
        }
    }

    protected void func_82422_c()
    {
        GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
    }

    protected ResourceLocation getEntityTexture(EntityHardmodeSkeleton entity)
    {
        return entity.getSkeletonType() == 1 ? witherSkeletonTextures : skeletonTextures;
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity)
    {
        return this.getEntityTexture((EntityHardmodeSkeleton)entity);
    }

    protected void preRenderCallback(EntityLivingBase entity, float p_77041_2_)
    {
        this.preRenderCallback((EntityHardmodeSkeleton)entity, p_77041_2_);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityHardmodeSkeleton)entity);
    }
}
