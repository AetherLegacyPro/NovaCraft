package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PrisonerModelNew extends ModelBase {
	
	private final ModelRenderer portal;
	private final ModelRenderer eye;
	private final ModelRenderer tentacle_1;
	private final ModelRenderer tentacle_2;
	private final ModelRenderer tentacle_3;
	private final ModelRenderer tentacle_4;
	private final ModelRenderer tentacle_5;
	private final ModelRenderer tentacle_6;
	private final ModelRenderer tentacle_7;
	private final ModelRenderer tentacle_8;
	private final ModelRenderer tentacle_9;
	private final ModelRenderer tentacle_10;

	public PrisonerModelNew() {
		textureWidth = 128;
		textureHeight = 128;
		
		(this.portal = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 24.0F, 0.0F);
        this.portal.addBox(0.0F, -16.0F, -16.0F, 1, 16, 32, 0.0f);
        this.setRotationAngle(this.portal, 0.0f, 0.0f, 0.0f);
        
        (this.eye = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 24.0F, 0.0F);
        this.eye.addBox(1.0F, -15.0F, -3.0F, 2, 7, 7, 0.0F);
        this.setRotationAngle(this.eye, 0.0f, 0.0f, 0.0f);
        
        (this.tentacle_1 = new ModelRenderer((ModelBase)this, 6, 59)).setRotationPoint(0.0f, 24.0F, 0.0F);
        this.tentacle_1.addBox(5.0F, -14.0F, 9.0F, 5, 2, 2, 0.0F);
        this.setRotationAngle(this.tentacle_1, 0.0f, 0.0f, 0.0f);
        
        (this.tentacle_2 = new ModelRenderer((ModelBase)this, 28, 58)).setRotationPoint(5.0F, -7.0F, 12.0F);
        this.tentacle_2.addBox(-4.0F, -3.0F, -1.0F, 5, 3, 3, 0.0F);
        this.setRotationAngle(this.tentacle_2, 0.0F, 0.0F, 0.0873F);
        this.portal.addChild(this.tentacle_2);
        
        (this.tentacle_3 = new ModelRenderer((ModelBase)this, 24, 61)).setRotationPoint(4.0F, -1.0F, -8.0F);
        this.tentacle_3.addBox(-3.0F, -3.0F, -1.0F, 4, 3, 3, 0.0F);
        this.setRotationAngle(this.tentacle_3, 0.0F, 0.0F, -0.0873F);
        this.portal.addChild(this.tentacle_3);
        
        (this.tentacle_4 = new ModelRenderer((ModelBase)this, 24, 62)).setRotationPoint(8.0F, -8.0F, -5.0F);
        this.tentacle_4.addBox(-2.0F, -2.0F, -1.0F, 3, 2, 2, 0.0F);
        this.setRotationAngle(this.tentacle_4, 0.2182F, 0.0F, -0.1309F);
        this.portal.addChild(this.tentacle_4);
        
        (this.tentacle_5 = new ModelRenderer((ModelBase)this, 41, 55)).setRotationPoint(5.0F, -6.0F, -6.0F);
        this.tentacle_5.addBox(-4.0F, -4.0F, -1.0F, 5, 4, 4, 0.0F);
        this.setRotationAngle(this.tentacle_5, 0.2182F, 0.0F, -0.1309F);
        this.portal.addChild(this.tentacle_5);
        
        (this.tentacle_6 = new ModelRenderer((ModelBase)this, 24, 54)).setRotationPoint(6.0F, -4.0F, -13.0F);
        this.tentacle_6.addBox(-5.0F, -3.0F, -1.0F, 6, 3, 3, 0.0F);
        this.setRotationAngle(this.tentacle_6, 0.0F, 0.0F, -0.0873F);
        this.portal.addChild(this.tentacle_6);
        
        (this.tentacle_7 = new ModelRenderer((ModelBase)this, 2, 59)).setRotationPoint(9.0F, -4.0F, 4.0F);
        this.tentacle_7.addBox(-9.0F, -3.0F, -1.0F, 10, 3, 3, 0.0F);
        this.setRotationAngle(this.tentacle_7, 0.0F, 0.0F, 0.1745F);
        this.portal.addChild(this.tentacle_7);
        
        (this.tentacle_8 = new ModelRenderer((ModelBase)this, 48, 59)).setRotationPoint(4.0F, -11.0F, 9.0F);
        this.tentacle_8.addBox(-3.0F, -4.0F, -1.0F, 4, 4, 4, 0.0F);
        this.setRotationAngle(this.tentacle_8, 0.0F, 0.0F, -0.0436F);
        this.portal.addChild(this.tentacle_8);
        
        (this.tentacle_9 = new ModelRenderer((ModelBase)this, 29, 58)).setRotationPoint(5.0F, -2.0F, 9.0F);
        this.tentacle_9.addBox(-5.0F, -3.0F, -1.0F, 6, 3, 3, 0.0F);
        this.setRotationAngle(this.tentacle_9, -0.1309F, 0.0F, 0.1309F);
        this.portal.addChild(this.tentacle_9);
        
        (this.tentacle_10 = new ModelRenderer((ModelBase)this, 7, 58)).setRotationPoint(8.0F, -9.0F, -11.0F);
        this.tentacle_10.addBox(-7.0F, -3.0F, -1.0F, 8, 3, 3, 0.0F);
        this.setRotationAngle(this.tentacle_10, -0.2182F, 0.0F, 0.0F);
        this.portal.addChild(this.tentacle_10);
        
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		portal.render(f5);
		eye.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}

