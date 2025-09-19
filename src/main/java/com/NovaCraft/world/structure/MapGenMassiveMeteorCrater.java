package com.NovaCraft.world.structure;

import java.util.Random;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

public class MapGenMassiveMeteorCrater extends MapGenBase {

    public void generateAt(World world, int chunkX, int chunkZ) {
        this.rand.setSeed(world.getSeed());
        long xSeed = this.rand.nextLong() >> 2 + 1L;
        long zSeed = this.rand.nextLong() >> 2 + 1L;
        long chunkSeed = ((long) chunkX * xSeed + (long) chunkZ * zSeed) ^ world.getSeed();
        this.rand.setSeed(chunkSeed);

        recursiveGenerate(world, chunkX, chunkZ, chunkX * 16, chunkZ * 16, null);
    }

    public void recursiveGenerate(World world, int chunkX, int chunkZ, int originX, int originZ, Block[] blockArray) {
        Random rand = this.rand;

        if (rand.nextInt(2880) != 0) return;

        int x = chunkX * 16 + rand.nextInt(16);
        int z = chunkZ * 16 + rand.nextInt(16);
        int y = world.getTopSolidOrLiquidBlock(x, z);

        if (!world.canBlockSeeTheSky(x, y + 1, z)) return;

        generateCrater(world, rand, x, y, z);
    }

    private void generateCrater(World world, Random rand, int x, int y, int z) {
        float radius = 36.0F + rand.nextFloat() * 4.0F;
        int radiusInt = MathHelper.floor_float(radius + 8);
        int craterBottomY = y - 24;
        int craterTopY = y + 1;

        boolean hasWater = false;
        int highestWaterY = -1;
        int waterCheckRadius = 24;
        int verticalCheckRange = 32;

        //Looks for water blocks nearby
        for (int dx = -waterCheckRadius; dx <= waterCheckRadius; dx++) {
            for (int dz = -waterCheckRadius; dz <= waterCheckRadius; dz++) {
                int checkX = x + dx;
                int checkZ = z + dz;

                if (dx * dx + dz * dz > waterCheckRadius * waterCheckRadius) continue;

                for (int dy = -verticalCheckRange; dy <= verticalCheckRange; dy++) {
                    int checkY = y + dy;

                    if (checkY < 1 || checkY > 255) continue;

                    Block block = world.getBlock(checkX, checkY, checkZ);
                    if (block == Blocks.water || block == Blocks.flowing_water) {
                        hasWater = true;
                        if (checkY > highestWaterY) {
                            highestWaterY = checkY;
                        }
                    }
                }
            }
        }

        //Creates the Crater
        for (int dx = -radiusInt; dx <= radiusInt; dx++) {
            for (int dz = -radiusInt; dz <= radiusInt; dz++) {
                for (int dy = -24; dy <= 1; dy++) {
                    int realX = x + dx;
                    int realY = y + dy;
                    int realZ = z + dz;

                    double distSq = dx * dx + dz * dz + dy * dy * 4.5;

                    if (distSq < radius * radius) {
                        Block block = world.getBlock(realX, realY, realZ);
                        if (block != Blocks.bedrock && block.getMaterial().isSolid()) {
                            world.setBlockToAir(realX, realY, realZ);
                        }

                        if (dy == -24 && world.isAirBlock(realX, realY + 1, realZ)) {
                            Block floor = rand.nextInt(4) == 0 ? Blocks.mossy_cobblestone : Blocks.grass;
                            world.setBlock(realX, realY, realZ, floor);
                        }

                        if (hasWater && realY <= highestWaterY && realY > craterBottomY) {
                            world.setBlock(realX, realY, realZ, Blocks.water, 0, 2);
                        }
                    }
                }
            }
        }

        //Creates air blocks above the crater
        double radiusSq = radius * radius;
        int domeHeight = 16;

        for (int dx = -radiusInt; dx <= radiusInt; dx++) {
            for (int dz = -radiusInt; dz <= radiusInt; dz++) {
                double horizDistSq = dx * dx + dz * dz;
                if (horizDistSq >= radiusSq) continue;

                int maxHeight = (int) (Math.sqrt((radiusSq - horizDistSq) / 0.8));
                maxHeight = Math.min(maxHeight, domeHeight);

                for (int dy = 1; dy <= maxHeight; dy++) {
                    int realX = x + dx;
                    int realY = y + dy;
                    int realZ = z + dz;

                    if (!world.isAirBlock(realX, realY, realZ)) {
                        world.setBlockToAir(realX, realY, realZ);
                    }
                }
            }
        }

        //Adds random ores within the crater walls and around them
        for (int dx = -radiusInt; dx <= radiusInt; dx++) {
            for (int dz = -radiusInt; dz <= radiusInt; dz++) {
                for (int dy = -24; dy <= 1; dy++) {
                    int realX = x + dx;
                    int realY = y + dy - rand.nextInt(3);
                    int realZ = z + dz;

                    double distSq = dx * dx + dz * dz + dy * dy * 4.5;
                    double diff = Math.abs(distSq - radius * radius);

                    if (diff <= 6.0 && rand.nextFloat() < 0.45F) {
                        Block target = world.getBlock(realX, realY, realZ);
                        if (target.getMaterial().isSolid() && target != Blocks.water && target != Blocks.flowing_water && target != Blocks.air && target != Blocks.leaves && target != Blocks.leaves2 && target != Blocks.dirt && target != Blocks.grass) {
                            Block ore;
                            int oreType = rand.nextInt(28);
                            switch (oreType) {
                                case 0: 
                                	ore = NovaCraftBlocks.iridium_ore; 
                                	break;
                                case 1:
                                	ore = Blocks.gold_ore;
                                	break;
                                case 2: 
                                	ore = Blocks.gold_ore;
                                	break;
                                case 3:
                                	ore = Blocks.stone; 
                                	break;
                                case 4: 
                                	ore = Blocks.stone; 
                                	break;
                                case 5: 
                                	ore = Blocks.stone; 
                                	break;
                                case 6: 
                                	ore = Blocks.stone; 
                                	break;
                                case 7: 
                                	ore = Blocks.cobblestone;
                                	break;
                                case 8: 
                                	ore = Blocks.iron_ore; 
                                	break;
                                case 9: 
                                	ore = Blocks.iron_ore; 
                                	break;
                                case 10: 
                                	ore = Blocks.iron_ore; 
                                	break;
                                case 11: 
                                	ore = Blocks.obsidian; 
                                	break;
                                case 12: 
                                	ore = Blocks.obsidian; 
                                	break;
                                default: 
                                	ore = NovaCraftBlocks.meteorite_block; 
                                	break;
                            }

                            world.setBlock(realX, realY, realZ, ore);
                        }
                    }
                }
            }
        }

        //Add grass, sand, or snow at the bottom of the crater if not filled with water
        if (!hasWater) {
        	for (int dx = -radiusInt; dx <= radiusInt; dx++) {
                for (int dz = -radiusInt; dz <= radiusInt; dz++) {
                    int realX = x + dx;
                    int realZ = z + dz;

                    double horizDistSq = dx * dx + dz * dz;
                    if (horizDistSq > radius * radius) continue;

                    int topY = world.getTopSolidOrLiquidBlock(realX, realZ) - 1;

                    if (topY <= 0 || topY > 255) continue;

                    Block block = world.getBlock(realX, topY, realZ);
                    Block above = world.getBlock(realX, topY + 1, realZ);

                    if (block != Blocks.air && block != Blocks.water && block != Blocks.flowing_water && world.canBlockSeeTheSky(realX, topY + 1, realZ)) {
                        String biomeName = world.getBiomeGenForCoords(realX, realZ).biomeName.toLowerCase();
                        Block surfaceBlock;

                        if (biomeName.contains("desert")) {
                            float chance = rand.nextFloat();
                            if (chance < 0.6f) {
                                surfaceBlock = Blocks.sand;
                            } else if (chance < 0.85f) {
                                surfaceBlock = Blocks.dirt;
                            } else {
                                surfaceBlock = Blocks.stone;
                            }
                        } else {
                            float chance = rand.nextFloat();
                           if (rand.nextInt(3) == 0) {
                            if (chance < 0.5f) {
                                surfaceBlock = Blocks.grass;
                            } else if (chance < 0.8f) {
                                surfaceBlock = Blocks.dirt;
                            } else {
                                surfaceBlock = Blocks.stone;
                             }
                           } else {
                        	   surfaceBlock = Blocks.grass; 
                           }
                        }

                        world.setBlock(realX, topY + 1, realZ, surfaceBlock);
                    }
                }
            }
        
        for (int dx = -radiusInt; dx <= radiusInt; dx++) {
            for (int dz = -radiusInt; dz <= radiusInt; dz++) {
                int realX = x + dx;
                int realZ = z + dz;

                double horizDistSq = dx * dx + dz * dz;
                if (horizDistSq > radius * radius) continue;

                int topY = world.getTopSolidOrLiquidBlock(realX, realZ);

                if (topY <= 0 || topY > 255) continue;

                Block ground = world.getBlock(realX, topY - 1, realZ);
                Block above = world.getBlock(realX, topY, realZ);

                if (above != Blocks.air) continue;

                String biomeName = world.getBiomeGenForCoords(realX, realZ).biomeName.toLowerCase();

                if (biomeName.contains("desert")) {
                    if (ground == Blocks.sand && rand.nextFloat() < 0.04F && world.isAirBlock(realX, topY + 1, realZ)) {
                        world.setBlock(realX, topY, realZ, Blocks.cactus);
                    }
                } 
                else if (biomeName.contains("ice") || biomeName.contains("snow")) {
                	if (rand.nextFloat() < 0.04F && world.isAirBlock(realX, topY + 1, realZ)) {
                        world.setBlock(realX, topY, realZ, Blocks.snow_layer, 0, 0);
                    }
                } else {
                    if (ground == Blocks.grass) {
                    	float roll = rand.nextFloat();

                        if (roll < 0.06f) {
                            world.setBlock(realX, topY, realZ, Blocks.tallgrass, 1, 2);
                        } else if (roll < 0.10f) {
                            Block flower = rand.nextBoolean() ? Blocks.red_flower : Blocks.yellow_flower;
                            world.setBlock(realX, topY, realZ, flower);
                        } else if (roll < 0.115f) {
                            world.setBlock(realX, topY, realZ, Blocks.sapling, 0, 2);
                        }
                    }
                }
            }
        }
      } else {
    	    for (int dx = -radiusInt; dx <= radiusInt; dx++) {
    	        for (int dz = -radiusInt; dz <= radiusInt; dz++) {
    	            int realX = x + dx;
    	            int realZ = z + dz;

    	            double horizDistSq = dx * dx + dz * dz;
    	            if (horizDistSq > radius * radius) continue;

    	            boolean placedBottomBlock = false;

    	            for (int dy = -24; dy <= 1; dy++) {
    	                int realY = y + dy;

    	                Block current = world.getBlock(realX, realY, realZ);
    	                Block above = world.getBlock(realX, realY + 1, realZ);

    	                if ((current.getMaterial().isSolid() && current != Blocks.bedrock) && (above == Blocks.water || above == Blocks.flowing_water)) {

    	                    Block bottomBlock = rand.nextFloat() < 0.8f ? Blocks.gravel : Blocks.clay;
    	                    world.setBlock(realX, realY + 1, realZ, bottomBlock);
    	                    placedBottomBlock = true;
    	                    break;
    	                }
    	            }

    	            // Fallback if no placement done
    	            if (!placedBottomBlock) {
    	                int topY = world.getTopSolidOrLiquidBlock(realX, realZ) - 1;
    	                if (topY > 1 && topY < 255) {
    	                    Block b = world.getBlock(realX, topY, realZ);
    	                    if (b == Blocks.water || b == Blocks.flowing_water) {
    	                        Block fallbackBlock = rand.nextFloat() < 0.8f ? Blocks.gravel : Blocks.clay;
    	                        world.setBlock(realX, topY - 1, realZ, fallbackBlock);
    	                    }
    	                }
    	            }
    	        }
    	    }
       }
    }
}