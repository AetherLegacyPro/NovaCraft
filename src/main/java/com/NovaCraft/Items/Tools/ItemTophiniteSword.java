package com.NovaCraft.Items.Tools;

import java.util.List;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemTophiniteSword extends ItemSword
{
    public ItemTophiniteSword() {
        super(NCToolMaterial.TOPHINITE_SWORD);
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
   		return repair.getItem() == NovaCraftItems.tophinite_gemstone;
   	}
    
    @Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1) {
    	if (entityliving.worldObj.provider.dimensionId == -1) {
		if ((new Random()).nextInt(50) == 3 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(Items.glowstone_dust, 1);
			}
		}
		else if ((new Random()).nextInt(50) == 2 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(Items.quartz, 1);
			}
		}
		else if ((new Random()).nextInt(50) == 1 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(Items.gold_nugget, 1);
			}
		}
		else if ((new Random()).nextInt(50) == 0 && entityliving1 != null && entityliving1 instanceof EntityPlayer && entityliving.hurtTime > 0 && entityliving.deathTime <= 0) {
			if (!entityliving.worldObj.isRemote) {
				entityliving.dropItem(Items.magma_cream, 1);
			}
		}

		itemstack.damageItem(1, entityliving1);
		return true;
    	}
    	
		return true;
    }
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
 	   tooltip.add(EnumChatFormatting.DARK_AQUA + "" + StatCollector.translateToLocal("tooltip.tophinite_tools.desc"));
 	}
}
