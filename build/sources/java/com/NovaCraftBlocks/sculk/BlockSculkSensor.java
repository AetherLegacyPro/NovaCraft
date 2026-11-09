package com.NovaCraftBlocks.sculk;

import java.util.Random;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockMushroom;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSculkSensor extends BlockMushroom {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockSculkSensor() {
		super();
		this.setHardness(1);
		this.setResistance(1);
		this.setStepSound(ModSounds.soundSculkVein);
		this.setHarvestLevel("axe", 0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:sculk_sensor");
		iconFace = iconRegister.registerIcon("nova_craft:sculk_sensor");
		iconTop = iconRegister.registerIcon("nova_craft:sculk_sensor");
	}

    protected boolean canPlaceBlockOn(Block block)
    {
        return (block == NovaCraftBlocks.grimstone || block == NovaCraftBlocks.nullstone || block == NovaCraftBlocks.sculk_block || 
        		block == NovaCraftBlocks.sculk_deepslate || block == NovaCraftBlocks.sculk_grimstone || block == NovaCraftBlocks.sculk_stone);
    }

    public boolean canBlockStay(World world, int p_149718_2_, int p_149718_3_, int p_149718_4_)
    {
        return super.canBlockStay(world, p_149718_2_, p_149718_3_, p_149718_4_);
    }
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z)
	{
	   return true;
	}
	
	public int getRenderType() {    
		return 1;
	  }
	
	public int quantityDropped(final Random random) {
        return 1;
    }
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return null;
    }
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

}
