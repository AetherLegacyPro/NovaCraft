package com.NovaCraft.entity.models;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;

public class DestituteTentacleModel extends ModelBase
{
    ModelRenderer Tail1; //middle cube
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Tail4;
    ModelRenderer Tail5; //top cube
    ModelRenderer Tail6; //bottom cube
    
    public DestituteTentacleModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Tail1 = new ModelRenderer((ModelBase)this, 50, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2); //2 2 2
        this.Tail1.setRotationPoint(-1.0f, 9.0f, 0.0f);
        this.Tail1.setTextureSize(128, 64);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase)this, 39, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2);
        this.Tail2.setRotationPoint(-1.0f, 10.0f, 2.0f);
        this.Tail2.setTextureSize(128, 64);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase)this, 0, 46)).addBox(-0.5f, -0.5f, -2.0f, 1, 1, 4);
        this.Tail3.setRotationPoint(0.0f, 10.0f, -1.0f);
        this.Tail3.setTextureSize(128, 64);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 0.1673038f, 0.0f, 0.0f);
        (this.Tail4 = new ModelRenderer((ModelBase)this, 71, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2);
        this.Tail4.setRotationPoint(-1.0f, 11.0f, 3.0f);
        this.Tail4.setTextureSize(128, 64);
        this.Tail4.mirror = true;
        this.setRotation(this.Tail4, 0.0f, 0.0f, 0.0f);
        (this.Tail5 = new ModelRenderer((ModelBase)this, 0, 37)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 2); //2 2 2
        this.Tail5.setRotationPoint(-1.0f, 12.0f, 4.0f);
        this.Tail5.setTextureSize(128, 64);;
        this.Tail5.mirror = true;
        this.setRotation(this.Tail5, 0.0f, 0.0f, 0.0f);
        (this.Tail6 = new ModelRenderer((ModelBase)this, 0, 29)).addBox(0.0f, -6.0f, 0.0f, 2, 1, 2); //2 2 2
        this.Tail6.setRotationPoint(-1.0f, 20.0f, 5.0f);
        this.Tail6.setTextureSize(128, 64);
        this.Tail6.mirror = true;
        this.setRotation(this.Tail6, 0.0371786f, 0.0f, 0.0f);
    }
    
    public void render(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
    	this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        GL11.glTranslatef(0, 0.625f, 0);
        this.Tail1.render(par7);
        this.Tail2.render(par7);
        this.Tail3.render(par7);
        this.Tail4.render(par7);
        this.Tail5.render(par7);
        this.Tail6.render(par7);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entityIn) {       
                           
        final float tailVal = limbSwing * 0.1f + ageInTicks * 0.06f;
        final float tailSway = MathHelper.cos(tailVal) / 3.0f;
        final float tailSwaySin = MathHelper.sin(tailVal) / 3.0f;
        this.Tail1.rotateAngleY = tailSway;
        this.Tail2.rotateAngleY = tailSwaySin;
        this.Tail3.rotateAngleY = tailSway;
        this.Tail4.rotateAngleY = tailSwaySin;
        this.Tail6.rotateAngleY = tailSway;
        final float tailBase = -0.08726646f;
        final float tail4Base = 0.17453292f;
        final float tailSwing = MathHelper.cos(limbSwing * 0.6662f) * 0.05f * limbSwingAmount;
        this.Tail1.rotateAngleX = tailBase + tailSwing;
        this.Tail2.rotateAngleX = tailBase + tailSwing;
        this.Tail3.rotateAngleX = tailBase + tailSwing;
        this.Tail4.rotateAngleX = tail4Base + tailSwing;
        this.Tail5.rotateAngleX = tail4Base + tailSwing;
    }
}
