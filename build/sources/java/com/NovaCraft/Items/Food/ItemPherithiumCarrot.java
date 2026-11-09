package com.NovaCraft.Items.Food;

import com.NovaCraft.Items.ItemNovaCraftFood;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

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
