package com.NovaCraft.Items.Tools;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemTophiniteHammer extends ItemSword
{
    public ItemTophiniteHammer() {
        super(NCToolMaterial.TOPHINITE_HAMMER);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
    
    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
    
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
    	
    	int rand = (int)(1 + Math.random() * 6);
		switch (rand)
        {
        	case 1: ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 70, 1));
        		break;
    		case 2: ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.harm.id, 0, 0));
    			break;
    		case 3: ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 30, 0));
    			break;
    		case 4: ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 70, 0));
    			break;
    		case 5:
    			break;
    		case 6:
    			break;
    			
		}
		return false;
	}
    
    @Override
   	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
   		return repair.getItem() == NovaCraftItems.tophinite_gemstone;
   	}
}
