package com.NovaCraft.entity.models;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

//Credit goes to the lads who worked on Aether Highlands: Amazing model, did not want it to go to waste!
public class VargouziteModel extends ModelBase
{
    //public final ModelRenderer body;
    //public final ModelRenderer body_front;
    //public final ModelRenderer body_back;
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
    
    public VargouziteModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.head_top = new ModelRenderer((ModelBase)this, 68, 0)).setRotationPoint(0.0f, 2.0f, -8.0f);
        this.head_top.addBox(-3.5f, -3.0f, -11.0f, 7, 4, 12, 0.0f);
        this.setRotateAngle(this.head_top, -0.17453292f, 0.0f, 0.0f);
        (this.forehead = new ModelRenderer((ModelBase)this, 68, 16)).setRotationPoint(0.0f, -3.0f, -7.0f);
        this.forehead.addBox(-4.0f, 0.0f, 0.0f, 8, 2, 7, 0.0f);
        this.setRotateAngle(this.forehead, 0.2617994f, 0.0f, 0.0f);
        (this.head_bottom = new ModelRenderer((ModelBase)this, 68, 33)).setRotationPoint(0.0f, 1.0f, 0.0f);
        this.head_bottom.addBox(-3.0f, 0.0f, -11.0f, 6, 2, 12, 0.0f);
        this.setRotateAngle(this.head_bottom, 0.34906584f, 0.0f, 0.0f);
        (this.crest3 = new ModelRenderer((ModelBase)this, 118, 20)).setRotationPoint(-2.0f, 0.0f, 5.5f);
        this.crest3.addBox(-2.0f, -3.0f, -1.0f, 2, 3, 2, 0.0f);
        this.setRotateAngle(this.crest3, 0.0f, 0.0f, -0.6981317f);
        (this.crest2 = new ModelRenderer((ModelBase)this, 106, 21)).setRotationPoint(0.0f, -5.0f, 0.0f);
        this.crest2.addBox(-4.0f, 0.0f, -1.0f, 4, 2, 2, 0.0f);
        (this.crest4 = new ModelRenderer((ModelBase)this, 106, 21)).setRotationPoint(2.0f, -5.0f, 0.0f);
        this.crest4.addBox(-4.0f, 0.0f, -1.0f, 4, 2, 2, 0.0f);
        (this.cheek_left = new ModelRenderer((ModelBase)this, 68, 25)).setRotationPoint(3.5f, -1.0f, -6.0f);
        this.cheek_left.addBox(-3.0f, 0.0f, 0.0f, 3, 2, 6, 0.0f);
        this.setRotateAngle(this.cheek_left, 0.0f, 0.34906584f, 0.0f);
        (this.teeth_top = new ModelRenderer((ModelBase)this, 68, 47)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.teeth_top.addBox(-2.5f, 0.5f, -10.0f, 5, 1, 11, 0.0f);
        this.cheek_right = new ModelRenderer((ModelBase)this, 68, 25);
        this.cheek_right.mirror = true;
        this.cheek_right.setRotationPoint(-3.5f, -1.0f, -6.0f);
        this.cheek_right.addBox(0.0f, 0.0f, 0.0f, 3, 2, 6, 0.0f);
        this.setRotateAngle(this.cheek_right, 0.0f, -0.34906584f, 0.0f);
        (this.crest1 = new ModelRenderer((ModelBase)this, 98, 18)).setRotationPoint(2.0f, 0.0f, 5.5f);
        this.crest1.addBox(0.0f, -5.0f, -1.0f, 2, 5, 2, 0.0f);
        this.setRotateAngle(this.crest1, 0.0f, 0.0f, 0.6981317f);
        (this.teeth_bottom = new ModelRenderer((ModelBase)this, 68, 59)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.teeth_bottom.addBox(-2.5f, -0.5f, -10.0f, 5, 1, 11, 0.0f);
        this.head_top.addChild(this.forehead);
        this.head_top.addChild(this.head_bottom);
        this.forehead.addChild(this.crest3);
        this.crest1.addChild(this.crest2);
        this.crest3.addChild(this.crest4);
        this.head_top.addChild(this.cheek_left);
        this.head_top.addChild(this.teeth_top);
        this.head_top.addChild(this.cheek_right);
        this.forehead.addChild(this.crest1);
        this.head_bottom.addChild(this.teeth_bottom);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    	super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	this.head_top.render(f5);   
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
        final float jawLower = MathHelper.cos(ageInTicks * 0.1f) / 5.0f;
        this.head_bottom.rotateAngleX = 0.34906584f - jawLower;
    }
}

