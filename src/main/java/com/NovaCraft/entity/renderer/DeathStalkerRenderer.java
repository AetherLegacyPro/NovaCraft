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
    
    public DeathStalkerRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return DeathStalkerRenderer.texture;
    }
    
    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
        GL11.glScalef(1.35F, 1.35F, 1.35F);
    }
    
    static {
    	texture = new ResourceLocation("nova_craft", "textures/entity/death_stalker/death_stalker.png");
    }
	
	
}
