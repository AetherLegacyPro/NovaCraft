package com.NovaCraft.Items.Staffs;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.entity.misc.EntityVaniteFirechargeProjectile;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemVaniteFirechargeLauncher extends ItemBow {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public ItemVaniteFirechargeLauncher() {
		super();

		this.maxStackSize = 1;
		this.setMaxDamage(637);
		this.setFull3D();
		this.setTextureName(NovaCraft.find("vanite_firechargelauncher"));
		this.setCreativeTab(NovaCraftCreativeTabs.tools);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getItemIconForUseDuration(int p_94599_1_) {
		return this.iconArray[p_94599_1_];
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == Item.getItemFromBlock(NovaCraftBlocks.block_of_vanite);
	}

	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if (usingItem != null && stack.getItem() == NovaCraftItems.vanite_firecharge_launcher) {
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
		this.itemIcon = p_94581_1_.registerIcon(NovaCraft.find("vanite_firechargelauncher"));
		this.iconArray = new IIcon[bowPullIconNameArray.length];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = p_94581_1_.registerIcon(this.getIconString() + "_" + bowPullIconNameArray[i]);
		}
	}

	private ItemStack findAmmo(EntityPlayer player) {
		for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
			ItemStack itemstack = player.inventory.getStackInSlot(i);

			if (this.isArrow(itemstack)) {
				return itemstack;
			}
		}

		return null;
	}

	protected boolean isArrow(ItemStack stack) {
		return stack != null && stack.getItem() == Items.fire_charge;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer entityLiving, int timeLeft) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) entityLiving;
			boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
			ItemStack itemstack = this.findAmmo(entityplayer);

			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			ArrowLooseEvent event = new ArrowLooseEvent(entityplayer, stack, i);
			MinecraftForge.EVENT_BUS.post(event);

			if (event.isCanceled()) {
				return;
			}

			i = event.charge;
			if (i < 0) return;

			if (itemstack != null || flag) {
				if (itemstack == null) {
					itemstack = new ItemStack(Items.fire_charge);
				}

				float f = getArrowVelocity(i);

				if ((double) f >= 0.1D) {
					boolean flag1 = entityplayer.capabilities.isCreativeMode; //|| EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0

					if (!worldIn.isRemote) {
						float f2 = 2.0F;
			        	final EntityVaniteFirechargeProjectile diamond_firecharge = new EntityVaniteFirechargeProjectile(worldIn, (EntityLivingBase)entityLiving, 1.2f);

			            diamond_firecharge.setDamage(diamond_firecharge.getDamage() + (double) f * 0.8D + 0.8D);

						int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

						if (j > 0) {
							diamond_firecharge.setDamage(diamond_firecharge.getDamage() + (double) j * 0.6D + 0.6D);
						}

						int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack);

						if (l > 0)
						{
							diamond_firecharge.setFire(2400);
						}

						stack.damageItem(1, entityplayer);

						worldIn.spawnEntityInWorld(diamond_firecharge);
					}

					worldIn.playSoundAtEntity((Entity)entityLiving, "mob.ghast.fireball", 1.5f, 1.5f / (ItemDiamondFirechargeLauncher.itemRand.nextFloat() * 1.4f + 1.8f));

					if (!flag1) {
						--itemstack.stackSize;

						if (itemstack.stackSize == 0) {
							entityplayer.inventory.consumeInventoryItem(itemstack.getItem());
						}
					}
				}
			}
		}
	}

	public EntityVaniteFirechargeProjectile createArrow(World worldIn, float distance, ItemStack stack, EntityLivingBase shooter) {
		EntityVaniteFirechargeProjectile entityDiamondArrow = new EntityVaniteFirechargeProjectile(worldIn, shooter, distance);

		return entityDiamondArrow;
	}

	public static float getArrowVelocity(int charge) {
		float f = (float) charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.none;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack heldItem, World worldIn, EntityPlayer playerIn) {
		boolean flag = this.findAmmo(playerIn) != null;

		ArrowNockEvent event = new ArrowNockEvent(playerIn, heldItem);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return event.result;
		}

		if (playerIn.capabilities.isCreativeMode || flag) {
			playerIn.setItemInUse(heldItem, this.getMaxItemUseDuration(heldItem));
		}

		return heldItem;
	}

	@Override
	public int getItemEnchantability() {
		return 1;
	}

}
