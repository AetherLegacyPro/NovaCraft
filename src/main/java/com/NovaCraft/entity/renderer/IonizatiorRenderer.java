package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityIonizatior;
import com.NovaCraft.entity.models.IonizatiorModel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class IonizatiorRenderer extends RenderLiving
{
    private static final ResourceLocation blazeTextures = new ResourceLocation("nova_craft", "textures/entity/ionizatior/ionizatior.png");
    private int field_77068_a;

    public IonizatiorRenderer()
    {
        super(new IonizatiorModel(), 0.7F);
        this.field_77068_a = ((IonizatiorModel)this.mainModel).func_78104_a();
    }

    public void doRender(EntityIonizatior p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        int i = ((IonizatiorModel)this.mainModel).func_78104_a();

        if (i != this.field_77068_a)
        {
            this.field_77068_a = i;
            this.mainModel = new IonizatiorModel();
        }

        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(EntityIonizatior p_110775_1_)
    {
        return blazeTextures;
    }

    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityIonizatior)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityIonizatior)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityIonizatior)p_110775_1_);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityIonizatior)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    protected void preRenderCallback(EntityLivingBase entityLivingBase, float partialTickTime)
    {
        GL11.glScalef(1.1F, 1.1F, 1.1F);
    }
}
