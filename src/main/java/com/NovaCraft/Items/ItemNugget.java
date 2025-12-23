package com.NovaCraft.Items;

import java.util.List;

import com.NovaCraft.Items.Food.ItemCaveStew;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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

public class ItemNugget extends Item {

	private static final String[] types;
    private IIcon[] textures;
    
    public ItemNugget() {
    	
        this.setHasSubtypes(true);
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
    
    public int getMetadata(final int meta) {
        return meta;
    }
    
    public void registerIcons(final IIconRegister iconRegister) {
        this.textures = new IIcon[ItemNugget.types.length];
        for (int i = 0; i < ItemNugget.types.length; ++i) {
            this.textures[i] = iconRegister.registerIcon("nova_craft:" + ItemNugget.types[i]);
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
        if (meta < 0 || meta >= ItemNugget.types.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + ItemNugget.types[meta];
    }
    
    public void getSubItems(final Item item, final CreativeTabs creativeTabs, final List list) {
        for (int meta = 0; meta < ItemNugget.types.length; ++meta) {
            list.add(new ItemStack(item, 1, meta));
        }
    }
    
    static {
        types = new String[] { "diamond_nugget", "emerald_nugget", "farlander_nugget" };
    }
}
