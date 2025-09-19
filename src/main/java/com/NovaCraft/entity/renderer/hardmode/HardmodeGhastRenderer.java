package com.NovaCraft.entity.renderer.hardmode;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.hardmode.EntityHardmodeGhast;
import com.NovaCraft.entity.models.hardmode.HardmodeGhastModel;

@SideOnly(Side.CLIENT)
public class HardmodeGhastRenderer extends RenderLiving
{
    private static final ResourceLocation ghastTextures = new ResourceLocation("nova_craft", "textures/entity/hardmode/hardmode_ghast.png");
    private static final ResourceLocation ghastShootingTextures = new ResourceLocation("nova_craft", "textures/entity/hardmode/hardmode_ghast_shooting.png");

    public HardmodeGhastRenderer()
    {
        super(new HardmodeGhastModel(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityHardmodeGhast p_110775_1_)
    {
        return p_110775_1_.func_110182_bF() ? ghastShootingTextures : ghastTextures;
    }

    protected void preRenderCallback(EntityHardmodeGhast p_77041_1_, float p_77041_2_)
    {
        float f1 = ((float)p_77041_1_.prevAttackCounter + (float)(p_77041_1_.attackCounter - p_77041_1_.prevAttackCounter) * p_77041_2_) / 20.0F;

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
    
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.preRenderCallback((EntityHardmodeGhast)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityHardmodeGhast)p_110775_1_);
    }
}
