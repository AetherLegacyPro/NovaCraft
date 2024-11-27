package com.NovaCraft.entity.models;

import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
    
    public class WardenModel extends ModelBase {
    	
         ModelRenderer head;
         ModelRenderer right_ear;
         ModelRenderer left_ear;
         ModelRenderer body;
         ModelRenderer right_arm;
         ModelRenderer left_arm;
         ModelRenderer left_leg;
         ModelRenderer right_leg;
        
        public WardenModel() {
            this.textureWidth = 128;
            this.textureHeight = 128;
            
            (this.head = new ModelRenderer((ModelBase)this)).setRotationPoint(0.0f, -10.0f, 0.0f);
            this.head.setTextureOffset(0, 33).addBox(-8.0f, -16.0f, -6.0f, 16, 16, 10);               
            
            (this.right_ear = new ModelRenderer((ModelBase)this)).setRotationPoint(-8.0f, -12.5f, 0.0f);
            this.head.addChild(this.right_ear);
            this.setRotation(this.right_ear, 0.0f, 0.0f, 0.0873f);
            this.right_ear.setTextureOffset(78, 78).addBox(-10.0f, -6.5f, -1.0f, 10, 10, 0);
            
            (this.left_ear = new ModelRenderer((ModelBase)this)).setRotationPoint(8.0f, -12.5f, 0.0f);
            this.head.addChild(this.left_ear);
            this.setRotation(this.left_ear, 0.0f, 0.0f, -0.0873f);
            this.left_ear.setTextureOffset(78, 57).addBox(0.0f, -6.5f, -1.0f, 10, 10, 0);
            
            (this.body = new ModelRenderer((ModelBase)this)).setRotationPoint(0.0f, -10.0f, -1.0f);
            this.setRotation(this.body, 0.0873f, 0.0f, 0.0f);
            this.body.setTextureOffset(0, 0).addBox(-9.0f, 0.0f, -5.0f, 18, 21, 11);
            
            (this.right_arm = new ModelRenderer((ModelBase)this)).setRotationPoint(-11.0f, -6.0f, 0.0f);
            this.setRotation(this.right_arm, 0.2182f, 0.0f, 0.0f);
            this.right_arm.setTextureOffset(59, 0).addBox(-6.0f, -4.0f, -4.0f, 8, 28, 8);
            
            (this.left_arm = new ModelRenderer((ModelBase)this)).setRotationPoint(11.0f, -6.0f, 0.0f);
            this.setRotation(this.left_arm, 0.2182f, 0.0f, 0.0f);
            this.left_arm.setTextureOffset(45, 52).addBox(-2.0f, -4.0f, -4.0f, 8, 28, 8);
            
            (this.left_leg = new ModelRenderer((ModelBase)this)).setRotationPoint(6.0f, 11.0f, 0.0f);
            this.left_leg.setTextureOffset(70, 37).addBox(-3.0f, 0.0f, -3.0f, 6, 13, 6);
            
            (this.right_leg = new ModelRenderer((ModelBase)this)).setRotationPoint(-6.0f, 11.0f, 0.0f);
            this.right_leg.setTextureOffset(0, 60).addBox(-3.0f, 0.0f, -3.0f, 6, 13, 6);
        }
        
        public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
            super.render(entity, f, f1, f2, f3, f4, f5);
            this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            this.head.render(f5);
            this.body.render(f5);
            this.right_arm.render(f5);
            this.left_arm.render(f5);
            this.left_leg.render(f5);
            this.right_leg.render(f5);
        }
        
        public void setRotation(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
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
            this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0f) * -1.0f * limbSwingAngle;
            this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * limbSwingAngle;
            this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0f) * 1.0f * limbSwingAngle;
                      
        }
    }
