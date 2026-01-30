package com.NovaCraftBlocks.ores;

import java.util.Random;

import com.NovaCraft.NovaCraft;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.decorative.BlocksNovaCraftSlab;
import com.ibm.icu.impl.duration.impl.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockVanite extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockVanite() {
		super(Material.iron);
		this.setHardness(15);
		this.setResistance(25);
		this.setStepSound(ModSounds.soundNullstone);
		this.setHarvestLevel("pickaxe", 3);
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
		blockIcon = iconRegister.registerIcon("nova_craft:block_of_vanite");
		iconFace = iconRegister.registerIcon("nova_craft:block_of_vanite");
		iconTop = iconRegister.registerIcon("nova_craft:block_of_vanite");
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return true;
	}
	
	public void randomDisplayTick(World world, int i, int j, int k, Random random) {
		World par1World = world;
		int par2 = i;
		int par3 = j;
		int par4 = k;
		Random par5Random = random;
		if (true)
			for (int l = 0; l < 4; ++l) {
				double d0 = (double) ((float) par2 + par5Random.nextFloat());
				double d1 = (double) ((float) par3 + par5Random.nextFloat());
				double d2 = (double) ((float) par4 + par5Random.nextFloat());
				double d3 = 0.0D;
				double d4 = 0.0D;
				double d5 = 0.0D;
				int i1 = par5Random.nextInt(2) * 2 - 1;
				d3 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d4 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				d5 = ((double) par5Random.nextFloat() - 0.5D) * 0.5D;
				par1World.spawnParticle("reddust", d0, d1, d2, d3, d4, d5);
			}

	}
	
	public void updateTick(World world, int i, int j, int k, Random random) {

		//Diamond
		if (random.nextInt(3) == 0) {
           if (world.getBlock(i, j, k + 1) == Blocks.diamond_ore) {
                world.setBlock(i, j, k + 1, NovaCraftBlocks.grimstone_diamond, 0, 2);
           }
		}
		if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
           if (world.getBlock(i, j, k + 1) == NovaCraftBlocks.grimstone_diamond) {
               world.setBlock(i, j, k + 1, NovaCraftBlocks.nullstone_diamond, 0, 2);
           	}
		}
		if (random.nextInt(3) == 0) {
          if (world.getBlock(i, j, k - 1) == Blocks.diamond_ore) {
            world.setBlock(i, j, k - 1, NovaCraftBlocks.grimstone_diamond, 0, 2);
           }
		}
		if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
          if (world.getBlock(i, j, k - 1) == NovaCraftBlocks.grimstone_diamond) {
              world.setBlock(i, j, k - 1, NovaCraftBlocks.nullstone_diamond, 0, 2);
              }
		}
		if (random.nextInt(3) == 0) {
          if (world.getBlock(i + 1, j, k) == Blocks.diamond_ore) {
            world.setBlock(i + 1, j, k, NovaCraftBlocks.grimstone_diamond, 0, 2);
           }
		}
		if (random.nextInt(15) == 0  && world.provider.dimensionId == 1) {
          if (world.getBlock(i + 1, j, k) == NovaCraftBlocks.grimstone_diamond) {
              world.setBlock(i + 1, j, k, NovaCraftBlocks.nullstone_diamond, 0, 2);
            }
		}
		if (random.nextInt(3) == 0) {
          if (world.getBlock(i - 1, j, k) == Blocks.diamond_ore) {
            world.setBlock(i - 1, j, k, NovaCraftBlocks.grimstone_diamond, 0, 2);
           }
		}
		if (random.nextInt(15) == 0  && world.provider.dimensionId == 1) {
          if (world.getBlock(i - 1, j, k) == NovaCraftBlocks.grimstone_diamond) {
              world.setBlock(i - 1, j, k, NovaCraftBlocks.nullstone_diamond, 0, 2);
              }
		}
		if (random.nextInt(3) == 0) {
          if (world.getBlock(i, j + 1, k) == Blocks.diamond_ore) {
            world.setBlock(i, j + 1, k, NovaCraftBlocks.grimstone_diamond, 0, 2);
           }
		}
		if (random.nextInt(15) == 0  && world.provider.dimensionId == 1) {
          if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.grimstone_diamond) {
              world.setBlock(i, j + 1, k, NovaCraftBlocks.nullstone_diamond, 0, 2);
              }
		}
		if (random.nextInt(3) == 0) {
          if (world.getBlock(i, j - 1, k) == Blocks.diamond_ore) {
            world.setBlock(i, j - 1, k, NovaCraftBlocks.grimstone_diamond, 0, 2);
           }
		}
		if (random.nextInt(15) == 0  && world.provider.dimensionId == 1) {
          if (world.getBlock(i, j - 1, k) == NovaCraftBlocks.grimstone_diamond) {
              world.setBlock(i, j - 1, k, NovaCraftBlocks.nullstone_diamond, 0, 2);
              }		
		}
          //------------------------------------------------------------------------------

          //Gold
		if (random.nextInt(3) == 0) {
	           if (world.getBlock(i, j, k + 1) == Blocks.gold_ore) {
	                world.setBlock(i, j, k + 1, NovaCraftBlocks.grimstone_gold, 0, 2);
	           }
			}
			if (random.nextInt(15) == 0  && world.provider.dimensionId == 1) {
	           if (world.getBlock(i, j, k + 1) == NovaCraftBlocks.grimstone_gold) {
	               world.setBlock(i, j, k + 1, NovaCraftBlocks.nullstone_gold, 0, 2);
	           	}
			}
			if (random.nextInt(3) == 0) {
	          if (world.getBlock(i, j, k - 1) == Blocks.gold_ore) {
	            world.setBlock(i, j, k - 1, NovaCraftBlocks.grimstone_gold, 0, 2);
	           }
			}
			if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
	          if (world.getBlock(i, j, k - 1) == NovaCraftBlocks.grimstone_gold) {
	              world.setBlock(i, j, k - 1, NovaCraftBlocks.nullstone_gold, 0, 2);
	              }
			}
			if (random.nextInt(3) == 0) {
	          if (world.getBlock(i + 1, j, k) == Blocks.gold_ore) {
	            world.setBlock(i + 1, j, k, NovaCraftBlocks.grimstone_gold, 0, 2);
	           }
			}
			if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
	          if (world.getBlock(i + 1, j, k) == NovaCraftBlocks.grimstone_gold) {
	              world.setBlock(i + 1, j, k, NovaCraftBlocks.nullstone_gold, 0, 2);
	            }
			}
			if (random.nextInt(3) == 0) {
	          if (world.getBlock(i - 1, j, k) == Blocks.gold_ore) {
	            world.setBlock(i - 1, j, k, NovaCraftBlocks.grimstone_gold, 0, 2);
	           }
			}
			if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
	          if (world.getBlock(i - 1, j, k) == NovaCraftBlocks.grimstone_gold) {
	              world.setBlock(i - 1, j, k, NovaCraftBlocks.nullstone_gold, 0, 2);
	              }
			}
			if (random.nextInt(3) == 0) {
	          if (world.getBlock(i, j + 1, k) == Blocks.gold_ore) {
	            world.setBlock(i, j + 1, k, NovaCraftBlocks.grimstone_gold, 0, 2);
	           }
			}
			if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
	          if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.grimstone_gold) {
	              world.setBlock(i, j + 1, k, NovaCraftBlocks.nullstone_gold, 0, 2);
	              }
			}
			if (random.nextInt(3) == 0) {
	          if (world.getBlock(i, j - 1, k) == Blocks.gold_ore) {
	            world.setBlock(i, j - 1, k, NovaCraftBlocks.grimstone_gold, 0, 2);
	           }
			}
			if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
	          if (world.getBlock(i, j - 1, k) == NovaCraftBlocks.grimstone_gold) {
	              world.setBlock(i, j - 1, k, NovaCraftBlocks.nullstone_gold, 0, 2);
	              }		
			}
          //-----------------------------------------------------------------------------

          //Iron
			if (random.nextInt(3) == 0) {
		           if (world.getBlock(i, j, k + 1) == Blocks.iron_ore) {
		                world.setBlock(i, j, k + 1, NovaCraftBlocks.grimstone_iron, 0, 2);
		           }
				}
				if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
		           if (world.getBlock(i, j, k + 1) == NovaCraftBlocks.grimstone_iron) {
		               world.setBlock(i, j, k + 1, NovaCraftBlocks.nullstone_iron, 0, 2);
		           	}
				}
				if (random.nextInt(3) == 0) {
		          if (world.getBlock(i, j, k - 1) == Blocks.iron_ore) {
		            world.setBlock(i, j, k - 1, NovaCraftBlocks.grimstone_iron, 0, 2);
		           }
				}
				if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
		          if (world.getBlock(i, j, k - 1) == NovaCraftBlocks.grimstone_iron) {
		              world.setBlock(i, j, k - 1, NovaCraftBlocks.nullstone_iron, 0, 2);
		              }
				}
				if (random.nextInt(3) == 0) {
		          if (world.getBlock(i + 1, j, k) == Blocks.iron_ore) {
		            world.setBlock(i + 1, j, k, NovaCraftBlocks.grimstone_iron, 0, 2);
		           }
				}
				if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
		          if (world.getBlock(i + 1, j, k) == NovaCraftBlocks.grimstone_iron) {
		              world.setBlock(i + 1, j, k, NovaCraftBlocks.nullstone_iron, 0, 2);
		            }
				}
				if (random.nextInt(3) == 0) {
		          if (world.getBlock(i - 1, j, k) == Blocks.iron_ore) {
		            world.setBlock(i - 1, j, k, NovaCraftBlocks.grimstone_iron, 0, 2);
		           }
				}
				if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
		          if (world.getBlock(i - 1, j, k) == NovaCraftBlocks.grimstone_iron) {
		              world.setBlock(i - 1, j, k, NovaCraftBlocks.nullstone_iron, 0, 2);
		              }
				}
				if (random.nextInt(3) == 0) {
		          if (world.getBlock(i, j + 1, k) == Blocks.iron_ore) {
		            world.setBlock(i, j + 1, k, NovaCraftBlocks.grimstone_iron, 0, 2);
		           }
				}
				if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
		          if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.grimstone_iron) {
		              world.setBlock(i, j + 1, k, NovaCraftBlocks.nullstone_iron, 0, 2);
		              }
				}
				if (random.nextInt(3) == 0) {
		          if (world.getBlock(i, j - 1, k) == Blocks.iron_ore) {
		            world.setBlock(i, j - 1, k, NovaCraftBlocks.grimstone_iron, 0, 2);
		           }
				}
				if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
		          if (world.getBlock(i, j - 1, k) == NovaCraftBlocks.grimstone_iron) {
		              world.setBlock(i, j - 1, k, NovaCraftBlocks.nullstone_iron, 0, 2);
		              }		
				}
           //-----------------------------------------------------------------------
           
           //Redstone
				if (random.nextInt(3) == 0) {
			           if (world.getBlock(i, j, k + 1) == Blocks.redstone_ore) {
			                world.setBlock(i, j, k + 1, NovaCraftBlocks.grimstone_redstone, 0, 2);
			           }
					}
					if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
			           if (world.getBlock(i, j, k + 1) == NovaCraftBlocks.grimstone_redstone) {
			               world.setBlock(i, j, k + 1, NovaCraftBlocks.nullstone_redstone, 0, 2);
			           	}
					}
					if (random.nextInt(3) == 0) {
			          if (world.getBlock(i, j, k - 1) == Blocks.redstone_ore) {
			            world.setBlock(i, j, k - 1, NovaCraftBlocks.grimstone_redstone, 0, 2);
			           }
					}
					if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
			          if (world.getBlock(i, j, k - 1) == NovaCraftBlocks.grimstone_redstone) {
			              world.setBlock(i, j, k - 1, NovaCraftBlocks.nullstone_redstone, 0, 2);
			              }
					}
					if (random.nextInt(3) == 0) {
			          if (world.getBlock(i + 1, j, k) == Blocks.redstone_ore) {
			            world.setBlock(i + 1, j, k, NovaCraftBlocks.grimstone_redstone, 0, 2);
			           }
					}
					if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
			          if (world.getBlock(i + 1, j, k) == NovaCraftBlocks.grimstone_redstone) {
			              world.setBlock(i + 1, j, k, NovaCraftBlocks.nullstone_redstone, 0, 2);
			            }
					}
					if (random.nextInt(3) == 0) {
			          if (world.getBlock(i - 1, j, k) == Blocks.redstone_ore) {
			            world.setBlock(i - 1, j, k, NovaCraftBlocks.grimstone_redstone, 0, 2);
			           }
					}
					if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
			          if (world.getBlock(i - 1, j, k) == NovaCraftBlocks.grimstone_redstone) {
			              world.setBlock(i - 1, j, k, NovaCraftBlocks.nullstone_redstone, 0, 2);
			              }
					}
					if (random.nextInt(3) == 0) {
			          if (world.getBlock(i, j + 1, k) == Blocks.redstone_ore) {
			            world.setBlock(i, j + 1, k, NovaCraftBlocks.grimstone_redstone, 0, 2);
			           }
					}
					if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
			          if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.grimstone_redstone) {
			              world.setBlock(i, j + 1, k, NovaCraftBlocks.nullstone_redstone, 0, 2);
			              }
					}
					if (random.nextInt(3) == 0) {
			          if (world.getBlock(i, j - 1, k) == Blocks.redstone_ore) {
			            world.setBlock(i, j - 1, k, NovaCraftBlocks.grimstone_redstone, 0, 2);
			           }
					}
					if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
			          if (world.getBlock(i, j - 1, k) == NovaCraftBlocks.grimstone_redstone) {
			              world.setBlock(i, j - 1, k, NovaCraftBlocks.nullstone_redstone, 0, 2);
			              }		
					}
           //--------------------------------------------------------------------------
           
           //Lapis
					if (random.nextInt(3) == 0) {
				           if (world.getBlock(i, j, k + 1) == Blocks.lapis_ore) {
				                world.setBlock(i, j, k + 1, NovaCraftBlocks.grimstone_lapis, 0, 2);
				           }
						}
						if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
				           if (world.getBlock(i, j, k + 1) == NovaCraftBlocks.grimstone_lapis) {
				               world.setBlock(i, j, k + 1, NovaCraftBlocks.nullstone_lapis, 0, 2);
				           	}
						}
						if (random.nextInt(3) == 0) {
				          if (world.getBlock(i, j, k - 1) == Blocks.lapis_ore) {
				            world.setBlock(i, j, k - 1, NovaCraftBlocks.grimstone_lapis, 0, 2);
				           }
						}
						if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
				          if (world.getBlock(i, j, k - 1) == NovaCraftBlocks.grimstone_lapis) {
				              world.setBlock(i, j, k - 1, NovaCraftBlocks.nullstone_lapis, 0, 2);
				              }
						}
						if (random.nextInt(3) == 0) {
				          if (world.getBlock(i + 1, j, k) == Blocks.lapis_ore) {
				            world.setBlock(i + 1, j, k, NovaCraftBlocks.grimstone_lapis, 0, 2);
				           }
						}
						if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
				          if (world.getBlock(i + 1, j, k) == NovaCraftBlocks.grimstone_lapis) {
				              world.setBlock(i + 1, j, k, NovaCraftBlocks.nullstone_lapis, 0, 2);
				            }
						}
						if (random.nextInt(3) == 0) {
				          if (world.getBlock(i - 1, j, k) == Blocks.lapis_ore) {
				            world.setBlock(i - 1, j, k, NovaCraftBlocks.grimstone_lapis, 0, 2);
				           }
						}
						if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
				          if (world.getBlock(i - 1, j, k) == NovaCraftBlocks.grimstone_lapis) {
				              world.setBlock(i - 1, j, k, NovaCraftBlocks.nullstone_lapis, 0, 2);
				              }
						}
						if (random.nextInt(3) == 0) {
				          if (world.getBlock(i, j + 1, k) == Blocks.lapis_ore) {
				            world.setBlock(i, j + 1, k, NovaCraftBlocks.grimstone_lapis, 0, 2);
				           }
						}
						if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
				          if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.grimstone_lapis) {
							  world.setBlock(i, j + 1, k, NovaCraftBlocks.nullstone_lapis, 0, 2);
						  }
						}
						if (random.nextInt(3) == 0) {
				          if (world.getBlock(i, j - 1, k) == Blocks.lapis_ore) {
				            world.setBlock(i, j - 1, k, NovaCraftBlocks.grimstone_lapis, 0, 2);
				           }
						}
						if (random.nextInt(15) == 0 && world.provider.dimensionId == 1) {
					          if (world.getBlock(i, j - 1, k) == NovaCraftBlocks.grimstone_lapis) {
					              world.setBlock(i, j - 1, k, NovaCraftBlocks.nullstone_lapis, 0, 2);
					        }		
						}
          //---------------------------------------------------------------------------

          //Vanite
		if (random.nextInt(5) == 0 && world.provider.dimensionId == 1) {
          if (world.getBlock(i, j, k + 1) == NovaCraftBlocks.grimstone_vanite_ore) {
                world.setBlock(i, j, k + 1, NovaCraftBlocks.nullstone_vanite_ore, 0, 2);
           }

          if (world.getBlock(i, j, k - 1) == NovaCraftBlocks.grimstone_vanite_ore) {
            world.setBlock(i, j, k - 1, NovaCraftBlocks.nullstone_vanite_ore, 0, 2);
           }

          if (world.getBlock(i + 1, j, k) == NovaCraftBlocks.grimstone_vanite_ore) {
            world.setBlock(i + 1, j, k, NovaCraftBlocks.nullstone_vanite_ore, 0, 2);
           }

          if (world.getBlock(i - 1, j, k) == NovaCraftBlocks.grimstone_vanite_ore) {
            world.setBlock(i - 1, j, k, NovaCraftBlocks.nullstone_vanite_ore, 0, 2);
           }

          if (world.getBlock(i, j + 1, k) == NovaCraftBlocks.grimstone_vanite_ore) {
            world.setBlock(i, j + 1, k, NovaCraftBlocks.nullstone_vanite_ore, 0, 2);
           }

          if (world.getBlock(i, j - 1, k) == NovaCraftBlocks.grimstone_vanite_ore) {
            world.setBlock(i, j - 1, k, NovaCraftBlocks.nullstone_vanite_ore, 0, 2);
           }
		}

		world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));
	}
	
	@Override
	public int tickRate(World world) {
		return 4000;
	}

}

