package com.NovaCraft.entity.models;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

//Credit goes to the lads who worked on Aether Highlands: Amazing model, did not want it to go to waste!
public class DeepoidModel extends ModelBase
{
    public final ModelRenderer body;
    public final ModelRenderer body_front;
    public final ModelRenderer body_back;
    public final ModelRenderer leg_front_left_joint;
    public final ModelRenderer leg_front_right_joint;
    public final ModelRenderer head_top;
    public final ModelRenderer head_bottom;
    public final ModelRenderer teeth_top;
    public final ModelRenderer cheek_left;
    public final ModelRenderer cheek_right;
    public final ModelRenderer forehead;
    public final ModelRenderer teeth_bottom;
    public final ModelRenderer crest1;
    public final ModelRenderer crest3;
    public final ModelRenderer crest2; //bend crest
    public final ModelRenderer crest4;
    public final ModelRenderer tail1;
    public final ModelRenderer leg_back_left_top;
    public final ModelRenderer leg_back_right_top;
    public final ModelRenderer tail2;
    public final ModelRenderer tail3;
    public final ModelRenderer tail4;
    public final ModelRenderer leg_back_left_bottom;
    public final ModelRenderer foot_back_left_heel;
    public final ModelRenderer foot_back_left;
    public final ModelRenderer toe7;
    public final ModelRenderer toe8;
    public final ModelRenderer leg_back_left_bottom_1;
    public final ModelRenderer foot_back_left_heel_1;
    public final ModelRenderer foot_back_left_1;
    public final ModelRenderer toe9;
    public final ModelRenderer toe10;
    public final ModelRenderer leg_front_left_top;
    public final ModelRenderer leg_front_left_bottom;
    public final ModelRenderer foot_front_left;
    public final ModelRenderer toe1;
    public final ModelRenderer toe2;
    public final ModelRenderer toe3;
    public final ModelRenderer leg_front_right_top;
    public final ModelRenderer leg_front_right_bottom;
    public final ModelRenderer foot_front_right;
    public final ModelRenderer toe4;
    public final ModelRenderer toe5;
    public final ModelRenderer toe6;
    
    public DeepoidModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.toe6 = new ModelRenderer((ModelBase)this, 44, 41);
        this.toe6.mirror = true;
        this.toe6.setRotationPoint(-1.0f, 0.8f, -5.0f);
        this.toe6.addBox(-0.5f, 0.0f, -1.6f, 1, 1, 3, 0.0f);
        this.setRotateAngle(this.toe6, 0.2617994f, 0.17453292f, 0.0f);
        (this.tail4 = new ModelRenderer((ModelBase)this, 0, 90)).setRotationPoint(0.0f, 0.0f, 8.0f);
        this.tail4.addBox(-1.5f, -1.5f, 0.0f, 3, 3, 10, 0.0f);
        this.setRotateAngle(this.tail4, 0.17453292f, 0.0f, 0.0f);
        (this.body_back = new ModelRenderer((ModelBase)this, 0, 32)).setRotationPoint(0.0f, -3.5f, 5.0f);
        this.body_back.addBox(-5.5f, 0.0f, 0.0f, 11, 7, 9, 0.0f);
        this.setRotateAngle(this.body_back, -0.08726646f, 0.0f, 0.0f);
        this.leg_back_left_bottom_1 = new ModelRenderer((ModelBase)this, 44, 57);
        this.leg_back_left_bottom_1.mirror = true;
        this.leg_back_left_bottom_1.setRotationPoint(-2.99f, 6.5f, -1.5f);
        this.leg_back_left_bottom_1.addBox(-2.0f, 0.0f, 0.0f, 4, 5, 3, 0.0f);
        this.setRotateAngle(this.leg_back_left_bottom_1, 0.43633232f, 0.0f, 0.0f);
        (this.body_front = new ModelRenderer((ModelBase)this, 0, 17)).setRotationPoint(0.0f, -3.5f, -5.0f);
        this.body_front.addBox(-5.5f, 0.0f, -8.0f, 11, 7, 8, 0.0f);
        this.setRotateAngle(this.body_front, 0.2617994f, 0.0f, 0.0f);
        (this.foot_front_left = new ModelRenderer((ModelBase)this, 44, 26)).setRotationPoint(0.0f, 7.0f, 0.0f);
        this.foot_front_left.addBox(-2.0f, 0.0f, -5.0f, 4, 2, 5, 0.0f);
        this.foot_back_left_heel_1 = new ModelRenderer((ModelBase)this, 44, 65);
        this.foot_back_left_heel_1.mirror = true;
        this.foot_back_left_heel_1.setRotationPoint(0.5f, 5.0f, 3.0f);
        this.foot_back_left_heel_1.addBox(-1.5f, 0.0f, -2.0f, 3, 2, 2, 0.0f);
        this.setRotateAngle(this.foot_back_left_heel_1, -0.43633232f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase)this, 0, 63)).setRotationPoint(0.0f, -0.5f, 8.0f);
        this.tail2.addBox(-3.5f, -2.5f, 0.0f, 7, 5, 9, 0.0f);
        this.setRotateAngle(this.tail2, -0.08726646f, 0.0f, 0.0f);
        (this.head_top = new ModelRenderer((ModelBase)this, 68, 0)).setRotationPoint(0.0f, 2.0f, -8.0f);
        this.head_top.addBox(-3.5f, -3.0f, -11.0f, 7, 4, 12, 0.0f);
        this.setRotateAngle(this.head_top, -0.17453292f, 0.0f, 0.0f);
        (this.forehead = new ModelRenderer((ModelBase)this, 68, 16)).setRotationPoint(0.0f, -3.0f, -7.0f);
        this.forehead.addBox(-4.0f, 0.0f, 0.0f, 8, 2, 7, 0.0f);
        this.setRotateAngle(this.forehead, 0.2617994f, 0.0f, 0.0f);
        this.toe4 = new ModelRenderer((ModelBase)this, 44, 33);
        this.toe4.mirror = true;
        this.toe4.setRotationPoint(1.0f, 0.5f, -5.0f);
        this.toe4.addBox(-0.5f, 0.0f, -2.5f, 1, 1, 3, 0.0f);
        this.setRotateAngle(this.toe4, 0.2617994f, -0.17453292f, 0.0f);
        (this.head_bottom = new ModelRenderer((ModelBase)this, 68, 33)).setRotationPoint(0.0f, 1.0f, 0.0f);
        this.head_bottom.addBox(-3.0f, 0.0f, -11.0f, 6, 2, 12, 0.0f);
        this.setRotateAngle(this.head_bottom, 0.34906584f, 0.0f, 0.0f);
        (this.toe7 = new ModelRenderer((ModelBase)this, 44, 72)).setRotationPoint(-0.5f, 0.0f, -2.0f);
        this.toe7.addBox(-1.0f, 0.0f, -2.0f, 1, 1, 2, 0.0f);
        this.setRotateAngle(this.toe7, 0.17453292f, 0.0f, 0.0f);
        (this.toe8 = new ModelRenderer((ModelBase)this, 44, 75)).setRotationPoint(-0.5f, 0.0f, -2.0f);
        this.toe8.addBox(0.0f, 0.0f, -1.0f, 1, 1, 1, 0.0f);
        this.setRotateAngle(this.toe8, 0.2617994f, 0.0f, 0.0f);
        (this.leg_front_left_top = new ModelRenderer((ModelBase)this, 44, 0)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.leg_front_left_top.addBox(-3.5f, -1.5f, -3.0f, 7, 9, 5, 0.0f);
        this.setRotateAngle(this.leg_front_left_top, 0.0f, -1.5707964f, -0.87266463f);
        (this.crest3 = new ModelRenderer((ModelBase)this, 118, 20)).setRotationPoint(-2.0f, 0.0f, 5.5f);
        this.crest3.addBox(-2.0f, -3.0f, -1.0f, 2, 3, 2, 0.0f);
        this.setRotateAngle(this.crest3, 0.0f, 0.0f, -0.6981317f);
        (this.leg_back_left_bottom = new ModelRenderer((ModelBase)this, 44, 57)).setRotationPoint(2.99f, 6.5f, -1.5f);
        this.leg_back_left_bottom.addBox(-2.0f, 0.0f, 0.0f, 4, 5, 3, 0.0f);
        this.setRotateAngle(this.leg_back_left_bottom, 0.43633232f, 0.0f, 0.0f);
        this.foot_front_right = new ModelRenderer((ModelBase)this, 44, 26);
        this.foot_front_right.mirror = true;
        this.foot_front_right.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.foot_front_right.addBox(-2.0f, 0.0f, -5.0f, 4, 2, 5, 0.0f);
        (this.leg_front_left_bottom = new ModelRenderer((ModelBase)this, 44, 14)).setRotationPoint(5.0f, 3.7f, 2.0f);
        this.leg_front_left_bottom.addBox(-2.5f, -1.0f, -3.5f, 5, 8, 4, 0.0f);
        (this.foot_back_left_heel = new ModelRenderer((ModelBase)this, 44, 65)).setRotationPoint(-0.5f, 5.0f, 3.0f);
        this.foot_back_left_heel.addBox(-1.5f, 0.0f, -2.0f, 3, 2, 2, 0.0f);
        this.setRotateAngle(this.foot_back_left_heel, -0.43633232f, 0.0f, 0.0f);
        this.toe5 = new ModelRenderer((ModelBase)this, 44, 37);
        this.toe5.mirror = true;
        this.toe5.setRotationPoint(0.0f, 0.6f, -5.0f);
        this.toe5.addBox(-0.5f, 0.0f, -2.0f, 1, 1, 3, 0.0f);
        this.setRotateAngle(this.toe5, 0.2617994f, 0.0f, 0.0f);
        (this.crest2 = new ModelRenderer((ModelBase)this, 106, 21)).setRotationPoint(0.0f, -5.0f, 0.0f);
        this.crest2.addBox(-4.0f, 0.0f, -1.0f, 4, 2, 2, 0.0f);
        (this.crest4 = new ModelRenderer((ModelBase)this, 106, 21)).setRotationPoint(2.0f, -5.0f, 0.0f);
        this.crest4.addBox(-4.0f, 0.0f, -1.0f, 4, 2, 2, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase)this, 0, 48)).setRotationPoint(0.0f, 4.0f, 8.0f);
        this.tail1.addBox(-4.5f, -3.5f, 0.0f, 9, 6, 9, 0.0f);
        this.setRotateAngle(this.tail1, -0.08726646f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 13.3f, 0.0f);
        this.body.addBox(-6.0f, -3.5f, -5.0f, 12, 7, 10, 0.0f);
        (this.cheek_left = new ModelRenderer((ModelBase)this, 68, 25)).setRotationPoint(3.5f, -1.0f, -6.0f);
        this.cheek_left.addBox(-3.0f, 0.0f, 0.0f, 3, 2, 6, 0.0f);
        this.setRotateAngle(this.cheek_left, 0.0f, 0.34906584f, 0.0f);
        this.toe9 = new ModelRenderer((ModelBase)this, 44, 72);
        this.toe9.mirror = true;
        this.toe9.setRotationPoint(1.5f, 0.0f, -2.0f);
        this.toe9.addBox(-1.0f, 0.0f, -2.0f, 1, 1, 2, 0.0f);
        this.setRotateAngle(this.toe9, 0.17453292f, 0.0f, 0.0f);
        this.toe10 = new ModelRenderer((ModelBase)this, 44, 75);
        this.toe10.mirror = true;
        this.toe10.setRotationPoint(-0.5f, 0.0f, -2.0f);
        this.toe10.addBox(0.0f, 0.0f, -1.0f, 1, 1, 1, 0.0f);
        this.setRotateAngle(this.toe10, 0.2617994f, 0.0f, 0.0f);
        (this.leg_front_right_joint = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(-4.5f, -2.0f, -4.0f);
        this.leg_front_right_joint.addBox(0.0f, 0.0f, 0.0f, 1, 1, 1, 0.0f);
        this.setRotateAngle(this.leg_front_right_joint, 0.0f, 0.17453292f, 0.0f);
        (this.teeth_top = new ModelRenderer((ModelBase)this, 68, 47)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.teeth_top.addBox(-2.5f, 0.5f, -10.0f, 5, 1, 11, 0.0f);
        this.cheek_right = new ModelRenderer((ModelBase)this, 68, 25);
        this.cheek_right.mirror = true;
        this.cheek_right.setRotationPoint(-3.5f, -1.0f, -6.0f);
        this.cheek_right.addBox(0.0f, 0.0f, 0.0f, 3, 2, 6, 0.0f);
        this.setRotateAngle(this.cheek_right, 0.0f, -0.34906584f, 0.0f);
        (this.foot_back_left = new ModelRenderer((ModelBase)this, 44, 69)).setRotationPoint(0.5f, 0.6f, -2.0f);
        this.foot_back_left.addBox(-1.5f, 0.0f, -2.0f, 3, 1, 2, 0.0f);
        this.setRotateAngle(this.foot_back_left, 0.08726646f, 0.0f, 0.0f);
        (this.leg_front_left_joint = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(4.5f, -2.0f, -4.0f);
        this.leg_front_left_joint.addBox(0.0f, 0.0f, 0.0f, 1, 1, 1, 0.0f);
        this.setRotateAngle(this.leg_front_left_joint, 0.0f, -0.17453292f, 0.0f);
        this.foot_back_left_1 = new ModelRenderer((ModelBase)this, 44, 69);
        this.foot_back_left_1.mirror = true;
        this.foot_back_left_1.setRotationPoint(-0.5f, 0.6f, -2.0f);
        this.foot_back_left_1.addBox(-1.5f, 0.0f, -2.0f, 3, 1, 2, 0.0f);
        this.setRotateAngle(this.foot_back_left_1, 0.08726646f, 0.0f, 0.0f);
        this.leg_front_right_top = new ModelRenderer((ModelBase)this, 44, 0);
        this.leg_front_right_top.mirror = true;
        this.leg_front_right_top.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.leg_front_right_top.addBox(-3.5f, -1.5f, -3.0f, 7, 9, 5, 0.0f);
        this.setRotateAngle(this.leg_front_right_top, 0.0f, 1.5707964f, 0.87266463f);
        this.leg_front_right_bottom = new ModelRenderer((ModelBase)this, 44, 14);
        this.leg_front_right_bottom.mirror = true;
        this.leg_front_right_bottom.setRotationPoint(-5.0f, 3.7f, 2.0f);
        this.leg_front_right_bottom.addBox(-2.5f, -1.0f, -3.5f, 5, 8, 4, 0.0f);
        (this.toe2 = new ModelRenderer((ModelBase)this, 44, 37)).setRotationPoint(0.0f, 0.6f, -5.0f);
        this.toe2.addBox(-0.5f, 0.0f, -2.0f, 1, 1, 3, 0.0f);
        this.setRotateAngle(this.toe2, 0.2617994f, 0.0f, 0.0f);
        (this.crest1 = new ModelRenderer((ModelBase)this, 98, 18)).setRotationPoint(2.0f, 0.0f, 5.5f);
        this.crest1.addBox(0.0f, -5.0f, -1.0f, 2, 5, 2, 0.0f);
        this.setRotateAngle(this.crest1, 0.0f, 0.0f, 0.6981317f);
        this.leg_back_right_top = new ModelRenderer((ModelBase)this, 44, 45);
        this.leg_back_right_top.mirror = true;
        this.leg_back_right_top.setRotationPoint(-4.9f, 1.9f, 7.4f);
        this.leg_back_right_top.addBox(-5.0f, -1.5f, -2.0f, 5, 8, 4, 0.0f);
        this.setRotateAngle(this.leg_back_right_top, 0.0f, 0.34906584f, 0.0f);
        (this.tail3 = new ModelRenderer((ModelBase)this, 0, 77)).setRotationPoint(0.0f, 0.0f, 8.0f);
        this.tail3.addBox(-2.5f, -2.0f, 0.0f, 5, 4, 9, 0.0f);
        this.setRotateAngle(this.tail3, -0.08726646f, 0.0f, 0.0f);
        (this.leg_back_left_top = new ModelRenderer((ModelBase)this, 44, 45)).setRotationPoint(4.9f, 1.9f, 7.4f);
        this.leg_back_left_top.addBox(0.0f, -1.5f, -2.0f, 5, 8, 4, 0.0f);
        this.setRotateAngle(this.leg_back_left_top, 0.0f, -0.34906584f, 0.0f);
        (this.toe1 = new ModelRenderer((ModelBase)this, 44, 33)).setRotationPoint(-1.0f, 0.5f, -5.0f);
        this.toe1.addBox(-0.5f, 0.0f, -2.5f, 1, 1, 3, 0.0f);
        this.setRotateAngle(this.toe1, 0.2617994f, 0.17453292f, 0.0f);
        (this.toe3 = new ModelRenderer((ModelBase)this, 44, 41)).setRotationPoint(1.0f, 0.8f, -5.0f);
        this.toe3.addBox(-0.5f, 0.0f, -1.6f, 1, 1, 3, 0.0f);
        this.setRotateAngle(this.toe3, 0.2617994f, -0.17453292f, 0.0f);
        (this.teeth_bottom = new ModelRenderer((ModelBase)this, 68, 59)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.teeth_bottom.addBox(-2.5f, -0.5f, -10.0f, 5, 1, 11, 0.0f);
        this.foot_front_right.addChild(this.toe6);
        this.tail3.addChild(this.tail4);
        this.body.addChild(this.body_back);
        this.leg_back_right_top.addChild(this.leg_back_left_bottom_1);
        this.body.addChild(this.body_front);
        this.leg_front_left_bottom.addChild(this.foot_front_left);
        this.leg_back_left_bottom_1.addChild(this.foot_back_left_heel_1);
        this.tail1.addChild(this.tail2);
        this.body_front.addChild(this.head_top);
        this.head_top.addChild(this.forehead);
        this.foot_front_right.addChild(this.toe4);
        this.head_top.addChild(this.head_bottom);
        this.foot_back_left.addChild(this.toe7);
        this.foot_back_left.addChild(this.toe8);
        this.leg_front_left_joint.addChild(this.leg_front_left_top);
        this.forehead.addChild(this.crest3);
        this.leg_back_left_top.addChild(this.leg_back_left_bottom);
        this.leg_front_right_bottom.addChild(this.foot_front_right);
        this.leg_front_left_joint.addChild(this.leg_front_left_bottom);
        this.leg_back_left_bottom.addChild(this.foot_back_left_heel);
        this.foot_front_right.addChild(this.toe5);
        this.crest1.addChild(this.crest2);
        this.crest3.addChild(this.crest4);
        this.body_back.addChild(this.tail1);
        this.head_top.addChild(this.cheek_left);
        this.foot_back_left_1.addChild(this.toe9);
        this.foot_back_left_1.addChild(this.toe10);
        this.body.addChild(this.leg_front_right_joint);
        this.head_top.addChild(this.teeth_top);
        this.head_top.addChild(this.cheek_right);
        this.foot_back_left_heel.addChild(this.foot_back_left);
        this.body.addChild(this.leg_front_left_joint);
        this.foot_back_left_heel_1.addChild(this.foot_back_left_1);
        this.leg_front_right_joint.addChild(this.leg_front_right_top);
        this.leg_front_right_joint.addChild(this.leg_front_right_bottom);
        this.foot_front_left.addChild(this.toe2);
        this.forehead.addChild(this.crest1);
        this.body_back.addChild(this.leg_back_right_top);
        this.tail2.addChild(this.tail3);
        this.body_back.addChild(this.leg_back_left_top);
        this.foot_front_left.addChild(this.toe1);
        this.foot_front_left.addChild(this.toe3);
        this.head_bottom.addChild(this.teeth_bottom);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    	super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	this.body.render(f5);   
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.head_top.rotateAngleX = headPitch * 0.017453292f;
        this.head_top.rotateAngleY = netHeadYaw * 0.017453292f;
        this.leg_front_right_joint.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 0.6f * limbSwingAmount;
        this.leg_front_left_joint.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 0.6f * limbSwingAmount;
        this.leg_back_right_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 0.6f * limbSwingAmount;
        this.leg_back_left_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 0.6f * limbSwingAmount;
        final float jawLower = MathHelper.cos(ageInTicks * 0.1f) / 5.0f;
        this.head_bottom.rotateAngleX = 0.34906584f - jawLower;
        final float tailVal = limbSwing * 0.3f + ageInTicks * 0.06f;
        final float tailSway = MathHelper.cos(tailVal) / 3.0f;
        final float tailSwaySin = MathHelper.sin(tailVal) / 3.0f;
        this.tail1.rotateAngleY = tailSway;
        this.tail2.rotateAngleY = tailSwaySin;
        this.tail3.rotateAngleY = tailSway;
        this.tail4.rotateAngleY = tailSwaySin;
        final float tailBase = -0.08726646f;
        final float tail4Base = 0.17453292f;
        final float tailSwing = MathHelper.cos(limbSwing * 0.6662f) * 0.05f * limbSwingAmount;
        this.tail1.rotateAngleX = tailBase + tailSwing;
        this.tail2.rotateAngleX = tailBase + tailSwing;
        this.tail3.rotateAngleX = tailBase + tailSwing;
        this.tail4.rotateAngleX = tail4Base + tailSwing;
    }
}
