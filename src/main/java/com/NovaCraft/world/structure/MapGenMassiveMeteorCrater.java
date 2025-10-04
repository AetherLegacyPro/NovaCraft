package com.NovaCraft.world.structure;

import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.MapGenBase;

public class MapGenMassiveMeteorCrater extends MapGenBase {
    public void generateAt(World world, int chunkX, int chunkZ) {
        this.rand.setSeed(world.getSeed());
        long xSeed = this.rand.nextLong() >> 3;
        long zSeed = this.rand.nextLong() >> 3;
        long chunkSeed = (long)chunkX * xSeed + (long)chunkZ * zSeed ^ world.getSeed();
        this.rand.setSeed(chunkSeed);
        this.recursiveGenerate(world, chunkX, chunkZ, chunkX * 16, chunkZ * 16, (Block[])null);
    }

    public void recursiveGenerate(World world, int chunkX, int chunkZ, int originX, int originZ, Block[] blockArray) {
        Random rand = this.rand;
        if (rand.nextInt(5760) == 0) {
            int x = chunkX * 16 + rand.nextInt(16);
            int z = chunkZ * 16 + rand.nextInt(16);
            int y = world.getTopSolidOrLiquidBlock(x, z);
            if (world.canBlockSeeTheSky(x, y + 1, z)) {
                this.generateCrater(world, rand, x, y, z);
            }
        }
    }

    private void generateCrater(World world, Random rand, int x, int y, int z) {
        if (y <= 85) {
            float radius = 36.0F + rand.nextFloat() * 4.0F;
            int radiusInt = MathHelper.floor_float(radius + 8.0F);
            int craterBottomY = y - 24;
            int waterCount = 0;
            int highestWaterY = -1;
            int waterCheckRadius = 24;
            int verticalCheckRange = 32;

            int checkX;
            int checkY;
            for(int dx = -waterCheckRadius; dx <= waterCheckRadius; ++dx) {
                for(int dz = -waterCheckRadius; dz <= waterCheckRadius; ++dz) {
                    if (dx * dx + dz * dz <= waterCheckRadius * waterCheckRadius) {
                        checkX = x + dx;
                        int checkZ = z + dz;

                        for(int dy = -verticalCheckRange; dy <= verticalCheckRange; ++dy) {
                            checkY = y + dy;
                            if (checkY >= 1 && checkY <= 255) {
                                Block block = world.getBlock(checkX, checkY, checkZ);
                                if (block == Blocks.water || block == Blocks.flowing_water) {
                                    ++waterCount;
                                    if (checkY > highestWaterY) {
                                        highestWaterY = checkY;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
            float temp = biome.getFloatTemperature(x, y, z);
            checkX = biome.getIntRainfall();
            int requiredWater = 50;
            if (temp > 1.0F || checkX < 500) {
                requiredWater = 200;
            }

            boolean hasWater = waterCount > requiredWater;

            int realY;
            int realZ;
            int dz;
            for(checkY = -radiusInt; checkY <= radiusInt; ++checkY) {
                for(dz = -radiusInt; dz <= radiusInt; ++dz) {
                    for(int dy = -24; dy <= 1; ++dy) {
                        int realX = x + checkY;
                        realY = y + dy;
                        realZ = z + dz;
                        double distSq = (double)(checkY * checkY + dz * dz) + (double)(dy * dy) * 4.5D;
                        if (distSq < (double)(radius * radius)) {
                            Block block = world.getBlock(realX, realY, realZ);
                            if (block != Blocks.bedrock && block.getMaterial().isSolid()) {
                                world.setBlockToAir(realX, realY, realZ);
                            }

                            if (dy == -24 && world.isAirBlock(realX, realY + 1, realZ)) {
                                Block floor = rand.nextInt(4) == 0 ? Blocks.dirt : Blocks.grass;
                                world.setBlock(realX, realY, realZ, (Block)floor);
                            }

                            if (hasWater && realY <= highestWaterY && realY > craterBottomY) {
                                world.setBlock(realX, realY, realZ, Blocks.water, 0, 2);
                            }
                        }
                    }
                }
            }

            for(checkY = -radiusInt; checkY <= radiusInt; ++checkY) {
                for(dz = -radiusInt; dz <= radiusInt; ++dz) {
                    double horizDistSq = (double)(checkY * checkY + dz * dz);
                    if (horizDistSq <= (double)(radius * radius)) {
                        realY = x + checkY;
                        realZ = z + dz;

                        for(int realY2 = y + 1; realY2 < world.getActualHeight(); ++realY2) {
                            if (!world.isAirBlock(realY, realY2, realZ)) {
                                world.setBlockToAir(realY, realY2, realZ);
                            }
                        }
                    }
                }
            }

            if (!hasWater) {
                this.fillCraterBottom(world, rand, x, y, z, radiusInt, radius);
                this.clearLiquidsInCrater(world, x, y, z, radiusInt, radius);
                this.AddFlora(world, rand, x, y, z, radiusInt, radius);
            } else {
                this.fillCraterBottomHasWater(world, rand, x, y, z, radiusInt, radius);
            }

            this.decorateCrater(world, rand, x, y, z, radiusInt, radius);
        }
    }

    private void fillCraterBottom(World world, Random rand, int x, int y, int z, int radiusInt, float radius) {
        for(int dx = -radiusInt; dx <= radiusInt; ++dx) {
            for(int dz = -radiusInt; dz <= radiusInt; ++dz) {
                double horizDistSq = (double)(dx * dx + dz * dz);
                if (horizDistSq <= (double)(radius * radius)) {
                    int realX = x + dx;
                    int realZ = z + dz;
                    int floorY = -1;

                    for(int relY = 1; relY >= -24; --relY) {
                        int realY = y + relY;
                        if (realY < 0) {
                            break;
                        }

                        if (!world.isAirBlock(realX, realY, realZ)) {
                            floorY = realY;
                            break;
                        }
                    }

                    if (floorY > 0) {
                        String biomeName = world.getBiomeGenForCoords(realX, realZ).biomeName.toLowerCase();
                        Block bottomBlock = Blocks.dirt;
                        //Object bottomBlock;
                        if (biomeName.contains("desert")) {
                            float chance = rand.nextFloat();
                            bottomBlock = chance < 0.85F ? Blocks.sand : Blocks.sandstone;
                        } else {
                            int chanceAllGrass = (int)(1.0D + Math.random() * 4.0D);
                            if (chanceAllGrass <= 3) {
                                float chance = rand.nextFloat();
                                if (chance < 0.5F) {
                                    bottomBlock = Blocks.grass;
                                } else if (chance < 0.8F) {
                                    if (Loader.isModLoaded("etfuturum")) {
                                        try {
                                            Block coarse_dirt = GameRegistry.findBlock("etfuturum", "coarse_dirt");
                                            if (coarse_dirt != null) {
                                                bottomBlock = coarse_dirt;
                                            } else {
                                                bottomBlock = Blocks.dirt;
                                            }
                                        } catch (Exception var20) {
                                            bottomBlock = Blocks.dirt;
                                        }
                                    } else {
                                        bottomBlock = Blocks.dirt;
                                    }
                                } else {
                                    bottomBlock = Blocks.cobblestone;
                                }
                            } else {
                                bottomBlock = Blocks.grass;
                            }
                        }

                        Block target = world.getBlock(realX, floorY, realZ);
                        if (world.isAirBlock(realX, floorY + 1, realZ) && target.getMaterial().isSolid() && target != Blocks.log && target != Blocks.log2 && target != Blocks.leaves && target != Blocks.leaves2) {
                            world.setBlock(realX, floorY + 1, realZ, (Block)bottomBlock, 0, 2);
                        }
                    }
                }
            }
        }

    }

    private void AddFlora(World world, Random rand, int x, int y, int z, int radiusInt, float radius) {
        for(int dx = -radiusInt; dx <= radiusInt; ++dx) {
            for(int dz = -radiusInt; dz <= radiusInt; ++dz) {
                double horizDistSq = (double)(dx * dx + dz * dz);
                if (horizDistSq <= (double)(radius * radius)) {
                    int realX = x + dx;
                    int realZ = z + dz;
                    int floorY = -1;

                    for(int relY = 1; relY >= -24; --relY) {
                        int realY = y + relY + 1;
                        if (realY < 0) {
                            break;
                        }

                        if (!world.isAirBlock(realX, realY, realZ)) {
                            floorY = realY;
                            break;
                        }
                    }

                    if (floorY > 0) {
                        String biome = world.getBiomeGenForCoords(realX, realZ).biomeName.toLowerCase();
                        float chance;
                        Object bottomBlock;
                        if (biome.contains("desert")) {
                            chance = rand.nextFloat();
                            if ((double)chance < 0.01D) {
                                bottomBlock = Blocks.cactus;
                            } else if (chance < 0.02F) {
                                bottomBlock = NovaCraftBlocks.blooming_barb;
                            } else if (chance < 0.03F) {
                                bottomBlock = Blocks.deadbush;
                            } else {
                                bottomBlock = Blocks.air;
                            }
                        } else if (!biome.contains("ice") && !biome.contains("snow")) {
                            chance = rand.nextFloat();
                            if (chance < 0.35F) {
                                Block target = world.getBlock(realX, floorY, realZ);
                                if (world.isAirBlock(realX, floorY + 1, realZ) && target.getMaterial().isSolid() && target != Blocks.log && target != Blocks.log2 && target != Blocks.leaves && target != Blocks.leaves2) {
                                    world.setBlock(realX, floorY + 1, realZ, Blocks.tallgrass, 1, 2);
                                }
                                continue;
                            }

                            if (chance < 0.38F) {
                                bottomBlock = Blocks.yellow_flower;
                            } else if (chance < 0.39F) {
                                bottomBlock = Blocks.red_flower;
                            } else if (chance < 0.4F) {
                                bottomBlock = NovaCraftBlocks.violet;
                            } else if (chance < 0.41F) {
                                bottomBlock = NovaCraftBlocks.cyan_rose;
                            } else {
                                bottomBlock = Blocks.air;
                            }
                        } else {
                            bottomBlock = Blocks.snow_layer;
                        }

                        Block target = world.getBlock(realX, floorY, realZ);
                        if (bottomBlock != Blocks.air && world.isAirBlock(realX, floorY + 1, realZ) && target.getMaterial().isSolid() && target != Blocks.log && target != Blocks.log2 && target != Blocks.leaves && target != Blocks.leaves2) {
                            world.setBlock(realX, floorY + 1, realZ, (Block)bottomBlock, 0, 2);
                        }
                    }
                }
            }
        }

    }

    private void fillCraterBottomHasWater(World world, Random rand, int x, int y, int z, int radiusInt, float radius) {
        for(int dx = -radiusInt; dx <= radiusInt; ++dx) {
            for(int dz = -radiusInt; dz <= radiusInt; ++dz) {
                double horizDistSq = (double)(dx * dx + dz * dz);
                if (horizDistSq <= (double)(radius * radius)) {
                    int realX = x + dx;
                    int realZ = z + dz;
                    int floorY = -1;

                    for(int relY = 1; relY >= -24; --relY) {
                        int realY = y + relY;
                        if (realY < 0) {
                            break;
                        }

                        if (!world.isAirBlock(realX, realY, realZ)) {
                            floorY = realY;
                            break;
                        }
                    }

                    if (floorY > 0) {
                        float chance = rand.nextFloat();
                        Block bottomBlock = chance < 0.85F ? Blocks.gravel : Blocks.clay;
                        Block target = world.getBlock(realX, floorY, realZ);
                        if (world.isAirBlock(realX, floorY + 1, realZ) && target.getMaterial().isSolid() && target != Blocks.log && target != Blocks.log2 && target != Blocks.leaves && target != Blocks.leaves2) {
                            world.setBlock(realX, floorY + 1, realZ, bottomBlock);
                        }
                    }
                }
            }
        }

    }

    private void decorateCrater(World world, Random rand, int x, int y, int z, int radiusInt, float radius) {
        int extraRadius;
        int dx;

        for(extraRadius = -radiusInt; extraRadius <= radiusInt; ++extraRadius) {
            for(int dz = -radiusInt; dz <= radiusInt; ++dz) {
                for(dx = -24; dx <= 0; ++dx) {
                    dz = x + extraRadius;
                    int realY = y + dx;
                    int realZ = z + dz;
                    double distSq = (double)(extraRadius * extraRadius + dz * dz) + (double)(dx * dx) * 4.5D;
                    if (Math.abs(distSq - (double)(radius * radius)) < 6.0D && rand.nextFloat() < 0.12F) {
                        this.tryPlaceOre(world, rand, dz, realY, realZ);
                    }
                }
            }
        }

        extraRadius = radiusInt + 12;
        int depth = 20;
        int dz;
        for(dx = -extraRadius; dx <= extraRadius; ++dx) {
            for(dz = -extraRadius; dz <= extraRadius; ++dz) {
                double horizDistSq = (double)(dx * dx + dz * dz);
                if (horizDistSq <= (double)(extraRadius * extraRadius)) {
                    int realX = x + dx;
                    int realZ = z + dz;

                    for(int dy = -depth; dy <= 0; ++dy) {
                        int realY = y + dy;
                        if (realY >= 5 && rand.nextFloat() < 0.04F) {
                            this.tryPlaceOre(world, rand, realX, realY, realZ);
                        }
                    }
                }
            }
        }

    }

    private void tryPlaceOre(World world, Random rand, int x, int y, int z) {
        Block ore = this.pickRandomOre(rand);
        if (ore != null) {
            Block target = world.getBlock(x, y, z);
            if (target != Blocks.air && target.getMaterial().isSolid() && target != Blocks.sand && target != Blocks.water && target != Blocks.flowing_water && (target == Blocks.stone || target == Blocks.sandstone)) {
                world.setBlock(x, y, z, ore, 0, 2);
            }

        }
    }

    private Block pickRandomOre(Random rand) {
        float chance = rand.nextFloat();
        if (chance < 0.4F) {
            return NovaCraftBlocks.meteorite_block;
        } else if (chance >= 0.4F && chance < 0.7F) {
            return Blocks.iron_ore;
        } else if (chance >= 0.7F && chance < 0.89F) {
            return Blocks.gold_ore;
        } else if (chance >= 0.89F && chance <= 0.9F) {
            return Blocks.diamond_ore;
        } else {
            return chance > 0.9F && chance <= 0.93F ? NovaCraftBlocks.iridium_ore : NovaCraftBlocks.meteorite_block;
        }
    }

    private void clearLiquidsInCrater(World world, int x, int y, int z, int radiusInt, float radius) {
        for(int dx = -radiusInt; dx <= radiusInt; ++dx) {
            for(int dz = -radiusInt; dz <= radiusInt; ++dz) {
                double horizDistSq = (double)(dx * dx + dz * dz);
                if (horizDistSq <= (double)(radius * radius)) {
                    int realX = x + dx;
                    int realZ = z + dz;

                    int dy;
                    for(dy = y + 1; dy < world.getActualHeight(); ++dy) {
                        Block block = world.getBlock(realX, dy, realZ);
                        if (block.getMaterial().isLiquid()) {
                            world.setBlockToAir(realX, dy, realZ);
                        }
                    }

                    for(dy = -24; dy <= 1; ++dy) {
                        int realY = y + dy;
                        if (realY >= 0) {
                            Block block = world.getBlock(realX, realY, realZ);
                            if (block.getMaterial().isLiquid()) {
                                world.setBlockToAir(realX, realY, realZ);
                            }
                        }
                    }
                }
            }
        }

    }
}