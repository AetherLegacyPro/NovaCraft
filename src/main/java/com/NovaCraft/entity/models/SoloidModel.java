package com.NovaCraft.entity.models;

import com.NovaCraft.entity.EntitySoloid;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class SoloidModel extends ModelBase {

    private final ModelRenderer body;
    private final ModelRenderer tail1;
    private final ModelRenderer tail2;
    private final ModelRenderer tail3;
    private final ModelRenderer tail4;
    private final ModelRenderer tail5;

    private final ModelRenderer neck;
    private final ModelRenderer head_back;
    private final ModelRenderer head_top;
    private final ModelRenderer head_bottom;
    private final ModelRenderer crest;
    private final ModelRenderer right_horn_bottom;
    private final ModelRenderer right_horn_top;
    private final ModelRenderer left_horn_bottom;
    private final ModelRenderer left_horn_top;

    private final ModelRenderer front_right_shoulder;
    private final ModelRenderer front_left_leg;

    private final ModelRenderer back_right_shoulder;
    private final ModelRenderer back_right_leg;

    private final ModelRenderer front_left_shoulder;
    private final ModelRenderer front_right_leg;

    private final ModelRenderer back_left_shoulder;
    private final ModelRenderer back_left_leg;

    private final ModelRenderer top_teeth_1;
    private final ModelRenderer top_teeth_2;
    private final ModelRenderer bottom_teeth_1;
    private final ModelRenderer bottom_teeth_2;

    public SoloidModel() { //+x left -xright //-z forward +z back
        textureWidth = 192;
        textureHeight = 192;

        (this.body = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(4.75F, -0.25F, 0.0F);
        this.body.addBox(-12.25F, 5.0F, -1.5F, 14, 10, 20, 0.0f);
        this.setRotationAngle(this.body, -0.0436F, 0.0F, 0.0F);

        this.tail1 = new ModelRenderer(this, 0, 32);
        this.tail1.setRotationPoint(-6.0F, 7.0F, 18.0F);
        this.tail1.addBox(-3.5F, -1.75F, 0.25F, 9, 9, 8, 0.0F);
        this.body.addChild(this.tail1);

        (this.tail2 = new ModelRenderer(this, 0, 51)).setRotationPoint(0.75F, 0.0F, 8.0F);
        this.tail2.addBox(-4.0F, -1.75F, 0.25F, 8, 8, 6, 0.0F);
        this.tail1.addChild(this.tail2);

        (this.tail3 = new ModelRenderer((ModelBase)this, 0, 67)).setRotationPoint(-0.75F, -0.5F, 4.0F);
        this.tail3.addBox(-2.5F, -0.5F, 2.5F, 6, 7, 6, 0.0f);
        this.setRotationAngle(this.tail3, -0.0436F, 0.0F, 0.0F);
        this.tail2.addChild(this.tail3);

        (this.tail4 = new ModelRenderer((ModelBase)this, 0, 82)).setRotationPoint(-1.25F, -3.25F, 3.25F);
        this.tail4.addBox(-0.75F, 3.5F, 5.25F, 5, 6, 4, 0.0f);
        this.setRotationAngle(this.tail4, -0.0436F, 0.0F, 0.0F);
        this.tail3.addChild(this.tail4);

        (this.tail5 = new ModelRenderer((ModelBase)this, 0, 94)).setRotationPoint(-0.25F, 0.5F, 2.75F);
        this.tail5.addBox(0.25F, 3.0F, 6.75F, 3, 5, 5, 0.0f);
        this.setRotationAngle(this.tail5, -0.0436F, 0.0F, 0.0F);
        this.tail4.addChild(this.tail5);

        (this.neck = new ModelRenderer((ModelBase)this, 123, 25)).setRotationPoint(2.0F, -5.0F, -12.0F);
        this.neck.addBox(-6.0F, 9.0F, 1.0F, 7, 7, 12);
        this.setRotationAngle(this.neck, -0.1745F, 0.0F, 0.0F);

        (this.head_back = new ModelRenderer((ModelBase)this, 78, 26)).setRotationPoint(1.0F, -1.0F, 0.0F);
        this.head_back.addBox(-6.5F, 3.6891F, -14.4507F, 10, 9, 5);
        this.setRotationAngle(this.head_back, 0.0F, 0.0F, 0.0F);

        (this.head_top = new ModelRenderer((ModelBase)this, 75, 52)).setRotationPoint(-0.25F, -0.75F, -2.5F);
        this.head_top.addBox(-5.25F, 4.9391F, -21.9508F, 8, 5, 10, 0.0f);
        this.setRotationAngle(this.head_top, 0.0F, 0.0F, 0.0F);
        this.head_back.addChild(this.head_top);

        (this.head_bottom = new ModelRenderer((ModelBase)this, 76, 69)).setRotationPoint(1.0F, -1.0F, -2.0F);
        this.head_bottom.addBox(-6.0F, 9.6952F, -23.5203F, 7, 2, 10, 0.0f);
        this.setRotationAngle(this.head_bottom, 0.1309F, 0.0F, 0.0F);
        this.head_back.addChild(this.head_bottom);

        (this.crest = new ModelRenderer((ModelBase)this, 82, 43)).setRotationPoint(-0.75F, -1.0F, 2.75F);
        this.crest.addBox(-4.5F, 2.9391F, -17.7008F, 8, 3, 3, 0.0f);
        this.setRotationAngle(this.crest, 0.0F, 0.0F, 0.0F);
        this.head_top.addChild(this.crest);

        (this.right_horn_bottom = new ModelRenderer((ModelBase)this, 87, 85)).setRotationPoint(-8.0F, -1.5F, 0.75F);
        this.right_horn_bottom.addBox(1.5F, -1.0609F, -17.7008F, 2, 7, 2, 0.0f);
        this.setRotationAngle(this.right_horn_bottom, 0.0F, 0.0F, 0.0F);
        this.crest.addChild(this.right_horn_bottom);

        (this.right_horn_top = new ModelRenderer((ModelBase)this, 87, 85)).setRotationPoint(-12.0F, -4.0F, 0.0F);
        this.right_horn_top.addBox(11.5F, -1.0609F, -17.7008F, 2, 7, 2, 0.0f);
        this.setRotationAngle(this.right_horn_top, 0.0F, 0.0F, 0.0F);
        this.right_horn_bottom.addChild(this.right_horn_top);

        (this.left_horn_bottom = new ModelRenderer((ModelBase)this, 97, 85)).setRotationPoint(2.0F, -1.5F, 0.75F);
        this.left_horn_bottom.addBox(1.5F, -1.0609F, -17.7008F, 2, 7, 2, 0.0f);
        this.setRotationAngle(this.left_horn_bottom, 0.0F, 0.0F, 0.0F);
        this.crest.addChild(this.left_horn_bottom);

        (this.left_horn_top = new ModelRenderer((ModelBase)this, 97, 85)).setRotationPoint(-12.0F, -4.0F, 0.0F);
        this.left_horn_top.addBox(15.5F, -1.0609F, -17.7008F, 2, 7, 2, 0.0f);
        this.setRotationAngle(this.left_horn_top, 0.0F, 0.0F, 0.0F);
        this.left_horn_bottom.addChild(this.left_horn_top);

        (this.front_left_shoulder = new ModelRenderer((ModelBase)this, 37, 64)).setRotationPoint(-22.5F, 1.25F, -2.0F);
        this.front_left_shoulder.addBox(24.0861F, 1.4388F, 2.0F, 5, 5, 5, 0.0f);
        this.setRotationAngle(this.front_left_shoulder, 0.0872F, 0.0F, 0.0872F);
        body.addChild(front_left_shoulder); //DONE

        (this.front_right_shoulder = new ModelRenderer((ModelBase)this, 37, 64)).setRotationPoint(20.25F, 0.75F, 1.0F);
        this.front_right_shoulder.addBox(-37.2531F, 0.6811F, -1.0F, 5, 5, 5, 0.0f);
        this.setRotationAngle(this.front_right_shoulder, 0.0872F, 0.0F, -0.0872F);
        body.addChild(front_right_shoulder);

        (this.back_left_shoulder = new ModelRenderer((ModelBase)this, 37, 52)).setRotationPoint(-24.0F, 0.5F, 12.0F);
        this.back_left_shoulder.addBox(25.0861F, 1.4388F, -1.0F, 5, 5, 5, 0.0f);
        this.setRotationAngle(this.back_left_shoulder, 0.0F, 0.0F, 0.0872F);
        body.addChild(back_left_shoulder);

        (this.back_right_shoulder = new ModelRenderer((ModelBase)this, 37, 52)).setRotationPoint(20.5F, 0.5F, 12.0F);
        this.back_right_shoulder.addBox(-37.2531F, 0.6811F, -1.0F, 5, 5, 5, 0.0f);
        this.setRotationAngle(this.back_right_shoulder, 0.0F, 0.0F, -0.0872F);
        body.addChild(back_right_shoulder);

        (this.front_left_leg = new ModelRenderer((ModelBase)this, 41, 76)).setRotationPoint(27.5F, 4.5F, 4.0F);
        this.front_left_leg.addBox(-1.5F, 0.0F, -1.5F, 3, 17, 3, 0.0F);
        this.front_left_shoulder.addChild(this.front_left_leg);
        this.setRotationAngle(this.front_left_leg, -0.0872F, 0.0F, -0.0436F);

        (this.back_right_leg = new ModelRenderer(this, 56, 76)).setRotationPoint(-35.5F, 4.0F, 1.5F);
        this.back_right_leg.addBox(-1.5F, 0.0F, -1.5F, 3, 17, 3, 0.0F);
        this.back_right_shoulder.addChild(this.back_right_leg);
        this.setRotationAngle(this.back_right_leg, 0.0872F, 0.0F, 0.0872F);

        (this.front_right_leg = new ModelRenderer(this, 41, 76)).setRotationPoint(-35.5F, 5.0F, 1.5F);
        this.front_right_leg.addBox(-1.5F, 0.0F, -1.5F, 3, 17, 3, 0.0F);
        this.front_right_shoulder.addChild(this.front_right_leg);
        this.setRotationAngle(this.front_right_leg, -0.0872F, 0.0F, 0.0872F);

        (this.back_left_leg = new ModelRenderer(this, 56, 76)).setRotationPoint(20.0F, 4.0F, -0.5F);
        this.back_left_leg.addBox(6.5F, 1.0F, 0.25F, 3, 17, 3, 0.0F);
        this.back_left_shoulder.addChild(this.back_left_leg);
        this.setRotationAngle(this.back_left_leg, 0.0F, 0.0F, -0.0872F);

        (this.top_teeth_1 = new ModelRenderer((ModelBase)this, 72, 78)).setRotationPoint(0.0F, -4.75F, -21.5F);
        this.top_teeth_1.addBox(1.0F, 13.5F, 1.0F, 0, 2, 7, 0.0f);
        this.setRotationAngle(this.top_teeth_1, 0.0F, 0.0F, 0.0F);
        head_top.addChild(top_teeth_1);

        (this.top_teeth_2 = new ModelRenderer((ModelBase)this, 72, 78)).setRotationPoint(-1.5F, -4.75F, -21.5F);
        this.top_teeth_2.addBox(-2.0F, 13.5F, 1.0F, 0, 2, 7, 0.0f);
        this.setRotationAngle(this.top_teeth_2, -0.0436F, 0.0F, 0.0F);
        head_top.addChild(top_teeth_2);

        (this.bottom_teeth_1 = new ModelRenderer((ModelBase)this, 72, 78)).setRotationPoint(-1.25F, -5.0F, -21.25F);
        this.bottom_teeth_1.addBox(1.0F, 14.0F, 0.0F, 0, 2, 7, 0.0f);
        this.setRotationAngle(this.bottom_teeth_1, 0.0F, 0.0F, 0.0F);
        head_bottom.addChild(bottom_teeth_1);

        (this.bottom_teeth_2 = new ModelRenderer((ModelBase)this, 72, 78)).setRotationPoint(-5.75F, -5.0F, -21.25F);
        this.bottom_teeth_2.addBox(1.0F, 14.0F, 0.0F, 0, 2, 7, 0.0f);
        this.setRotationAngle(this.bottom_teeth_2, 0.0F, 0.0F, 0.0F);
        head_bottom.addChild(bottom_teeth_2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        body.render(f5);
        neck.render(f5);
        head_back.render(f5);
    }

    @Override
    public void setRotationAngles(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

        this.head_top.rotateAngleX = headPitch * 0.0008453292f;
        this.head_top.rotateAngleY = netHeadYaw * 0.0008453292f;

        float jawSpeed = 0.05F;
        float jawAmplitude = 0.01F;
        float jawAngle = MathHelper.sin(ageInTicks * jawSpeed) * jawAmplitude;
        this.head_bottom.rotateAngleX = 0.1309F + jawAngle;

        this.back_right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 0.5f * limbSwingAmount;
        this.back_left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 0.5f * limbSwingAmount;
        this.front_right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * -0.5f * limbSwingAmount;
        this.front_left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * -0.5f * limbSwingAmount;

        float speed = 0.1F;
        float amplitude = 0.15F;
        this.tail1.rotateAngleY = MathHelper.sin(ageInTicks * speed) * amplitude;
        this.tail2.rotateAngleY = MathHelper.sin(ageInTicks * speed + 0.5F) * (amplitude * 0.75F);
        this.tail3.rotateAngleY = MathHelper.sin(ageInTicks * speed + 0.49F) * (amplitude * 0.74F);
        this.tail4.rotateAngleY = MathHelper.sin(ageInTicks * speed + 0.48F) * (amplitude * 0.73F);
        this.tail5.rotateAngleY = MathHelper.sin(ageInTicks * speed + 0.48F) * (amplitude * 0.73F);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
