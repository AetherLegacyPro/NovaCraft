package com.NovaCraftBlocks.plants.end;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityDestitumite;
import com.NovaCraft.entity.EntityDestituteTentacle;
import com.NovaCraft.entity.EntityRealityDistorter;
import com.NovaCraft.entity.EntitySculkAbomination;
import com.NovaCraft.entity.EntitySculkSymbiote;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.sounds.ModSounds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDestitudeGrowth extends Block {

	@SideOnly(Side.CLIENT)
    private IIcon blockTop;
    @SideOnly(Side.CLIENT)
    private IIcon blockBottom;
	
	public BlockDestitudeGrowth() {
		super(Material.grass);

		this.setTickRandomly(true);
		this.setHardness(1.0F);
		this.setResistance(0.5F);
		this.setStepSound(ModSounds.soundSculk);
		this.setHarvestLevel("shovel", 0);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.blockTop : (p_149691_1_ == 0 ? this.blockBottom : this.blockIcon);
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
	    this.blockIcon = p_149651_1_.registerIcon("nova_craft:destitute_growth_side");
	    this.blockTop = p_149651_1_.registerIcon("nova_craft:destitute_growth_top");
	    this.blockBottom = p_149651_1_.registerIcon("minecraft:end_stone");
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return Item.getItemFromBlock(Blocks.end_stone);
	}
	
	protected boolean canSilkHarvest() {
	    return true;
	 }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox((double)p_149668_2_, (double)p_149668_3_, (double)p_149668_4_, (double)(p_149668_2_ + 1), (double)((float)(p_149668_3_ + 1) - f), (double)(p_149668_4_ + 1));
    }
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			
			boolean hasKlangiteBoots = false;
	 		if (entity instanceof EntityPlayer) {
	 			final ItemStack boots = player.getCurrentArmor(0);
	 			if (boots != null) {
	 				hasKlangiteBoots = (boots.getItem() == NovaCraftItems.klangite_boots);
	 			}
	 		}
	 		if (entity instanceof EntityPlayer && !(hasKlangiteBoots)) {
			if (player.isSneaking()) {
				if (player.motionY < 0) {
					player.motionY *= 0.005D;
				}

				return;
			}
			else {
					player.motionX *= 0.9D;
					player.motionZ *= 0.9D;
					player.motionY = -2.0D;
					int rand = (int)(1 + Math.random() * 20);		
					if (rand == 1) {
						player.attackEntityFrom(DamageSource.generic, 2.0F);
					}
					
					int rand2 = (int)(1 + Math.random() * 40);		
					if (rand2 == 3) {
						player.attackEntityFrom(DamageSource.wither, 2.0F);
					}
			}
		  }
		}
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		boolean hasKlangiteBoots = false;
 		if (entity instanceof EntityPlayer) {
 			EntityPlayer player = (EntityPlayer) entity;
 			final ItemStack boots = player.getCurrentArmor(0);
 			if (boots != null) {
 				hasKlangiteBoots = (boots.getItem() == NovaCraftItems.klangite_boots);
 			}
 		}
 		
 		if (entity instanceof EntityPlayer && !(hasKlangiteBoots)) {
 			int rand = (int)(1 + Math.random() * 25);
 			if (rand == 1 && !entity.isSneaking()) {
 			world.playSoundEffect(x, y, z, "ambient.cave.cave", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 0.9F);
 			EntityDestitumite dest = new EntityDestitumite(world);
 			dest.setPosition(x + 0.5D, y + 1D, z + 0.5D);

				if (!world.isRemote) {
					world.spawnEntityInWorld(dest);		
				}
				
 			}
 			int rand3 = (int)(1 + Math.random() * 35);
 			if (rand3 == 11 && !entity.isSneaking()) {
 	 			world.playSoundEffect(x, y, z, "ambient.cave.cave", 2.5F, world.rand.nextFloat() - world.rand.nextFloat() * 0.25F + 0.95F);
 	 			EntityDestituteTentacle tentacle = new EntityDestituteTentacle(world);
 	 			tentacle.setPosition(x + 0.5D, y + 1D, z + 0.5D);

 					if (!world.isRemote) {
 						world.spawnEntityInWorld(tentacle);		
 					}
 					
 	 		}
 			
 			int rand2 = (int)(1 + Math.random() * 100);
 			if (rand2 == 10 && !entity.isSneaking()) {
 	 			world.playSoundEffect(x, y, z, "ambient.cave.cave", 3.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.25F + 0.95F);
 	 			EntityRealityDistorter reality = new EntityRealityDistorter(world);
 	 			reality.setPosition(x + 0.5D, y + 1D, z + 0.5D);

 					if (!world.isRemote) {
 						world.spawnEntityInWorld(reality);		
 					}
 					
 	 		}
 		}
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World p_149734_1_, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random p_149734_5_) {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
        if (p_149734_5_.nextInt(5) == 0) {
            ParticleHandler.VOID.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.VOID.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.4f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.VOID.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.6f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.VOID.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.9f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.VOID.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }	
        
    }


}
