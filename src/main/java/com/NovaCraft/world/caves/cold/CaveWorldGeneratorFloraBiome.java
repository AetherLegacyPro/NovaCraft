package com.NovaCraft.world.caves.cold;

import com.NovaCraft.config.ConfigsWorld;
import com.NovaCraft.world.caves.BlockPos;
import com.NovaCraft.world.caves.jungle.JungleFloraBiome;
import com.NovaCraft.world.caves.temperate.TemperateFloraBiome;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import java.util.Arrays;
import java.util.Random;

public class CaveWorldGeneratorFloraBiome implements IWorldGenerator {

    private final CaveBiomeGeneratorNearSurface generator_COLD_FLORA;
    private final CaveBiomeGeneratorNearSurface generator_TEMP_FLORA;
    private final CaveBiomeGeneratorNearSurface generator_JUNGLE_FLORA;

    public CaveWorldGeneratorFloraBiome() {
        generator_COLD_FLORA = new CaveBiomeGeneratorNearSurface(new ColdFloraBiome(),
                360,
                248, 20, 248,
                10, 5, 10,
                36, 62,
                Arrays.asList(BiomeDictionary.Type.COLD)
        );

        generator_TEMP_FLORA = new CaveBiomeGeneratorNearSurface(new TemperateFloraBiome(),
                360,
                248, 20, 248,
                10, 5, 10,
                36, 62,
                Arrays.asList(BiomeDictionary.Type.FOREST)
        );

        generator_JUNGLE_FLORA = new CaveBiomeGeneratorNearSurface(new JungleFloraBiome(),
                360,
                298, 20, 298,
                10, 5, 10,
                36, 62,
                Arrays.asList(BiomeDictionary.Type.JUNGLE)
        );
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        if (world.provider.dimensionId != 0) return;

        BlockPos[] sources_cold_flora = generator_COLD_FLORA.getSourcesInChunk(random, chunkX, chunkZ);
        BlockPos[] sources_temp_flora = generator_TEMP_FLORA.getSourcesInChunk(random, chunkX, chunkZ);
        BlockPos[] sources_jungle_flora = generator_JUNGLE_FLORA.getSourcesInChunk(random, chunkX, chunkZ);

        if (ConfigsWorld.enableColdFloraCavern) {
            for (BlockPos pos : sources_cold_flora) {
                if (generator_COLD_FLORA.isSourceValid(world, pos)) {
                    generator_COLD_FLORA.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }
        }

        if (ConfigsWorld.enableTemperateFloraCavern) {
            for (BlockPos pos : sources_temp_flora) {
                if (generator_TEMP_FLORA.isSourceValid(world, pos)) {
                    generator_TEMP_FLORA.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }
        }

        if (ConfigsWorld.enableTropicalFloraCavern) {
            for (BlockPos pos : sources_jungle_flora) {
                if (generator_JUNGLE_FLORA.isSourceValid(world, pos)) {
                    generator_JUNGLE_FLORA.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }
        }
    }
}
