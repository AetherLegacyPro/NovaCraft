package com.NovaCraft.Items;

import java.util.List;

import com.NovaCraft.NovaCraft;
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

public class ItemCookedChevon extends ItemNovaCraftFood {

	@SideOnly(Side.CLIENT)
	private IIcon alternativeIcon;

	public ItemCookedChevon() {
		super(7);

		this.setHasSubtypes(false);
		this.setCreativeTab(NovaCraftCreativeTabs.items);
		this.setTextureName(NovaCraft.find("cooked_chevon"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister registry) {
		super.registerIcons(registry);

		this.alternativeIcon = registry.registerIcon(NovaCraft.find("cooked_chevon"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return meta == 1 ? this.itemIcon : this.alternativeIcon;
	}

	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void getSubItems(Item item, CreativeTabs tab, List subItems) {
		subItems.add(new ItemStack(this, 1, 0));
	}
}