package com.NovaCraft.world.sculkshaft;

import java.lang.reflect.Field;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class WorldGenSculkedMineshaftInjector {

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        if (!(event.world instanceof WorldServer)) return;

        WorldServer world = (WorldServer) event.world;
        ChunkProviderServer cps = world.theChunkProviderServer;

        if (!(cps.currentChunkProvider instanceof ChunkProviderGenerate)) return;

        ChunkProviderGenerate gen = (ChunkProviderGenerate) cps.currentChunkProvider;

        try {
            for (Field field : ChunkProviderGenerate.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(gen);

                if (value instanceof MapGenMineshaft) {
                    field.set(gen, new MapGenSculkMineshaft());
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
