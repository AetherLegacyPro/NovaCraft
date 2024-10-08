package com.NovaCraft.Items.Tools;

import java.util.List;

import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPhoenixRazor extends ItemSword
{
	public ItemPhoenixRazor() {
        super(NCToolMaterial.PHOENIX_RAZOR);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.RED + "" + StatCollector.translateToLocal("tooltip.phoenix_razor.desc"));
    }
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase livingBase1, EntityLivingBase livingBase2) {
		stack.damageItem(1, livingBase2);
		livingBase1.setFire(12);
		return true;
	}
	
	public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
}
