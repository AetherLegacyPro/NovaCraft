package com.NovaCraft.Items.Armor;

import cpw.mods.fml.common.FMLLog;

import java.util.List;

import org.apache.logging.log4j.Level;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemSculkLeggings extends ItemArmor
{
	
    public ItemSculkLeggings() {
        super(NCArmorMaterial.SCULK, 0, 2);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }

	public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.sculk_leggings) {
            return "nova_craft:textures/armor/sculk_layer_2.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Sculk Leggings", new Object[0]);
        return null;
    }
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
 	   tooltip.add(EnumChatFormatting.BLUE + "" + StatCollector.translateToLocal("tooltip.sculk_armor.desc"));
 	}
}
