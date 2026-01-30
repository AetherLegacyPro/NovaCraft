package com.NovaCraft.Items.Potions;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemVaniteBottle extends Item {
	
	private IIcon[] icon;

	public ItemVaniteBottle() {
		this.icon = new IIcon[1];
		maxStackSize = 64;
        this.setCreativeTab(NovaCraftCreativeTabs.potions);
    }
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:vanite_bottle");
    }
	
	public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        return this.icon[meta];
    }

    @Override
    public boolean hasContainerItem() {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(Items.glass_bottle);
    }
	
}
