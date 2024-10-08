package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class PrisonerModel extends ModelBase {
	
	ModelRenderer head;
	ModelRenderer right_ear;
	ModelRenderer left_ear;
	ModelRenderer body;
	ModelRenderer top_left_tent1;
	ModelRenderer top_right_tent1;
	ModelRenderer mid_left_tent1;
	ModelRenderer mid_right_tent1;
	ModelRenderer bottom_left_tent1;
	ModelRenderer bottom_right_tent1;
	ModelRenderer top_left_tent2;
	ModelRenderer left_arm;	
	ModelRenderer right_arm;
	ModelRenderer mid_right_tent2;
	ModelRenderer bottom_left_tent2;
	ModelRenderer bottom_right_tent2;
	ModelRenderer mid_left_tent2;
	ModelRenderer top_right_tent2;
	
	ModelRenderer eye1;
	ModelRenderer eye2;
	ModelRenderer eye3;
	ModelRenderer eye4;
	ModelRenderer largeEye1;
	ModelRenderer largeEye2;

	public PrisonerModel() {
		textureWidth = 128;
		textureHeight = 128;
		
		(this.head = new ModelRenderer((ModelBase)this)).setRotationPoint(0.0f, -10.0f, 0.0f);
        this.head.setTextureOffset(0, 33).addBox(-8.0f, -16.0f, -6.0f, 16, 16, 10);

		(this.right_ear = new ModelRenderer((ModelBase)this)).setRotationPoint(-8.0f, -12.5f, 0.0f);
        this.head.addChild(this.right_ear);
        this.setRotation(this.right_ear, 0.0f, 0.0f, 0.0873f);
        this.right_ear.setTextureOffset(78, 78).addBox(-10.0f, -6.5f, -1.0f, 10, 10, 0);
        
		(this.left_ear = new ModelRenderer((ModelBase)this)).setRotationPoint(7.0f, -12.5f, 0.0f); //8
        this.head.addChild(this.left_ear);
        this.setRotation(this.left_ear, 0.0f, 0.0f, -0.0873f);
        this.left_ear.setTextureOffset(78, 57).addBox(0.0f, -6.5f, -1.0f, 10, 10, 0);

		(this.body = new ModelRenderer((ModelBase)this)).setRotationPoint(0.0f, -10.0f, -1.0f);
        this.setRotation(this.body, 0.0873f, 0.0f, 0.0f);
        this.body.setTextureOffset(0, 0).addBox(-9.0f, 0.0f, -5.0f, 18, 21, 11);
        		
		(this.left_arm = new ModelRenderer((ModelBase)this)).setRotationPoint(11.0f, -6.0f, 0.0f);
        this.setRotation(this.left_arm, 0.2182f, 0.0f, 0.0f);
        this.left_arm.setTextureOffset(61, 60).addBox(-2.0f, -4.0f, -4.0f, 4, 24, 4);
		
		(this.right_arm = new ModelRenderer((ModelBase)this)).setRotationPoint(-11.0f, -6.0f, 0.0f);
        this.setRotation(this.right_arm, 0.2182f, 0.0f, 0.0f);
        this.right_arm.setTextureOffset(61, 60).addBox(-2.0f, -4.0f, -4.0f, 4, 24, 4); //-6
        
        
        
        
        
        (this.top_left_tent1 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(9.0F, -33.0F, 1.0F, 18, 4, 4);
		this.top_left_tent1.setTextureSize(128, 128);
		top_left_tent1.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.top_left_tent1.mirror = true;

        (this.top_right_tent1 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(-27.0F, -33.0F, 1.0F, 18, 4, 4);
		this.top_right_tent1.setTextureSize(128, 128); //-18, -2
		top_right_tent1.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.top_right_tent1.mirror = true;
        
        (this.mid_left_tent1 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(9.0F, -27.0F, 1.0F, 14, 4, 4);
		this.mid_left_tent1.setTextureSize(128, 128); //-14, -2
		mid_left_tent1.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.mid_left_tent1.mirror = true;
        
        (this.mid_right_tent1 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(-23.0F, -27.0F, 1.0F, 14, 4, 4);
		this.mid_right_tent1.setTextureSize(128, 128);
		mid_right_tent1.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.mid_right_tent1.mirror = true;

        (this.bottom_left_tent1 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(9.0F, -21.0F, 1.0F, 12, 4, 4);
		this.bottom_left_tent1.setTextureSize(128, 128);
		bottom_left_tent1.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.bottom_left_tent1.mirror = true;

        (this.bottom_right_tent1 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(-21.0F, -21.0F, 1.0F, 12, 4, 4);
		this.bottom_right_tent1.setTextureSize(128, 128);
		bottom_right_tent1.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.bottom_right_tent1.mirror = true;
		
        (this.top_left_tent2 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(27.0F, -42.0F, 1.0F, 4, 12, 4);
        this.top_left_tent2.setTextureSize(128, 128);
		top_left_tent2.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.top_left_tent2.mirror = true;
        
        (this.mid_right_tent2 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(19.0F, -36.0F, 5.0F, 4, 12, 4);
		this.mid_right_tent2.setTextureSize(128, 128);
		mid_right_tent2.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.mid_right_tent2.mirror = true;

        (this.bottom_left_tent2 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(17.0F, -20.0F, 5.0F, 4, 6, 4);
		this.bottom_left_tent2.setTextureSize(128, 128);
		bottom_left_tent2.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.bottom_left_tent2.mirror = true;
        
        (this.bottom_right_tent2 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(-21.0F, -20.0F, 5.0F, 4, 6, 4);
		this.bottom_right_tent2.setTextureSize(128, 128);
		bottom_right_tent2.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.bottom_right_tent2.mirror = true;
		
        (this.mid_left_tent2 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(-23.0F, -36.0F, 5.0F, 4, 12, 4);
		this.mid_left_tent2.setTextureSize(128, 128);
		mid_left_tent2.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.mid_left_tent2.mirror = true;
		
        (this.top_right_tent2 = new ModelRenderer((ModelBase)this, 50, 102)).addBox(-31.0F, -42.0F, 1.0F, 4, 12, 4);
		this.top_right_tent2.setTextureSize(128, 128);
		top_right_tent2.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.top_right_tent2.mirror = true;
        
        (this.eye1 = new ModelRenderer((ModelBase)this, 0, 92)).addBox(26.0F, -48.0F, 0.0F, 6, 6, 6);
		this.eye1.setTextureSize(128, 128);
		eye1.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.eye1.mirror = true;
        
        (this.eye2 = new ModelRenderer((ModelBase)this, 0, 92)).addBox(-32.0F, -48.0F, 0.0F, 6, 6, 6);
		this.eye2.setTextureSize(128, 128);
		eye2.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.eye2.mirror = true;

        (this.eye3 = new ModelRenderer((ModelBase)this, 0, 92)).addBox(18.0F, -42.0F, 4.0F, 6, 6, 6);
		this.eye3.setTextureSize(128, 128);
		eye3.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.eye3.mirror = true;

        (this.eye4 = new ModelRenderer((ModelBase)this, 0, 92)).addBox(-24.0F, -42.0F, 4.0F, 6, 6, 6);
		this.eye4.setTextureSize(128, 128);
		eye4.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.eye4.mirror = true;

        (this.largeEye1 = new ModelRenderer((ModelBase)this, 0, 66)).addBox(15.0F, -14.0F, 3.0F, 8, 8, 8);
		this.largeEye1.setTextureSize(128, 128);
		largeEye1.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.largeEye1.mirror = true;

        (this.largeEye2 = new ModelRenderer((ModelBase)this, 0, 66)).addBox(-23.0F, -14.0F, 3.0F, 8, 8, 8);
		this.largeEye2.setTextureSize(128, 128);
		largeEye2.setRotationPoint(0.0F, 24.0F, 0.0F);
        //this.largeEye2.mirror = true;
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		top_left_tent1.render(f5);
		top_right_tent1.render(f5);
		mid_left_tent1.render(f5);
		mid_right_tent1.render(f5);
		bottom_left_tent1.render(f5);
		bottom_right_tent1.render(f5);
		top_left_tent2.render(f5);
		left_arm.render(f5);
		right_arm.render(f5);
		mid_right_tent2.render(f5);
		bottom_left_tent2.render(f5);
		bottom_right_tent2.render(f5);
		mid_left_tent2.render(f5);
		top_right_tent2.render(f5);
		eye1.render(f5);
		eye2.render(f5);
		eye3.render(f5);
		eye4.render(f5);
		largeEye1.render(f5);
		largeEye2.render(f5);
	}

	public void setRotation(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
    public void setRotationAngles(float limbSwing, float limbSwingAngle, float entityTickTime, float rotationYaw, float rotationPitch, float unitPixel, Entity entity) {
    	super.setRotationAngles(limbSwing, limbSwingAngle, entityTickTime, rotationYaw, rotationPitch, unitPixel, entity);
    	
        this.head.rotateAngleY = rotationYaw / 57.295776f;
        this.head.rotateAngleX = rotationPitch / 57.295776f;
        
        this.left_ear.rotateAngleY = rotationYaw / 57.295776f;
        this.left_ear.rotateAngleX = rotationPitch / 57.295776f;
        this.right_ear.rotateAngleY = rotationYaw / 57.295776f;
        this.right_ear.rotateAngleX = rotationPitch / 57.295776f;
        
        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * limbSwingAngle;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * limbSwingAngle;
                  
    }
}
