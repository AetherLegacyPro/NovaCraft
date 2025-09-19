package com.NovaCraft.Items.Armor.crown;

import java.util.List;

import org.apache.logging.log4j.Level;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.Items.Armor.NCArmorMaterial;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class ItemVaniteNotchedCrown extends ItemArmor {
	
	boolean wearing_ancient_leggings;

	 public ItemVaniteNotchedCrown() {
	        super(NCArmorMaterial.BASE_CROWN, 0, 0);
	        this.setCreativeTab(NovaCraftCreativeTabs.tools);
	    }
	    
	    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
	        if (stack.getItem() == NovaCraftItems.vanite_notched_crown) {
	            return "nova_craft:textures/armor/vanite_crown/vanite_notched_layer_1.png";
	        }
	        FMLLog.log(Level.ERROR, "Invaild Texture for Notched Vanite Crown", new Object[0]);
	        return null;
	    }
	    
	    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
	 	   tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.notched_vanite_crown.desc"));
	 	}
	
	    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
	        boolean hasCrown = false;
	        boolean hasAncientLegs = false;
	        final ItemStack helmet = player.getCurrentArmor(3);
	        final ItemStack legs = player.getCurrentArmor(1);
	        if (helmet != null) {
	        	hasCrown = (helmet.getItem() == NovaCraftItems.vanite_notched_crown);
	        }
	        if (legs != null) {
	        	hasAncientLegs = (legs.getItem() == NovaCraftItems.ancient_leggings);
	        }
	        if (!hasAncientLegs) {
	        	wearing_ancient_leggings = false;
	        }
	        if (hasAncientLegs) {
	        	wearing_ancient_leggings = true;
	        }
	        if (hasCrown) {
	        	player.triggerAchievement(AchievementsNovaCraft.showing_off);
	        }
	    }
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.tophinite_gemstone;
	}

	public boolean isBetween(ItemStack tool, int max, int min) {
		int origin = tool.getItemDamage();
		int maxDamage = tool.getMaxDamage();

		return origin <= maxDamage - max && origin >= maxDamage - min ? true : false;
	}
	
	public Multimap getItemAttributeModifiers() {
		if (wearing_ancient_leggings != true) {
        Multimap multimap = HashMultimap.create();
        multimap.put(SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "speed_boost", 0.20D, 2));
        	return multimap;
		}
		else {
			Multimap multimap = HashMultimap.create();
			return multimap;
		}
     }
	
	public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }

}
