package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntityGiantFrog;
import com.NovaCraft.entity.misc.EnumGiantFrogType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class GiantFrogRenderer extends RenderLiving {
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[EnumGiantFrogType.values().length];

    static {
        for (EnumGiantFrogType type : EnumGiantFrogType.values()) {
            TEXTURES[type.ordinal()] = new ResourceLocation("nova_craft","textures/entity/giant_frog/" + type + ".png");
        }
    }

    public GiantFrogRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
        GL11.glScalef(2.5F, 2.5F, 2.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return TEXTURES[((EntityGiantFrog)entity).getType().ordinal()];
    }

    public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityGiantFrog)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
