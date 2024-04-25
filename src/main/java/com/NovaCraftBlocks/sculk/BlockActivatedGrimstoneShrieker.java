package com.NovaCraftBlocks.sculk;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.entity.EntityWarden;
import com.NovaCraft.entity.DeepoidDragon.EntityDeepoidDragon;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockActivatedGrimstoneShrieker extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockActivatedGrimstoneShrieker() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setResistance(600000000);
		this.setStepSound(ModSounds.soundGrimstone);
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
		blockIcon = iconRegister.registerIcon("nova_craft:activatedwardenaltar");
		iconFace = iconRegister.registerIcon("nova_craft:warden_altar_top");
		iconTop = iconRegister.registerIcon("nova_craft:warden_altar_top");
	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
			float f = (float) x + 0.5F;
			float f1 = (float) y + 1.0F + (random.nextFloat() * 6F) / 16F;
			float f2 = (float) z + 0.5F;

			world.spawnParticle("smoke", f, f1, f2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("townaura", f, f1, f2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("townaura", f, f1, f2, 0.1D, 0.0D, 0.1D);
			world.spawnParticle("townaura", f, f1, f2, -0.1D, 0.0D, -0.1D);
			world.spawnParticle("townaura", f, f1, f2, -0.1D, 0.0D, 0.1D);
			world.spawnParticle("townaura", f, f1, f2, 0.1D, 0.0D, -0.1D);
			world.spawnParticle("townaura", f, f1, f2, 0.1D, 0.0D, 0.2D);
			world.spawnParticle("townaura", f, f1, f2, -0.1D, 0.0D, -0.2D);
			world.spawnParticle("townaura", f, f1, f2, -0.1D, 0.0D, 0.2D);
			world.spawnParticle("townaura", f, f1, f2, 0.1D, 0.0D, -0.2D);
	}
	
	public void updateTick(World world, int i, int j, int k, Random random) {
		
		if (true) {
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
		
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i + 4, j + 3, k + 4));
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i - 4, j + 3, k + 4));
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i + 4, j + 3, k - 4));
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i - 4, j + 3, k - 4));
		
		world.playSoundEffect(i, j, k, "nova_craft:boss.Wardensummoning", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
		world.setBlock(i, j, k, NovaCraftBlocks.grimstone_shrieker);
		world.playSoundEffect(i, j, k, "nova_craft:boss.Wardensummoning", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 1.2F);
		
			if (!world.isRemote)
        	{
				EntityWarden warden = new EntityWarden(world);
				warden.setLocationAndAngles((double)i + 0.5D, (double)j, (double)k + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(warden);
				warden.spawnExplosionParticle();
        	}
		}
		
		world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));
	}
	
	@Override
	public int tickRate(World world) {
		return 40;
	}
	
	protected String getWardenSummoningSound()
    {
        return "nova_craft:boss.Wardensummoning";
    }
	

}
