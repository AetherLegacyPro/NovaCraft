package com.NovaCraft.entity.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class EnderLordModel extends ModelBiped
{
	 //Credit goes to the Legendary Beasts Mod Author for the base model
    public EnderLordModel()
    {
    	this.textureWidth = 128;
        this.textureHeight = 64;
        float f = -14.0F;
        float f1 = 0.0F;
        
        this.bipedHeadwear = new ModelRenderer(this, 0, 0).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.bipedHeadwear.setRotationPoint(0.0f, -23.0f, 0.0f);
        this.bipedHeadwear.setTextureSize(128, 64);
        this.bipedHeadwear.mirror = true;
        this.setRotation(this.bipedHeadwear, 0.2617994f, 0.0f, 0.0f);
        this.bipedHeadwear.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8); 
        this.bipedHeadwear.setRotationPoint(0.0f, -23.0f, 0.0f);
        
        this.bipedBody = new ModelRenderer(this, 57, 41).addBox(-4.0f, 0.0f, -2.0f, 10, 16, 6);
        this.bipedBody.setRotationPoint(-1.0f, -23.0f, -1.0f);
        this.bipedBody.setTextureSize(128, 64);
        this.bipedBody.mirror = true;
        this.setRotation(this.bipedBody, 0.0f, 0.0f, 0.0f);    
        
        this.bipedRightArm = new ModelRenderer(this, 56, 0);
        this.bipedRightArm.addBox(-1.0F, -2.0F, -1.0F, 3, 30, 3, f1);
        this.bipedRightArm.setRotationPoint(-3.0F, 2.0F + f, 0.0F);
        
        this.bipedLeftArm = new ModelRenderer(this, 56, 0);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -1.0F, 3, 30, 3, f1);
        this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + f, 0.0F);
        
        (this.bipedRightLeg = new ModelRenderer(this, 56, 0)).addBox(-1.0f, 0.0f, -1.0f, 3, 35, 3);
        this.bipedRightLeg.setRotationPoint(-3.0f, -7.0f, 0.0f);
        this.bipedRightLeg.setTextureSize(128, 64);
        this.bipedRightLeg.mirror = true;
        this.setRotation(this.bipedRightLeg, 0.0f, 0.0f, 0.0f);          
        
        (this.bipedLeftLeg = new ModelRenderer(this, 56, 0)).addBox(-1.0f, 0.0f, -1.0f, 3, 35, 3);
        this.bipedLeftLeg.setRotationPoint(2.0f, -7.0f, 0.0f);
        this.bipedLeftLeg.setTextureSize(128, 64);
        this.bipedLeftLeg.mirror = true;
        this.setRotation(this.bipedLeftLeg, 0.0f, 0.0f, 0.0f);
        this.bipedLeftLeg.mirror = false;
    }
    
    public void render(final Entity entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        super.render(entity, par2, par3, par4, par5, par6, par7);
        this.setRotationAngles(par7, par2, par3, par4, par5, par6, entity);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
        this.bipedHead.showModel = true;
        float f6 = -14.0F;
        this.bipedBody.rotateAngleX = 0.0F;
        this.bipedBody.rotationPointY = f6;
        this.bipedBody.rotationPointZ = -0.0F;
        this.bipedRightLeg.rotateAngleX -= 0.0F;
        this.bipedLeftLeg.rotateAngleX -= 0.0F;
        this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX * 0.5D);
        this.bipedLeftArm.rotateAngleX = (float)((double)this.bipedLeftArm.rotateAngleX * 0.5D);
        this.bipedRightLeg.rotateAngleX = (float)((double)this.bipedRightLeg.rotateAngleX * 0.5D);
        this.bipedLeftLeg.rotateAngleX = (float)((double)this.bipedLeftLeg.rotateAngleX * 0.5D);
        float f7 = 0.4F;

        if (this.bipedRightArm.rotateAngleX > f7)
        {
            this.bipedRightArm.rotateAngleX = f7;
        }

        if (this.bipedLeftArm.rotateAngleX > f7)
        {
            this.bipedLeftArm.rotateAngleX = f7;
        }

        if (this.bipedRightArm.rotateAngleX < -f7)
        {
            this.bipedRightArm.rotateAngleX = -f7;
        }

        if (this.bipedLeftArm.rotateAngleX < -f7)
        {
            this.bipedLeftArm.rotateAngleX = -f7;
        }

        if (this.bipedRightLeg.rotateAngleX > f7)
        {
            this.bipedRightLeg.rotateAngleX = f7;
        }

        if (this.bipedLeftLeg.rotateAngleX > f7)
        {
            this.bipedLeftLeg.rotateAngleX = f7;
        }

        if (this.bipedRightLeg.rotateAngleX < -f7)
        {
            this.bipedRightLeg.rotateAngleX = -f7;
        }

        if (this.bipedLeftLeg.rotateAngleX < -f7)
        {
            this.bipedLeftLeg.rotateAngleX = -f7;
        }

        this.bipedRightArm.rotationPointZ = 0.0F;
        this.bipedLeftArm.rotationPointZ = 0.0F;
        this.bipedRightLeg.rotationPointZ = 0.0F;
        this.bipedLeftLeg.rotationPointZ = 0.0F;
        this.bipedRightLeg.rotationPointY = 9.0F + f6;
        this.bipedLeftLeg.rotationPointY = 9.0F + f6;
        this.bipedHead.rotationPointZ = -0.0F;
        this.bipedHead.rotationPointY = f6 + 1.0F;
        this.bipedHeadwear.rotationPointX = this.bipedHead.rotationPointX;
        this.bipedHeadwear.rotationPointY = this.bipedHead.rotationPointY;
        this.bipedHeadwear.rotationPointZ = this.bipedHead.rotationPointZ;
        this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear.rotateAngleZ = this.bipedHead.rotateAngleZ;
        
        
    }
}
