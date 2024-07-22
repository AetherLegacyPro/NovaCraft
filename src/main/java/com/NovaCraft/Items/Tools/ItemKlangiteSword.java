package com.NovaCraft.Items.Tools;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemKlangiteSword extends ItemSword
{
    public ItemKlangiteSword() {
        super(NCToolMaterial.KLANGITE_SWORD);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
    
    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public boolean hitEntity(ItemStack stack, EntityLivingBase livingBase1, EntityLivingBase livingBase2) {
    	stack.damageItem(1, livingBase2);
    	int rand = (int)(1 + Math.random() * 10);
		switch (rand)
        {
        case 1:
        	if(livingBase1.isEntityUndead()) {
                livingBase1.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0, true));
            	}
            else {
            	livingBase1.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 0, true));
            	}
        	break;
        default:        	
        	break;
		
        }
    	
		return true;
	}
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
    
    @Override
   	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
   		return repair.getItem() == NovaCraftItems.klangite_ingot;
   	}
}
