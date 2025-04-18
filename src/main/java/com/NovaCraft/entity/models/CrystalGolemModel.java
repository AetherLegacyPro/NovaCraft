package com.NovaCraft.entity.models;

import com.NovaCraft.entity.EntityCrystalGolem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class CrystalGolemModel extends ModelBase {

	public ModelRenderer head;
	public ModelRenderer body;
	public ModelRenderer left_leg;
	public ModelRenderer right_leg;
	public ModelRenderer left_arm;
	public ModelRenderer right_arm;
	public ModelRenderer left_crystal;
	public ModelRenderer right_crystal;
	
	public CrystalGolemModel() {
		textureWidth = 64;
		textureHeight = 64;
		
        (this.head = new ModelRenderer((ModelBase)this, 44, 32)).addBox(-2.0F, -28.0F, -3.0F, 4, 6, 4);
      	this.head.setTextureSize(64, 64);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        
        (this.body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-6.0F, -22.0F, -3.0F, 12, 12, 6);
      	this.body.setTextureSize(64, 64);
      	body.setRotationPoint(0.0F, 24.5F, 0.0F);
      	this.body.addChild(this.head);
        
        (this.right_leg = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-5.0F, 10.0F, -2.0F, 4, 10, 4);
        this.right_leg.setTextureSize(64, 64);
        this.right_leg.setRotationPoint(-0.5F, 3.5F, 0.0F);
        
        (this.left_leg = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-5.0F, 10.0F, -2.0F, 4, 10, 4);
		this.left_leg.setTextureSize(64, 64);
		this.left_leg.setRotationPoint(6.5F, 3.5F, 0.0F);
		
		(this.right_arm = new ModelRenderer((ModelBase)this, 0, 0)).addBox(6.0F, 21.0F, -2.0F, 3, 14, 3);
		this.right_arm.setTextureSize(64, 64);
		this.right_arm.setRotationPoint(0.0F, -18.5F, 0.0F);
		this.setRotation(this.right_arm, 0.2182f, 0.0f, 0.0f);

        (this.left_arm = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-9.0F, 21.0F, -2.0F, 3, 14, 3);
		this.left_arm.setTextureSize(64, 64);
		this.left_arm.setRotationPoint(-0.0F, -18.5F, 0.0F);
		this.setRotation(this.left_arm, 0.2182f, 0.0f, 0.0f);      
		
        (this.left_crystal = new ModelRenderer((ModelBase)this, 16, 48)).addBox(2.0F, -26.0F, 0.0F, 4, 4, 0);
		this.left_crystal.setTextureSize(64, 64);
		this.left_crystal.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addChild(this.left_crystal);
        
        (this.right_crystal = new ModelRenderer((ModelBase)this, 0, 48)).addBox(-6.0F, -25.0F, -1.0F, 4, 3, 0);
		this.right_crystal.setTextureSize(64, 64);
		this.right_crystal.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addChild(this.right_crystal);
	}
	
	public void setRotation(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		body.render(f5);
		right_leg.render(f5);
		left_leg.render(f5);
		right_arm.render(f5);
		left_arm.render(f5);
	}

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity)
    {
    	// Head rotation (looking around)
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F); // Horizontal rotation
        //this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F); // Vertical rotation
        
        // Leg movement (swing back and forth)
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.35F * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.35F * limbSwingAmount;

        // Arm movement (opposite of the legs)
        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount * 0.5F;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount * 0.5F;

        // Slight arm sway (like a zombie)
        this.right_arm.rotateAngleZ = 0.0F;
        this.left_arm.rotateAngleZ = 0.0F;

        // Prevent legs and arms from rotating too far
        this.right_leg.rotateAngleY = 0.0F;
        this.left_leg.rotateAngleY = 0.0F;
        
    }
    
    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntityCrystalGolem entitycrystalgolem = (EntityCrystalGolem)p_78086_1_;
        int i = entitycrystalgolem.getAttackTimer();

        if (i > 0)
        {
            this.right_arm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - p_78086_4_, 2.0F);
            this.left_arm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - p_78086_4_, 2.0F);
        }
        else
        {           
        	this.right_arm.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(p_78086_2_, 4.0F)) * p_78086_3_;
            this.left_arm.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(p_78086_2_, 4.0F)) * p_78086_3_;           
        }
    }

    private float func_78172_a(float p_78172_1_, float p_78172_2_)
    {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
