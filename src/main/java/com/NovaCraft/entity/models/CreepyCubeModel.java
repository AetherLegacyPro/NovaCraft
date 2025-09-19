package com.NovaCraft.entity.models;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class CreepyCubeModel extends ModelBase
{
    ModelRenderer Cube;
    
    public CreepyCubeModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Cube = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-8.0f, -2.0f, -8.0f, 16, 16, 16);
        this.Cube.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.Cube.setTextureSize(64, 32);
        this.Cube.mirror = true;
        this.setRotation(this.Cube, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Cube.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    }
}
