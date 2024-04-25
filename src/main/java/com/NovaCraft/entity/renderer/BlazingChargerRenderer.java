package com.NovaCraft.entity.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class BlazingChargerRenderer extends RenderLiving
{
    private static final ResourceLocation texture;
    
    public BlazingChargerRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return BlazingChargerRenderer.texture;
    }
    
    static {
        texture = new ResourceLocation("nova_craft","textures/entity/blazing_charger/blazing_charger.png");
    }
}
