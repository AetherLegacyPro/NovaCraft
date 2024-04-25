package com.NovaCraftBlocks.potion;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMoltenVaniteCrystalCauldron extends BlockCauldron {

	@SideOnly(Side.CLIENT)
	public IIcon field_150029_a;
	@SideOnly(Side.CLIENT)
	public IIcon field_150028_b;
	@SideOnly(Side.CLIENT)
	public IIcon field_150030_M;
	@SideOnly(Side.CLIENT)
	public IIcon lavaIcon;
	
	public BlockMoltenVaniteCrystalCauldron() {
		super();
		this.setHardness(12);
		this.setResistance(55);
		this.setTickRandomly(true);
		this.setLightLevel(1.0F);
		this.setStepSound(ModSounds.soundNullstone);
		setHarvestLevel("pickaxe", 3);
		this.setCreativeTab((CreativeTabs)null);
	}
	
	protected boolean canSilkHarvest() {
	    return false;
	 }
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return NovaCraftItems.vanite_cauldron_item;
    }
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		boolean flag = (int)entity.prevPosX != (int)entity.posX || (int)entity.prevPosY != (int)entity.posY || (int)entity.prevPosZ != (int)entity.posZ;

		if ((flag || entity.ticksExisted % 25 == 0))
		{
			entity.motionY = 0.20000000298023224D;
			entity.motionX = (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F;
			entity.motionZ = (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F;
			entity.playSound("random.fizz", 0.4F, 2.0F + world.rand.nextFloat() * 0.4F);
		}
		if (!world.isRemote) {
			entity.attackEntityFrom(DamageSource.lava, 4.0F);
			entity.setFire(15);			
		}
	}
	
	@Override
	public void updateTick(World world, int i, int j, int k, Random random) {

		if (world.provider.dimensionId == -1) {
			if (world.getBlock(i, j, k + 1) == NovaCraftBlocks.blazlinite
			&& world.getBlock(i, j, k - 1) == NovaCraftBlocks.blazlinite
			&& world.getBlock(i + 1, j, k) == NovaCraftBlocks.blazlinite
			&& world.getBlock(i - 1, j, k) == NovaCraftBlocks.blazlinite
			&& world.getBlock(i, j - 1, k) == NovaCraftBlocks.deepfire) {
				
			world.setBlock(i, j, k, NovaCraftBlocks.cracked_vanite_crystal_cauldron, 0, 2);
			world.setBlock(i, j + 1, k, NovaCraftBlocks.vanite_cluster, 1, 2);
			
			world.setBlock(i, j, k + 1, Blocks.air, 0, 2);
			world.setBlock(i, j, k - 1, Blocks.air, 0, 2);
			world.setBlock(i + 1, j, k, Blocks.air, 0, 2);
			world.setBlock(i - 1, j, k, Blocks.air, 0, 2);
			world.setBlock(i, j - 1, k, Blocks.netherrack, 0, 2);
			
            world.playSoundEffect((double)(i + 0.5f), (double)(j + 0.5f), (double)(k + 0.5f), "nova_craft:crystal.break", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
    public static IIcon getCauldronIcon(String p_150026_0_)
    {
        return (IIcon) (p_150026_0_.equals("inner") ? NovaCraftBlocks.vanite_cauldron : (p_150026_0_.equals("bottom") ? NovaCraftBlocks.vanite_cauldron : null));
    }
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return Blocks.cauldron.getIcon(side, meta);
	}
	
	@Override
	public int tickRate(World world)
	{
		return 500;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.field_150029_a = p_149651_1_.registerIcon("nova_craft:vanitecauldron_bottom");
        this.field_150028_b = p_149651_1_.registerIcon("nova_craft:vanitecauldron_top");
        this.field_150030_M = p_149651_1_.registerIcon("nova_craft:bottom");
        this.blockIcon = p_149651_1_.registerIcon("nova_craft:vanitecauldron_side");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int i, int j, int k, Random random) {
		World par1World = world;
		int par2 = i;
		int par3 = j;
		int par4 = k;
		Random par5Random = random;
		if (true)
			for (int l = 0; l < 8; ++l) {
				double d0 = (double) ((float) par2 + par5Random.nextFloat());
				double d1 = (double) ((float) par3 + par5Random.nextFloat());
				double d2 = (double) ((float) par4 + par5Random.nextFloat());
				double d3 = 0.0D;
				double d4 = 0.0D;
				double d5 = 0.0D;
				int i1 = par5Random.nextInt(2) * 2 - 1;
				d3 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d4 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d5 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				par1World.spawnParticle("reddust", d0, d1, d2, d3, d4, d5);
				if (random.nextInt(50) == 0)
	            {
				ParticleHandler.BLAZFLAME.spawn(par1World, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]); 
	            }
			}

	}
	
	@Override
	public int getRenderType()
	{
		return RenderIDs.MOLTEN_VANITE_CRYSTAL_CAULDRON;
	}
	
	@SideOnly(Side.CLIENT)
    public static float getRenderLiquidLevel(int p_150025_0_)
    {
        int j = MathHelper.clamp_int(p_150025_0_, 0, 3);
        return (float)(6 + 3 * j) / 16.0F;
    }

}
