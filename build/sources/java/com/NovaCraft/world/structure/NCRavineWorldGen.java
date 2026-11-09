package com.NovaCraft.world.structure;

import java.util.Arrays;
import java.util.Random;
import com.NovaCraft.config.ConfigsWorld;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.MapGenRavine;

public class NCRavineWorldGen extends MapGenRavine {

    private static boolean[] blockedBiomes;

    private final float[] widthScale = new float[256];

    public static void resolveBiomeFilter() {
        String[] whitelist = ConfigsWorld.ravineBiomeWhitelist;
        String[] blacklist = ConfigsWorld.ravineBiomeBlacklist;
        if (whitelist.length == 0 && blacklist.length == 0) {
            blockedBiomes = null;
            return;
        }

        BiomeGenBase[] biomes = BiomeGenBase.getBiomeGenArray();
        boolean[] blocked = new boolean[biomes.length];
        if (whitelist.length > 0) {
            Arrays.fill(blocked, true);
            for (String entry : whitelist) {
                int id = findBiome(biomes, entry);
                if (id >= 0) blocked[id] = false;
            }
        }
        for (String entry : blacklist) {
            int id = findBiome(biomes, entry);
            if (id >= 0) blocked[id] = true;
        }
        blockedBiomes = blocked;
    }

    private static int findBiome(BiomeGenBase[] biomes, String entry) {
        String name = entry.trim();
        try {
            int id = Integer.parseInt(name);
            if (id >= 0 && id < biomes.length && biomes[id] != null) return id;
        } catch (NumberFormatException ignored) {
            for (BiomeGenBase biome : biomes) {
                if (biome != null && biome.biomeName.equalsIgnoreCase(name)) return biome.biomeID;
            }
        }
        FMLLog.warning("[NovaCraft] Unknown biome in ravine biome list: %s", entry);
        return -1;
    }

    @Override
    protected void func_151538_a(World world, int chunkX, int chunkZ, int x, int z, Block[] blocks) {
        if (this.rand.nextInt(ConfigsWorld.ravineChance) == 0) {

            boolean useCustom = this.rand.nextInt(ConfigsWorld.tallRavineChance) == 0;

            double d0 = chunkX * 16 + this.rand.nextInt(16);
            BiomeGenBase startBiome = world.getBiomeGenForCoords(chunkX * 16 + 8, chunkZ * 16 + 8);
            if (blockedBiomes != null && blockedBiomes[startBiome.biomeID]) return;

            boolean tallBiome = startBiome.rootHeight >= ConfigsWorld.tallBiomeRavineMinBaseHeight;
            int maxStartY = tallBiome ? ConfigsWorld.tallBiomeRavineMaxStartY : ConfigsWorld.ravineMaxStartY;
            double d1 = this.rand.nextInt(this.rand.nextInt(maxStartY - 26) + 8) + 20;
            double d2 = chunkZ * 16 + this.rand.nextInt(16);

            float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
            float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float f2 = (this.rand.nextFloat() * 2.0F + this.rand.nextFloat()) * 2.0F;

            double heightScale = useCustom ? ConfigsWorld.tallRavineHeightScale : ConfigsWorld.ravineHeightScale;
            this.func_151540_a(this.rand.nextLong(), x, z, blocks, d0, d1, d2, f2, f, f1, 0, 0, heightScale);
        }
    }

    @Override
    protected void func_151540_a(long seed, int chunkX, int chunkZ, Block[] blocks, double x, double y, double z, float width, float yaw, float pitch, int start, int end, double verticalScale) {
        Random random = new Random(seed);
        double centerX = chunkX * 16 + 8;
        double centerZ = chunkZ * 16 + 8;

        float yawOffset = 0.0F;
        float pitchOffset = 0.0F;

        if (end <= 0) {
            int range = this.range * 16 - 16;
            end = range - random.nextInt(range / 4);
        }

        boolean firstLoop = false;
        BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(x), MathHelper.floor_double(z));
        Block top = biome.topBlock;
        Block filler = biome.fillerBlock;
        boolean redSandBiome = top == Blocks.sand && biome.field_150604_aj == 1;
        boolean carveSand = redSandBiome ? ConfigsWorld.ravinesCarveRedSand : ConfigsWorld.ravinesCarveSand;
        boolean carveSandstone = ConfigsWorld.ravinesCarveSandstone;
        boolean carveClay = ConfigsWorld.ravinesCarveHardenedClay;
        boolean resurfaceFloor = top != Blocks.sand;

        if (start == -1) {
            start = end / 2;
            firstLoop = true;
        }

        float[] field_75046_d = this.widthScale;
        float f5 = 1.0F;

        for (int i = 0; i < 256; ++i) {
            if (i == 0 || random.nextInt(3) == 0) {
                f5 = 1.0F + random.nextFloat() * random.nextFloat();
            }
            field_75046_d[i] = f5 * f5;
        }

        for (; start < end; ++start) {
            double radiusXZ = 1.5D + MathHelper.sin(start * (float)Math.PI / end) * width;
            double radiusY = radiusXZ * verticalScale;

            radiusXZ *= random.nextFloat() * 0.25D + 0.75D;
            radiusY *= random.nextFloat() * 0.25D + 0.75D;

            float cosPitch = MathHelper.cos(pitch);
            float sinPitch = MathHelper.sin(pitch);

            x += MathHelper.cos(yaw) * cosPitch;
            y += sinPitch;
            z += MathHelper.sin(yaw) * cosPitch;

            pitch *= 0.7F;
            pitch += pitchOffset * 0.05F;
            yaw += yawOffset * 0.05F;

            pitchOffset *= 0.8F;
            yawOffset *= 0.5F;

            pitchOffset += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            yawOffset += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;

            if (!firstLoop && random.nextInt(4) == 0) continue;

            double dx = x - centerX;
            double dz = z - centerZ;
            double distance = end - start;
            double range = width + 2.0F + 16.0F;

            if (dx * dx + dz * dz - distance * distance > range * range) return;

            if (x < centerX - 16.0D - radiusXZ * 2.0D || z < centerZ - 16.0D - radiusXZ * 2.0D || x > centerX + 16.0D + radiusXZ * 2.0D || z > centerZ + 16.0D + radiusXZ * 2.0D)
                continue;

            int minX = MathHelper.floor_double(x - radiusXZ) - chunkX * 16 - 1;
            int maxX = MathHelper.floor_double(x + radiusXZ) - chunkX * 16 + 1;
            int minY = MathHelper.floor_double(y - radiusY) - 1;
            int maxY = MathHelper.floor_double(y + radiusY) + 1;
            int minZ = MathHelper.floor_double(z - radiusXZ) - chunkZ * 16 - 1;
            int maxZ = MathHelper.floor_double(z + radiusXZ) - chunkZ * 16 + 1;

            minX = Math.max(minX, 0);
            maxX = Math.min(maxX, 16);
            minY = Math.max(minY, 1);
            maxY = Math.min(maxY, 255);
            minZ = Math.max(minZ, 0);
            maxZ = Math.min(maxZ, 16);

            boolean oceanBlock = false;

            for (int x1 = minX; !oceanBlock && x1 < maxX; ++x1) {
                for (int z1 = minZ; !oceanBlock && z1 < maxZ; ++z1) {
                    for (int y1 = maxY + 1; !oceanBlock && y1 >= minY - 1; --y1) {
                        int index = (x1 * 16 + z1) * 256 + y1;
                        if (y1 >= 0 && y1 < 256) {
                            Block block = blocks[index];
                            if (block == Blocks.water || block == Blocks.flowing_water) {
                                oceanBlock = true;
                            }

                            if (y1 != minY - 1 && x1 != minX && x1 != maxX - 1 && z1 != minZ && z1 != maxZ - 1) {
                                y1 = minY;
                            }
                        }
                    }
                }
            }

            if (!oceanBlock) {
                for (int x1 = minX; x1 < maxX; ++x1) {
                    double xDist = (x1 + chunkX * 16 + 0.5D - x) / radiusXZ;

                    for (int z1 = minZ; z1 < maxZ; ++z1) {
                        double zDist = (z1 + chunkZ * 16 + 0.5D - z) / radiusXZ;
                        int index = (x1 * 16 + z1) * 256 + maxY;
                        boolean surfaceTouched = false;

                        if (xDist * xDist + zDist * zDist < 1.0D) {
                            for (int y1 = maxY - 1; y1 >= minY; --y1) {
                                double yDist = (y1 + 0.5D - y) / radiusY;

                                if ((xDist * xDist + zDist * zDist) * field_75046_d[y1] + yDist * yDist / 6.0D < 1.0D) {
                                    Block block = blocks[index];

                                    if (block == top || block == Blocks.grass) surfaceTouched = true;

                                    boolean carvable;
                                    if (block == Blocks.sand) carvable = carveSand;
                                    else if (block == Blocks.sandstone) carvable = carveSandstone;
                                    else if (block == Blocks.hardened_clay || block == Blocks.stained_hardened_clay) carvable = carveClay;
                                    else carvable = block == Blocks.stone || block == Blocks.dirt || block == Blocks.grass || block == top || block == filler;

                                    if (carvable) {
                                        if (y1 < 10) {
                                            blocks[index] = Blocks.flowing_lava;
                                        } else {
                                            blocks[index] = null;

                                            if (resurfaceFloor && surfaceTouched && blocks[index - 1] == filler) {
                                                blocks[index - 1] = top;
                                            }
                                        }
                                    }
                                }
                                --index;
                            }
                        }
                    }
                }

                if (firstLoop) break;
            }
        }
    }
}