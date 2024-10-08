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

public class ItemPhantomChestplate extends ItemArmor
{
    public ItemPhantomChestplate() {
        super(NCArmorMaterial.PHANTOM, 0, 1);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.phantom_chestplate) {
            return "nova_craft:textures/armor/phantom_layer_1.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Phantom Chestplate", new Object[0]);
        return null;
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        boolean hasPhantomHelmet = false;
        boolean hasPhantomChest = false;
        boolean hasPhantomLegs = false;
        boolean hasPhantomBoots = false;
        final ItemStack helmet = player.getCurrentArmor(3);
        final ItemStack chest = player.getCurrentArmor(2);
        final ItemStack legs = player.getCurrentArmor(1);
        final ItemStack boots = player.getCurrentArmor(0);
        if (helmet != null) {
            hasPhantomHelmet = (helmet.getItem() == NovaCraftItems.phantom_helmet);
        }
        if (chest != null) {
            hasPhantomChest = (chest.getItem() == NovaCraftItems.phantom_chestplate);
        }
        if (legs != null) {
            hasPhantomLegs = (legs.getItem() == NovaCraftItems.phantom_leggings);
        }
        if (boots != null) {
            hasPhantomBoots = (boots.getItem() == NovaCraftItems.phantom_boots);
        }
             
        if (hasPhantomHelmet && hasPhantomChest && hasPhantomLegs && hasPhantomBoots && world.provider.dimensionId == 1) {
            ((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.nightVision.id, 20, 0));
            ((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 1));
        }
    }
    
    @Override
   	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
   		return repair.getItem() == NovaCraftItems.phantom_membrane;
   	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
  	   tooltip.add(EnumChatFormatting.WHITE + "" + StatCollector.translateToLocal("tooltip.phantom_armor.desc"));
  	}
}
