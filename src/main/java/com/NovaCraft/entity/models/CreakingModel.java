package com.NovaCraft.entity.models;

import java.util.List;

import com.NovaCraft.entity.EntityCreaking;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class CreakingModel extends ModelBase {
	
	ModelRenderer head;
	ModelRenderer crown;
	ModelRenderer left_leaves;
	ModelRenderer right_leaves;
	ModelRenderer body; 
	ModelRenderer body2; 
	ModelRenderer right_arm; 
	ModelRenderer right_arm2; 
	ModelRenderer left_arm; 
	ModelRenderer left_arm2; 
	ModelRenderer left_arm3; 
	ModelRenderer left_leg; 
	ModelRenderer left_foot; 
	ModelRenderer right_leg; 
	ModelRenderer right_foot; 
	ModelRenderer right_leg3; 

	public CreakingModel() {
	  textureWidth = 64;
	  textureHeight = 64;
	  
	  (this.head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0F, -10.0F, -3.0F, 6, 10, 6);
	  this.head.setTextureSize(64, 64);
	  head.setRotationPoint(-3.0F, -3.0F, 0.0F);
      this.head.mirror = true;
      
      (this.crown = new ModelRenderer((ModelBase)this, 28, 31)).addBox(0.0F, -10.0F, -3.0F, 6, 3, 6);
	  this.crown.setTextureSize(64, 64);
	  crown.setRotationPoint(-3.0F, -3.0F, 0.0F);
	  this.head.addChild(this.crown);
      
      (this.left_leaves = new ModelRenderer((ModelBase)this, 12, 40)).addBox(6.0F, -13.0F, 0.0F, 9, 14, 0);
	  this.left_leaves.setTextureSize(64, 64);
	  left_leaves.setRotationPoint(-3.0F, -3.0F, 0.0F);
	  this.head.addChild(this.left_leaves);
      
      (this.right_leaves = new ModelRenderer((ModelBase)this, 34, 12)).addBox(-9.0F, -13.0F, 0.0F, 9, 14, 0);
	  this.right_leaves.setTextureSize(64, 64);
	  right_leaves.setRotationPoint(-3.0F, -3.0F, 0.0F);
	  this.head.addChild(this.right_leaves);
	  
	  (this.body = new ModelRenderer((ModelBase)this, 0, 16)).addBox(0.0F, -3.0F, -3.0F, 6, 13, 5);
	  this.body.setTextureSize(64, 64);
	  body.setRotationPoint(0.0F, 1.0F, 1.0F);
      this.body.mirror = true;
      
      (this.body2 = new ModelRenderer((ModelBase)this, 24, 0)).addBox(-6.0F, -4.0F, -3.0F, 6, 7, 5);
	  this.body2.setTextureSize(64, 64);
	  body2.setRotationPoint(0.0F, 1.0F, 1.0F);
      this.body2.mirror = true;
      
      (this.right_arm = new ModelRenderer((ModelBase)this, 22, 13)).addBox(-2.0F, -1.5F, -1.5F, 3, 21, 3);
	  this.right_arm.setTextureSize(64, 64);
	  right_arm.setRotationPoint(-7.0F, -1.5F, 1.5F);
      this.right_arm.mirror = true;
      
      (this.right_arm2 = new ModelRenderer((ModelBase)this, 46, 0)).addBox(-2.0F, 19.5F, -1.5F, 3, 4, 3);
	  this.right_arm2.setTextureSize(64, 64);
	  right_arm2.setRotationPoint(-7.0F, -1.5F, 1.5F);
      this.right_arm2.mirror = true;
 
      (this.left_arm = new ModelRenderer((ModelBase)this, 30, 40)).addBox(0.0F, -1.0F, -1.5F, 3, 16, 3);
	  this.left_arm.setTextureSize(64, 64);
	  left_arm.setRotationPoint(6.0F, -1.0F, 0.5F);
      this.left_arm.mirror = true;
      
      (this.left_arm2 = new ModelRenderer((ModelBase)this, 52, 12)).addBox(0.0F, -5.0F, -1.5F, 3, 4, 3);
	  this.left_arm2.setTextureSize(64, 64);
	  left_arm2.setRotationPoint(6.0F, -1.0F, 0.5F);
      this.left_arm2.mirror = true;
      
      (this.left_arm3 = new ModelRenderer((ModelBase)this, 52, 19)).addBox(0.0F, 15.0F, -1.5F, 3, 4, 3);
	  this.left_arm3.setTextureSize(64, 64);
	  left_arm3.setRotationPoint(6.0F, -1.0F, 0.5F);
      this.left_arm3.mirror = true;
      
      (this.left_leg = new ModelRenderer((ModelBase)this, 42, 40)).addBox(0.0F, 2.0F, -1.5F, 3, 16, 3);
	  this.left_leg.setTextureSize(64, 64);
	  left_leg.setRotationPoint(1.5F, 6.0F, 0.5F);
      this.left_leg.mirror = true;
      
      (this.left_foot = new ModelRenderer((ModelBase)this, 45, 55)).addBox(-3.0F, 12.0F, -4.5F, 5, 0, 9);
	  this.left_foot.setTextureSize(64, 64);
	  left_foot.setRotationPoint(1.5F, 6.0F, 0.5F);
	  this.left_leg.addChild(this.left_foot);
     
      (this.right_leg = new ModelRenderer((ModelBase)this, 0, 34)).addBox(-3.0F, -1.5F, -1.5F, 3, 19, 3);
	  this.right_leg.setTextureSize(64, 64);
	  right_leg.setRotationPoint(-1.0F, 6.5F, 0.5F);
      this.right_leg.mirror = true;
      
      (this.right_foot = new ModelRenderer((ModelBase)this, 45, 46)).addBox(-4.0F, 11.0F, -4.5F, 5, 0, 9);
	  this.right_foot.setTextureSize(64, 64);
	  right_foot.setRotationPoint(-1.0F, 6.5F, 0.5F);
	  this.right_leg.addChild(this.right_foot);
      
      (this.right_leg3 = new ModelRenderer((ModelBase)this, 12, 34)).addBox(-3.0F, -4.5F, -1.5F, 3, 3, 3);
	  this.right_leg3.setTextureSize(64, 64);
	  right_leg3.setRotationPoint(-1.0F, 6.5F, 0.5F);
      this.right_leg3.mirror = true;      
      
   }

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		body2.render(f5);
		right_arm.render(f5);
		right_arm2.render(f5);
		left_arm.render(f5);
		left_arm2.render(f5);
		left_arm3.render(f5);
		left_leg.render(f5);
		right_leg.render(f5);
		right_leg3.render(f5);
		
	}
	
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity)
    {
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.35F * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.35F * limbSwingAmount;

        this.right_leg.rotateAngleY = 0.0F;
        this.left_leg.rotateAngleY = 0.0F;
        
    }
	
	@Override
	public void setLivingAnimations(EntityLivingBase entityIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
	    EntityCreaking entity = (EntityCreaking) entityIn;
	    int attackTimer = entity.getAttackTimer();

	    if (attackTimer > 0) {
	        float progress = ((float)attackTimer - partialTickTime) / 10.0F;
	        float swing = MathHelper.sin(progress * (float)Math.PI);
	        
	        this.right_arm.rotateAngleX = -2.0F * swing;
	        this.left_arm.rotateAngleX = -2.0F * swing;
	    } else {
	        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.35F * limbSwingAmount;
	        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.35F * limbSwingAmount;
	    }
	}

    private float func_78172_a(float p_78172_1_, float p_78172_2_)
    {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}


