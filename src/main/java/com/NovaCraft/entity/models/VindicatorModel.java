package com.NovaCraft.entity.models;

import com.NovaCraft.entity.illager.EntityVindicator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class VindicatorModel extends ModelBiped
{

    public VindicatorModel()
    {
        this(0.0F, 0.0F, false);
    }

    public VindicatorModel(float p_i1165_1_, float p_i1165_2_, boolean p_i1165_3_)
    {
        super(p_i1165_1_, 0.0F, 64, p_i1165_3_ ? 32 : 64);

        if (p_i1165_3_)
        {
            this.bipedHead = new ModelRenderer(this, 0, 0);
            this.bipedHead.addBox(-4.0F, -10.0F, -4.0F, 8, 6, 8, p_i1165_1_);
            this.bipedHead.setRotationPoint(0.0F, 0.0F + p_i1165_2_, 0.0F);
        }
        else
        {
            this.bipedHead = new ModelRenderer(this);
            this.bipedHead.setRotationPoint(0.0F, 0.0F + p_i1165_2_, 0.0F);
            this.bipedHead.setTextureOffset(0, 32).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, p_i1165_1_);
            this.bipedHead.setTextureOffset(24, 32).addBox(-1.0F, -3.0F, -6.0F, 2, 4, 2, p_i1165_1_);
        }
    }

    public int func_82897_a()
    {
        return 10;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);

        if (entity instanceof EntityVindicator) {
            EntityVindicator vindicator = (EntityVindicator) entity;

            if (vindicator.isAngry()) {
                this.bipedRightArm.rotateAngleX = -1.5F;
                this.bipedRightArm.rotateAngleY = 0.0F;
                this.bipedRightArm.rotateAngleZ = 0.0F;
            } else {
                this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
                this.bipedRightArm.rotateAngleY = 0.0F;
                this.bipedRightArm.rotateAngleZ = 0.0F;
            }

            this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
            this.bipedLeftArm.rotateAngleY = 0.0F;
            this.bipedLeftArm.rotateAngleZ = 0.0F;
        }
    }

}
