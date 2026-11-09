package com.NovaCraft.world.caves.cold;

import com.NovaCraft.world.caves.BlockPos;
import com.NovaCraft.world.caves.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class UndergroundBiomeNearSurface {

    public double dungeonChance;

    public void fill(World world, int x, int y, int z, CaveBiomeGeneratorNearSurface.UndergroundBiomeGenerationContext context) {
        Block block = world.getBlock(x, y, z);
        if (block.getBlockHardness(world, x, y, z) == -1 || world.canBlockSeeTheSky(x, y, z)) return;

        if (isFloor(world, x, y, z, block)) {
            context.floorList.add(new BlockPos(x, y, z));
            fillFloor(world, x, y, z, block);
        } else if (isCeiling(world, x, y, z, block)) {
            context.ceilingList.add(new BlockPos(x, y, z));
            fillCeiling(world, x, y, z, block);
        } else if (isWall(world, x, y, z, block)) {
            context.wallMap.put(new BlockPos(x, y, z), getBorderSide(world, new BlockPos(x, y, z)));
            fillWall(world, x, y, z, block);
        } else if (block instanceof BlockStone) {
            context.insideList.add(new BlockPos(x, y, z));
            fillInside(world, x, y, z, block);
        }
    }

    public abstract void fillFloor(World world, int x, int y, int z, Block block);

    public abstract void fillCeiling(World world, int x, int y, int z, Block block);

    public abstract void fillWall(World world, int x, int y, int z, Block block);

    public abstract void fillInside(World world, int x, int y, int z, Block block);

    public void finalFloorPass(World world, int x, int y, int z) {
        // NO-OP
    }

    public void finalCeilingPass(World world, int x, int y, int z) {
        // NO-OP
    }

    public void finalWallPass(World world, int x, int y, int z) {
        // NO-OP
    }

    @SuppressWarnings({ "unused", "EmptyMethod" })
    public void finalInsidePass(World world, int x, int y, int z) {
        // NO-OP
    }

    public boolean isValidBiome(BiomeGenBase biome) {
        return true;
    }

    public boolean hasDungeon() {
        return false;
    }

    public float getDungeonChance() {
        return 0.05F;
    }

    public void spawnDungeon(WorldServer world, BlockPos pos, EnumFacing face) {
        // NO-OP
    }

    public boolean isFloor(World world, int x, int y, int z, Block block) {
        if (!block.isNormalCube() || !block.isOpaqueCube()) return false;

        return (world.isAirBlock(x, y + 1, z) || (world.getBlock(x, y + 1, z)
                .isReplaceable(world, x, y + 1, z))
                && world.getBlock(x, y + 1, z)
                .getMaterial() == Material.rock);
    }

    public boolean isCeiling(World world, int x, int y, int z, Block block) {
        if (!block.isNormalCube() || !block.isOpaqueCube()) return false;

        return world.isAirBlock(x, y - 1, z) || world.getBlock(x, y - 1, z).isReplaceable(world, x, y - 1, z);
    }

    public boolean isWall(World world, int x, int y, int z, Block block) {
        if (!block.isNormalCube() || !block.isOpaqueCube() || !(block instanceof BlockStone)) return false;

        return isBorder(world, x, y, z);
    }

    public EnumFacing getBorderSide(World world, BlockPos pos) {
        Block block = world.getBlock(pos.x, pos.y, pos.z);
        for (EnumFacing facing : Constants.HORIZONTALS) {
            BlockPos offsetPos = pos.offset(facing);
            Block blockAt = world.getBlock(offsetPos.x, offsetPos.y, offsetPos.z);

            if (block != blockAt && world.isAirBlock(offsetPos.x, offsetPos.y, offsetPos.z)
                    || blockAt.isReplaceable(world, offsetPos.x, offsetPos.y, offsetPos.z)) return facing;
        }

        return null;
    }

    public boolean isBorder(World world, int x, int y, int z) {
        return getBorderSide(world, new BlockPos(x, y, z)) != null;
    }

}
