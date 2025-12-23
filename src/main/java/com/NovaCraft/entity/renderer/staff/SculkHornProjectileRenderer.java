package com.NovaCraft.entity.renderer.staff;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import com.NovaCraft.entity.misc.EntitySculkHornProjectile;

public class SculkHornProjectileRenderer extends Render {

	private static final ResourceLocation vibrationTexture = new ResourceLocation("nova_craft", "textures/entity/vibration.png");
	
    public SculkHornProjectileRenderer() {
        super();

        this.shadowSize = 0.0F;
    }

    public void doRenderProjectile(EntitySculkHornProjectile projectile, double par2, double par4, double par6, float par8, float par9) {
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glTranslated(par2, par4, par6);

        this.bindTexture(this.getEntityTexture(projectile));

        Tessellator tessellator = Tessellator.instance;

        GL11.glRotatef(180F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-0.5F, -0.25F, 0.0F, 0.0F, 0.0F);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(0.5F, -0.25F, 0.0F, 0.0F, 1.0F);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(0.5F, 0.75F, 0.0F, 1.0F, 1.0F);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(-0.5F, 0.75F, 0.0F, 1.0F, 0.0F);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.draw();

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.doRenderProjectile((EntitySculkHornProjectile) par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return vibrationTexture;
    }

}

