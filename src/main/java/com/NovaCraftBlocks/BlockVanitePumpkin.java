package com.NovaCraftBlocks;

import com.NovaCraft.entity.EntityCorruptist;
import com.NovaCraft.entity.EntityRavager;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.sounds.ModSounds;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockVanitePumpkin extends BlockDirectional
{
    private boolean field_149985_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_149984_b;
    @SideOnly(Side.CLIENT)
    private IIcon field_149986_M;

    protected BlockVanitePumpkin(boolean p_i45419_1_)
    {
        super(Material.gourd);
        this.setTickRandomly(true);
        this.field_149985_a = p_i45419_1_;
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.setStepSound(ModSounds.soundNullstone);
        this.setHarvestLevel("pickaxe", 3);
        this.setHardness(7.5F);
        this.setResistance(12F);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_149984_b : (p_149691_1_ == 0 ? this.field_149984_b : (p_149691_2_ == 2 && p_149691_1_ == 2 ? this.field_149986_M : (p_149691_2_ == 3 && p_149691_1_ == 5 ? this.field_149986_M : (p_149691_2_ == 0 && p_149691_1_ == 3 ? this.field_149986_M : (p_149691_2_ == 1 && p_149691_1_ == 4 ? this.field_149986_M : this.blockIcon)))));
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        super.onBlockAdded(world, i, j, k);

        if (world.getBlock(i, j - 1, k) == NovaCraftBlocks.block_of_vanite && world.getBlock(i + 2, j, k) == Blocks.iron_block
                && world.getBlock(i - 2, j, k) == Blocks.iron_block && world.getBlock(i + 2, j + 1, k - 1) == Blocks.iron_block
                && world.getBlock(i + 2, j + 1, k - 2) == Blocks.iron_block && world.getBlock(i - 2, j + 1, k - 1) == Blocks.iron_block
                && world.getBlock(i - 2, j + 1, k - 2) == Blocks.iron_block

                && world.getBlock(i, j - 3, k + 3) == Blocks.gold_block && world.getBlock(i, j - 4, k + 3) == Blocks.gold_block
                && world.getBlock(i - 1, j - 3, k + 3) == Blocks.gold_block && world.getBlock(i - 1, j - 4, k + 3) == Blocks.gold_block
                && world.getBlock(i + 1, j - 3, k + 3) == Blocks.gold_block && world.getBlock(i + 1, j - 4, k + 3) == Blocks.gold_block
                && world.getBlock(i - 1, j - 3, k + 4) == Blocks.gold_block && world.getBlock(i - 1, j - 4, k + 4) == Blocks.gold_block
                && world.getBlock(i, j - 3, k + 4) == NovaCraftBlocks.block_of_vanite && world.getBlock(i, j - 4, k + 4) == NovaCraftBlocks.block_of_vanite
                && world.getBlock(i + 1, j - 3, k + 4) == Blocks.gold_block && world.getBlock(i + 1, j - 4, k + 4) == Blocks.gold_block
                && world.getBlock(i - 1, j - 3, k + 5) == Blocks.gold_block && world.getBlock(i - 1, j - 4, k + 5) == Blocks.gold_block
                && world.getBlock(i, j - 3, k + 5) == Blocks.gold_block && world.getBlock(i, j - 4, k + 5) == Blocks.gold_block
                && world.getBlock(i + 1, j - 3, k + 5) == Blocks.gold_block && world.getBlock(i + 1, j - 4, k + 5) == Blocks.gold_block

                //Nullstone
                && world.getBlock(i + 1, j, k) == NovaCraftBlocks.nullstone_bricks && world.getBlock(i - 1, j, k) == NovaCraftBlocks.nullstone_bricks
                && world.getBlock(i + 1, j - 1, k) == NovaCraftBlocks.nullstone_bricks && world.getBlock(i - 1, j - 1, k) == NovaCraftBlocks.nullstone_bricks
                && world.getBlock(i + 1, j - 2, k) == NovaCraftBlocks.nullstone_bricks && world.getBlock(i - 1, j - 2, k) == NovaCraftBlocks.nullstone_bricks
                && world.getBlock(i, j - 2, k) == NovaCraftBlocks.nullstone_bricks && world.getBlock(i, j - 2, k - 1) == NovaCraftBlocks.nullstone_bricks
                && world.getBlock(i, j - 3, k - 1) == NovaCraftBlocks.nullstone_bricks && world.getBlock(i, j - 2, k + 1) == NovaCraftBlocks.nullstone_bricks
                && world.getBlock(i - 1, j - 2, k + 1) == NovaCraftBlocks.nullstone_bricks && world.getBlock(i + 1, j - 2, k + 1) == NovaCraftBlocks.nullstone_bricks
                && world.getBlock(i, j - 3, k + 1) == NovaCraftBlocks.nullstone_bricks && world.getBlock(i - 1, j - 3, k + 1) == NovaCraftBlocks.nullstone_bricks
                && world.getBlock(i + 1, j - 3, k + 1) == NovaCraftBlocks.nullstone_bricks

                //Grimstone
                && world.getBlock(i + 2, j - 2, k + 1) == NovaCraftBlocks.grimstone_bricks && world.getBlock(i - 2, j - 2, k + 1) == NovaCraftBlocks.grimstone_bricks
                && world.getBlock(i + 3, j - 2, k + 1) == NovaCraftBlocks.grimstone_bricks && world.getBlock(i - 3, j - 2, k + 1) == NovaCraftBlocks.grimstone_bricks
                && world.getBlock(i + 2, j - 2, k + 2) == NovaCraftBlocks.grimstone_bricks && world.getBlock(i - 2, j - 2, k + 2) == NovaCraftBlocks.grimstone_bricks
                && world.getBlock(i + 3, j - 2, k + 2) == NovaCraftBlocks.grimstone_bricks && world.getBlock(i - 3, j - 2, k + 2) == NovaCraftBlocks.grimstone_bricks
                && world.getBlock(i + 2, j - 2, k + 6) == NovaCraftBlocks.grimstone_bricks && world.getBlock(i - 2, j - 2, k + 6) == NovaCraftBlocks.grimstone_bricks
                && world.getBlock(i + 3, j - 2, k + 6) == NovaCraftBlocks.grimstone_bricks && world.getBlock(i - 3, j - 2, k + 6) == NovaCraftBlocks.grimstone_bricks
                && world.getBlock(i + 2, j - 2, k + 7) == NovaCraftBlocks.grimstone_bricks && world.getBlock(i - 2, j - 2, k + 7) == NovaCraftBlocks.grimstone_bricks
                && world.getBlock(i + 3, j - 2, k + 7) == NovaCraftBlocks.grimstone_bricks && world.getBlock(i - 3, j - 2, k + 7) == NovaCraftBlocks.grimstone_bricks

                //StoneBricks
                && world.getBlock(i + 2, j - 3, k + 1) == Blocks.stonebrick && world.getBlock(i - 2, j - 3, k + 1) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 3, k + 1) == Blocks.stonebrick && world.getBlock(i - 3, j - 3, k + 1) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 3, k + 2) == Blocks.stonebrick && world.getBlock(i - 2, j - 3, k + 2) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 3, k + 2) == Blocks.stonebrick && world.getBlock(i - 3, j - 3, k + 2) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 4, k + 1) == Blocks.stonebrick && world.getBlock(i - 2, j - 4, k + 1) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 4, k + 1) == Blocks.stonebrick && world.getBlock(i - 3, j - 4, k + 1) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 4, k + 2) == Blocks.stonebrick && world.getBlock(i - 2, j - 4, k + 2) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 4, k + 2) == Blocks.stonebrick && world.getBlock(i - 3, j - 4, k + 2) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 5, k + 1) == Blocks.stonebrick && world.getBlock(i - 2, j - 5, k + 1) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 5, k + 1) == Blocks.stonebrick && world.getBlock(i - 3, j - 5, k + 1) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 5, k + 2) == Blocks.stonebrick && world.getBlock(i - 2, j - 5, k + 2) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 5, k + 2) == Blocks.stonebrick && world.getBlock(i - 3, j - 5, k + 2) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 3, k + 6) == Blocks.stonebrick && world.getBlock(i - 2, j - 3, k + 6) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 3, k + 6) == Blocks.stonebrick && world.getBlock(i - 3, j - 3, k + 6) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 3, k + 7) == Blocks.stonebrick && world.getBlock(i - 2, j - 3, k + 7) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 3, k + 7) == Blocks.stonebrick && world.getBlock(i - 3, j - 3, k + 7) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 4, k + 6) == Blocks.stonebrick && world.getBlock(i - 2, j - 4, k + 6) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 4, k + 6) == Blocks.stonebrick && world.getBlock(i - 3, j - 4, k + 6) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 4, k + 7) == Blocks.stonebrick && world.getBlock(i - 2, j - 4, k + 7) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 4, k + 7) == Blocks.stonebrick && world.getBlock(i - 3, j - 4, k + 7) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 5, k + 6) == Blocks.stonebrick && world.getBlock(i - 2, j - 5, k + 6) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 5, k + 6) == Blocks.stonebrick && world.getBlock(i - 3, j - 5, k + 6) == Blocks.stonebrick
                && world.getBlock(i + 2, j - 5, k + 7) == Blocks.stonebrick && world.getBlock(i - 2, j - 5, k + 7) == Blocks.stonebrick
                && world.getBlock(i + 3, j - 5, k + 7) == Blocks.stonebrick && world.getBlock(i - 3, j - 5, k + 7) == Blocks.stonebrick
                && world.getBlock(i - 2, j - 3, k + 3) == Blocks.stonebrick && world.getBlock(i + 2, j - 3, k + 3) == Blocks.stonebrick
                && world.getBlock(i - 2, j - 4, k + 3) == Blocks.stonebrick && world.getBlock(i + 2, j - 4, k + 3) == Blocks.stonebrick
                && world.getBlock(i - 2, j - 3, k + 5) == Blocks.stonebrick && world.getBlock(i + 2, j - 3, k + 5) == Blocks.stonebrick
                && world.getBlock(i - 2, j - 4, k + 5) == Blocks.stonebrick && world.getBlock(i + 2, j - 4, k + 5) == Blocks.stonebrick
        ) {
            world.setBlock(i, j, k, Blocks.air, 0, 2);
            world.setBlock(i, j - 1, k, Blocks.air, 0, 2);
            world.setBlock(i + 2, j, k, Blocks.air, 0, 2);
            world.setBlock(i - 2, j, k, Blocks.air, 0, 2);
            world.setBlock(i + 2, j + 1, k - 1, Blocks.air, 0, 2);
            world.setBlock(i + 2, j + 1, k - 2, Blocks.air, 0, 2);
            world.setBlock(i - 2, j + 1, k - 1, Blocks.air, 0, 2);
            world.setBlock(i - 2, j + 1, k - 2, Blocks.air, 0, 2);
            world.setBlock(i, j - 3, k + 3, Blocks.air, 0, 2);
            world.setBlock(i, j - 4, k + 3, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 3, k + 3, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 4, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 3, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 4, k + 3, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 3, k + 4, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 4, k + 4, Blocks.air, 0, 2);
            world.setBlock(i, j - 3, k + 4, Blocks.air, 0, 2);
            world.setBlock(i, j - 4, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 3, k + 4, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 4, k + 4, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 3, k + 5, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 4, k + 5, Blocks.air, 0, 2);
            world.setBlock(i, j - 3, k + 5, Blocks.air, 0, 2);
            world.setBlock(i, j - 4, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 3, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 4, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 1, j, k, Blocks.air, 0, 2);
            world.setBlock(i - 1, j, k, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 1, k, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 1, k, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 2, k, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 2, k, Blocks.air, 0, 2);
            world.setBlock(i, j - 2, k, Blocks.air, 0, 2);
            world.setBlock(i, j - 2, k - 1, Blocks.air, 0, 2);
            world.setBlock(i, j - 3, k - 1, Blocks.air, 0, 2);
            world.setBlock(i, j - 2, k + 1, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 2, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 2, k + 1, Blocks.air, 0, 2);
            world.setBlock(i, j - 3, k + 1, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 3, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 3, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 2, k + 1, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 2, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 2, k + 1, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 2, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 2, k + 2, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 2, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 2, k + 2, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 2, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 2, k + 6, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 2, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 2, k + 6, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 2, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 2, k + 7, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 2, k + 7, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 2, k + 7, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 2, k + 7, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 3, k + 1, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 3, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 3, k + 1, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 3, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 3, k + 2, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 3, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 3, k + 2, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 3, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 4, k + 1, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 4, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 4, k + 1, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 4, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 4, k + 2, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 4, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 4, k + 2, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 4, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 5, k + 1, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 5, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 5, k + 1, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 5, k + 1, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 5, k + 2, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 5, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 5, k + 2, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 5, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 3, k + 6, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 3, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 3, k + 6, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 3, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 3, k + 7, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 3, k + 7, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 3, k + 7, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 3, k + 7, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 4, k + 6, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 4, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 4, k + 6, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 4, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 4, k + 7, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 4, k + 7, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 4, k + 7, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 4, k + 7, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 5, k + 6, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 5, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 5, k + 6, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 5, k + 6, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 5, k + 7, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 5, k + 7, Blocks.air, 0, 2);
            world.setBlock(i + 3, j - 5, k + 7, Blocks.air, 0, 2);
            world.setBlock(i - 3, j - 5, k + 7, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 3, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 3, k + 3, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 4, k + 3, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 4, k + 3, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 3, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 3, k + 5, Blocks.air, 0, 2);
            world.setBlock(i - 2, j - 4, k + 5, Blocks.air, 0, 2);
            world.setBlock(i + 2, j - 4, k + 5, Blocks.air, 0, 2);
            world.setBlock(i, j - 3, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 3, k + 2, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 3, k + 2, Blocks.air, 0, 2);
            world.setBlock(i, j - 4, k + 2, Blocks.air, 0, 2);
            world.setBlock(i + 1, j - 4, k + 2, Blocks.air, 0, 2);
            world.setBlock(i - 1, j - 4, k + 2, Blocks.air, 0, 2);

            if (!world.isRemote) {
                final EntityRavager ravager = new EntityRavager(world);
                ravager.setLocationAndAngles(i, j + 2, k, 0.0f, 0.0f);
                world.spawnEntityInWorld(ravager);
                ravager.setType(1);
            }

        }

    }

    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return  p_149742_1_.getBlock(p_149742_2_, p_149742_3_, p_149742_4_).isReplaceable(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_);
    }

    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, l, 2);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_149986_M = p_149651_1_.registerIcon("nova_craft:vanite_pumpkin_face");
        this.field_149984_b = p_149651_1_.registerIcon("nova_craft:vanite_pumpkin_top");
        this.blockIcon = p_149651_1_.registerIcon("nova_craft:vanite_pumpkin_side");
    }
}
