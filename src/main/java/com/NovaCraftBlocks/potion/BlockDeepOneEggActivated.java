package com.NovaCraftBlocks.potion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.TileEntity.TileEntityDeepOneEggActivated;
import com.NovaCraft.entity.DeepoidDragon.EntityDeepoidDragon;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDeepOneEggActivated extends BlockContainer
{

    public BlockDeepOneEggActivated()
    {
        super(Material.dragonEgg);
        this.setBlockUnbreakable();
		this.setResistance(600000000);
        this.setStepSound(soundTypePiston);
        this.setLightLevel(0.825F);
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
        this.setTickRandomly(true);
    }
    
    protected boolean canSilkHarvest() {
	    return false;
	 }

    public int quantityDropped(final Random par1Random) {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        return true;
    }
    
    public int getRenderType() {
        return NovaCraft.proxy.getBlockRender((Block)this);
    }
    
    public void onNeighborBlockChange(final World w, final int x, final int y, final int z, final int par5) {
    }
    
    public void breakBlock(final World par1World, final int par2, final int par3, final int par4, final Block par5, final int par6) {
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
    
    public TileEntity createNewTileEntity(final World par1World, final int par1) {
        return new TileEntityDeepOneEggActivated();
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemById(0);
    }
    
    public void updateTick(World world, int i, int j, int k, Random random) {
		
		if (true) {
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
		
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i + 4, j + 3, k + 4));
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i - 4, j + 3, k + 4));
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i + 4, j + 3, k - 4));
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i - 4, j + 3, k - 4));
		
		world.playSoundEffect(i, j, k, "nova_craft:boss.DOsummoning", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
		world.setBlock(i, j, k, NovaCraftBlocks.deepfire);
		world.playSoundEffect(i, j, k, "nova_craft:boss.DOsummoning", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
		
			if (!world.isRemote)
        	{
				EntityDeepoidDragon dragon = new EntityDeepoidDragon(world);
				dragon.setLocationAndAngles((double)i + 0.5D, (double)j + 15D, (double)k + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(dragon);
				dragon.spawnExplosionParticle();
        	}
		}
		
		world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));
	}
    
    @Override
	public int tickRate(World world) {
		return 10;
	}
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);

        if (p_149734_5_.nextInt(2) == 0)
        {
            p_149734_1_.spawnParticle("smoke", (double)((float)p_149734_2_ + p_149734_5_.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", (double)((float)p_149734_2_ + p_149734_5_.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);

        }
    }
    
    protected String getSummoningSound()
    {
        return "nova_craft:boss.DOsummoning";
    }
}
