package com.NovaCraft.entity.misc;

public enum EnumCrystalSlimeType {

    IRON(), GOLD(), LAPIS(), EMERALD(), DIAMOND(), VANITE(), IRIDIUM(), CRYSTAL();

    EnumCrystalSlimeType() {}

    public int getId() {
        return this.ordinal();
    }

    private static final EnumCrystalSlimeType[] VALUES = values();

    public static EnumCrystalSlimeType get(int id) {
        return VALUES[id];
    }
}