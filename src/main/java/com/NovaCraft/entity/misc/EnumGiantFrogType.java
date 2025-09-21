package com.NovaCraft.entity.misc;


public enum EnumGiantFrogType {

    GREEN(), BROWN(), YELLOW(), LIGHT_BLUE();

    EnumGiantFrogType() {

    }

    public int getId() {
        return this.ordinal();
    }

    public static EnumGiantFrogType get(int id) {
        return values()[id];
    }
}
