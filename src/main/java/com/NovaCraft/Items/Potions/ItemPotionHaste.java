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

	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
	{
	    super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
	    p_77654_3_.triggerAchievement(AchievementsNovaCraft.super_buff);
	    
	    if (p_77654_1_.stackSize >= 1) {	    	
	    p_77654_3_.inventory.addItemStackToInventory(new ItemStack(NovaCraftItems.vanite_bottle));
	    
	    }
	    return p_77654_1_.stackSize <= 0 ? new ItemStack(NovaCraftItems.vanite_bottle) : p_77654_1_;
	}
	
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.drink;
    }
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
		tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.haste.recipe.desc"));
        tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.haste.desc"));
    }

}
