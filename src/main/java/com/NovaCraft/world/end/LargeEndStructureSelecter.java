package com.NovaCraft.world.end;

import com.NovaCraft.world.end.ancient_base.AncientEndBaseGen;
import com.NovaCraft.world.end.ruined_end_city.RuinedEndCityGen;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import java.util.Random;

public class LargeEndStructureSelecter implements IWorldGenerator {

    private final RuinedEndCityGen ruinedEndCity = new RuinedEndCityGen();
    private final AncientEndBaseGen ancientEndBase = new AncientEndBaseGen();

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        if (world.provider.dimensionId != 1) {
            return;
        }

        if (rand.nextInt(750) != 25) {
            return;
        }

        int x = chunkX * 16;
        int z = chunkZ * 16;

        if (rand.nextBoolean()) {
            ruinedEndCity.generateEnd(world, rand, x, z);
        } else {
            ancientEndBase.generateEnd(world, rand, x, z);
        }
    }
}