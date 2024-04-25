package com.NovaCraft.legendarybeacon;

import net.minecraft.tileentity.TileEntity;

import java.util.Iterator;
import net.minecraft.util.MathHelper;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import com.NovaCraft.TileEntity.TileEntityLegendaryBeacon;

import java.util.List;
import net.minecraft.client.model.ModelEnderCrystal;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class LegendaryBeaconRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation BEAM_TEXTURE;
    public static final ResourceLocation ENDER_CRYSTAL_TEXTURES;
    private final ModelBase modelEnderCrystal;
    private int rotation;
    
    public LegendaryBeaconRenderer() {
        this.modelEnderCrystal = (ModelBase)new ModelEnderCrystal(0.8f, false);
        this.rotation = (int)(Math.random() * 100000.0);
    }
    
    public void renderTileEntityAt(TileEntityLegendaryBeacon p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_, final long time)
    {
        float f1 = p_147500_1_.func_146002_i();
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);

        if (f1 > 0.0F)
        {
            Tessellator tessellator = Tessellator.instance;
            this.bindTexture(BEAM_TEXTURE);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDepthMask(true);
            OpenGlHelper.glBlendFunc(770, 1, 1, 0);
            float f2 = (float)p_147500_1_.getWorldObj().getTotalWorldTime() + p_147500_8_;
            float f3 = -f2 * 0.2F - (float)MathHelper.floor_float(-f2 * 0.1F);
            byte b0 = 1;
            double d3 = (double)f2 * 0.025D * (1.0D - (double)(b0 & 1) * 2.5D);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(255, 255, 255, 32);
            double d5 = (double)b0 * 0.2D;
            double d7 = 0.5D + Math.cos(d3 + 2.356194490192345D) * d5;
            double d9 = 0.5D + Math.sin(d3 + 2.356194490192345D) * d5;
            double d11 = 0.5D + Math.cos(d3 + (Math.PI / 4D)) * d5;
            double d13 = 0.5D + Math.sin(d3 + (Math.PI / 4D)) * d5;
            double d15 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * d5;
            double d17 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * d5;
            double d19 = 0.5D + Math.cos(d3 + 5.497787143782138D) * d5;
            double d21 = 0.5D + Math.sin(d3 + 5.497787143782138D) * d5;
            double d23 = (double)(256.0F * f1);
            double d25 = 0.0D;
            double d27 = 1.0D;
            double d28 = (double)(-1.0F + f3);
            double d29 = (double)(256.0F * f1) * (0.5D / d5) + d28;
            tessellator.addVertexWithUV(p_147500_2_ + d7, p_147500_4_ + d23, p_147500_6_ + d9, d27, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d7, p_147500_4_, p_147500_6_ + d9, d27, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d11, p_147500_4_, p_147500_6_ + d13, d25, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d11, p_147500_4_ + d23, p_147500_6_ + d13, d25, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d19, p_147500_4_ + d23, p_147500_6_ + d21, d27, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d19, p_147500_4_, p_147500_6_ + d21, d27, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d15, p_147500_4_, p_147500_6_ + d17, d25, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d15, p_147500_4_ + d23, p_147500_6_ + d17, d25, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d11, p_147500_4_ + d23, p_147500_6_ + d13, d27, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d11, p_147500_4_, p_147500_6_ + d13, d27, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d19, p_147500_4_, p_147500_6_ + d21, d25, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d19, p_147500_4_ + d23, p_147500_6_ + d21, d25, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d15, p_147500_4_ + d23, p_147500_6_ + d17, d27, d29);
            tessellator.addVertexWithUV(p_147500_2_ + d15, p_147500_4_, p_147500_6_ + d17, d27, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d7, p_147500_4_, p_147500_6_ + d9, d25, d28);
            tessellator.addVertexWithUV(p_147500_2_ + d7, p_147500_4_ + d23, p_147500_6_ + d9, d25, d29);
            tessellator.draw();
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glDepthMask(false);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(255, 255, 255, 32);
            double d30 = 0.2D;
            double d4 = 0.2D;
            double d6 = 0.8D;
            double d8 = 0.2D;
            double d10 = 0.2D;
            double d12 = 0.8D;
            double d14 = 0.8D;
            double d16 = 0.8D;
            double d18 = (double)(256.0F * f1);
            double d20 = 0.0D;
            double d22 = 1.0D;
            double d24 = (double)(-1.0F + f3);
            double d26 = (double)(256.0F * f1) + d24;
            tessellator.addVertexWithUV(p_147500_2_ + d30, p_147500_4_ + d18, p_147500_6_ + d4, d22, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d30, p_147500_4_, p_147500_6_ + d4, d22, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d6, p_147500_4_, p_147500_6_ + d8, d20, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d6, p_147500_4_ + d18, p_147500_6_ + d8, d20, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d14, p_147500_4_ + d18, p_147500_6_ + d16, d22, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d14, p_147500_4_, p_147500_6_ + d16, d22, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d10, p_147500_4_, p_147500_6_ + d12, d20, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d10, p_147500_4_ + d18, p_147500_6_ + d12, d20, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d6, p_147500_4_ + d18, p_147500_6_ + d8, d22, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d6, p_147500_4_, p_147500_6_ + d8, d22, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d14, p_147500_4_, p_147500_6_ + d16, d20, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d14, p_147500_4_ + d18, p_147500_6_ + d16, d20, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d10, p_147500_4_ + d18, p_147500_6_ + d12, d22, d26);
            tessellator.addVertexWithUV(p_147500_2_ + d10, p_147500_4_, p_147500_6_ + d12, d22, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d30, p_147500_4_, p_147500_6_ + d4, d20, d24);
            tessellator.addVertexWithUV(p_147500_2_ + d30, p_147500_4_ + d18, p_147500_6_ + d4, d20, d26);
            tessellator.draw();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDepthMask(true);
        }
        
        this.renderNetherStar(p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_, (double)time);
    }
    
    public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        this.renderTileEntityAt((TileEntityLegendaryBeacon)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_, p_147500_1_.getWorldObj().getTotalWorldTime());
    }
    
    public void renderNetherStar(final double x, final double y, final double z, final float partialTicks, final double totalWorldTime) {
        final int rotation = (int)(this.rotation + totalWorldTime);
        final float f = rotation + partialTicks;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5f, (float)y + 0.2f, (float)z + 0.5f);
        this.bindTexture(LegendaryBeaconRenderer.ENDER_CRYSTAL_TEXTURES);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.modelEnderCrystal.render((Entity)null, 0.0f, f * 3.0f, 0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
    
    public void renderBeam(final World world, final List<BeamSegment> list, final double x, final double y, final double z, final float tick, final float time) {
        GL11.glAlphaFunc(516, 0.1f);
        GL11.glDisable(2912);
        this.bindTexture(LegendaryBeaconRenderer.BEAM_TEXTURE);
        if (time > 0.0f) {
            final Tessellator tessellator = Tessellator.instance;
            int j = 0;
            for (final BeamSegment beamsegment : list) {
                final int l = j + beamsegment.func_177264_c();
                GL11.glTexParameterf(3553, 10242, 10497.0f);
                GL11.glTexParameterf(3553, 10243, 10497.0f);
                GL11.glDisable(2896);
                GL11.glDisable(2884);
                GL11.glDisable(3042);
                GL11.glDepthMask(true);
                OpenGlHelper.glBlendFunc(770, 1, 1, 0);
                final float f2 = world.getTotalWorldTime() + tick;
                final float f3 = -f2 * 0.2f - MathHelper.floor_float(-f2 * 0.1f);
                double d3 = f2 * 0.025 * -1.5;
                tessellator.startDrawingQuads();
                double d4 = 0.2;
                double d5 = 0.5 + Math.cos(d3 + 2.356194490192345) * d4;
                double d6 = 0.5 + Math.sin(d3 + 2.356194490192345) * d4;
                double d7 = 0.5 + Math.cos(d3 + 0.7853981633974483) * d4;
                double d8 = 0.5 + Math.sin(d3 + 0.7853981633974483) * d4;
                double d9 = 0.5 + Math.cos(d3 + 3.9269908169872414) * d4;
                double d10 = 0.5 + Math.sin(d3 + 3.9269908169872414) * d4;
                double d11 = 0.5 + Math.cos(d3 + 5.497787143782138) * d4;
                double d12 = 0.5 + Math.sin(d3 + 5.497787143782138) * d4;
                double d13 = 0.0;
                double d14 = 1.0;
                final double d15 = -1.0f + f3;
                final double d16 = beamsegment.func_177264_c() * time * (0.5 / d4) + d15;
                beamsegment.setColor(tessellator);
                tessellator.addVertexWithUV(x + d5, y + l, z + d6, d14, d16);
                tessellator.addVertexWithUV(x + d5, y + j, z + d6, d14, d15);
                tessellator.addVertexWithUV(x + d7, y + j, z + d8, d13, d15);
                tessellator.addVertexWithUV(x + d7, y + l, z + d8, d13, d16);
                tessellator.addVertexWithUV(x + d11, y + l, z + d12, d14, d16);
                tessellator.addVertexWithUV(x + d11, y + j, z + d12, d14, d15);
                tessellator.addVertexWithUV(x + d9, y + j, z + d10, d13, d15);
                tessellator.addVertexWithUV(x + d9, y + l, z + d10, d13, d16);
                tessellator.addVertexWithUV(x + d7, y + l, z + d8, d14, d16);
                tessellator.addVertexWithUV(x + d7, y + j, z + d8, d14, d15);
                tessellator.addVertexWithUV(x + d11, y + j, z + d12, d13, d15);
                tessellator.addVertexWithUV(x + d11, y + l, z + d12, d13, d16);
                tessellator.addVertexWithUV(x + d9, y + l, z + d10, d14, d16);
                tessellator.addVertexWithUV(x + d9, y + j, z + d10, d14, d15);
                tessellator.addVertexWithUV(x + d5, y + j, z + d6, d13, d15);
                tessellator.addVertexWithUV(x + d5, y + l, z + d6, d13, d16);
                tessellator.draw();
                GL11.glEnable(3042);
                OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                GL11.glDepthMask(false);
                tessellator.startDrawingQuads();
                beamsegment.setColor(tessellator);
                d3 = 0.2;
                d4 = 0.2;
                d5 = 0.8;
                d6 = 0.2;
                d7 = 0.2;
                d8 = 0.8;
                d9 = 0.8;
                d10 = 0.8;
                d11 = 0.0;
                d12 = 1.0;
                d13 = -1.0f + f3;
                d14 = beamsegment.func_177264_c() * time + d13;
                tessellator.addVertexWithUV(x + d3, y + l, z + d4, d12, d14);
                tessellator.addVertexWithUV(x + d3, y + j, z + d4, d12, d13);
                tessellator.addVertexWithUV(x + d5, y + j, z + d6, d11, d13);
                tessellator.addVertexWithUV(x + d5, y + l, z + d6, d11, d14);
                tessellator.addVertexWithUV(x + d9, y + l, z + d10, d12, d14);
                tessellator.addVertexWithUV(x + d9, y + j, z + d10, d12, d13);
                tessellator.addVertexWithUV(x + d7, y + j, z + d8, d11, d13);
                tessellator.addVertexWithUV(x + d7, y + l, z + d8, d11, d14);
                tessellator.addVertexWithUV(x + d5, y + l, z + d6, d12, d14);
                tessellator.addVertexWithUV(x + d5, y + j, z + d6, d12, d13);
                tessellator.addVertexWithUV(x + d9, y + j, z + d10, d11, d13);
                tessellator.addVertexWithUV(x + d9, y + l, z + d10, d11, d14);
                tessellator.addVertexWithUV(x + d7, y + l, z + d8, d12, d14);
                tessellator.addVertexWithUV(x + d7, y + j, z + d8, d12, d13);
                tessellator.addVertexWithUV(x + d3, y + j, z + d4, d11, d13);
                tessellator.addVertexWithUV(x + d3, y + l, z + d4, d11, d14);
                tessellator.draw();
                GL11.glEnable(2896);
                GL11.glEnable(3553);
                GL11.glDepthMask(true);
                j = l;
            }
        }
        GL11.glEnable(2912);
    }
    
    static {
        BEAM_TEXTURE = new ResourceLocation("nova_craft:textures/entity/legendary_beacon/beacon_beam.png");
        ENDER_CRYSTAL_TEXTURES = new ResourceLocation("nova_craft:textures/entity/legendary_beacon/beacon.png");
    }

}
