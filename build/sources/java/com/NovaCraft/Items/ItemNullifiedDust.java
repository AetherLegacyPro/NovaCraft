package com.NovaCraft.Items;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemNullifiedDust extends Item
{
    public ItemNullifiedDust()
    {
    	maxStackSize = 16;
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
