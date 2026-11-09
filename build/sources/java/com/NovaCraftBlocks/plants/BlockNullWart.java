package com.NovaCraftBlocks.plants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockNullWart extends BlockBush
{
    @SideOnly(Side.CLIENT)
    private IIcon[] field_149883_a;

    public BlockNullWart()
    {
        this.setTickRandomly(true);
        float f = 0.5F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.setCreativeTab((CreativeTabs)null);
    }

    protected boolean canPlaceBlockOn(Block block)
    {
        return block == NovaCraftBlocks.nullstone;
    }

    public boolean canBlockStay(World world, int p_149718_2_, int p_149718_3_, int p_149718_4_)
    {
        return super.canBlockStay(world, p_149718_2_, p_149718_3_, p_149718_4_);
    }

    public void updateTick(World world, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random random)
    {
        int l = world.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);

        if (l < 3 && random.nextInt(10) == 0)
        {
            ++l;
            world.setBlockMetadataWithNotify(p_149674_2_, p_149674_3_, p_149674_4_, l, 2);
        }

        super.updateTick(world, p_149674_2_, p_149674_3_, p_149674_4_, random);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_2_ >= 3 ? this.field_149883_a[2] : (p_149691_2_ > 0 ? this.field_149883_a[1] : this.field_149883_a[0]);
    }

    public int getRenderType()
    {
        return 6;
    }

    @SuppressWarnings("unused")
    public void dropBlockAsItemWithChance(World world, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
    {
        super.dropBlockAsItemWithChance(world, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
        
        if (false && !world.isRemote)
        {
            int j1 = 1;

            if (p_149690_5_ >= 3)
            {
                j1 = 2 + world.rand.nextInt(3);

                if (p_149690_7_ > 0)
                {
                    j1 += world.rand.nextInt(p_149690_7_ + 1);
                }
            }

            for (int k1 = 0; k1 < j1; ++k1)
            {
                this.dropBlockAsItem(world, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(NovaCraftItems.nullwart));
            }
        }
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return null;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return NovaCraftItems.nullwart;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.field_149883_a = new IIcon[3];

        for (int i = 0; i < this.field_149883_a.length; ++i)
        {
            this.field_149883_a[i] = iconRegister.registerIcon(this.getTextureName() + "_stage_" + i);
        }
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        int count = 1;

        if (metadata >= 3)
        {
            count = 2 + world.rand.nextInt(3) + (fortune > 0 ? world.rand.nextInt(fortune + 1) : 0);
        }

        for (int i = 0; i < count; i++)
        {
            ret.add(new ItemStack(NovaCraftItems.nullwart));
        }

        return ret;
    }
}
