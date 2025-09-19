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

public class ItemOphidianShovel extends ItemSpade
{
    public ItemOphidianShovel() {
        super(NCToolMaterial.OPHIDIAN);
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
   		return repair.getItem() == NovaCraftItems.deep_one_bone;
   	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
   	   tooltip.add(EnumChatFormatting.RED + "" + StatCollector.translateToLocal("tooltip.ophidian_tools.desc"));
   	}
    
    @Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving) {
    	if (world.provider.dimensionId == -1) {
		if (!world.isRemote && world.rand.nextInt(115) == 5) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.magma_cream, 1));

			world.spawnEntityInWorld(entityItem);
		}
		else if (!world.isRemote && world.rand.nextInt(65) == 4) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.quartz, 1));

			world.spawnEntityInWorld(entityItem);
		}
		else if (!world.isRemote && world.rand.nextInt(65) == 3) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gold_ingot, 1));

			world.spawnEntityInWorld(entityItem);
		}
		else if (!world.isRemote && world.rand.nextInt(50) == 2) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.glowstone_dust, 1));

			world.spawnEntityInWorld(entityItem);
		 }
		else if (!world.isRemote && world.rand.nextInt(140) == 6) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.ghast_tear, 1));

			world.spawnEntityInWorld(entityItem);
		 }
		else if (!world.isRemote && world.rand.nextInt(41) == 8) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gunpowder, 1));

			world.spawnEntityInWorld(entityItem);
		 }
		else if (!world.isRemote && world.rand.nextInt(55) == 7) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.blazing_coal, 1));

			world.spawnEntityInWorld(entityItem);
		 }
		else if (!world.isRemote && world.rand.nextInt(200) == 8) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.flaming_pitcher_petal, 1));

			world.spawnEntityInWorld(entityItem);
		 }
		else if (!world.isRemote && world.rand.nextInt(160) == 9) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.blazing_serpent_tooth, 1));

			world.spawnEntityInWorld(entityItem);
		 }
		else if (!world.isRemote && world.rand.nextInt(750) == 10) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.tophinite_gemstone, 1));

			world.spawnEntityInWorld(entityItem);
		 }
    	}

		return super.onBlockDestroyed(stack, world, block, x, y, z, entityLiving);
	}
}