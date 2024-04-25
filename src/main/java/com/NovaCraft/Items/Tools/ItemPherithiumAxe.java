package com.NovaCraft.Items.Tools;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemPherithiumAxe extends ItemAxe
{
    public ItemPherithiumAxe() {
        super(NCToolMaterial.PHERITHIUM);  
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
    
    @Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.pherithium_ingot;
	}
}
