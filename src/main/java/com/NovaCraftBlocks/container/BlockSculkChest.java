package com.NovaCraftBlocks.container;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.config.ConfigsCompact;
import com.NovaCraft.entity.EntitySculkDweller;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.OtherModBlocks;
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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSculkChest extends Block {
	
	public BlockSculkChest() {
		super(Material.wood);
		this.setHardness(50);
		this.setResistance(3000);
		this.setStepSound(ModSounds.soundSculkVein);
		this.setHarvestLevel("axe", 0);
	}

	public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("nova_craft:wardencrate");
    }
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return null;
    }
	
	protected boolean canSilkHarvest() {
        return false;
    }
	
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int l) {
		int rand2 = (int)(1 + Math.random() * 14);
		int rand = (int)(1 + Math.random() * 16);
		switch (rand2) {
		
		case 1: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.iron_ingot, 15 + rand));

			world.spawnEntityInWorld(entityItem);
		}
		case 2: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.diamond, 1 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 3: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.gold_ingot, 10 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 4: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.vanite_chunk, 6 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 5: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.echo_shard, 3 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 6: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.disc_fragment_5, 3));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 7: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.pherithium_scraps, 17 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}		
		case 8: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.brimstone_dust, 12 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 9: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.raw_klangite, 1));
			
			world.spawnEntityInWorld(entityItem);
		}
		case 10: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.glow_ink_sac, 5 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 11: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftBlocks.sculk_block, 12 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 12: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.heart_of_the_end, 1));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 13: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.dark_essence, 1 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 14: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(NovaCraftItems.echo_shard, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 15: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.diamond, 1 + rand));
			
			world.spawnEntityInWorld(entityItem);
		}
		
		case 16: if (!world.isRemote) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(Items.golden_apple, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
			
			EntitySculkDweller sentry = new EntitySculkDweller(world);

			if (!world.isRemote) {
				world.spawnEntityInWorld(sentry);
			}
		}
		
		case 17: if (!world.isRemote) {
			if (Loader.isModLoaded("etfuturum")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.netherite_scrap, 1 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
			
		}
		
		case 18: if (!world.isRemote) {
			if (Loader.isModLoaded("etfuturum")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.copper_ingot, 16 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
			
		}
		
		case 19: if (!world.isRemote) {
			if (Loader.isModLoaded("aether_legacy")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.ambrosium_shard, 20 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
			
		}
		
		case 20: if (!world.isRemote) {
			if (Loader.isModLoaded("aether_legacy")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.zanite_gemstone, 5 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
			
		}
		
		case 21: if (!world.isRemote) {
			if (Loader.isModLoaded("aether_legacy")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.swet_ball, 6 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 22: if (!world.isRemote) {
			if (Loader.isModLoaded("netherlicious")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.Ingot, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}

		case 23: if (!world.isRemote) {
			if (Loader.isModLoaded("netherlicious")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.VoidQuartzItem, 9 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}	

		case 24: if (!world.isRemote) {
			if (Loader.isModLoaded("aether_legacy")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModBlocks.enchanted_gravitite, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}

		case 25: if (!world.isRemote) {	
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.rupeeIngot, 1 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}

		case 26: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.arlemiteIngot, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}	

		case 27: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.realmiteIngot, 4 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 28: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.netheriteIngot, 3 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 29: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.bloodgem, 3 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 30: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.corruptedShards, 3 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 31: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.corruptedShards, 3 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}

		case 32: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.divineShards, 3 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}	
		
		case 33: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.enderShards, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 34: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.jungleShards, 3 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 35: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.moltenShards, 3 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 36: if (!world.isRemote) {
			if (Loader.isModLoaded("divinerpg")) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.terranShards, 3 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 37: if (!world.isRemote) {
			if (Loader.isModLoaded("aether_legacy") && ConfigsCompact.enableAetherLegacyCompact) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.arkenium_chunk, 2 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 38: if (!world.isRemote) {
			if (Loader.isModLoaded("aether_legacy") && ConfigsCompact.enableAetherLegacyCompact) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.enchanted_divineral, 2));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 39: if (!world.isRemote) {
			if (Loader.isModLoaded("aether_legacy") && ConfigsCompact.enableAetherLegacyCompact) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.continuum_orb, 1));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 40: if (!world.isRemote) {
			if (Loader.isModLoaded("aether_legacy") && ConfigsCompact.enableAetherLegacyCompact) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.continuum_gemstone, 1 + rand));
			
			world.spawnEntityInWorld(entityItem);
			}
		}
		
		case 41: if (!world.isRemote) {
			if (Loader.isModLoaded("aether_legacy") && ConfigsCompact.enableAetherLegacyCompact) {
			EntityItem entityItem = new EntityItem(world, x, y, z, new ItemStack(OtherModItems.divineral_ingot, 1));
			
			world.spawnEntityInWorld(entityItem);
			}
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
