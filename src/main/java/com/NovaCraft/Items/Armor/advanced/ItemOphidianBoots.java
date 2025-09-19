package com.NovaCraft.Items.Armor.advanced;

import cpw.mods.fml.common.FMLLog;

import java.util.List;

import org.apache.logging.log4j.Level;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.Items.Armor.NCArmorMaterial;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemOphidianBoots extends ItemArmor implements ISpecialArmor
{
	int number_of_pieces;
	boolean dimension_nether;
	AttributeModifier damage_boost_nether = new AttributeModifier("generic.attackDamage", 0.125D, 1);
	AttributeModifier damage_boost_other = new AttributeModifier("generic.attackDamage", 0.0625D, 1);
	
    public ItemOphidianBoots() {
        super(NCArmorMaterial.OPHIDIAN, 0, 3);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.ophidian_boots) {
            return "nova_craft:textures/armor/ophidian_layer_1.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Ophidian Boots", new Object[0]);
        return null;
    }
    
    @Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.ophidian_scales;
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.RED + "" + StatCollector.translateToLocal("tooltip.ophidian_armor.desc"));
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        boolean hasOphidianHelmet = false;
        boolean hasOphidianChest = false;
        boolean hasOphidianLegs = false;
        boolean hasOphidianBoots = false;
        final ItemStack helmet = player.getCurrentArmor(3);
        final ItemStack chest = player.getCurrentArmor(2);
        final ItemStack legs = player.getCurrentArmor(1);
        final ItemStack boots = player.getCurrentArmor(0);
        if (helmet != null) {
            hasOphidianHelmet = (helmet.getItem() == NovaCraftItems.ophidian_helmet);
        }
        if (chest != null) {
            hasOphidianChest = (chest.getItem() == NovaCraftItems.ophidian_chestplate);
        }
        if (legs != null) {
            hasOphidianLegs = (legs.getItem() == NovaCraftItems.ophidian_leggings);
        }
        if (boots != null) {
            hasOphidianBoots = (boots.getItem() == NovaCraftItems.ophidian_boots);
        }
        if (hasOphidianHelmet && hasOphidianChest && hasOphidianLegs && hasOphidianBoots) {
        	
        	number_of_pieces = 4;
            if (player.isBurning()) {
            	player.extinguish();
            	((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20, 0));
            }

        }
        else if ((hasOphidianHelmet && !hasOphidianChest && !hasOphidianLegs && !hasOphidianBoots) //1 piece
        		|| (!hasOphidianHelmet && hasOphidianChest && !hasOphidianLegs && !hasOphidianBoots)
        		|| (!hasOphidianHelmet && !hasOphidianChest && hasOphidianLegs && !hasOphidianBoots)
        		|| (!hasOphidianHelmet && !hasOphidianChest && !hasOphidianLegs && hasOphidianBoots)) {
        	
        	number_of_pieces = 1;
        	if (player.isBurning()) {
            	player.extinguish();
        	}
        }
        else if ((hasOphidianHelmet && hasOphidianChest && !hasOphidianLegs && !hasOphidianBoots) //2 pieces
        		|| (hasOphidianHelmet && !hasOphidianChest && hasOphidianLegs && !hasOphidianBoots)
        		|| (hasOphidianHelmet && !hasOphidianChest && !hasOphidianLegs && hasOphidianBoots)
        		|| (!hasOphidianHelmet && hasOphidianChest && hasOphidianLegs && !hasOphidianBoots)
        		|| (!hasOphidianHelmet && hasOphidianChest && !hasOphidianLegs && hasOphidianBoots)
        		|| (!hasOphidianHelmet && !hasOphidianChest && hasOphidianLegs && hasOphidianBoots)) {
        	
        	number_of_pieces = 2;
        	if (player.isBurning()) {
            	player.extinguish();          
        	}
        }
        else if ((hasOphidianHelmet && hasOphidianChest && hasOphidianLegs && !hasOphidianBoots) //3 pieces
        		|| (hasOphidianHelmet && hasOphidianChest && !hasOphidianLegs && hasOphidianBoots)
        		|| (hasOphidianHelmet && !hasOphidianChest && hasOphidianLegs && hasOphidianBoots)
        		|| (!hasOphidianHelmet && hasOphidianChest && hasOphidianLegs && hasOphidianBoots)) {
        	
        	number_of_pieces = 3;
        	if (player.isBurning()) {
            	player.extinguish();
            	((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20, 0));
        	}
        }
        
        if (world.provider.dimensionId == -1 ) {
        	dimension_nether = true;
        }
        else {
        	dimension_nether = false;
        }
    }
    
    public Multimap getItemAttributeModifiers() {
    	if (dimension_nether == false) {
    		Multimap multimap = HashMultimap.create();
        	multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), this.damage_boost_other);
        	return multimap;
    	}
    	else {
    		Multimap multimap = HashMultimap.create();
            multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), this.damage_boost_nether);
            return multimap;	
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
    	ItemOphidianBoots armorItem = (ItemOphidianBoots) armor.getItem();
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
