package com.NovaCraft.Items.Tools;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemKlangiteShovel extends ItemSpade
{
    public ItemKlangiteShovel() {
        super(NCToolMaterial.KLANGITE);  
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
   		return repair.getItem() == NovaCraftItems.klangite_ingot;
   	}
    
    @Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving) {
    	if (world.provider.dimensionId != -1 && world.provider.dimensionId != 1) { //Not Nether or End
    	 if (!world.isRemote && world.rand.nextInt(125) == 5) {
			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.coal, 1));

			 world.spawnEntityInWorld(entityItem);
		 }
    	 else if (!world.isRemote && world.rand.nextInt(500) == 9) {
			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.dye, 4, 1));

			 world.spawnEntityInWorld(entityItem);
		 }
    	 else if (!world.isRemote && world.rand.nextInt(250) == 6) {
			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.redstone, 1));

			 world.spawnEntityInWorld(entityItem);
		 }
    	 else if (!world.isRemote && world.rand.nextInt(280) == 11) {
			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.vanite_chunk, 1));

			 world.spawnEntityInWorld(entityItem);
		 }
    	 else if (!world.isRemote && world.rand.nextInt(240) == 13) {
			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.pherithium_scraps, 2));

			 world.spawnEntityInWorld(entityItem);
		 }
    	 else if (!world.isRemote && world.rand.nextInt(800) == 15) {
			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.diamond, 1));

			 world.spawnEntityInWorld(entityItem);
		 }
    	 else if (!world.isRemote && world.rand.nextInt(400) == 7) {
    		 if (Loader.isModLoaded("etfuturum") && Configs.enableRawOreBlocksStructures == true) {
    			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.raw_ore, 2, 1));

    			 world.spawnEntityInWorld(entityItem);
    		 }
    		 else {
    			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.iron_ingot, 1));

    			 world.spawnEntityInWorld(entityItem);
    		 }
		 }
    	 else if (!world.isRemote && world.rand.nextInt(500) == 8) {
    		 if (Loader.isModLoaded("etfuturum") && Configs.enableRawOreBlocksStructures == true) {
    			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.raw_ore, 2, 2));

    			 world.spawnEntityInWorld(entityItem);
    		 }
    		 else {
    			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gold_ingot, 1));

    			 world.spawnEntityInWorld(entityItem);
    		 }
		 }
    	 else if (!world.isRemote && world.rand.nextInt(35) == 4) {
 			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.flint, 1));

 			world.spawnEntityInWorld(entityItem);
 		 }
    	}
    	
    	
    	if (world.provider.dimensionId == -1) { //Nether
    		if (!world.isRemote && world.rand.nextInt(125) == 5) {
   			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.blazing_coal, 1));

   			 world.spawnEntityInWorld(entityItem);
   		 	}
    		else if (!world.isRemote && world.rand.nextInt(900) == 1) {
      		 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.tophinite_gemstone, 1));

      		 world.spawnEntityInWorld(entityItem);
      		}
    		else if (!world.isRemote && world.rand.nextInt(80) == 6) {
         	EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.glowstone_dust, 1));

         	world.spawnEntityInWorld(entityItem);
         	}
    		else if (!world.isRemote && world.rand.nextInt(70) == 3) {
            EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.quartz, 1));

            world.spawnEntityInWorld(entityItem);
            }
    		else if (!world.isRemote && world.rand.nextInt(30) == 10) {
            EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gold_nugget, 3));

            world.spawnEntityInWorld(entityItem);
           }
    		else if (!world.isRemote && world.rand.nextInt(350) == 21) {
            EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.magma_cream, 1));

            world.spawnEntityInWorld(entityItem);
    		}
    		else if (!world.isRemote && world.rand.nextInt(35) == 4) {
     		EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.flint, 1));

     		world.spawnEntityInWorld(entityItem);
     		 }
    	}
    	
    	if (world.provider.dimensionId == 1) {
    		if (!world.isRemote && world.rand.nextInt(400) == 5) {
      			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.echo_shard, 1));

      			 world.spawnEntityInWorld(entityItem);
      		 	}
    		else if (!world.isRemote && world.rand.nextInt(700) == 6) {
     			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.dark_essence, 1));

     			 world.spawnEntityInWorld(entityItem);
     		 	}
    		else if (!world.isRemote && world.rand.nextInt(50) == 1) {
    			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftBlocks.vacuum_sand, 1));

    			 world.spawnEntityInWorld(entityItem);
    		 	}
    		else if (!world.isRemote && world.rand.nextInt(900) == 7) {
   			 EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.raw_klangite, 1));

   			 world.spawnEntityInWorld(entityItem);
   		 	}
    		else if (!world.isRemote && world.rand.nextInt(35) == 4) {
         		EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.flint, 1));

         		world.spawnEntityInWorld(entityItem);
         		 }
    	}
    	

		return super.onBlockDestroyed(stack, world, block, x, y, z, entityLiving);
	}
    
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List tooltip, final boolean who) {
        tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "" + StatCollector.translateToLocal("tooltip.klangite_shovel.desc"));
    }
}
