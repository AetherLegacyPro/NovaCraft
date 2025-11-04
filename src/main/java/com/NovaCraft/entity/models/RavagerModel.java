package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class RavagerModel extends ModelBase {
    public ModelRenderer neck;
    public ModelRenderer head;
    public ModelRenderer mouth;
    public ModelRenderer rightHindLeg;
    public ModelRenderer leftHindLeg;
    public ModelRenderer rightFrontLeg;
    public ModelRenderer leftFrontLeg;
    public ModelRenderer body;
    public ModelRenderer lowerBody;
    public ModelRenderer rightHorn;
    public ModelRenderer leftHorn;
    public ModelRenderer nose;

    public RavagerModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.body = new ModelRenderer(this, 0, 55);
        this.body.addBox(-7F, -10F, -7F, 14, 16, 20);
        this.body.setRotationPoint(0F, 1F, 2F);
        setRotation(this.body, (float)Math.PI / 2F, 0F, 0F);

        this.lowerBody = new ModelRenderer(this, 0, 91);
        this.lowerBody.addBox(-6F, 6F, -7F, 12, 13, 18);
        this.lowerBody.setRotationPoint(0F, 0F, 0F);
        this.body.addChild(lowerBody);

        this.neck = new ModelRenderer(this, 68, 73);
        this.neck.addBox(-5F, -1F, -18F, 10, 10, 18);
        this.neck.setRotationPoint(0F, -7F, 5.5F);

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-8F, -20F, -14F, 16, 20, 16);
        this.head.setRotationPoint(0F, 16F, -17F);
        this.neck.addChild(this.head);

        this.nose = new ModelRenderer(this, 0, 0);
        this.nose.addBox(-2F, -6F, -18F, 4, 8, 4);
        this.nose.setRotationPoint(0F, 0F, 0F);
        this.head.addChild(this.nose);

        this.rightHorn = new ModelRenderer(this, 74, 55);
        this.rightHorn.addBox(0F, -14F, -2F, 2, 14, 4);
        this.rightHorn.setRotationPoint(-10F, -14F, -8F);
        setRotation(this.rightHorn, 1.0995574F, 0F, 0F);
        this.head.addChild(this.rightHorn);

        this.leftHorn = new ModelRenderer(this, 74, 55);
        this.leftHorn.mirror = true;
        this.leftHorn.addBox(0F, -14F, -2F, 2, 14, 4);
        this.leftHorn.setRotationPoint(8F, -14F, -8F);
        setRotation(this.leftHorn, 1.0995574F, 0F, 0F);
        this.head.addChild(this.leftHorn);

        this.mouth = new ModelRenderer(this, 0, 36);
        this.mouth.addBox(-8F, 0F, -16F, 16, 3, 16);
        this.mouth.setRotationPoint(0F, -2F, 2F);
        this.head.addChild(this.mouth);

        this.rightHindLeg = new ModelRenderer(this, 96, 0);
        this.rightHindLeg.addBox(-4F, 0F, -4F, 8, 37, 8);
        this.rightHindLeg.setRotationPoint(-8F, -13F, 18F);

        this.leftHindLeg = new ModelRenderer(this, 96, 0);
        this.leftHindLeg.mirror = true;
        this.leftHindLeg.addBox(-4F, 0F, -4F, 8, 37, 8);
        this.leftHindLeg.setRotationPoint(8F, -13F, 18F);

        this.rightFrontLeg = new ModelRenderer(this, 64, 0);
        this.rightFrontLeg.addBox(-4F, 0F, -4F, 8, 37, 8);
        this.rightFrontLeg.setRotationPoint(-8F, -13F, -5F);

        this.leftFrontLeg = new ModelRenderer(this, 64, 0);
        this.leftFrontLeg.mirror = true;
        this.leftFrontLeg.addBox(-4F, 0F, -4F, 8, 37, 8);
        this.leftFrontLeg.setRotationPoint(8F, -13F, -5F);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);

        this.body.render(scale);
        this.neck.render(scale);
        this.rightHindLeg.render(scale);
        this.leftHindLeg.render(scale);
        this.rightFrontLeg.render(scale);
        this.leftFrontLeg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Entity entity) {
        this.head.rotateAngleX = headPitch * (float)Math.PI / 180F;
        this.head.rotateAngleY = netHeadYaw * (float)Math.PI / 180F;

        float f = 0.4F * limbSwingAmount;
        this.rightHindLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * f;
        this.leftHindLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * f;
        this.rightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * f;
        this.leftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * f;
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
