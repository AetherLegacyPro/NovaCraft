package com.NovaCraft.world.ancient_city.prisoner;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.world.*;
import java.util.*;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityWardenVessel;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.MathHelper;

public class AncientCitySmallHangingStructure3Gen extends WorldGenerator
{
	public AncientCitySmallHangingStructure3Gen() {

	}
	
	 public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
		 
			world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 2, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 3, k + 0, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 3, k + 0, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 3, k + 0, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 3, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 3, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 3, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 3, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 3, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 3, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 3, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 3, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 3, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 3, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 3, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 3, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 3, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 3, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 3, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 3, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 3, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 3, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 4, k + 0, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 2, j + 4, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 4, k + 0, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 0, j + 4, k + 1, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 4, j + 4, k + 1, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 0, j + 4, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 4, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 4, k + 3, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 4, j + 4, k + 3, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 1, j + 4, k + 4, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 2, j + 4, k + 4, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 4, k + 4, NovaCraftBlocks.nullstone_bricks, 0, 2);
			world.setBlock(i + 0, j + 5, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 5, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 5, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 5, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 5, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 5, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 5, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 5, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 5, k + 4, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 5, k + 4, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 5, k + 4, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 4, j + 5, k + 4, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 0, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 6, k + 0, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 6, k + 0, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 6, k + 0, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 0, j + 6, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 6, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 6, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 6, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 6, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 6, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 6, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 6, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 6, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 6, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 6, k + 4, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 6, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 6, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 6, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 6, k + 4, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 7, k + 0, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 7, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 7, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 7, k + 1, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 0, j + 7, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 7, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 7, k + 2, Blocks.glowstone, 0, 2);
			world.setBlock(i + 3, j + 7, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 4, j + 7, k + 2, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 1, j + 7, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 7, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 3, j + 7, k + 3, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 7, k + 4, NovaCraftBlocks.nullstone_tiles, 0, 2);
			world.setBlock(i + 2, j + 8, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 8, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 8, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 8, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 1, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 1, j + 9, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 3, j + 9, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 9, k + 3, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 10, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 11, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			world.setBlock(i + 2, j + 12, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			
			world.setBlock(i + 2, j + 13, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);
			if ((world.getBlock(i + 2, j + 14, k + 2) == Blocks.air || world.getBlock(i + 2, j + 14, k + 2) == Blocks.gravel) && world.getBlock(i + 2, j + 13, k + 2) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 2, j + 14, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);	            
	        } if ((world.getBlock(i + 2, j + 15, k + 2) == Blocks.air || world.getBlock(i + 2, j + 15, k + 2) == Blocks.gravel) && world.getBlock(i + 2, j + 14, k + 2) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 2, j + 15, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);	            
	        } if ((world.getBlock(i + 2, j + 16, k + 2) == Blocks.air || world.getBlock(i + 2, j + 16, k + 2) == Blocks.gravel) && world.getBlock(i + 2, j + 15, k + 2) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 2, j + 16, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);	            
	        } if ((world.getBlock(i + 2, j + 17, k + 2) == Blocks.air || world.getBlock(i + 2, j + 17, k + 2) == Blocks.gravel) && world.getBlock(i + 2, j + 16, k + 2) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 2, j + 17, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);	            
	        } if ((world.getBlock(i + 2, j + 18, k + 2) == Blocks.air || world.getBlock(i + 2, j + 18, k + 2) == Blocks.gravel) && world.getBlock(i + 2, j + 17, k + 2) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 2, j + 18, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);	            
	        } if ((world.getBlock(i + 2, j + 19, k + 2) == Blocks.air || world.getBlock(i + 2, j + 19, k + 2) == Blocks.gravel) && world.getBlock(i + 2, j + 18, k + 2) == NovaCraftBlocks.nullstone_tiled_wall) {
	            world.setBlock(i + 2, j + 19, k + 2, NovaCraftBlocks.nullstone_tiled_wall, 0, 2);	            
	        }
			
			world.setBlock(i + 2, j + 4, k + 2, NovaCraftBlocks.nullstone_deactivator, 0, 2);
			
			world.setBlock(i + 2, j + 0, k + 2, Blocks.mob_spawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i + 2, j + 0, k + 2);
			
			if (tileentitymobspawner != null)
			{
    		tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_incinerator");

	        NBTTagCompound spawnerNBT = new NBTTagCompound();
	        tileentitymobspawner.writeToNBT(spawnerNBT);

	        NBTTagCompound spawnData = new NBTTagCompound();
	        spawnData.setString("id", "nova_craft.sculk_incinerator");

	        NBTTagList effects = new NBTTagList();

	        NBTTagCompound resistanceEffect = new NBTTagCompound();
	        resistanceEffect.setByte("Id", (byte) 11);
	        resistanceEffect.setByte("Amplifier", (byte) 1);
	        resistanceEffect.setInteger("Duration", Integer.MAX_VALUE);
	        resistanceEffect.setByte("Ambient", (byte) 1);
	        resistanceEffect.setByte("ShowParticles", (byte) 0);

	        effects.appendTag(resistanceEffect);
	        spawnData.setTag("ActiveEffects", effects);
	        
	        spawnerNBT.setTag("SpawnData", spawnData);

	        tileentitymobspawner.readFromNBT(spawnerNBT);
			}
		 
		 return true;
	 }

}
