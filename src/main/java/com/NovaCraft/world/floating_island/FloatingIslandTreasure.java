package com.NovaCraft.world.floating_island;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class FloatingIslandTreasure extends WorldGenAbstractTree
{

    public FloatingIslandTreasure(final Block block, final int height, final boolean branch) {
        super(true);
    }

    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {

        world.setBlock(i + 1, j + 0, k + 0, NovaCraftBlocks.etherstone_brick_slab, 5, 2);
        world.setBlock(i + 2, j + 0, k + 0, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 0, k + 0, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 0, j + 0, k + 1, NovaCraftBlocks.etherstone_brick_slab, 5, 2);
        world.setBlock(i + 1, j + 0, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j + 0, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 0, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 1, j + 0, k + 2, NovaCraftBlocks.etherstone_brick_slab, 5, 2);
        world.setBlock(i + 2, j + 0, k + 2, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 0, k + 2, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j + 1, k + 0, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 1, k + 1, NovaCraftBlocks.etherstone_bricks, 0, 2);
        world.setBlock(i + 2, j + 1, k + 2, NovaCraftBlocks.cracked_etherstone_bricks, 0, 2);
        world.setBlock(i + 3, j + 2, k + 1, NovaCraftBlocks.etherstone_brick_slab, 5, 2);

        world.setBlock(i + 2, j + 1, k + 1, Blocks.chest, 4, 2);
        TileEntityChest chest = (TileEntityChest) world.getTileEntity(i + 2, j + 1, k + 1);

        for (int slot = 0; slot < 3 + random.nextInt(20); slot++) {
            chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), this.getChestLoot(random));
        }

        return true;
    }

    private ItemStack getChestLoot(Random random) {
        int item = random.nextInt(15);
        switch (item) {
            case 0:
                return new ItemStack(Items.iron_ingot, random.nextInt(4) + 3);
            case 1:
                return new ItemStack(NovaCraftBlocks.cobbled_etherstone, random.nextInt(8) + 3);
            case 2:
                return new ItemStack(NovaCraftItems.aether_shard);
            case 3:
                return new ItemStack(NovaCraftItems.vanite_ingot, random.nextInt(5) + 4);
            case 4:
                return new ItemStack(NovaCraftItems.iridium_nugget, 0, random.nextInt(4) + 3);
            case 5:
                return new ItemStack(NovaCraftItems.copartz_shard, random.nextInt(3) + 1);
            case 6:
                return new ItemStack(NovaCraftItems.tsavorokite_shard, random.nextInt(2) + 1);
            case 7:
                return new ItemStack(NovaCraftItems.larimar_shard, random.nextInt(2) + 1);
            default: {
                return new ItemStack(Items.gold_ingot, random.nextInt(9) + 3);
            }
        }
    }
}
