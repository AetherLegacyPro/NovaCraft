package com.NovaCraft.Items.Tools;

import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemEerieSword extends ItemSword
{
	public ItemEerieSword() {
        super(NCToolMaterial.EERIE_SWORD);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
}
