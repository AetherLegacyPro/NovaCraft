package com.NovaCraft.world.mansion;

import com.NovaCraft.world.ancient_city.AncientCitySphereGen;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class MansionGen implements IWorldGenerator {

    @Override //Need to add config option at some point, so they can generate in other dimensions at some point
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) {
            this.generateOverworld(world, rand, chunkX * 16, chunkZ * 16);
        }
    }

    //When the echo eye is trying to find the ancient city it points to locations where there are no ancient cities in the negative quadrants
    //Without this if x<0 or z<0 it chooses the wrong quadrant as the true position and position the echo eye points to become misaligned due to a truncation error
    //-((-a + b - 1) / b) is added to make sure it rounds toward a negative integer instead of toward 0 as this is what truncating does in java for some reason
    private static int floorDiv(int a, int b) {
        if (a >= 0) return a / b;
        return - ((-a + b - 1) / b);
    }
    public void generateOverworld(World world, Random rand, int x, int z) {

        if (Math.abs(x) >= 12000 || Math.abs(z) >= 12000) {

            //The minimum distance between Mansions, so they do not overlap
            final int spacing = 500;

            int regionX = floorDiv(x, spacing);
            int regionZ = floorDiv(z, spacing);

            //Tie the generation to the world seed
            Random regionRand = new Random(world.getSeed() + (long) (regionX * 341873128712L) + (long) (regionZ * 132897987541L));

            if (regionRand.nextInt(3) == 1) {

                int baseX = regionX * spacing + regionRand.nextInt(spacing);
                int baseZ = regionZ * spacing + regionRand.nextInt(spacing);
                int yBase = 95;

                //Make sure generator runs only in the chunk containing baseX/baseZ
                if ((x >> 4) == (baseX >> 4) && (z >> 4) == (baseZ >> 4)) {
                    //If baseX and baseZ coords are less than 12k in x or z fail to generate
                    if (Math.abs(baseX) < 12000 || Math.abs(baseZ) < 12000) return;

                    int x1 = baseX + regionRand.nextInt(8) + 8;
                    int y1 = yBase;
                    int z1 = baseZ + regionRand.nextInt(8) + 8;

                    int x2 = x1 + 36;
                    int y2 = 95;
                    int z2 = z1 + 36;

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
                    new MansionBasementAirGen().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen2().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen3().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen4().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen5().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionBasementGen6().generate(world, rand, x2 - 36, y1 - 24, z2 + 21);
                    new MansionSealedOffRoomGen().generate(world, rand, x2 + 33, y1 - 24, z2 + 33);
                }
            }

        }
    }
}
