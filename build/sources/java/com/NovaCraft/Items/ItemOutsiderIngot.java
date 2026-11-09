package com.NovaCraft.Items;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemOutsiderIngot extends Item {

	public ItemOutsiderIngot()
    {
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
	
	public boolean isBeaconPayment(final ItemStack stack) {
        return true;
    }
    
    @Override
	public boolean hasEffect(ItemStack stack, int pass) {
		return true;
	}
	
}
