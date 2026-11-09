package com.NovaCraft.world.caves.ore_deposit.middle;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BasicUndergroundBiomeIronOreDeposit extends UndergroundBiomeIronOreDeposit {

    public Block floorBlock, ceilingBlock, wallBlock;
    public int floorMeta, ceilingMeta, wallMeta;
    public final boolean mimicInside;

    public BasicUndergroundBiomeIronOreDeposit(Block floorBlock, Block ceilingBlock, Block wallBlock) {
        this(floorBlock, ceilingBlock, wallBlock, 0, 0, 0, false);
    }

    public BasicUndergroundBiomeIronOreDeposit(Block floorBlock, Block ceilingBlock, Block wallBlock, int floorMeta, int ceilingMeta, int wallMeta) {
        this(floorBlock, ceilingBlock, wallBlock, floorMeta, ceilingMeta, wallMeta, false);
    }

    public BasicUndergroundBiomeIronOreDeposit(Block floorBlock, Block ceilingBlock, Block wallBlock, int floorMeta, int ceilingMeta, int wallMeta, boolean mimicInside) {
        this.floorBlock = floorBlock;
        this.ceilingBlock = ceilingBlock;
        this.wallBlock = wallBlock;
        this.mimicInside = mimicInside;
    }

    @Override
    public void fillFloor(World world, int x, int y, int z, Block block) {
        if (floorBlock != null) world.setBlock(x, y, z, floorBlock, 0, 2);
    }

    @Override
    public void fillCeiling(World world, int x, int y, int z, Block block) {
        if (ceilingBlock != null) world.setBlock(x, y, z, ceilingBlock, 0, 2);
    }

    @Override
    public void fillWall(World world, int x, int y, int z, Block block) {
        if (wallBlock != null) world.setBlock(x, y, z, wallBlock, 0, 2);
    }

    @Override
    public void fillInside(World world, int x, int y, int z, Block block) {
        if (mimicInside) fillWall(world, x, y, z, block);
    }

}
