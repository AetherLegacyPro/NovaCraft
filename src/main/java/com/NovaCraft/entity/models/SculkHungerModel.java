package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class SculkHungerModel extends ModelBase
{
	ModelRenderer body;
	ModelRenderer left_arm;
	public ModelRenderer right_arm;
	ModelRenderer left_leg;
	ModelRenderer right_leg;
	
	ModelRenderer tentacle1;
	ModelRenderer tentacle2;
	ModelRenderer tentacle3;
	ModelRenderer lefttentacle1;
	ModelRenderer lefttentacle2;
	ModelRenderer righttentacle;
	ModelRenderer part7;
	ModelRenderer part8;
	ModelRenderer part9;
	ModelRenderer part10;
	ModelRenderer part11;
	ModelRenderer part12;
	ModelRenderer part13;
	ModelRenderer part14;
	ModelRenderer part15;
	ModelRenderer part16;
	ModelRenderer part17;
	ModelRenderer part18;
	ModelRenderer part19;
	
	public int heldItemLeft;
	public int heldItemRight;
	
	public SculkHungerModel() {
		textureWidth = 64;
		textureHeight = 64;
		
		(this.tentacle1 = new ModelRenderer((ModelBase)this, 8, 4)).addBox(-2.0F, 4.0F, -2.0F, 4, 4, 4);
		this.tentacle1.setTextureSize(64, 64);
		tentacle1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle1.mirror = true;
		
        (this.tentacle2 = new ModelRenderer((ModelBase)this, 12, 6)).addBox(-1.0F, -1.0F, -1.0F, 2, 5, 2);
		this.tentacle2.setTextureSize(64, 64);
		tentacle2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle2.mirror = true;
        
        (this.tentacle3 = new ModelRenderer((ModelBase)this, -2, -2)).addBox(-1.0F, -3.0F, -4.0F, 2, 2, 4);
		this.tentacle3.setTextureSize(64, 64);
		tentacle3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tentacle3.mirror = true;
        
        (this.lefttentacle1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(1.0F, 2.0F, -1.0F, 2, 2, 2); //5.0F, 2.0F, -1.0F
		this.lefttentacle1.setTextureSize(64, 64);
		lefttentacle1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lefttentacle1.mirror = true;
        
        (this.lefttentacle2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0F, 4.0F, -1.0F, 2, 4, 2); //4.0F, 4.0F, -1.0F
		this.lefttentacle2.setTextureSize(64, 64);
		lefttentacle2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lefttentacle2.mirror = true;
        
        (this.righttentacle = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0F, 6.0F, -1.0F, 2, 2, 2); //-7.0F, 6.0F, -1.0F
		this.righttentacle.setTextureSize(64, 64);
		righttentacle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.righttentacle.mirror = true;
        
        (this.part7 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(1.0F, 13.0F, -4.0F, 1, 1, 2);
		this.part7.setTextureSize(64, 64);
		part7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part7.mirror = true;

        (this.part8 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(1.0F, 20.0F, -4.0F, 1, 1, 2);
		this.part8.setTextureSize(64, 64);
		part8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part8.mirror = true;
        
        (this.part9 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(-3.0F, 17.0F, -4.0F, 1, 1, 2);
      	this.part9.setTextureSize(64, 64);
      	part9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part9.mirror = true;
        
        (this.part10 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(-3.0F, 21.0F, 2.0F, 1, 1, 2);
      	this.part10.setTextureSize(64, 64);
      	part10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part10.mirror = true;
        
        (this.part11 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(1.0F, 19.0F, 2.0F, 1, 1, 2);
      	this.part11.setTextureSize(64, 64);
      	part11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part11.mirror = true;

        (this.part12 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(-9.0F, 12.0F, -1.0F, 1, 2, 2);
      	this.part12.setTextureSize(64, 64);
      	part12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part12.mirror = true;
        
        (this.part13 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(-3.0F, 9.0F, -4.0F, 1, 1, 2);
      	this.part13.setTextureSize(64, 64);
      	part13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part13.mirror = true;
        
        (this.part14 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(-2.0F, 12.0F, -4.0F, 1, 1, 2);
      	this.part14.setTextureSize(64, 64);
      	part14.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part14.mirror = true;
        
        (this.part15 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(-2.0F, 11.0F, 2.0F, 1, 1, 2);
      	this.part15.setTextureSize(64, 64);
      	part15.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part15.mirror = true;

        (this.part16 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(2.0F, 12.0F, 2.0F, 1, 1, 2);
      	this.part16.setTextureSize(64, 64);
      	part16.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part16.mirror = true;
        
        (this.part17 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(1.0F, 9.0F, 2.0F, 1, 1, 2);
      	this.part17.setTextureSize(64, 64);
      	part17.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part17.mirror = true;

        (this.part18 = new ModelRenderer((ModelBase)this, 2, 1)).addBox(-7.0F, 11.0F, -4.0F, 1, 1, 1);
      	this.part18.setTextureSize(64, 64);
      	part18.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part18.mirror = true;
        
        (this.part19 = new ModelRenderer((ModelBase)this, 1, 0)).addBox(7.0F, 9.0F, -1.0F, 2, 2, 2);
      	this.part19.setTextureSize(64, 64);
      	part19.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part19.mirror = true;	

        (this.body = new ModelRenderer((ModelBase)this, 16, 16)).addBox(-4.0F, 8.0F, -2.0F, 8, 8, 4);
      	this.body.setTextureSize(64, 64);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);	
		this.body.mirror = true;
		
		(this.left_arm = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-1.0F, 6.0F, -2.0F, 3, 8, 4);
      	this.left_arm.setTextureSize(64, 64);
      	left_arm.setRotationPoint(5.0F, 2.0F, 0.0F);	
		this.left_arm.mirror = true;
		
		(this.right_arm = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-3.0F, 6.0F, -2.0F, 4, 8, 4);
      	this.right_arm.setTextureSize(64, 64);
      	right_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);	
		this.right_arm.mirror = true;

		(this.left_leg = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-2.0F, 4.0F, -2.0F, 4, 8, 4);
		this.left_leg.setTextureSize(64, 64);
		left_leg.setRotationPoint(2.0F, 12.0F, 0.0F);
		this.left_leg.mirror = true;
		
		(this.right_leg = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-2.0F, 4.0F, -2.0F, 4, 8, 4);
		this.right_leg.setTextureSize(64, 64);
		right_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		this.right_leg.mirror = true;		
		
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		tentacle1.render(f5);
		tentacle2.render(f5);
		tentacle3.render(f5);
		lefttentacle1.render(f5);
		lefttentacle2.render(f5);
		righttentacle.render(f5);
		//part7.render(f5);
		//part8.render(f5);
		//part9.render(f5);
		//part10.render(f5);
		//part11.render(f5);
		//part12.render(f5);
		//part13.render(f5);
		//part14.render(f5);
		//part15.render(f5);
		//part16.render(f5);
		//part17.render(f5);
		//part18.render(f5);
		//part19.render(f5);
		
		body.render(f5);
		left_arm.render(f5);
		right_arm.render(f5);
		left_leg.render(f5);
		right_leg.render(f5);
	}
	
	public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        this.tentacle1.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
        this.tentacle2.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
        this.tentacle3.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
		this.right_arm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 2.0F * p_78087_2_ * 0.25F;
		this.righttentacle.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 2.0F * p_78087_2_ * 0.25F;
        this.left_arm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.25F;       
        this.lefttentacle1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.25F;
        this.lefttentacle2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.25F;       
        this.right_arm.rotateAngleZ = 0.0F;
        this.righttentacle.rotateAngleZ = 0.0F;
        this.left_arm.rotateAngleZ = 0.0F;
        this.lefttentacle1.rotateAngleZ = 0.0F;
        this.lefttentacle2.rotateAngleZ = 0.0F;
        this.right_leg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 0.7F * p_78087_2_;
        this.left_leg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 0.7F * p_78087_2_;
        this.right_leg.rotateAngleY = 0.0F;
        this.left_leg.rotateAngleY = 0.0F;

        if (this.heldItemLeft != 0)
        {
            this.left_arm.rotateAngleX = this.left_arm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemLeft;
            this.lefttentacle1.rotateAngleX = this.lefttentacle1.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemLeft;
            this.lefttentacle2.rotateAngleX = this.lefttentacle2.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemLeft;
        }

        if (this.heldItemRight != 0)
        {
            this.right_arm.rotateAngleX = this.right_arm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemRight;
            this.righttentacle.rotateAngleX = this.righttentacle.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemRight;
        }

        this.right_arm.rotateAngleY = 0.0F;
        this.righttentacle.rotateAngleY = 0.0F;
        this.left_arm.rotateAngleY = 0.0F;
        this.lefttentacle1.rotateAngleY = 0.0F;
        this.lefttentacle2.rotateAngleY = 0.0F;
        float f6;
        float f7;

        if (this.onGround > -9990.0F)
        {
            f6 = this.onGround;
            this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.1F;
            this.right_arm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 2.5F;
            this.right_arm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 2.5F;           
            this.righttentacle.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 2.5F;
            this.righttentacle.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 2.5F;           
            this.left_arm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 2.5F;            
            this.lefttentacle1.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 2.5F;
            this.lefttentacle2.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 2.5F;            
            this.left_arm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 2.5F;            
            this.lefttentacle1.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 2.5F;
            this.lefttentacle2.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 2.5F;           
            this.right_arm.rotateAngleY += this.body.rotateAngleY;
            this.righttentacle.rotateAngleY += this.body.rotateAngleY;
            this.left_arm.rotateAngleY += this.body.rotateAngleY;
            this.left_arm.rotateAngleX += this.body.rotateAngleY;
        }

        
            this.body.rotateAngleX = 0.0F;            
            this.tentacle1.rotationPointY = 0.0F;
            this.tentacle2.rotationPointY = 0.0F;
            this.tentacle3.rotationPointY = 0.0F;

        this.right_arm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
        this.righttentacle.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
        this.left_arm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
        this.lefttentacle1.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
        this.lefttentacle2.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
        this.right_arm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
        this.left_arm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;

    }

}
