package com.NovaCraft.entity.models;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class VoidiferModel extends ModelBase
{
    ModelRenderer ribLeftTop;
    ModelRenderer ribRightTop;
    ModelRenderer ribLeftMiddle;
    ModelRenderer ribRightMiddle;
    ModelRenderer ribLeftBottom;
    ModelRenderer ribRightBottom;
    ModelRenderer forehead;
    ModelRenderer sideburnLeft;
    ModelRenderer nose;
    ModelRenderer sideburnRight;
    ModelRenderer moustacheLeft;
    ModelRenderer moustacheRight;
    ModelRenderer jowlLeft;
    ModelRenderer jowlRight;
    ModelRenderer chin1;
    ModelRenderer spineFront;
    ModelRenderer spineBack;
    ModelRenderer head;
    ModelRenderer chin2;
    ModelRenderer neck;
    ModelRenderer bodyTop;
    ModelRenderer bodyBottom;
    ModelRenderer frontRightLeg;
    ModelRenderer foreFrontRightLeg;
    ModelRenderer frontLeftLeg;
    ModelRenderer foreFrontLeftLeg;
    ModelRenderer backRightLeg;
    ModelRenderer backForeRightLeg;
    ModelRenderer backLeftLeg;
    ModelRenderer backForeLeftLeg;
    ModelRenderer pecLeft;
    ModelRenderer pecRight;
    
    public VoidiferModel() {
        this(0.0f);
    }
    
    //Credit goes to the Evil Minecraft(1.2.5) mod Author
    public VoidiferModel(final float scale) {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.ribLeftTop = new ModelRenderer((ModelBase)this, 14, 26)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.ribLeftTop.setRotationPoint(0.0f, 6.0f, -2.0f);
        this.ribLeftTop.setTextureSize(64, 64);
        this.ribLeftTop.mirror = true;
        this.setRotateAngle(this.ribLeftTop, -0.1745329f, 0.0f, -0.2443461f);
        (this.ribRightTop = new ModelRenderer((ModelBase)this, 0, 26)).addBox(-4.0f, 0.0f, 0.0f, 4, 1, 1);
        this.ribRightTop.setRotationPoint(0.0f, 6.0f, -2.0f);
        this.ribRightTop.setTextureSize(64, 64);
        this.ribRightTop.mirror = true;
        this.setRotateAngle(this.ribRightTop, -0.1745329f, 0.0f, 0.2443461f);
        (this.ribLeftMiddle = new ModelRenderer((ModelBase)this, 14, 28)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.ribLeftMiddle.setRotationPoint(0.0f, 7.0f, -2.0f);
        this.ribLeftMiddle.setTextureSize(64, 64);
        this.ribLeftMiddle.mirror = true;
        this.setRotateAngle(this.ribLeftMiddle, -0.1745329f, 0.0f, 0.122173f);
        (this.ribRightMiddle = new ModelRenderer((ModelBase)this, 0, 28)).addBox(-4.0f, 0.0f, 0.0f, 4, 1, 1);
        this.ribRightMiddle.setRotationPoint(0.0f, 7.0f, -2.0f);
        this.ribRightMiddle.setTextureSize(64, 64);
        this.ribRightMiddle.mirror = true;
        this.setRotateAngle(this.ribRightMiddle, -0.1745329f, 0.0f, -0.122173f);
        (this.ribLeftBottom = new ModelRenderer((ModelBase)this, 14, 30)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.ribLeftBottom.setRotationPoint(0.0f, 8.5f, -2.0f);
        this.ribLeftBottom.setTextureSize(64, 64);
        this.ribLeftBottom.mirror = true;
        this.setRotateAngle(this.ribLeftBottom, -0.1745329f, 0.0f, 0.3665191f);
        (this.ribRightBottom = new ModelRenderer((ModelBase)this, 0, 30)).addBox(-4.0f, 0.0f, 0.0f, 4, 1, 1);
        this.ribRightBottom.setRotationPoint(0.0f, 8.5f, -2.0f);
        this.ribRightBottom.setTextureSize(64, 64);
        this.ribRightBottom.mirror = true;
        this.setRotateAngle(this.ribRightBottom, -0.1745329f, 0.0f, -0.3665191f);
        (this.forehead = new ModelRenderer((ModelBase)this, 0, 41)).addBox(-4.0f, -8.0f, -8.0f, 8, 3, 1);
        this.forehead.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.forehead.setTextureSize(64, 64);
        this.forehead.mirror = true;
        this.setRotateAngle(this.forehead, 0.0f, 0.0f, 0.0f);
        (this.sideburnLeft = new ModelRenderer((ModelBase)this, 22, 57)).addBox(3.0f, -6.0f, -8.0f, 1, 6, 1);
        this.sideburnLeft.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.sideburnLeft.setTextureSize(64, 64);
        this.sideburnLeft.mirror = true;
        this.setRotateAngle(this.sideburnLeft, 0.0f, 0.0f, 0.0f);
        (this.nose = new ModelRenderer((ModelBase)this, 10, 55)).addBox(-1.0f, -6.0f, -8.0f, 2, 3, 1);
        this.nose.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.nose.setTextureSize(64, 64);
        this.nose.mirror = true;
        this.setRotateAngle(this.nose, 0.0f, 0.0f, 0.0f);
        (this.sideburnRight = new ModelRenderer((ModelBase)this, 0, 57)).addBox(-4.0f, -6.0f, -8.0f, 1, 6, 1);
        this.sideburnRight.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.sideburnRight.setTextureSize(64, 64);
        this.sideburnRight.mirror = true;
        this.setRotateAngle(this.sideburnRight, 0.0f, 0.0f, 0.0f);
        (this.moustacheLeft = new ModelRenderer((ModelBase)this, 17, 59)).addBox(1.0f, -3.0f, -8.0f, 2, 1, 1);
        this.moustacheLeft.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.moustacheLeft.setTextureSize(64, 64);
        this.moustacheLeft.mirror = true;
        this.setRotateAngle(this.moustacheLeft, 0.0f, 0.0f, 0.0f);
        (this.moustacheRight = new ModelRenderer((ModelBase)this, 5, 59)).addBox(-3.0f, -3.0f, -8.0f, 2, 1, 1);
        this.moustacheRight.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.moustacheRight.setTextureSize(64, 64);
        this.moustacheRight.mirror = true;
        this.setRotateAngle(this.moustacheRight, 0.0f, 0.0f, 0.0f);
        (this.jowlLeft = new ModelRenderer((ModelBase)this, 5, 53)).addBox(2.0f, -3.0f, -8.0f, 1, 4, 1);
        this.jowlLeft.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.jowlLeft.setTextureSize(64, 64);
        this.jowlLeft.mirror = true;
        this.setRotateAngle(this.jowlLeft, 0.0f, 0.0f, 0.0f);
        (this.jowlRight = new ModelRenderer((ModelBase)this, 17, 53)).addBox(-3.0f, -3.0f, -8.0f, 1, 4, 1);
        this.jowlRight.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.jowlRight.setTextureSize(64, 64);
        this.jowlRight.mirror = true;
        this.setRotateAngle(this.jowlRight, 0.0f, 0.0f, 0.0f);
        (this.chin1 = new ModelRenderer((ModelBase)this, 10, 60)).addBox(-1.0f, -1.0f, -8.0f, 2, 2, 1);
        this.chin1.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.chin1.setTextureSize(64, 64);
        this.chin1.mirror = true;
        this.setRotateAngle(this.chin1, 0.0f, 0.0f, 0.0f);
        (this.spineFront = new ModelRenderer((ModelBase)this, 10, 26)).addBox(0.0f, 0.0f, 2.0f, 1, 7, 1);
        this.spineFront.setRotationPoint(-0.5f, 4.6f, -4.4f);
        this.spineFront.setTextureSize(64, 64);
        this.spineFront.mirror = true;
        this.setRotateAngle(this.spineFront, 0.0349066f, 0.0f, 0.0f);
        (this.spineBack = new ModelRenderer((ModelBase)this, 24, 26)).addBox(-0.5f, 0.0f, 0.0f, 1, 10, 1);
        this.spineBack.setRotationPoint(0.0f, 2.0f, 3.3f);
        this.spineBack.setTextureSize(64, 64);
        this.spineBack.mirror = true;
        this.setRotateAngle(this.spineBack, -0.1919862f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -8.0f, -7.0f, 8, 8, 9, scale);
        this.head.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotateAngle(this.head, 0.0f, 0.0f, 0.0f);
        (this.chin2 = new ModelRenderer((ModelBase)this, 14, 17)).addBox(-2.0f, 0.0f, -7.0f, 4, 1, 6);
        this.chin2.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.chin2.setTextureSize(64, 64);
        this.chin2.mirror = true;
        this.setRotateAngle(this.chin2, 0.0f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase)this, 34, 20)).addBox(-1.5f, 0.0f, -1.0f, 3, 5, 3);
        this.neck.setRotationPoint(0.0f, -2.0f, 3.0f);
        this.neck.setTextureSize(64, 64);
        this.neck.mirror = true;
        this.setRotateAngle(this.neck, -0.2617994f, 0.0f, 0.0f);
        (this.bodyTop = new ModelRenderer((ModelBase)this, 34, 0)).addBox(-5.0f, 0.0f, -2.0f, 10, 5, 5);
        this.bodyTop.setRotationPoint(0.0f, 2.0f, 1.0f);
        this.bodyTop.setTextureSize(64, 64);
        this.bodyTop.mirror = true;
        this.setRotateAngle(this.bodyTop, -0.1745329f, 0.0f, 0.0f);
        (this.bodyBottom = new ModelRenderer((ModelBase)this, 42, 10)).addBox(-3.5f, 0.0f, -2.0f, 7, 6, 4);
        this.bodyBottom.setRotationPoint(0.0f, 6.0f, 1.0f);
        this.bodyBottom.setTextureSize(64, 64);
        this.bodyBottom.mirror = true;
        this.setRotateAngle(this.bodyBottom, -0.1745329f, 0.0f, 0.0f);
        (this.frontRightLeg = new ModelRenderer((ModelBase)this, 0, 17)).addBox(-1.5f, 0.0f, -1.5f, 3, 6, 3);
        this.frontRightLeg.setRotationPoint(-2.0f, 12.0f, -1.0f);
        this.frontRightLeg.setTextureSize(64, 64);
        this.frontRightLeg.mirror = true;
        this.setRotateAngle(this.frontRightLeg, -0.8726646f, 0.0f, 0.2268928f);
        (this.foreFrontRightLeg = new ModelRenderer((ModelBase)this, 56, 21)).addBox(-2.0f, 2.0f, -6.0f, 2, 10, 2);
        this.foreFrontRightLeg.setRotationPoint(-2.0f, 12.0f, -1.0f);
        this.foreFrontRightLeg.setTextureSize(64, 64);
        this.foreFrontRightLeg.mirror = true;
        this.setRotateAngle(this.foreFrontRightLeg, 0.1745329f, 0.0f, -0.0872665f);
        (this.frontLeftLeg = new ModelRenderer((ModelBase)this, 0, 17)).addBox(-1.5f, 0.0f, -1.5f, 3, 6, 3);
        this.frontLeftLeg.setRotationPoint(2.0f, 12.0f, -1.0f);
        this.frontLeftLeg.setTextureSize(64, 64);
        this.frontLeftLeg.mirror = true;
        this.setRotateAngle(this.frontLeftLeg, -0.8726646f, 0.0f, -0.2268928f);
        (this.foreFrontLeftLeg = new ModelRenderer((ModelBase)this, 56, 21)).addBox(0.0f, 2.0f, -6.0f, 2, 10, 2);
        this.foreFrontLeftLeg.setRotationPoint(2.0f, 12.0f, -1.0f);
        this.foreFrontLeftLeg.setTextureSize(64, 64);
        this.foreFrontLeftLeg.mirror = true;
        this.setRotateAngle(this.foreFrontLeftLeg, 0.1745329f, 0.0f, 0.0872665f);
        (this.backRightLeg = new ModelRenderer((ModelBase)this, 0, 17)).addBox(-1.5f, 0.0f, -1.5f, 3, 6, 3);
        this.backRightLeg.setRotationPoint(-2.0f, 11.0f, 1.0f);
        this.backRightLeg.setTextureSize(64, 64);
        this.backRightLeg.mirror = true;
        this.setRotateAngle(this.backRightLeg, 0.8726646f, 0.0f, 0.2268928f);
        (this.backForeRightLeg = new ModelRenderer((ModelBase)this, 56, 22)).addBox(-2.0f, 3.0f, 3.0f, 2, 10, 2);
        this.backForeRightLeg.setRotationPoint(-2.0f, 11.0f, 1.0f);
        this.backForeRightLeg.setTextureSize(64, 64);
        this.backForeRightLeg.mirror = true;
        this.setRotateAngle(this.backForeRightLeg, -0.1745329f, 0.0f, 0.0f);
        (this.backLeftLeg = new ModelRenderer((ModelBase)this, 0, 17)).addBox(-1.5f, 0.0f, -1.5f, 3, 6, 3);
        this.backLeftLeg.setRotationPoint(2.0f, 11.0f, 1.0f);
        this.backLeftLeg.setTextureSize(64, 64);
        this.backLeftLeg.mirror = true;
        this.setRotateAngle(this.backLeftLeg, 0.8726646f, 0.0f, -0.2268928f);
        (this.backForeLeftLeg = new ModelRenderer((ModelBase)this, 56, 22)).addBox(4.0f, 3.0f, 3.0f, 2, 10, 2);
        this.backForeLeftLeg.setRotationPoint(-2.0f, 11.0f, 1.0f);
        this.backForeLeftLeg.setTextureSize(64, 64);
        this.backForeLeftLeg.mirror = true;
        this.setRotateAngle(this.backForeLeftLeg, -0.1745329f, 0.0f, 0.0f);
        (this.pecLeft = new ModelRenderer((ModelBase)this, 12, 35)).addBox(-2.0f, -1.0f, 0.0f, 4, 3, 2);
        this.pecLeft.setRotationPoint(2.3f, 3.0f, -2.5f);
        this.pecLeft.setTextureSize(64, 64);
        this.pecLeft.mirror = true;
        this.setRotateAngle(this.pecLeft, -0.1745329f, 0.0f, 0.0f);
        (this.pecRight = new ModelRenderer((ModelBase)this, 0, 35)).addBox(-2.0f, -1.0f, 0.0f, 4, 3, 2);
        this.pecRight.setRotationPoint(-2.3f, 3.0f, -2.5f);
        this.pecRight.setTextureSize(64, 64);
        this.pecRight.mirror = true;
        this.setRotateAngle(this.pecRight, -0.1745329f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.ribLeftTop.render(scale);
        this.ribRightTop.render(scale);
        this.ribLeftMiddle.render(scale);
        this.ribRightMiddle.render(scale);
        this.ribLeftBottom.render(scale);
        this.ribRightBottom.render(scale);
        this.forehead.render(scale);
        this.sideburnLeft.render(scale);
        this.nose.render(scale);
        this.sideburnRight.render(scale);
        this.moustacheLeft.render(scale);
        this.moustacheRight.render(scale);
        this.jowlLeft.render(scale);
        this.jowlRight.render(scale);
        this.chin1.render(scale);
        this.spineFront.render(scale);
        this.spineBack.render(scale);
        this.head.render(scale);
        this.chin2.render(scale);
        this.neck.render(scale);
        this.bodyTop.render(scale);
        this.bodyBottom.render(scale);
        this.frontRightLeg.render(scale);
        this.foreFrontRightLeg.render(scale);
        this.frontLeftLeg.render(scale);
        this.foreFrontLeftLeg.render(scale);
        this.backRightLeg.render(scale);
        this.backForeRightLeg.render(scale);
        this.backLeftLeg.render(scale);
        this.backForeLeftLeg.render(scale);
        this.pecLeft.render(scale);
        this.pecRight.render(scale);
    }
    
    private void setRotateAngle(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entityIn) {
        this.head.rotateAngleX = netHeadYaw / 57.29578f;
        this.head.rotateAngleY = headPitch / 57.29578f;
        this.chin1.rotateAngleX = this.head.rotateAngleX;
        this.chin1.rotateAngleY = this.head.rotateAngleY;
        this.chin2.rotateAngleY = this.head.rotateAngleY;
        this.chin2.rotateAngleX = this.head.rotateAngleX;
        this.jowlLeft.rotateAngleX = this.head.rotateAngleX;
        this.jowlLeft.rotateAngleY = this.head.rotateAngleY;
        this.jowlRight.rotateAngleX = this.head.rotateAngleX;
        this.jowlRight.rotateAngleY = this.head.rotateAngleY;
        this.nose.rotateAngleX = this.head.rotateAngleX;
        this.nose.rotateAngleY = this.head.rotateAngleY;
        this.sideburnRight.rotateAngleX = this.head.rotateAngleX;
        this.sideburnRight.rotateAngleY = this.head.rotateAngleY;
        this.sideburnLeft.rotateAngleX = this.head.rotateAngleX;
        this.sideburnLeft.rotateAngleY = this.head.rotateAngleY;
        this.forehead.rotateAngleX = this.head.rotateAngleX;
        this.forehead.rotateAngleY = this.head.rotateAngleY;
        this.moustacheLeft.rotateAngleX = this.head.rotateAngleX;
        this.moustacheLeft.rotateAngleY = this.head.rotateAngleY;
        this.moustacheRight.rotateAngleX = this.head.rotateAngleX;
        this.moustacheRight.rotateAngleY = this.head.rotateAngleY;
        this.backRightLeg.rotateAngleX = 0.8726646f;
        final ModelRenderer backRightLeg = this.backRightLeg;
        backRightLeg.rotateAngleX -= MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.backForeRightLeg.rotateAngleX = -0.1745329f;
        final ModelRenderer backForeRightLeg = this.backForeRightLeg;
        backForeRightLeg.rotateAngleX += MathHelper.cos(limbSwing * 0.6662f + 3.141593f) * 1.4f * limbSwingAmount;
        this.frontRightLeg.rotateAngleX = -0.8726646f;
        final ModelRenderer frontRightLeg = this.frontRightLeg;
        frontRightLeg.rotateAngleX += MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.foreFrontRightLeg.rotateAngleX = 0.1745329f;
        final ModelRenderer foreFrontRightLeg = this.foreFrontRightLeg;
        foreFrontRightLeg.rotateAngleX -= MathHelper.cos(limbSwing * 0.6662f + 3.141593f) * 1.4f * limbSwingAmount;
        this.frontLeftLeg.rotateAngleX = -0.8726646f;
        final ModelRenderer frontLeftLeg = this.frontLeftLeg;
        frontLeftLeg.rotateAngleX += MathHelper.cos(limbSwing * 0.6662f + 3.141593f) * 1.4f * limbSwingAmount;
        this.foreFrontLeftLeg.rotateAngleX = 0.1745329f;
        final ModelRenderer foreFrontLeftLeg = this.foreFrontLeftLeg;
        foreFrontLeftLeg.rotateAngleX -= MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.backLeftLeg.rotateAngleX = 0.8726646f;
        final ModelRenderer backLeftLeg = this.backLeftLeg;
        backLeftLeg.rotateAngleX -= MathHelper.cos(limbSwing * 0.6662f + 3.141593f) * 1.4f * limbSwingAmount;
        this.backForeLeftLeg.rotateAngleX = -0.1745329f;
        final ModelRenderer backForeLeftLeg = this.backForeLeftLeg;
        backForeLeftLeg.rotateAngleX += MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    }
}
