package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class SculkedMonitorModel extends ModelBase
{
	ModelRenderer Head;
	ModelRenderer Body;
	ModelRenderer Shape3;
	ModelRenderer Shape2;
	ModelRenderer Shape1;
	ModelRenderer Shape4;
	ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg1;
    ModelRenderer Leg4;
    ModelRenderer OnTopOfBody;
    ModelRenderer OnTopOfHead;
    ModelRenderer Tongue;
    
    public SculkedMonitorModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Head = new ModelRenderer((ModelBase)this, 37, 22)).addBox(0.5f, 0.0f, 0.0f, 5, 4, 6);
        this.Head.setRotationPoint(-3.0f, 16.0f, -13.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0f, -3.0f, -3.0f, 8, 4, 18);
        this.Body.setRotationPoint(-1.0f, 20.0f, -5.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 6);
        this.Shape3.setRotationPoint(-1.0f, 15.0f, 19.0f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 1.052361f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 10);
        this.Shape2.setRotationPoint(-1.5f, 18.0f, 11.0f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.5098633f, 0.0f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 4, 4);
        this.Shape1.setRotationPoint(-3.0f, 17.0f, 10.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, -0.0872665f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Shape4.setRotationPoint(-0.5f, 10.66667f, 22.4f);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 1.572862f, 0.0f, 0.0f);
        (this.Leg2 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 12, 2, 2);
        this.Leg2.setRotationPoint(4.0f, 19.0f, 8.0f);
        this.Leg2.setTextureSize(64, 32);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0f, -0.1745329f, 0.3490659f);
        (this.Leg3 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-11.0f, -1.0f, -1.0f, 12, 2, 2);
        this.Leg3.setRotationPoint(-4.0f, 19.0f, -6.0f);
        this.Leg3.setTextureSize(64, 32);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, 0.0f, -0.1745329f, -0.3490659f);
        (this.Leg1 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-11.0f, -1.0f, -1.0f, 12, 2, 2);
        this.Leg1.setRotationPoint(-4.0f, 19.0f, 8.0f);
        this.Leg1.setTextureSize(64, 32);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0f, 0.1745329f, -0.3490659f);
        (this.Leg4 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 12, 2, 2);
        this.Leg4.setRotationPoint(4.0f, 19.0f, -6.0f);
        this.Leg4.setTextureSize(64, 32);
        this.Leg4.mirror = true;
        this.setRotation(this.Leg4, 0.0f, 0.1745329f, 0.3490659f);
        (this.OnTopOfBody = new ModelRenderer((ModelBase)this, 0, 17)).addBox(0.0f, 0.0f, 0.0f, 0, 1, 13);
        this.OnTopOfBody.setRotationPoint(0.0f, 16.0f, -5.0f);
        this.OnTopOfBody.setTextureSize(64, 32);
        this.OnTopOfBody.mirror = true;
        this.setRotation(this.OnTopOfBody, 0.0f, 0.0f, 0.0f);
        (this.OnTopOfHead = new ModelRenderer((ModelBase)this, 0, 25)).addBox(0.0f, 0.0f, 0.0f, 0, 2, 4);
        this.OnTopOfHead.setRotationPoint(0.0f, 15.0f, -12.0f);
        this.OnTopOfHead.setTextureSize(64, 32);
        this.OnTopOfHead.mirror = true;
        this.setRotation(this.OnTopOfHead, 0.1858931f, 0.0f, 0.0f);
        (this.Tongue = new ModelRenderer((ModelBase)this, 0, 26)).addBox(-0.5f, 0.0f, 1.0f, 1, 0, 3);
        this.Tongue.setRotationPoint(0.0f, 19.0f, -16.0f);
        this.Tongue.setTextureSize(64, 32);
        this.Tongue.mirror = true;
        this.setRotation(this.Tongue, 0.2617994f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.render(f5);
        this.Body.render(f5);
        this.Shape3.render(f5);
        this.Shape2.render(f5);
        this.Shape1.render(f5);
        this.Shape4.render(f5);
        this.Leg2.render(f5);
        this.Leg3.render(f5);
        this.Leg1.render(f5);
        this.Leg4.render(f5);
        this.OnTopOfBody.render(f5);
        this.OnTopOfHead.render(f5);
        this.Tongue.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x; //f
        model.rotateAngleY = y; //g
        model.rotateAngleZ = z; //h
    }
    
    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        //this.Head.rotateAngleY = p_78087_4_ / (180F / (float)Math.PI);
        //this.Head.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
        
        this.Head.rotateAngleX = p_78087_5_ * 0.017453292f;
        this.Head.rotateAngleY = p_78087_4_ * 0.001453292f;
        this.OnTopOfHead.rotateAngleX = p_78087_5_ * 0.017453292f;
        this.OnTopOfHead.rotateAngleY = p_78087_4_ * 0.001453292f;
        this.Tongue.rotateAngleX = p_78087_5_ * 0.017453292f;
        this.Tongue.rotateAngleY = p_78087_4_ * 0.001453292f;
        
        float f6 = ((float)Math.PI / 4F);
        this.Leg1.rotateAngleZ = -f6;
        this.Leg2.rotateAngleZ = f6;
        this.Leg3.rotateAngleZ = -f6 * 0.74F;
        this.Leg4.rotateAngleZ = f6 * 0.74F;

        float f7 = -0.0F;
        float f8 = 0.3926991F;
        this.Leg1.rotateAngleY = f8 * 2.0F + f7;
        this.Leg2.rotateAngleY = -f8 * 2.0F - f7;
        this.Leg3.rotateAngleY = f8 * 1.0F + f7;
        this.Leg4.rotateAngleY = -f8 * 1.0F - f7;

        float f9 = -(MathHelper.cos(p_78087_1_ * 0.6662F * 2.0F + 0.0F) * 0.4F) * p_78087_2_;
        float f10 = -(MathHelper.cos(p_78087_1_ * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * p_78087_2_;
        float f11 = -(MathHelper.cos(p_78087_1_ * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * p_78087_2_;
        float f12 = -(MathHelper.cos(p_78087_1_ * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * p_78087_2_;
        float f13 = Math.abs(MathHelper.sin(p_78087_1_ * 0.6662F + 0.0F) * 0.4F) * p_78087_2_;
        float f14 = Math.abs(MathHelper.sin(p_78087_1_ * 0.6662F + (float)Math.PI) * 0.4F) * p_78087_2_;
        float f15 = Math.abs(MathHelper.sin(p_78087_1_ * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * p_78087_2_;
        float f16 = Math.abs(MathHelper.sin(p_78087_1_ * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * p_78087_2_;
        this.Leg1.rotateAngleY += f9;
        this.Leg2.rotateAngleY += -f9;
        this.Leg3.rotateAngleY += f10;
        this.Leg4.rotateAngleY += -f10;

        this.Leg1.rotateAngleZ += f13;
        this.Leg2.rotateAngleZ += -f13;
        this.Leg3.rotateAngleZ += f14;
        this.Leg4.rotateAngleZ += -f14;

    }
    
}    
