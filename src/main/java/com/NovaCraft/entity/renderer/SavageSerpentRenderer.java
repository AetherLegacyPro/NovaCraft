package com.NovaCraft.entity.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntitySavageSerpent;
import com.NovaCraft.entity.models.SavageSerpentModel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;

@SideOnly(Side.CLIENT)
public class SavageSerpentRenderer extends RenderLiving
{
    private static final ResourceLocation texture;
    private static final ResourceLocation eyes;
    
    public SavageSerpentRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.setRenderPassModel((ModelBase)new SavageSerpentModel());
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return SavageSerpentRenderer.texture;
    }
    
    @Override
	protected void preRenderCallback(EntityLivingBase living, float partialTickTime) {
	    GL11.glScalef(1.25F, 1.25F, 1.25F);
	}
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntitySavageSerpent)par1EntityLivingBase, par2, par3);
    }
    
    protected int shouldRenderPass(final EntitySavageSerpent serpent, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        this.bindTexture(SavageSerpentRenderer.eyes);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(1, 1);
        if (serpent.isInvisible()) {
            GL11.glDepthMask(false);
        }
        else {
            GL11.glDepthMask(true);
        }
        final char c0 = '\uf0f0';
        final int j = 61680;
        final int k = 0;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0f, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return 1;
    }
    
    static {
        texture = new ResourceLocation("nova_craft", "textures/entity/serpent/savage_serpent.png");
        eyes = new ResourceLocation("nova_craft", "textures/entity/serpent/eyes_savage.png");
    }
}
