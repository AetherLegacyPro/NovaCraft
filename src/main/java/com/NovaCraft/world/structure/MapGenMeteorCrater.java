package com.NovaCraft.world.structure;

import java.util.Random;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

public class MapGenMeteorCrater extends MapGenBase {

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

        if (rand.nextInt(1440) != 0) return;

        int x = chunkX * 16 + rand.nextInt(16);
        int z = chunkZ * 16 + rand.nextInt(16);
        int y = world.getTopSolidOrLiquidBlock(x, z);

        if (!world.canBlockSeeTheSky(x, y + 1, z)) return;

        generateCrater(world, rand, x, y, z);
    }

    private void generateCrater(World world, Random rand, int x, int y, int z) {
        float radius = 8.0F + rand.nextFloat() * 4.0F;
        int radiusInt = MathHelper.floor_float(radius + 6);
        int craterBottomY = y - 12;
        int craterTopY = y + 1;

        boolean hasWater = false;
        int highestWaterY = -1;
        int waterCheckRadius = 24;
        int verticalCheckRange = 32;
       
        for (int dx = -waterCheckRadius; dx <= waterCheckRadius; dx++) {
            for (int dz = -waterCheckRadius; dz <= waterCheckRadius; dz++) {
                if (dx * dx + dz * dz > waterCheckRadius * waterCheckRadius) continue;
                for (int dy = -verticalCheckRange; dy <= verticalCheckRange; dy++) {
                    int checkX = x + dx, checkY = y + dy, checkZ = z + dz;
                    if (checkY < 1 || checkY > 255) continue;
                    Block block = world.getBlock(checkX, checkY, checkZ);
                    if (block == Blocks.water || block == Blocks.flowing_water) {
                        hasWater = true;
                        if (checkY > highestWaterY) highestWaterY = checkY;
                    }
                }
            }
        }

        for (int dx = -radiusInt; dx <= radiusInt; dx++) {
            for (int dz = -radiusInt; dz <= radiusInt; dz++) {
                for (int dy = -12; dy <= 1; dy++) {
                    int realX = x + dx, realY = y + dy, realZ = z + dz;
                    double distSq = dx * dx + dz * dz + dy * dy * 4.5;

                    if (distSq < radius * radius) {
                        Block block = world.getBlock(realX, realY, realZ);
                        if (block != Blocks.bedrock && block.getMaterial().isSolid()) {
                            world.setBlockToAir(realX, realY, realZ);
                        }

                        if (dy == -12 && world.isAirBlock(realX, realY + 1, realZ)) {
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

        double radiusSq = radius * radius;
        int domeHeight = 8;

        for (int dx = -radiusInt; dx <= radiusInt; dx++) {
            for (int dz = -radiusInt; dz <= radiusInt; dz++) {
                double horizDistSq = dx * dx + dz * dz;
                if (horizDistSq >= radiusSq) continue;

                int maxHeight = (int) (Math.sqrt((radiusSq - horizDistSq) / 0.8));
                maxHeight = Math.min(maxHeight, domeHeight);

                for (int dy = 1; dy <= maxHeight; dy++) {
                    int realX = x + dx, realY = y + dy, realZ = z + dz;
                    if (!world.isAirBlock(realX, realY, realZ)) {
                        world.setBlockToAir(realX, realY, realZ);
                    }
                }
            }
        }

        for (int dx = -radiusInt; dx <= radiusInt; dx++) {
            for (int dz = -radiusInt; dz <= radiusInt; dz++) {
                for (int dy = -6; dy <= 1; dy++) {
                    int realX = x + dx;
                    int realY = y + dy;
                    int realZ = z + dz;

                    double distSq = dx * dx + dz * dz + dy * dy * 2.5;
                    if (distSq < radius * radius * 0.95 && rand.nextFloat() < 0.06F) {
                        Block existing = world.getBlock(realX, realY, realZ);
                        if (existing != Blocks.air && existing != Blocks.water && existing != Blocks.flowing_water && existing.getMaterial().isSolid()) {
                            Block ore;
                            int oreType = rand.nextInt(22);
                            switch (oreType) {
                                case 0: 
                                	ore = NovaCraftBlocks.iridium_ore; 
                                	break;
                                case 1:
                                	ore = Blocks.gold_ore;
                                	break;
                                case 2: 
                                	ore = Blocks.stone;
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
                                	ore = Blocks.stone; 
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

        if (hasWater) {
            for (int dx = -radiusInt; dx <= radiusInt; dx++) {
                for (int dz = -radiusInt; dz <= radiusInt; dz++) {
                    int realX = x + dx;
                    int realZ = z + dz;

                    double horizDistSq = dx * dx + dz * dz;
                    if (horizDistSq > radius * radius) continue;

                    for (int dy = -6; dy <= -3; dy++) {
                        int realY = y + dy;
                        Block above = world.getBlock(realX, realY + 1, realZ);
                        Block ground = world.getBlock(realX, realY, realZ);

                        if ((above == Blocks.water || above == Blocks.flowing_water) && ground.getMaterial().isSolid()) {
                            Block mat = rand.nextFloat() < 0.8f ? Blocks.gravel : Blocks.clay;
                            world.setBlock(realX, realY + 1, realZ, mat);
                            break;
                        }
                    }
                }
            }
        }
    }
}
