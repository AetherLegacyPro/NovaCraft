package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class OctoqusModel extends ModelBase {

    public ModelRenderer body;
    public ModelRenderer mouth;
    public ModelRenderer front_shoulder_1;
    public ModelRenderer front_shoulder_2;
    public ModelRenderer left_shoulder_1;
    public ModelRenderer left_shoulder_2;
    public ModelRenderer right_shoulder_1;
    public ModelRenderer right_shoulder_2;
    public ModelRenderer back_shoulder_1;
    public ModelRenderer back_shoulder_2;
    public ModelRenderer right_tentacle_1;
    public ModelRenderer right_tentacle_2;
    public ModelRenderer left_tentacle_1;
    public ModelRenderer left_tentacle_2;
    public ModelRenderer back_tentacle_1;
    public ModelRenderer back_tentacle_2;
    public ModelRenderer front_tentacle_1;
    public ModelRenderer front_tentacle_2;

    public OctoqusModel() {
        textureWidth = 64;
        textureHeight = 64;

        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-8.0F, -24.0F, -8.0F, 16, 16, 16);
        this.body.setRotationPoint(0.0F, 24.0F, 0.0F);

        this.mouth = new ModelRenderer(this, 17, 56);
        this.mouth.addBox(-2.0F, -15.0F, -12.0F, 4, 4, 4);
        this.mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(mouth);

        this.front_shoulder_1 = new ModelRenderer(this, 0, 35);
        this.front_shoulder_1.addBox(-7.0F, -10.0F, -12.0F, 5, 5, 5);
        this.front_shoulder_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(front_shoulder_1);

        this.front_shoulder_2 = new ModelRenderer(this, 0, 35);
        this.front_shoulder_2.addBox(2.0F, -10.0F, -12.0F, 5, 5, 5);
        this.front_shoulder_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(front_shoulder_2);

        this.left_shoulder_1 = new ModelRenderer(this, 40, 35);
        this.left_shoulder_1.addBox(-12.0F, -10.0F, -7.0F, 5, 5, 5);
        this.left_shoulder_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(left_shoulder_1);

        this.left_shoulder_2 = new ModelRenderer(this, 40, 35);
        this.left_shoulder_2.addBox(-12.0F, -10.0F, 1.0F, 5, 5, 5);
        this.left_shoulder_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(left_shoulder_2);

        this.right_shoulder_1 = new ModelRenderer(this, 40, 45);
        this.right_shoulder_1.addBox(7.0F, -10.0F, -7.0F, 5, 5, 5);
        this.right_shoulder_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(right_shoulder_1);

        this.right_shoulder_2 = new ModelRenderer(this, 40, 45);
        this.right_shoulder_2.addBox(7.0F, -10.0F, 0.0F, 5, 5, 5);
        this.right_shoulder_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(right_shoulder_2);

        this.back_shoulder_1 = new ModelRenderer(this, 20, 35);
        this.back_shoulder_1.addBox(2.0F, -10.0F, 7.0F, 5, 5, 5);
        this.back_shoulder_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(back_shoulder_1);

        this.back_shoulder_2 = new ModelRenderer(this, 20, 35);
        this.back_shoulder_2.addBox(-7.0F, -10.0F, 7.0F, 5, 5, 5);
        this.back_shoulder_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(back_shoulder_2);

        this.right_tentacle_1 = new ModelRenderer(this, 0, 45);
        this.right_tentacle_1.setRotationPoint(11.5F, -8.0F, 1.0F);
        this.right_tentacle_1.addBox(-1.5F, 0.0F, 0.0F, 3, 16, 3);
        this.setRotation(right_tentacle_1, 0.0F, 0.0F, -0.4363F);
        right_shoulder_2.addChild(right_tentacle_1);

        this.right_tentacle_2 = new ModelRenderer(this, 0, 45);
        this.right_tentacle_2.setRotationPoint(11.5F, -8.0F, 1.0F);
        this.right_tentacle_2.addBox(-1.5F, 0.0F, -7.0F, 3, 16, 3);
        this.setRotation(right_tentacle_2, 0.0F, 0.0F, -0.4363F);
        right_shoulder_1.addChild(right_tentacle_2);

        this.left_tentacle_1 = new ModelRenderer(this, 0, 45);
        this.left_tentacle_1.setRotationPoint(-11.5F, -8.0F, 1.0F);
        this.left_tentacle_1.addBox(-1.5F, 0.0F, 1.0F, 3, 16, 3);
        this.setRotation(left_tentacle_1, 0.0F, 0.0F, 0.4363F);
        left_shoulder_1.addChild(left_tentacle_1);

        this.left_tentacle_2 = new ModelRenderer(this, 0, 45);
        this.left_tentacle_2.setRotationPoint(-11.5F, -8.0F, 1.0F);
        this.left_tentacle_2.addBox(-1.5F, 0.0F, -7.0F, 3, 16, 3);
        this.setRotation(left_tentacle_2, 0.0F, 0.0F, 0.4363F);
        left_shoulder_2.addChild(left_tentacle_2);

        this.back_tentacle_1 = new ModelRenderer(this, 0, 45);
        this.back_tentacle_1.setRotationPoint(-4.0F, -8.0F, 11.5F);
        this.back_tentacle_1.addBox(-2.0F, 0.0F, -1.5F, 3, 16, 3);
        this.setRotation(back_tentacle_1, 0.4363F, 0.0F, 0.0F);
        back_shoulder_1.addChild(back_tentacle_1);

        this.back_tentacle_2 = new ModelRenderer(this, 0, 45);
        this.back_tentacle_2.setRotationPoint(-4.0F, -8.0F, 11.5F);
        this.back_tentacle_2.addBox(7.0F, 0.0F, -1.5F, 3, 16, 3);
        this.setRotation(back_tentacle_2, 0.4363F, 0.0F, 0.0F);
        back_shoulder_2.addChild(back_tentacle_2);

        this.front_tentacle_1 = new ModelRenderer(this, 0, 45);
        this.front_tentacle_1.setRotationPoint(-4.0F, -8.0F, -11.5F);
        this.front_tentacle_1.addBox(7.0F, 0.0F, -1.5F, 3, 16, 3);
        this.setRotation(front_tentacle_1, -0.4363F, 0.0F, 0.0F);
        front_shoulder_1.addChild(front_tentacle_1);

        this.front_tentacle_2 = new ModelRenderer(this, 0, 45);
        this.front_tentacle_2.setRotationPoint(-4.0F, -8.0F, -11.5F);
        this.front_tentacle_2.addBox(-2.0F, 0.0F, -1.5F, 3, 16, 3);
        this.setRotation(front_tentacle_2, -0.4363F, 0.0F, 0.0F);
        front_shoulder_2.addChild(front_tentacle_2);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        body.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Entity entity) {
        float speed = 0.05F;
        float amount = 0.6F;
        float movementX = Math.abs((float)Math.sin(ageInTicks * speed) * amount) + 0.3F;
        float movementZ = -Math.abs((float)Math.sin(ageInTicks * speed) * amount) - 0.3F;

        this.right_tentacle_1.rotateAngleZ = movementZ;
        this.right_tentacle_2.rotateAngleZ = movementZ;
        this.left_tentacle_1.rotateAngleZ = -movementZ;
        this.left_tentacle_2.rotateAngleZ = -movementZ;

        this.back_tentacle_1.rotateAngleX = movementX;
        this.back_tentacle_2.rotateAngleX = movementX;
        this.front_tentacle_1.rotateAngleX = -movementX;
        this.front_tentacle_2.rotateAngleX = -movementX;
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
