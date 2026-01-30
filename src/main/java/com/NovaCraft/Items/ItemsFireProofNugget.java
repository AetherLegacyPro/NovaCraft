package com.NovaCraft.Items;

import java.util.List;

import com.NovaCraft.Items.Food.ItemCaveStew;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
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

public class ItemsFireProofNugget extends Item {

	private static final String[] types;
    private IIcon[] textures;
    
    public ItemsFireProofNugget() {
    	
        this.setHasSubtypes(true);
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }
    
    public int getMetadata(final int meta) {
        return meta;
    }
    
    public void registerIcons(final IIconRegister iconRegister) {
        this.textures = new IIcon[ItemsFireProofNugget.types.length];
        for (int i = 0; i < ItemsFireProofNugget.types.length; ++i) {
            this.textures[i] = iconRegister.registerIcon("nova_craft:" + ItemsFireProofNugget.types[i]);
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
        if (meta < 0 || meta >= ItemsFireProofNugget.types.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + ItemsFireProofNugget.types[meta];
    }
    
    public void getSubItems(final Item item, final CreativeTabs creativeTabs, final List list) {
        for (int meta = 0; meta < ItemsFireProofNugget.types.length; ++meta) {
            list.add(new ItemStack(item, 1, meta));
        }
    }
    
    static {
        types = new String[] { "iridium_nugget", "vanite_nugget", "impure_klangite_nugget" };
    }
    
    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
}
