package com.NovaCraft;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

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
        this.hardmode = true;
        markDirty();
        world.mapStorage.saveAllData();
        System.out.println("Hardmode activated and saved to world data!");
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
        Hardmode data = (Hardmode) world.mapStorage.loadData(Hardmode.class, DATA_NAME);

        if (data == null) {
            data = new Hardmode();
            world.mapStorage.setData(DATA_NAME, data);
        }

        return data;
    }
}
