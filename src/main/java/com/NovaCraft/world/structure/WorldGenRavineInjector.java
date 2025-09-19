package com.NovaCraft.world.structure;

import java.lang.reflect.Field;

import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import com.NovaCraft.world.structure.NCRavineWorldGen;

public class WorldGenRavineInjector {

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        World world = event.world;

        if (!(world instanceof WorldServer)) return;

        ChunkProviderServer chunkProvider = ((WorldServer) world).theChunkProviderServer;
        if (!(chunkProvider.currentChunkProvider instanceof ChunkProviderGenerate)) return;

        try {
            ChunkProviderGenerate gen = (ChunkProviderGenerate) chunkProvider.currentChunkProvider;

            for (Field field : ChunkProviderGenerate.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(gen);

                if (value instanceof MapGenRavine) {
                	field.set(gen, new NCRavineWorldGen());
                	return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







