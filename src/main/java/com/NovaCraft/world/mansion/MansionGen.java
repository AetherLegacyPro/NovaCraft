package com.NovaCraft.world.mansion;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

public class MansionGen implements IWorldGenerator {

    @Override //Need to add config option at some point, so they can generate in other dimensions at some point
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) {
            this.generateOverworld(world, rand, chunkX * 16, chunkZ * 16);
        }
    }

    //When the vindicator insignia is trying to find the ancient city it points to locations where there are no ancient cities in the negative quadrants
    //Without this if x<0 or z<0 it chooses the wrong quadrant as the true position and position the vindicator insignia points to become misaligned due to a truncation error
    //-((-a + b - 1) / b) is added to make sure it rounds toward a negative integer instead of toward 0 as this is what truncating does in java for some reason
    private static int floorDiv(int a, int b) {
        if (a >= 0) return a / b;
        return - ((-a + b - 1) / b);
    }
    public void generateOverworld(World world, Random rand, int x, int z) {

        if (Math.abs(x) >= 12000 || Math.abs(z) >= 12000) {

            BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
            BiomeDictionary.Type[] biomeList = BiomeDictionary.getTypesForBiome(biome);

            BiomeGenBase biomePosX = world.getBiomeGenForCoords(x + 60, z);
            BiomeDictionary.Type[] biomeListPosX= BiomeDictionary.getTypesForBiome(biomePosX);

            BiomeGenBase biomePosZ = world.getBiomeGenForCoords(x, z + 76);
            BiomeDictionary.Type[] biomeListNegX = BiomeDictionary.getTypesForBiome(biomePosZ);

            BiomeGenBase biomePosXPosZ = world.getBiomeGenForCoords(x + 60, z + 76);
            BiomeDictionary.Type[] biomeListPosXPosZ = BiomeDictionary.getTypesForBiome(biomePosXPosZ);

            //The minimum distance between Mansions, so they do not overlap
            final int spacing = 500;

            int regionX = floorDiv(x, spacing);
            int regionZ = floorDiv(z, spacing);

            //Tie the generation to the world seed
            Random regionRand = new Random(world.getSeed() + (long) (regionX * 341873128712L) + (long) (regionZ * 132897987541L));

            if (regionRand.nextInt(2) == 1 && ArrayUtils.contains(biomeList, BiomeDictionary.Type.FOREST)
                    && ArrayUtils.contains(biomeListPosX, BiomeDictionary.Type.FOREST) && ArrayUtils.contains(biomeListNegX, BiomeDictionary.Type.FOREST)
                    && ArrayUtils.contains(biomeListPosXPosZ, BiomeDictionary.Type.FOREST)) {

                int baseX = regionX * spacing + regionRand.nextInt(spacing);
                int baseZ = regionZ * spacing + regionRand.nextInt(spacing);

                //Make sure generator runs only in the chunk containing baseX/baseZ
                if ((x >> 4) == (baseX >> 4) && (z >> 4) == (baseZ >> 4)) {
                    //If baseX and baseZ coords are less than 12k in x or z fail to generate
                    if (Math.abs(baseX) < 12000 || Math.abs(baseZ) < 12000) return;

                    int x1 = baseX + regionRand.nextInt(8) + 8;
                    int z1 = baseZ + regionRand.nextInt(8) + 8;

                    int x2 = x1 + 36;
                    int z2 = z1 + 36;

                    int width = 36;
                    int length = 36;
                    int sumY = 0;
                    int count = 0;
                    int maxY = 0;

                    for (int dx = 0; dx < width; dx++) {
                        for (int dz = 0; dz < length; dz++) {
                            int y = getSurfaceY(world, x2 + dx, z2 + dz);
                            sumY += y;
                            count++;
                            if (y > maxY) maxY = y;
                        }
                    }
                    int y1 = sumY / count;

                    if (maxY > 75) {
                        y1 = 65;
                    }

                    terraformMansionSite(world, x2, y1, z2);

                    System.out.println("Mansion generating at (X:" + x2 + ", Z:" + z2 + ")");

                    new MansionAirGen().generate(world, rand, x2, y1, z2);
                    new MansionBaseGen().generate(world, rand, x2, y1, z2);
                    new MansionEntrance().generate(world, rand, x2 + 20, y1 + 4, z2 - 3);

                    new MansionFloor1Gen().generate(world, rand, x2, y1 + 8, z2);
                    new MansionFloor1Gen2().generate(world, rand, x2, y1 + 8, z2);
                    new MansionFloor1Gen3().generate(world, rand, x2, y1 + 8, z2);
                    new MansionFloor1Gen4().generate(world, rand, x2, y1 + 8, z2);
                    new MansionFloor1Gen5().generate(world, rand, x2, y1 + 8, z2);
                    new MansionFloor1Gen6().generate(world, rand, x2, y1 + 8, z2);
                    new MansionBasementStairsFloor1Gen().generate(world, rand, x2 + 17, y1 + 7, z2 + 41);

                    new MansionFloor2Gen().generate(world, rand, x2, y1 + 16, z2 - 1);
                    new MansionFloor2Gen2().generate(world, rand, x2, y1 + 16, z2 - 1);
                    new MansionFloor2Gen3().generate(world, rand, x2, y1 + 16, z2 - 1);
                    new MansionFloor2Gen4().generate(world, rand, x2, y1 + 16, z2 - 1);
                    new MansionFloor2Gen5().generate(world, rand, x2, y1 + 16, z2 - 1);
                    new MansionFloor2Gen6().generate(world, rand, x2, y1 + 16, z2 - 1);
                    new MansionFloor2Gen7().generate(world, rand, x2, y1 + 16, z2 - 1);

                    new MansionFloor3Gen().generate(world, rand, x2 - 1, y1 + 27, z2 - 1);
                    new MansionFloor3Gen2().generate(world, rand, x2 - 1, y1 + 27, z2 - 1);
                    new MansionFloor3Gen3().generate(world, rand, x2 - 1, y1 + 27, z2 - 1);
                    new MansionFloor3Gen4().generate(world, rand, x2 - 1, y1 + 27, z2 - 1);

                    new MansionBasementStairsGen().generate(world, rand, x2 + 29, y1 - 24, z2 + 41);
                    new MansionBasementAirGen().generate(world, rand, x2 - 27, y1 - 24, z2 + 22);
                    new MansionBasementGen().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen2().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen3().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen4().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen5().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen6().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionSealedOffRoomGen().generate(world, rand, x2 + 33, y1 - 24, z2 + 33);
                    new MansionRavagerStatue().generate(world, rand, x2 - 11, y1 - 23, z2 + 65);
                }
            }

        }
    }

    public static int getSurfaceY(World world, int x, int z) {
        int y = world.getActualHeight() - 1; //Start from top of world

        //Search downward until we hit a solid block
        while (y > 0) {
            int blockId = world.getBlock(x, y, z).getMaterial().isSolid() ? 1 : 0;
            if (blockId != 0) break;
            y--;
        }
        return y;
    }

    private void terraformMansionSite(World world, int startX, int startY, int startZ) {
        int width = 59;
        int length = 75;

        for (int dx = 0; dx < width; dx++) {
            for (int dz = 0; dz < length; dz++) {

                int x = startX + dx;
                int z = startZ + dz;

                //Fill downward until a true solid block is hit
                for (int y = startY; y > 0; y--) {
                    Block block = world.getBlock(x, y, z);
                    Material mat = block.getMaterial();

                    //Stop if we hit a real solid block
                    if (isTrueSolidBlock(block)) {
                        break;
                    }

                    //Replace air, plants, non-full blocks etc
                    world.setBlock(x, y, z, Blocks.cobblestone, 0, 2);
                }
            }
        }
    }

    private boolean isTrueSolidBlock(Block block) {
        Material mat = block.getMaterial();

        if (block instanceof BlockBush) return false;
        if (block instanceof BlockSnow) return false;

        if (mat == Material.water || mat == Material.lava) return false;

        return mat.isSolid() && block.isOpaqueCube() && block.renderAsNormalBlock();
    }
}