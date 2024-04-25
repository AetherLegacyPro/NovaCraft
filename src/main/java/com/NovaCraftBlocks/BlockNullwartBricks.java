package com.NovaCraftBlocks;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntityDeepoid;
import com.NovaCraft.entity.EntityIonizatior;
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
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockNullwartBricks extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockNullwartBricks() {
		super(Material.rock);
		this.setHardness(1.5F);
		this.setResistance(3);
		this.setStepSound(ModSounds.soundGrimstoneBricks);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:nullwart_brick");
		iconFace = iconRegister.registerIcon("nova_craft:nullwart_brick");
		iconTop = iconRegister.registerIcon("nova_craft:nullwart_brick");
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
 		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;		
		
		}
 		
 		if (entity instanceof EntityPlayer) {
 			int rand = (int)(1 + Math.random() * 750);
 			if (rand == 1 && world.getBlockLightValue(x, y, z) < 9 && world.provider.dimensionId == -1) {
 			world.playSoundEffect(x, y, z, "nova_craft:deepoid.breath", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 0.9F);
 			EntityDeepoid deepoid = new EntityDeepoid(world);
 			deepoid.setPosition(x + 0.5D, y + 1D, z + 0.5D);

				if (!world.isRemote) {
					world.spawnEntityInWorld(deepoid);		
				}
				
 			}
 			int rand2 = (int)(1 + Math.random() * 250);
 			if (rand2 == 10 && world.getBlockLightValue(x, y, z) < 10 && world.provider.dimensionId == -1) {
 	 			world.playSoundEffect(x, y, z, "mob.blaze.hit", 3.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.25F + 0.95F);
 	 			EntityIonizatior ion = new EntityIonizatior(world);
 	 			ion.setPosition(x + 0.5D, y + 1D, z + 0.5D);

 					if (!world.isRemote) {
 						world.spawnEntityInWorld(ion);		
 					}
 					
 	 		}
 		}
 	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);

        if (p_149734_5_.nextInt(30) == 0 && p_149734_1_.provider.dimensionId == -1)
        {
            ParticleHandler.IONFLAME.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAME.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.3f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAME.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ - 1.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAME.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 1.3f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.IONFLAME.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);

        }
    }

}