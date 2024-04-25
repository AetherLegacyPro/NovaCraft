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

public class ItemCrystaliteArmor extends ItemBaseCrystaliteArmor implements ISpecialArmor {

	private final int[][] damageReductionAmountArray = new int[][]{new int[]{1, 2, 3, 1}, new int[]{1, 4, 5, 2}, new int[]{2, 5, 6, 2}, new int[]{3, 6, 8, 3}, new int[]{4, 8, 10, 4}};

	public ItemCrystaliteArmor(int armorType, ArmorMaterial material, String name, Item repair) {
		super(armorType, material, name, repair);
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		return new ArmorProperties(0, this.calculateIncrease(armor) / 25D, Integer.MAX_VALUE);
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
        boolean hasCrystaliteHelmet = false;
        boolean hasCrystaliteChest = false;
        boolean hasCrystaliteLegs = false;
        boolean hasCrystaliteBoots = false;
        final ItemStack helmet = player.getCurrentArmor(3);
        final ItemStack chest = player.getCurrentArmor(2);
        final ItemStack legs = player.getCurrentArmor(1);
        final ItemStack boots = player.getCurrentArmor(0);
        if (helmet != null) {
            hasCrystaliteHelmet = (helmet.getItem() == NovaCraftItems.crystalite_helmet);
        }
        if (chest != null) {
            hasCrystaliteChest = (chest.getItem() == NovaCraftItems.crystalite_chestplate);
        }
        if (legs != null) {
            hasCrystaliteLegs = (legs.getItem() == NovaCraftItems.crystalite_leggings);
        }
        if (boots != null) {
            hasCrystaliteBoots = (boots.getItem() == NovaCraftItems.crystalite_boots);
        }
        if (hasCrystaliteHelmet && hasCrystaliteChest && hasCrystaliteLegs && hasCrystaliteBoots) {
            ((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 3));
            ((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.jump.id, 20, 1));
            ((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20, 0));
            player.triggerAchievement(AchievementsNovaCraft.ascension);
        }
        if (player.dimension == 1 && player.fallDistance > 10.0f) {
            player.fallDistance = 10.0f;
        }
        else if (player.dimension == 1 && player.posY <= 5.0 && player.fallDistance > 5.0f) {
            player.fallDistance = 5.0f;
            for (int i = 0; i < 16; ++i) {
                final double xx = player.posX + (player.getRNG().nextDouble() - 0.5) * 128.0;
                final double yy = player.posY + player.getRNG().nextInt(128);
                final double zz = player.posZ + (player.getRNG().nextDouble() - 0.5) * 128.0;
                if (player.worldObj.isSideSolid((int)xx, (int)yy - 1, (int)zz, ForgeDirection.UP) && player.worldObj.getBlock((int)xx, (int)yy, (int)zz) == Blocks.air && player.worldObj.getBlock((int)xx, (int)yy + 1, (int)zz) == Blocks.air && teleportTo((EntityLivingBase)player, xx, yy, zz)) {
                    break;
                }
            }
        }    
    }
	
	private static boolean teleportTo(final EntityLivingBase entity, final double xx, final double yy, final double zz) {
        final EnderTeleportEvent event = new EnderTeleportEvent(entity, xx, yy, zz, 0.0f);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return false;
        }
        final double d3 = entity.posX;
        final double d4 = entity.posY;
        final double d5 = entity.posZ;
        entity.posX = event.targetX;
        entity.posY = event.targetY;
        entity.posZ = event.targetZ;
        boolean flag = false;
        final int i = MathHelper.floor_double(entity.posX);
        int j = MathHelper.floor_double(entity.posY);
        final int k = MathHelper.floor_double(entity.posZ);
        if (entity.worldObj.blockExists(i, j, k)) {
            boolean flag2 = false;
            while (!flag2 && j > 0) {
                final Block block = entity.worldObj.getBlock(i, j - 1, k);
                if (block.getMaterial().blocksMovement()) {
                    flag2 = true;
                }
                else {
                    --entity.posY;
                    --j;
                }
            }
            if (flag2) {
                entity.setPositionAndUpdate(entity.posX, entity.posY, entity.posZ);
                if (entity.worldObj.getCollidingBoundingBoxes((Entity)entity, entity.boundingBox).isEmpty() && !entity.worldObj.isAnyLiquid(entity.boundingBox)) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            entity.setPosition(d3, d4, d5);
            return false;
        }
        final short short1 = 128;
        for (int l = 0; l < short1; ++l) {
            final double d6 = l / (short1 - 1.0);
            final float f = (entity.getRNG().nextFloat() - 0.5f) * 0.2f;
            final float f2 = (entity.getRNG().nextFloat() - 0.5f) * 0.2f;
            final float f3 = (entity.getRNG().nextFloat() - 0.5f) * 0.2f;
            final double d7 = d3 + (entity.posX - d3) * d6 + (entity.getRNG().nextDouble() - 0.5) * entity.width * 2.0;
            final double d8 = d4 + (entity.posY - d4) * d6 + entity.getRNG().nextDouble() * entity.height;
            final double d9 = d5 + (entity.posZ - d5) * d6 + (entity.getRNG().nextDouble() - 0.5) * entity.width * 2.0;
            entity.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f2, (double)f3);
        }
        entity.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0f, 1.0f);
        entity.playSound("mob.endermen.portal", 1.0f, 1.0f);
        return true;
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
