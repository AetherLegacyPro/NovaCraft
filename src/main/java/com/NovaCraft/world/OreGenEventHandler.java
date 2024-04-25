package com.NovaCraft.world;

import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType;

import com.NovaCraft.config.Configs;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class OreGenEventHandler
{
    @SubscribeEvent
    public void onOreGenMinable(OreGenEvent.GenerateMinable event)
    {

        if (event.type == EventType.CUSTOM)
        {
            if (Configs.disableCustom == true)
            {
                event.setResult(Event.Result.DENY);
            }

            return;
        }

        // Disable ALL vanilla generation, including dirt and gravel pockets.
        if (Configs.disableRegularVanillaGen == true)
        {
            event.setResult(Event.Result.DENY);
            return;
        }

        // Individual ore types
        switch(event.type)
        {
            case DIRT:
                if (Configs.disableDirt == true)
                {
                    event.setResult(Event.Result.DENY);
                }
                break;
            case GRAVEL:
                if (Configs.disableGravel == true)
                {
                    event.setResult(Event.Result.DENY);
                }
                break;
            case COAL:
                if (Configs.disableCoal == true)
                {
                    event.setResult(Event.Result.DENY);
                }
                break;
            case DIAMOND:
                if (Configs.disableDiamond == true)
                {
                    event.setResult(Event.Result.DENY);
                }
                break;
            case GOLD:
                if (Configs.disableGold == true)
                {
                    event.setResult(Event.Result.DENY);
                }
                break;
            case IRON:
                if (Configs.disableIron == true)
                {
                    event.setResult(Event.Result.DENY);
                }
                break;
            case LAPIS:
                if (Configs.disableLapis == true)
                {
                    event.setResult(Event.Result.DENY);
                }
                break;
            case REDSTONE:
                if (Configs.disableRedstone == true)
                {
                    event.setResult(Event.Result.DENY);
                }
                break;
            default:
        }
    }
}
