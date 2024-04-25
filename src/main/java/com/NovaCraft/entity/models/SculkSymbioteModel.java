package com.NovaCraft.entity.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class SculkSymbioteModel extends ModelBase
{
    ModelRenderer Head;
    ModelRenderer Tooth1;
    ModelRenderer Piece1;
    ModelRenderer Piece2;
    ModelRenderer Tooth2;
    ModelRenderer Tooth3;
    ModelRenderer Tooth4;
    ModelRenderer Piece3;
    ModelRenderer Piece4;
    ModelRenderer Piece5;
    ModelRenderer Piece6;
    ModelRenderer Piece7;
    ModelRenderer Piece8;
    
    public SculkSymbioteModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        final float f = 0.1f;
        (this.Head = new ModelRenderer((ModelBase)this, 0, 10)).addBox(-2.0f, -2.0f, -2.0f, 4, 4, 4);
        this.Head.setRotationPoint(0.0f, 21.0f, -10.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Tooth1 = new ModelRenderer((ModelBase)this, 8, 0)).addBox(1.0f, 1.0f, -3.0f, 1, 1, 2);
        this.Tooth1.setRotationPoint(0.0f, 21.0f, -10.0f);
        this.Tooth1.setTextureSize(64, 32);
        this.Tooth1.mirror = true;
        this.setRotation(this.Tooth1, -0.122173f, 0.122173f, 0.0f);
        (this.Tooth2 = new ModelRenderer((ModelBase)this, 8, 0)).addBox(-2.0f, 1.0f, -3.0f, 1, 1, 2);
        this.Tooth2.setRotationPoint(0.0f, 21.0f, -10.0f);
        this.Tooth2.setTextureSize(64, 32);
        this.Tooth2.mirror = true;
        this.setRotation(this.Tooth2, -0.122173f, -0.122173f, 0.0f);
        (this.Tooth3 = new ModelRenderer((ModelBase)this, 8, 0)).addBox(-2.0f, -2.0f, -3.0f, 1, 1, 2);
        this.Tooth3.setRotationPoint(0.0f, 21.0f, -10.0f);
        this.Tooth3.setTextureSize(64, 32);
        this.Tooth3.mirror = true;
        this.setRotation(this.Tooth3, 0.122173f, -0.122173f, 0.0f);
        (this.Tooth4 = new ModelRenderer((ModelBase)this, 8, 0)).addBox(1.0f, -2.0f, -3.0f, 1, 1, 2);
        this.Tooth4.setRotationPoint(0.0f, 21.0f, -10.0f);
        this.Tooth4.setTextureSize(64, 32);
        this.Tooth4.mirror = true;
        this.setRotation(this.Tooth4, 0.122173f, 0.122173f, 0.0f);
        (this.Piece1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2);
        this.Piece1.setRotationPoint(0.0f, 21.0f, -8.0f + f);
        this.Piece1.setTextureSize(64, 32);
        this.Piece1.mirror = true;
        this.setRotation(this.Piece1, 0.0f, 0.0f, 0.0f);
        (this.Piece2 = new ModelRenderer((ModelBase)this, 0, 4)).addBox(-1.5f, -1.5f, 2.0f, 3, 3, 3);
        this.Piece2.setRotationPoint(0.0f, 21.0f, -8.0f + f);
        this.Piece2.setTextureSize(64, 32);
        this.Piece2.mirror = true;
        this.setRotation(this.Piece2, 0.0f, 0.0f, 0.0f);
        (this.Piece3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0f, -1.0f, 5.0f, 2, 2, 2);
        this.Piece3.setRotationPoint(0.0f, 21.0f, -8.0f + f);
        this.Piece3.setTextureSize(64, 32);
        this.Piece3.mirror = true;
        this.setRotation(this.Piece3, 0.0f, 0.0f, 0.0f);
        (this.Piece4 = new ModelRenderer((ModelBase)this, 0, 4)).addBox(-1.5f, -1.5f, 7.0f, 3, 3, 3);
        this.Piece4.setRotationPoint(0.0f, 21.0f, -8.0f + f);
        this.Piece4.setTextureSize(64, 32);
        this.Piece4.mirror = true;
        this.setRotation(this.Piece4, 0.0f, 0.0f, 0.0f);
        (this.Piece5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0f, -1.0f, 10.0f, 2, 2, 2);
        this.Piece5.setRotationPoint(0.0f, 21.0f, -8.0f + f);
        this.Piece5.setTextureSize(64, 32);
        this.Piece5.mirror = true;
        this.setRotation(this.Piece5, 0.0f, 0.0f, 0.0f);
        (this.Piece6 = new ModelRenderer((ModelBase)this, 0, 4)).addBox(-1.5f, -1.5f, 12.0f, 3, 3, 3);
        this.Piece6.setRotationPoint(0.0f, 21.0f, -8.0f + f);
        this.Piece6.setTextureSize(64, 32);
        this.Piece6.mirror = true;
        this.setRotation(this.Piece6, 0.0f, 0.0f, 0.0f);
        (this.Piece7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0f, -1.0f, 15.0f, 2, 2, 2);
        this.Piece7.setRotationPoint(0.0f, 21.0f, -8.0f + f);
        this.Piece7.setTextureSize(64, 32);
        this.Piece7.mirror = true;
        this.setRotation(this.Piece7, 0.0f, 0.0f, 0.0f);
        (this.Piece8 = new ModelRenderer((ModelBase)this, 14, 0)).addBox(-0.5f, -0.5f, 17.0f, 1, 1, 3);
        this.Piece8.setRotationPoint(0.0f, 21.0f, -8.0f + f);
        this.Piece8.setTextureSize(64, 32);
        this.Piece8.mirror = true;
        this.setRotation(this.Piece8, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.render(f5);
        this.Tooth1.render(f5);
        this.Piece1.render(f5);
        this.Piece2.render(f5);
        this.Tooth2.render(f5);
        this.Tooth3.render(f5);
        this.Tooth4.render(f5);
        this.Piece3.render(f5);
        this.Piece4.render(f5);
        this.Piece5.render(f5);
        this.Piece6.render(f5);
        this.Piece7.render(f5);
        this.Piece8.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
    	final float f11 = (0.5f + Math.max(f4, f5 - 1.0f)) * 0.25f;
        final float f21 = f3 * 0.6662f;
        this.Piece1.rotateAngleY = MathHelper.sin(f21 - 0.75f) * f11;
        this.Piece2.rotateAngleY = MathHelper.sin(f21 - 1.05f) * f11;
        this.Piece3.rotateAngleY = MathHelper.sin(f21 - 1.33125f) * f11;
        this.Piece4.rotateAngleY = MathHelper.sin(f21 - 1.59375f) * f11;
        this.Piece5.rotateAngleY = MathHelper.sin(f21 - 1.8375001f) * f11;
        this.Piece6.rotateAngleY = MathHelper.sin(f21 - 2.0625f) * f11;
        this.Piece7.rotateAngleY = MathHelper.sin(f21 - 2.2687502f) * f11;
        this.Piece8.rotateAngleY = MathHelper.sin(f21 - 2.4562502f) * f11;
    }
    
   // public void setRotationAngles(final EntityLiving par1EntityLiving, final float par2, final float par3, final float par4) {
    //    final float f1 = (0.5f + Math.max(par3, par4 - 1.0f)) * 0.25f;
    //    final float f2 = par2 * 0.6662f;
    //    this.Piece1.rotateAngleY = MathHelper.cos(f2 - 0.75f) * f1;
    //    this.Piece2.rotateAngleY = MathHelper.cos(f2 - 1.05f) * f1;
    //    this.Piece3.rotateAngleY = MathHelper.cos(f2 - 1.33125f) * f1;
     //   this.Piece4.rotateAngleY = MathHelper.cos(f2 - 1.59375f) * f1;
     //   this.Piece5.rotateAngleY = MathHelper.cos(f2 - 1.8375001f) * f1;
     //   this.Piece6.rotateAngleY = MathHelper.cos(f2 - 2.0625f) * f1;
     //   this.Piece7.rotateAngleY = MathHelper.cos(f2 - 2.2687502f) * f1;
     //   this.Piece8.rotateAngleY = MathHelper.cos(f2 - 2.4562502f) * f1;
   // }
    
}
