package com.NovaCraftBlocks.plants.end;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLacunaLog extends Block {
	
	//Credit to Et Futurum
	private IIcon[][] icon;
	
	public BlockLacunaLog() {
		super(Material.plants);
		this.icon = new IIcon[1][6];
		setHardness(2.5F);
		setStepSound(soundTypeWood);
		this.setResistance(2.5F);
		this.setHarvestLevel("axe", 2);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(final IIconRegister iconRegister) {
            this.icon[0][0] = iconRegister.registerIcon("nova_craft:lacuna_log");
            this.icon[0][1] = iconRegister.registerIcon("nova_craft:lacuna_log");
            this.icon[0][2] = iconRegister.registerIcon("nova_craft:lacuna_log");
            this.icon[0][3] = iconRegister.registerIcon("nova_craft:lacuna_log");
            this.icon[0][4] = iconRegister.registerIcon("nova_craft:lacuna_log");
            this.icon[0][5] = iconRegister.registerIcon("nova_craft:lacuna_log");

    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        if (side < 0 || side >= this.icon[meta].length) {
            side = 1;
        }
        return this.icon[meta][side];
    }

	//Come back to: Make it so the dragon can destroy the fruits if the new end is on
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		return !(entity instanceof EntityDragon);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		float down = canConnectTo(world, x, y-1, z) ? 0.0F : 0.1875F;
		float up = canConnectTo(world, x, y+1, z) ? 1.0F : 0.8125F;
		float west = canConnectTo(world, x-1, y, z) ? 0.0F : 0.1875F;
		float east = canConnectTo(world, x+1, y, z) ? 1.0F : 0.8125F;
		float north = canConnectTo(world, x, y, z-1) ? 0.0F : 0.1875F;
		float south = canConnectTo(world, x, y, z+1) ? 1.0F : 0.8125F;
		setBlockBounds(west, down, north, east, up, south);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		float down = canConnectTo(world, x, y-1, z) ? 0.0F : 0.1875F;
		float up = canConnectTo(world, x, y+1, z) ? 1.0F : 0.8125F;
		float west = canConnectTo(world, x-1, y, z) ? 0.0F : 0.1875F;
		float east = canConnectTo(world, x+1, y, z) ? 1.0F : 0.8125F;
		float north = canConnectTo(world, x, y, z-1) ? 0.0F : 0.1875F;
		float south = canConnectTo(world, x, y, z+1) ? 1.0F : 0.8125F;
		return AxisAlignedBB.getBoundingBox(x+west, y+down, z+north, x+east, y+up, z+south);
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		return this.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	public boolean canConnectTo(IBlockAccess world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return canPlaceOn(block) || block == NovaCraftBlocks.lacuna_fruit;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return super.canPlaceBlockAt(world, x, y, z) || this.canSurviveAt(world, x, y, z);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!this.canSurviveAt(world, x, y, z))
		{
			world.func_147480_a(x, y, z, true);
		}
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block p_149695_5_)
	{
		if (!this.canSurviveAt(world, x, y, z))
		{
			world.scheduleBlockUpdate(x, y, z, this, 1);
		}
	}

	public boolean canSurviveAt(World world, int x, int y, int z)
	{
		boolean flag = world.isAirBlock(x, y+1, z);
		boolean flag1 = world.isAirBlock(x, y-1, z);

		for (EnumFacing enumfacing : EnumFacing.values())
		{
			if(enumfacing.getFrontOffsetY() != 0) continue;
			
			Block block = world.getBlock(x+enumfacing.getFrontOffsetX(), y, z+enumfacing.getFrontOffsetZ());

			if (block == this)
			{
				if (!flag && !flag1)
				{
					return false;
				}

				Block block1 = world.getBlock(x+enumfacing.getFrontOffsetX(), y-1, z+enumfacing.getFrontOffsetZ());

				if (block1 == this || canPlaceOn(block1))
				{
					return true;
				}
			}
		}

		Block block2 = world.getBlock(x, y-1, z);
		return block2 == this || canPlaceOn(block2);
	}
	
	public static boolean canPlaceOn(Block block) {
		return block == Blocks.end_stone || block == NovaCraftBlocks.frontierslate;
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
	protected boolean canSilkHarvest() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIDs.ENDIUM_PLANT;
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);

        if (p_149734_5_.nextInt(2) == 0)
        {
            p_149734_1_.spawnParticle("townaura", (double)((float)p_149734_2_ + p_149734_5_.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
        }
    }

}
