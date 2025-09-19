package com.NovaCraft.world;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

import com.NovaCraft.config.Configs;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PopulateChunkEventHandler
{
    @SubscribeEvent
    public void onPopulateChunkEvent(PopulateChunkEvent.Post event)
    {
        if (Configs.disableEmerald == true || Configs.disableMonsterEgg == true)
        {
            World world = event.world;
            int endX = (event.chunkX * 16) + 16;
            int endZ = (event.chunkZ * 16) + 16;

            // Get the highest possibly existing block location
            int maxY = event.chunkProvider.provideChunk(event.chunkX, event.chunkZ).getTopFilledSegment() + 15;

            for (int x = event.chunkX * 16; x < endX; ++x)
            {
                for (int z = event.chunkZ * 16; z < endZ; ++z)
                {
                    for (int y = 0; y < maxY; ++y)
                    {
                        if ((Configs.disableEmerald == true && world.getBlock(x, y, z) == Blocks.emerald_ore)
                            || (Configs.disableMonsterEgg == true && world.getBlock(x, y, z) == Blocks.monster_egg))
                        {
                            world.setBlock(x, y, z, Blocks.stone, 0, 2);
                        }
                    }
                }
            }
        }
    }
}
