package com.NovaCraft.Items.Tools;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemCrystallizedVaniteShovel extends ItemSpade
{
    public ItemCrystallizedVaniteShovel() {
        super(NCToolMaterial.CRYSTALLIZED_VANITE);
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
   		return repair.getItem() == NovaCraftItems.crystallized_vanite_alloy;
   	}
    
    @Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving) {
    	if (world.provider.dimensionId == -1) {
		if (!world.isRemote && world.rand.nextInt(125) == 5) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.magma_cream, 1));

			world.spawnEntityInWorld(entityItem);
		}
		else if (!world.isRemote && world.rand.nextInt(75) == 4) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.quartz, 1));

			world.spawnEntityInWorld(entityItem);
		}
		else if (!world.isRemote && world.rand.nextInt(75) == 3) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gold_ingot, 1));

			world.spawnEntityInWorld(entityItem);
		}
		else if (!world.isRemote && world.rand.nextInt(50) == 2) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.glowstone_dust, 1));

			world.spawnEntityInWorld(entityItem);
		 }
		else if (!world.isRemote && world.rand.nextInt(150) == 6) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.ghast_tear, 1));

			world.spawnEntityInWorld(entityItem);
		 }
		else if (!world.isRemote && world.rand.nextInt(41) == 8) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gunpowder, 1));

			world.spawnEntityInWorld(entityItem);
		 }
		else if (!world.isRemote && world.rand.nextInt(65) == 7) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.blazing_coal, 1));

			world.spawnEntityInWorld(entityItem);
		 }
    	}

		return super.onBlockDestroyed(stack, world, block, x, y, z, entityLiving);
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
  	   tooltip.add(EnumChatFormatting.DARK_AQUA + "" + StatCollector.translateToLocal("tooltip.crystallized_vanite_tools.desc"));
  	}
}
