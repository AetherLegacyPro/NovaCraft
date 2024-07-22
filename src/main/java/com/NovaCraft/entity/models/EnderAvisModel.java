package com.NovaCraft.entity.models;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLiving;
import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityEnderAvis;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class EnderAvisModel extends ModelBase
{
    public ModelRenderer body;
    public ModelRenderer neck;
    public ModelRenderer bodyTailM;
    public ModelRenderer bodyTailL;
    public ModelRenderer bodyTailR;
    public ModelRenderer head;
    public ModelRenderer headTailM;
    public ModelRenderer beak1;
    public ModelRenderer beak2;
    public ModelRenderer rightLeg;
    public ModelRenderer leftLeg;
    public ModelRenderer rightFoot;
    public ModelRenderer leftFoot;
    public ModelRenderer leftWingBone;
    public ModelRenderer leftWing;
    public ModelRenderer rightWingBone;
    public ModelRenderer rightWing;
    public ModelRenderer headTailL;
    public ModelRenderer headTailR;
    public ModelRenderer collar;
    public boolean isFlying;
    public int ticksFlying;
    public double motionY;
    public boolean isTamed;
    public boolean isSitting;
    public float[] collarClr;
    
    //Credit goes to the Ender Stuff Plus Mod Author
    public EnderAvisModel() {
        this.isFlying = false;
        this.ticksFlying = 0;
        this.motionY = 0.0;
        this.isTamed = false;
        this.isSitting = false;
        this.collarClr = new float[3];
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.body = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -3.0f, -8.0f, 8, 6, 16);
        this.body.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = false;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase)this, 8, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 9, 2);
        this.neck.setRotationPoint(0.0f, 6.0f, -7.0f);
        this.neck.setTextureSize(64, 32);
        this.neck.mirror = false;
        this.setRotation(this.neck, -2.530727f, 0.0f, 0.0f);
        (this.bodyTailM = new ModelRenderer((ModelBase)this, -8, 0)).addBox(-0.5f, 0.0f, 0.0f, 1, 0, 8);
        this.bodyTailM.setRotationPoint(0.0f, 5.0f, 8.0f);
        this.bodyTailM.setTextureSize(64, 32);
        this.bodyTailM.mirror = false;
        this.setRotation(this.bodyTailM, 0.5235988f, 0.0f, 0.0f);
        (this.bodyTailL = new ModelRenderer((ModelBase)this, -8, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 0, 8);
        this.bodyTailL.setRotationPoint(0.0f, 5.0f, 8.0f);
        this.bodyTailL.setTextureSize(64, 32);
        this.bodyTailL.mirror = false;
        this.setRotation(this.bodyTailL, 0.5235988f, 0.5235988f, 0.3490659f);
        (this.bodyTailR = new ModelRenderer((ModelBase)this, -8, 0)).addBox(-1.0f, 0.0f, 0.0f, 1, 0, 8);
        this.bodyTailR.setRotationPoint(0.0f, 5.0f, 8.0f);
        this.bodyTailR.setTextureSize(64, 32);
        this.bodyTailR.mirror = false;
        this.setRotation(this.bodyTailR, 0.5235988f, -0.5235988f, -0.3490659f);
        (this.head = new ModelRenderer((ModelBase)this, 32, 6)).addBox(-2.0f, -3.0f, -3.0f, 4, 4, 6);
        this.head.setRotationPoint(0.0f, -1.0f, -12.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = false;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.headTailM = new ModelRenderer((ModelBase)this, -4, 12)).addBox(-0.5f, 0.0f, 4.0f, 1, 0, 4);
        this.headTailM.setRotationPoint(0.0f, -1.0f, -12.0f);
        this.headTailM.setTextureSize(64, 32);
        this.headTailM.mirror = false;
        this.setRotation(this.headTailM, 0.7853982f, 0.0f, 0.0f);
        (this.beak1 = new ModelRenderer((ModelBase)this, 8, 12)).addBox(-1.0f, -2.0f, -5.0f, 2, 2, 2);
        this.beak1.setRotationPoint(0.0f, -1.0f, -12.0f);
        this.beak1.setTextureSize(64, 32);
        this.beak1.mirror = false;
        this.setRotation(this.beak1, 0.0f, 0.0f, 0.0f);
        (this.beak2 = new ModelRenderer((ModelBase)this, 6, 12)).addBox(-0.5f, -1.5f, -6.0f, 1, 1, 1);
        this.beak2.setRotationPoint(0.0f, -1.0f, -12.0f);
        this.beak2.setTextureSize(64, 32);
        this.beak2.mirror = false;
        this.setRotation(this.beak2, 0.0f, 0.0f, 0.0f);
        (this.rightLeg = new ModelRenderer((ModelBase)this, 2, 0)).addBox(-0.5f, 0.0f, -0.5f, 1, 14, 1);
        this.rightLeg.setRotationPoint(-2.0f, 10.0f, 0.0f);
        this.rightLeg.setTextureSize(64, 32);
        this.rightLeg.mirror = true;
        this.setRotation(this.rightLeg, 0.0f, 0.0f, 0.0f);
        (this.leftLeg = new ModelRenderer((ModelBase)this, 2, 0)).addBox(-0.5f, 0.0f, -0.5f, 1, 14, 1);
        this.leftLeg.setRotationPoint(2.0f, 10.0f, 0.0f);
        this.leftLeg.setTextureSize(64, 32);
        this.leftLeg.mirror = false;
        this.setRotation(this.leftLeg, 0.0f, 0.0f, 0.0f);
        (this.rightFoot = new ModelRenderer((ModelBase)this, 27, 0)).addBox(-1.5f, 14.0f, -3.0f, 3, 0, 5);
        this.rightFoot.setRotationPoint(-2.0f, 10.0f, 0.0f);
        this.rightFoot.setTextureSize(64, 32);
        this.rightFoot.mirror = true;
        this.setRotation(this.rightFoot, 0.0f, 0.0f, 0.0f);
        (this.leftFoot = new ModelRenderer((ModelBase)this, 27, 0)).addBox(-1.5f, 14.0f, -3.0f, 3, 0, 5);
        this.leftFoot.setRotationPoint(2.0f, 10.0f, 0.0f);
        this.leftFoot.setTextureSize(64, 32);
        this.leftFoot.mirror = false;
        this.setRotation(this.leftFoot, 0.0f, 0.0f, 0.0f);
        (this.leftWingBone = new ModelRenderer((ModelBase)this, 0, 22)).addBox(0.0f, 0.0f, -1.0f, 12, 1, 1);
        this.leftWingBone.setRotationPoint(4.0f, 6.0f, -5.0f);
        this.leftWingBone.setTextureSize(64, 32);
        this.leftWingBone.mirror = false;
        this.setRotation(this.leftWingBone, 0.0f, -1.5707964f, 0.0f);
        (this.leftWing = new ModelRenderer((ModelBase)this, -8, 24)).addBox(-0.5f, 0.5f, 0.0f, 12, 0, 8);
        this.leftWing.setRotationPoint(4.0f, 6.0f, -5.0f);
        this.leftWing.setTextureSize(64, 32);
        this.leftWing.mirror = true;
        this.setRotation(this.leftWing, 0.0f, -1.5707964f, 0.0f);
        (this.rightWingBone = new ModelRenderer((ModelBase)this, 0, 22)).addBox(-12.0f, 0.0f, -1.0f, 12, 1, 1);
        this.rightWingBone.setRotationPoint(-4.0f, 6.0f, -5.0f);
        this.rightWingBone.setTextureSize(64, 32);
        this.rightWingBone.mirror = false;
        this.setRotation(this.rightWingBone, 0.0f, 1.5707964f, 0.0f);
        (this.rightWing = new ModelRenderer((ModelBase)this, 16, 24)).addBox(-11.5f, 0.5f, 0.0f, 12, 0, 8);
        this.rightWing.setRotationPoint(-4.0f, 6.0f, -5.0f);
        this.rightWing.setTextureSize(64, 32);
        this.rightWing.mirror = false;
        this.setRotation(this.rightWing, 0.0f, 1.5707964f, 0.0f);
        (this.headTailL = new ModelRenderer((ModelBase)this, -4, 12)).addBox(-0.5f, 0.0f, 4.0f, 1, 0, 4);
        this.headTailL.setRotationPoint(0.0f, -1.0f, -12.0f);
        this.headTailL.setTextureSize(64, 32);
        this.headTailL.mirror = false;
        this.setRotation(this.headTailL, 0.7853982f, 0.2617994f, 0.2617994f);
        (this.headTailR = new ModelRenderer((ModelBase)this, -4, 12)).addBox(-0.5f, 0.0f, 4.0f, 1, 0, 4);
        this.headTailR.setRotationPoint(0.0f, -1.0f, -12.0f);
        this.headTailR.setTextureSize(64, 32);
        this.headTailR.mirror = false;
        this.setRotation(this.headTailR, 0.7853982f, -0.2617994f, -0.2617994f);
        (this.collar = new ModelRenderer((ModelBase)this, 38, 0)).addBox(-1.0f, 3.0f, -1.8f, 2, 3, 2);
        this.collar.setRotationPoint(0.0f, 6.0f, -7.0f);
        this.collar.setTextureSize(64, 32);
        this.collar.mirror = false;
        this.setRotation(this.collar, -2.530727f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    	EntityEnderAvis avis = ((EntityEnderAvis) entity);
        if(avis.isChild()) {
        	
        	GL11.glScalef(1.0F / 2.0F, 1.0F / 2.0F, 1.0F / 2.0F);
			GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
        	
        }
    	
    	this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        final float yPos = this.isSitting ? 11.5f : 0.0f;
        this.body.setRotationPoint(0.0f, 8.0f + yPos, 0.0f);
        this.neck.setRotationPoint(0.0f, 6.0f + yPos, -7.0f);
        this.bodyTailM.setRotationPoint(0.0f, 5.0f + yPos, 8.0f);
        this.bodyTailL.setRotationPoint(0.0f, 5.0f + yPos, 8.0f);
        this.bodyTailR.setRotationPoint(0.0f, 5.0f + yPos, 8.0f);
        this.head.setRotationPoint(0.0f, -1.0f + yPos, -12.0f);
        this.headTailM.setRotationPoint(0.0f, -1.0f + yPos, -12.0f);
        this.beak1.setRotationPoint(0.0f, -1.0f + yPos, -12.0f);
        this.beak2.setRotationPoint(0.0f, -1.0f + yPos, -12.0f);
        this.leftWingBone.setRotationPoint(4.0f, 6.0f + yPos, -5.0f);
        this.leftWing.setRotationPoint(4.0f, 6.0f + yPos, -5.0f);
        this.rightWingBone.setRotationPoint(-4.0f, 6.0f + yPos, -5.0f);
        this.rightWing.setRotationPoint(-4.0f, 6.0f + yPos, -5.0f);
        this.headTailL.setRotationPoint(0.0f, -1.0f + yPos, -12.0f);
        this.headTailR.setRotationPoint(0.0f, -1.0f + yPos, -12.0f);
        this.collar.setRotationPoint(0.0f, 6.0f + yPos, -7.0f + (this.isSitting ? 0.8f : 0.0f));
        this.body.render(f5);
        this.neck.render(f5);
        this.bodyTailM.render(f5);
        this.bodyTailL.render(f5);
        this.bodyTailR.render(f5);
        this.head.render(f5);
        this.headTailM.render(f5);
        this.beak1.render(f5);
        this.beak2.render(f5);
        if (!this.isSitting) {
            this.rightLeg.render(f5);
            this.leftLeg.render(f5);
            this.rightFoot.render(f5);
            this.leftFoot.render(f5);
        }
        this.leftWingBone.render(f5);
        this.leftWing.render(f5);
        this.rightWingBone.render(f5);
        this.rightWing.render(f5);
        this.headTailL.render(f5);
        this.headTailR.render(f5);
        if (this.isTamed) {
            GL11.glPushMatrix();
            if (entity instanceof EntityLiving && ((EntityLiving)entity).hurtTime <= 0) {
                GL11.glColor3f(this.collarClr[0], this.collarClr[1], this.collarClr[2]);
            }
            GL11.glScalef(1.1f, 1.1f, 1.1f);
            this.collar.render(f5);
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
        }
               
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity e) {
        this.head.rotateAngleY = f3 / 57.295776f;
        this.head.rotateAngleX = f4 / 57.295776f;
        final ModelRenderer beak1 = this.beak1;
        final ModelRenderer beak2 = this.beak2;
        final float rotateAngleY = this.head.rotateAngleY;
        beak2.rotateAngleY = rotateAngleY;
        beak1.rotateAngleY = rotateAngleY;
        final ModelRenderer beak3 = this.beak1;
        final ModelRenderer beak4 = this.beak2;
        final float rotateAngleX = this.head.rotateAngleX;
        beak4.rotateAngleX = rotateAngleX;
        beak3.rotateAngleX = rotateAngleX;
        this.headTailM.rotateAngleY = this.head.rotateAngleY;
        this.headTailM.rotateAngleX = 0.7853982f + this.head.rotateAngleX;
        this.headTailL.rotateAngleY = 0.2617994f + this.head.rotateAngleY;
        this.headTailL.rotateAngleX = 0.7853982f + this.head.rotateAngleX;
        this.headTailR.rotateAngleY = -0.2617994f + this.head.rotateAngleY;
        this.headTailR.rotateAngleX = 0.7853982f + this.head.rotateAngleX;
        this.rightWingBone.rotateAngleY = 1.5707964f - 1.5707964f * (this.ticksFlying / 5.0f);
        this.rightWing.rotateAngleY = 1.5707964f - 1.5707964f * (this.ticksFlying / 5.0f);
        this.leftWingBone.rotateAngleY = -1.5707964f + 1.5707964f * (this.ticksFlying / 5.0f);
        this.leftWing.rotateAngleY = -1.5707964f + 1.5707964f * (this.ticksFlying / 5.0f);
       // if (this.isFlying) {
            //if (this.ticksFlying >= 5) {
                this.rightWing.rotateAngleZ = -f2 - 2.7f;
                this.leftWing.rotateAngleZ = f2 + 2.7f;
                this.rightWingBone.rotateAngleZ = -f2 - 2.7f;
                this.leftWingBone.rotateAngleZ = f2 + 2.7f;
           // }
            final ModelRenderer rightLeg = this.rightLeg;
            rightLeg.rotateAngleX *= 0.8f;
            final ModelRenderer leftLeg = this.leftLeg;
            leftLeg.rotateAngleX *= 0.8f;
            final ModelRenderer rightFoot = this.rightFoot;
            rightFoot.rotateAngleX *= 0.8f;
            final ModelRenderer leftFoot = this.leftFoot;
            leftFoot.rotateAngleX *= 0.8f;
       // }
       // else {
          // this.rightWing.rotateAngleZ = 0.0f;
          //  this.rightWingBone.rotateAngleZ = 0.0f;
          //  this.leftWing.rotateAngleZ = 0.0f;
          //  this.leftWingBone.rotateAngleZ = 0.0f;
            this.rightLeg.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
            this.leftLeg.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
            this.rightFoot.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
            this.leftFoot.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
       // }
    }
}
