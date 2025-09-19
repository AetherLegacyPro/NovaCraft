package com.NovaCraft.Items.Food;

import java.util.List;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.ItemNovaCraftFood;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCookedFrogLeg extends ItemNovaCraftFood {

	public ItemCookedFrogLeg() {
		super(6);

		this.setCreativeTab(NovaCraftCreativeTabs.items);
	}

}
