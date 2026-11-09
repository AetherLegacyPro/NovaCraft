package com.NovaCraft.world.end.ruined_end_city;

import com.NovaCraft.world.ancient_city.AncientCitySphereGen;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class RuinedEndCityGen implements IWorldGenerator {

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 1) {
            this.generateEnd(world, rand, chunkX * 16, chunkZ * 16);
        }
    }

    public void generateEnd(World world, Random rand, int x, int z) {
            int x1 = x + rand.nextInt(8) + 8;
            int y1 = 42;
            int z1 = z + rand.nextInt(8) + 8;

            new AncientCitySphereGen().generate(world, rand, x1, y1, z1);
            new AncientCitySphereGen().generate(world, rand, x1 - 16, y1, z1);
            new AncientCitySphereGen().generate(world, rand, x1 + 16, y1, z1);
            new AncientCitySphereGen().generate(world, rand, x1, y1, z1 - 16);
            new AncientCitySphereGen().generate(world, rand, x1, y1, z1 + 16);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 16, z1);
            new AncientCitySphereGen().generate(world, rand, x1 - 16, y1 + 16, z1);
            new AncientCitySphereGen().generate(world, rand, x1 + 16, y1 + 16, z1);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 16, z1 - 16);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 16, z1 + 16);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 32, z1);
            new AncientCitySphereGen().generate(world, rand, x1 - 16, y1 + 32, z1);
            new AncientCitySphereGen().generate(world, rand, x1 + 16, y1 + 32, z1);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 32, z1 - 16);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 32, z1 + 16);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 48, z1);
            new AncientCitySphereGen().generate(world, rand, x1 - 16, y1 + 48, z1);
            new AncientCitySphereGen().generate(world, rand, x1 + 16, y1 + 48, z1);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 48, z1 - 16);
            new AncientCitySphereGen().generate(world, rand, x1, y1 + 48, z1 + 16);

            new RuinedEndCityPlatformGen().generate(world, rand, x1, y1 - 22, z1 - 4);
            new RuinedEndCityPlatformGen2().generate(world, rand, x1, y1 - 22, z1 - 4);
            new RuinedEndCityRandomFloraGen().generate(world, rand, x1, y1 + 1, z1 - 4);
            new RuinedEndCityBaseGen().generate(world, rand, x1, y1, z1);

            new RuinedEndCityBranch1Gen().generate(world, rand, x1 - 31, y1 + 26, z1 + 2);
            new RuinedEndCityBranch2Gen().generate(world, rand, x1 + 1, y1 + 26, z1 + 17);

            if (rand.nextBoolean()) {
                new RuinedEndCityBranch3Gen().generate(world, rand, x1 + 17, y1 + 60, z1 + 27);
            }

            if (rand.nextBoolean()) {
                new RuinedEndShipGen().generate(world, rand, x1 + 54, y1 + 60, z1 + 27);
            }

            new RuinedEndCityBossGen1().generate(world, rand, x1 - 34, y1 + 60, z1 + 7);
            new RuinedEndCityBossGen2().generate(world, rand, x1 - 34, y1 + 60, z1 + 7);
            new RuinedEndCityBossGen3().generate(world, rand, x1 - 34, y1 + 60, z1 + 7);
            new RuinedEndCityBossGen4().generate(world, rand, x1 - 34, y1 + 60, z1 + 7);
            new RuinedEndCityBossModifications().generate(world, rand, x1 - 39, y1 + 60, z1 + 1);

            System.out.println("Ruined End City generating at (X:" + x1 + ", Z:" + z1 + ")");
        }
}
