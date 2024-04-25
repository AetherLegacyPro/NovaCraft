package com.NovaCraft.Items;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemDarkEssence extends Item {
	
	private IIcon[] icon;

	public ItemDarkEssence() {
		this.icon = new IIcon[1];
		maxStackSize = 16;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:dark_essence");
    }
	
	public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        return this.icon[meta];
    }
	
	public boolean isBeaconPayment(final ItemStack stack) {
	    return true;
	}
	
}
