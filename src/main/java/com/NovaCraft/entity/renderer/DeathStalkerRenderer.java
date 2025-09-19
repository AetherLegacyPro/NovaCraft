package com.NovaCraft.entity.renderer;

import java.util.UUID;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntityDeathStalker;
import com.NovaCraft.entity.models.DeathStalkerModel;
import com.mojang.authlib.GameProfile;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class DeathStalkerRenderer extends RenderLiving
{
	private static final ResourceLocation texture;
	private static final ResourceLocation eyes;
    
    public DeathStalkerRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.setRenderPassModel((ModelBase)new DeathStalkerModel());
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return DeathStalkerRenderer.texture;
    }
    
    protected int shouldRenderPass(final EntityLivingBase par1EntityLivingBase, final int par2, final float par3) {
        return this.shouldRenderPass((EntityDeathStalker)par1EntityLivingBase, par2, par3);
    }
    
    protected int shouldRenderPass(EntityDeathStalker p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ != 0)
        {
            return -1;
        }
        else
        {
            this.bindTexture(eyes);
            float f1 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDisable(GL11.GL_LIGHTING);

            if (p_77032_1_.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }
    
    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
        GL11.glScalef(1.35F, 1.35F, 1.35F);
    }
    
    static {
    	texture = new ResourceLocation("nova_craft", "textures/entity/death_stalker/death_stalker.png");
    	eyes = new ResourceLocation("nova_craft", "textures/entity/death_stalker/eyes.png");
    }
	
	
}
