package com.NovaCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

//Lava Pools cannot generate above y=32
public final class LakeGenerationHooks {
    private LakeGenerationHooks() {
    }

    public static boolean shouldCancelLake(Object worldObject, Object blockObject, int finalOriginY) {
        World world = (World)worldObject;
        Block lakeBlock = (Block)blockObject;

        return world.provider.dimensionId == 0 && lakeBlock.getMaterial() == Material.lava && finalOriginY + 3 > 32;
    }
}
