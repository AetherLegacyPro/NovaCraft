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
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemTophiniteLeggings extends ItemArmor implements ISpecialArmor
{
    public ItemTophiniteLeggings() {
        super(NCArmorMaterial.TOPHINITE, 0, 2);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.tophinite_leggings) {
            return "nova_craft:textures/armor/tophinite_layer_2.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Tophinite Leggings", new Object[0]);
        return null;
    }
    
    @Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.tophinite_gemstone;
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.BLUE + "" + StatCollector.translateToLocal("tooltip.tophinite_armor.desc"));
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        boolean hasTophiniteHelmet = false;
        boolean hasTophiniteChest = false;
        boolean hasTophiniteLegs = false;
        boolean hasTophiniteBoots = false;
        final ItemStack helmet = player.getCurrentArmor(3);
        final ItemStack chest = player.getCurrentArmor(2);
        final ItemStack legs = player.getCurrentArmor(1);
        final ItemStack boots = player.getCurrentArmor(0);
        if (helmet != null) {
            hasTophiniteHelmet = (helmet.getItem() == NovaCraftItems.tophinite_helmet);
        }
        if (chest != null) {
            hasTophiniteChest = (chest.getItem() == NovaCraftItems.tophinite_chestplate);
        }
        if (legs != null) {
            hasTophiniteLegs = (legs.getItem() == NovaCraftItems.tophinite_leggings);
        }
        if (boots != null) {
            hasTophiniteBoots = (boots.getItem() == NovaCraftItems.tophinite_boots);
        }
        if (hasTophiniteHelmet && hasTophiniteChest && hasTophiniteLegs && hasTophiniteBoots) {
            player.triggerAchievement(AchievementsNovaCraft.cover_me_with_tophinite);
            
            if (player.isBurning()) {
            	player.extinguish();
            }
        }
        else if ((hasTophiniteHelmet && hasTophiniteChest && hasTophiniteLegs && !hasTophiniteBoots)
        		|| (hasTophiniteHelmet && hasTophiniteChest && !hasTophiniteLegs && hasTophiniteBoots)
        		|| (hasTophiniteHelmet && !hasTophiniteChest && hasTophiniteLegs && hasTophiniteBoots)
        		|| (!hasTophiniteHelmet && hasTophiniteChest && hasTophiniteLegs && hasTophiniteBoots)) {
        	int rand = (int)(1 + Math.random() * 90);
        	if (player.isBurning() && rand == 1) {
            	player.extinguish();
            }
        }
        else {
        	int rand = (int)(1 + Math.random() * 180);
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
    	ItemTophiniteLeggings armorItem = (ItemTophiniteLeggings) armor.getItem();
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
