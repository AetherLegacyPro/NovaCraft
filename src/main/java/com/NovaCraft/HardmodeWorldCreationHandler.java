package com.NovaCraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;

public class HardmodeWorldCreationHandler {

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        if (event.world.isRemote || event.world.provider.dimensionId != 0) {
            return;
        }

        Boolean startingHardmode = HardmodeWorldCreationSettings.consume();
        if (startingHardmode == null) {
            return;
        }

        if (startingHardmode.booleanValue()) {
            Hardmode data = Hardmode.get(event.world);
            data.enableStartingHardmode(event.world);
            //System.out.println("[NovaCraft] Starting Hardmode applied: " + "stats=" + data.getHardmode() + ", mobsUnlocked=" + data.areHardmodeMobsUnlocked());
        }
    }
}