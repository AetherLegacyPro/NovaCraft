package com.NovaCraftBlocks.container;

import java.util.Iterator;
import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.EntitySculkSymbiote;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.OtherModItems;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTreasureChest extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockTreasureChest() {
		super(Material.rock);
		this.setHardness(50);
		this.setResistance(3000);
		this.setStepSound(Block.soundTypeWood);
		this.setHarvestLevel("axe", 0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:treasure crate");
		iconFace = iconRegister.registerIcon("nova_craft:treasure crate");
		iconTop = iconRegister.registerIcon("nova_craft:treasure crate");
	}
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return null;
    }
	
	protected boolean canSilkHarvest() {
        return false;
    }
	
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int l) {
		int rand2 = (int)(1 + Math.random() * 16);
		int rand = (int)(1 + Math.random() * 11);
		
		switch (rand2) {
		
		case 1: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.iron_ingot, 3 + rand));

			world.spawnEntityInWorld(entityItem);
		}
		case 2: if (!world.isRemote) {
			if (Configs.enableTreasureCratesDropDiamonds == true) {
				EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.diamond, 1));
				world.spawnEntityInWorld(entityItem);
			}
			else {
				EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.iron_ingot, 8 + rand));
				world.spawnEntityInWorld(entityItem);
			}
		}
		case 3: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gold_ingot, 4 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 4: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.vanite_chunk, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 5: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.vanite_chunk, 1 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 6: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.disc_fragment_5, 1));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 7: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.pherithium_scraps, 20 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}		
		case 8: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.brimstone_dust, 15 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 9: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.blazing_coal, 1));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 10: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.glow_ink_sac, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 11: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftBlocks.sculk_block, 6 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 12: if (!world.isRemote) {
			if (Loader.isModLoaded("etfuturum")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.copper_ingot, 5 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 13: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.arlemiteIngot, 1));
			
			world.spawnEntityInWorld(entityItem);
			}
		}	

		case 14: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.realmiteIngot, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 15: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.iron_ingot, 7 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 16: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.disc_fragment_5, 1));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		}
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World p_149734_1_, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random p_149734_5_) {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
        if (p_149734_5_.nextInt(35) == 0) {
            ParticleHandler.TREASURE.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.TREASURE.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.4f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.TREASURE.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.6f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.TREASURE.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.9f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.TREASURE.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }	
        
    }

}
