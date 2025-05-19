package com.NovaCraft.entity.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class BlazingSerpentModel extends ModelBase
{
	ModelRenderer Head1;
    ModelRenderer Teeth1;
    ModelRenderer Head2;
    ModelRenderer Teeth2;
    ModelRenderer Head3;
    ModelRenderer Head4;
    ModelRenderer Head5;
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Body4;
    ModelRenderer Body5;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Fin1;
    ModelRenderer Fin2;
    ModelRenderer Fin3;
    ModelRenderer Fin4;
    ModelRenderer Upperfin1;
    ModelRenderer Upperfin2;
    ModelRenderer Upperfin3;
    ModelRenderer Upperfin4;
    ModelRenderer Upperfin5;
    
    public BlazingSerpentModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Head1 = new ModelRenderer((ModelBase)this, 0, 30)).addBox(-3.0f, -5.0f, -9.0f, 6, 5, 9);
        this.Head1.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Head1.setTextureSize(128, 64);
        this.Head1.mirror = true;
        this.setRotation(this.Head1, 0.1919862f, 0.0f, 0.0f);      
        (this.Teeth1 = new ModelRenderer((ModelBase)this, 30, 34)).addBox(-3.0f, 0.0f, -9.0f, 6, 1, 7);
        this.Teeth1.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Teeth1.setTextureSize(128, 64);
        this.Teeth1.mirror = true;
        this.setRotation(this.Teeth1, 0.1919862f, 0.0f, 0.0f);
        (this.Head2 = new ModelRenderer((ModelBase)this, 0, 21)).addBox(-3.0f, 0.0f, -7.0f, 6, 2, 7);
        this.Head2.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Head2.setTextureSize(128, 64);
        this.Head2.mirror = true;
        this.setRotation(this.Head2, 0.6632251f, 0.0f, 0.0f);
        (this.Teeth2 = new ModelRenderer((ModelBase)this, 26, 21)).addBox(-3.0f, -1.0f, -7.0f, 6, 1, 5);
        this.Teeth2.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Teeth2.setTextureSize(128, 64);
        this.Teeth2.mirror = true;
        this.setRotation(this.Teeth2, 0.6632251f, 0.0f, 0.0f);
        (this.Head3 = new ModelRenderer((ModelBase)this, 36, 13)).addBox(-1.0f, 0.0f, 0.0f, 2, 1, 5);
        this.Head3.setRotationPoint(2.0f, 17.0f, -25.0f);
        this.Head3.setTextureSize(128, 64);
        this.Head3.mirror = true;
        this.setRotation(this.Head3, 0.3316126f, 0.5934119f, 1.029744f);
        (this.Head4 = new ModelRenderer((ModelBase)this, 36, 13)).addBox(-1.0f, 0.0f, 0.0f, 2, 1, 5);
        this.Head4.setRotationPoint(-2.0f, 17.0f, -25.0f);
        this.Head4.setTextureSize(128, 64);
        this.Head4.mirror = true;
        this.setRotation(this.Head4, 0.3316126f, -0.5934119f, -1.029744f);
        (this.Head5 = new ModelRenderer((ModelBase)this, 0, 45)).addBox(-3.0f, 0.0f, 0.0f, 6, 1, 16);
        this.Head5.setRotationPoint(0.0f, 15.0f, -33.0f);
        this.Head5.setTextureSize(128, 64);
        this.Head5.mirror = true;
        this.setRotation(this.Head5, 0.1919862f, 0.0f, 0.0f);
        (this.Body1 = new ModelRenderer((ModelBase)this, 45, 45)).addBox(-3.0f, -2.0f, 0.0f, 6, 4, 10);
        this.Body1.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Body1.setTextureSize(128, 64);
        this.Body1.mirror = true;
        this.setRotation(this.Body1, 0.0f, 0.0f, 0.0f);
        (this.Body2 = new ModelRenderer((ModelBase)this, 45, 45)).addBox(-3.0f, -2.0f, 10.0f, 6, 4, 10);
        this.Body2.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Body2.setTextureSize(128, 64);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, 0.0f, 0.0f, 0.0f);
        (this.Body3 = new ModelRenderer((ModelBase)this, 45, 45)).addBox(-3.0f, -2.0f, 20.0f, 6, 4, 10);
        this.Body3.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Body3.setTextureSize(128, 64);
        this.Body3.mirror = true;
        this.setRotation(this.Body3, 0.0f, 0.0f, 0.0f);
        (this.Body4 = new ModelRenderer((ModelBase)this, 45, 45)).addBox(-3.0f, -2.0f, 30.0f, 6, 4, 10);
        this.Body4.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Body4.setTextureSize(128, 64);
        this.Body4.mirror = true;
        this.setRotation(this.Body4, 0.0f, 0.0f, 0.0f);
        (this.Body5 = new ModelRenderer((ModelBase)this, 45, 45)).addBox(-3.0f, -2.0f, 40.0f, 6, 4, 10);
        this.Body5.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Body5.setTextureSize(128, 64);
        this.Body5.mirror = true;
        this.setRotation(this.Body5, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase)this, 44, 7)).addBox(-23.0f, 0.0f, 39.0f, 4, 1, 12);
        this.Tail1.setRotationPoint(2.0f, 19.0f, -24.0f);
        this.Tail1.setTextureSize(128, 64);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.0f, 0.4886922f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase)this, 44, 7)).addBox(19.0f, 0.0f, 39.0f, 4, 1, 12);
        this.Tail2.setRotationPoint(-2.0f, 19.0f, -24.0f);
        this.Tail2.setTextureSize(128, 64);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, -0.4886922f, 0.0f);
        (this.Fin1 = new ModelRenderer((ModelBase)this, 14, 9)).addBox(4.0f, 0.0f, 11.0f, 4, 1, 10);
        this.Fin1.setRotationPoint(-2.0f, 19.0f, -24.0f);
        this.Fin1.setTextureSize(128, 64);
        this.Fin1.mirror = true;
        this.setRotation(this.Fin1, 0.0f, -0.4886922f, 0.0f);
        (this.Fin2 = new ModelRenderer((ModelBase)this, 14, 9)).addBox(-8.0f, 0.0f, 11.0f, 4, 1, 10);
        this.Fin2.setRotationPoint(2.0f, 19.0f, -24.0f);
        this.Fin2.setTextureSize(128, 64);
        this.Fin2.mirror = true;
        this.setRotation(this.Fin2, 0.0f, 0.4886922f, 0.0f);
        (this.Fin3 = new ModelRenderer((ModelBase)this, 14, 9)).addBox(-15.0f, 0.0f, 29.0f, 4, 1, 10);
        this.Fin3.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Fin3.setTextureSize(128, 64);
        this.Fin3.mirror = true;
        this.setRotation(this.Fin3, 0.0f, 0.4886922f, 0.0f);
        (this.Fin4 = new ModelRenderer((ModelBase)this, 14, 9)).addBox(11.0f, 0.0f, 29.0f, 4, 1, 10);
        this.Fin4.setRotationPoint(0.0f, 19.0f, -24.0f);
        this.Fin4.setTextureSize(128, 64);
        this.Fin4.mirror = true;
        this.setRotation(this.Fin4, 0.0f, -0.4886922f, 0.0f);
        (this.Upperfin1 = new ModelRenderer((ModelBase)this, 0, 11)).addBox(0.0f, -4.0f, 2.0f, 1, 3, 6);
        this.Upperfin1.setRotationPoint(-0.5f, 19.0f, -24.0f);
        this.Upperfin1.setTextureSize(128, 64);
        this.Upperfin1.mirror = true;
        this.setRotation(this.Upperfin1, 0.0f, 0.0f, 0.0f);
        (this.Upperfin2 = new ModelRenderer((ModelBase)this, 0, 11)).addBox(0.0f, -4.0f, 12.0f, 1, 3, 6);
        this.Upperfin2.setRotationPoint(-0.5f, 19.0f, -24.0f);
        this.Upperfin2.setTextureSize(128, 64);
        this.Upperfin2.mirror = true;
        this.setRotation(this.Upperfin2, 0.0f, 0.0f, 0.0f);
        (this.Upperfin3 = new ModelRenderer((ModelBase)this, 0, 11)).addBox(0.0f, -4.0f, 22.0f, 1, 3, 6);
        this.Upperfin3.setRotationPoint(-0.5f, 19.0f, -24.0f);
        this.Upperfin3.setTextureSize(128, 64);
        this.Upperfin3.mirror = true;
        this.setRotation(this.Upperfin3, 0.0f, 0.0f, 0.0f);
        (this.Upperfin4 = new ModelRenderer((ModelBase)this, 0, 11)).addBox(0.0f, -4.0f, 32.0f, 1, 3, 6);
        this.Upperfin4.setRotationPoint(-0.5f, 19.0f, -24.0f);
        this.Upperfin4.setTextureSize(128, 64);
        this.Upperfin4.mirror = true;
        this.setRotation(this.Upperfin4, 0.0f, 0.0f, 0.0f);
        (this.Upperfin5 = new ModelRenderer((ModelBase)this, 0, 11)).addBox(0.0f, -4.0f, 42.0f, 1, 3, 6);
        this.Upperfin5.setRotationPoint(-0.5f, 19.0f, -24.0f);
        this.Upperfin5.setTextureSize(128, 64);
        this.Upperfin5.mirror = true;
        this.setRotation(this.Upperfin5, 0.0f, 0.0f, 0.0f);
        
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head1.render(f5);
        this.Teeth1.render(f5);
        this.Head2.render(f5);
        this.Teeth2.render(f5);
        this.Head3.render(f5);
        this.Head4.render(f5);
        this.Body1.render(f5);
        this.Body2.render(f5);
        this.Body3.render(f5);
        this.Body4.render(f5);
        this.Body5.render(f5);
        this.Upperfin1.render(f5);
        this.Upperfin2.render(f5);
        this.Upperfin3.render(f5);
        this.Upperfin4.render(f5);
        this.Upperfin5.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        
        this.Head1.rotateAngleX = headPitch * 0.017453292f;
        this.Head1.rotateAngleY = netHeadYaw * 0.017453292f;
        this.Head2.rotateAngleX = headPitch * 0.017453292f;
        this.Head2.rotateAngleY = netHeadYaw * 0.017453292f;
        this.Head3.rotateAngleX = headPitch * 0.017453292f;
        this.Head3.rotateAngleY = netHeadYaw * 0.017453292f;
        this.Head4.rotateAngleX = headPitch * 0.017453292f;
        this.Head4.rotateAngleY = netHeadYaw * 0.017453292f;
        this.Teeth1.rotateAngleX = headPitch * 0.017453292f;
        this.Teeth1.rotateAngleY = netHeadYaw * 0.017453292f;
        this.Teeth2.rotateAngleX = headPitch * 0.017453292f;
        this.Teeth2.rotateAngleY = netHeadYaw * 0.017453292f;
        
        
        final float jawLower = MathHelper.cos(ageInTicks * 0.1f) / 5.0f;
        this.Head2.rotateAngleX = 0.34906584f - jawLower;
        this.Teeth2.rotateAngleX = 0.34906584f - jawLower;
        
        final float tailVal = limbSwing * 0.3f + ageInTicks * 0.06f;
        final float tailSway1 = MathHelper.cos(tailVal) / 9.0f;
        final float tailSwaySin1 = MathHelper.sin(tailVal) / 8.0f;
        final float tailSway2 = MathHelper.sin(tailVal) / 7.0f;
        final float tailSwaySin2 = MathHelper.sin(tailVal) / 6.0f;
        final float tailSway3 = MathHelper.sin(tailVal) / 5.0f;               
        
        this.Fin1.rotateAngleY = tailSwaySin1;
        this.Fin2.rotateAngleY = tailSwaySin1;      
        
        this.Body1.rotateAngleY = tailSway1;
        this.Body2.rotateAngleY = tailSwaySin1;
        this.Body3.rotateAngleY = tailSway2;
        this.Body4.rotateAngleY = tailSwaySin2;
        this.Body5.rotateAngleY = tailSway3;
        
        this.Upperfin1.rotateAngleY = tailSway1;
        this.Upperfin2.rotateAngleY = tailSwaySin1;
        this.Upperfin3.rotateAngleY = tailSway2;
        this.Upperfin4.rotateAngleY = tailSwaySin2;
        this.Upperfin5.rotateAngleY = tailSway3;           
        
        final float tailBase = -0.08726646f;
        final float tail4Base = 0.17453292f;
        final float tailSwing = MathHelper.cos(limbSwing * 0.6662f) * 0.05f * limbSwingAmount;       
        
        this.Fin1.rotateAngleX = tail4Base + tailSwing;
        this.Fin2.rotateAngleX = tail4Base + tailSwing;
        
        this.Body1.rotateAngleX = tailBase + tailSwing;
        this.Body2.rotateAngleX = tailBase + tailSwing;
        this.Body3.rotateAngleX = tailBase + tailSwing;
        this.Body4.rotateAngleX = tailBase + tailSwing;
        this.Body5.rotateAngleX = tailBase + tailSwing;
        
        this.Upperfin1.rotateAngleX = tailBase + tailSwing;
        this.Upperfin2.rotateAngleX = tailBase + tailSwing;
        this.Upperfin3.rotateAngleX = tailBase + tailSwing;
        this.Upperfin4.rotateAngleX = tailBase + tailSwing;
        this.Upperfin5.rotateAngleX = tailBase + tailSwing;

    }
}
