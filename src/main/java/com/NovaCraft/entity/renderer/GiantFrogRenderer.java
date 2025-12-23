package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntityGiantFrog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class GiantFrogRenderer extends RenderLiving
{
    public GiantFrogRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
        GL11.glScalef(2.5F, 2.5F, 2.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return new ResourceLocation("nova_craft","textures/entity/giant_frog/" + ((EntityGiantFrog)entity).getType() + ".png");
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityGiantFrog)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
