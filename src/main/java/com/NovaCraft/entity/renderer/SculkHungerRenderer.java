package com.NovaCraft.entity.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

import java.util.UUID;

import org.lwjgl.opengl.GL11;

import com.NovaCraft.entity.EntitySculkHunger;
import com.NovaCraft.entity.models.SculkHungerModel;
import com.mojang.authlib.GameProfile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;

public class SculkHungerRenderer extends RenderLiving
{
    private static final ResourceLocation EntityTexture;
    private static final ResourceLocation OverlayTexture;
    
    protected ModelBiped field_82437_k;
	protected ModelBiped field_82435_l;
	public SculkHungerModel modelBipedMain;
    
    public SculkHungerRenderer(final SculkHungerModel mainModel, final SculkHungerModel renderPassModel, final float shadowSize) {
    	super((ModelBase)mainModel, shadowSize);
        this.setRenderPassModel((ModelBase)renderPassModel);
        this.modelBipedMain = mainModel;
    }
  
    
    protected ResourceLocation getEntityTexture(final Entity p_110775_1_) {
        return SculkHungerRenderer.EntityTexture;
    }
    
    protected int setMobTextureGlow(final EntitySculkHunger entity, final int pass, final float partialTickTime) {
        final float flap = MathHelper.sin((entity.ticksExisted + partialTickTime) * 0.5f) * 0.6f;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.0f - flap * 0.5f, 0.0f);
        GL11.glPopMatrix();
        if (pass == 1) {
            final char c0 = '\uf0f0';
            final int j = c0 % 65536;
            final int k = c0 / 65536;
            this.bindTexture(SculkHungerRenderer.OverlayTexture);
           final float var4 = 1.0f;
            GL11.glEnable(3042);
            GL11.glBlendFunc(1, 771);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0f, k / 1.0f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, var4);
            return 1;
        }
        if (pass == 2) {
            GL11.glDisable(3042);
        }
        return -1;
    }
    
    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
        GL11.glScalef(1.34F, 1.34F, 1.34F);
    }
    
    protected int shouldRenderPass(final EntityLivingBase entity, final int pass, final float partialTickTime) {
        return this.setMobTextureGlow((EntitySculkHunger)entity, pass, partialTickTime);
    }
    
    protected void renderEquippedItems(EntityLiving p_77029_1_, float p_77029_2_)
    {
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        super.renderEquippedItems(p_77029_1_, p_77029_2_);
        ItemStack itemstack = p_77029_1_.getHeldItem();
        ItemStack itemstack1 = p_77029_1_.func_130225_q(3);
        Item item;
        float f1;

        if (itemstack1 != null)
        {
            GL11.glPushMatrix();           
            item = itemstack1.getItem();

            net.minecraftforge.client.IItemRenderer customRenderer = net.minecraftforge.client.MinecraftForgeClient.getItemRenderer(itemstack1, net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED, itemstack1, net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D));

            if (item instanceof ItemBlock)
            {
                if (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType()))
                {
                    f1 = 0.625F;
                    GL11.glTranslatef(0.0F, -0.25F, 0.0F);
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glScalef(f1, -f1, -f1);
                }

                this.renderManager.itemRenderer.renderItem(p_77029_1_, itemstack1, 0);
            }

            GL11.glPopMatrix();
        }

        if (itemstack != null && itemstack.getItem() != null)
        {
            item = itemstack.getItem();
            GL11.glPushMatrix();

            this.modelBipedMain.right_arm.postRender(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

            net.minecraftforge.client.IItemRenderer customRenderer = net.minecraftforge.client.MinecraftForgeClient.getItemRenderer(itemstack, net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED, itemstack, net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D));

            if (item instanceof ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType())))
            {
                f1 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f1 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(-f1/2, -f1/2, f1/2);
            }
            else if (item == Items.bow)
            {
                f1 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1/2, -f1/2, f1/2);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else if (item.isFull3D())
            {
                f1 = 0.625F;

                if (item.shouldRotateAroundWhenRendering())
                {
                    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }

                this.func_82422_c();
                GL11.glScalef(f1/2, -f1/2, f1/2);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else
            {
                f1 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f1/2, f1/2, f1/2);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            float f2;
            int i;
            float f5;

            if (itemstack.getItem().requiresMultipleRenderPasses())
            {
                for (i = 0; i < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); ++i)
                {
                    int j = itemstack.getItem().getColorFromItemStack(itemstack, i);
                    f5 = (float)(j >> 16 & 255) / 255.0F;
                    f2 = (float)(j >> 8 & 255) / 255.0F;
                    float f3 = (float)(j & 255) / 255.0F;
                    GL11.glColor4f(f5, f2, f3, 1.0F);
                    this.renderManager.itemRenderer.renderItem(p_77029_1_, itemstack, i);
                }
            }
            else
            {
                i = itemstack.getItem().getColorFromItemStack(itemstack, 0);
                float f4 = (float)(i >> 16 & 255) / 255.0F;
                f5 = (float)(i >> 8 & 255) / 255.0F;
                f2 = (float)(i & 255) / 255.0F;
                GL11.glColor4f(f4, f5, f2, 1.0F);
                this.renderManager.itemRenderer.renderItem(p_77029_1_, itemstack, 0);
            }

            GL11.glPopMatrix();
        }
    }
    
    protected void func_82422_c()
    {
        GL11.glTranslatef(0.0F, 0.3875F, -0.1675F);
    }
    
    protected void renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_)
    {
        this.renderEquippedItems((EntityLiving)p_77029_1_, p_77029_2_);
    }
    
    static {
        EntityTexture = new ResourceLocation("nova_craft","textures/entity/sculk_hunger/sculk_hunger.png");
        OverlayTexture = new ResourceLocation("nova_craft","textures/entity/sculk_hunger/sculk_hunger_glow.png");
    }
}
