package com.NovaCraft.Items.Armor;

import cpw.mods.fml.common.FMLLog;

import java.util.List;

import org.apache.logging.log4j.Level;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemCrystallizedVaniteBoots extends ItemArmor implements ISpecialArmor
{
	
    public ItemCrystallizedVaniteBoots() {
        super(NCArmorMaterial.CRYSTALLIZED_VANITE, 0, 3);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.crystallized_vanite_boots) {
            return "nova_craft:textures/armor/crystallized_vanite_layer_1.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Crystallized Vanite Boots", new Object[0]);
        return null;
    }
    
    @Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.crystallized_vanite_alloy;
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.DARK_AQUA + "" + StatCollector.translateToLocal("tooltip.crystallized_vanite_armor.desc"));
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        boolean hasVaniteHelmet = false;
        boolean hasVaniteChest = false;
        boolean hasVaniteLegs = false;
        boolean hasVaniteBoots = false;
        final ItemStack helmet = player.getCurrentArmor(3);
        final ItemStack chest = player.getCurrentArmor(2);
        final ItemStack legs = player.getCurrentArmor(1);
        final ItemStack boots = player.getCurrentArmor(0);
        if (helmet != null) {
            hasVaniteHelmet = (helmet.getItem() == NovaCraftItems.crystallized_vanite_helmet);
        }
        if (chest != null) {
            hasVaniteChest = (chest.getItem() == NovaCraftItems.crystallized_vanite_chestplate);
        }
        if (legs != null) {
            hasVaniteLegs = (legs.getItem() == NovaCraftItems.crystallized_vanite_leggings);
        }
        if (boots != null) {
            hasVaniteBoots = (boots.getItem() == NovaCraftItems.crystallized_vanite_boots);
        }
        if (hasVaniteHelmet && hasVaniteChest && hasVaniteLegs && hasVaniteBoots) {
            
            if (player.isBurning()) {
            	player.extinguish();
            }
        }
        else if ((hasVaniteHelmet && hasVaniteChest && hasVaniteLegs && !hasVaniteBoots)
        		|| (hasVaniteHelmet && hasVaniteChest && !hasVaniteLegs && hasVaniteBoots)
        		|| (hasVaniteHelmet && !hasVaniteChest && hasVaniteLegs && hasVaniteBoots)
        		|| (!hasVaniteHelmet && hasVaniteChest && hasVaniteLegs && hasVaniteBoots)) {
        	int rand = (int)(1 + Math.random() * 75);
        	if (player.isBurning() && rand == 2) {
            	player.extinguish();
            }
        }
        else {
        	int rand = (int)(1 + Math.random() * 100);
        	if (player.isBurning() && rand == 1) {
            	player.extinguish();
            }
        }
    }
    
    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
    
    @Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return this.damageReduceAmount;
	}
    
    @Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
    	ItemCrystallizedVaniteBoots armorItem = (ItemCrystallizedVaniteBoots) armor.getItem();
		ArmorProperties ap = new ArmorProperties(0, source.isUnblockable() ? 0 : armorItem.damageReduceAmount / 25D, armorItem.getMaxDamage() + 1 - armor.getItemDamage());
		return ap;
	}
    
    @Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		if (!source.isUnblockable()) {
			if (!source.isFireDamage()) {
				stack.damageItem(damage, entity);
			}
		}
	}
}
