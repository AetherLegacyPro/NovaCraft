package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntityRavager;
import com.NovaCraft.entity.misc.EnumRavagerType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RavagerRenderer extends RenderLiving {

    public RavagerRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    public void doRender(EntityRavager entityRavager, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        if (entityRavager.getType() == EnumRavagerType.BOSS) {
            BossStatus.setBossStatus(entityRavager, true);
            super.doRender((EntityLiving)entityRavager, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        }

        super.doRender((EntityLiving)entityRavager, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
        if (((EntityRavager)entity).getType() == EnumRavagerType.BOSS) {
            GL11.glScalef(2.0F, 2.0F, 2.0F);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return new ResourceLocation("textures/entity/ravager/" + ((EntityRavager)entity).getType() + ".png");
    }
}

