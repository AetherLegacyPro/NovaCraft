package com.NovaCraft.entity.renderer;

import com.NovaCraft.entity.EntityEnderAvis;
import com.NovaCraft.entity.models.EnderAvisModel;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class EnderAvisRenderer extends RenderLiving {

    private static final ResourceLocation TEXTURE = new ResourceLocation("nova_craft", "textures/entity/ender_avis/ender_avis.png");
    private static final ResourceLocation TEXTURE_MARKINGS = new ResourceLocation("nova_craft", "textures/entity/ender_avis/ender_avis_glow.png");
    private static final ResourceLocation TEXTURE_SADDLE = new ResourceLocation("nova_craft", "textures/entity/ender_avis/ender_avis_saddle.png");
    private final EnderAvisModel saddleModel = new EnderAvisModel();

    public EnderAvisRenderer() {
        super(new EnderAvisModel(), 0.7F);
        
        this.setRenderPassModel(new EnderAvisModel());
    }

    protected int renderLayers(EntityEnderAvis entity, int pass, float particleTicks) {
        if (entity.isInvisible()) {
            return 0;
        } else if (pass == 1 && entity.isSaddled()) {
            this.setRenderPassModel(this.saddleModel);
            this.bindTexture(TEXTURE_SADDLE);

            return 1;
        }

        return -1;
    }
    
    protected float getWingRotation(EntityEnderAvis avis, float f) {
		float f1 = avis.prevWingRotation + (avis.wingRotation - avis.prevWingRotation) * f;
		float f2 = avis.prevDestPos + (avis.destPos - avis.prevDestPos) * f;

		return (MathHelper.sin(f1) + 1.0F) * f2;
	}
    
    @Override
	protected float handleRotationFloat(EntityLivingBase entityliving, float f) {
		return this.getWingRotation((EntityEnderAvis) entityliving, f);
	}

    @Override
    protected int shouldRenderPass(EntityLivingBase entity, int pass, float particleTicks) {
        return this.renderLayers((EntityEnderAvis) entity, pass, particleTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return TEXTURE;
    }

}