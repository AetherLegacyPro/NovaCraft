package com.NovaCraftBlocks.ores.vanilla;

import java.util.Random;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockNullstoneRedstone extends Block {
    private boolean field_150187_a;

    public BlockNullstoneRedstone(boolean bool) {
        super(Material.rock);
        this.setHardness(7);
        this.setStepSound(ModSounds.soundNullstone);
		this.setResistance(14);

        if (bool) {
            this.setTickRandomly(true);
        }

        this.field_150187_a = bool;
    }

    public int tickRate(World world) {
        return 60;
    }

    public void onBlockClicked(World world, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer entityPlayer) {
        this.func_150185_e(world, p_149699_2_, p_149699_3_, p_149699_4_);
        super.onBlockClicked(world, p_149699_2_, p_149699_3_, p_149699_4_, entityPlayer);
    }

    public void onEntityWalking(World world, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity entity) {
        this.func_150185_e(world, p_149724_2_, p_149724_3_, p_149724_4_);
        super.onEntityWalking(world, p_149724_2_, p_149724_3_, p_149724_4_, entity);
    }

    public boolean onBlockActivated(World world, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer entityPlayer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        this.func_150185_e(world, p_149727_2_, p_149727_3_, p_149727_4_);
        return super.onBlockActivated(world, p_149727_2_, p_149727_3_, p_149727_4_, entityPlayer, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }

    private void func_150185_e(World world, int p_150185_2_, int p_150185_3_, int p_150185_4_) {
        this.func_150186_m(world, p_150185_2_, p_150185_3_, p_150185_4_);

        if (this == NovaCraftBlocks.nullstone_redstone) {
            world.setBlock(p_150185_2_, p_150185_3_, p_150185_4_,NovaCraftBlocks.lit_nullstone_redstone);
        }
    }

    public void updateTick(World world, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random random) {
        if (this == NovaCraftBlocks.lit_nullstone_redstone) {
            world.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, NovaCraftBlocks.nullstone_redstone);
        }
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Items.redstone;
    }

    public int quantityDroppedWithBonus(int p_149679_1_, Random random) {
        return this.quantityDropped(random) + random.nextInt(p_149679_1_ + 1);
    }

    public int quantityDropped(Random p_149745_1_) {
        return 1 + p_149745_1_.nextInt(2);
    }

    public void dropBlockAsItemWithChance(World world, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
        super.dropBlockAsItemWithChance(world, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
    }

    private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess world, int meta, int fortune) {
        if (this.getItemDropped(meta, rand, fortune) != Item.getItemFromBlock(this)) {
            return 1 + rand.nextInt(5);
        }
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random random) {
        if (this.field_150187_a) {
            this.func_150186_m(world, p_149734_2_, p_149734_3_, p_149734_4_);
        }
    }

    private void func_150186_m(World world, int p_150186_2_, int p_150186_3_, int p_150186_4_) {
        Random random = world.rand;
        double d0 = 0.0625D;

        for (int l = 0; l < 12; ++l) {
            double d1 = (double)((float)p_150186_2_ + random.nextFloat());
            double d2 = (double)((float)p_150186_3_ + random.nextFloat());
            double d3 = (double)((float)p_150186_4_ + random.nextFloat());

            if (l == 0 && !world.getBlock(p_150186_2_, p_150186_3_ + 1, p_150186_4_).isOpaqueCube()) {
                d2 = (double)(p_150186_3_ + 1) + d0;
            }

            if (l == 1 && !world.getBlock(p_150186_2_, p_150186_3_ - 1, p_150186_4_).isOpaqueCube()) {
                d2 = (double)(p_150186_3_ + 0) - d0;
            }

            if (l == 2 && !world.getBlock(p_150186_2_, p_150186_3_, p_150186_4_ + 1).isOpaqueCube()) {
                d3 = (double)(p_150186_4_ + 1) + d0;
            }

            if (l == 3 && !world.getBlock(p_150186_2_, p_150186_3_, p_150186_4_ - 1).isOpaqueCube()) {
                d3 = (double)(p_150186_4_ + 0) - d0;
            }

            if (l == 4 && !world.getBlock(p_150186_2_ + 1, p_150186_3_, p_150186_4_).isOpaqueCube()) {
                d1 = (double)(p_150186_2_ + 1) + d0;
            }

            if (l == 5 && !world.getBlock(p_150186_2_ - 1, p_150186_3_, p_150186_4_).isOpaqueCube()) {
                d1 = (double)(p_150186_2_ + 0) - d0;
            }

            if (d1 < (double)p_150186_2_ || d1 > (double)(p_150186_2_ + 1) || d2 < 0.0D || d2 > (double)(p_150186_3_ + 1) || d3 < (double)p_150186_4_ || d3 > (double)(p_150186_4_ + 1)) {
                world.spawnParticle("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    protected ItemStack createStackedBlock(int item) {
        return new ItemStack(NovaCraftBlocks.nullstone_redstone);
    }
}