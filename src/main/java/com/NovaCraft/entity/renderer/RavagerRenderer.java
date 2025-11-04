package com.NovaCraft.entity.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RavagerRenderer extends RenderLiving
{
    private static final ResourceLocation texture;

    public RavagerRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RavagerRenderer.texture;
    }

    static {
        texture = new ResourceLocation("textures/entity/ravager/ravager.png");
    }
}

