package com.NovaCraft;

import com.NovaCraft.config.Configs;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.MapStorage;

public class Hardmode extends WorldSavedData {
    private static final String DATA_NAME = "HardmodeData";

    private boolean hardmode;
    private boolean hardmodeMobsUnlocked;

    public Hardmode()
    {
        super(DATA_NAME);
    }

    public Hardmode(String name)
    {
        super(name);
    }

    public boolean getHardmode() {
        return Configs.enableHardmode && this.hardmode;
    }

    public boolean areHardmodeMobsUnlocked() {
        return Configs.enableHardmode && this.hardmodeMobsUnlocked;
    }

    public void enableStartingHardmode(World world) {
        if (world.isRemote) {
            return;
        }

        Configs.enableHardmodeAndSave();
        Hardmode data = Hardmode.get(world);
        data.hardmode = true;
        data.hardmodeMobsUnlocked = false;
        data.markDirty();
    }

    public void triggerEvent(World world) {
        if (world.isRemote || !Configs.enableHardmode) {
            return;
        }

        Hardmode data = get(world);
        data.hardmode = true;
        data.hardmodeMobsUnlocked = true;
        data.markDirty();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        this.hardmode = nbt.getBoolean("Hardmode");
        this.hardmodeMobsUnlocked = nbt.hasKey("HardmodeMobsUnlocked") ? nbt.getBoolean("HardmodeMobsUnlocked") : this.hardmode;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setBoolean("Hardmode", this.hardmode);
        nbt.setBoolean("HardmodeMobsUnlocked", this.hardmodeMobsUnlocked);
    }

    public static Hardmode get(World world) {
        if (world.isRemote) {
            throw new IllegalStateException("Attempted to access Hardmode data on client!");
        }

        MinecraftServer server = MinecraftServer.getServer();
        WorldServer overworld = server == null ? null : server.worldServerForDimension(0);

        World storageWorld = overworld;
        if (storageWorld == null && world.provider.dimensionId == 0) {
            storageWorld = world;
        }

        if (storageWorld == null) {
            throw new IllegalStateException("Overworld unavailable for global Hardmode data.");
        }

        MapStorage storage = storageWorld.mapStorage;
        Hardmode data = (Hardmode)storage.loadData(Hardmode.class, DATA_NAME);
        if (data == null) {
            data = new Hardmode();
            storage.setData(DATA_NAME, data);
        }

        return data;
    }
}