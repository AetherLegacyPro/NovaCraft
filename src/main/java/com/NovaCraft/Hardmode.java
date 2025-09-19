package com.NovaCraft;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;

public class Hardmode extends WorldSavedData {

    private static final String DATA_NAME = "HardmodeData";
    private boolean hardmode = false;

    public Hardmode() {
        super(DATA_NAME);
    }

    public Hardmode(String name) {
        super(name);
    }

    public boolean getHardmode() {
        return hardmode;
    }

    public void triggerEvent(World world) {
        if (!world.isRemote) {
            this.hardmode = true;
            markDirty();
            world.mapStorage.setData(DATA_NAME, this);
            world.mapStorage.saveAllData();
            System.out.println("Hardmode activated and saved to world data!");
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        this.hardmode = nbt.getBoolean("Hardmode");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setBoolean("Hardmode", hardmode);
    }

    public static Hardmode get(World world) {
        if (world.isRemote) {
            throw new IllegalStateException("Attempted to access Hardmode data on client!");
        }

        MapStorage storage = world.mapStorage;
        Hardmode data = (Hardmode) storage.loadData(Hardmode.class, DATA_NAME);

        if (data == null) {
            data = new Hardmode();
            storage.setData(DATA_NAME, data);
            System.out.println("Created new Hardmode world data.");
        } else {
            System.out.println("Loaded existing Hardmode world data.");
        }

        return data;
    }
}