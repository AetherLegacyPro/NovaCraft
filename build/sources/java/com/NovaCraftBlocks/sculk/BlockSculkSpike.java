package com.NovaCraftBlocks.sculk;

import java.util.List;
import java.util.Random;
import com.NovaCraft.Item.Block.ItemSculkSpike;
import com.NovaCraft.core.Utils;
import com.NovaCraft.entity.EntitySculkAbomination;
import com.NovaCraft.entity.EntitySculkSymbiote;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraft.sounds.ModSounds;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSculkSpike extends Block implements ISubBlocksBlock {
	
	private final int type;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockSculkSpike(int type) {
		super(Material.plants);
		setHardness(1.5F);
		setResistance(1.5F);
		this.setStepSound(ModSounds.soundSculkVein);
		setBlockName(Utils.getUnlocalisedName("sculkspike" + (type + 1)));
		setHarvestLevel("axe", 0);
		this.type = type;
		setTickRandomly(true);
	}

   public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
   {
        return null;
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
    
    @Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {		
    	
 		if (entity instanceof EntityPlayer) {
 			int rand = (int)(1 + Math.random() * 10);
 			if (rand == 1 && !entity.isSneaking()) {
 			world.playSoundEffect(x, y, z, "nova_craft:warden_altar.shriek", 2.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.2F + 0.9F);
 			EntitySculkSymbiote sculk = new EntitySculkSymbiote(world);
 			sculk.setPosition(x + 0.5D, y + 1D, z + 0.5D);

				if (!world.isRemote) {
					world.spawnEntityInWorld(sculk);		
				}
				
 			}
 			int rand2 = (int)(1 + Math.random() * 75);
 			if (rand2 == 10 && !entity.isSneaking()) {
 	 			world.playSoundEffect(x, y, z, "nova_craft:warden_altar.shriek", 3.0F, world.rand.nextFloat() - world.rand.nextFloat() * 0.25F + 0.95F);
 	 			EntitySculkAbomination sculk2 = new EntitySculkAbomination(world);
 	 			sculk2.setPosition(x + 0.5D, y + 1D, z + 0.5D);

 					if (!world.isRemote) {
 						world.spawnEntityInWorld(sculk2);		
 					}
 					
 	 		}
 		}
 	}
    
    public void onBlockDestroyedByPlayer(World world, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_)
    { 
 		
        if (!world.isRemote)
        {       	
        	int rand = (int)(1 + Math.random() * 4);
    		switch (rand)
          {
          	case 1:
          	EntitySculkSymbiote entitysilverfish = new EntitySculkSymbiote(world);
            entitysilverfish.setLocationAndAngles((double)p_149664_2_ + 0.5D, (double)p_149664_3_, (double)p_149664_4_ + 0.5D, 0.0F, 0.0F);
            world.spawnEntityInWorld(entitysilverfish);
            entitysilverfish.spawnExplosionParticle();
            	break;
          	case 2:
          		break;
          	case 3:
              	break;	
          	case 4:
              	break;	
          		
          }
        }

        super.onBlockDestroyedByPlayer(world, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_);
    }

    public int getDamageValue(World world, int p_149643_2_, int p_149643_3_, int p_149643_4_)
    {
        return world.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_) < 6 ? 0 : 6;
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
	public IIcon getIcon(int side, int meta)
	{
		if (meta < 0 || meta >= this.icons.length) {
            meta = 1;
        }
		
		return this.icons[meta < 6 ? 0 : 1];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		icons = new IIcon[1];
		if(type == 0) {
			icons[0] = p_149651_1_.registerIcon("nova_craft:sculkspike");
		}
		super.registerBlockIcons(p_149651_1_);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		list.add(new ItemStack(item, 1, 0));
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
		return RenderIDs.SCULK_SPIKE;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemSculkSpike.class;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
			((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.wither.id, 100, 0));
		
		}
		
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World world, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random random) {
        super.randomDisplayTick(world, p_149734_2_, p_149734_3_, p_149734_4_, random);
        if (random.nextInt(15) == 0) {
            ParticleHandler.SCULK.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.4f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.6f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.9f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }	
        
    }
	
	@Override
	public int tickRate(World world) {
		return 2500;
	}
}
