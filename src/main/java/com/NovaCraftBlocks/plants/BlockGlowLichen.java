package com.NovaCraftBlocks.plants;

import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.util.*;
import java.util.*;

import com.NovaCraft.particles.ParticleGlowLichen;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks.ISubBlocksBlock;
import com.NovaCraftBlocks.special.IEmissiveLayerBlock;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlowLichen extends BlockBush implements IEmissiveLayerBlock
{
	public static final int[] colors = new int[]{0xfbff71, 0xfbff77, 0xcfff77, 0xcfff77, 0xcfff77, 0xcfff77, 0xcfff77, 0xcfff77};
	private IIcon infusedOverlay;
    private IIcon[] icon;

    public BlockGlowLichen() {
        super(Material.plants);
        this.icon = new IIcon[2];
        this.setStepSound(ModSounds.soundMoss);
        this.setHardness(0.1f);
        this.setLightOpacity(0);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.setLightLevel(0.55F);
        this.setTickRandomly(true);
    }
    
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:glow_lichen");
        this.icon[1] = iconRegister.registerIcon("nova_craft:glow_lichen");
        infusedOverlay = iconRegister.registerIcon("nova_craft:glow_lichen_overlay");
    }
    
    public IIcon getIcon(final int side, final int meta) {
    	return this.icon[0];
    }
    
    @Override
    public int getRenderType() {
    	return RenderIDs.EMISSIVE_DOUBLE_LAYER;
    }
    
    public int damageDropped(final int meta) {
        return 0;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess access, final int x, final int y, final int z) {
        final int meta = access.getBlockMetadata(x, y, z);
        float widthMin = 0.0f;
        float heightMin = 0.0f;
        float depthMin = 0.0f;
        float widthMax = 0.0f;
        float heightMax = 0.0f;
        float depthMax = 0.0f;
        
            switch (meta) {
                case 0: {
                    widthMin = 0.0f;
                    heightMin = 0.99f;
                    depthMin = 0.0f;
                    widthMax = 0.0f;
                    heightMax = 0.0f;
                    depthMax = 0.0f;
                    break;
                }
                case 1: {
                    widthMin = 0.0f;
                    heightMin = 0.0f;
                    depthMin = 0.0f;
                    widthMax = 0.0f;
                    heightMax = 0.99f;
                    depthMax = 0.0f;
                    break;
                }
                case 2: {
                    widthMin = 0.0f;
                    heightMin = 0.0f;
                    depthMin = 0.99f;
                    widthMax = 0.0f;
                    heightMax = 0.0f;
                    depthMax = 0.0f;
                    break;
                }
                case 3: {
                    widthMin = 0.0f;
                    heightMin = 0.0f;
                    depthMin = 0.0f;
                    widthMax = 0.0f;
                    heightMax = 0.0f;
                    depthMax = 0.99f;
                    break;
                }
                case 4: {
                    widthMin = 0.99f;
                    heightMin = 0.0f;
                    depthMin = 0.0f;
                    widthMax = 0.0f;
                    heightMax = 0.0f;
                    depthMax = 0.0f;
                    break;
                }
                case 5: {
                    widthMin = 0.0f;
                    heightMin = 0.0f;
                    depthMin = 0.0f;
                    widthMax = 0.99f;
                    heightMax = 0.0f;
                    depthMax = 0.0f;
                    break;
                }
                case 6: {
                    widthMin = 0.0f;
                    heightMin = 0.99f;
                    depthMin = 0.0f;
                    widthMax = 0.0f;
                    heightMax = 0.0f;
                    depthMax = 0.0f;
                    break;
                }
                case 7: {
                    widthMin = 0.0f;
                    heightMin = 0.0f;
                    depthMin = 0.0f;
                    widthMax = 0.0f;
                    heightMax = 0.99f;
                    depthMax = 0.0f;
                    break;
                }
                case 8: {
                    widthMin = 0.0f;
                    heightMin = 0.0f;
                    depthMin = 0.99f;
                    widthMax = 0.0f;
                    heightMax = 0.0f;
                    depthMax = 0.0f;
                    break;
                }
                case 9: {
                    widthMin = 0.0f;
                    heightMin = 0.0f;
                    depthMin = 0.0f;
                    widthMax = 0.0f;
                    heightMax = 0.0f;
                    depthMax = 0.99f;
                    break;
                }
                case 10: {
                    widthMin = 0.99f;
                    heightMin = 0.0f;
                    depthMin = 0.0f;
                    widthMax = 0.0f;
                    heightMax = 0.0f;
                    depthMax = 0.0f;
                    break;
                }
                case 11: {
                    widthMin = 0.0f;
                    heightMin = 0.0f;
                    depthMin = 0.0f;
                    widthMax = 0.99f;
                    heightMax = 0.0f;
                    depthMax = 0.0f;
                    break;
                }
            }                 
        
        this.setBlockBounds(0.0f + widthMin, 0.0f + heightMin, 0.0f + depthMin, 1.0f - widthMax, 1.0f - heightMax, 1.0f - depthMax);
    }
    
    public void onNeighborBlockChange(final World world, final int i, final int j, final int k, final Block l) {
        final int md = world.getBlockMetadata(i, j, k);
        if (this.checkIfAttachedToBlock(world, i, j, k)) {
            boolean flag = false;
            if (!world.isSideSolid(i - 1, j, k, ForgeDirection.getOrientation(5)) && (md == 5 || md == 11)) {
                flag = true;
            }
            if (!world.isSideSolid(i + 1, j, k, ForgeDirection.getOrientation(4)) && (md == 4 || md == 10)) {
                flag = true;
            }
            if (!world.isSideSolid(i, j, k - 1, ForgeDirection.getOrientation(3)) && (md == 3 || md == 9)) {
                flag = true;
            }
            if (!world.isSideSolid(i, j, k + 1, ForgeDirection.getOrientation(2)) && (md == 2 || md == 8)) {
                flag = true;
            }
            if (!world.isSideSolid(i, j - 1, k, ForgeDirection.getOrientation(1)) && (md == 1 || md == 7)) {
                flag = true;
            }
            if (!world.isSideSolid(i, j + 1, k, ForgeDirection.getOrientation(0)) && (md == 0 || md == 6)) {
                flag = true;
            }
            if (flag) {
                this.dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
                world.setBlockToAir(i, j, k);
            }
        }
    }
    
    private boolean checkIfAttachedToBlock(final World world, final int i, final int j, final int k) {
        if (!this.canPlaceBlockAt(world, i, j, k)) {
            this.dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
            world.setBlockToAir(i, j, k);
            return false;
        }
        return true;
    }
    
    public boolean canPlaceBlockAt(final World world, final int i, final int j, final int k) {
        return world.isSideSolid(i - 1, j, k, ForgeDirection.getOrientation(5)) || world.isSideSolid(i + 1, j, k, ForgeDirection.getOrientation(4)) || world.isSideSolid(i, j, k - 1, ForgeDirection.getOrientation(3)) || world.isSideSolid(i, j, k + 1, ForgeDirection.getOrientation(2)) || world.isSideSolid(i, j - 1, k, ForgeDirection.getOrientation(1)) || world.isSideSolid(i, j + 1, k, ForgeDirection.getOrientation(0));
    }
    
    public boolean canBlockStay(final World world, final int i, final int j, final int k) {
        return world.isSideSolid(i - 1, j, k, ForgeDirection.getOrientation(5)) || world.isSideSolid(i + 1, j, k, ForgeDirection.getOrientation(4)) || world.isSideSolid(i, j, k - 1, ForgeDirection.getOrientation(3)) || world.isSideSolid(i, j, k + 1, ForgeDirection.getOrientation(2)) || world.isSideSolid(i, j - 1, k, ForgeDirection.getOrientation(1)) || world.isSideSolid(i, j + 1, k, ForgeDirection.getOrientation(0));
    }
    
    public int onBlockPlaced(final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ, int meta) {
        if (side == 0 && world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN)) {
            meta = 0;
        }
        if (side == 1 && world.isSideSolid(x, y - 1, z, ForgeDirection.UP)) {
            meta = 1;
        }
        if (side == 2 && world.isSideSolid(x, y, z + 1, ForgeDirection.NORTH)) {
            meta = 2;
        }
        if (side == 3 && world.isSideSolid(x, y, z - 1, ForgeDirection.SOUTH)) {
            meta = 3;
        }
        if (side == 4 && world.isSideSolid(x + 1, y, z, ForgeDirection.WEST)) {
            meta = 4;
        }
        if (side == 5 && world.isSideSolid(x - 1, y, z, ForgeDirection.EAST)) {
            meta = 5;
        }
        return meta;
    }
    
    public void updateTick(final World world, final int x, final int y, final int z, final Random rand) {
        final int meta = world.getBlockMetadata(x, y, z);
        int attempt = 0;
        if (meta <= 5) {
            final byte radius = 5;
            int distance = 3;
            for (int xx = x - radius; xx <= x + radius; ++xx) {
                for (int zz = z - radius; zz <= z + radius; ++zz) {
                    for (int yy = y - radius; yy <= y + radius; ++yy) {
                        if (world.getBlock(xx, zz, yy) == this && --distance <= 0) {
                            return;
                        }
                    }
                }
            }
            int xx = x + rand.nextInt(3) - 1;
            int yy = y + rand.nextInt(3) - 1;
            int zz = z + rand.nextInt(3) - 1;
            int offsetDir = 0;
            if (xx != x) {
                ++offsetDir;
            }
            if (yy != y) {
                ++offsetDir;
            }
            if (zz != z) {
                ++offsetDir;
            }
            if (offsetDir > 1) {
                return;
            }
            if (world.isAirBlock(xx, yy, zz)) {
                for (attempt = 0; attempt < 6; ++attempt) {
                    final int offset = 1;
                    final int randomiseSide = rand.nextInt(6);
                    switch (randomiseSide) {
                        case 0: {
                            if (!world.isSideSolid(xx, yy + offset, zz, ForgeDirection.DOWN)) {
                                break;
                            }
                            if (rand.nextInt(10) == 0) {
                                world.setBlock(xx, yy, zz, (Block)this, 6, 2);
                                break;
                            }
                            world.setBlock(xx, yy, zz, (Block)this, 0, 2);
                            break;
                        }
                        case 1: {
                            if (!world.isSideSolid(xx, yy - offset, zz, ForgeDirection.UP)) {
                                break;
                            }
                            if (rand.nextInt(10) == 0) {
                                world.setBlock(xx, yy, zz, (Block)this, 7, 2);
                                break;
                            }
                            world.setBlock(xx, yy, zz, (Block)this, 1, 2);
                            break;
                        }
                        case 2: {
                            if (!world.isSideSolid(xx, yy, zz + offset, ForgeDirection.NORTH)) {
                                break;
                            }
                            if (rand.nextInt(10) == 0) {
                                world.setBlock(xx, yy, zz, (Block)this, 8, 2);
                                break;
                            }
                            world.setBlock(xx, yy, zz, (Block)this, 2, 2);
                            break;
                        }
                        case 3: {
                            if (!world.isSideSolid(xx, yy, zz - offset, ForgeDirection.SOUTH)) {
                                break;
                            }
                            if (rand.nextInt(10) == 0) {
                                world.setBlock(xx, yy, zz, (Block)this, 9, 2);
                                break;
                            }
                            world.setBlock(xx, yy, zz, (Block)this, 3, 2);
                            break;
                        }
                        case 4: {
                            if (!world.isSideSolid(xx + offset, yy, zz, ForgeDirection.WEST)) {
                                break;
                            }
                            if (rand.nextInt(10) == 0) {
                                world.setBlock(xx, yy, zz, (Block)this, 10, 2);
                                break;
                            }
                            world.setBlock(xx, yy, zz, (Block)this, 4, 2);
                            break;
                        }
                        case 5: {
                            if (!world.isSideSolid(xx - offset, yy, zz, ForgeDirection.EAST)) {
                                break;
                            }
                            if (rand.nextInt(10) == 0) {
                                world.setBlock(xx, yy, zz, (Block)this, 11, 2);
                                break;
                            }
                            world.setBlock(xx, yy, zz, (Block)this, 5, 2);
                            break;
                        }
                    }
                }
            }
            if (rand.nextInt(5) == 0) {
                if (meta == 0) {
                    world.setBlock(x, y, z, (Block)this, 6, 2);
                }
                else if (meta == 1) {
                    world.setBlock(x, y, z, (Block)this, 7, 2);
                }
                else if (meta == 2) {
                    world.setBlock(x, y, z, (Block)this, 8, 2);
                }
                else if (meta == 3) {
                    world.setBlock(x, y, z, (Block)this, 9, 2);
                }
                else if (meta == 4) {
                    world.setBlock(x, y, z, (Block)this, 10, 2);
                }
                else if (meta == 5) {
                    world.setBlock(x, y, z, (Block)this, 11, 2);
                }
            }
        }
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		super.randomDisplayTick(world, x, y, z, rand);
		if (!world.isRemote) {
			return;
		}

		if (net.minecraft.client.Minecraft.getMinecraft().gameSettings.particleSetting == 2) {
			return;
		}

		if (this == NovaCraftBlocks.glow_lichen) {
			for (int ammount = 0; ammount < 15; ammount++) {
				double d = x + (rand.nextFloat() - 0.5D) * 10;
				double d1 = y + (rand.nextFloat() - 0.5D) * 10;
				double d2 = z + (rand.nextFloat() - 0.5D) * 10;
				double d3 = (rand.nextFloat() - 0.5D) * 0.5D;
				double d4 = (rand.nextFloat() - 0.5D) * 0.5D;
				double d5 = (rand.nextFloat() - 0.5D) * 0.5D;

				ParticleGlowLichen obj = new ParticleGlowLichen(world, d, d1, d2, d3, d4, d5);
				FMLClientHandler.instance().getClient().effectRenderer.addEffect(obj);
			}
		}
    }

	@Override
	public IIcon getSecondLayerIcon(int side, int meta) {
			return infusedOverlay;
	}

	@Override
	public int getEmissiveMinBrightness(int meta) {
		return 15;
	}
	
	@Override
	public int getEmissiveLayerColor(int meta) {
		return colors[meta % colors.length];
	}
	
	@Override
	public boolean doesEmissiveLayerHaveDirShading(int meta) {
		return false;
	}
		
}

