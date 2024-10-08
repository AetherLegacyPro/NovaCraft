package com.NovaCraft.Items.Armor;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class ItemKylaziteArmor extends ItemBaseKylaziteArmor implements ISpecialArmor {
	
	private final int[][] damageReductionAmountArray = new int[][]{new int[]{1, 2, 3, 1}, new int[]{1, 4, 5, 2}, new int[]{2, 5, 6, 2}, new int[]{3, 6, 8, 3}, new int[]{4, 8, 10, 4}};
	
	public ItemKylaziteArmor(int armorType, ArmorMaterial material, String name, Item repair) {
		super(armorType, material, name, repair);
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		return new ArmorProperties(0, this.calculateIncrease(armor) / 26D, Integer.MAX_VALUE);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return (int) this.calculateIncrease(armor);
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		stack.damageItem(damage, entity);
	}

	private float calculateIncrease(ItemStack tool) {
		if (this.armorType == 0) {
			if (isBetween(tool, 0, 32)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 33, 65)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 66, 98)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 99, 131)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 132, 22747)) {
				return this.getDamageReductionAmount(3);
			}
		} else if (this.armorType == 1) {
			if (isBetween(tool, 0, 47)) {
				return this.getDamageReductionAmount(4);
			} else if (isBetween(tool, 48, 95)) {
				return this.getDamageReductionAmount(4);
			} else if (isBetween(tool, 96, 143)) {
				return this.getDamageReductionAmount(4);
			} else if (isBetween(tool, 144, 191)) {
				return this.getDamageReductionAmount(4);
			} else if (isBetween(tool, 192, 22747)) {
				return this.getDamageReductionAmount(4);
			}
		} else if (this.armorType == 2) {
			if (isBetween(tool, 0, 44)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 45, 89)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 90, 134)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 135, 179)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 180, 22747)) {
				return this.getDamageReductionAmount(3);
			}
		} else if (this.armorType == 3) {
			if (isBetween(tool, 0, 38)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 39, 77)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 78, 116)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 117, 155)) {
				return this.getDamageReductionAmount(3);
			} else if (isBetween(tool, 156, 22747)) {
				return this.getDamageReductionAmount(3);
			}
		}

		return 0.0F;
	}
	
	public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        boolean hasPherithiumHelmet = false;
        boolean hasPherithiumChest = false;
        boolean hasPherithiumLegs = false;
        boolean hasPherithiumBoots = false;
        final ItemStack helmet = player.getCurrentArmor(3);
        final ItemStack chest = player.getCurrentArmor(2);
        final ItemStack legs = player.getCurrentArmor(1);
        final ItemStack boots = player.getCurrentArmor(0);
        if (helmet != null) {
            hasPherithiumHelmet = (helmet.getItem() == NovaCraftItems.kylazite_helmet);
        }
        if (chest != null) {
            hasPherithiumChest = (chest.getItem() == NovaCraftItems.kylazite_chestplate);
        }
        if (legs != null) {
            hasPherithiumLegs = (legs.getItem() == NovaCraftItems.kylazite_leggings);
        }
        if (boots != null) {
            hasPherithiumBoots = (boots.getItem() == NovaCraftItems.kylazite_boots);
        }
        if (hasPherithiumHelmet && hasPherithiumChest && hasPherithiumLegs && hasPherithiumBoots) {
        }
    }

	public boolean isBetween(ItemStack tool, int max, int min) {
		int origin = tool.getItemDamage();
		int maxDamage = tool.getMaxDamage();

		return origin <= maxDamage - max && origin >= maxDamage - min ? true : false;
	}

	public int getDamageReductionAmount(int level) {
		return this.damageReductionAmountArray[level][this.armorType];
	}
	
	public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

}
