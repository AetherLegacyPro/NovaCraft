package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class SculkAbominationModel extends ModelBase
{	
	//legs
	ModelRenderer part1;
	ModelRenderer part2;	
	ModelRenderer part3;
	ModelRenderer part4;
	ModelRenderer part5;
	ModelRenderer part6;
	ModelRenderer part7;
	ModelRenderer part8;
	ModelRenderer part9;
	ModelRenderer part10;
	ModelRenderer part11;
	ModelRenderer part12;
	
	//body
	ModelRenderer body;
	
	//eyes
	ModelRenderer eye;
	
	//spikes
	ModelRenderer part18;
	ModelRenderer part19;
	ModelRenderer part20;
	ModelRenderer part21;
	ModelRenderer part22;	
	ModelRenderer part23;
	ModelRenderer part24;
	ModelRenderer part25;
	
	ModelRenderer part26;
	ModelRenderer part27;
	ModelRenderer part29;
	ModelRenderer part30;
	ModelRenderer part31;
	ModelRenderer part32;
	ModelRenderer part33;
	ModelRenderer part34;
	
	ModelRenderer part35;
	ModelRenderer part36;
	ModelRenderer part37;
	ModelRenderer part38;
	ModelRenderer part39;
	ModelRenderer part40;
	ModelRenderer part41;
	ModelRenderer part42;

	public SculkAbominationModel() {
		textureWidth = 64;
		textureHeight = 32;
		
		(this.part1 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-1.0F, -4.0F, -8.0F, 2, 4, 1);
		this.part1.setTextureSize(64, 32); //52 40
		part1.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part1, 0.0F, -1.5708F, 0.0F);
        this.part1.mirror = true;
        
        (this.part2 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-1.0F, -4.0F, 7.0F, 2, 4, 1);
		this.part2.setTextureSize(64, 32);
		part2.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part2, 0.0F, -1.5708F, 0.0F);
        this.part2.mirror = true;
        
        (this.part3 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(7.0F, -4.0F, -1.0F, 1, 4, 2);
		this.part3.setTextureSize(64, 32);
		part3.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part3, 0.0F, -1.5708F, 0.0F);
        this.part3.mirror = true;
        
        (this.part4 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-8.0F, -4.0F, -1.0F, 1, 4, 2);
		this.part4.setTextureSize(64, 32);
		part4.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part4, 0.0F, -1.5708F, 0.0F);
        this.part4.mirror = true;
        
        (this.part5 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-7.0F, -5.0F, -1.0F, 2, 1, 2);
		this.part5.setTextureSize(64, 32);
		part5.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part5, 0.0F, -1.5708F, 0.0F);
        this.part5.mirror = true;
        
        (this.part6 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-5.0F, -6.0F, -1.0F, 2, 1, 2);
		this.part6.setTextureSize(64, 32);
		part6.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part6, 0.0F, -1.5708F, 0.0F);
        this.part6.mirror = true;
               
        (this.part7 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(5.0F, -5.0F, -1.0F, 2, 1, 2);
		this.part7.setTextureSize(64, 32);
		part7.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part7, 0.0F, -1.5708F, 0.0F);
        this.part7.mirror = true;
        
        (this.part8 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(3.0F, -6.0F, -1.0F, 2, 1, 2);
		this.part8.setTextureSize(64, 32);
		part8.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part8, 0.0F, -1.5708F, 0.0F);
        this.part8.mirror = true;
        
        (this.part9 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-1.0F, -5.0F, -7.0F, 2, 1, 2);
		this.part9.setTextureSize(64, 32);
		part9.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part9, 0.0F, -1.5708F, 0.0F);
        this.part9.mirror = true;
        
        (this.part10 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-1.0F, -6.0F, -5.0F, 2, 1, 2);
		this.part10.setTextureSize(64, 32);
		part10.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part10, 0.0F, -1.5708F, 0.0F);
        this.part10.mirror = true;
        
        (this.part11 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-1.0F, -5.0F, 5.0F, 2, 1, 2);
		this.part11.setTextureSize(64, 32);
		part11.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part11, 0.0F, -1.5708F, 0.0F);
        this.part11.mirror = true;
              
        (this.part12 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-1.0F, -6.0F, 3.0F, 2, 1, 2);
		this.part12.setTextureSize(64, 32);
		part12.setRotationPoint(0.0F, 24.0F, 0.0F);
		//setRotationAngle(part12, 0.0F, -1.5708F, 0.0F);
        this.part12.mirror = true;
        
        (this.body = new ModelRenderer((ModelBase)this, 40, 5)).addBox(-3.0F, -23.0F, -3.0F, 6, 18, 6);
		this.body.setTextureSize(64, 32);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(body, 0.0F, -1.5708F, 0.0F);
        this.body.mirror = true;
        
        (this.eye = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0F, -29.0F, -3.0F, 6, 6, 6);
     	this.eye.setTextureSize(64, 32);
     	eye.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(eye, 0.0F, -1.5708F, 0.0F);
        this.eye.mirror = true;

        (this.part18 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(3.0F, -11.0F, 0.0F, 2, 1, 1);
     	this.part18.setTextureSize(64, 32);
        part18.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(part18, 0.0F, -1.5708F, 0.0F);
        this.part18.mirror = true;
              
        (this.part19 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-5.0F, -11.0F, 0.0F, 2, 1, 1);
     	this.part19.setTextureSize(64, 32);
        part19.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(part19, 0.0F, -1.5708F, 0.0F);
        this.part19.mirror = true;
                
        (this.part20 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(0.0F, -14.0F, -3.0F, 1, 1, -2);
     	this.part20.setTextureSize(64, 32);
     	part20.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part20, 0.0F, -1.5708F, 0.0F);
        this.part20.mirror = true;
        
        (this.part21 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(0.0F, -9.0F, 5.0F, 1, 1, -2);
     	this.part21.setTextureSize(64, 32);
     	part21.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part21, 0.0F, -1.5708F, 0.0F);
        this.part21.mirror = true;
        
        (this.part22 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-2.0F, -16.0F, 5.0F, 1, 1, -2);
     	this.part22.setTextureSize(64, 32);
     	part22.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part22, 0.0F, -1.5708F, 0.0F);
        this.part22.mirror = true;
        
        (this.part23 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-5.0F, -13.0F, -2.0F, 2, 1, 1);
     	this.part23.setTextureSize(64, 32);
     	part23.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part23, 0.0F, -1.5708F, 0.0F);
        this.part23.mirror = true;
        
        (this.part24 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-2.0F, -10.0F, -3.0F, 1, 1, -2);
     	this.part24.setTextureSize(64, 32);
     	part24.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part24, 0.0F, -1.5708F, 0.0F);
        this.part24.mirror = true;
        
        (this.part25 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(3.0F, -15.0F, 1.0F, 2, 1, 1);
     	this.part25.setTextureSize(64, 32);
     	part25.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part25, 0.0F, -1.5708F, 0.0F);
        this.part25.mirror = true;
        
        
        
        //upper spikes
        (this.part26 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(3.0F, -14.0F, 0.0F, 2, 1, 1);
     	this.part26.setTextureSize(64, 32);
     	part26.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part26, 0.0F, -1.5708F, 0.0F);
        this.part26.mirror = true;
              
        (this.part27 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-5.0F, -14.0F, 0.0F, 2, 1, 1);
     	this.part27.setTextureSize(64, 32);
     	part27.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part27, 0.0F, -1.5708F, 0.0F);
        this.part27.mirror = true;
                
        (this.part29 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(0.0F, -16.0F, -3.0F, 1, 1, -2);
     	this.part29.setTextureSize(64, 32);
     	part29.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part29, 0.0F, -1.5708F, 0.0F);
        this.part29.mirror = true;
        
        (this.part30 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(0.0F, -12.0F, 5.0F, 1, 1, -2);
     	this.part30.setTextureSize(64, 32);
     	part30.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part30, 0.0F, -1.5708F, 0.0F);
        this.part30.mirror = true;
        
        (this.part31 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-2.0F, -17.0F, 5.0F, 1, 1, -2);
     	this.part31.setTextureSize(64, 32);
     	part31.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part31, 0.0F, -1.5708F, 0.0F);
        this.part31.mirror = true;
        
        (this.part32 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-5.0F, -16.0F, -2.0F, 2, 1, 1);
     	this.part32.setTextureSize(64, 32);
     	part32.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part32, 0.0F, -1.5708F, 0.0F);
        this.part32.mirror = true;
        
        (this.part33 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-2.0F, -11.0F, -3.0F, 1, 1, -2);
     	this.part33.setTextureSize(64, 32);
     	part33.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part33, 0.0F, -1.5708F, 0.0F);
        this.part33.mirror = true;
        
        (this.part34 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(3.0F, -13.0F, 1.0F, 2, 1, 1);
     	this.part34.setTextureSize(64, 32);
     	part34.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part34, 0.0F, -1.5708F, 0.0F);
        this.part34.mirror = true;
                   
        (this.part35 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-2.0F, -18.0F, -3.0F, 1, 1, -2);
     	this.part35.setTextureSize(64, 32);
     	part35.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part35, 0.0F, -1.5708F, 0.0F);
        this.part35.mirror = true;
        
        (this.part36 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(1.0F, -21.0F, -3.0F, 1, 1, -2);
     	this.part36.setTextureSize(64, 32);
     	part36.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part36, 0.0F, -1.5708F, 0.0F);
        this.part36.mirror = true;
        
        (this.part37 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(0.0F, -20.0F, 5.0F, 1, 1, -2);
     	this.part37.setTextureSize(64, 32);
     	part37.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part37, 0.0F, -1.5708F, 0.0F);
        this.part37.mirror = true;
        
        (this.part38 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(1.0F, -17.0F, 5.0F, 1, 1, -2);
     	this.part38.setTextureSize(64, 32);
     	part38.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part38, 0.0F, -1.5708F, 0.0F);
        this.part38.mirror = true;
        
        (this.part39 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-1.0F, -22.0F, 5.0F, 1, 1, -2);
     	this.part39.setTextureSize(64, 32);
     	part39.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part39, 0.0F, -1.5708F, 0.0F);
        this.part39.mirror = true;
        
        (this.part40 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-2.0F, -16.0F, 5.0F, 1, 1, -2);
     	this.part40.setTextureSize(64, 32);
     	part40.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part40, 0.0F, -1.5708F, 0.0F);
        this.part40.mirror = true;
        
        (this.part41 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-5.0F, -13.0F, -2.0F, 2, 1, 1);
     	this.part41.setTextureSize(64, 32);
     	part41.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part41, 0.0F, -1.5708F, 0.0F);
        this.part41.mirror = true;
        
        (this.part42 = new ModelRenderer((ModelBase)this, 40, 20)).addBox(-5.0F, -19.0F, -1.0F, 2, 1, 1);
     	this.part42.setTextureSize(64, 32);
     	part42.setRotationPoint(0.0F, 24.0F, 0.0F);
     	setRotationAngle(part42, 0.0F, -1.5708F, 0.0F);
        this.part42.mirror = true;
        
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
		super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
		part1.render(f5);
		part2.render(f5);
		part3.render(f5);
		part4.render(f5);
		part5.render(f5);
		part6.render(f5);
		part7.render(f5);
		part8.render(f5);
		part9.render(f5);
		part10.render(f5);
		part11.render(f5);		
		part12.render(f5);
		
		body.render(f5);
		
		eye.render(f5);
		
		part18.render(f5);
		part19.render(f5);
		part20.render(f5);
		part21.render(f5);
		part22.render(f5);
		part23.render(f5);
		part24.render(f5);		
		part25.render(f5);		
		part26.render(f5);
		part27.render(f5);
		part29.render(f5);
		part30.render(f5);
		part31.render(f5);
		part32.render(f5);
		part33.render(f5);
		part34.render(f5);		
		part35.render(f5);
		part36.render(f5);
		part37.render(f5);
		part38.render(f5);
		part39.render(f5);
		part40.render(f5);
		part41.render(f5);
		part42.render(f5);
		
		
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	 public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
	  {
	      this.eye.rotateAngleY = var4 / (310F / (float)Math.PI);
	      
	      this.part1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 0.7F * var2;
	      this.part9.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 0.7F * var2;
	      this.part10.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 0.7F * var2;
	      
	      this.part2.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 0.7F * var2;
	      this.part11.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 0.7F * var2;
	      this.part12.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 0.7F * var2;
	      

	      this.part3.rotateAngleY = 0.0F;
	      this.part5.rotateAngleY = 0.0F;
	      this.part6.rotateAngleY = 0.0F;
	      
	      this.part4.rotateAngleY = 0.0F;
	      this.part7.rotateAngleY = 0.0F;
	      this.part8.rotateAngleY = 0.0F;
	  }
}
