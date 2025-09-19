package com.NovaCraft.Items.Tools;

import java.util.List;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemOphidianSword extends ItemSword
{
    public ItemOphidianSword() {
        super(NCToolMaterial.OPHIDIAN_SWORD);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
    
    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
    
    @Override
   	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
   		return repair.getItem() == NovaCraftItems.deep_one_bone;
   	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
	 	   tooltip.add(EnumChatFormatting.RED + "" + StatCollector.translateToLocal("tooltip.ophidian_sword.desc"));
	}
    
    @Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1) {
    	if (entityliving.worldObj.provider.dimensionId == -1) {
		if ((new Random()).nextInt(40) == 3 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(Items.glowstone_dust, 1);
			}
		}
		else if ((new Random()).nextInt(40) == 2 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(Items.quartz, 1);
			}
		}
		else if ((new Random()).nextInt(60) == 1 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(Items.gold_ingot, 1);
			}
		}
		else if ((new Random()).nextInt(40) == 0 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(Items.magma_cream, 1);
			}
		else if ((new Random()).nextInt(150) == 4 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(Items.ghast_tear, 1);
				}
			}
		else if ((new Random()).nextInt(65) == 5 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(NovaCraftItems.blazing_coal, 1);
				}
			}
		else if ((new Random()).nextInt(40) == 6 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(Items.gunpowder, 1);
				}
			}
			
		else if (this == NovaCraftItems.ophidian_sword && (entityliving.isEntityUndead() || entityliving.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD)) {

			float damage = 13.0F;

			int level = EnchantmentHelper.getEnchantmentLevel(Enchantment.smite.effectId, itemstack);

			if (level > 0)
			{
				damage += (level * 3);
			}

			entityliving.attackEntityFrom(DamageSource.drown, damage);
			}
		 }
    	}
    	
    	else if (this == NovaCraftItems.ophidian_sword) {

			float damage = 13.0F;

			int level = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, itemstack);
			int level2 = EnchantmentHelper.getEnchantmentLevel(Enchantment.smite.effectId, itemstack);

			if (level > 0)
			{
				damage += (level * 1.5);
			}
			if (level2 > 0)
			{
				damage += (level2 * 1.5);
			}

			entityliving.attackEntityFrom(DamageSource.inFire, damage);
			}
    	
		itemstack.damageItem(1, entityliving1);
    	
		return true;
    }
}
