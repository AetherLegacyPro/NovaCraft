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
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemWardenSword extends ItemSword
{
    public ItemWardenSword() {
        super(NCToolMaterial.WARDEN_SWORD);
        this.setCreativeTab((CreativeTabs)NovaCraftCreativeTabs.tools);
    }
    
    public boolean hasCustomEntity(final ItemStack stack) {
        return true;
    }
    
    public Entity createEntity(final World world, final Entity location, final ItemStack itemstack) {
        return (Entity)new EntityFireProofItemNovaCraft(world, location, itemstack);
    }
    
    @Override
   	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
   		return repair.getItem() == NovaCraftItems.warden_shard;
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
        
        int rand = (int)(1 + Math.random() * 100);
        if (rand < 50) {
		item.damageItem(1, (EntityLivingBase)player);
        }
        
        return item;
    }
    
    @Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase living) {
		EntityPlayer player = (EntityPlayer) living;
		
		player.heal(1.0F);

		return super.hitEntity(stack, target, living);
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.DARK_AQUA + "" + StatCollector.translateToLocal("tooltip.warden_sword.desc"));
    }
}
