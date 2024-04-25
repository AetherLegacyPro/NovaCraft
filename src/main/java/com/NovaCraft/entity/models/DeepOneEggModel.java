package com.NovaCraft.entity.models;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class DeepOneEggModel extends ModelBase
{
    ModelRenderer Bulk;
    ModelRenderer Bulk2;
    ModelRenderer Bulk3;
    ModelRenderer Bulk4;
    ModelRenderer Bulk5;
    ModelRenderer Bulk6;
    
    public DeepOneEggModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Bulk = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 14, 5, 14);
        this.Bulk.setRotationPoint(-7.0f, 16.0f, -7.0f);
        this.Bulk.setTextureSize(64, 32);
        this.Bulk.mirror = true;
        this.setRotation(this.Bulk, 0.0f, 0.0f, 0.0f);
        (this.Bulk2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 10, 12);
        this.Bulk2.setRotationPoint(-6.0f, 13.0f, -6.0f);
        this.Bulk2.setTextureSize(64, 32);
        this.Bulk2.mirror = true;
        this.setRotation(this.Bulk2, 0.0f, 0.0f, 0.0f);
        (this.Bulk3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 2, 10);
        this.Bulk3.setRotationPoint(-5.0f, 11.0f, -5.0f);
        this.Bulk3.setTextureSize(64, 32);
        this.Bulk3.mirror = true;
        this.setRotation(this.Bulk3, 0.0f, 0.0f, 0.0f);
        (this.Bulk4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 8);
        this.Bulk4.setRotationPoint(-4.0f, 10.0f, -4.0f);
        this.Bulk4.setTextureSize(64, 32);
        this.Bulk4.mirror = true;
        this.setRotation(this.Bulk4, 0.0f, 0.0f, 0.0f);
        (this.Bulk5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 15, 6);
        this.Bulk5.setRotationPoint(-3.0f, 9.0f, -3.0f);
        this.Bulk5.setTextureSize(64, 32);
        this.Bulk5.mirror = true;
        this.setRotation(this.Bulk5, 0.0f, 0.0f, 0.0f);
        (this.Bulk6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 4);
        this.Bulk6.setRotationPoint(-2.0f, 8.0f, -2.0f);
        this.Bulk6.setTextureSize(64, 32);
        this.Bulk6.mirror = true;
        this.setRotation(this.Bulk6, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final float scale, final double x, final double y, final double z, final float ang, final float angY, final boolean renderLantern, final boolean lanternOn, final boolean renderHeadTorch) {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);
        GL11.glPushMatrix();
        GL11.glRotatef(ang, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(angY, 0.0f, 1.0f, 0.0f);
        this.Bulk.render(scale);
        this.Bulk2.render(scale);
        this.Bulk3.render(scale);
        this.Bulk4.render(scale);
        this.Bulk5.render(scale);
        this.Bulk6.render(scale);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void renderAll() {
        this.Bulk.render(0.0625f);
        this.Bulk2.render(0.0625f);
        this.Bulk3.render(0.0625f);
        this.Bulk4.render(0.0625f);
        this.Bulk5.render(0.0625f);
        this.Bulk6.render(0.0625f);
    }
}
