package com.NovaCraft.entity.misc;

public enum EnumCreakingType {

    OAK(), BIRCH(), SPRUCE(), JUNGLE(), DARK_OAK(), LUMINANT();

	EnumCreakingType() {

    }

    public int getId() {
        return this.ordinal();
    }

    public static EnumCreakingType get(int id) {
        return values()[id];
    }
}
