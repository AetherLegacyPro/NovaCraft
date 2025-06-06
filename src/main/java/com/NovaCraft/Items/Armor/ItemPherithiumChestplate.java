package com.NovaCraft.Items.Armor;

import cpw.mods.fml.common.FMLLog;

import java.util.List;

import org.apache.logging.log4j.Level;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
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

public class ItemPherithiumChestplate extends ItemArmor
{
    public ItemPherithiumChestplate() {
        super(NCArmorMaterial.PHERITHIUM, 0, 1);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.pherithium_chestplate) {
            return "nova_craft:textures/armor/pherithium_layer_1.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Pherithium Chestplate", new Object[0]);
        return null;
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        boolean hasPherithiumHelmet = false;
        boolean hasPherithiumChest = false;
        boolean hasPherithiumLegs = false;
        boolean hasPherithiumBoots = false;
        final ItemStack helmet = player.getCurrentArmor(3);
        final ItemStack chest = player.getCurrentArmor(2);
        final ItemStack legs = player.getCurrentArmor(1);
        final ItemStack boots = player.getCurrentArmor(0);
        if (helmet != null) {
            hasPherithiumHelmet = (helmet.getItem() == NovaCraftItems.pherithium_helmet);
        }
        if (chest != null) {
            hasPherithiumChest = (chest.getItem() == NovaCraftItems.pherithium_chestplate);
        }
        if (legs != null) {
            hasPherithiumLegs = (legs.getItem() == NovaCraftItems.pherithium_leggings);
        }
        if (boots != null) {
            hasPherithiumBoots = (boots.getItem() == NovaCraftItems.pherithium_boots);
        }
        if (hasPherithiumHelmet && hasPherithiumChest && hasPherithiumLegs && hasPherithiumBoots) {
            ((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20, 3));
            player.triggerAchievement(AchievementsNovaCraft.hardcore_miner);
        }
    }
    
    @Override
   	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
   		return repair.getItem() == NovaCraftItems.pherithium_ingot;
   	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
 	   tooltip.add(EnumChatFormatting.GREEN + "" + StatCollector.translateToLocal("tooltip.pherithium_armor.desc"));
 	}
}
