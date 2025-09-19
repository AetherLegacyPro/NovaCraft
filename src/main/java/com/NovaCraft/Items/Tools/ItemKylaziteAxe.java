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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemKylaziteAxe extends ItemAxe
{
    public ItemKylaziteAxe() {
        super(NCToolMaterial.KYLAZITE);
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
   		return repair.getItem() == NovaCraftItems.nullified_dust;
   	}
    
    @Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving) {
    	if (!world.isRemote && world.rand.nextInt(115) == 5) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.coal, 1, 1));

			world.spawnEntityInWorld(entityItem);
		}
		else if (!world.isRemote && world.rand.nextInt(70) == 4) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.stick, 1));

			world.spawnEntityInWorld(entityItem);
		}
		else if (!world.isRemote && world.rand.nextInt(140) == 6) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Blocks.log, 1));

			world.spawnEntityInWorld(entityItem);
		}
		else if (!world.isRemote && world.rand.nextInt(100) == 3) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.apple, 1));

			world.spawnEntityInWorld(entityItem);
		}

		return super.onBlockDestroyed(stack, world, block, x, y, z, entityLiving);
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.DARK_PURPLE + "" + StatCollector.translateToLocal("tooltip.kylazite_axe.desc"));
    }
}
