package com.NovaCraftBlocks.sculk;

import java.util.Random;
import com.NovaCraft.config.Configs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSculkGrimstone extends Block implements IGrowable {

	@SideOnly(Side.CLIENT)
	private IIcon[] topIcons;
	private IIcon sideIcon;

	public BlockSculkGrimstone() {
		super(Material.grass);
		this.setHardness(2.45F);
		this.setResistance(2.45F);
		this.setTickRandomly(true);
		this.setStepSound(ModSounds.soundSculk);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public void updateTick(World worldIn, int x, int y, int z, Random rand) {
		if (!worldIn.isRemote) {
			if (worldIn.getBlockLightValue(x, y + 1, z) > 3 && worldIn.getBlockLightOpacity(x, y + 1, z) > 2) {
				worldIn.setBlock(x, y, z, NovaCraftBlocks.grimstone);
			} else if (worldIn.getBlockLightValue(x, y + 1, z) == 0 && y <= 25.0D && rand.nextInt(50) == 0 && Configs.enableSculkStoneSpreading == true) {
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
		return Item.getItemFromBlock(NovaCraftBlocks.cobbled_grimstone);
	}

	@Override
	public int damageDropped(int meta) {
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister registry) {
		this.topIcons = new IIcon[4];
		for (int i = 0; i < 4; i++) {
			this.topIcons[i] = registry.registerIcon("nova_craft:sculk_sensor_top_" + i);
		}
		this.sideIcon = registry.registerIcon("nova_craft:sculk_grimstone");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		if (side == 1) {
			int hash = x * 3129871 ^ z * 116129781 ^ y;
			hash = hash * hash * 42317861 + hash * 11;
			int rotation = (hash >> 16) & 3;
			return this.topIcons[rotation];
		} else if (side == 0) {
			return NovaCraftBlocks.grimstone.getBlockTextureFromSide(side);
		} else {
			return this.sideIcon;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (side == 1) return topIcons[0];
		if (side == 0) return NovaCraftBlocks.grimstone.getBlockTextureFromSide(side);
		return sideIcon;
	}


	@Override
	public boolean func_149851_a(World world, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		return true;
	}

	@Override
	public boolean func_149852_a(World world, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return true;
	}

	@Override
	public void func_149853_b(World world, Random random, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		int l = 0;

		while (l < 128) {
			int i1 = p_149853_3_;
			int j1 = p_149853_4_ + 1;
			int k1 = p_149853_5_;
			int l1 = 0;

			while (true) {
				if (l1 < l / 16) {
					i1 += random.nextInt(3) - 1;
					j1 += (random.nextInt(3) - 1) * random.nextInt(3) / 2;
					k1 += random.nextInt(3) - 1;

					if ((world.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.sculk_stone || world.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.sculk_grimstone
					   || world.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.sculk_nullstone || world.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.sculk_deepslate 
					   || world.getBlock(i1, j1 - 1, k1) == NovaCraftBlocks.sculk_endstone) && !world.getBlock(i1, j1, k1).isNormalCube()) {
						++l1;
						continue;
					}
				} else if (world.isAirBlock(i1, j1, k1)) {
					if (random.nextInt(5) != 0) {
						if (NovaCraftBlocks.sculk_growth.canBlockStay(world, i1, j1, k1)) {
							world.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_growth, 1, 3);
						}
					} else if (random.nextInt(5) != 1) {
						if (NovaCraftBlocks.sculk_vein.canBlockStay(world, i1, j1, k1)) {
							world.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_vein, 1, 3);
						}
					} else if (random.nextInt(5) != 2) {
						if (NovaCraftBlocks.sculk_tentacle_1.canBlockStay(world, i1, j1, k1)) {
							world.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_tentacle_1, 1, 0);
						}
					} else if (random.nextInt(5) != 3) {
						if (NovaCraftBlocks.sculk_sensor.canBlockStay(world, i1, j1, k1)) {
							world.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_sensor, 0, 2);
						}
					} else if (random.nextInt(5) != 4) {
						if (NovaCraftBlocks.sculk_tulip.canBlockStay(world, i1, j1, k1)) {
							world.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_tulip, 0, 2);
						}
					}
					else {
						if (NovaCraftBlocks.sculk_bush.canBlockStay(world, i1, j1, k1)) {
							world.setBlock(i1, j1, k1, NovaCraftBlocks.sculk_bush, 1, 3);
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
