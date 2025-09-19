package com.NovaCraft.Items.Tools;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.entity.misc.KlangiteSwordProjectile;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemKlangiteSword extends ItemSword
{
    public ItemKlangiteSword() {
        super(NCToolMaterial.KLANGITE_SWORD);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
    
    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public EnumAction getItemUseAction(final ItemStack p_77661_1_) {
        return EnumAction.none;
    }
    
    public ItemStack onItemRightClick(final ItemStack item, final World world, final EntityPlayer player) {
        if (player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(NovaCraftItems.xancium_pellet)) {
            final KlangiteSwordProjectile projectile = new KlangiteSwordProjectile(world, (EntityLivingBase)player);
            player.swingItem();
            world.playSoundAtEntity((Entity)player, "mob.ghast.fireball", 1.0f, 1.0f / (ItemKlangiteSword.itemRand.nextFloat() * 0.605f + 0.71f));
            world.playSoundAtEntity((Entity)player, "fire.ignite", 1.0f, 1.0f / (ItemKlangiteSword.itemRand.nextFloat() * 0.7f + 1.1f));
            world.playSoundAtEntity((Entity)player, "random.fizz", 1.5f, 1.5f / (ItemKlangiteSword.itemRand.nextFloat() * 0.6f + 0.9f));
            if (!world.isRemote) {
                world.spawnEntityInWorld((Entity)projectile);
            }
        }
        if (player.capabilities.isCreativeMode || player.inventory.hasItem(NovaCraftItems.xancium_pellet)) {
            player.setItemInUse(item, this.getMaxItemUseDuration(item));
        }
        item.damageItem(1, (EntityLivingBase)player);
        return item;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
    
    @Override
   	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
   		return repair.getItem() == NovaCraftItems.klangite_ingot;
   	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.klangite_sword.desc"));
    }
}
