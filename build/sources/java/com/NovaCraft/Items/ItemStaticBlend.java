package com.NovaCraft.Items;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import java.util.List;

public class ItemStaticBlend extends Item
{
    public ItemStaticBlend()
    {
    	maxStackSize = 16;
        this.setCreativeTab(NovaCraftCreativeTabs.potions);
    }
    
    @Override
	public boolean hasEffect(ItemStack stack, int pass) {
		return true;
	}

    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.potion.static_blend.desc"));
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.potion.static_blend2.desc"));
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.potion.static_blend3.desc"));
    }
}
