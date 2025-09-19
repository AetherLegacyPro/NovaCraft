package com.NovaCraftBlocks.ores.piles;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDiamondPile extends Block
{
	public BlockDiamondPile()
    {
        super(Material.iron);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        this.setTickRandomly(true);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.func_150154_b(0);
        this.setHardness(1.3F);
		this.setResistance(2.3F);
        this.setHarvestLevel("shovel", 2);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("nova_craft:diamond_pile");
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        int l = p_149668_1_.getBlockMetadata(p_149668_2_, p_149668_3_, p_149668_4_) & 7;
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox((double)p_149668_2_ + this.minX, (double)p_149668_3_ + this.minY, (double)p_149668_4_ + this.minZ, (double)p_149668_2_ + this.maxX, (float)p_149668_3_ + (float)l * f, (double)p_149668_4_ + this.maxZ);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public void setBlockBoundsForItemRender()
    {
        this.func_150154_b(0);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        this.func_150154_b(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));
    }

    protected void func_150154_b(int p_150154_1_)
    {
        int j = p_150154_1_ & 7;
        float f = (float)(2 * (1 + j)) / 16.0F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }

    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        Block block = p_149742_1_.getBlock(p_149742_2_, p_149742_3_ - 1, p_149742_4_);
        return block != Blocks.ice && block != Blocks.packed_ice ? (block.isLeaves(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_) ? true : (block == this && (p_149742_1_.getBlockMetadata(p_149742_2_, p_149742_3_ - 1, p_149742_4_) & 7) == 7 ? true : block.isOpaqueCube())) : false;
    }

    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        this.func_150155_m(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
    }

    private boolean func_150155_m(World p_150155_1_, int p_150155_2_, int p_150155_3_, int p_150155_4_)
    {
        if (!this.canPlaceBlockAt(p_150155_1_, p_150155_2_, p_150155_3_, p_150155_4_))
        {
            p_150155_1_.setBlockToAir(p_150155_2_, p_150155_3_, p_150155_4_);
            return false;
        }
        else
        {
            return true;
        }
    }

    public void harvestBlock(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_)
    {
        super.harvestBlock(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
        p_149636_1_.setBlockToAir(p_149636_3_, p_149636_4_, p_149636_5_);
    }
    
    @Override
   	public int damageDropped(int meta) {
   		return 0;
   	}

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    	return NovaCraftItems.diamond_nugget;
    }

    public int quantityDropped(World world, EntityPlayer p_149636_2_, int x, int y, int z, Random random)
    {
    	int meta = world.getBlockMetadata(x, y, z);
    	switch (meta) {
		case 1: 
			return 1 + random.nextInt(1);
		case 2: 
			return 2 + random.nextInt(2);
		case 3: 
			return 2 + random.nextInt(3);
		case 4: 
			return 3 + random.nextInt(3);   		
    	case 5: 
    		return 4 + random.nextInt(3);  		
    	case 6: 
    		return 5 + random.nextInt(3);   		
    	case 7: 
    		return 5 + random.nextInt(4);
    	
    	default: 
    		return 1;
    	}
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        return p_149646_5_ == 1 ? true : super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
    }
    
    public int quantityDropped(int meta, int fortune, Random random)
    {
        return (meta & 7) + 1;
    }

    public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        return meta >= 7 ? false : blockMaterial.isReplaceable();
    }
}
