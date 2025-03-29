package com.NovaCraft.Items;

import java.util.List;
import java.util.Random;

import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

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
