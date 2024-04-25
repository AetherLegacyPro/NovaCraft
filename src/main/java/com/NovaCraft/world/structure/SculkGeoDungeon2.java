package com.NovaCraft.world.structure;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.DungeonHooks;

public class SculkGeoDungeon2 extends WorldGenerator {
	//Credit Goes to Roadhog360
    
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		final float size = (random.nextInt(3) + 6) + random.nextFloat();
	    final float DISTANCE_NULLSTONE_SQ = (size * size);
	    final float DISTANCE_NULLSTONEBRICKS_SQ = ((size - 1) * (size - 1));
	    final float DISTANCE_AMETHYST_SQ = ((size - 2) * (size - 2));
	    final float DISTANCE_INNER_SQ = ((size - 3) * (size - 3));
	    final int sizeInt = MathHelper.floor_float(size);
	    
	    if(!canGeodeGenerateHere(world, x, y, z, sizeInt)) {
	    	return false;
	    }
	    
		int holeX = -1;
		int holeY = -1;
		int holeZ = -1;
		float radius = -1;
		int holeSize = random.nextFloat() < .95F ? random.nextInt(3) + 5 : -1;
		float holeTheta = 0;
		float holePhi = 0;
		int attempts = 1;
		if(holeSize != -1) {
			holeTheta = (float) (Math.acos(1 - 2 * random.nextFloat()) - Math.PI/2);
			holePhi = (float) (random.nextFloat() * Math.PI * 2);
			radius = size - (random.nextFloat() * 2 + 0.5F) + (random.nextFloat() * 0);
			holeX = Math.round(radius * MathHelper.cos(holePhi) * MathHelper.cos(holeTheta));
			holeY = Math.round(radius * MathHelper.sin(holeTheta));
			holeZ = Math.round(radius * MathHelper.sin(holePhi) * MathHelper.cos(holeTheta));
			//System.out.println("Hole xyz: " + holeX + " " + holeY + " " + holeZ);
			//System.out.println("Hole distance sq: " + (Math.sqrt(holeX * holeX + holeY * holeY + holeZ * holeZ)));
			//System.out.println("Radius & Size: " + radius + " " + size);
			//System.out.println(attempts + " attempts.");
			attempts++;
		}
		
//		if(holeSize > -1) {
//			holeX = random.nextInt(sizeInt * 2) - sizeInt;
//			holeY = random.nextInt(sizeInt * 2) - sizeInt;
//			holeZ = random.nextInt(sizeInt * 2) - sizeInt;
//			int holeDistSq = holeX * holeX + holeY * holeY + holeZ * holeZ;
//			//Keep guessing with random numbers until the hole is at the proper spot since I don't know how to do this right, lmao
//			while(holeDistSq > DISTANCE_NULLSTONEBRICKS_SQ || holeDistSq < DISTANCE_AMETHYST_SQ) {
//				holeX = random.nextInt(sizeInt * 2) - sizeInt;
//				holeY = random.nextInt(sizeInt * 2) - sizeInt;
//				holeZ = random.nextInt(sizeInt * 2) - sizeInt;
//				holeDistSq = holeX * holeX + holeY * holeY + holeZ * holeZ;
//			}
//		}
		
        for (int i = -sizeInt; i <= sizeInt; i++) {
            for (int j = -sizeInt; j <= sizeInt; j++) {
                for (int k = -sizeInt; k <= sizeInt; k++) {
                    int distSq = i * i + j * j + k * k;
                    Block block = world.getBlock(x + i, y + j, z + k);
                    if(block.getBlockHardness(world, x + i, y + j, z + k) == -1) continue;

                    if(holeSize > -1) {
                    	double deltaX = Math.abs(i - holeX);
                    	double deltaY = Math.abs(j - holeY);
                    	double deltaZ = Math.abs(k - holeZ);
                    	
                    	if(deltaX + deltaY + deltaZ < holeSize && distSq <= DISTANCE_NULLSTONE_SQ) {
                            world.setBlockToAir(x + i, y + j, z + k);
                            continue;
                    	}
                    }
                    
                    if (distSq <= DISTANCE_INNER_SQ) {
                        world.setBlockToAir(x + i, y + j, z + k);
                    } else if (distSq <= DISTANCE_NULLSTONE_SQ && distSq > DISTANCE_NULLSTONEBRICKS_SQ) {
                        world.setBlock(x + i, y + j, z + k, NovaCraftBlocks.nullstone, 0, 2);
                	} else if (distSq <= DISTANCE_NULLSTONEBRICKS_SQ && distSq > DISTANCE_AMETHYST_SQ) {
                        world.setBlock(x + i, y + j, z + k, NovaCraftBlocks.nullstone_bricks, 0, 2);
                	} else if (distSq <= DISTANCE_AMETHYST_SQ) {
                        placeAmethyst(world, random, x + i, y + j, z + k);
                    }
                }
            }
        }        
        
        {
        	world.setBlock(x, y + 3, z, NovaCraftBlocks.treasure_chest);
        	world.setBlock(x, y - 5, z, NovaCraftBlocks.treasure_chest);
        	
        	world.setBlock(x, y + 2, z, Blocks.obsidian);
        	world.setBlock(x, y, z, Blocks.obsidian);
        	world.setBlock(x, y + 1, z + 1, Blocks.obsidian);
        	world.setBlock(x, y + 1, z - 1, Blocks.obsidian);
        	world.setBlock(x + 1, y + 1, z, Blocks.obsidian);
        	world.setBlock(x - 1, y + 1, z, Blocks.obsidian);
        	
        	world.setBlock(x, y - 2, z, NovaCraftBlocks.sculk_block);
        	world.setBlock(x, y - 4, z, NovaCraftBlocks.sculk_block);
        	world.setBlock(x, y - 3, z + 1, NovaCraftBlocks.sculk_block);
        	world.setBlock(x, y - 3, z - 1, NovaCraftBlocks.sculk_block);
        	world.setBlock(x + 1, y - 3, z, NovaCraftBlocks.sculk_block);
        	world.setBlock(x - 1, y - 3, z, NovaCraftBlocks.sculk_block);
        	
            world.setBlock(x, y + 1, z, Blocks.mob_spawner);
            world.setBlock(x, y - 3, z, Blocks.mob_spawner);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x, y + 1, z);
            
            if (tileentitymobspawner != null)
            {
            	tileentitymobspawner.func_145881_a().setEntityName("nova_craft.sculk_dweller");
            }
            
            TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)world.getTileEntity(x, y - 3, z);
            if (tileentitymobspawner2 != null)
            {
            	tileentitymobspawner2.func_145881_a().setEntityName("nova_craft.sculk_abomination");
            }
            
            else
            {
                System.err.println("Failed to fetch mob spawner entity at (" + x + ", " + y + ", " + z + ")");
            	}
            }
            return true;
         
        
	}
	
	private boolean canGeodeGenerateHere(World world, int x, int y, int z, int size) {
		int air = 0;
		if(isAirOrFluid(world, x + size, y + size, z + size)) {
			air++;
		}
		if(isAirOrFluid(world, x + size, y + size, z - size)) { 
			air++;
		}
		if(isAirOrFluid(world, x - size, y + size, z + size)) {
			air++;
		}
		if(isAirOrFluid(world, x - size, y + size, z - size)) {
			air++;
		}
		if(isAirOrFluid(world, x + size, y - size, z + size)) {
			air++;
		}
		if(isAirOrFluid(world, x + size, y - size, z - size)) {
			air++;
		}
		if(isAirOrFluid(world, x - size, y - size, z + size)) {
			air++;
		}
		if(isAirOrFluid(world, x - size, y - size, z - size)) {
			air++;
		}
		return air < 4;
	}
	
	private boolean isAirOrFluid(World world, int x, int y, int z) {
		return world.isAirBlock(x, y, z) || world.getBlock(x, y, z).getMaterial().isLiquid();
	}
	
	private void placeAmethyst(World world, Random random, int x, int y, int z) {
		if(random.nextInt(12) == 0) {
			world.setBlock(x, y, z, NovaCraftBlocks.sculk_block);
			for(EnumFacing facing : EnumFacing.values()) {
				int clusterSize = random.nextInt(5);
				if(clusterSize > 0) {
					int offX = x + facing.getFrontOffsetX();
					int offY = y + facing.getFrontOffsetY();
					int offZ = z + facing.getFrontOffsetZ();
					if(world.getBlock(offX, offY, offZ).getMaterial() == Material.air || world.getBlock(offX, offY, offZ).getMaterial() == Material.water) {
						Block block = clusterSize > 2 ? NovaCraftBlocks.sculk_spike : NovaCraftBlocks.sculk_spike;
						int meta = (clusterSize == 1 || clusterSize == 3 ? 0 : 6) + facing.ordinal();
						world.setBlock(offX, offY, offZ, block, meta, 2);
					}
				}
			}
		} else {
			world.setBlock(x, y, z, NovaCraftBlocks.sculk_block);
		}
	}
	
	 private String pickMobSpawner(Random p_76543_1_)
	    {
	        return DungeonHooks.getRandomDungeonMob(p_76543_1_);
	    }
	
	private ItemStack getNormalLoot(Random random) {
		int item = random.nextInt(30);
		switch (item) {
			case 0:
				return new ItemStack(Items.iron_ingot);
			case 1:
				return new ItemStack(Items.experience_bottle, random.nextInt(4) + 1);
			case 2:
				return new ItemStack(Items.gold_ingot, random.nextInt(6) + 1);
			case 3:
				return new ItemStack(NovaCraftItems.pherithium_scraps, random.nextInt(6) + 1);
			case 4:
				return new ItemStack(NovaCraftItems.vanite_chunk, random.nextInt(7) + 1);
			case 5:
				return new ItemStack(NovaCraftBlocks.sculk_vein, random.nextInt(8) + 1);
			case 6: {
				if (random.nextInt(20) == 0) {
					return new ItemStack(Items.diamond, random.nextInt(3) + 2);
				}

				break;
			}
			case 7:
				return new ItemStack(NovaCraftItems.brimstone_dust, random.nextInt(3) + 1);
			case 8: {
				if (random.nextInt(10) == 0) {
					return new ItemStack(NovaCraftBlocks.sculk_bricks, random.nextInt(20) + 1);
				}

				break;
			}
			case 9: {
				if (random.nextInt(10) == 0) {
					return new ItemStack(NovaCraftItems.copartz_shard);
				}
				break;
			}
			case 10: {
				if (random.nextInt(5) == 0) {
					return new ItemStack(NovaCraftItems.pherithium_pickaxe);
				}
				break;
			}
		}
		return new ItemStack(NovaCraftBlocks.sculk_block, random.nextInt(2) + 2);
	}
}

