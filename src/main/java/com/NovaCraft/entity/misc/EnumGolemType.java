package com.NovaCraft.entity.misc;

public enum EnumGolemType {

    COPARTZ(), LARIMAR(), TSAVOROKITE(), YTTRLINISTE(), AMETHYST(), AETHER(), NULLSTONE();

	EnumGolemType() {

    }

    public int getId() {
        return this.ordinal();
    }

    public static EnumGolemType get(int id) {
        return values()[id];
    }
}
