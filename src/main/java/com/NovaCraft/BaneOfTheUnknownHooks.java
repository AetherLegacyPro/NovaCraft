package com.NovaCraft;

import net.minecraft.entity.EnumCreatureAttribute;

public final class BaneOfTheUnknownHooks {
    private BaneOfTheUnknownHooks() {
    }

    public static boolean isValidTarget(EnumCreatureAttribute attribute) {
        return attribute == EnumCreatureAttribute.ARTHROPOD || attribute == EnumCreatureAttribute.UNDEFINED || attribute == null;
    }
}
