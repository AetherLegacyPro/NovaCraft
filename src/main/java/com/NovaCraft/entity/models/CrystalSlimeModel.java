package com.NovaCraft.entity.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class CrystalSlimeModel extends ModelBase
{
    ModelRenderer slimeBodies;
    ModelRenderer slimeRightEye;
    ModelRenderer slimeLeftEye;
    ModelRenderer slimeMouth;

    ModelRenderer crystal;
    ModelRenderer crystal2;

    ModelRenderer crystal_side_right;

    ModelRenderer crystal_side_right_2;

    ModelRenderer crystal_side_left;

    ModelRenderer crystal_side_left_2;

    public CrystalSlimeModel(int p_i1157_1_)
    {
        this.slimeBodies = new ModelRenderer(this, 0, p_i1157_1_);
        this.slimeBodies.addBox(-4.0F, 16.0F, -4.0F, 8, 8, 8);

        if (p_i1157_1_ > 0)
        {
            this.slimeBodies = new ModelRenderer(this, 0, p_i1157_1_);
            this.slimeBodies.addBox(-3.0F, 17.0F, -3.0F, 6, 6, 6);
            this.slimeRightEye = new ModelRenderer(this, 32, 0);
            this.slimeRightEye.addBox(-3.25F, 18.0F, -3.5F, 2, 2, 2);
            this.slimeLeftEye = new ModelRenderer(this, 32, 4);
            this.slimeLeftEye.addBox(1.25F, 18.0F, -3.5F, 2, 2, 2);
            this.slimeMouth = new ModelRenderer(this, 32, 8);
            this.slimeMouth.addBox(0.0F, 21.0F, -3.5F, 1, 1, 1);

            this.crystal = new ModelRenderer(this, 32, 22);
            this.crystal.addBox(-3.0F, 12.0F, 0.5F, 6, 6, 0); //0.0F, 12.0F, -3.5F
            this.setRotationAngle(this.crystal, 0.0F, 0.45F, 0.0F);

            this.crystal2 = new ModelRenderer(this, 32, 22);
            this.crystal2.addBox(-3.0F, 12.0F, 0.5F, 6, 6, 0); //0.0F, 12.0F, -3.5F
            this.setRotationAngle(this.crystal2, 0.0F, -0.45F, 0.0F);

            this.crystal_side_right = new ModelRenderer(this, 50, 22);
            this.crystal_side_right.addBox(-9.0F, 14.0F, 0.0F, 5, 6, 0); //-9.0F, 14.0F, -0.5F
            this.setRotationAngle(this.crystal_side_right, 0.0F, 0.45F, 0.0F);

            this.crystal_side_right_2 = new ModelRenderer(this, 50, 22);
            this.crystal_side_right_2.addBox(-9.0F, 14.0F, 0.0F, 5, 6, 0); //-9.0F, 14.0F, -0.5F
            this.setRotationAngle(this.crystal_side_right_2, 0.0F, -0.45F, 0.0F);

            this.crystal_side_left = new ModelRenderer(this, 50, 14);
            this.crystal_side_left.addBox(4.0F, 14.0F, 0.0F, 5, 6, 0); //-9.0F, 14.0F, -0.5F
            this.setRotationAngle(this.crystal_side_left, 0.0F, 0.45F, 0.0F);

            this.crystal_side_left_2 = new ModelRenderer(this, 50, 14);
            this.crystal_side_left_2.addBox(4.0F, 14.0F, 0.0F, 5, 6, 0); //-9.0F, 14.0F, -0.5F
            this.setRotationAngle(this.crystal_side_left_2, 0.0F, -0.45F, 0.0F);
        }
    }

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.slimeBodies.render(p_78088_7_);

        if (this.slimeRightEye != null)
        {
            this.slimeRightEye.render(p_78088_7_);
            this.slimeLeftEye.render(p_78088_7_);
            this.slimeMouth.render(p_78088_7_);
            this.crystal.render(p_78088_7_);
            this.crystal2.render(p_78088_7_);
            this.crystal_side_right.render(p_78088_7_);
            this.crystal_side_right_2.render(p_78088_7_);
            this.crystal_side_left.render(p_78088_7_);
            this.crystal_side_left_2.render(p_78088_7_);
        }
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
