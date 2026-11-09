package com.NovaCraft.entity.misc;

public enum EnumGolemType {

    COPARTZ(), LARIMAR(), TSAVOROKITE(), YTTRLINISTE(), AMETHYST(), AETHER(), NULLSTONE();

    EnumGolemType() {}

    public int getId() {
        return this.ordinal();
    }

    private static final EnumGolemType[] VALUES = values();

    public static EnumGolemType get(int id) {
        return VALUES[id];
    }
}