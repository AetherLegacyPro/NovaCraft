package com.NovaCraft.Items.Potions;

import java.util.List;
import com.NovaCraft.Items.ItemNovaCraftFood;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPotionHaste extends ItemNovaCraftFood {

	public ItemPotionHaste() {
		super(0);
		this.setMaxStackSize(4);
		 this.setCreativeTab(NovaCraftCreativeTabs.potions);
		this.setAlwaysEdible();
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.rare;
	}

	@Override
	public boolean hasEffect(ItemStack stack, int pass) {
		return true;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 38400, 0));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		boolean creative = player.capabilities.isCreativeMode;

		if (!creative) {
			--stack.stackSize;
		}

		if (!world.isRemote) {
			this.onFoodEaten(stack, world, player);
			player.triggerAchievement(AchievementsNovaCraft.super_buff);
		}

		if (!creative) {
			if (stack.stackSize <= 0) {
				return new ItemStack(NovaCraftItems.vanite_bottle);
			}

			player.inventory.addItemStackToInventory(new ItemStack(NovaCraftItems.vanite_bottle));
		}

		return stack;
	}
	
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.drink;
    }
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.haste.recipe.desc"));
        tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.haste.desc"));
    }

}
