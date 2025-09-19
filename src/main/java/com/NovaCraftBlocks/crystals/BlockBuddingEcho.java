package com.NovaCraftBlocks.crystals;

import java.util.Random;

import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBuddingEcho extends BlockEcho {
	
	private IIcon[] icon;
	
	public BlockBuddingEcho() {
		this.icon = new IIcon[1];
		this.setHardness(5F);
		this.setResistance(13);
		this.setStepSound(ModSounds.soundCrystal);
		setTickRandomly(true);
	}
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:budding_echo_block");
    }
	
	public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        return this.icon[meta];
    }
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
	if (world.provider.dimensionId == 1) {
		if (rand.nextInt(130) == 1) {
			EnumFacing facing = EnumFacing.getFront(rand.nextInt(EnumFacing.values().length));
		Block block = world.getBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ());
		int meta = world.getBlockMetadata(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ());
		
			if(block instanceof BlockEchoCluster && meta % 6 == facing.ordinal()) {
				if(meta < 6) {
					world.setBlockMetadataWithNotify(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ(), meta + 6, 3);
				} else if(block == NovaCraftBlocks.echo_cluster_1) {
					world.setBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ(), NovaCraftBlocks.echo_cluster_2, meta - 6, 3);
				}
			} else if(canGrowIn(block)) {
				world.setBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ(), NovaCraftBlocks.echo_cluster_1, facing.ordinal(), 3);
				}
			}
		}
	}

	private boolean canGrowIn(Block state) {
		return state.getMaterial() == Material.air || state.getMaterial() == Material.water;
	}
	
	protected boolean canSilkHarvest() {
        return false;
    }
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
		Random random = new Random();

		if (this.getItemDropped(p_149690_5_, random, p_149690_7_) != Item.getItemFromBlock(this)) {
			int amount = 0;	
			
				amount = MathHelper.getRandomIntegerInRange(random, 0, 2);
			

			return amount;
		}

		return 0;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return true;
	}
}
