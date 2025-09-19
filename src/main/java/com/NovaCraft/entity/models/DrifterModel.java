package com.NovaCraft.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class DrifterModel extends ModelBase
{
	private final ModelRenderer MainBody;
	private final ModelRenderer Particle1;
	private final ModelRenderer Particle2;
	private final ModelRenderer Particle3;
	private final ModelRenderer Particle4;
	private final ModelRenderer Smoke1;
	private final ModelRenderer Smoke2;
	private final ModelRenderer Smoke3;
	private final ModelRenderer Smoke4;
    
    public DrifterModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.MainBody = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-5.0f, -5.0f, -5.0f, 11, 11, 11);
        this.MainBody.setRotationPoint(-1.0f, 7.0f, -2.0f);
        this.MainBody.setTextureSize(64, 32);
        this.MainBody.mirror = true;
        this.setRotation(this.MainBody, 0.0f, 0.0f, 0.0f);
        (this.Particle1 = new ModelRenderer((ModelBase)this, 49, 0)).addBox(-10.0f, 0.0f, 0.0f, 3, 3, 3);
        this.Particle1.setRotationPoint(-1.0f, 7.0f, -2.0f);
        this.Particle1.setTextureSize(64, 32);
        this.Particle1.mirror = true;
        this.setRotation(this.Particle1, 0.0f, 0.0f, 0.0f);
        (this.Particle2 = new ModelRenderer((ModelBase)this, 49, 0)).addBox(0.0f, 0.0f, -10.0f, 3, 3, 3);
        this.Particle2.setRotationPoint(-1.0f, 7.0f, -2.0f);
        this.Particle2.setTextureSize(64, 32);
        this.Particle2.mirror = true;
        this.setRotation(this.Particle2, 0.0f, 0.0f, 0.0f);
        (this.Particle3 = new ModelRenderer((ModelBase)this, 49, 0)).addBox(0.0f, 0.0f, 10.0f, 3, 3, 3);
        this.Particle3.setRotationPoint(-1.0f, 7.0f, -2.0f);
        this.Particle3.setTextureSize(64, 32);
        this.Particle3.mirror = true;
        this.setRotation(this.Particle3, 0.0f, 0.0f, 0.0f);
        (this.Particle4 = new ModelRenderer((ModelBase)this, 49, 0)).addBox(10.0f, 0.0f, 0.0f, 3, 3, 3);
        this.Particle4.setRotationPoint(-1.0f, 7.0f, -2.0f);
        this.Particle4.setTextureSize(64, 32);
        this.Particle4.mirror = true;
        this.setRotation(this.Particle4, 0.0f, 0.0f, 0.0f);
        (this.Smoke1 = new ModelRenderer((ModelBase)this, 49, 15)).addBox(-9.0f, -2.0f, -8.0f, 1, 5, 1);
        this.Smoke1.setRotationPoint(-1.0f, 7.0f, -2.0f);
        this.Smoke1.setTextureSize(64, 32);
        this.Smoke1.mirror = true;
        this.setRotation(this.Smoke1, 0.0f, 0.0f, 0.0f);
        (this.Smoke2 = new ModelRenderer((ModelBase)this, 49, 15)).addBox(-9.0f, -2.0f, 8.0f, 1, 5, 1);
        this.Smoke2.setRotationPoint(-1.0f, 7.0f, -2.0f);
        this.Smoke2.setTextureSize(64, 32);
        this.Smoke2.mirror = true;
        this.setRotation(this.Smoke2, 0.0f, 0.0f, 0.0f);
        (this.Smoke3 = new ModelRenderer((ModelBase)this, 49, 15)).addBox(9.0f, 0.0f, -8.0f, 1, 5, 1);
        this.Smoke3.setRotationPoint(-1.0f, 7.0f, -2.0f);
        this.Smoke3.setTextureSize(64, 32);
        this.Smoke3.mirror = true;
        this.setRotation(this.Smoke3, 0.0f, 0.0f, 0.0f);
        (this.Smoke4 = new ModelRenderer((ModelBase)this, 49, 15)).addBox(9.0f, 0.0f, 8.0f, 1, 5, 1);
        this.Smoke4.setRotationPoint(-1.0f, 7.0f, -2.0f);
        this.Smoke4.setTextureSize(64, 32);
        this.Smoke4.mirror = true;
        this.setRotation(this.Smoke4, 0.0f, 0.0f, 0.0f);
    }
    
    public int func_78104_a()
    {
        return 8;
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.MainBody.render(f5);
        this.Particle1.render(f5);
        this.Particle2.render(f5);
        this.Particle3.render(f5);
        this.Particle4.render(f5);
        this.Smoke1.render(f5);
        this.Smoke2.render(f5);
        this.Smoke3.render(f5);
        this.Smoke4.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y; //g
        model.rotateAngleZ = z; //h
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity ent) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
        this.Smoke1.rotateAngleY = MathHelper.cos(f2 * 3.141593f * 0.0958f) * 0.5f - 0.9f;
        this.Smoke2.rotateAngleY = MathHelper.cos(f2 * 3.141593f * 0.0958f) * 0.5f - 0.9f;
        this.Smoke3.rotateAngleY = MathHelper.cos(f2 * 3.141593f * 0.0958f) * 0.5f - 0.9f;
        this.Smoke4.rotateAngleY = MathHelper.cos(f2 * 3.141593f * 0.0958f) * 0.5f - 0.9f;
        this.Particle1.rotateAngleY = MathHelper.cos(f2 * 3.141593f * 0.036f) * 0.5f + 0.4f;
        this.Particle2.rotateAngleY = MathHelper.cos(f2 * 3.141593f * 0.036f) * 0.5f + 0.4f;
        this.Particle3.rotateAngleY = MathHelper.cos(f2 * 3.141593f * 0.036f) * 0.5f + 0.4f;
        this.Particle4.rotateAngleY = MathHelper.cos(f2 * 3.141593f * 0.036f) * 0.5f + 0.4f;
    }
}
