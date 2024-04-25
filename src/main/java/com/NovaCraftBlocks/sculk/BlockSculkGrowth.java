package com.NovaCraftBlocks.sculk;

import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraftforge.common.util.*;
import java.util.*;

import com.NovaCraft.particles.ParticleDarkLichen;
import com.NovaCraft.particles.ParticleDarkLichenThree;
import com.NovaCraft.particles.ParticleDarkLichenTwo;
import com.NovaCraft.particles.ParticleGlowLichen;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSculkGrowth extends BlockBush
{
	private static final String[] types;
    private IIcon[] icon;
    
    public BlockSculkGrowth() {
        super(Material.plants);
        this.icon = new IIcon[2];
        this.setStepSound(ModSounds.soundSculkVein);
        this.setHardness(0.2f);
        this.setLightOpacity(0);
        this.func_150089_b(0);
        this.setCreativeTab(NovaCraftCreativeTabs.blocks);
        this.setTickRandomly(true);
    }
    
    protected boolean canPlaceBlockOn(Block p_149854_1_)
    {
        return (p_149854_1_ == NovaCraftBlocks.grimstone || p_149854_1_ == NovaCraftBlocks.nullstone || p_149854_1_ == NovaCraftBlocks.sculk_block || 
        		p_149854_1_ == NovaCraftBlocks.sculk_deepslate || p_149854_1_ == NovaCraftBlocks.sculk_grimstone || p_149854_1_ == NovaCraftBlocks.sculk_stone);
    }

    
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.icon[0] = iconRegister.registerIcon("nova_craft:sculk");
        this.icon[1] = iconRegister.registerIcon("nova_craft:sculk");
    }
	
    public IIcon getIcon(final int side, int meta) {
        if (meta < 0 || meta >= this.icon.length) {
            meta = 1;
        }
        return this.icon[meta];
    }
	
	public void getSubBlocks(final Item block, final CreativeTabs creativeTabs, final List list) {
        for (int i = 0; i < BlockSculkGrowth.types.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }
    
    public int getRenderType() {
        return 0;
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
    
    public void setBlockBoundsForItemRender() {
        this.func_150089_b(0);
    }
    
    protected void func_150089_b(final int p_150089_1_) {
        final byte b0 = 0;
        final float f = 1 * (1 + b0) / 16.0f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
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
                    heightMin = 0.95f;
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
                    heightMax = 0.95f;
                    depthMax = 0.0f;
                    break;
                }
                case 2: {
                    widthMin = 0.0f;
                    heightMin = 0.0f;
                    depthMin = 0.95f;
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
                    depthMax = 0.95f;
                    break;
                }
                case 4: {
                    widthMin = 0.95f;
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
                    widthMax = 0.95f;
                    heightMax = 0.0f;
                    depthMax = 0.0f;
                    break;
                }
                case 6: {
                    widthMin = 0.0f;
                    heightMin = 0.95f;
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
                    heightMax = 0.95f;
                    depthMax = 0.0f;
                    break;
                }
                case 8: {
                    widthMin = 0.0f;
                    heightMin = 0.0f;
                    depthMin = 0.95f;
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
                    depthMax = 0.95f;
                    break;
                }
                case 10: {
                    widthMin = 0.95f;
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
                    widthMax = 0.95f;
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
    
    static {
        types = new String[] { "default" };
    }
    
    protected boolean canSilkHarvest()
    {
    	return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World p_149734_1_, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random p_149734_5_) {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
        if (p_149734_5_.nextInt(20) == 0) {
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.4f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.6f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.9f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }	
        
    }
}




