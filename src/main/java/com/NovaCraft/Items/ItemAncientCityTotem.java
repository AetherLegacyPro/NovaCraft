package com.NovaCraft.Items;

import java.util.List;

import com.NovaCraft.entity.EntitySculkAbomination;
import com.NovaCraft.entity.EntitySculkDuplicator;
import com.NovaCraft.entity.EntitySculkDweller;
import com.NovaCraft.entity.EntitySculkHunger;
import com.NovaCraft.entity.EntitySculkIncinerator;
import com.NovaCraft.entity.EntitySculkSymbiote;
import com.NovaCraft.entity.EntitySculkedMonitor;
import com.NovaCraft.entity.EntityWarden;
import com.NovaCraft.entity.EntityWardenVessel;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemAncientCityTotem extends Item {
	
	public ItemAncientCityTotem() {
		this.setCreativeTab(NovaCraftCreativeTabs.items);
		maxStackSize = 1;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack, int pass) {
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer player) {		
		if (!player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}
		
		if(!worldIn.isRemote) {
    		AxisAlignedBB axisalignedbb = player.boundingBox;
    		List<EntityLivingBase> volume = worldIn.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb.expand(10, 10, 10));
    		 for(Entity entity : volume) {
    			 if((entity instanceof EntitySculkSymbiote) || (entity instanceof EntitySculkHunger) || (entity instanceof EntitySculkDweller) 
    				|| (entity instanceof EntitySculkAbomination) || (entity instanceof EntitySculkDuplicator) || (entity instanceof EntitySculkedMonitor)
    				|| (entity instanceof EntitySculkIncinerator) || (entity instanceof EntityWardenVessel)) {
    				 worldIn.playSoundAtEntity(player, "nova_craft:totem.use", 1, 1);
    				 player.attackEntityFrom(DamageSource.outOfWorld, 10F);
    				 entity.setDead();
    			 }
    			 else if (entity instanceof EntityWarden) {
    				 worldIn.playSoundAtEntity(player, "nova_craft:totem.use", 1, 1);
    				 player.attackEntityFrom(DamageSource.outOfWorld, 10F);
    				 entity.attackEntityFrom(DamageSource.magic, 50F);
    			 }
    		  }
		}
		return stack;
	}
	
	public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.AQUA + "" + StatCollector.translateToLocal("tooltip.anicent_city_totem.desc"));
    }

}
