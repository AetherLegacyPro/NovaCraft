package com.NovaCraft.entity.models;

import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
    
    public class WardlingModel extends ModelBase {
    	
         ModelRenderer head;
         ModelRenderer right_ear;
         ModelRenderer left_ear;
         ModelRenderer body;
         ModelRenderer right_arm;
         ModelRenderer left_arm;
         ModelRenderer left_leg;
         ModelRenderer right_leg;

         ModelRenderer mouth_bottomleft;
         ModelRenderer mouth_bottomright;
         ModelRenderer mouth_topleft;
         ModelRenderer mouth_4;
        
        public WardlingModel() {
            this.textureWidth = 128;
            this.textureHeight = 128;
            
            (this.head = new ModelRenderer((ModelBase)this)).setRotationPoint(0.0f, -10.0f, 0.0f);
            this.setRotation(this.head, 0.0973f, 0.0f, 0.0f);
            this.head.setTextureOffset(0, 0).addBox(0.0F, -14.0F, -4.0F, 6, 16, 6);
            
            (this.body = new ModelRenderer((ModelBase)this)).setRotationPoint(0.0f, -10.0f, -1.0f);
            this.setRotation(this.body, 0.0873f, 0.0f, 0.0f);
            this.body.setTextureOffset(0, 29).addBox(-8.0F, 2.0F, -4.0F, 16, 20, 8);
            
            (this.right_arm = new ModelRenderer((ModelBase)this)).setRotationPoint(-11.0f, -6.0f, 0.0f);
            this.setRotation(this.right_arm, 0.2182f, 0.0f, 0.0f);
            this.right_arm.setTextureOffset(0, 59).addBox(-3.0F, 0.0F, -4.0F, 6, 18, 6);
            
            (this.left_arm = new ModelRenderer((ModelBase)this)).setRotationPoint(-11.0f, -6.0f, 0.0f);
            this.setRotation(this.left_arm, 0.2182f, 0.0f, 0.0f);
            this.left_arm.setTextureOffset(0, 87).addBox(19.0F, 0.0F, -4.0F, 6, 25, 6);
            
            (this.right_ear = new ModelRenderer((ModelBase)this)).setRotationPoint(-8.0f, -12.5f, 0.0f);
            this.head.addChild(this.right_ear);
            this.setRotation(this.right_ear, 0.0973f, 0.0f, 0.0f);
            this.right_ear.setTextureOffset(58, 10).addBox(14.0F, 2.0F, -1.0F, 6, 6, 0);
            
            (this.left_ear = new ModelRenderer((ModelBase)this)).setRotationPoint(-8.0f, -12.5f, 0.0f);
            this.head.addChild(this.left_ear);
            this.setRotation(this.left_ear, 0.0973f, 0.0f, -0.0f);
            this.left_ear.setTextureOffset(45, 10).addBox(2.0F, 2.0F, -1.0F, 6, 6, 0);
            
            (this.left_leg = new ModelRenderer((ModelBase)this)).setRotationPoint(6.0f, 11.0f, 0.0f);
            this.left_leg.setTextureOffset(0, 59).addBox(-13.0F, 0.5F, -3.0F, 6, 12, 6);
            
            (this.right_leg = new ModelRenderer((ModelBase)this)).setRotationPoint(6.0f, 11.0f, 0.0f);
            this.right_leg.setTextureOffset(0, 60).addBox(-3.0F, 0.5F, -3.0F, 6, 12, 6);
            
            (this.mouth_bottomleft = new ModelRenderer((ModelBase)this)).setRotationPoint(6.0F, -20.0F, -3.0F);
            this.body.addChild(mouth_bottomleft);
            this.setRotation(this.mouth_bottomleft, -0.2182F, -0.3927F, 0.0F);
            this.mouth_bottomleft.setTextureOffset(75, 3).addBox(-9.0F, 30.0F, 4.0F, 2, 2, 6);
            
            (this.mouth_bottomright = new ModelRenderer((ModelBase)this)).setRotationPoint(4.0F, -20.0F, -7.0F);
            this.body.addChild(mouth_bottomright);
            this.setRotation(this.mouth_bottomright, -0.2182F, 0.3927F, 0.0F);
            this.mouth_bottomright.setTextureOffset(75, 3).addBox(-3.0F, 30.0F, 4.0F, 2, 2, 6);
            
            (this.mouth_topleft = new ModelRenderer((ModelBase)this)).setRotationPoint(6.0F, -23.0F, -3.0F);
            this.body.addChild(mouth_topleft);
            this.setRotation(this.mouth_topleft, 0.2182F, -0.3927F, 0.0F);
            this.mouth_topleft.setTextureOffset(75, 3).addBox(-9.0F, 29.0F, -9.0F, 2, 2, 6);
            
            (this.mouth_4 = new ModelRenderer((ModelBase)this)).setRotationPoint(4.0F, -23.0F, -7.0F);
            this.body.addChild(mouth_4);
            this.setRotation(this.mouth_4, 0.2182F, 0.3927F, 0.0F);
            this.mouth_4.setTextureOffset(75, 3).addBox(-2.0F, 29.0F, -9.0F, 2, 2, 6);
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
            
            this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * limbSwingAngle;
            this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0f) * -1.0f * limbSwingAngle;
            this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * limbSwingAngle;
            this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 1.0f) * 1.0f * limbSwingAngle;
                      
        }
    }
