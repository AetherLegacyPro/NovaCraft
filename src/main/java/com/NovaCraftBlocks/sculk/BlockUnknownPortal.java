package com.NovaCraftBlocks.sculk;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.entity.EntityNulk;
import com.NovaCraft.entity.EntityNuxx;
import com.NovaCraft.entity.EntityPrisoner;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.sounds.ModSounds;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockUnknownPortal extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockUnknownPortal() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setResistance(99999999F);
		this.setStepSound(ModSounds.soundVoid);
		this.setBlockBounds(0.3F, 0.0F, 0.0F, 0.7F, 1.0F, 1.0F);
		this.setTickRandomly(true);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:unknown_portal");
		iconFace = iconRegister.registerIcon("nova_craft:unknown_portal");
		iconTop = iconRegister.registerIcon("nova_craft:unknown_portal");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		if (rand.nextInt(100) == 0) {
			world.playSound((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "nova_craft:unknown.portal", 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
		}

		for (int i = 0; i < 4; ++i) {
			double d0 = (float) x + rand.nextFloat();
			double d1 = (float) y + rand.nextFloat();
			double d2 = (float) z + rand.nextFloat();
			double d3 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
			double d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
			double d5 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
			int j = rand.nextInt(2) * 2 - 1;

			if (world.getBlock(x - 1, y, z) != this && world.getBlock(x + 1, y, z) != this) {
				d0 = (double) x + 0.5D + 0.25D * (double) j;
				d3 = rand.nextFloat() * 2.0F * (float) j;
			} else {
				d2 = (double) z + 0.5D + 0.25D * (double) j;
				d5 = rand.nextFloat() * 2.0F * (float) j;
			}

			if (rand.nextInt(13) == 0) {
	            ParticleHandler.PORTAL_PARTICLE.spawn(world, x + rand.nextFloat(), y + 0.1f, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.PORTAL_PARTICLE.spawn(world, x + rand.nextFloat(), y + 0.4f, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.PORTAL_PARTICLE.spawn(world, x + rand.nextFloat(), y + 0.6f, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.PORTAL_PARTICLE.spawn(world, x + rand.nextFloat(), y + 0.9f, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.PORTAL_PARTICLE.spawn(world, x + rand.nextFloat(), y + 1.1f, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.PORTAL_PARTICLE.spawn(world, x + rand.nextFloat() + 2.1, y + 2.1f, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.PORTAL_PARTICLE.spawn(world, x + rand.nextFloat() + 2.4, y + 2.4f, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.PORTAL_PARTICLE.spawn(world, x + rand.nextFloat() + 2.6, y + 2.6f, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.PORTAL_PARTICLE.spawn(world, x + rand.nextFloat() + 2.9f, y + 2.9f, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.PORTAL_PARTICLE.spawn(world, x + rand.nextFloat() + 3.1f, y + 3.1f, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	        }
		}
	}
	
	public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
    {
		if (!(p_149670_5_ instanceof EntityPrisoner)) {
			p_149670_5_.attackEntityFrom(DamageSource.outOfWorld, 2.0F);
		}
    }
	
	public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }

}
