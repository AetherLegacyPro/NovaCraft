package com.NovaCraftBlocks.stalactites;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockMassiveStoneStalagmiteTop extends Block {

    public BlockMassiveStoneStalagmiteTop() {
        super(Material.rock);
        this.setHardness(0.3F);
        this.setResistance(0.3F);
        this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.8F, 1.0F, 0.8F);
        this.setStepSound(soundTypeStone);
        this.setHarvestLevel("pickaxe", 0);
        this.setTickRandomly(true);
    }

    protected boolean canPlaceBlockOn(Block block) {
        return (block == Blocks.stone || block == NovaCraftBlocks.massive_stone_stalagmite_bottom);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    @Override
    public Item getItemDropped(int meta, Random rand, int fortune) {
        return NovaCraftItems.massive_stone_stalagmite;
    }

    @Override
    public int quantityDropped(Random rand) {
        return 1;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.checkAndDropBlock(world, x, y, z);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock) {
        super.onNeighborBlockChange(world, x, y, z, neighborBlock);
        this.checkAndDropBlock(world, x, y, z);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        this.checkAndDropBlock(world, x, y, z);
        super.updateTick(world, x, y, z, rand);
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        if (y <= 0) {
            return false;
        }

        Block blockBelow = world.getBlock(x, y - 1, z);

        return blockBelow == NovaCraftBlocks.massive_stone_stalagmite_bottom || world.isSideSolid(x, y - 1, z, ForgeDirection.UP);
    }

    private void checkAndDropBlock(World world, int x, int y, int z) {
        if (!this.canBlockStay(world, x, y, z)) {
            if (!world.isRemote) {
                this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                world.setBlockToAir(x, y, z);
            }
        }
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int l) {
        if (world.getBlock(x, y - 1, z) == NovaCraftBlocks.massive_stone_stalagmite_bottom) {
            world.setBlock(x, y - 1, z, Blocks.air);

        }
    }

    public void onBlockDestroyedByExplosion(final World world, final int x, final int y, final int z, final Explosion explosion) {
        if (world.getBlock(x, y - 1, z) == NovaCraftBlocks.massive_stone_stalagmite_bottom) {
            world.setBlock(x, y - 1, z, Blocks.air);
        }
    }
}
