package com.NovaCraft;

import net.minecraft.entity.EnumCreatureAttribute;

public final class BaneOfTheUnknownHooks {
    private BaneOfTheUnknownHooks() {
    }

    public static boolean isValidTarget(Object attribute) {
        return attribute == EnumCreatureAttribute.ARTHROPOD || attribute == EnumCreatureAttribute.UNDEFINED || attribute == null;
    }
}
