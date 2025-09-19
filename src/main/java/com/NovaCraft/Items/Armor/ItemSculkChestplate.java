package com.NovaCraft.Items.Armor;

import cpw.mods.fml.common.FMLLog;

import java.util.List;

import org.apache.logging.log4j.Level;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemSculkChestplate extends ItemArmor
{
    public ItemSculkChestplate() {
        super(NCArmorMaterial.SCULK, 0, 1);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.sculk_chestplate) {
            return "nova_craft:textures/armor/sculk_layer_1.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Sculk Chestplate", new Object[0]);
        return null;
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        boolean hasSculkHelmet = false;
        boolean hasSculkChest = false;
        boolean hasSculkLegs = false;
        boolean hasSculkBoots = false;
        final ItemStack helmet = player.getCurrentArmor(3);
        final ItemStack chest = player.getCurrentArmor(2);
        final ItemStack legs = player.getCurrentArmor(1);
        final ItemStack boots = player.getCurrentArmor(0);
        if (helmet != null) {
            hasSculkHelmet = (helmet.getItem() == NovaCraftItems.sculk_helmet);
        }
        if (chest != null) {
            hasSculkChest = (chest.getItem() == NovaCraftItems.sculk_chestplate);
        }
        if (legs != null) {
            hasSculkLegs = (legs.getItem() == NovaCraftItems.sculk_leggings);
        }
        if (boots != null) {
            hasSculkBoots = (boots.getItem() == NovaCraftItems.sculk_boots);
        }
        if (hasSculkHelmet && hasSculkChest && hasSculkLegs && hasSculkBoots) {
            ((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20, 2));
            ((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 2));
        }
    }
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
 	   tooltip.add(EnumChatFormatting.BLUE + "" + StatCollector.translateToLocal("tooltip.sculk_armor.desc"));
 	}
}
