package com.NovaCraft.Items.Tools;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSculkedBlade extends ItemSword
{
	public ItemSculkedBlade() {
        super(NCToolMaterial.SCULKED_BLADE);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.sculked_shard;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		EntityPlayer player = (EntityPlayer) attacker;
		
		int rand = (int)(1 + Math.random() * 12);
		switch (rand)
        {
        case 1:
        	if (player.getHealth() < player.getMaxHealth()) {
        		player.heal(2.0F);
				}
        	break;
        default:        	
        	break;
		
        }

		return super.hitEntity(stack, target, attacker);
	}
}
