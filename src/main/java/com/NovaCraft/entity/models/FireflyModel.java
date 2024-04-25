package com.NovaCraft.entity.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class FireflyModel extends ModelBase
{
    ModelRenderer Head;
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Wing1;
    ModelRenderer Wing2;
    
    public FireflyModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-0.5f, 0.0f, -1.5f, 1, 1, 1);
        this.Head.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.3316126f, 0.0f, 0.0f);
        (this.Body1 = new ModelRenderer((ModelBase)this, 0, 2)).addBox(-1.0f, 0.0f, -0.5f, 2, 1, 2);
        this.Body1.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.Body1.setTextureSize(64, 32);
        this.Body1.mirror = true;
        this.setRotation(this.Body1, 0.0f, 0.0f, 0.0f);
        (this.Body2 = new ModelRenderer((ModelBase)this, 0, 5)).addBox(-1.0f, 0.0f, 1.5f, 2, 1, 3);
        this.Body2.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.Body2.setTextureSize(64, 32);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, -0.122173f, 0.0f, 0.0f);
        (this.Wing1 = new ModelRenderer((ModelBase)this, 0, 9)).addBox(0.0f, 0.0f, -1.0f, 4, 1, 2);
        this.Wing1.setRotationPoint(0.0f, 22.0f, 1.0f);
        this.Wing1.setTextureSize(64, 32);
        this.Wing1.mirror = true;
        this.setRotation(this.Wing1, 0.0f, -0.4363323f, -0.2617994f);
        (this.Wing2 = new ModelRenderer((ModelBase)this, 0, 9)).addBox(-4.0f, 0.0f, -1.0f, 4, 1, 2);
        this.Wing2.setRotationPoint(0.0f, 22.0f, 1.0f);
        this.Wing2.setTextureSize(64, 32);
        this.Wing2.mirror = true;
        this.setRotation(this.Wing2, 0.0f, 0.4363323f, 0.2617994f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.render(f5);
        this.Body1.render(f5);
        this.Body2.render(f5);
        this.Wing1.render(f5);
        this.Wing2.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Wing1.rotateAngleZ = MathHelper.cos(f3 + 3.1415927f);
        this.Wing2.rotateAngleZ = MathHelper.cos(f3);
    }
}
