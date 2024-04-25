package com.NovaCraft.entity.renderer;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

import com.NovaCraft.entity.EntityPrimedPETN;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;

@SideOnly(Side.CLIENT)
public class PrimedPETNRenderer extends Render
{
    private final RenderBlocks blockRenderer;
    
    public PrimedPETNRenderer() {
        this.blockRenderer = new RenderBlocks();
        this.shadowSize = 0.5f;
    }
    
    public void doRender(final Entity p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        this.doRender((EntityPrimedPETN)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    
    public void doRender(final EntityPrimedPETN p_76986_1_, final double p_76986_2_, final double p_76986_4_, final double p_76986_6_, final float p_76986_8_, final float p_76986_9_) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
        if (p_76986_1_.fuse - p_76986_9_ + 1.0f < 10.0f) {
            float f2 = 1.0f - (p_76986_1_.fuse - p_76986_9_ + 1.0f) / 10.0f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            f2 *= f2;
            f2 *= f2;
            final float f3 = 1.0f + f2 * 0.3f;
            GL11.glScalef(f3, f3, f3);
        }
        float f2 = (1.0f - (p_76986_1_.fuse - p_76986_9_ + 1.0f) / 100.0f) * 0.8f;
        this.bindEntityTexture((Entity)p_76986_1_);
        this.blockRenderer.renderBlockAsItem(NovaCraftBlocks.PETN, 0, p_76986_1_.getBrightness(p_76986_9_));
        if (p_76986_1_.fuse / 5 % 2 == 0) {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 772);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, f2);
            this.blockRenderer.renderBlockAsItem(NovaCraftBlocks.PETN, 0, 1.0f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
        GL11.glPopMatrix();
    }
    
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return this.getEntityTexture((EntityPrimedPETN)p_110775_1_);
    }
    
    protected ResourceLocation getEntityTexture(final EntityPrimedPETN p_110775_1_) {
        return TextureMap.locationBlocksTexture;
    }
}
