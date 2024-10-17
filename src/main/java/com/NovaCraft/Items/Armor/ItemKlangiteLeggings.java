package com.NovaCraft.Items.Armor;

import cpw.mods.fml.common.FMLLog;

import java.util.List;

import org.apache.logging.log4j.Level;

import com.NovaCraft.Items.NovaCraftItems;
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

public class ItemKlangiteLeggings extends ItemArmor implements ISpecialArmor
{
    public ItemKlangiteLeggings() {
        super(NCArmorMaterial.KLANGITE, 0, 2);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.klangite_leggings) {
            return "nova_craft:textures/armor/klangite_layer_2.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Klangite Leggings", new Object[0]);
        return null;
    }
    
    @Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.klangite_ingot;
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.klangite_armor.desc"));
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
    	ItemKlangiteLeggings armorItem = (ItemKlangiteLeggings) armor.getItem();
		ArmorProperties ap = new ArmorProperties(0, source.isUnblockable() ? 0 : armorItem.damageReduceAmount / 27D, armorItem.getMaxDamage() + 1 - armor.getItemDamage());
		return ap;
	}
    
    @Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		if (!source.isUnblockable()) {
				stack.damageItem(damage, entity);
		}
	}
    
}
