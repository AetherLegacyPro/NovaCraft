package com.NovaCraftBlocks.plants.nether;

import java.util.Random;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockFlamingPitcherTop extends BlockBush {

	public AxisAlignedBB FLOWER_AABB = AxisAlignedBB.getBoundingBox(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D);

	public BlockFlamingPitcherTop() {
		this.setHardness(0.0F);
		this.setTickRandomly(true);
		this.setStepSound(soundTypeGrass);
		this.setCreativeTab(null);
		this.setBlockBounds(0.5F - 0.2F, 0.0F, 0.5F - 0.2F, 0.5F + 0.2F, 0.2F * 3.0F, 0.5F + 0.2F);
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		return soil == NovaCraftBlocks.flaming_pitcher_bottom;
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		return (soil != null && this.canPlaceBlockAt(world, x, y, z));
	}
	
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int l) {
		world.setBlock(x, y - 1, z, Blocks.air);
	}
	
	public int quantityDropped(final Random random) {
        return 1 + random.nextInt(3);
    }
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return NovaCraftItems.flaming_pitcher_petal;
	}

	public int getRenderType() {    
		return 6;
	  }
	
	protected boolean canSilkHarvest() {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random random)
    {
        super.randomDisplayTick(world, p_149734_2_, p_149734_3_, p_149734_4_, random);

        if (random.nextInt(2) == 0)
        {
			world.spawnParticle("smoke", (double)((float)p_149734_2_ + random.nextFloat()), (double)((float)p_149734_3_ + 0.6F), (double)((float)p_149734_4_ + random.nextFloat()), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", (double)((float)p_149734_2_ + random.nextFloat()), (double)((float)p_149734_3_ + 0.6F), (double)((float)p_149734_4_ + random.nextFloat()), 0.0D, 0.0D, 0.0D);

        }
    }
	
}
