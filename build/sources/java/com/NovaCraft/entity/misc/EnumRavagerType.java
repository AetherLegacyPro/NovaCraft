package com.NovaCraft.entity.misc;

public enum EnumRavagerType {

    BASE(), BOSS();

    EnumRavagerType() {}

    public int getId() {
        return this.ordinal();
    }

    private static final EnumRavagerType[] VALUES = values();

    public static EnumRavagerType get(int id) {
        return VALUES[id];
    }
}