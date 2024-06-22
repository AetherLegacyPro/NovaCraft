package com.NovaCraft.entity.renderer;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityDestituteTentacle;
import com.NovaCraft.entity.models.DestituteTentacleModel;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class DestituteTentacleRenderer extends RenderLiving {

    public static final ResourceLocation TEXTURE = new ResourceLocation("nova_craft", "textures/entity/destitute_tentacle/destitute_tentacle.png");
    private static final ResourceLocation glow;
    
    public DestituteTentacleModel mode;

    public DestituteTentacleRenderer() {
        super(new DestituteTentacleModel(), 0.3F);
        this.mode = ((DestituteTentacleModel) this.mainModel);

        this.setRenderPassModel(this.mainModel);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f) {
    	EntityDestituteTentacle plant = (EntityDestituteTentacle) entity;
        
        GL11.glScalef(2.0F, 2.0F, 2.0F);

    }

    protected int Render(EntityDestituteTentacle EntityDestituteTentacle, int i, float f) {
        if (i != 0) {
            return -1;
        } else {
            return 1;
        }
    }
    
    protected int shouldRenderPass(final EntityDestituteTentacle par1XCEntityDemiGod, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        
        this.bindTexture(DestituteTentacleRenderer.glow);
        return 1;
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase entityliving, int i, float f) {
        return this.Render((EntityDestituteTentacle) entityliving, i, f);
    }
    
    @Override
	protected ResourceLocation getEntityTexture(final Entity entity) {
        return TEXTURE;
    }
    
    static {
    	glow = new ResourceLocation("nova_craft", "textures/entity/destitute_tentacle/destitute_tentacle_overlay.png");
    }

}
