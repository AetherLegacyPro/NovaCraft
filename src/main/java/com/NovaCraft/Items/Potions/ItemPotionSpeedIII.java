package com.NovaCraft.Items.Potions;

import java.util.List;

import com.NovaCraft.Items.ItemNovaCraftFood;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPotionSpeedIII extends ItemNovaCraftFood {

	private static final String[] types;
	private IIcon[] textures;

	public ItemPotionSpeedIII() {
		super(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(4);
		this.setCreativeTab(NovaCraftCreativeTabs.potions);
		this.setAlwaysEdible();
	}

	public int getMetadata(final int meta) {
		return meta;
	}

	public void registerIcons(final IIconRegister iconRegister) {
		this.textures = new IIcon[ItemPotionSpeedIII.types.length];
		for (int i = 0; i < ItemPotionSpeedIII.types.length; ++i) {
			this.textures[i] = iconRegister.registerIcon("nova_craft:" + ItemPotionSpeedIII.types[i]);
		}
	}

	public IIcon getIconFromDamage(int meta) {
		if (meta < 0 || meta >= this.textures.length) {
			meta = 0;
		}
		return this.textures[meta];
	}

	public String getUnlocalizedName(final ItemStack itemstack) {
		int meta = itemstack.getItemDamage();
		if (meta < 0 || meta >= ItemPotionSpeedIII.types.length) {
			meta = 0;
		}
		return super.getUnlocalizedName() + "." + ItemPotionSpeedIII.types[meta];
	}

	public void getSubItems(final Item item, final CreativeTabs creativeTabs, final List list) {
		for (int meta = 0; meta < ItemPotionSpeedIII.types.length; ++meta) {
			list.add(new ItemStack(item, 1, meta));
		}
	}

	static {
		types = new String[] { "potion_speed", "potion_speed_regular" };
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
		int meta = stack.getItemDamage();
		if (meta == 0) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 7200, 2));
		} else if (meta == 1) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1800, 1));
		}
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
		int meta = stack.getItemDamage();
		if (meta == 0) {
			tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.speedIII.recipe.desc"));
			tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.speedIII.desc"));
		} else if (meta == 1) {
			tooltip.add(EnumChatFormatting.GRAY + "" + StatCollector.translateToLocal("tooltip.potion.speedII.regular.desc"));
		}
    }

}
