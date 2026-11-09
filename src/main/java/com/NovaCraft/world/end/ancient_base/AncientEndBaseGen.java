package com.NovaCraft.world.end.ancient_base;

import com.NovaCraft.world.ancient_city.AncientCitySphereGen;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class AncientEndBaseGen implements IWorldGenerator {

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 1) {
            this.generateEnd(world, rand, chunkX * 16, chunkZ * 16);
        }
    }

    public void generateEnd(World world, Random rand, int x, int z) {
            int x1 = x + rand.nextInt(8) + 8;
            int y1 = 27;
            int z1 = z + rand.nextInt(8) + 8;

            new AncientCitySphereGen().generate(world, rand, x1, y1, z1);
            new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1);
            new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1);
            new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 12);
            new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 12);
            new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1 + 12);
            new AncientCitySphereGen().generate(world, rand, x1 + 12, y1, z1 - 12);
            new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1 + 12);
            new AncientCitySphereGen().generate(world, rand, x1 - 12, y1, z1 - 12);
            new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 24);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 12, z1 + 24);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 24, z1 + 24);
            new AncientCitySphereGen().generate(world, rand, x1 - 24, y1, z1 + 24);
            new AncientCitySphereGen().generate(world, rand, x1 - 24, y1 + 12, z1 + 24);
            new AncientCitySphereGen().generate(world, rand, x1 - 24, y1 + 24, z1 + 24);
            new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 12, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 24, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 - 48, y1, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 - 48, y1 + 12, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 - 48, y1 + 24, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 + 48, y1, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 + 48, y1 + 12, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 + 48, y1 + 24, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 + 36, y1, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 + 36, y1 + 12, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 + 36, y1 + 24, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 - 36, y1, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 - 36, y1 + 12, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1 - 36, y1 + 24, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 36, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 48, z1 + 48);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 36, z1 + 60);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 48, z1 + 60);
            new AncientCitySphereGen().generate(world, rand, x1 - 21, y1 + 16, z1 - 15);
            new AncientCitySphereGen().generate(world, rand, x1 - 21, y1 + 32, z1 - 15);
            new AncientCitySphereGen().generate(world, rand, x1 - 21, y1 + 48, z1 - 15);

            new AncientEndBaseMainGen().generate(world, rand, x1, y1, z1);
            new AncientEndBaseMainGen2().generate(world, rand, x1, y1, z1);
            new AncientEndBaseAltarGen().generate(world, rand, x1 + 9, y1 + 24, z1 + 60);
            new AncientEndBaseShrine().generate(world, rand, x1 + 17, y1 + 6, z1 - 30);

            new AncientEndBaseRuinedTowerGen().generate(world, rand, x1 - 21, y1 + 3, z1 - 15);
            new AncientEndBaseRuinedTowerGen2().generate(world, rand, x1 - 21, y1 + 3, z1 - 15);

            if (rand.nextBoolean()) {
                new AncientEndBaseEndermanStatue().generate(world, rand, x1 + 36, y1 + 10, z1 + 68);
                new AncientEndBaseEndermanStatue().generate(world, rand, x1 + 14, y1 + 10, z1 + 68);
            } else {
                new AncientEndBaseEndermanStatue().generate(world, rand, x1 + 36, y1 + 10, z1 + 68);
            }

            if (rand.nextBoolean()) {
                new AncientEndBaseUnknownEntityStatue().generate(world, rand, x1 + 28, y1 + 43, z1 + 95);
            }

            new AncientEndBasePlatformGen().generate(world, rand, x1 + 9, y1 + 8, z1 + 60);
            new AncientEndBasePlatformGen().generate(world, rand, x1 + 18, y1 + 17, z1 + 42);
            new AncientEndBasePlatformGen().generate(world, rand, x1 - 18, y1 + 11, z1 + 48);
            new AncientEndBasePlatformGen().generate(world, rand, x1 + 30, y1 + 26, z1 + 36);
            new AncientEndBasePlatformGen().generate(world, rand, x1 - 19, y1 + 17, z1 + 24);
            new AncientEndBasePlatformGen().generate(world, rand, x1 + 9, y1 + 24, z1 + 55);
            new AncientEndBasePlatformGen().generate(world, rand, x1 - 18, y1 + 18, z1 + 47);
            new AncientEndBasePlatformGen().generate(world, rand, x1 + 22, y1 + 20, z1 + 47);
            new AncientEndBasePlatformGen().generate(world, rand, x1 - 18, y1 + 18, z1 + 47);
            new AncientEndBasePlatformGen().generate(world, rand, x1 + 44, y1 + 20, z1 + 47);
            new AncientEndBasePlatformGen().generate(world, rand, x1 + 34, y1 + 20, z1 + 51);
            new AncientEndBasePlatformGen().generate(world, rand, x1 + 27, y1 + 20, z1 + 65);

            System.out.println("Ancient End Site generating at (X:" + x1 + ", Z:" + z1 + ")");
        }
}
