package com.NovaCraft.world.sculkshaft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;

public class WorldGenSculkedMineshaftInjector {

    @SubscribeEvent
    public void onInitMapGen(InitMapGenEvent event) {
        if (event.type == InitMapGenEvent.EventType.MINESHAFT) {
            event.newGen = new MapGenSculkMineshaft();
        }
    }
}
