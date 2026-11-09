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

    public void doRender(EntityIonizatior entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        int i = ((IonizatiorModel)this.mainModel).func_78104_a();

        if (i != this.field_77068_a)
        {
            this.field_77068_a = i;
            this.mainModel = new IonizatiorModel();
        }

        super.doRender((EntityLiving)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(EntityIonizatior entity)
    {
        return blazeTextures;
    }

    public void doRender(EntityLiving entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityIonizatior)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    public void doRender(EntityLivingBase entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityIonizatior)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityIonizatior)entity);
    }

    public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityIonizatior)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    @Override
    protected void preRenderCallback(EntityLivingBase entityLivingBase, float partialTickTime)
    {
        GL11.glScalef(1.1F, 1.1F, 1.1F);
    }
}
