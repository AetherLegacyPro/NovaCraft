package com.NovaCraft.Items.Tools;

import java.util.List;

import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemEerieSword extends ItemSword
{
	public ItemEerieSword() {
        super(NCToolMaterial.EERIE_SWORD);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.DARK_PURPLE + "" + StatCollector.translateToLocal("tooltip.eerie_blade.desc"));
    }
}
