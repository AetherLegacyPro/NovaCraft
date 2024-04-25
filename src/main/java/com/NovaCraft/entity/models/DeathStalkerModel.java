package com.NovaCraft.entity.models;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityDeathStalker;

import net.minecraft.client.model.ModelBase;

public class DeathStalkerModel extends ModelBase
{
    ModelRenderer Head;
    ModelRenderer Bauch;
    ModelRenderer Zange;
    ModelRenderer Zange1;
    ModelRenderer Zange2;
    ModelRenderer Zange3;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Tail4;
    ModelRenderer Tail5;
    ModelRenderer Tail6;
    ModelRenderer RearEnd;
    ModelRenderer armlinks;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer Leg2;
    ModelRenderer Armrechts;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer Leg1;
    
    public DeathStalkerModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Head = new ModelRenderer((ModelBase)this, 32, 4)).addBox(-4.0f, -4.0f, -8.0f, 6, 4, 6);
        this.Head.setRotationPoint(1.0f, 20.0f, -1.0f);
        this.Head.setTextureSize(128, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Bauch = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0f, -3.0f, -3.0f, 6, 4, 6);
        this.Bauch.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Bauch.setTextureSize(128, 64);
        this.Bauch.mirror = true;
        this.setRotation(this.Bauch, 0.0f, 0.0f, 0.0f);
        (this.Zange = new ModelRenderer((ModelBase)this, 60, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 3);
        this.Zange.setRotationPoint(5.0f, 18.0f, -8.0f);
        this.Zange.setTextureSize(128, 64);
        this.Zange.mirror = true;
        this.setRotation(this.Zange, 0.0f, 0.2602503f, 0.0f);
        (this.Zange1 = new ModelRenderer((ModelBase)this, 60, 0)).addBox(0.0f, 0.0f, -0.7f, 1, 2, 3);
        this.Zange1.setRotationPoint(7.0f, 18.0f, -8.0f);
        this.Zange1.setTextureSize(128, 64);
        this.Zange1.mirror = true;
        this.setRotation(this.Zange1, 0.0f, 0.1487144f, 0.0f);
        (this.Zange2 = new ModelRenderer((ModelBase)this, 60, 0)).addBox(-0.5f, -8.0f, 1.0f, 1, 2, 3);
        this.Zange2.setRotationPoint(-5.0f, 26.0f, -9.0f);
        this.Zange2.setTextureSize(128, 64);
        this.Zange2.mirror = true;
        this.setRotation(this.Zange2, 0.0371786f, -0.3164313f, 0.0f);
        (this.Zange3 = new ModelRenderer((ModelBase)this, 60, 0)).addBox(0.0f, 0.0f, -2.0f, 1, 2, 3);
        this.Zange3.setRotationPoint(-8.0f, 18.0f, -7.0f);
        this.Zange3.setTextureSize(128, 64);
        this.Zange3.mirror = true;
        this.setRotation(this.Zange3, 0.0f, -0.2792527f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase)this, 50, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
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
        (this.Tail5 = new ModelRenderer((ModelBase)this, 0, 37)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.Tail5.setRotationPoint(-1.0f, 12.0f, 4.0f);
        this.Tail5.setTextureSize(128, 64);
        this.Tail5.mirror = true;
        this.setRotation(this.Tail5, 0.0f, 0.0f, 0.0f);
        (this.Tail6 = new ModelRenderer((ModelBase)this, 0, 29)).addBox(0.0f, -6.0f, 0.0f, 2, 2, 2);
        this.Tail6.setRotationPoint(-1.0f, 20.0f, 5.0f);
        this.Tail6.setTextureSize(128, 64);
        this.Tail6.mirror = true;
        this.setRotation(this.Tail6, 0.0371786f, 0.0f, 0.0f);
        (this.RearEnd = new ModelRenderer((ModelBase)this, 0, 12)).addBox(-5.0f, -4.0f, -6.0f, 5, 4, 6);
        this.RearEnd.setRotationPoint(2.5f, 20.0f, 9.0f);
        this.RearEnd.setTextureSize(128, 64);
        this.RearEnd.mirror = true;
        this.setRotation(this.RearEnd, 0.0f, 0.0f, 0.0f);
        (this.armlinks = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 7, 2, 2);
        this.armlinks.setRotationPoint(3.0f, 19.0f, -3.0f);
        this.armlinks.setTextureSize(128, 64);
        this.armlinks.mirror = true;
        this.setRotation(this.armlinks, 0.0f, 0.3490659f, 0.0f);
        (this.Leg6 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg6.setRotationPoint(4.0f, 20.0f, 0.0f);
        this.Leg6.setTextureSize(128, 64);
        this.Leg6.mirror = true;
        this.setRotation(this.Leg6, 0.0f, 0.3536099f, 0.4894151f);
        (this.Leg4 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg4.setRotationPoint(4.0f, 20.0f, 1.0f);
        this.Leg4.setTextureSize(128, 64);
        this.Leg4.mirror = true;
        this.setRotation(this.Leg4, 0.0f, -0.2792527f, 0.4894151f);
        (this.Leg2 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg2.setRotationPoint(4.0f, 20.0f, 2.0f);
        this.Leg2.setTextureSize(128, 64);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0f, -0.5759587f, 0.4894151f);
        (this.Armrechts = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-11.0f, -1.0f, -1.0f, 6, 2, 2);
        this.Armrechts.setRotationPoint(2.0f, 19.0f, -2.0f);
        this.Armrechts.setTextureSize(128, 64);
        this.Armrechts.mirror = true;
        this.setRotation(this.Armrechts, 0.0f, -0.2792527f, 0.0f);
        (this.Leg5 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-6.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg5.setRotationPoint(-4.0f, 20.0f, -1.0f);
        this.Leg5.setTextureSize(128, 64);
        this.Leg5.mirror = true;
        this.setRotation(this.Leg5, 0.0f, -0.3536099f, -0.4894151f);
        (this.Leg3 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-6.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg3.setRotationPoint(-4.0f, 20.0f, 0.0f);
        this.Leg3.setTextureSize(128, 64);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, 0.0f, 0.2792527f, -0.4894151f);
        (this.Leg1 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-6.0f, -1.0f, -1.0f, 8, 2, 2);
        this.Leg1.setRotationPoint(-4.0f, 20.0f, 2.0f);
        this.Leg1.setTextureSize(128, 64);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0f, 0.5759587f, -0.5265937f);
    }
    
    public void render(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
    	this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        if(par1Entity instanceof EntityDeathStalker && !((EntityDeathStalker)par1Entity).getProvoked())GL11.glTranslatef(0, 0.625f, 0);
        this.Tail1.render(par7);
        this.Tail2.render(par7);
        this.Tail3.render(par7);
        this.Tail4.render(par7);
        this.Tail5.render(par7);
        this.Tail6.render(par7);
        this.Head.render(par7);
        this.Bauch.render(par7);
        this.Zange.render(par7);
        this.Zange1.render(par7);
        this.Zange2.render(par7);
        this.Zange3.render(par7);        
        this.RearEnd.render(par7);
        this.armlinks.render(par7);
        this.Leg6.render(par7);
        this.Leg4.render(par7);
        this.Leg2.render(par7);
        this.Armrechts.render(par7);
        this.Leg5.render(par7);
        this.Leg3.render(par7);
        this.Leg1.render(par7);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entityIn) {       
        this.Head.rotateAngleX = headPitch * 0.017453292f;
        this.Head.rotateAngleY = netHeadYaw * 0.001453292f;
        
        
        this.armlinks.rotateAngleX = -0.7853982F + (MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount);
        this.armlinks.rotateAngleX = -1.570796F + (MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount);
        this.Armrechts.rotateAngleX = -0.7853982F + (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount);
        this.Armrechts.rotateAngleX = -1.570796F + (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount);
        
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

        float f9 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f10 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f11 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f12 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        float f13 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f14 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f15 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f16 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        this.Leg1.rotateAngleY += f9;
        this.Leg2.rotateAngleY += -f9;
        this.Leg3.rotateAngleY += f10;
        this.Leg4.rotateAngleY += -f10;

        this.Leg1.rotateAngleZ += f13;
        this.Leg2.rotateAngleZ += -f13;
        this.Leg3.rotateAngleZ += f14;
        this.Leg4.rotateAngleZ += -f14;
            
               
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
