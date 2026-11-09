package com.NovaCraftBlocks.plants;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.BlockVine;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockBloomedGlowVines extends BlockVine implements IShearable {

    public BlockBloomedGlowVines()
    {
        super();
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.setStepSound(ModSounds.soundMoss);
        this.setHardness(0.15f);
        this.setLightOpacity(0);
        this.setLightLevel(0.55F);
        this.setTickRandomly(true);
    }

    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public int getRenderType()
    {
        return 20;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(int p_149741_1_)
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
        return p_149720_1_.getBiomeGenForCoords(p_149720_2_, p_149720_4_).getBiomeFoliageColor(p_149720_2_, p_149720_3_, p_149720_4_);
    }

    public int onBlockPlaced(World world, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
    {
        byte b0 = 0;

        switch (p_149660_5_)
        {
            case 2:
                b0 = 1;
                break;
            case 3:
                b0 = 4;
                break;
            case 4:
                b0 = 8;
                break;
            case 5:
                b0 = 2;
        }

        return b0 != 0 ? b0 : p_149660_9_;
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return null;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public void harvestBlock(World world, EntityPlayer entityPlayer, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_)
    {
        {
            super.harvestBlock(world, entityPlayer, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
        }
    }

    @Override
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest) {
        int meta = world.getBlockMetadata(x, y, z);
        boolean removed = super.removedByPlayer(world, player, x, y, z, willHarvest);

        if (!world.isRemote && removed) {
            world.setBlock(x, y, z, NovaCraftBlocks.glow_vines, meta, 3);

            this.dropBlockAsItem(world, x, y, z, new ItemStack(NovaCraftItems.cave_berry, 1));
        }

        return removed;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1));
        return ret;
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }
}
