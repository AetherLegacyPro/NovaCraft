package com.NovaCraft.entity.models;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityPhoenix;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class PhoenixModel extends ModelBase
{
	ModelRenderer HeadFlame1;
    ModelRenderer Beak2;
    ModelRenderer Body1;
    ModelRenderer WingFlame1;
    ModelRenderer WingMain2;
    ModelRenderer WingMain1;
    ModelRenderer WingSide2;
    ModelRenderer WingSide1;
    ModelRenderer WingFlame2;
    ModelRenderer Wing2;
    ModelRenderer Wing1;
    ModelRenderer Head;
    ModelRenderer HeadFlame2;
    ModelRenderer HeadFlame3;
    ModelRenderer TailBottom;
    ModelRenderer Body2;
    ModelRenderer Tail1;
    ModelRenderer TailSide1;
    ModelRenderer Tail2;
    ModelRenderer TailSide2;
    ModelRenderer Body3;
    ModelRenderer Beak1;
    
    public PhoenixModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.HeadFlame1 = new ModelRenderer((ModelBase)this, 52, 40)).addBox(0.0f, -4.0f, -1.0f, 0, 5, 9);
        this.HeadFlame1.setRotationPoint(0.0f, 7.0f, -3.0f);
        this.HeadFlame1.setTextureSize(128, 64);
        this.HeadFlame1.mirror = true;
        this.setRotation(this.HeadFlame1, 0.0785398f, 0.0f, 0.0f);
        (this.Beak2 = new ModelRenderer((ModelBase)this, 14, 44)).addBox(-1.5f, -1.0f, -6.0f, 3, 2, 3);
        this.Beak2.setRotationPoint(0.0f, 7.0f, -3.0f);
        this.Beak2.setTextureSize(128, 64);
        this.Beak2.mirror = true;
        this.setRotation(this.Beak2, 0.0f, 0.0f, 0.0f);
        (this.Body1 = new ModelRenderer((ModelBase)this, 64, 51)).addBox(-3.0f, 0.0f, -1.0f, 6, 2, 11);
        this.Body1.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.Body1.setTextureSize(128, 64);
        this.Body1.mirror = true;
        this.setRotation(this.Body1, -0.0872665f, 0.0f, 0.0f);
        (this.WingFlame1 = new ModelRenderer((ModelBase)this, 0, 3)).addBox(-13.0f, 0.0f, 0.7f, 13, 1, 10);
        this.WingFlame1.setRotationPoint(-3.0f, 8.0f, -3.0f);
        this.WingFlame1.setTextureSize(128, 64);
        this.WingFlame1.mirror = true;
        this.setRotation(this.WingFlame1, 0.0f, 0.0349066f, 0.0f);
        (this.WingMain2 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(0.0f, -1.0f, -0.5f, 15, 1, 1);
        this.WingMain2.setRotationPoint(3.0f, 8.0f, -3.0f);
        this.WingMain2.setTextureSize(128, 64);
        this.WingMain2.mirror = true;
        this.setRotation(this.WingMain2, 0.0f, 0.0f, 0.0f);
        (this.WingMain1 = new ModelRenderer((ModelBase)this, 0, 50)).addBox(-15.0f, -1.0f, -0.5f, 15, 1, 1);
        this.WingMain1.setRotationPoint(-3.0f, 8.0f, -3.0f);
        this.WingMain1.setTextureSize(128, 64);
        this.WingMain1.mirror = true;
        this.setRotation(this.WingMain1, 0.0f, 0.0f, 0.0f);
        (this.WingSide2 = new ModelRenderer((ModelBase)this, 0, 52)).addBox(0.0f, -0.7f, 0.0f, 14, 1, 1);
        this.WingSide2.setRotationPoint(3.0f, 8.0f, -3.0f);
        this.WingSide2.setTextureSize(128, 64);
        this.WingSide2.mirror = true;
        this.setRotation(this.WingSide2, 0.0f, -0.3665191f, 0.0f);
        (this.WingSide1 = new ModelRenderer((ModelBase)this, 0, 52)).addBox(-14.0f, -0.7f, 0.0f, 14, 1, 1);
        this.WingSide1.setRotationPoint(-3.0f, 8.0f, -3.0f);
        this.WingSide1.setTextureSize(128, 64);
        this.WingSide1.mirror = true;
        this.setRotation(this.WingSide1, 0.0f, 0.3665191f, 0.0f);
        (this.WingFlame2 = new ModelRenderer((ModelBase)this, 0, 3)).addBox(0.0f, 0.0f, 0.7f, 13, 1, 10);
        this.WingFlame2.setRotationPoint(3.0f, 8.0f, -3.0f);
        this.WingFlame2.setTextureSize(128, 64);
        this.WingFlame2.mirror = true;
        this.setRotation(this.WingFlame2, 0.0f, -0.0349066f, 0.0f);
        (this.Wing2 = new ModelRenderer((ModelBase)this, 0, 52)).addBox(0.0f, -0.7f, 0.0f, 14, 1, 1);
        this.Wing2.setRotationPoint(3.0f, 8.0f, -3.0f);
        this.Wing2.setTextureSize(128, 64);
        this.Wing2.mirror = true;
        this.setRotation(this.Wing2, 0.0f, -0.0349066f, 0.0f);
        (this.Wing1 = new ModelRenderer((ModelBase)this, 0, 52)).addBox(-14.0f, -0.7f, 0.0f, 14, 1, 1);
        this.Wing1.setRotationPoint(-3.0f, 8.0f, -3.0f);
        this.Wing1.setTextureSize(128, 64);
        this.Wing1.mirror = true;
        this.setRotation(this.Wing1, 0.0f, 0.0349066f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 0, 43)).addBox(-2.0f, -2.0f, -3.0f, 4, 3, 3);
        this.Head.setRotationPoint(0.0f, 7.0f, -3.0f);
        this.Head.setTextureSize(128, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.HeadFlame2 = new ModelRenderer((ModelBase)this, 40, 44)).addBox(1.0f, -3.0f, -1.0f, 0, 4, 6);
        this.HeadFlame2.setRotationPoint(0.0f, 7.0f, -3.0f);
        this.HeadFlame2.setTextureSize(128, 64);
        this.HeadFlame2.mirror = true;
        this.setRotation(this.HeadFlame2, 0.0698132f, 0.0f, 0.0f);
        (this.HeadFlame3 = new ModelRenderer((ModelBase)this, 40, 44)).addBox(-1.0f, -3.0f, -1.0f, 0, 4, 6);
        this.HeadFlame3.setRotationPoint(0.0f, 7.0f, -3.0f);
        this.HeadFlame3.setTextureSize(128, 64);
        this.HeadFlame3.mirror = true;
        this.setRotation(this.HeadFlame3, 0.0698132f, 0.0f, 0.0f);
        (this.TailBottom = new ModelRenderer((ModelBase)this, 34, 27)).addBox(0.0f, 1.0f, 9.0f, 0, 2, 8);
        this.TailBottom.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.TailBottom.setTextureSize(128, 64);
        this.TailBottom.mirror = true;
        this.setRotation(this.TailBottom, 0.0523599f, 0.0f, 0.0f);
        (this.Body2 = new ModelRenderer((ModelBase)this, 36, 54)).addBox(-3.0f, -1.0f, -4.0f, 6, 2, 8);
        this.Body2.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.Body2.setTextureSize(128, 64);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase)this, 0, 19)).addBox(-1.0f, -0.2f, 18.0f, 2, 1, 7);
        this.Tail1.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.Tail1.setTextureSize(128, 64);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.0f, 0.0f, 0.0f);
        (this.TailSide1 = new ModelRenderer((ModelBase)this, 46, 37)).addBox(0.5f, -1.0f, 4.0f, 1, 1, 11);
        this.TailSide1.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.TailSide1.setTextureSize(128, 64);
        this.TailSide1.mirror = true;
        this.setRotation(this.TailSide1, -0.0261799f, 0.1396263f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase)this, 18, 14)).addBox(-1.5f, 0.0f, 4.0f, 3, 1, 11);
        this.Tail2.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.Tail2.setTextureSize(128, 64);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.2230717f, 0.0f, 0.0f);
        (this.TailSide2 = new ModelRenderer((ModelBase)this, 46, 37)).addBox(-1.5f, -1.0f, 4.0f, 1, 1, 11);
        this.TailSide2.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.TailSide2.setTextureSize(128, 64);
        this.TailSide2.mirror = true;
        this.setRotation(this.TailSide2, -0.0261799f, -0.1396263f, 0.0f);
        (this.Body3 = new ModelRenderer((ModelBase)this, 0, 27)).addBox(-1.5f, -1.0f, 4.0f, 3, 2, 14);
        this.Body3.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.Body3.setTextureSize(128, 64);
        this.Body3.mirror = true;
        this.setRotation(this.Body3, 0.0f, 0.0f, 0.0f);
        (this.Beak1 = new ModelRenderer((ModelBase)this, 32, 50)).addBox(-0.5f, -2.0f, -5.0f, 1, 1, 3);
        this.Beak1.setRotationPoint(0.0f, 7.0f, -3.0f);
        this.Beak1.setTextureSize(128, 64);
        this.Beak1.mirror = true;
        this.setRotation(this.Beak1, 0.1858931f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        
        EntityPhoenix phoenix = ((EntityPhoenix) entity);
        if(phoenix.isChild()) {       	
        	GL11.glScalef(1.0F / 2.0F, 1.0F / 2.0F, 1.0F / 2.0F);
			GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
       }
        this.HeadFlame1.render(f5);
        this.Beak2.render(f5);
        this.Body1.render(f5);
        this.WingFlame1.render(f5);
        this.WingMain2.render(f5);
        this.WingMain1.render(f5);
        this.WingSide2.render(f5);
        this.WingSide1.render(f5);
        this.WingFlame2.render(f5);
        this.Wing2.render(f5);
        this.Wing1.render(f5);
        this.Head.render(f5);
        this.HeadFlame2.render(f5);
        this.HeadFlame3.render(f5);
        this.TailBottom.render(f5);
        this.Body2.render(f5);
        this.Tail1.render(f5);
        this.TailSide1.render(f5);
        this.Tail2.render(f5);
        this.TailSide2.render(f5);
        this.Body3.render(f5);
        this.Beak1.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
    	model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.WingFlame1.rotateAngleZ = f2;
        this.WingMain1.rotateAngleZ = f2;
        this.WingSide1.rotateAngleZ = f2;
        this.Wing1.rotateAngleZ = f2;
        this.WingFlame2.rotateAngleZ = -f2;
        this.WingMain2.rotateAngleZ = -f2;
        this.WingSide2.rotateAngleZ = -f2;
        this.Wing2.rotateAngleZ = -f2;
    }
}
