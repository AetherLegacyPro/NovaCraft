package com.NovaCraft.entity.misc;

public enum EnumRavagerType {

    BASE(), BOSS();

    EnumRavagerType() {

    }

    public int getId() {
        return this.ordinal();
    }

    public static EnumRavagerType get(int id) {
        return values()[id];
    }
}
