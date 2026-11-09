package com.NovaCraft.legendarybeacon;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class LegendaryBeaconModel extends ModelBase
{
    private final ModelRenderer cube;
    private final ModelRenderer glass;
    private final float scale = 0.8f;
    
    public LegendaryBeaconModel() {
        this.cube = new ModelRenderer((ModelBase)this, "cube");
        this.glass = new ModelRenderer((ModelBase)this, "glass");
        this.glass.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.cube.setTextureOffset(32, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
    }
    
    public void render(final Entity entityIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        GL11.glPushMatrix();
        this.getClass();
        final float n = 0.8f;
        this.getClass();
        final float n2 = 0.8f;
        this.getClass();
        GL11.glScalef(n, n2, 0.8f);
        GL11.glTranslatef(0.0f, -0.5f, 0.0f);
        GL11.glRotatef(limbSwingAmount, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.8f + ageInTicks, 0.0f);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        this.glass.render(scale);
        GL11.glScalef(0.875f, 0.875f, 0.875f);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        GL11.glRotatef(limbSwingAmount, 0.0f, 1.0f, 0.0f);
        this.glass.render(scale);
        GL11.glScalef(0.875f, 0.875f, 0.875f);
        GL11.glRotatef(60.0f, 0.7071f, 0.0f, 0.7071f);
        GL11.glRotatef(limbSwingAmount, 0.0f, 1.0f, 0.0f);
        this.cube.render(scale);
        GL11.glPopMatrix();
    }
}
