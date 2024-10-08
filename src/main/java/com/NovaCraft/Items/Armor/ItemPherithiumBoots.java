package com.NovaCraft.Items.Armor;

import cpw.mods.fml.common.FMLLog;

import java.util.List;

import org.apache.logging.log4j.Level;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemPherithiumBoots extends ItemArmor
{
    public ItemPherithiumBoots () {
        super(NCArmorMaterial.PHERITHIUM, 0, 3);
        this.setCreativeTab(NovaCraftCreativeTabs.tools); //.setMaxDamage(277)
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.pherithium_boots) {
            return "nova_craft:textures/armor/pherithium_layer_1.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Pherithium Boots", new Object[0]);
        return null;
    }
    
    @Override
   	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
   		return repair.getItem() == NovaCraftItems.pherithium_ingot;
   	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
 	   tooltip.add(EnumChatFormatting.GREEN + "" + StatCollector.translateToLocal("tooltip.pherithium_armor.desc"));
 	}
}
