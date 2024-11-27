package com.NovaCraftBlocks.sculk;

import java.util.List;
import java.util.Random;

import com.NovaCraft.Item.Block.ItemSculkTentacle;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.core.Utils;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks.ISubBlocksBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;


public class BlockSculkTentacle extends BlockSculk implements ISubBlocksBlock {
	
	private final int type;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockSculkTentacle(int type) {
		super();
		setHardness(0.2F);
		setResistance(0.2F);
		this.setStepSound(ModSounds.soundSculkVein);
		setBlockName(Utils.getUnlocalisedName("sculk_tentacle" + (type + 1)));
		setHarvestLevel("shovel", 0);
		this.type = type;
		this.setTickRandomly(true);
	}
	
	protected boolean canPlaceBlockOn(Block p_149854_1_)
	  {
	       return p_149854_1_ == NovaCraftBlocks.sculk_block;
	  }
    
    protected ItemStack createStackedBlock(int p_149644_1_)
    {
        int j = 0;
        Item item = Item.getItemFromBlock(this);

        if (item != null && item.getHasSubtypes())
        {
            j = p_149644_1_ < 6 ? 0 : 6;
        }

        return new ItemStack(item, 1, j);
    }
	
    protected boolean canSilkHarvest()
    {
    	return true;
    }

    public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_)
    {
        return p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_) < 6 ? 0 : 6;
    }
    
    public int quantityDropped(int meta, int fortune, Random random)
    {
    	if(this == NovaCraftBlocks.sculk_tentacle_2 && meta >= 6) {
    		int drop = quantityDropped(random);
    		if(fortune > 0 && harvestingWithHoe() && random.nextInt(2 + fortune) == 0) {
    			drop += 4 * fortune;
    		}
        	return drop;
    	}
    	return 0;
    }

    public int quantityDropped(Random p_149745_1_)
    {
    	if(harvestingWithHoe()) {
            return 4;
    	}
    	return 2;
    }
    
    private boolean harvestingWithHoe() {
    	return harvesters.get() != null && harvesters.get().getCurrentEquippedItem() != null && harvesters.get().getCurrentEquippedItem().getItem().getToolClasses(harvesters.get().getCurrentEquippedItem()).contains("axe");
    }
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}

    @Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z) {
    	int meta = access.getBlockMetadata(x, y, z);

    	float height = (meta < 6 ? 0.125F : 0.1875F) + (type == 1 ? 0.1875F : 0.0625F);
    	float xzOffset = meta < 6 && type == 0 ? .25F : .1875F;
    	if(meta >= 6 && type == 1) {
    		height += .0625F;
    	}

		switch (meta % 6) {
		case 0:
			this.setBlockBounds(xzOffset, 1 - height, xzOffset, 1 - xzOffset, 1.0F, 1 - xzOffset);
			break;
		case 1:
			this.setBlockBounds(xzOffset, 0.0F, xzOffset, 1 - xzOffset, height, 1 - xzOffset);
			break;
		case 2:
			this.setBlockBounds(xzOffset, xzOffset, 1 - height, 1 - xzOffset, 1 - xzOffset, 1.0F);
			break;
		case 3:
			this.setBlockBounds(xzOffset, xzOffset, 0.0F, 1 - xzOffset, 1 - xzOffset, height);
			break;
		case 4:
			this.setBlockBounds(1 - height, xzOffset, xzOffset, 1.0F, 1 - xzOffset, 1 - xzOffset);
			break;
		case 5:
			this.setBlockBounds(0.0F, xzOffset, xzOffset, height, 1 - xzOffset, 1 - xzOffset);
			break;
		}
    }

    protected void checkAndDropBlock(World p_149855_1_, int p_149855_2_, int p_149855_3_, int p_149855_4_)
    {
        if (!this.canBlockStay(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_))
        {
            this.dropBlockAsItem(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_, p_149855_1_.getBlockMetadata(p_149855_2_, p_149855_3_, p_149855_4_), 0);
            p_149855_1_.setBlockToAir(p_149855_2_, p_149855_3_, p_149855_4_);
        }
    }
    
    @Override 
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
            if (world.isAirBlock(xx, yy, zz) && (world.getBlock(xx, yy + 1, zz)  == NovaCraftBlocks.sculk_block || world.getBlock(xx, yy - 1, zz)  == NovaCraftBlocks.sculk_block || world.getBlock(xx + 1, yy, zz)  == NovaCraftBlocks.sculk_block || world.getBlock(xx - 1, yy, zz)  == NovaCraftBlocks.sculk_block || world.getBlock(xx, yy, zz + 1)  == NovaCraftBlocks.sculk_block || world.getBlock(xx, yy, zz - 1)  == NovaCraftBlocks.sculk_block)
            		&& world.getBlockLightValue(x, y + 1, z) <= 3 && y <= 25.0D) {
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return this.icons[p_149691_2_ < 6 ? 0 : 1];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		icons = new IIcon[2];
		if(type == 0) {
			icons[0] = p_149651_1_.registerIcon("nova_craft:sculktentaclesmall");
			icons[1] = p_149651_1_.registerIcon("nova_craft:sculktentaclesmall");
		}
		if(type == 1) {
			icons[0] = p_149651_1_.registerIcon("nova_craft:SculkSensorAnimation");
			icons[1] = p_149651_1_.registerIcon("nova_craft:SculkSensorAnimation");
		}
		super.registerBlockIcons(p_149651_1_);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
	{
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 6));
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIDs.SCULK_TENTACLE;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemSculkTentacle.class;
	}
	
	
	 @Override
	    @SideOnly(Side.CLIENT)
	    public void randomDisplayTick(final World p_149734_1_, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random p_149734_5_) {
	        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
	        if (p_149734_5_.nextInt(15) == 0) {
	            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.4f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.6f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.9f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	            ParticleHandler.SCULK.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
	        }	
	        
	    }
}
