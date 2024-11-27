package com.NovaCraftBlocks.container;

import java.util.Iterator;
import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.EntitySculkSymbiote;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFloodedChest extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockFloodedChest() {
		super(Material.rock);
		this.setHardness(25);
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
		blockIcon = iconRegister.registerIcon("nova_craft:flooded_crate");
		iconFace = iconRegister.registerIcon("nova_craft:flooded_crate");
		iconTop = iconRegister.registerIcon("nova_craft:flooded_crate");
	}
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return null;
    }
	
	protected boolean canSilkHarvest() {
        return false;
    }
	
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int l) {
		int rand2 = (int)(1 + Math.random() * 25);
		int rand = (int)(1 + Math.random() * 3);
		
		int rand3 = (int)(1 + Math.random() * 5);
		
		switch (rand2) {
		
		case 1: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.fish, 0, rand + 4));

			world.spawnEntityInWorld(entityItem);
		}
		case 2: if (!world.isRemote) {
					if(rand3 == 2) {
				EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.fish, 1, rand + 4));
				
				world.spawnEntityInWorld(entityItem);
				}
		}
		case 3: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.fish, 2, rand + 1));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 4: if (!world.isRemote) {
				if(rand3 == 1) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.potion_water_breathing_extended, 1));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		case 5: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.fish, 3, rand + 2));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 6: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.sea_serpent_scales, rand + 2));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 7: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.sea_serpent_venom_sac, 1));
			
			world.spawnEntityInWorld(entityItem);
		}		
		case 8: if (!world.isRemote) {
			if (Loader.isModLoaded("etfuturum") && Configs.enablePrismarineInStructures == true) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.prismarine_shard, rand + 5));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		case 9: if (!world.isRemote) {
			if (Loader.isModLoaded("etfuturum") && Configs.enablePrismarineInStructures == true) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.prismarine_crystals, rand + 4));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		case 10: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.dye, 0, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 11: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.glow_ink_sac, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 12: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.cave_monitor_scales, rand + 1));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 13: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.clay_ball, rand + 8));
			
			world.spawnEntityInWorld(entityItem);
		}	

		case 14: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.emerald, 1));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 15: if (!world.isRemote) {
			if(rand3 == 4) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.vanite_ingot, rand + 1));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		case 16: if (!world.isRemote) {
			if(rand3 == 5) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gold_ingot, rand + 1));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		default: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.clay_ball, rand + 8));
			
			world.spawnEntityInWorld(entityItem);
			
			}
		}
	}

}
