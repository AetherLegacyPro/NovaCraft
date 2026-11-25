package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class NotImportantModel extends ModelBase {
    private final ModelRenderer eyes;

    public NotImportantModel() {
        textureWidth = 16;
        textureHeight = 16;

        eyes = new ModelRenderer(this);
        eyes.setRotationPoint(0.0F, 0.0F, 0.0F);
        eyes.cubeList.add(new ModelBox(eyes, 4, 7, 4.0F, -11.0F, -4.0F, 0, 1, 2, 0.0F));
        eyes.cubeList.add(new ModelBox(eyes, 9, 7, 4.0F, -11.0F, 1.0F, 0, 1, 2, 0.0F));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        eyes.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
