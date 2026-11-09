package com.NovaCraft.world.caves;

import com.NovaCraft.config.ConfigsWorld;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import java.util.Arrays;
import java.util.Random;

public class CaveWorldGeneratorDeepDark implements IWorldGenerator {

    private final CaveBiomeGenerator generator_DEEPDARK_MOUNTAIN;
    private final CaveBiomeGenerator generator_DEEPDARK_NON_MOUNTAIN;

    public CaveWorldGeneratorDeepDark() {
        generator_DEEPDARK_MOUNTAIN = new CaveBiomeGenerator(new DeepDarkBiome(),
                180,        //lower rarity = more common
                294, 20, 294,   //min sizes
                40, 20, 40,   //variation
                12, 30,   //Y range
                Arrays.asList(BiomeDictionary.Type.MOUNTAIN)
        );

        generator_DEEPDARK_NON_MOUNTAIN = new CaveBiomeGenerator(new DeepDarkBiome(),
                480,
                196, 20, 196,
                20, 10, 20,
                12, 30,
                Arrays.asList(BiomeDictionary.Type.COLD)
        );
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        if (world.provider.dimensionId != 0) return;

        BlockPos[] sources_sculk = generator_DEEPDARK_MOUNTAIN.getSourcesInChunk(random, chunkX, chunkZ);
        BlockPos[] sources_sculk_nonmountain = generator_DEEPDARK_NON_MOUNTAIN.getSourcesInChunk(random, chunkX, chunkZ);

        if (ConfigsWorld.enableDeepDark) {
            for (BlockPos pos : sources_sculk) {
                if (generator_DEEPDARK_MOUNTAIN.isSourceValid(world, pos)) {
                    generator_DEEPDARK_MOUNTAIN.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }

            for (BlockPos pos : sources_sculk_nonmountain) {
                if (generator_DEEPDARK_NON_MOUNTAIN.isSourceValid(world, pos)) {
                    generator_DEEPDARK_NON_MOUNTAIN.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }
        }

    }
}
