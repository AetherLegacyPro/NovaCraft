package com.NovaCraft.entity.misc;

public enum EnumFrogType {

    GREEN(), BROWN(), YELLOW(), LIGHT_BLUE(), TREE_1(), TREE_2(), TREE_3(), POSION_1(), POSION_2(), POSION_3(), POSION_4();

	EnumFrogType() {

    }

    public int getId() {
        return this.ordinal();
    }

    public static EnumFrogType get(int id) {
        return values()[id];
    }
}
