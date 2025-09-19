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

public class ItemPherithiumCarrot extends ItemNovaCraftFood {

	public ItemPherithiumCarrot() {
		super(7);

		this.setCreativeTab(NovaCraftCreativeTabs.items);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 400, 1));
	}

}
