package com.NovaCraft.Items.Staffs;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.Items.Tools.NCToolMaterial;
import com.NovaCraft.entity.misc.EntityPrimevalHornProjectile;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemPrimevalHorn extends ItemSword {
	
	public ItemPrimevalHorn() {
		super(NCToolMaterial.PRIMEVAL_HORN);
		this.setCreativeTab(NovaCraftCreativeTabs.tools);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return false;
	}
		

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {		
			itemstack.damageItem(1, entityplayer);

			world.playSound(entityplayer.posX, entityplayer.posY, entityplayer.posZ, "nova_craft:sculk_horn.vibration", 0.22F, 0.22F / (itemRand.nextFloat() * 0.2F + 0.4F), false);

			if (!world.isRemote) {
				EntityPrimevalHornProjectile sculkVibration = new EntityPrimevalHornProjectile(world, entityplayer);
				sculkVibration.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, 1.3F, 1.0F);
				world.spawnEntityInWorld(sculkVibration);
			}

		return itemstack;
	}

}
