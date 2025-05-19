package com.NovaCraftBlocks;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityBlazingSerpentQueen;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.entity.EntitySavageSerpent;
import com.NovaCraft.entity.EntitySculkSymbiote;
import com.NovaCraft.sounds.ModSounds;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTrapTophinite extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockTrapTophinite() {
		super(Material.iron);
		this.setHardness(10);
		this.setResistance(10);
		this.setStepSound(ModSounds.soundNullstone);
		this.setHarvestLevel("pickaxe", 1);
		this.setCreativeTab((CreativeTabs)null);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:block_of_tophinite");
		iconFace = iconRegister.registerIcon("nova_craft:block_of_tophinite");
		iconTop = iconRegister.registerIcon("nova_craft:block_of_tophinite");
	}

	protected boolean canSilkHarvest() {
	    return false;
	 }
	
	public boolean canDropFromExplosion(Explosion p_149659_1_) {
        return false;
    }
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
	    return null;
	}
	
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion p_149723_5_) {
		if (!world.isRemote)
        { 
			world.setBlock(x, y, z, Blocks.air, 0, 2);
			EntityBlazingSerpentQueen entityserpent = new EntityBlazingSerpentQueen(world);
            entityserpent.setLocationAndAngles((double)x + 5.5D, (double)y, (double)z + 0.5D, 0.0F, 0.0F);
            world.spawnEntityInWorld(entityserpent);
            entityserpent.spawnExplosionParticle();
            
            world.setBlock(x, y, z, Blocks.air, 0, 2);
			EntitySavageSerpent entityserpent2 = new EntitySavageSerpent(world);
            entityserpent2.setLocationAndAngles((double)x + 5.5D, (double)y, (double)z + 3.5D, 0.0F, 0.0F);
            world.spawnEntityInWorld(entityserpent2);
            entityserpent2.spawnExplosionParticle();
            
            world.setBlock(x, y, z, Blocks.air, 0, 2);
			EntitySavageSerpent entityserpent3 = new EntitySavageSerpent(world);
            entityserpent3.setLocationAndAngles((double)x + 5.5D, (double)y, (double)z - 3.5D, 0.0F, 0.0F);
            world.spawnEntityInWorld(entityserpent3);
            entityserpent3.spawnExplosionParticle();
        }
		
	}
	
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int p_149664_5_) { 
		if (!world.isRemote)
        { 
			world.setBlock(x, y, z, Blocks.air, 0, 2);
			EntityBlazingSerpentQueen entityserpent = new EntityBlazingSerpentQueen(world);
            entityserpent.setLocationAndAngles((double)x + 5.5D, (double)y, (double)z + 0.5D, 0.0F, 0.0F);
            world.spawnEntityInWorld(entityserpent);
            entityserpent.spawnExplosionParticle();
            
            world.setBlock(x, y, z, Blocks.air, 0, 2);
			EntitySavageSerpent entityserpent2 = new EntitySavageSerpent(world);
            entityserpent2.setLocationAndAngles((double)x + 5.5D, (double)y, (double)z + 3.5D, 0.0F, 0.0F);
            world.spawnEntityInWorld(entityserpent2);
            entityserpent2.spawnExplosionParticle();
            
            world.setBlock(x, y, z, Blocks.air, 0, 2);
			EntitySavageSerpent entityserpent3 = new EntitySavageSerpent(world);
            entityserpent3.setLocationAndAngles((double)x + 5.5D, (double)y, (double)z - 3.5D, 0.0F, 0.0F);
            world.spawnEntityInWorld(entityserpent3);
            entityserpent3.spawnExplosionParticle();
        }
		
    }
}
