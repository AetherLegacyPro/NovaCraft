package com.NovaCraft.world.structure;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;

public class WorldGenRavineInjector {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onInitMapGen(InitMapGenEvent event) {
        if (event.type == InitMapGenEvent.EventType.RAVINE) {
            event.newGen = new NCRavineWorldGen();
        }
    }
}