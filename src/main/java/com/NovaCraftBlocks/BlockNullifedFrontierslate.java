package com.NovaCraftBlocks;

import com.NovaCraft.entity.misc.EntityVoidLightningBolt;
import com.NovaCraft.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import java.util.Random;

public class BlockNullifedFrontierslate extends Block {

    public BlockNullifedFrontierslate() {
        super(Material.rock);
        this.setHardness(8);
        this.setResistance(15);
        this.setStepSound(ModSounds.soundFrontierslate);
        this.setHarvestLevel("pickaxe", 3);
        this.setTickRandomly(true);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (world.isRemote) {
            return;
        }

        EntityPlayer nearbyPlayer = world.getClosestPlayer(x + 0.5D, y + 0.5D, z + 0.5D, 128.0D);
        if (nearbyPlayer == null) {
            return;
        }

        if (world.provider.dimensionId != 1) {
            return;
        }

        int targetY = this.findLightningTargetY(world, x, y - 1, z);
        if (targetY <= 0) {
            return;
        }

        world.spawnEntityInWorld(new EntityVoidLightningBolt(world, x, y - 1.0D, z));
    }

    private int findLightningTargetY(World world, int x, int startY, int z) {
        if (startY > 255) {
            startY = 255;
        }

        for (int scanY = startY; scanY > 0; scanY--) {

            Block block = world.getBlock(x, scanY, z);
            if (block == Blocks.air || block == NovaCraftBlocks.frontierslate || block == NovaCraftBlocks.frontierslate_bricks) {
                continue;
            }

            return scanY;
        }

        return -1;
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int p_149664_5_) {
        int lightning_chance = (int)(Math.random() * 2);
        if (!world.isRemote && lightning_chance == 0) {
            world.spawnEntityInWorld(new EntityVoidLightningBolt(world, x, y, z));
        }
    }

    public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return Item.getItemFromBlock(NovaCraftBlocks.frontierslate);
    }

}
