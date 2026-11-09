package com.NovaCraft.entity.models;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class BlazingChargerModel extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape21;
    ModelRenderer Shape211;
    ModelRenderer Shape2;
    ModelRenderer Shape2111;
    ModelRenderer Shape3;
    ModelRenderer Shape41;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Spike1;
    ModelRenderer Spike2;
    ModelRenderer Spike3;
    
    public BlazingChargerModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 34, 38)).addBox(0.0f, 0.0f, 0.0f, 13, 13, 13);
        this.Shape1.setRotationPoint(-7.0f, 1.0f, -8.0f);
        this.Shape1.setTextureSize(128, 64);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0892287f, 0.0f, 0.0f);
        
        
        (this.Shape21 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 11, 4);
        this.Shape21.setRotationPoint(-6.0f, 13.0f, 9.0f);
        this.Shape21.setTextureSize(128, 64);
        this.Shape21.mirror = true;
        this.setRotation(this.Shape21, 0.0f, 0.0f, 0.0f);
        (this.Shape211 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 11, 4);
        this.Shape211.setRotationPoint(1.0f, 13.0f, 9.0f);
        this.Shape211.setTextureSize(128, 64);
        this.Shape211.mirror = true;
        this.setRotation(this.Shape211, 0.0f, 0.0f, 0.0f);
        (this.Shape2111 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 11, 4);
        this.Shape2111.setRotationPoint(1.0f, 13.0f, -6.0f);
        this.Shape2111.setTextureSize(128, 64);
        this.Shape2111.mirror = true;
        this.setRotation(this.Shape21, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 10.0f, -1.0f, 4, 11, 4);
        this.Shape2.setRotationPoint(-6.0f, 3.0f, -5.0f);
        this.Shape2.setTextureSize(128, 64);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 91, 48)).addBox(0.5f, 0.0f, 0.0f, 10, 10, 6);
        this.Shape3.setRotationPoint(-6.0f, 0.0f, 4.0f);
        this.Shape3.setTextureSize(128, 64);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, -0.237943f, 0.0f, 0.0f);
        (this.Shape41 = new ModelRenderer((ModelBase)this, 5, 49)).addBox(0.0f, 0.0f, 0.0f, 7, 8, 7);
        this.Shape41.setRotationPoint(-4.0f, 1.0f, -12.0f);
        this.Shape41.setTextureSize(128, 64);
        this.Shape41.mirror = true;
        this.setRotation(this.Shape41, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 1, 42)).addBox(0.5f, 0.0f, 0.0f, 4, 4, 2);
        this.Shape4.setRotationPoint(-3.0f, 4.0f, -14.0f);
        this.Shape4.setTextureSize(128, 64);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape41, 0.0f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 13, 29)).addBox(-0.5f, 0.0f, 0.0f, 6, 2, 6);
        this.Shape5.setRotationPoint(-3.0f, 1.0f, -9.0f);
        this.Shape5.setTextureSize(128, 64);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.178457f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 41, 0)).addBox(0.0f, 0.0f, -0.3f, 13, 12, 9);
        this.Shape6.setRotationPoint(-7.0f, 2.0f, 7.0f);
        this.Shape6.setTextureSize(128, 64);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, -0.0594858f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 116, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 2);
        this.Shape7.setRotationPoint(3.0f, 1.0f, -11.0f);
        this.Shape7.setTextureSize(128, 64);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, 0.0f, 0.0f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase)this, 116, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 2, 2);
        this.Shape8.setRotationPoint(-8.0f, 1.0f, -11.0f);
        this.Shape8.setTextureSize(128, 64);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, 0.0f, 0.0f, 0.0f);
        (this.Shape9 = new ModelRenderer((ModelBase)this, 98, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 6);
        this.Shape9.setRotationPoint(7.0f, 1.0f, -15.0f);
        this.Shape9.setTextureSize(128, 64);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, 0.0f, 0.0f, 0.0f);
        (this.Shape10 = new ModelRenderer((ModelBase)this, 98, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 6);
        this.Shape10.setRotationPoint(-10.0f, 1.0f, -15.0f);
        this.Shape10.setTextureSize(128, 64);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, 0.0f, 0.0f, 0.0f);
        (this.Spike1 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-0.5f, 0.0f, 0.0f, 2, 6, 2);
        this.Spike1.setRotationPoint(-1.0f, -5.0f, -5.0f);
        this.Spike1.setTextureSize(128, 64);
        this.Spike1.mirror = true;
        this.setRotation(this.Spike1, -0.2974289f, 0.0f, 0.0f);
        (this.Spike2 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-0.5f, 0.0f, 0.0f, 2, 6, 2);
        this.Spike2.setRotationPoint(-1.0f, -4.0f, 0.0f);
        this.Spike2.setTextureSize(128, 64);
        this.Spike2.mirror = true;
        this.setRotation(this.Spike2, -0.2974289f, 0.0f, 0.0f);
        (this.Spike3 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-0.5f, 0.0f, 0.0f, 2, 6, 2);
        this.Spike3.setRotationPoint(-1.0f, -3.0f, 5.0f);
        this.Spike3.setTextureSize(128, 64);
        this.Spike3.mirror = true;
        this.setRotation(this.Spike3, -0.2974289f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape21.render(f5);
        this.Shape211.render(f5);
        this.Shape2111.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape41.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.Shape7.render(f5);
        this.Shape8.render(f5);
        this.Shape9.render(f5);
        this.Shape10.render(f5);
        this.Spike1.render(f5);
        this.Spike2.render(f5);
        this.Spike3.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        final float f6 = 57.295776f;
        this.Shape21.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.Shape2.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.141593f) * 1.4f * f1;
        this.Shape211.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.141593f) * 1.4f * f1;
        this.Shape2111.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
    }
}
