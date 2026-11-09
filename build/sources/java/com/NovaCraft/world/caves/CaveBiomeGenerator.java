package com.NovaCraft.world.caves;

import java.util.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

public class CaveBiomeGenerator extends MultiChunkFeatureGenerator {

    public final UndergroundBiome biome;
    public final List<BiomeDictionary.Type> types;
    public final int rarity;
    public final int minXSize, minYSize, minZSize;
    public final int xVariation, yVariation, zVariation;
    public final int minY, maxY;

    private final long seedXor;

    // TUNABLES (adjust these first)
    private static final int BLOBS_CELL_SIZE = 80;     // bigger = thicker, larger patches
    private static final double NOISE_AMPLITUDE = 0.01; // smaller = more consistent coverage
    private static final double SURFACE_SHELL = 0.99; // bigger = more blocks qualify near surface
    private static final boolean COUNT_LIQUID_AS_EXPOSED = true; // set false to ignore water/lava adjacency
    private static final boolean APPLY_Y_CULL = true; // set true to restore your y>25 filtering

    public CaveBiomeGenerator(UndergroundBiome biome, int rarity, int minXSize, int minYSize, int minZSize,
                              int xVariation, int yVariation, int zVariation,
                              int minY, int maxY,
                              List<BiomeDictionary.Type> types) {
        this.biome = biome;
        this.types = types;
        this.rarity = rarity;
        this.minXSize = minXSize;
        this.minYSize = minYSize;
        this.minZSize = minZSize;
        this.xVariation = xVariation;
        this.yVariation = yVariation;
        this.zVariation = zVariation;
        this.minY = minY;
        this.maxY = maxY;

        seedXor = biome.getClass().toString().hashCode();
    }

    @Override
    public int getFeatureRadius() {
        return (int) Math.ceil(Math.max(minXSize + xVariation, minZSize + zVariation));
    }

    @Override
    public void generateChunkPart(BlockPos src, Random random, int chunkX, int chunkZ, World world) {

        for (int i = 0; i < 24 + random.nextInt(4); i++) {
            int offsetX = src.x + random.nextInt(20) - 10;
            int offsetY = src.y + random.nextInt(10) - 5;
            int offsetZ = src.z + random.nextInt(20) - 10;

            int radiusX = minXSize + random.nextInt(xVariation);
            int radiusY = minYSize + random.nextInt(yVariation);
            int radiusZ = minZSize + random.nextInt(zVariation);

            apply(world, offsetX, offsetY, offsetZ, random, chunkX, chunkZ, radiusX, radiusY, radiusZ);
        }
    }

    @Override
    public BlockPos[] getSourcesInChunk(Random random, int chunkX, int chunkZ) {
        if (rarity > 0 && random.nextInt(rarity) == 0) {
            return new BlockPos[] {
                    new BlockPos(
                            chunkX * 16 + random.nextInt(16),
                            minY + random.nextInt(maxY - minY),
                            chunkZ * 16 + random.nextInt(16)
                    )
            };
        }

        return new BlockPos[0];
    }

    @Override
    public long modifyWorldSeed(long seed) {
        return seed ^ seedXor;
    }

    @Override
    public boolean isSourceValid(World world, BlockPos pos) {
        BiomeGenBase biomeGen = world.getBiomeGenForCoords((int) pos.x, (int) pos.z);
        return (types.isEmpty() || biomeTypeIntersectCheck(types, biomeGen)) && biome.isValidBiome(biomeGen);
    }

    public boolean biomeTypeIntersectCheck(List<BiomeDictionary.Type> typesArray, BiomeGenBase b) {
        BiomeDictionary.Type[] currentBiomesTypes = BiomeDictionary.getTypesForBiome(b);
        for (BiomeDictionary.Type type : typesArray) {
            for (BiomeDictionary.Type currentType : currentBiomesTypes) {
                if (currentType.equals(type)) return true;
            }
        }
        return false;
    }

    public void apply(World world, int centerX, int centerY, int centerZ,
                      Random random, int chunkX, int chunkZ,
                      int radiusX, int radiusY, int radiusZ) {

        double radiusX2 = radiusX * radiusX;
        double radiusY2 = radiusY * radiusY;
        double radiusZ2 = radiusZ * radiusZ;

        UndergroundBiomeGenerationContext context = new UndergroundBiomeGenerationContext();

        forEachChunkBlock(chunkX, chunkZ, centerY - radiusY, centerY + radiusY, (pos) -> {

            // Optional Y culling (off by default because it dramatically reduces coverage)
            if (APPLY_Y_CULL) {
                if (pos.y > 25) {
                    if (pos.y > 30 || random.nextFloat() > 0.25f) return;
                }
            }

            int x = (int) (pos.x - centerX);
            int y = (int) (pos.y - centerY);
            int z = (int) (pos.z - centerZ);

            // Warp (use originals to avoid artifacts/striping)
            double warp = 0.2;
            int ox = x, oz = z;
            x = ox + (int) (Math.sin(oz * 0.1) * warp * radiusX);
            z = oz + (int) (Math.cos(ox * 0.1) * warp * radiusZ);

            // World coords for this candidate
            int wx = centerX + x;
            int wy = centerY + y;
            int wz = centerZ + z;

            double distX = x * x;
            double distY = y * y;
            double distZ = z * z;

            // Thick, position-based noise (no iteration-order striping)
            int cell = BLOBS_CELL_SIZE;
            double n = posNoise01(world.getSeed(),
                    Math.floorDiv(wx, cell),
                    Math.floorDiv(wy, cell),
                    Math.floorDiv(wz, cell));
            double noise = n * NOISE_AMPLITUDE;

            // Ellipsoid value (1.0 is surface). We accept a "shell" around it.
            double value = distX / radiusX2 + distY / radiusY2 + distZ / radiusZ2;

            // More consistent surface coverage: use a shell band + mild noise
            boolean nearSurfaceOrInside = value <= (1.0 + SURFACE_SHELL + noise);
            if (!nearSurfaceOrInside) return;

            // Exposed check: count air AND other "open" blocks as exposed
            boolean exposed = false;
            for (EnumFacing dir : EnumFacing.values()) {
                int nx = wx + dir.getFrontOffsetX();
                int ny = wy + dir.getFrontOffsetY();
                int nz = wz + dir.getFrontOffsetZ();

                Block nb = world.getBlock(nx, ny, nz);

                if (!COUNT_LIQUID_AS_EXPOSED) {
                    Material m = nb.getMaterial();
                    if (m != null && m.isLiquid()) continue;
                }

                if (world.isAirBlock(nx, ny, nz) ||
                        nb.getCollisionBoundingBoxFromPool(world, nx, ny, nz) == null ||
                        !nb.getMaterial().isSolid() ||
                        nb.isReplaceable(world, nx, ny, nz)) {
                    exposed = true;
                    break;
                }
            }

            if (!exposed) return;

            biome.fill(world, wx, wy, wz, context);
        });

        context.floorList.forEach(pos -> biome.finalFloorPass(world, pos.x, pos.y, pos.z));
        context.ceilingList.forEach(pos -> biome.finalCeilingPass(world, pos.x, pos.y, pos.z));
        context.wallMap.keySet().forEach(pos -> biome.finalWallPass(world, pos.x, pos.y, pos.z));
        context.insideList.forEach(pos -> biome.finalInsidePass(world, pos.x, pos.y, pos.z));

        if (biome.hasDungeon() && world instanceof WorldServer && random.nextDouble() < biome.dungeonChance) {
            List<BlockPos> candidates = new ArrayList<>(context.wallMap.keySet());
            candidates.removeIf(pos -> {
                Block block = world.getBlock((int) pos.x, (int) pos.y - 1, (int) pos.z);
                BlockPos newPos = pos.down();
                return biome.isWall(world, newPos.x, newPos.y, newPos.z, block)
                        || block.isAir(world, (int) pos.x, (int) pos.y - 1, (int) pos.z);
            });

            if (!candidates.isEmpty()) {
                BlockPos pos = candidates.get(world.rand.nextInt(candidates.size()));

                EnumFacing border = context.wallMap.get(pos);
                if (border != null) biome.spawnDungeon((WorldServer) world, pos, border);
            }
        }
    }

    // Deterministic hash noise in [0,1)
    private static double posNoise01(long worldSeed, int x, int y, int z) {
        long h = worldSeed;
        h ^= x * 341873128712L;
        h ^= y * 132897987541L;
        h ^= z * 42317861L;
        h = (h ^ (h >> 27)) * 0x3C79AC492BA7B653L;
        h = (h ^ (h >> 33)) * 0x1C69B3F74AC4AE35L;
        h ^= (h >> 27);
        return ((h & ((1L << 53) - 1)) / (double) (1L << 53));
    }

    public static class UndergroundBiomeGenerationContext {
        public final List<BlockPos> floorList = new LinkedList<>();
        public final List<BlockPos> ceilingList = new LinkedList<>();
        public final List<BlockPos> insideList = new LinkedList<>();
        public final Map<BlockPos, EnumFacing> wallMap = new HashMap<>();
    }

    public static class UndergroundBiomeData {
        public UndergroundBiomeData(UndergroundBiome biome, int rarity,
                                    int minWidth, int widthVariation,
                                    int minHeight, int heightVariation,
                                    int minY, int maxY,
                                    List<BiomeDictionary.Type> types) {
            this.biome = biome;
            this.rarity = rarity;
            this.minWidth = minWidth;
            this.widthVariation = widthVariation;
            this.minHeight = minHeight;
            this.heightVariation = heightVariation;
            this.minY = minY;
            this.maxY = maxY;
            this.types = types;
        }

        public final UndergroundBiome biome;
        public final int rarity;
        public final int minWidth;
        public final int widthVariation;
        public final int minHeight;
        public final int heightVariation;
        public final int minY;
        public final int maxY;
        public final List<BiomeDictionary.Type> types;
    }
}