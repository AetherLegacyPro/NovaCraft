package com.NovaCraft.world.caves.ore_deposit.deep;

import com.NovaCraft.config.ConfigsWorld;
import com.NovaCraft.world.caves.BlockPos;
import com.NovaCraft.world.caves.CaveBiomeGenerator;
import com.NovaCraft.world.caves.DeepDarkBiome;
import com.NovaCraft.world.caves.cold.CaveBiomeGeneratorNearSurface;
import com.NovaCraft.world.caves.hot.DeepMercuryCaveBiome;
import com.NovaCraft.world.caves.hot.MercuryCaveBiome;
import com.NovaCraft.world.caves.ore_deposit.dripstone_alternatives.CaveBiomeGeneratorStalgStacCave;
import com.NovaCraft.world.caves.ore_deposit.dripstone_alternatives.GrimstoneStalgStacCaveBiome;
import com.NovaCraft.world.caves.ore_deposit.dripstone_alternatives.NullstoneStalgStacCaveBiome;
import com.NovaCraft.world.caves.ore_deposit.dripstone_alternatives.StoneStalgStacCaveBiome;
import com.NovaCraft.world.caves.ore_deposit.middle.CaveBiomeGeneratorIronOreDeposit;
import com.NovaCraft.world.caves.ore_deposit.middle.CoalDeposit;
import com.NovaCraft.world.caves.ore_deposit.middle.IronDeposit;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import java.util.Arrays;
import java.util.Random;

public class CaveWorldGeneratorDeepOreDeposit implements IWorldGenerator {

    private final CaveBiomeGeneratorDeepOreDeposit generator_REDSTONE;
    private final CaveBiomeGeneratorDeepOreDeposit generator_GOLD;
    private final CaveBiomeGeneratorDeepOreDeposit generator_GOLD_ALTERNATE;

    private final CaveBiomeGeneratorIronOreDeposit generator_IRON;
    private final CaveBiomeGeneratorIronOreDeposit generator_COAL;

    private final CaveBiomeGeneratorStalgStacCave generator_STONE_STAG_STAC;
    private final CaveBiomeGeneratorDeepOreDeposit generator_GRIMSTONE_STAG_STAC;
    private final CaveBiomeGeneratorDeepOreDeposit generator_NULLSTONE_STAG_STAC;

    private final CaveBiomeGeneratorNearSurface generator_MERCURY;
    private final CaveBiomeGenerator generator_MERCURY_DEEP;

    public CaveWorldGeneratorDeepOreDeposit() {
        generator_REDSTONE = new CaveBiomeGeneratorDeepOreDeposit(new RedstoneDeposit(),
                420,
                96, 20, 96,
                10, 5, 10,
                5, 24,
                Arrays.asList(BiomeDictionary.Type.HOT)
        );

        generator_GOLD = new CaveBiomeGeneratorDeepOreDeposit(new GoldDeposit(),
                480,
                96, 20, 96,
                10, 5, 10,
                5, 24,
                Arrays.asList(BiomeDictionary.Type.MESA)
        );

        generator_GOLD_ALTERNATE = new CaveBiomeGeneratorDeepOreDeposit(new GoldDeposit(),
                1060,
                96, 20, 96,
                10, 5, 10,
                5, 24,
                Arrays.asList(BiomeDictionary.Type.HOT)
        );

        generator_IRON = new CaveBiomeGeneratorIronOreDeposit(new IronDeposit(),
                620,
                96, 20, 96,
                10, 5, 10,
                32, 52,
                Arrays.asList(BiomeDictionary.Type.PLAINS)
        );

        generator_COAL = new CaveBiomeGeneratorIronOreDeposit(new CoalDeposit(),
                510,
                96, 20, 96,
                10, 5, 10,
                42, 62,
                Arrays.asList(BiomeDictionary.Type.FOREST)
        );

        generator_MERCURY = new CaveBiomeGeneratorNearSurface(new MercuryCaveBiome(),
                196,
                128, 20, 128,
                10, 5, 10,
                32, 58,
                Arrays.asList(BiomeDictionary.Type.SANDY)
        );

        generator_MERCURY_DEEP = new CaveBiomeGenerator(new DeepMercuryCaveBiome(),
                215,
                128, 20, 128,
                10, 5, 10,
                12, 38,
                Arrays.asList(BiomeDictionary.Type.SANDY)
        );

        generator_STONE_STAG_STAC = new CaveBiomeGeneratorStalgStacCave(new StoneStalgStacCaveBiome(),
                128,
                248, 20, 248,
                10, 5, 10,
                52, 68,
                Arrays.asList(BiomeDictionary.Type.FOREST)
        );

        generator_GRIMSTONE_STAG_STAC = new CaveBiomeGeneratorDeepOreDeposit(new GrimstoneStalgStacCaveBiome(),
                64,
                248, 20, 248,
                10, 5, 10,
                18, 24,
                Arrays.asList(BiomeDictionary.Type.FOREST)
        );

        generator_NULLSTONE_STAG_STAC = new CaveBiomeGeneratorDeepOreDeposit(new NullstoneStalgStacCaveBiome(),
                64,
                248, 20, 248,
                10, 5, 10,
                12, 24,
                Arrays.asList(BiomeDictionary.Type.FOREST)
        );
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        if (world.provider.dimensionId != 0) return;

        BlockPos[] sources_redstone = generator_REDSTONE.getSourcesInChunk(random, chunkX, chunkZ);
        BlockPos[] sources_gold = generator_GOLD.getSourcesInChunk(random, chunkX, chunkZ);
        BlockPos[] sources_gold_alternate = generator_GOLD_ALTERNATE.getSourcesInChunk(random, chunkX, chunkZ);

        BlockPos[] sources_iron = generator_IRON.getSourcesInChunk(random, chunkX, chunkZ);
        BlockPos[] sources_coal = generator_COAL.getSourcesInChunk(random, chunkX, chunkZ);

        BlockPos[] sources_stone_stag_stac = generator_STONE_STAG_STAC.getSourcesInChunk(random, chunkX, chunkZ);
        BlockPos[] sources_grimstone_stag_stac = generator_GRIMSTONE_STAG_STAC.getSourcesInChunk(random, chunkX, chunkZ);
        BlockPos[] sources_nullstone_stag_stac = generator_NULLSTONE_STAG_STAC.getSourcesInChunk(random, chunkX, chunkZ);

        BlockPos[] sources_mercury = generator_MERCURY.getSourcesInChunk(random, chunkX, chunkZ);
        BlockPos[] sources_mercury_deep = generator_MERCURY_DEEP.getSourcesInChunk(random, chunkX, chunkZ);

        if (ConfigsWorld.enableRedstoneOreDeposit) {
            for (BlockPos pos : sources_redstone) {
                if (generator_REDSTONE.isSourceValid(world, pos)) {
                    generator_REDSTONE.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }
        }

        if (ConfigsWorld.enableGoldOreDeposit) {
            for (BlockPos pos : sources_gold) {
                if (generator_GOLD.isSourceValid(world, pos)) {
                    generator_GOLD.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }

            for (BlockPos pos : sources_gold_alternate) {
                if (generator_GOLD_ALTERNATE.isSourceValid(world, pos)) {
                    generator_GOLD_ALTERNATE.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }
        }

        if (ConfigsWorld.enableIronOreDeposit) {
            for (BlockPos pos : sources_iron) {
                if (generator_IRON.isSourceValid(world, pos)) {
                    generator_IRON.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }
        }

        if (ConfigsWorld.enableCoalOreDeposit) {
            for (BlockPos pos : sources_coal) {
                if (generator_COAL.isSourceValid(world, pos)) {
                    generator_COAL.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }
        }

        if (ConfigsWorld.enableMercuryCavern) {
            for (BlockPos pos : sources_mercury) {
                if (generator_MERCURY.isSourceValid(world, pos)) {
                    generator_MERCURY.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }

            for (BlockPos pos : sources_mercury_deep) {
                if (generator_MERCURY_DEEP.isSourceValid(world, pos)) {
                    generator_MERCURY_DEEP.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }
        }

        if (ConfigsWorld.enableStagStacCavern) {
            for (BlockPos pos : sources_stone_stag_stac) {
                if (generator_STONE_STAG_STAC.isSourceValid(world, pos)) {
                    generator_STONE_STAG_STAC.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }

            for (BlockPos pos : sources_grimstone_stag_stac) {
                if (generator_GRIMSTONE_STAG_STAC.isSourceValid(world, pos)) {
                    generator_GRIMSTONE_STAG_STAC.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }

            for (BlockPos pos : sources_nullstone_stag_stac) {
                if (generator_NULLSTONE_STAG_STAC.isSourceValid(world, pos)) {
                    generator_NULLSTONE_STAG_STAC.generateChunkPart(pos, random, chunkX, chunkZ, world);
                }
            }
        }

    }
}
