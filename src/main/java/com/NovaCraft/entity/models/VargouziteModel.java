package com.NovaCraft.entity.models;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class VargouziteModel extends ModelBase
{
	private final ModelRenderer neck;
	private final ModelRenderer head_top;
	private final ModelRenderer head_bottom;
	private final ModelRenderer crest;
	
	private final ModelRenderer rightteeth_bottom;
	private final ModelRenderer leftteeth_bottom;
	private final ModelRenderer rightteeth_top;
	private final ModelRenderer leftteeth_top;

	public VargouziteModel() {
		textureWidth = 128;
		textureHeight = 128;
        
        (this.neck = new ModelRenderer((ModelBase)this, 96, 66)).setRotationPoint(4.0f, -4.0f, -10.0f); 
        this.neck.addBox(-9.0F, -11.0F, -1.0F, 10, 11, 6, 0.0f);
        this.setRotationAngle(this.neck, 0.0873F, 0.0f, 0.0f);
        
        (this.head_top = new ModelRenderer((ModelBase)this, 59, 66)).setRotationPoint(-1.0f, -7.0f, -9.5f);
        this.head_top.addBox(-7.0F, -5.0F, -1.0F, 8, 5, 10, 0.0f);
        this.setRotationAngle(this.head_top, 0.0873F, 0.0f, 0.0f); 
        this.neck.addChild(this.head_top);
        
        (this.crest = new ModelRenderer((ModelBase)this, 99, 86)).setRotationPoint(0.0f, -11.0f, 0.0f);
        this.crest.addBox(-9.0F, -3.0F, -1.0F, 10, 3, 4, 0.0f);
        this.neck.addChild(this.crest);
        
        (this.head_bottom = new ModelRenderer((ModelBase)this, 60, 84)).setRotationPoint(-2.0f, -2.0f, -1.5f); 
        this.head_bottom.addBox(-5.0F, -2.0F, -9.0F, 6, 2, 10, 0.0f);
        this.setRotationAngle(this.head_bottom, 0.0945F, 0.0f, 0.0f);
        this.neck.addChild(this.head_bottom);
                
        (this.rightteeth_bottom = new ModelRenderer((ModelBase)this, 61, 94)).setRotationPoint(-2.0f, 4.0f, 12.0f); 
        this.rightteeth_bottom.addBox(-2.0F, -7.0F, -19.0F, 0, 2, 7, 0.0f); 
        this.head_bottom.addChild(this.rightteeth_bottom);
        
        (this.leftteeth_bottom = new ModelRenderer((ModelBase)this, 61, 94)).setRotationPoint(2.0f, 4.0f, 12.0f); 
        this.leftteeth_bottom.addBox(-2.0F, -7.0F, -19.0F, 0, 2, 7, 0.0f); 
        this.head_bottom.addChild(this.leftteeth_bottom);
        
        (this.rightteeth_top = new ModelRenderer((ModelBase)this, 61, 94)).setRotationPoint(-3.0f, 6.0f, 20.0f); 
        this.rightteeth_top.addBox(-2.0F, -7.0F, -19.0F, 0, 2, 7, 0.0f);
        this.head_top.addChild(this.rightteeth_top);
        
        (this.leftteeth_top = new ModelRenderer((ModelBase)this, 61, 94)).setRotationPoint(1.0f, 6.0f, 20.0f); 
        this.leftteeth_top.addBox(-2.0F, -7.0F, -19.0F, 0, 2, 7, 0.0f);
        this.head_top.addChild(this.leftteeth_top);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    	super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	this.neck.render(f5);   
    }
    
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
    
    @Override
    public void setRotationAngles(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        
        final float jawLower = MathHelper.cos(ageInTicks * 0.025f) / 5.0f;
        this.head_bottom.rotateAngleX = 0.34906584f - jawLower;
    }
}

