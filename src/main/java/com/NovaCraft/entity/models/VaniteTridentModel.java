package com.NovaCraft.entity.models;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;

public class VaniteTridentModel extends ModelBase
{
    public static final ResourceLocation TEXTURE;
    public final ModelRenderer modelRenderer;
    
    public VaniteTridentModel() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        (this.modelRenderer = new ModelRenderer((ModelBase)this, 0, 6)).addBox(-0.5f, 2.0f, -0.5f, 1, 25, 1, 0.0f);
        final ModelRenderer modelrenderer = new ModelRenderer((ModelBase)this, 4, 0);
        modelrenderer.addBox(-1.5f, 0.0f, -0.5f, 3, 2, 1);
        this.modelRenderer.addChild(modelrenderer);
        final ModelRenderer modelrenderer2 = new ModelRenderer((ModelBase)this, 4, 3);
        modelrenderer2.addBox(-2.5f, -3.0f, -0.5f, 1, 4, 1);
        this.modelRenderer.addChild(modelrenderer2);
        final ModelRenderer modelrenderer3 = new ModelRenderer((ModelBase)this, 0, 0);
        modelrenderer3.addBox(-0.5f, -4.0f, -0.5f, 1, 4, 1, 0.0f);
        this.modelRenderer.addChild(modelrenderer3);
        final ModelRenderer modelrenderer4 = new ModelRenderer((ModelBase)this, 4, 3);
        modelrenderer4.mirror = true;
        modelrenderer4.addBox(1.5f, -3.0f, -0.5f, 1, 4, 1);
        this.modelRenderer.addChild(modelrenderer4);
    }
    
    public void renderer() {
        this.modelRenderer.render(0.0625f);
    }
    
    public void render(final Entity entityIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.modelRenderer.render(scale);
    }
    
    static {
        TEXTURE = new ResourceLocation("nova_craft", "textures/entity/vanite_trident.png");
    }
}
