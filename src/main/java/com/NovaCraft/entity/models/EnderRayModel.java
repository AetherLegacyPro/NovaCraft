package com.NovaCraft.entity.models;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class EnderRayModel extends ModelBase
{
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer body2;
    ModelRenderer righttail;
    ModelRenderer lefttail;
    
    public EnderRayModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        final float top = 4.0f;
        (this.body = new ModelRenderer((ModelBase)this, 0, 18)).addBox(-6.0f, -1.0f, -6.0f, 12, 2, 12);
        this.body.setRotationPoint(0.0f, 20.0f + top, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = false;
        this.setRotation(this.body, 0.0f, 0.7853982f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 33, 0)).addBox(-4.0f, -1.0f, -2.0f, 4, 1, 11);
        this.rightarm.setRotationPoint(-3.0f, 20.5f + top, -5.0f);
        this.rightarm.setTextureSize(64, 32);
        this.rightarm.mirror = false;
        this.setRotation(this.rightarm, 0.0f, -0.7853982f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 33, 0)).addBox(0.0f, -1.0f, -2.0f, 4, 1, 11);
        this.leftarm.setRotationPoint(3.0f, 20.5f + top, -5.0f);
        this.leftarm.setTextureSize(64, 32);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0f, 0.7853982f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 37, 12)).addBox(-2.0f, -1.0f, 0.0f, 2, 1, 11);
        this.rightleg.setRotationPoint(-1.0f, 20.5f + top, 5.0f);
        this.rightleg.setTextureSize(64, 32);
        this.setRotation(this.rightleg, 0.0f, 0.0523599f, 0.0f);
        this.rightleg.mirror = false;
        (this.leftleg = new ModelRenderer((ModelBase)this, 33, 0)).addBox(0.0f, -1.0f, -2.0f, 4, 1, 11);
        this.leftleg.setRotationPoint(6.0f, 20.5f + top, 2.0f);
        this.leftleg.setTextureSize(64, 32);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, -0.3316126f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-5.0f, -2.0f, -4.0f, 9, 2, 9);
        this.body2.setRotationPoint(0.0f, 20.0f + top, 0.0f);
        this.body2.setTextureSize(64, 32);
        this.body2.mirror = false;
        this.setRotation(this.body2, 0.0f, 0.7853982f, 0.0f);
        (this.righttail = new ModelRenderer((ModelBase)this, 33, 0)).addBox(-4.0f, -1.0f, -2.0f, 4, 1, 11);
        this.righttail.setRotationPoint(-6.0f, 20.5f + top, 2.0f);
        this.righttail.setTextureSize(64, 32);
        this.setRotation(this.righttail, 0.0f, 0.3316126f, 0.0f);
        this.righttail.mirror = false;
        (this.lefttail = new ModelRenderer((ModelBase)this, 37, 12)).addBox(0.0f, -1.0f, 0.0f, 2, 1, 11);
        this.lefttail.setRotationPoint(1.0f, 20.5f + top, 5.0f);
        this.lefttail.setTextureSize(64, 32);
        this.lefttail.mirror = true;
        this.setRotation(this.lefttail, 0.0f, -0.0523599f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.body2.render(f5);
        this.righttail.render(f5);
        this.lefttail.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity e) {
        this.lefttail.rotateAngleX = 0.1f * MathHelper.sin(f2 * 0.1f) + 0.0f;
        this.rightleg.rotateAngleX = -0.1f * MathHelper.sin(f2 * 0.1f + 0.7f) + 0.0f;
        this.righttail.rotateAngleY = 0.3f * MathHelper.sin(f2 * 0.1f) + 0.0f;
        this.leftleg.rotateAngleY = -0.3f * MathHelper.sin(f2 * 0.1f + 0.7f) + 0.0f;
    }
}

