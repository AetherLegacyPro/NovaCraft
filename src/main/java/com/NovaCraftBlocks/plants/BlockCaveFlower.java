package com.NovaCraftBlocks.plants;

import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockMushroom;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCaveFlower extends BlockMushroom {

    public BlockCaveFlower() {
        super();
        this.setHardness(0.1F);
        this.setResistance(0.1F);
        this.setStepSound(soundTypeGrass);
        this.setHarvestLevel("axe", 0);
        this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.3F, 0.7F);
    }

    public int getRenderType() {
        return 1;
    }

    protected boolean canPlaceBlockOn(Block block)
    {
        return (block == NovaCraftBlocks.moss_block || block == NovaCraftBlocks.arctic_moss_block || block == Blocks.dirt);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
        return null;
    }

}
