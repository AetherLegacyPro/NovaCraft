package com.NovaCraft.Items;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemKlagniteIngot extends Item {
	
	public ItemKlagniteIngot()
    {
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

	public boolean isBeaconPayment(final ItemStack stack) {
	     return true;
	 }
	 
	public boolean hasCustomEntity(final ItemStack stack) {
	      return true;
	 }
	    
	public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
	       return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
	 }

}
