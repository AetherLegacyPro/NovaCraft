package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FrontierGolemModel extends ModelBase {
    private final ModelRenderer base;

    public FrontierGolemModel() {
        textureWidth = 128;
        textureHeight = 128;

        base = new ModelRenderer(this);
        base.setRotationPoint(0.0F, 24.0F, 0.0F);
        base.cubeList.add(new ModelBox(base, 0, 0, -9.0F, -17.0F, -8.0F, 17, 17, 17, 0.0F));
        base.cubeList.add(new ModelBox(base, 0, 38, -6.0F, -27.0F, -7.0F, 11, 10, 10, 0.0F));
        base.cubeList.add(new ModelBox(base, 68, 41, -3.0F, -31.0F, 0.0F, 5, 4, 5, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        base.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
