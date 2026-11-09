package com.NovaCraft.world.sculkshaft;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;

public class WorldGenSculkedMineshaftInjector {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onInitMapGen(InitMapGenEvent event) {
        if (event.type == InitMapGenEvent.EventType.MINESHAFT) {
            boolean efrMesa = event.newGen != null && event.newGen.getClass().getName().equals(MapGenSculkMineshaft.EFR_MESA_GENERATOR);
            event.newGen = new MapGenSculkMineshaft(efrMesa);
        }
    }
}