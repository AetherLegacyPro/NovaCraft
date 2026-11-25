package com.NovaCraft;

import java.util.ArrayList;
import java.util.List;
import com.NovaCraft.entity.misc.EntityNotImportant;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.ChunkEvent;

public class NovaCraftSpecialClientEvents {
    //They can only attempt to spawn on days that end in 0, 3, or 7
    private boolean isSpecialDay(World world) {
        long day = world.getWorldTime() / 24000L;
        long lastDigit = day % 10L;
        return lastDigit == 0L || lastDigit == 3L || lastDigit == 7L;
    }

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.world.isRemote || !(event.entity instanceof EntityNotImportant)) {
            return;
        }

        if (event.entity.isDead || event.world.provider.dimensionId != 0 || !this.isSpecialDay(event.world)) {
            event.setCanceled(true);
            event.entity.setDead();
            return;
        }

        int unknownCount = 0;
        for (Object object : event.world.loadedEntityList) {
            if (object instanceof EntityNotImportant && object != event.entity && !((EntityNotImportant)object).isDead) {
                ++unknownCount;
            }
        }

        int playerCount = event.world.playerEntities.size();
        if (unknownCount >= playerCount) {
            event.setCanceled(true);
            event.entity.setDead();
        }
    }

    @SubscribeEvent
    public void onChunkUnload(ChunkEvent.Unload event) {
        if (event.world.isRemote) {
            return;
        }

        for (List section : event.getChunk().entityLists) {
            for (Object object : section) {
                if (object instanceof EntityNotImportant) {
                    ((EntityNotImportant)object).setDead();
                }
            }
        }
    }

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.world.isRemote || event.world.getTotalWorldTime() % 100 != 0L) {
            return;
        }

        World world = event.world;
        List<EntityNotImportant> unknowns = new ArrayList<>();
        for (Object object : world.loadedEntityList) {
            if (object instanceof EntityNotImportant && !((EntityNotImportant)object).isDead) {
                unknowns.add((EntityNotImportant)object);
            }
        }

        int maximum = world.provider.dimensionId == 0 && this.isSpecialDay(world) ? world.playerEntities.size() : 0;
        for (int i = maximum; i < unknowns.size(); ++i) {
            unknowns.get(i).setDead();
        }

        if (maximum == 0 || unknowns.size() >= maximum) {
            return;
        }

        if (world.rand.nextInt(120) != 0) { //spawn chance
            return;
        }

        EntityPlayer player = (EntityPlayer)world.playerEntities.get(world.rand.nextInt(world.playerEntities.size()));
        this.trySpawnunknown(world, player);
    }

    private void trySpawnunknown(World world, EntityPlayer player) {
        if (!player.isEntityAlive()) {
            return;
        }

        for (int attempt = 0; attempt < 12; ++attempt) { //Attempts to spawn
            double angle = world.rand.nextDouble() * Math.PI * 2.0D;
            double distance = 40.0D + world.rand.nextDouble() * (64.0D - 40.0D); //max - min distance it can spawn
            int x = MathHelper.floor_double(player.posX + Math.cos(angle) * distance);
            int z = MathHelper.floor_double(player.posZ + Math.sin(angle) * distance);

            if (!world.blockExists(x, 64, z)) {
                continue;
            }

            int y = world.getHeightValue(x, z);
            if (y < 1 || y >= 252) {
                continue;
            }

            if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)) {
                continue;
            }

            EntityNotImportant unknown = new EntityNotImportant(world);
            unknown.setLocationAndAngles(x + 0.5D, y, z + 0.5D, world.rand.nextFloat() * 360.0F, 0.0F);

            if (!this.isAreaLoaded(world, unknown)) {
                continue;
            }

            if (!unknown.getCanSpawnHere()) {
                continue;
            }

            if (!world.getCollidingBoundingBoxes(unknown, unknown.boundingBox).isEmpty() || world.isAnyLiquid(unknown.boundingBox) || !world.checkNoEntityCollision(unknown.boundingBox)) {
                continue;
            }

            if (world.spawnEntityInWorld(unknown)) {
                return;
            }
        }
    }

    private boolean isAreaLoaded(World world, EntityNotImportant unknown) {
        int minimumX = MathHelper.floor_double(unknown.boundingBox.minX);
        int maximumX = MathHelper.floor_double(unknown.boundingBox.maxX);
        int minimumZ = MathHelper.floor_double(unknown.boundingBox.minZ);
        int maximumZ = MathHelper.floor_double(unknown.boundingBox.maxZ);

        int y = MathHelper.floor_double(unknown.boundingBox.minY);
        for (int x = minimumX; x <= maximumX; ++x) {
            for (int z = minimumZ; z <= maximumZ; ++z) {
                if (!world.blockExists(x, y, z)) {
                    return false;
                }
            }
        }

        return true;
    }
}
