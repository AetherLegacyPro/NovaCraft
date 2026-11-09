package com.NovaCraftBlocks.crystals;

import java.util.List;
import java.util.Random;
import com.NovaCraft.Item.Block.ItemCopartzCluster;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.core.Utils;
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockCopartzCluster extends BlockCopartz implements ISubBlocksBlock {
	
	private final int type;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockCopartzCluster(int type) {
		super(Material.glass);
		setHardness(1.5F);
		setResistance(1.5F);
		this.setStepSound(ModSounds.soundCrystalCluster);
		setBlockTextureName("copartz_cluster");
		setBlockName(Utils.getUnlocalisedName("copartz_cluster" + (type + 1)));
		setHarvestLevel("pickaxe", 0);
		this.lightValue = 1;
		this.type = type;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(3, 520, 0));

		}	
	}
	
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
    	int meta = world.getBlockMetadata(x, y, z);
        return getLightValue() + (type * 3) + (meta / 6);
    }

   public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
   {
        return NovaCraftItems.copartz_shard;
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

    public int getDamageValue(World world, int p_149643_2_, int p_149643_3_, int p_149643_4_)
    {
        return world.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_) < 6 ? 0 : 6;
    }
    
    public int quantityDropped(int meta, int fortune, Random random)
    {
    	if(this == NovaCraftBlocks.copartz_cluster_2 && meta >= 6) {
    		int drop = quantityDropped(random);
    		if(fortune > 0 && harvestingWithPickaxe() && random.nextInt(2 + fortune) == 0) {
    			drop += 4 * fortune;
    		}
        	return drop;
    	}
    	return 0;
    }

    public int quantityDropped(Random random)
    {
    	if(harvestingWithPickaxe()) {
            return 4;
    	}
    	return 2;
    }
    
    private boolean harvestingWithPickaxe() {
    	return harvesters.get() != null && harvesters.get().getCurrentEquippedItem() != null && harvesters.get().getCurrentEquippedItem().getItem().getToolClasses(harvesters.get().getCurrentEquippedItem()).contains("pickaxe");
    }

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
		return side + meta;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
    	int meta = world.getBlockMetadata(x, y, z);

    	float height = (meta < 6 ? 0.125F : 0.1875F) + (type == 1 ? 0.1875F : 0.0625F);
    	float xzOffset = meta < 6 && type == 0 ? .25F : .1875F;
    	if(meta >= 6 && type == 1) {
    		height += .0625F;
    	}

		switch (meta % 6) {
		case 0:
			return AxisAlignedBB.getBoundingBox(x+xzOffset, y+1 - height, z+xzOffset, x+1 - xzOffset, y+1.0F, z+1 - xzOffset);
		case 1:
			return AxisAlignedBB.getBoundingBox(x+xzOffset, y, z+xzOffset, x+1 - xzOffset, y+height, z+1 - xzOffset);
		case 2:
			return AxisAlignedBB.getBoundingBox(x+xzOffset, y+xzOffset, z+1 - height, x+1 - xzOffset, y+1 - xzOffset, z+1.0F);
		case 3:
			return AxisAlignedBB.getBoundingBox(x+xzOffset, y+xzOffset, z, x+1 - xzOffset, y+1 - xzOffset, z+height);
		case 4:
			return AxisAlignedBB.getBoundingBox(x+1 - height, y+xzOffset, z+xzOffset, x+1.0F, y+1 - xzOffset, z+1 - xzOffset);
		case 5:
			return AxisAlignedBB.getBoundingBox(x, y+xzOffset, z+xzOffset, x+height, y+1 - xzOffset, z+1 - xzOffset);
		}
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

    protected void checkAndDropBlock(World world, int p_149855_2_, int p_149855_3_, int p_149855_4_)
    {
        if (!this.canBlockStay(world, p_149855_2_, p_149855_3_, p_149855_4_))
        {
            this.dropBlockAsItem(world, p_149855_2_, p_149855_3_, p_149855_4_, world.getBlockMetadata(p_149855_2_, p_149855_3_, p_149855_4_), 0);
            world.setBlockToAir(p_149855_2_, p_149855_3_, p_149855_4_);
        }
    }

	@Override
    public void onNeighborBlockChange(World world, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block block)
    {
        super.onNeighborBlockChange(world, p_149695_2_, p_149695_3_, p_149695_4_, block);
        this.checkAndDropBlock(world, p_149695_2_, p_149695_3_, p_149695_4_);
    }
    
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return this.canPlaceBlockOnSide(world, x, y, z, world.getBlockMetadata(x, y, z));
	}
	
	@Override
    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
    {
		EnumFacing facing = EnumFacing.getFront(side);
		return world.getBlock(x - facing.getFrontOffsetX(), y - facing.getFrontOffsetY(), z - facing.getFrontOffsetZ()).isOpaqueCube();
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return this.icons[p_149691_2_ < 6 ? 0 : 1];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iIconRegister)
	{
		icons = new IIcon[2];
		if(type == 0) {
			icons[0] = iIconRegister.registerIcon("nova_craft:copartz_bud");
			icons[1] = iIconRegister.registerIcon("nova_craft:copartz_medium_bud");
		}
		if(type == 1) {
			icons[0] = iIconRegister.registerIcon("nova_craft:copartz_large_bud");
			icons[1] = iIconRegister.registerIcon("nova_craft:copartz_cluster");
		}
		super.registerBlockIcons(iIconRegister);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 6));
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
		return RenderIDs.COPARTZ_CLUSTER;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemCopartzCluster.class;
	}
        
    
}

