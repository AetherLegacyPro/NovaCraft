package com.NovaCraft.entity.renderer;

import net.minecraft.entity.Entity;

import com.NovaCraft.entity.models.CreepyCubeModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;

public class CreepyCubeRenderer extends RenderLiving
{
    protected CreepyCubeModel creepycube_model;
    private static final ResourceLocation texture;
    
    public CreepyCubeRenderer(final CreepyCubeModel model, final float par2) {
        this(model, par2, 1.0f);
        this.creepycube_model = model;
    }
    
    public CreepyCubeRenderer(final CreepyCubeModel model, final float par2, final float par3) {
        super((ModelBase)model, par2);
        this.creepycube_model = model;
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return CreepyCubeRenderer.texture;
    }
    
    static {
        texture = new ResourceLocation("nova_craft", "textures/entity/creepy_cube/creepy_cube.png");
    }
}
