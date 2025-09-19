package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class OutsiderEyeModel extends ModelBase
{	
	ModelRenderer eye;

	public OutsiderEyeModel() {
		textureWidth = 64;
		textureHeight = 32;

        (this.eye = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0F, -29.0F, -3.0F, 6, 6, 6);
     	this.eye.setTextureSize(64, 32);
     	eye.setRotationPoint(0.0F, 30.0F, 0.0F);
     	setRotationAngle(eye, 0.0F, -1.5708F, 0.0F);
        this.eye.mirror = true;
       
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
		super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
		
		eye.render(f5);
			
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	 public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
	  {
	      this.eye.rotateAngleY = var4 / (310F / (float)Math.PI);
	      
	  }
}
