package com.NovaCraft.entity.models;

import com.NovaCraft.entity.EntityFrog;
import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityGiantFrog;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GiantFrogModel extends ModelBase {

    public ModelRenderer root;
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer eyes;
    public ModelRenderer tongue;
    public ModelRenderer leftArm;
    public ModelRenderer rightArm;
    public ModelRenderer leftLeg;
    public ModelRenderer rightLeg;
    public ModelRenderer croakingBody;

    private static final float WALK_SPEED = 2.5F;
    private static final float SWIM_SPEED = 3.5F;

    public GiantFrogModel() {
        this.textureWidth = 96;
        this.textureHeight = 96;

        //Root
        root = new ModelRenderer(this);
        root.setRotationPoint(0.0F, 22.0F, 0.0F);

        //Body
        body = new ModelRenderer(this, 6, 2);
        body.addBox(-7.0F, -4.0F, -16.0F, 14, 6, 18);
        body.setRotationPoint(0.0F, -4.0F, 8.0F);
        root.addChild(body);

        ModelRenderer bodyBottom = new ModelRenderer(this, 46, 44);
        bodyBottom.addBox(-7.0F, -2.0F, -16.0F, 14, 0, 18);
        body.addChild(bodyBottom);

        //Head
        head = new ModelRenderer(this, 0, 26);
        head.addBox(-7.0F, -4.0F, -14.0F, 14, 6, 18);
        head.setRotationPoint(0.0F, -4.0F, -2.0F);
        body.addChild(head);

        ModelRenderer headTop = new ModelRenderer(this, 46, 26);
        headTop.addBox(-7.0F, -2.0F, -14.0F, 14, 0, 18);
        head.addChild(headTop);

        //Eyes
        eyes = new ModelRenderer(this);
        eyes.setRotationPoint(-1.0F, 0.0F, 4.0F);
        head.addChild(eyes);

        ModelRenderer rightEye = new ModelRenderer(this, 0, 0);
        rightEye.addBox(-3.0F, -2.0F, -3.0F, 6, 4, 6);
        rightEye.setRotationPoint(-3.0F, -6.0F, -13.0F);
        eyes.addChild(rightEye);

        ModelRenderer leftEye = new ModelRenderer(this, 0, 10);
        leftEye.addBox(-3.0F, -2.0F, -3.0F, 6, 4, 6);
        leftEye.setRotationPoint(5.0F, -6.0F, -13.0F);
        eyes.addChild(leftEye);

        //Croaking body
        croakingBody = new ModelRenderer(this, 52, 10);
        croakingBody.addBox(-7.0F, -3.4F, -5.8F, 14, 4, 6); //-7.0F, 0.2F, -5.8F
        croakingBody.setRotationPoint(0.0F, 1.0F, -10.0F);
        body.addChild(croakingBody);

        //Tongue
        tongue = new ModelRenderer(this, 34, 26);
        tongue.addBox(-4.0F, 0.0F, -14.2F, 8, 0, 14);
        tongue.setRotationPoint(0.0F, -2.02F, 2.0F);
        body.addChild(tongue);

        //Arms
        leftArm = new ModelRenderer(this, 0, 64);
        leftArm.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 6);
        leftArm.setRotationPoint(8.0F, -2.0F, -13.0F);
        body.addChild(leftArm);

        ModelRenderer leftHand = new ModelRenderer(this, 36, 80);
        leftHand.addBox(-8.0F, 0.02F, -8.0F, 16, 0, 16);
        leftHand.setRotationPoint(0.0F, 6.0F, -2.0F);
        leftArm.addChild(leftHand);

        rightArm = new ModelRenderer(this, 0, 76);
        rightArm.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 6);
        rightArm.setRotationPoint(-8.0F, -2.0F, -13.0F);
        body.addChild(rightArm);

        ModelRenderer rightHand = new ModelRenderer(this, 4, 80);
        rightHand.addBox(-8.0F, 0.02F, -10.0F, 16, 0, 16);
        rightHand.setRotationPoint(0.0F, 6.0F, 0.0F);
        rightArm.addChild(rightHand);

        //Legs
        leftLeg = new ModelRenderer(this, 28, 50);
        leftLeg.addBox(-2.0F, 2.0F, -4.0F, 6, 6, 8);
        leftLeg.setRotationPoint(7.0F, -6.0F, 8.0F);
        root.addChild(leftLeg);

        ModelRenderer leftFoot = new ModelRenderer(this, 4, 64);
        leftFoot.addBox(-8.0F, 2.02F, -8.0F, 16, 0, 16);
        leftFoot.setRotationPoint(4.0F, 6.0F, 0.0F);
        leftLeg.addChild(leftFoot);

        rightLeg = new ModelRenderer(this, 0, 50);
        rightLeg.addBox(-4.0F, 2.0F, -4.0F, 6, 6, 8);
        rightLeg.setRotationPoint(-7.0F, -6.0F, 8.0F);
        root.addChild(rightLeg);

        ModelRenderer rightFoot = new ModelRenderer(this, 36, 64);
        rightFoot.addBox(-8.0F, 2.02F, -8.0F, 16, 0, 16);
        rightFoot.setRotationPoint(-4.0F, 6.0F, 0.0F);
        rightLeg.addChild(rightFoot);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);

        EntityGiantFrog frog = ((EntityGiantFrog) entity);
        if(frog.isChild()) {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            GL11.glTranslatef(0.0F, 24.0F * scale, 0.0F);
        }

        this.croakingBody.isHidden = true;
        root.render(scale);
        this.croakingBody.isHidden = false;

        if (entity instanceof EntityGiantFrog && frog.isCroakingAnim()) {
            renderCroakingBody(scale, frog);
        }
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Entity entity) {
        if (!(entity instanceof EntityGiantFrog)) return;
        EntityGiantFrog frog = (EntityGiantFrog) entity;

        for (ModelRenderer part : new ModelRenderer[]{body, head, eyes, tongue, leftArm, rightArm, leftLeg, rightLeg, croakingBody}) {
            part.rotateAngleX = part.rotateAngleY = part.rotateAngleZ = 0;
        }

        float walkSpeed = frog.isSwimmingAnim() ? SWIM_SPEED : WALK_SPEED;
        leftLeg.rotateAngleX = (float)(Math.cos(limbSwing * walkSpeed) * limbSwingAmount);
        rightLeg.rotateAngleX = (float)(Math.cos(limbSwing * walkSpeed + Math.PI) * limbSwingAmount);
        leftArm.rotateAngleX = leftLeg.rotateAngleX * 0.5F;
        rightArm.rotateAngleX = rightLeg.rotateAngleX * 0.5F;

        if (frog.isJumpingAnim()) {
            float jumpTimer = frog.getJumpTimer();
            float progress = jumpTimer / 0.5F;
            if (progress <= 1.0F) {
                head.rotateAngleX = -Math.abs((float)Math.sin(progress * Math.PI)) * 0.5F;
                body.rotateAngleX = Math.abs((float)Math.sin(progress * Math.PI)) * 0.3F;
            }
        }
        croakingBody.rotationPointZ = -5.0F;

        if (frog.isSwimmingAnim()) {
            float swimTimer = frog.getSwimTimer();
            body.rotationPointY = -2.0F + (float)Math.sin(swimTimer * 2.0F) * 0.1F;
        } else {
            body.rotationPointY = -2.0F;
        }

        //Add tongue animation here
    }


    private void renderCroakingBody(float scale, EntityGiantFrog frog) {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 20.25F * scale, 4.0F * scale);

        float croakTimer = frog.getCroakTimer();
        float p = croakTimer / 0.7F;
        if (p <= 1.0F) {
            float intensity = (float) Math.sin(p * Math.PI);
            float scaleFactor = 1.0F + intensity * 0.25F;
            GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);

            croakingBody.render(scale);
        }

        GL11.glPopMatrix();
    }





}
