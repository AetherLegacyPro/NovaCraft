package com.NovaCraft.entity.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class PhantomModel extends ModelBase
{
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer leftWingBody;
    private final ModelRenderer leftWing;
    private final ModelRenderer rightWingBody;
    private final ModelRenderer rightWing;
    private final ModelRenderer tail1;
    private final ModelRenderer tail2;
    
    public PhantomModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.body = new ModelRenderer((ModelBase)this, 0, 8)).addBox(-3.0f, 12.0f, -8.0f, 5, 3, 9);
        (this.tail1 = new ModelRenderer((ModelBase)this, 3, 20)).addBox(-2.0f, 0.0f, 0.0f, 3, 2, 6);
        this.tail1.setRotationPoint(0.0f, 12.0f, 1.0f);
        this.body.addChild(this.tail1);
        (this.tail2 = new ModelRenderer((ModelBase)this, 4, 29)).addBox(-1.0f, 0.0f, 0.0f, 1, 1, 6);
        this.tail2.setRotationPoint(0.0f, 0.5f, 6.0f);
        this.tail1.addChild(this.tail2);
        (this.leftWingBody = new ModelRenderer((ModelBase)this, 23, 12)).addBox(0.0f, 0.0f, 0.0f, 6, 2, 9);
        this.leftWingBody.setRotationPoint(2.0f, 12.0f, -8.0f);
        (this.leftWing = new ModelRenderer((ModelBase)this, 16, 24)).addBox(0.0f, 0.0f, 0.0f, 13, 1, 9);
        this.leftWing.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.leftWingBody.addChild(this.leftWing);
        this.rightWingBody = new ModelRenderer((ModelBase)this, 23, 12);
        this.rightWingBody.mirror = true;
        this.rightWingBody.addBox(-6.0f, 0.0f, 0.0f, 6, 2, 9);
        this.rightWingBody.setRotationPoint(-3.0f, 12.0f, -8.0f);
        this.rightWing = new ModelRenderer((ModelBase)this, 16, 24);
        this.rightWing.mirror = true;
        this.rightWing.addBox(-13.0f, 0.0f, 0.0f, 13, 1, 9);
        this.rightWing.setRotationPoint(-6.0f, 0.0f, 0.0f);
        this.rightWingBody.addChild(this.rightWing);
        this.leftWingBody.rotateAngleZ = 0.1f;
        this.leftWing.rotateAngleZ = 0.1f;
        this.rightWingBody.rotateAngleZ = -0.1f;
        this.rightWing.rotateAngleZ = -0.1f;
        this.body.rotateAngleX = -0.1f;
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -2.0f, -5.0f, 7, 3, 5);
        this.head.setRotationPoint(0.0f, 14.0f, -7.0f);
        this.head.rotateAngleX = 0.2f;
        this.body.addChild(this.head);
        this.body.addChild(this.leftWingBody);
        this.body.addChild(this.rightWingBody);
    }
    
    public void render(final Entity entity, final float limbSwing, final float limbSwingAngle, final float entityTickTime, final float rotationYaw, final float rotationPitch, final float unitPixel) {
        super.render(entity, limbSwing, limbSwingAngle, entityTickTime, rotationYaw, rotationPitch, unitPixel);
        this.setRotationAngles(limbSwing, limbSwingAngle, entityTickTime, rotationYaw, rotationPitch, unitPixel, entity);
        this.body.render(unitPixel);
    }
    
    public void setRotationAngles(final float limbSwing, final float limbSwingAngle, final float entityTickTime, final float rotationYaw, final float rotationPitch, final float unitPixel, final Entity entity) {
        final float f = 9.424778f + entityTickTime * 0.13f;
        final float f2 = 16.0f;
        this.head.rotateAngleY = rotationYaw / 57.295776f;
        this.head.rotateAngleX = rotationPitch / 57.295776f;
        this.leftWingBody.rotateAngleZ = MathHelper.cos(f) * 16.0f * 0.017453292f;
        this.leftWing.rotateAngleZ = MathHelper.cos(f) * 16.0f * 0.017453292f;
        this.rightWingBody.rotateAngleZ = -this.leftWingBody.rotateAngleZ;
        this.rightWing.rotateAngleZ = -this.leftWing.rotateAngleZ;
        this.tail1.rotateAngleX = -(5.0f + MathHelper.cos(f * 2.0f) * 5.0f) * 0.017453292f;
        this.tail2.rotateAngleX = -(5.0f + MathHelper.cos(f * 2.0f) * 5.0f) * 0.017453292f;
    }
}
