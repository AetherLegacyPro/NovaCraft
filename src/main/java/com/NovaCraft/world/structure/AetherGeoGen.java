package com.NovaCraft.world.structure;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityCrystalGolem;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
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

public class AetherGeoGen extends WorldGenerator {
	//Credit Goes to Roadhog360
    
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		final float size = (random.nextInt(2) + 4) + random.nextFloat(); //6
	    final float DISTANCE_COBBLESTONE_SQ = (size * size);
	    final float DISTANCE_GRIMSTONE_SQ = ((size - 1) * (size - 1));
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
			attempts++;
		}
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
                    	
                    	if(deltaX + deltaY + deltaZ < holeSize && distSq <= DISTANCE_COBBLESTONE_SQ) {
                            world.setBlockToAir(x + i, y + j, z + k);
                            continue;
                    	}
                    }
                    
                    if (distSq <= DISTANCE_INNER_SQ) {
                        world.setBlockToAir(x + i, y + j, z + k);
                    } else if (distSq <= DISTANCE_COBBLESTONE_SQ && distSq > DISTANCE_GRIMSTONE_SQ) {
                        world.setBlock(x + i, y + j, z + k, Blocks.cobblestone, 0, 2);
                	} else if (distSq <= DISTANCE_GRIMSTONE_SQ && distSq > DISTANCE_AMETHYST_SQ) {
                        world.setBlock(x + i, y + j, z + k, NovaCraftBlocks.cobbled_etherstone, 0, 2);
                	} else if (distSq <= DISTANCE_AMETHYST_SQ) {
                        placeAmethyst(world, random, x + i, y + j, z + k);
                    }
                }
            }
        }
        if (!world.isRemote) {
            final EntityCrystalGolem golem = new EntityCrystalGolem(world);
            golem.setLocationAndAngles((double)(x), (double)(y + 1), (double)(z), 0.0f, 0.0f);
            world.spawnEntityInWorld((Entity)golem);
            golem.setType(5);
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
			world.setBlock(x, y, z, NovaCraftBlocks.budding_aether_block);
			for(EnumFacing facing : EnumFacing.values()) {
				int clusterSize = random.nextInt(5);
				if(clusterSize > 0) {
					int offX = x + facing.getFrontOffsetX();
					int offY = y + facing.getFrontOffsetY();
					int offZ = z + facing.getFrontOffsetZ();
					if(world.getBlock(offX, offY, offZ).getMaterial() == Material.air || world.getBlock(offX, offY, offZ).getMaterial() == Material.water) {
						Block block = clusterSize > 2 ? NovaCraftBlocks.aether_cluster_1 : NovaCraftBlocks.aether_cluster_2;
						int meta = (clusterSize == 1 || clusterSize == 3 ? 0 : 6) + facing.ordinal();
						world.setBlock(offX, offY, offZ, block, meta, 2);
					}
				}
			}
		} else {
			world.setBlock(x, y, z, NovaCraftBlocks.aether_block);
		}
	}
	
}
