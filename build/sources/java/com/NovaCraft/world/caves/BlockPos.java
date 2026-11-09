package com.NovaCraft.world.caves;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;

public class BlockPos {

    /** An immutable block pos with zero as all coordinates. */
    public static final BlockPos ORIGIN = new BlockPos(0, 0, 0);

    /** X coordinate */
    public final int x;

    /** Y coordinate */
    public final int y;

    /** Z coordinate */
    public final int z;

    public BlockPos(int xIn, int yIn, int zIn) {
        this.x = xIn;
        this.y = yIn;
        this.z = zIn;
    }

    public BlockPos(double xIn, double yIn, double zIn) {
        this((int) xIn, (int) yIn, (int) zIn);
    }

    public BlockPos(Entity source) {
        this(source.posX, source.posY, source.posZ);
    }

    /**
     * Add the given coordinates to the coordinates of this BlockPos
     */
    public BlockPos add(int xIn, int yIn, int zIn) {
        return xIn == 0 && yIn == 0 && zIn == 0 ? this : new BlockPos(this.x + xIn, this.y + yIn, z + zIn);
    }

    /**
     * Offset this BlockPos 1 block up
     */
    public BlockPos up() {
        return this.up(1);
    }

    /**
     * Offset this BlockPos n blocks up
     */
    public BlockPos up(int n) {
        return this.offset(EnumFacing.UP, n);
    }

    /**
     * Offset this BlockPos 1 block down
     */
    public BlockPos down() {
        return this.down(1);
    }

    /**
     * Offset this BlockPos n blocks down
     */
    public BlockPos down(int n) {
        return this.offset(EnumFacing.DOWN, n);
    }

    /**
     * Offset this BlockPos 1 block in northern direction
     */
    public BlockPos north() {
        return this.north(1);
    }

    /**
     * Offset this BlockPos n blocks in northern direction
     */
    public BlockPos north(int n) {
        return this.offset(EnumFacing.NORTH, n);
    }

    /**
     * Offset this BlockPos 1 block in southern direction
     */
    public BlockPos south() {
        return this.south(1);
    }

    /**
     * Offset this BlockPos n blocks in southern direction
     */
    public BlockPos south(int n) {
        return this.offset(EnumFacing.SOUTH, n);
    }

    /**
     * Offset this BlockPos 1 block in western direction
     */
    public BlockPos west() {
        return this.west(1);
    }

    /**
     * Offset this BlockPos n blocks in western direction
     */
    public BlockPos west(int n) {
        return this.offset(EnumFacing.WEST, n);
    }

    /**
     * Offset this BlockPos 1 block in eastern direction
     */
    public BlockPos east() {
        return this.east(1);
    }

    /**
     * Offset this BlockPos n blocks in eastern direction
     */
    public BlockPos east(int n) {
        return this.offset(EnumFacing.EAST, n);
    }

    /**
     * Offset this BlockPos 1 block in the given direction
     */
    public BlockPos offset(EnumFacing facing) {
        return this.offset(facing, 1);
    }

    /**
     * Offsets this BlockPos n blocks in the given direction
     */
    public BlockPos offset(EnumFacing facing, int n) {
        return n == 0 ? this
                : new BlockPos(
                this.x + facing.getFrontOffsetX() * n,
                this.y + facing.getFrontOffsetY() * n,
                this.z + facing.getFrontOffsetZ() * n);
    }
}
