package com.NovaCraft.Items.Food;


import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.Items.ItemNovaCraftFood;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemRawGlowSquid extends ItemNovaCraftFood {

	public ItemRawGlowSquid() {
		super(3);

		this.setHasSubtypes(false);
		this.setCreativeTab(NovaCraftCreativeTabs.items);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (player.getHeldItem().getItem() == NovaCraftItems.raw_glow_squid) {
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 160, 0));
		}
	}
}
