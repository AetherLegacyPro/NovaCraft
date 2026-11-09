package com.NovaCraft;

import com.NovaCraft.entity.EntityOutsider;
import com.NovaCraft.entity.EntityOutsiderEye;
import com.NovaCraft.entity.hardmode.*;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class HardmodeSpawnHandler {

    @SubscribeEvent
    public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
        if (event.world.isRemote) {
            return;
        }

        if (!this.isHardmodeMob(event.entityLiving)) {
            return;
        }

        if (!Hardmode.get(event.world).areHardmodeMobsUnlocked()) {
            event.setResult(Result.DENY);
        }
    }

    private boolean isHardmodeMob(EntityLivingBase entity) {
        return entity instanceof EntityHardmodeCreeper || entity instanceof EntityHardmodeSpider || entity instanceof EntityHardmodeZombie
                || entity instanceof EntityHardmodeSkeleton || entity instanceof EntityHardmodeSlime || entity instanceof EntityHardmodeMagmaCube
                || entity instanceof EntityHardmodeGhast || entity instanceof EntityOutsiderEye || entity instanceof EntityOutsider;
    }
}