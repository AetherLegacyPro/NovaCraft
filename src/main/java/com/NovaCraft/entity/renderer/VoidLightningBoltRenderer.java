package com.NovaCraft.entity.renderer;

import java.util.Random;
import com.NovaCraft.entity.misc.EntityVoidLightningBolt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class VoidLightningBoltRenderer extends Render {
    private static final int SEGMENTS = 16;

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
        EntityVoidLightningBolt bolt = (EntityVoidLightningBolt)entity;

        double originY = Math.min(-16.0D, bolt.posY - 16.0D);
        double bottomOffset = originY - bolt.posY;

        long seed = (long)bolt.getEntityId() * 341873128712L + bolt.ticksExisted / 2;
        Random random = new Random(seed);

        double[] offsetsX = new double[SEGMENTS + 1];
        double[] offsetsZ = new double[SEGMENTS + 1];
        for (int i = 1; i < SEGMENTS; ++i) {
            offsetsX[i] = (random.nextDouble() - 0.5D) * 3.0D;
            offsetsZ[i] = (random.nextDouble() - 0.5D) * 3.0D;
        }

        GL11.glPushMatrix();
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT | GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT | GL11.GL_CURRENT_BIT);
        GL11.glTranslated(x, y, z);

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_ALPHA_TEST);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GL11.glDepthMask(false);

        this.drawBolt(offsetsX, offsetsZ, bottomOffset, 0.30D, 0.55F, 0.10F, 1.0F, 0.18F);
        this.drawBolt(offsetsX, offsetsZ, bottomOffset, 0.14D, 0.75F, 0.35F, 1.0F, 0.40F);
        this.drawBolt(offsetsX, offsetsZ, bottomOffset, 0.045D, 0.95F, 0.85F, 1.0F, 0.90F);

        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    private void drawBolt(double[] offsetsX, double[] offsetsZ, double bottomOffset, double width, float red, float green, float blue, float alpha) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(red, green, blue, alpha);

        for (int i = 0; i < SEGMENTS; ++i) {
            double lowerY = bottomOffset * (1.0D - (double)i / SEGMENTS);

            double upperY = bottomOffset * (1.0D - (double)(i + 1) / SEGMENTS);

            double lowerX = offsetsX[i];
            double lowerZ = offsetsZ[i];

            double upperX = offsetsX[i + 1];
            double upperZ = offsetsZ[i + 1];

            tessellator.addVertex(lowerX - width, lowerY, lowerZ);
            tessellator.addVertex(lowerX + width, lowerY, lowerZ);
            tessellator.addVertex(upperX + width, upperY, upperZ);
            tessellator.addVertex(upperX - width, upperY, upperZ);

            tessellator.addVertex(lowerX, lowerY, lowerZ - width);
            tessellator.addVertex(lowerX, lowerY, lowerZ + width);
            tessellator.addVertex(upperX, upperY, upperZ + width);
            tessellator.addVertex(upperX, upperY, upperZ - width);
        }

        tessellator.draw();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return null;
    }
}
