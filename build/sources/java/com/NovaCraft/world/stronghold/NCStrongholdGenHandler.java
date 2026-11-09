package com.NovaCraft.world.stronghold;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;

public class NCStrongholdGenHandler {

    @SubscribeEvent
    public void onInitMapGen(InitMapGenEvent event)
    {
        if (event.type == InitMapGenEvent.EventType.STRONGHOLD)
        {
            event.newGen = new MapGenNCStronghold();
        }
    }
}

