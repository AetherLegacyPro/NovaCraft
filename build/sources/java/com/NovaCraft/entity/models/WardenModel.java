package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import com.NovaCraft.entity.EntityWarden;

public class WardenModel extends ModelBase {

    private static final float RIBCAGE_CLOSED_Z = 0.0F;
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer leftArm;
    public ModelRenderer rightArm;
    public ModelRenderer leftLeg;
    public ModelRenderer rightLeg;
    public ModelRenderer leftTendril;
    public ModelRenderer rightTendril;
    public ModelRenderer rightRibcage;
    public ModelRenderer leftRibcage;

    public WardenModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-9.0F, -11.0F, -4.0F, 18, 21, 11);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F); //-17.0F

        this.head = new ModelRenderer(this, 0, 32);
        this.head.addBox(-8.0F, -14.0F, -5.0F, 16, 16, 10);
        this.head.setRotationPoint(0.0F, -13.0F, 0.0F);
        this.body.addChild(this.head);

        this.rightTendril = new ModelRenderer(this, 52, 32);
        this.rightTendril.addBox(-16.0F, -11.0F, 0.0F, 16, 16, 0);
        this.rightTendril.setRotationPoint(-8.0F, -12.0F, 0.0F);
        this.head.addChild(this.rightTendril);

        this.leftTendril = new ModelRenderer(this, 58, 0);
        this.leftTendril.addBox(0.0F, -11.0F, 0.0F, 16, 16, 0);
        this.leftTendril.setRotationPoint(8.0F, -12.0F, 0.0F);
        this.head.addChild(this.leftTendril);

        this.rightArm = new ModelRenderer(this, 44, 50);
        this.rightArm.addBox(-4.0F, 2.0F, -4.0F, 8, 28, 8);
        this.rightArm.setRotationPoint(-13.0F, -13.0F, 1.0F);
        this.body.addChild(this.rightArm);

        this.leftArm = new ModelRenderer(this, 0, 58);
        this.leftArm.addBox(-4.0F, 2.0F, -4.0F, 8, 28, 8);
        this.leftArm.setRotationPoint(13.0F, -13.0F, 1.0F);
        this.body.addChild(this.leftArm);

        this.rightLeg = new ModelRenderer(this, 76, 48);
        this.rightLeg.addBox(-3.1F, 2.0F, -3.0F, 6, 13, 6);
        this.rightLeg.setRotationPoint(-5.9F, 8.0F, 0.0F); //-9.0F

        this.leftLeg = new ModelRenderer(this, 76, 76);
        this.leftLeg.addBox(-2.9F, 2.0F, -3.0F, 6, 13, 6);
        this.leftLeg.setRotationPoint(5.9F, 8.0F, 0.0F); //-9.0F

        this.rightRibcage = new ModelRenderer(this, 90, 11);
        this.rightRibcage.addBox(-2.0F, -9.0F, -0.5F, 9, 21, 1);
        this.rightRibcage.setRotationPoint(-6.0F, -1.0F, -4.0F);
        this.rightRibcage.mirror = true;
        this.body.addChild(this.rightRibcage);

        this.leftRibcage = new ModelRenderer(this, 106, 11);
        this.leftRibcage.addBox(-7.0F, -9.0F, -0.5F, 9, 21, 1);
        this.leftRibcage.setRotationPoint(10.0F, -1.0F, -4.0F);
        this.leftRibcage.mirror = false;
        this.body.addChild(this.leftRibcage);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Entity entity) {
        resetPose();

        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);

        animateWalk(limbSwing, limbSwingAmount);
        animateTendrils(ageInTicks);

        if (this.onGround > 0.0F) {
            animateAttack(this.onGround);
        }

        if (entity instanceof EntityWarden) {
            EntityWarden warden = (EntityWarden) entity;

            int ticks = warden.getSonicBoomTicks();
            if (ticks > 0) {
                float progress = 1.0F - (ticks / 25.0F);
                animateSonicBoom(progress);
            }
        }

        EntityWarden warden = (EntityWarden)entity;

        if (warden.attackAnimationTicks > 0) {
            float progress = (10 - warden.attackAnimationTicks) / 10.0F;
            animateChestPulse(progress);
        }

        float breathe = MathHelper.sin(ageInTicks * 0.1F) * 0.05F;

        this.rightRibcage.rotateAngleZ +=  breathe;
        this.leftRibcage.rotateAngleZ  -=  breathe;
        applyBreathing(ageInTicks);
    }

    private void applyBreathing(float ageInTicks) {
        float breathe = MathHelper.sin(ageInTicks * 0.1F) * 0.05F;

        this.rightRibcage.rotateAngleZ += breathe;
        this.leftRibcage.rotateAngleZ  -= breathe;
    }

    private void animateChestPulse(float progress) {

        float ease = MathHelper.sin(progress * (float)Math.PI);

        this.rightRibcage.rotateAngleZ += 0.45F * ease;
        this.leftRibcage.rotateAngleZ  -= 0.45F * ease;

        this.rightRibcage.rotateAngleX -= 0.15F * ease;
        this.leftRibcage.rotateAngleX  -= 0.15F * ease;

        this.body.rotateAngleX -= 0.25F * ease;
    }

    private void animateSonicBoom(float progress) {

        float ease = MathHelper.sin(progress * (float)Math.PI);

        this.body.rotateAngleX -= 0.35F * ease;

        this.rightArm.rotateAngleX -= 1.6F * ease;
        this.leftArm.rotateAngleX  -= 1.6F * ease;
        this.rightArm.rotateAngleZ += 0.25F * ease;
        this.leftArm.rotateAngleZ  -= 0.25F * ease;

        this.head.rotateAngleX -= 0.15F * ease;

        this.rightTendril.rotateAngleX -= 0.6F * ease;
        this.leftTendril.rotateAngleX  -= 0.6F * ease;

        this.rightRibcage.rotateAngleY += 0.2F * ease;
        this.leftRibcage.rotateAngleY  -= 0.2F * ease;
    }

    private void animateWalk(float limbSwing, float limbSwingAmount) {

        float f  = Math.min(0.5F, 3.0F * limbSwingAmount);
        float f1 = limbSwing * 0.8662F;
        float f2 = MathHelper.cos(f1);
        float f3 = MathHelper.sin(f1);
        float f4 = Math.min(0.35F, f);

        this.head.rotateAngleZ += 0.3F * f3 * f;
        this.head.rotateAngleX += 1.2F * MathHelper.cos(f1 + ((float)Math.PI / 2F)) * f4;

        this.body.rotateAngleZ = 0.1F * f3 * f;
        this.body.rotateAngleX = 1.0F * f2 * f4;

        this.leftLeg.rotateAngleX = 1.0F * f2 * f;
        this.rightLeg.rotateAngleX = 1.0F * MathHelper.cos(f1 + (float)Math.PI) * f;

        this.leftArm.rotateAngleX = -(0.8F * f2 * f);
        this.rightArm.rotateAngleX = -(0.8F * f3 * f);

        resetArmPositions();
    }

    private void animateAttack(float progress) {

        float swing = MathHelper.sin(progress * (float)Math.PI);

        this.rightArm.rotateAngleX -= 2.6F * swing;
        this.leftArm.rotateAngleX  -= 2.0F * swing;

        this.body.rotateAngleX -= 0.55F * swing;

        this.head.rotateAngleX -= 0.35F * swing;
    }

    private void animateTendrils(float ageInTicks) {
        float sway = MathHelper.cos(ageInTicks * 0.1F) * 0.15F;

        this.leftTendril.rotateAngleX = sway;
        this.rightTendril.rotateAngleX = -sway;
    }

    private void resetArmPositions() {

        this.leftArm.rotateAngleY = 0.0F;
        this.leftArm.rotationPointX = 13.0F;
        this.leftArm.rotationPointY = -13.0F;
        this.leftArm.rotationPointZ = 1.0F;

        this.rightArm.rotateAngleY = 0.0F;
        this.rightArm.rotationPointX = -13.0F;
        this.rightArm.rotationPointY = -13.0F;
        this.rightArm.rotationPointZ = 1.0F;
    }

    private void resetPose() {

        this.head.rotateAngleX = 0.0F;
        this.head.rotateAngleY = 0.0F;
        this.head.rotateAngleZ = 0.0F;

        this.body.rotateAngleX = 0.0F;
        this.body.rotateAngleY = 0.0F;
        this.body.rotateAngleZ = 0.0F;

        this.leftArm.rotateAngleX = 0.0F;
        this.leftArm.rotateAngleY = 0.0F;
        this.leftArm.rotateAngleZ = 0.0F;

        this.rightArm.rotateAngleX = 0.0F;
        this.rightArm.rotateAngleY = 0.0F;
        this.rightArm.rotateAngleZ = 0.0F;

        this.leftLeg.rotateAngleX = 0.0F;
        this.rightLeg.rotateAngleX = 0.0F;

        this.leftTendril.rotateAngleX = 0.0F;
        this.rightTendril.rotateAngleX = 0.0F;

        this.rightRibcage.rotateAngleX = 0.0F;
        this.rightRibcage.rotateAngleY = 0.0F;
        this.rightRibcage.rotateAngleZ = RIBCAGE_CLOSED_Z;

        this.leftRibcage.rotateAngleX = 0.0F;
        this.leftRibcage.rotateAngleY = 0.0F;
        this.leftRibcage.rotateAngleZ = RIBCAGE_CLOSED_Z;
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);

        this.body.render(scale);
        this.leftLeg.render(scale);
        this.rightLeg.render(scale);
    }
}
