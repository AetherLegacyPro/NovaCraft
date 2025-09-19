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
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemKylaziteHelmet extends ItemArmor implements ISpecialArmor
{
    public ItemKylaziteHelmet() {
        super(NCArmorMaterial.KYLAZITE, 0, 0);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }
    
    public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type) {
        if (stack.getItem() == NovaCraftItems.kylazite_helmet) {
            return "nova_craft:textures/armor/kylazite_layer_1.png";
        }
        FMLLog.log(Level.ERROR, "Invaild Texture for Kylazite Helmet", new Object[0]);
        return null;
    }
    
    @Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == NovaCraftItems.nullified_dust;
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.DARK_PURPLE + "" + StatCollector.translateToLocal("tooltip.kylazite_armor.desc"));
    }
    
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        boolean hasKylaziteHelmet = false;
        boolean hasKylaziteChest = false;
        boolean hasKylaziteLegs = false;
        boolean hasKylaziteBoots = false;
        final ItemStack helmet = player.getCurrentArmor(3);
        final ItemStack chest = player.getCurrentArmor(2);
        final ItemStack legs = player.getCurrentArmor(1);
        final ItemStack boots = player.getCurrentArmor(0);
        if (helmet != null) {
            hasKylaziteHelmet = (helmet.getItem() == NovaCraftItems.kylazite_helmet);
        }
        if (chest != null) {
            hasKylaziteChest = (chest.getItem() == NovaCraftItems.kylazite_chestplate);
        }
        if (legs != null) {
            hasKylaziteLegs = (legs.getItem() == NovaCraftItems.kylazite_leggings);
        }
        if (boots != null) {
            hasKylaziteBoots = (boots.getItem() == NovaCraftItems.kylazite_boots);
        }
        if (hasKylaziteHelmet && hasKylaziteChest && hasKylaziteLegs && hasKylaziteBoots) {
            
            if(!world.isRemote) {
        		AxisAlignedBB axisalignedbb = player.boundingBox;
        		List<EntityLivingBase> volume = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb.expand(2, 3, 2));
        		int rand = (int)(1 + Math.random() * 66);
        		 for(Entity entity : volume) {
        			 if(!(entity instanceof EntityPlayer) && !(entity instanceof EntityAnimal) && rand == 1) {
        				 entity.attackEntityFrom(DamageSource.causeThornsDamage(player), 5F);
        			 }
        		  }
        		 }
        }
        else if ((hasKylaziteHelmet && hasKylaziteChest && hasKylaziteLegs && !hasKylaziteBoots)
        		|| (hasKylaziteHelmet && hasKylaziteChest && !hasKylaziteLegs && hasKylaziteBoots)
        		|| (hasKylaziteHelmet && !hasKylaziteChest && hasKylaziteLegs && hasKylaziteBoots)
        		|| (!hasKylaziteHelmet && hasKylaziteChest && hasKylaziteLegs && hasKylaziteBoots)) {
                
                if(!world.isRemote) {
            		AxisAlignedBB axisalignedbb = player.boundingBox;
            		List<EntityLivingBase> volume = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb.expand(2, 3, 2));
            		int rand = (int)(1 + Math.random() * 76);
            		 for(Entity entity : volume) {
            			 if(!(entity instanceof EntityPlayer) && !(entity instanceof EntityAnimal) && rand == 1) {
            				 entity.attackEntityFrom(DamageSource.causeThornsDamage(player), 3F);
            			 }
            		  }
            		 }
            }
        else {
        	if(!world.isRemote) {
        		AxisAlignedBB axisalignedbb = player.boundingBox;
        		List<EntityLivingBase> volume = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb.expand(2, 3, 2));
        		int rand = (int)(1 + Math.random() * 96);
        		 for(Entity entity : volume) {
        			 if(!(entity instanceof EntityPlayer) && !(entity instanceof EntityAnimal) && rand == 1) {
        				 entity.attackEntityFrom(DamageSource.causeThornsDamage(player), 2F);
        			 }
        		  }
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
    	ItemKylaziteHelmet armorItem = (ItemKylaziteHelmet) armor.getItem();
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
