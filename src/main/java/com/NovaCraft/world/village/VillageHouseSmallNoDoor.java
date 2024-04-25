package com.NovaCraft.world.village;

import java.util.Random;

import com.NovaCraft.entity.illager.EntityIllagerTrader;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class VillageHouseSmallNoDoor extends WorldGenerator
{
	private static final Block planks = Blocks.planks;
	private static final Block wood = Blocks.log2;
	private static final Block thinGlass = Blocks.glass_pane;
	private static final Block cobbledGrimstone = NovaCraftBlocks.cobbled_grimstone;
	private static final Block air = Blocks.air;
	
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] {
				Blocks.snow,
				Blocks.sand,
				Blocks.stone,
				Blocks.grass
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		Block checkID = world.getBlock(i, j, k);

		while (checkID != air){
			distanceToAir++;
			checkID = world.getBlock(i, j + distanceToAir, k);
		}

		if (distanceToAir > 2){
			return false;
		}
		j += distanceToAir - 1;

		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j+1, k);
		Block blockIDBelow = world.getBlock(i, j-1, k);
		for (Block x : GetValidSpawnBlocks()){
			if (blockIDAbove != air){
				return false;
			}
			if ((blockID == Blocks.snow && blockIDBelow == x) || (blockID == Blocks.tallgrass && blockIDBelow == x) || (blockID == Blocks.red_flower && blockIDBelow == x) || (blockID == Blocks.yellow_flower && blockIDBelow == x) || (blockID == Blocks.deadbush && blockIDBelow == x) || (blockID == Blocks.cactus && blockIDBelow == x) || (blockID == Blocks.brown_mushroom && blockIDBelow == x) || (blockID == Blocks.red_mushroom && blockIDBelow == x)){
				return true;
			}
			else if (blockID == x){
				return true;
			}
		}
		return false;
	}

	public VillageHouseSmallNoDoor() { }

	public boolean checkAllLocations(World world, int i, int j, int k){
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 4, j, k) || !LocationIsValidSpawn(world, i + 4, j, k + 5) || !LocationIsValidSpawn(world, i, j, k + 5) || !AirLocationIsValidSpawn(world, i, j + 5, k) || !AirLocationIsValidSpawn(world, i + 4, j + 5, k) || !AirLocationIsValidSpawn(world, i + 4, j + 5, k + 5) || !AirLocationIsValidSpawn(world, i, j + 5, k + 5))
		{
			return false;
		}

		return true;
	}
	
	public boolean AirLocationIsValidSpawn(World world, int i, int j, int k){
		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j+1, k);
		
		if (blockID != air || blockIDAbove != air){
			return false;
		}

		return true;
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 4, j, k) || !LocationIsValidSpawn(world, i + 4, j, k + 5) || !LocationIsValidSpawn(world, i, j, k + 5) || !AirLocationIsValidSpawn(world, i, j + 5, k) || !AirLocationIsValidSpawn(world, i + 4, j + 5, k) || !AirLocationIsValidSpawn(world, i + 4, j + 5, k + 5) || !AirLocationIsValidSpawn(world, i, j + 5, k + 5))
		{
			return false;
		}

		world.setBlock(i + 0, j + 1, k + 0, air);
		world.setBlock(i + 0, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 1, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 0, air);
		world.setBlock(i + 0, j + 2, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 2, k + 2, planks, 5, 2);
		world.setBlock(i + 0, j + 2, k + 3, planks, 5, 2);
		world.setBlock(i + 0, j + 2, k + 4, planks, 5, 2);
		world.setBlock(i + 0, j + 2, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 0, air);
		world.setBlock(i + 0, j + 3, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 3, k + 2, planks, 5, 2);
		world.setBlock(i + 0, j + 3, k + 3, thinGlass, 0, 2);
		world.setBlock(i + 0, j + 3, k + 4, planks, 5, 2);
		world.setBlock(i + 0, j + 3, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 0, air);
		world.setBlock(i + 0, j + 4, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 4, k + 2, planks, 5, 2);
		world.setBlock(i + 0, j + 4, k + 3, planks, 5, 2);
		world.setBlock(i + 0, j + 4, k + 4, planks, 5, 2);
		world.setBlock(i + 0, j + 4, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 0, j + 5, k + 0, air);
		world.setBlock(i + 0, j + 5, k + 1, wood, 1, 2);
		world.setBlock(i + 0, j + 5, k + 2, wood, 1, 2);
		world.setBlock(i + 0, j + 5, k + 3, wood, 1, 2);
		world.setBlock(i + 0, j + 5, k + 4, wood, 1, 2);
		world.setBlock(i + 0, j + 5, k + 5, wood, 1, 2);
		world.setBlock(i + 1, j + 1, k + 0, air);
		world.setBlock(i + 1, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 1, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 1, j + 2, k + 0, air);
		world.setBlock(i + 1, j + 2, k + 1, planks, 5, 2);
		world.setBlock(i + 1, j + 2, k + 2, air);
		world.setBlock(i + 1, j + 2, k + 3, air);
		world.setBlock(i + 1, j + 2, k + 4, air);
		world.setBlock(i + 1, j + 2, k + 5, planks, 5, 2);
		world.setBlock(i + 1, j + 3, k + 0, air);
		world.setBlock(i + 1, j + 3, k + 1, planks, 5, 2);
		world.setBlock(i + 1, j + 3, k + 2, air);
		world.setBlock(i + 1, j + 3, k + 3, air);
		world.setBlock(i + 1, j + 3, k + 4, air);
		world.setBlock(i + 1, j + 3, k + 5, planks, 5, 2);
		world.setBlock(i + 1, j + 4, k + 0, air);
		world.setBlock(i + 1, j + 4, k + 1, planks, 5, 2);
		world.setBlock(i + 1, j + 4, k + 2, air);
		world.setBlock(i + 1, j + 4, k + 3, air);
		world.setBlock(i + 1, j + 4, k + 4, air);
		world.setBlock(i + 1, j + 4, k + 5, planks, 5, 2);
		world.setBlock(i + 1, j + 5, k + 0, air);
		world.setBlock(i + 1, j + 5, k + 1, wood, 1, 2);
		world.setBlock(i + 1, j + 5, k + 2, planks, 5, 2);
		world.setBlock(i + 1, j + 5, k + 3, planks, 5, 2);
		world.setBlock(i + 1, j + 5, k + 4, planks, 5, 2);
		world.setBlock(i + 1, j + 5, k + 5, wood, 1, 2);
		world.setBlock(i + 2, j + 1, k + 0, NovaCraftBlocks.cobbled_grimstone_stairs, 2, 2);
		world.setBlock(i + 2, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 1, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 2, j + 2, k + 0, air);
		world.setBlock(i + 2, j + 2, k + 1, air);
		world.setBlock(i + 2, j + 2, k + 2, air);
		world.setBlock(i + 2, j + 2, k + 3, air);
		world.setBlock(i + 2, j + 2, k + 4, air);
		world.setBlock(i + 2, j + 2, k + 5, planks, 5, 2);
		world.setBlock(i + 2, j + 3, k + 0, air);
		world.setBlock(i + 2, j + 3, k + 1, air);
		world.setBlock(i + 2, j + 3, k + 2, air);
		world.setBlock(i + 2, j + 3, k + 3, air);
		world.setBlock(i + 2, j + 3, k + 4, air);
		world.setBlock(i + 2, j + 3, k + 5, thinGlass, 0, 2);
		world.setBlock(i + 2, j + 4, k + 0, air);
		world.setBlock(i + 2, j + 4, k + 1, planks, 5, 2);
		world.setBlock(i + 2, j + 4, k + 3, air);
		world.setBlock(i + 2, j + 4, k + 4, air);
		world.setBlock(i + 2, j + 4, k + 5, planks, 5, 2);
		world.setBlock(i + 2, j + 5, k + 0, air);
		world.setBlock(i + 2, j + 5, k + 1, wood, 1, 2);
		world.setBlock(i + 2, j + 5, k + 2, planks, 5, 2);
		world.setBlock(i + 2, j + 5, k + 3, planks, 5, 2);
		world.setBlock(i + 2, j + 5, k + 4, planks, 5, 2);
		world.setBlock(i + 2, j + 5, k + 5, wood, 1, 2);
		world.setBlock(i + 3, j + 1, k + 0, air);
		world.setBlock(i + 3, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 1, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 3, j + 2, k + 0, air);
		world.setBlock(i + 3, j + 2, k + 1, planks, 5, 2);
		world.setBlock(i + 3, j + 2, k + 2, air);
		world.setBlock(i + 3, j + 2, k + 3, air);
		world.setBlock(i + 3, j + 2, k + 4, air);
		world.setBlock(i + 3, j + 2, k + 5, planks, 5, 2);
		world.setBlock(i + 3, j + 3, k + 0, air);
		world.setBlock(i + 3, j + 3, k + 1, planks, 5, 2);
		world.setBlock(i + 3, j + 3, k + 2, air);
		world.setBlock(i + 3, j + 3, k + 3, air);
		world.setBlock(i + 3, j + 3, k + 4, air);
		world.setBlock(i + 3, j + 3, k + 5, planks, 5, 2);
		world.setBlock(i + 3, j + 4, k + 0, air);
		world.setBlock(i + 3, j + 4, k + 1, planks, 5, 2);
		world.setBlock(i + 3, j + 4, k + 2, air);
		world.setBlock(i + 3, j + 4, k + 3, air);
		world.setBlock(i + 3, j + 4, k + 4, air);
		world.setBlock(i + 3, j + 4, k + 5, planks, 5, 2);
		world.setBlock(i + 3, j + 5, k + 0, air);
		world.setBlock(i + 3, j + 5, k + 1, wood, 1, 2);
		world.setBlock(i + 3, j + 5, k + 2, planks, 5, 2);
		world.setBlock(i + 3, j + 5, k + 3, planks, 5, 2);
		world.setBlock(i + 3, j + 5, k + 4, planks, 5, 2);
		world.setBlock(i + 3, j + 5, k + 5, wood, 1, 2);
		world.setBlock(i + 4, j + 1, k + 0, air);
		world.setBlock(i + 4, j + 1, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 2, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 3, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 4, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 1, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 2, k + 0, air);
		world.setBlock(i + 4, j + 2, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 2, k + 2, planks, 5, 2);
		world.setBlock(i + 4, j + 2, k + 3, planks, 5, 2);
		world.setBlock(i + 4, j + 2, k + 4, planks, 5, 2);
		world.setBlock(i + 4, j + 2, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 3, k + 0, air);
		world.setBlock(i + 4, j + 3, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 3, k + 2, planks, 5, 2);
		world.setBlock(i + 4, j + 3, k + 3, thinGlass, 0, 2);
		world.setBlock(i + 4, j + 3, k + 4, planks, 5, 2);
		world.setBlock(i + 4, j + 3, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 4, k + 0, air);
		world.setBlock(i + 4, j + 4, k + 1, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 4, k + 2, planks, 5, 2);
		world.setBlock(i + 4, j + 4, k + 3, planks, 5, 2);
		world.setBlock(i + 4, j + 4, k + 4, planks, 5, 2);
		world.setBlock(i + 4, j + 4, k + 5, cobbledGrimstone, 0, 2);
		world.setBlock(i + 4, j + 5, k + 0, air);
		world.setBlock(i + 4, j + 5, k + 1, wood, 1, 2);
		world.setBlock(i + 4, j + 5, k + 2, wood, 1, 2);
		world.setBlock(i + 4, j + 5, k + 3, wood, 1, 2);
		world.setBlock(i + 4, j + 5, k + 4, wood, 1, 2);
		world.setBlock(i + 4, j + 5, k + 5, wood, 1, 2);
		world.setBlock(i + 2, j + 4, k + 2, Blocks.torch, 3, 2);
		if(rand.nextInt(2) == 0){
			world.setBlock(i + 3, j + 2, k + 3, Blocks.chest, 0, 2);
			TileEntityChest chest = new TileEntityChest();
			world.setTileEntity(i + 3, j + 2, k + 3, chest);

			for(int slot = 0; slot < chest.getSizeInventory(); slot++){
				int num = rand.nextInt(150);
				if(num == 0)
					chest.setInventorySlotContents(slot, new ItemStack(Items.apple));
				else if(num == 1)
					chest.setInventorySlotContents(slot, new ItemStack(Items.golden_apple));
				else if(num == 2)
					chest.setInventorySlotContents(slot, new ItemStack(Items.mushroom_stew));
				else if(num == 3)
					chest.setInventorySlotContents(slot, new ItemStack(Items.bread));
				else if(num == 4)
					chest.setInventorySlotContents(slot, new ItemStack(Items.cooked_porkchop));
				else if(num == 5)
					chest.setInventorySlotContents(slot, new ItemStack(Items.porkchop));
				else if(num == 6)
					chest.setInventorySlotContents(slot, new ItemStack(Items.wheat));
				else if(num == 7)
					chest.setInventorySlotContents(slot, new ItemStack(Items.milk_bucket));
				else if(num == 8)
					chest.setInventorySlotContents(slot, new ItemStack(Items.egg));
				else if(num == 9)
					chest.setInventorySlotContents(slot, new ItemStack(Items.fish));
				else if(num == 10)
					chest.setInventorySlotContents(slot, new ItemStack(Items.cooked_fished));
				else if(num == 11)
					chest.setInventorySlotContents(slot, new ItemStack(Items.sugar));
				else if(num == 12)
					chest.setInventorySlotContents(slot, new ItemStack(Items.cake));
				else if(num == 13)
					chest.setInventorySlotContents(slot, new ItemStack(Items.cookie));
				else if(num == 14)
					chest.setInventorySlotContents(slot, new ItemStack(Items.beef));
				else if(num == 15)
					chest.setInventorySlotContents(slot, new ItemStack(Items.cooked_beef));
				else if(num == 16)
					chest.setInventorySlotContents(slot, new ItemStack(Items.chicken));
				else if(num == 17)
					chest.setInventorySlotContents(slot, new ItemStack(Items.cooked_chicken));
				else if(num == 18)
					chest.setInventorySlotContents(slot, new ItemStack(Items.rotten_flesh));
				else if(num == 19)
					chest.setInventorySlotContents(slot, new ItemStack(Items.carrot));
				else if(num == 20)
					chest.setInventorySlotContents(slot, new ItemStack(Items.potato));
				else if(num == 21)
					chest.setInventorySlotContents(slot, new ItemStack(Items.baked_potato));
				else if(num == 22)
					chest.setInventorySlotContents(slot, new ItemStack(Items.poisonous_potato));
				else if(num == 23)
					chest.setInventorySlotContents(slot, new ItemStack(Items.golden_carrot));
				else if(num == 24)
					chest.setInventorySlotContents(slot, new ItemStack(Items.pumpkin_pie));
				else if(num == 25)
					chest.setInventorySlotContents(slot, new ItemStack(Items.melon));
			}
		}
		
		for(int posX = i; posX <= i + 4; posX++)
			for(int posZ = k; posZ <= k + 5; posZ++){
				int posY = j;		
				boolean isFloorFinished = false;
				while(isFloorFinished == false){		
					if(world.getBlock(posX, posY, posZ) == air || world.getBlock(posX, posY, posZ) == Blocks.tallgrass || world.getBlock(posX, posY, posZ) == Blocks.cactus || world.getBlock(posX, posY, posZ) == Blocks.red_flower || world.getBlock(posX, posY, posZ) == Blocks.yellow_flower || world.getBlock(posX, posY, posZ) == Blocks.deadbush || world.getBlock(posX, posY, posZ) == Blocks.snow || world.getBlock(posX, posY, posZ) == Blocks.water || world.getBlock(posX, posY, posZ) == Blocks.lava || world.getBlock(posX, posY, posZ) == Blocks.brown_mushroom || world.getBlock(posX, posY, posZ) == Blocks.red_mushroom || world.getBlock(posX, posY, posZ) == Blocks.waterlily){
						world.setBlock(posX, posY, posZ, cobbledGrimstone, 0, 2);
						posY--;
					}
					else
						isFloorFinished = true;
				}
			}

			EntityIllagerTrader var5 = new EntityIllagerTrader(world);
			var5.setPosition(i+2, j+2, k-1);
			world.spawnEntityInWorld(var5);

		return true;
	}
}
