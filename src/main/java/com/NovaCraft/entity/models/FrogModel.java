package com.NovaCraft.entity.models;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityFrog;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FrogModel extends ModelBase {
	
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
    
    public FrogModel() {
        this.textureWidth = 48;
        this.textureHeight = 48;

        //Root
        root = new ModelRenderer(this);
        root.setRotationPoint(0.0F, 24.0F, 0.0F);

        //Body
        body = new ModelRenderer(this, 3, 1);
        body.addBox(-3.5F, -2.0F, -8.0F, 7, 3, 9);
        body.setRotationPoint(0.0F, -2.0F, 4.0F);
        root.addChild(body);

        ModelRenderer bodyBottom = new ModelRenderer(this, 23, 22);
        bodyBottom.addBox(-3.5F, -1.0F, -8.0F, 7, 0, 9);
        body.addChild(bodyBottom);

        //Head
        head = new ModelRenderer(this, 0, 13);
        head.addBox(-3.5F, -2.0F, -7.0F, 7, 3, 9);
        head.setRotationPoint(0.0F, -2.0F, -1.0F);
        body.addChild(head);

        ModelRenderer headTop = new ModelRenderer(this, 23, 13);
        headTop.addBox(-3.5F, -1.0F, -7.0F, 7, 0, 9);
        head.addChild(headTop);

        //Eyes
        eyes = new ModelRenderer(this);
        eyes.setRotationPoint(-0.5F, 0.0F, 2.0F);
        head.addChild(eyes);

        ModelRenderer rightEye = new ModelRenderer(this, 0, 0);
        rightEye.addBox(-1.5F, -1.0F, -1.5F, 3, 2, 3);
        rightEye.setRotationPoint(-1.5F, -3.0F, -6.5F);
        eyes.addChild(rightEye);

        ModelRenderer leftEye = new ModelRenderer(this, 0, 5);
        leftEye.addBox(-1.5F, -1.0F, -1.5F, 3, 2, 3);
        leftEye.setRotationPoint(2.5F, -3.0F, -6.5F);
        eyes.addChild(leftEye);

        //Croaking body
        croakingBody = new ModelRenderer(this, 26, 5);
        croakingBody.addBox(-3.5F, 0.1F, -2.9F, 7, 2, 3);
        croakingBody.setRotationPoint(0.0F, 0.5F, -5.0F);
        body.addChild(croakingBody);

        //Tongue
        tongue = new ModelRenderer(this, 17, 13);
        tongue.addBox(-2.0F, 0.0F, -7.1F, 4, 0, 7);
        tongue.setRotationPoint(0.0F, -1.01F, 1.0F);
        body.addChild(tongue);

        //Arms
        leftArm = new ModelRenderer(this, 0, 32);
        leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 3);
        leftArm.setRotationPoint(4.0F, -1.0F, -6.5F);
        body.addChild(leftArm);

        ModelRenderer leftHand = new ModelRenderer(this, 18, 40);
        leftHand.addBox(-4.0F, 0.01F, -4.0F, 8, 0, 8);
        leftHand.setRotationPoint(0.0F, 3.0F, -1.0F);
        leftArm.addChild(leftHand);

        rightArm = new ModelRenderer(this, 0, 38);
        rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 3);
        rightArm.setRotationPoint(-4.0F, -1.0F, -6.5F);
        body.addChild(rightArm);

        ModelRenderer rightHand = new ModelRenderer(this, 2, 40);
        rightHand.addBox(-4.0F, 0.01F, -5.0F, 8, 0, 8);
        rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);
        rightArm.addChild(rightHand);

        //Legs
        leftLeg = new ModelRenderer(this, 14, 25);
        leftLeg.addBox(-1.0F, 0.0F, -2.0F, 3, 3, 4);
        leftLeg.setRotationPoint(3.5F, -3.0F, 4.0F);
        root.addChild(leftLeg);

        ModelRenderer leftFoot = new ModelRenderer(this, 2, 32);
        leftFoot.addBox(-4.0F, 0.01F, -4.0F, 8, 0, 8);
        leftFoot.setRotationPoint(2.0F, 3.0F, 0.0F);
        leftLeg.addChild(leftFoot);

        rightLeg = new ModelRenderer(this, 0, 25);
        rightLeg.addBox(-2.0F, 0.0F, -2.0F, 3, 3, 4);
        rightLeg.setRotationPoint(-3.5F, -3.0F, 4.0F);
        root.addChild(rightLeg);

        ModelRenderer rightFoot = new ModelRenderer(this, 18, 32);
        rightFoot.addBox(-4.0F, 0.01F, -4.0F, 8, 0, 8);
        rightFoot.setRotationPoint(-2.0F, 3.0F, 0.0F);
        rightLeg.addChild(rightFoot);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);

        EntityFrog frog = ((EntityFrog) entity);
        if(frog.isChild()) {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            GL11.glTranslatef(0.0F, 24.0F * scale, 0.0F);
        }

        this.croakingBody.isHidden = true;
        root.render(scale);
        this.croakingBody.isHidden = false;

        if (entity instanceof EntityFrog && frog.isCroakingAnim()) {
            renderCroakingBody(scale, frog);
        }
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Entity entity) {
        if (!(entity instanceof EntityFrog)) return;
        EntityFrog frog = (EntityFrog) entity;

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


    private void renderCroakingBody(float scale, EntityFrog frog) {
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

