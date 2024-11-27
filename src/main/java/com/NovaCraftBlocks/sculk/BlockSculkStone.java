package com.NovaCraftBlocks.sculk;

import java.util.Random;

import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSculkStone extends Block implements IGrowable {

	@SideOnly(Side.CLIENT)
	private IIcon icon;

	public BlockSculkStone() {
		super(Material.grass);
		this.setHardness(0.45F);
		this.setResistance(0.45F);
		this.setTickRandomly(true);
		this.setStepSound(ModSounds.soundSculk);
		this.setHarvestLevel("pickaxe", 0);
	}

	@Override
	public void updateTick(World worldIn, int x, int y, int z, Random rand) {
		if (!worldIn.isRemote) {
			if (worldIn.getBlockLightValue(x, y + 1, z) > 3 && worldIn.getBlockLightOpacity(x, y + 1, z) > 2) {
				worldIn.setBlock(x, y, z, Blocks.stone);
			} else if (worldIn.getBlockLightValue(x, y + 1, z) <= 3 && y <= 25.0D) {
				for (int l = 0; l < 4; ++l) {
					int i1 = x + rand.nextInt(3) - 1;
					int j1 = y + rand.nextInt(5) - 3;
					int k1 = z + rand.nextInt(3) - 1;

					if (worldIn.getBlock(i1, j1, k1) == Blocks.stone && worldIn.getBlockLightValue(i1, j1 + 1, k1) <= 3 && worldIn.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						worldIn.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_stone);
					}
					
					else if (worldIn.getBlock(i1, j1, k1) == NovaCraftBlocks.grimstone && worldIn.getBlockLightValue(i1, j1 + 1, k1) <= 3 && worldIn.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						worldIn.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_grimstone);
					}
					
					else if (worldIn.getBlock(i1, j1, k1) == NovaCraftBlocks.nullstone && worldIn.getBlockLightValue(i1, j1 + 1, k1) <= 3 && worldIn.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						worldIn.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_nullstone);
					}
					
					else if (worldIn.getBlock(i1, j1, k1) == Blocks.end_stone && worldIn.getBlockLightValue(i1, j1 + 1, k1) <= 3 && worldIn.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						worldIn.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_endstone);
					}
					
					else if (worldIn.getBlock(i1, j1, k1) == OtherModBlocks.deepslate && worldIn.getBlockLightValue(i1, j1 + 1, k1) <= 3 && worldIn.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						worldIn.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_deepslate);
					}
				}
			}
		}
	}

	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return Item.getItemFromBlock(Blocks.cobblestone);
	}

	@Override
	public int damageDropped(int meta) {
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister registry) {
		this.blockIcon = registry.registerIcon("nova_craft:sculk_stone");
		this.icon = registry.registerIcon("nova_craft:sculk_sensor_top");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return (side == 1 ? this.icon : (side == 0 ? Blocks.stone.getBlockTextureFromSide(side) : this.blockIcon));
	}


	@Override
	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		return true;
	}

	@Override
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return true;
	}

	@Override
	public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		int l = 0;

		while (l < 128) {
			int i1 = p_149853_3_;
			int j1 = p_149853_4_ + 1;
			int k1 = p_149853_5_;
			int l1 = 0;

			while (true) {
				if (l1 < l / 16) {
					i1 += p_149853_2_.nextInt(3) - 1;
					j1 += (p_149853_2_.nextInt(3) - 1) * p_149853_2_.nextInt(3) / 2;
					k1 += p_149853_2_.nextInt(3) - 1;

					if ((p_149853_1_.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.sculk_stone || p_149853_1_.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.sculk_grimstone
					   || p_149853_1_.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.sculk_nullstone || p_149853_1_.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.sculk_deepslate 
					   || p_149853_1_.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.sculk_endstone) && !p_149853_1_.getBlock(i1, j1, k1).isNormalCube()) {
						++l1;
						continue;
					}
				} else if (p_149853_1_.isAirBlock(i1, j1, k1)) {
					if (p_149853_2_.nextInt(5) != 0) {
						if (NovaCraftBlocks.sculk_growth.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_growth, 1, 3);
						}
					} else if (p_149853_2_.nextInt(5) != 1) {
						if (NovaCraftBlocks.sculk_vein.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_vein, 1, 3);
						}
					} else if (p_149853_2_.nextInt(5) != 2) {
						if (NovaCraftBlocks.sculk_tentacle_1.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_tentacle_1, 1, 0);
						}
					} else if (p_149853_2_.nextInt(5) != 3) {
						if (NovaCraftBlocks.sculk_sensor.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_sensor, 0, 2);
						}
					} else if (p_149853_2_.nextInt(5) != 4) {
						if (NovaCraftBlocks.sculk_tulip.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_tulip, 0, 2);
						}
					}
					else {
						if (NovaCraftBlocks.sculk_bush.canBlockStay(p_149853_1_, i1, j1, k1)) {
							p_149853_1_.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_bush, 1, 3);
						}
					}
				}

				++l;
				break;
			}
		}
	}
	
	@Override
	public int tickRate(World world) {
		return 30000;
	}

}