package com.NovaCraft.entity.models;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;

public class DestituteTentacleModel extends ModelBase
{
    ModelRenderer part1;
    ModelRenderer part2;
    ModelRenderer part3;
    ModelRenderer part4;
    
    public DestituteTentacleModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        
        (this.part1 = new ModelRenderer((ModelBase)this, -16, -8)).addBox(-5.0F, -6.0F, -5.0F, 10, 6, 10);
		this.part1.setTextureSize(64, 64);
		part1.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.part1.mirror = true;
        
        (this.part2 = new ModelRenderer((ModelBase)this, -12, -6)).addBox(-4.0F, -18.0F, -4.0F, 8, 12, 8);
		this.part2.setTextureSize(64, 64);
		part2.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.part2.mirror = true;
        
        (this.part3 = new ModelRenderer((ModelBase)this, -8, -4)).addBox(-3.0F, -26.0F, -3.0F, 6, 8, 6);
		this.part3.setTextureSize(64, 64);
		part3.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.part3.mirror = true;
        
        (this.part4 = new ModelRenderer((ModelBase)this, -9, -7)).addBox(-2.0F, -30.0F, -5.0F, 4, 4, 9); //- - -10
		this.part4.setTextureSize(64, 64);
		part4.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.part4.mirror = true;

    }
    
    public void render(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
    	this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        GL11.glTranslatef(0, 0.425f, 0);
        this.part1.render(par7);
        this.part2.render(par7);
        this.part3.render(par7);
        this.part4.render(par7);
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
        this.part1.rotateAngleY = tailSway;
        this.part2.rotateAngleY = tailSwaySin;
        this.part3.rotateAngleY = tailSway;
        this.part4.rotateAngleY = tailSwaySin;
        final float tailBase = -0.08726646f;
        final float tail4Base = 0.17453292f;
        final float tailSwing = MathHelper.cos(limbSwing * 0.6662f) * 0.05f * limbSwingAmount;
        this.part1.rotateAngleX = tailBase + tailSwing;
        this.part2.rotateAngleX = tailBase + tailSwing;
        this.part3.rotateAngleX = tailBase + tailSwing;
        this.part4.rotateAngleX = tail4Base + tailSwing;
    }
}
