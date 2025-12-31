package com.NovaCraft.world.meteor;

import com.NovaCraft.config.Configs;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class MeteorCraterGen implements IWorldGenerator {

    private final MeteorCraterStructure craterFeature = new MeteorCraterStructure();
    private final MassiveMeteorCraterStructure massiveCraterFeature = new MassiveMeteorCraterStructure();

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        if (world.provider.dimensionId == 0) {
            int x = chunkX * 16 + rand.nextInt(16);
            int z = chunkZ * 16 + rand.nextInt(16);
            int y = world.getTopSolidOrLiquidBlock(x, z);

            if (Configs.enableCraters && rand.nextInt(880) == 0) {
                craterFeature.generate(world, rand, x, y, z);
            }

            if (Configs.enableMassiveCraters && rand.nextInt(5760) == 0) {
                massiveCraterFeature.generate(world, rand, x, y, z);
            }
        }
    }
}
