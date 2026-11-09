package com.NovaCraft.entity.misc;

public enum EnumGiantFrogType {

    GREEN(), BROWN(), YELLOW(), LIGHT_BLUE();

    EnumGiantFrogType() {}

    public int getId() {
        return this.ordinal();
    }

    private static final EnumGiantFrogType[] VALUES = values();

    public static EnumGiantFrogType get(int id) {
        return VALUES[id];
    }
}