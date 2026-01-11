package com.NovaCraft.world.stronghold;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;

public class StrongholdGenHandler {

    @SubscribeEvent
    public void onInitMapGen(InitMapGenEvent event) {
        if (event.type == InitMapGenEvent.EventType.STRONGHOLD) {
            event.newGen = new EmptyStrongholdGenerator();
            System.out.println("Strongholds disabled via InitMapGenEvent");
        }
    }
}
