package com.NovaCraft.Items.goathorn;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import java.util.List;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGoatHornDream extends ItemBow {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public ItemGoatHornDream() {
		super();

		this.maxStackSize = 1;
		this.setFull3D();
		this.setTextureName(NovaCraft.find("goat_horn"));
		this.setCreativeTab(NovaCraftCreativeTabs.tools);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getItemIconForUseDuration(int p_94599_1_) {
		return this.iconArray[p_94599_1_];
	}
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.horn.dream.desc"));
    }

	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if (usingItem != null && stack.getItem() == NovaCraftItems.goat_horn_dream) {
			int j = stack.getMaxItemUseDuration() - useRemaining;
			
			if (j >= 18) {
				return this.getItemIconForUseDuration(2);
			}

			if (j > 13) {
				return this.getItemIconForUseDuration(1);
			}

			if (j > 0) {
				return this.getItemIconForUseDuration(0);
			}
		}

		return getIcon(stack, renderPass);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister p_94581_1_) {
		this.itemIcon = p_94581_1_.registerIcon(NovaCraft.find("goat_horn"));
		this.iconArray = new IIcon[bowPullIconNameArray.length];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = p_94581_1_.registerIcon(this.getIconString() + "_" + bowPullIconNameArray[i]);
		}
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer entityLiving, int timeLeft) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) entityLiving;			

			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			ArrowLooseEvent event = new ArrowLooseEvent(entityplayer, stack, i);
			MinecraftForge.EVENT_BUS.post(event);
			worldIn.playSound(entityplayer.posX, entityplayer.posY, entityplayer.posZ, "nova_craft:goat.horn.7", 5.0F, 0.8F + this.itemRand.nextFloat() * 0.3F, false);
			if (event.isCanceled()) {
				return;
			}
		}
	}


	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.bow;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack heldItem, World worldIn, EntityPlayer playerIn) {
		ArrowNockEvent event = new ArrowNockEvent(playerIn, heldItem);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return event.result;
		}

		playerIn.setItemInUse(heldItem, this.getMaxItemUseDuration(heldItem));
			
		return heldItem;
	}
	
	protected String getHornSound() {
	      return "nova_craft:goat.horn.7";
	 }
	
    protected float getSoundVolume() {
        return 3.0F;
    }

}
