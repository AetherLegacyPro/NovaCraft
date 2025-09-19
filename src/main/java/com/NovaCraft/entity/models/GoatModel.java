package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityGoat;
import com.google.common.collect.ImmutableList;

public class GoatModel extends ModelBase
{
    ModelRenderer headModel; //ears and hair
    ModelRenderer leftHorn;
    ModelRenderer rightHorn;
    ModelRenderer nose; //head
    ModelRenderer body;
    ModelRenderer legBackLeft;
    ModelRenderer legBackRight;
    ModelRenderer legFrontLeft;
    ModelRenderer legFrontRight;
    
    public GoatModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        
        (this.headModel = new ModelRenderer((ModelBase)this)).setRotationPoint(1.0f, 14.0f, 0.0f);
        this.headModel.setTextureOffset(2, 61).addBox(2.0f, -11.0f, -10.0f, 3, 2, 1);
        this.headModel.setTextureOffset(2, 61).addBox(-6.0f, -11.0f, -10.0f, 3, 2, 1);
        this.headModel.setTextureOffset(23, 52).addBox(-0.5f, -3.0f, -14.0f, 0, 7, 5);
        this.headModel.mirror = true;
        
        (this.leftHorn = new ModelRenderer((ModelBase)this)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.leftHorn.setTextureOffset(12, 55).addBox(-0.01f, -16.0f, -10.0f, 2, 7, 2);
        this.leftHorn.mirror = true;
        this.headModel.addChild(this.leftHorn);
        
        (this.rightHorn = new ModelRenderer((ModelBase)this)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.rightHorn.setTextureOffset(12, 55).addBox(-2.99f, -16.0f, -10.0f, 2, 7, 2);
        this.rightHorn.mirror = true;
        this.headModel.addChild(this.rightHorn);
        
        (this.nose = new ModelRenderer((ModelBase)this)).setRotationPoint(0.0f, -8.0f, -8.0f);
        this.setRotation(this.nose, 0.9599f, 0.0f, 0.0f);
        this.nose.setTextureOffset(34, 46).addBox(-3.0f, -4.0f, -8.0f, 5, 7, 10);
        this.nose.mirror = true;
        this.headModel.addChild(this.nose);
        
        (this.body = new ModelRenderer((ModelBase)this)).setRotationPoint(0.0f, 12.0f, 0.0f);
        this.body.setTextureOffset(1, 1).addBox(-4.0f, -5.0f, -7.0f, 9, 11, 16);
        this.body.setTextureOffset(0, 28).addBox(-5.0f, -6.0f, -8.0f, 11, 14, 11);
        this.body.mirror = true;
        
        (this.legBackLeft = new ModelRenderer((ModelBase)this)).setRotationPoint(1.0f, 14.0f, 4.0f);
        this.legBackLeft.setTextureOffset(36, 29).addBox(0.0f, 4.0f, 0.0f, 3, 6, 3);
        this.legBackLeft.mirror = true;
        
        (this.legBackRight = new ModelRenderer((ModelBase)this)).setRotationPoint(-3.0f, 14.0f, 4.0f);
        this.legBackRight.setTextureOffset(49, 29).addBox(0.0f, 4.0f, 0.0f, 3, 6, 3);
        this.legBackRight.mirror = true;
        
        (this.legFrontLeft = new ModelRenderer((ModelBase)this)).setRotationPoint(-3.0f, 14.0f, -6.0f);
        this.legFrontLeft.setTextureOffset(49, 2).addBox(0.0f, 0.0f, 0.0f, 3, 10, 3);
        this.legFrontLeft.mirror = true;
        
        (this.legFrontRight = new ModelRenderer((ModelBase)this)).setRotationPoint(1.0f, 14.0f, -6.0f);
        this.legFrontRight.setTextureOffset(35, 2).addBox(0.0f, 0.0f, 0.0f, 3, 10, 3);
        this.legFrontRight.mirror = true;
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    	super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	EntityGoat goat = ((EntityGoat) entity);
        if(goat.isChild()) {       	
        	GL11.glScalef(1.0F / 2.0F, 1.0F / 2.0F, 1.0F / 2.0F);
			GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
			
			this.leftHorn.showModel = false;
	        this.rightHorn.showModel = false;
	        this.headModel.render(f5);
        	this.body.render(f5);
        	this.legBackLeft.render(f5);
        	this.legBackRight.render(f5);
        	this.legFrontLeft.render(f5);
        	this.legFrontRight.render(f5);
       } else {
    	    this.leftHorn.showModel = true;
	        this.rightHorn.showModel = true;
        	this.headModel.render(f5);
        	this.body.render(f5);
        	this.legBackLeft.render(f5);
        	this.legBackRight.render(f5);
        	this.legFrontLeft.render(f5);
        	this.legFrontRight.render(f5);
       }
        
    }
    
    public void setRotation(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {	
    	
    	final float f6 = 57.295776f;
        this.headModel.rotateAngleX = f4 * 0.009453292f; //0.017453292
        this.headModel.rotateAngleY = f3 * 0.009453292f;
        this.legBackRight.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.legBackLeft.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.legFrontRight.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;

    }
    
}
