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

public class ItemWardenChestplate extends ItemArmor implements ISpecialArmor
{
	AttributeModifier health_increase_overworld = new AttributeModifier("generic.maxHealth", 2.0D, 0);
	
    public ItemWardenChestplate() {
        super(NCArmorMaterial.WARDEN, 0, 1);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.warden_chestplate) {
            return "nova_craft:textures/armor/warden_layer_1.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Warden Chestplate", new Object[0]);
        return null;
    }
    
    @Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.warden_shard;
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.DARK_AQUA + "" + StatCollector.translateToLocal("tooltip.warden_armor.desc"));
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        boolean hasWardenHelmet = false;
        boolean hasWardenChest = false;
        boolean hasWardenLegs = false;
        boolean hasWardenBoots = false;
        final ItemStack helmet = player.getCurrentArmor(3);
        final ItemStack chest = player.getCurrentArmor(2);
        final ItemStack legs = player.getCurrentArmor(1);
        final ItemStack boots = player.getCurrentArmor(0);
        if (helmet != null) {
            hasWardenHelmet = (helmet.getItem() == NovaCraftItems.warden_helmet);
        }
        if (chest != null) {
            hasWardenChest = (chest.getItem() == NovaCraftItems.warden_chestplate);
        }
        if (legs != null) {
            hasWardenLegs = (legs.getItem() == NovaCraftItems.warden_leggings);
        }
        if (boots != null) {
            hasWardenBoots = (boots.getItem() == NovaCraftItems.warden_boots);
        }
        if (hasWardenHelmet && hasWardenChest && hasWardenLegs && hasWardenBoots) {
        	
        	 player.triggerAchievement(AchievementsNovaCraft.warden_insurance);

        }
    }
    
    public Multimap getItemAttributeModifiers() {
    		Multimap multimap = HashMultimap.create();
    		multimap.put(SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), this.health_increase_overworld);
        	return multimap;
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
    	ItemWardenChestplate armorItem = (ItemWardenChestplate) armor.getItem();
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
