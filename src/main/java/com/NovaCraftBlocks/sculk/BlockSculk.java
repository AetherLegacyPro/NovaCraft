package com.NovaCraftBlocks.sculk;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.entity.EntitySculkAbomination;
import com.NovaCraft.entity.EntitySculkSymbiote;
import com.NovaCraft.particles.ParticleDarkLichenThree;
import com.NovaCraft.particles.ParticleGlowLichen;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.crystals.BlockLarimarCluster;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSculk extends Block {

    private IIcon[] icon;
    
	public BlockSculk() {
		super(Material.grass);
		this.icon = new IIcon[1];
		this.setHardness(0.3F);
		this.setResistance(1);
		this.setStepSound(ModSounds.soundSculk);
		this.setHarvestLevel("shovel", 0);
		setTickRandomly(true);
	}
	
	
	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:sculk");
    }
	
	public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        return this.icon[meta];
    }
	    
	protected boolean canSilkHarvest() {
	    return true;
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
			
				amount = MathHelper.getRandomIntegerInRange(random, 0, 1);
			

			return amount;
		}

		return 0;
	}
 	
 	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
 		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			player.triggerAchievement(AchievementsNovaCraft.the_deep_dark);
			
		if (entity.isSneaking()) {
			player.triggerAchievement(AchievementsNovaCraft.sneak_100);
			}
		
		}
 		
 		boolean hasSculkBoots = false;
 		if (entity instanceof EntityPlayer) {
 			EntityPlayer player = (EntityPlayer) entity;
 			final ItemStack boots = player.getCurrentArmor(0);
 			if (boots != null) {
 				hasSculkBoots = (boots.getItem() == NovaCraftItems.sculk_boots);
 			}
 		}
 		
 		if (entity instanceof EntityPlayer && !(hasSculkBoots)) {
 			int rand = (int)(1 + Math.random() * 15);
 			if (rand == 1 && !entity.isSneaking()) {
 			world.playSoundEffect(x, y, z, "nova_craft:warden_altar.shriek", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 0.9F);
 			EntitySculkSymbiote sculk = new EntitySculkSymbiote(world);
 			sculk.setPosition(x + 0.5D, y + 1D, z + 0.5D);

				if (!world.isRemote) {
					world.spawnEntityInWorld(sculk);		
				}
				
 			}
 			int rand2 = (int)(1 + Math.random() * 100);
 			if (rand2 == 10 && !entity.isSneaking()) {
 	 			world.playSoundEffect(x, y, z, "nova_craft:warden_altar.shriek", 3.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.25F + 0.95F);
 	 			EntitySculkAbomination sculk2 = new EntitySculkAbomination(world);
 	 			sculk2.setPosition(x + 0.5D, y + 1D, z + 0.5D);

 					if (!world.isRemote) {
 						world.spawnEntityInWorld(sculk2);		
 					}
 					
 	 		}
 		}
 	}
 	
 	public void onBlockDestroyedByPlayer(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_)
    { 
 		
        if (!p_149664_1_.isRemote)
        {       	
        	int rand = (int)(1 + Math.random() * 8);
    		switch (rand)
          {
          	case 1:
          	EntitySculkSymbiote entitysilverfish = new EntitySculkSymbiote(p_149664_1_);
            entitysilverfish.setLocationAndAngles((double)p_149664_2_ + 0.5D, (double)p_149664_3_, (double)p_149664_4_ + 0.5D, 0.0F, 0.0F);
            p_149664_1_.spawnEntityInWorld(entitysilverfish);
            entitysilverfish.spawnExplosionParticle();
            	break;
          	case 2:
          		break;
          	case 3:
              	break;	
          	case 4:
              	break;	
          		
          }
        }

        super.onBlockDestroyedByPlayer(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_);
    }
 	
 	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
 		
 		//if (world.provider.dimensionId != 1) {
 				
 		//	if (world.canBlockSeeTheSky(x, y, z)) { // && world.isDaytime()
 			//
 					//world.setBlock(x, y, z, NovaCraftBlocks.grimstone);
 			//}
			
 		//}
 		
 		
 		if (world.provider.dimensionId != -1 && world.provider.dimensionId != 1) {	
 			if (rand.nextInt(100) == 1 && world.getBlockLightValue(x, y + 1, z) <= 3 && y <= 25.0D) {
			EnumFacing facing = EnumFacing.getFront(rand.nextInt(EnumFacing.values().length));
			Block block = world.getBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ());
			int meta = world.getBlockMetadata(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ());
		
				if(block instanceof BlockSculkTentacle && meta % 6 == facing.ordinal()) {
					if(meta < 6) {
						world.setBlockMetadataWithNotify(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ(), meta + 6, 3);
					} else if(block == NovaCraftBlocks.sculk_tentacle_1) {
						world.setBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ(), NovaCraftBlocks.sculk_tentacle_2, meta - 6, 3);
					}
				} else if(canGrowIn(block)) {
					world.setBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ(), NovaCraftBlocks.sculk_tentacle_1, facing.ordinal(), 3);				
 				}
			}
		}
 		
 		else if (world.provider.dimensionId == 1 && world.getBlockLightValue(x, y + 1, z) <= 3) {	
 			if (rand.nextInt(15) == 1) {
			EnumFacing facing = EnumFacing.getFront(rand.nextInt(EnumFacing.values().length));
			Block block = world.getBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ());
			int meta = world.getBlockMetadata(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ());
		
				if(block instanceof BlockSculkTentacle && meta % 6 == facing.ordinal()) {
					if(meta < 6) {
						world.setBlockMetadataWithNotify(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ(), meta + 6, 3);
					} else if(block == NovaCraftBlocks.sculk_tentacle_1) {
						world.setBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ(), NovaCraftBlocks.sculk_tentacle_2, meta - 6, 3);
					}
				} else if(canGrowIn(block)) {
					world.setBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ(), NovaCraftBlocks.sculk_tentacle_1, facing.ordinal(), 3);
						}
 					}
 				}			
 		}
 	
 	private boolean canGrowIn(Block state) {
		return state.getMaterial() == Material.air;
	}
 	
 	@Override
	public boolean isOpaqueCube() {
		return true;
	}
 	
 	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World p_149734_1_, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random p_149734_5_) {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
        if (p_149734_5_.nextInt(15) == 0) {
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.4f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.6f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.9f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }	
        
    }
 	
 	@Override
	public int tickRate(World world) {
		return 2500;
	}

}
