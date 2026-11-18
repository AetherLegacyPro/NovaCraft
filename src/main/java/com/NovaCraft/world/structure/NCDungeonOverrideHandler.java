package com.NovaCraft.world.structure;

import java.util.Random;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

//Some dungeons are replaced with the NovaCraft variants and overhaul are more common
public class NCDungeonOverrideHandler {
        private final WorldGenerator vanillaDungeon = new WorldGenDungeons();
        private final WorldGenerator traditionalDungeon = new NovaCraftTraditionalDungeonGen();
        private final WorldGenerator advancedDungeon = new NovaCraftAdvancedTraditionalDungeonGen();

        @SubscribeEvent(priority = EventPriority.LOWEST)
        public void onPopulate(PopulateChunkEvent.Populate event) {
            if (event.world.isRemote || event.world.provider.dimensionId != 0 || event.type != PopulateChunkEvent.Populate.EventType.DUNGEON) {
                return;
            }

            if (event.getResult() == Event.Result.DENY) {
                return;
            }

            event.setResult(Event.Result.DENY);
            World world = event.world;
            Random random = event.rand;

            int chunkOriginX = event.chunkX * 16;
            int chunkOriginZ = event.chunkZ * 16;
            for (int attempt = 0; attempt < 12; ++attempt) {
                int x = chunkOriginX + random.nextInt(16) + 8;
                int y = random.nextInt(128);
                int z = chunkOriginZ + random.nextInt(16) + 8;

                int radiusX = random.nextInt(2) + 2;
                int radiusZ = random.nextInt(2) + 2;

                if (!this.isValidDungeonLocation(world, x, y, z, radiusX, radiusZ)) {
                    continue;
                }

                int dungeon_chance = random.nextInt(100);
                WorldGenerator generator;

                if (dungeon_chance < 10) {
                    generator = this.advancedDungeon;
                }
                else if (dungeon_chance < 40) {
                    generator = this.traditionalDungeon;
                }
                else {
                    generator = this.vanillaDungeon;
                }

                generator.generate(world, random, x, y, z);
            }
        }

        //Vanilla Dungeon check for space; used to be an issue for the NovaCraft Dungeons in oceans and in mountains
        private boolean isValidDungeonLocation(World world, int centerX, int centerY, int centerZ, int radiusX, int radiusZ) {
            if (centerY < 1 || centerY + 4 > 255) {
                return false;
            }

            int minimumX = centerX - radiusX - 1;
            int maximumX = centerX + radiusX + 1;
            int minimumZ = centerZ - radiusZ - 1;
            int maximumZ = centerZ + radiusZ + 1;
            int entranceCount = 0;

            for (int x = minimumX; x <= maximumX; ++x) {
                for (int y = centerY - 1; y <= centerY + 4; ++y) {
                    for (int z = minimumZ; z <= maximumZ; ++z) {
                        Material material = world.getBlock(x, y, z).getMaterial();

                        if (y == centerY - 1 && !material.isSolid()) {
                            return false;
                        }

                        if (y == centerY + 4 && !material.isSolid()) {
                            return false;
                        }

                        boolean wallPosition = x == minimumX || x == maximumX || z == minimumZ || z == maximumZ;
                        if (wallPosition && y == centerY && world.isAirBlock(x, y, z) && world.isAirBlock(x, y + 1, z)) {
                            ++entranceCount;
                        }
                    }
                }
            }

            return entranceCount >= 1 && entranceCount <= 5;
        }
}
