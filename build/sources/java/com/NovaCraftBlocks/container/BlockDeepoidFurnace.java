package com.NovaCraftBlocks.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import com.NovaCraft.NovaCraft;
import com.NovaCraft.TileEntity.TileEntityDeepoidFurnace;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockDeepoidFurnace extends BlockContainer
{
    private final Random rand = new Random();
    private final boolean smelting;
    
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    public IIcon iconFront;
    private static boolean field_149934_M;

    public BlockDeepoidFurnace(boolean smelting)
    {
    	super(Material.iron);
        this.setStepSound(ModSounds.soundNullstone);
        this.smelting = smelting;
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(10);
		this.setResistance(10);
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return Item.getItemFromBlock(NovaCraftBlocks.deepoid_furnace);
    }

    public void onBlockAdded(World world, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(world, p_149726_2_, p_149726_3_, p_149726_4_);
        this.func_149930_e(world, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    private void func_149930_e(World world, int p_149930_2_, int p_149930_3_, int p_149930_4_)
    {
        if (!world.isRemote)
        {
            Block block = world.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
            Block block1 = world.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
            Block block2 = world.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
            Block block3 = world.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int p_149691_1_, final int p_149691_2_) {
        return (p_149691_1_ == 1) ? this.iconTop : ((p_149691_1_ == 0) ? this.iconTop : ((p_149691_1_ != p_149691_2_) ? ((p_149691_1_ == 3 && p_149691_2_ == 0) ? this.iconFront : this.blockIcon) : this.iconFront));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("nova_craft:deepoid_furnace_side");
        this.iconTop = iconRegister.registerIcon("nova_craft:deepoid_furnace_top");
        if (this.smelting) {
        	this.iconFront = iconRegister.registerIcon("nova_craft:deepoid_furnace_face_on");
        }
        else {
        	this.iconFront = iconRegister.registerIcon("nova_craft:deepoid_furnace_face_off");
        }
    }

    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        final TileEntityDeepoidFurnace furnace = (TileEntityDeepoidFurnace)world.getTileEntity(x, y, z);
        	if ((furnace != null) && (world.getBlock(x + 1, y - 1, z) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x - 1, y - 1, z) == NovaCraftBlocks.deepoid_bricks) 
        		&& (world.getBlock(x - 1, y - 1, z - 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x, y - 1, z - 1) == NovaCraftBlocks.deepoid_bricks) 
        		&& (world.getBlock(x + 1, y - 1, z - 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x + 1, y - 1, z - 2) == NovaCraftBlocks.deepoid_bricks)
        		&& (world.getBlock(x, y - 1, z - 2) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x - 1, y - 1, z - 2) == NovaCraftBlocks.deepoid_bricks)
        		&& (world.getBlock(x, y, z - 1) == NovaCraftBlocks.deepoid_power_core) && (world.getBlock(x - 1, y, z - 1) == NovaCraftBlocks.deepoid_bricks)
        		&& (world.getBlock(x + 1, y, z - 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x, y, z - 2) == NovaCraftBlocks.deepoid_bricks)
        		&& (world.getBlock(x, y + 1, z - 1) == NovaCraftBlocks.deepoid_bricks)) {
        			player.openGui((Object)NovaCraft.instance, 5, world, x, y, z);
        	return true;
        	}
        	else if ((furnace != null) && (world.getBlock(x + 1, y - 1, z) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x - 1, y - 1, z) == NovaCraftBlocks.deepoid_bricks) 
            	&& (world.getBlock(x - 1, y - 1, z + 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x, y - 1, z + 1) == NovaCraftBlocks.deepoid_bricks) 
            	&& (world.getBlock(x + 1, y - 1, z + 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x + 1, y - 1, z + 2) == NovaCraftBlocks.deepoid_bricks)
            	&& (world.getBlock(x, y - 1, z + 2) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x - 1, y - 1, z + 2) == NovaCraftBlocks.deepoid_bricks)
            	&& (world.getBlock(x, y, z + 1) == NovaCraftBlocks.deepoid_power_core) && (world.getBlock(x - 1, y, z + 1) == NovaCraftBlocks.deepoid_bricks)
            	&& (world.getBlock(x + 1, y, z + 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x, y, z + 2) == NovaCraftBlocks.deepoid_bricks)
            	&& (world.getBlock(x, y + 1, z + 1) == NovaCraftBlocks.deepoid_bricks)) {
            		player.openGui((Object)NovaCraft.instance, 5, world, x, y, z);
            	return true;
            	}
        	else if ((furnace != null) && (world.getBlock(x, y - 1, z + 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x, y - 1, z - 1) == NovaCraftBlocks.deepoid_bricks)
        		&& (world.getBlock(x + 1, y - 1, z - 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x + 1, y - 1, z + 1) == NovaCraftBlocks.deepoid_bricks)
        		&& (world.getBlock(x + 1, y - 1, z) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x + 2, y - 1, z - 1) == NovaCraftBlocks.deepoid_bricks)
        		&& (world.getBlock(x + 2, y - 1, z) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x + 2, y - 1, z + 1) == NovaCraftBlocks.deepoid_bricks)
        		&& (world.getBlock(x + 1, y, z) == NovaCraftBlocks.deepoid_power_core) && (world.getBlock(x + 1, y, z + 1) == NovaCraftBlocks.deepoid_bricks)
        		&& (world.getBlock(x + 1, y, z - 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x + 2, y, z) == NovaCraftBlocks.deepoid_bricks)
        		&& (world.getBlock(x + 1, y + 1, z) == NovaCraftBlocks.deepoid_bricks))  {
        			player.openGui((Object)NovaCraft.instance, 5, world, x, y, z);
        		return true;
    			}
        	else if ((furnace != null) && (world.getBlock(x, y - 1, z + 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x, y - 1, z - 1) == NovaCraftBlocks.deepoid_bricks)
            		&& (world.getBlock(x - 1, y - 1, z - 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x - 1, y - 1, z + 1) == NovaCraftBlocks.deepoid_bricks)
            		&& (world.getBlock(x - 1, y - 1, z) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x - 2, y - 1, z - 1) == NovaCraftBlocks.deepoid_bricks)
            		&& (world.getBlock(x - 2, y - 1, z) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x - 2, y - 1, z + 1) == NovaCraftBlocks.deepoid_bricks)
            		&& (world.getBlock(x - 1, y, z) == NovaCraftBlocks.deepoid_power_core) && (world.getBlock(x - 1, y, z + 1) == NovaCraftBlocks.deepoid_bricks)
            		&& (world.getBlock(x - 1, y, z - 1) == NovaCraftBlocks.deepoid_bricks) && (world.getBlock(x - 2, y, z) == NovaCraftBlocks.deepoid_bricks)
            		&& (world.getBlock(x - 1, y + 1, z) == NovaCraftBlocks.deepoid_bricks))  {
            			player.openGui((Object)NovaCraft.instance, 5, world, x, y, z);
            	return true;
        		}
        	else {
        		if (world.isRemote) {
                	player.addChatComponentMessage(new ChatComponentText(I18n.format("gui.deepoid_furnace.invalid_structure")));
                	}
        		return false;
        	}
    }

    public static void updateFurnaceBlockState(boolean p_149931_0_, World world, int p_149931_2_, int p_149931_3_, int p_149931_4_)
    {
        int l = world.getBlockMetadata(p_149931_2_, p_149931_3_, p_149931_4_);
        TileEntity tileentity = world.getTileEntity(p_149931_2_, p_149931_3_, p_149931_4_);
        field_149934_M = true;

        if (p_149931_0_)
        {
            world.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, NovaCraftBlocks.lit_deepoid_furnace);
        }
        else
        {
            world.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, NovaCraftBlocks.deepoid_furnace);
        }

        field_149934_M = false;
        world.setBlockMetadataWithNotify(p_149931_2_, p_149931_3_, p_149931_4_, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(p_149931_2_, p_149931_3_, p_149931_4_, tileentity);
        }
    }

    public TileEntity createNewTileEntity(World world, int p_149915_2_)
    {
        return new TileEntityDeepoidFurnace();
    }

    public void onBlockPlacedBy(World world, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase entityLivingBase, ItemStack stack)
    {
        int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
        }

        if (stack.hasDisplayName())
        {
            ((TileEntityDeepoidFurnace)world.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(stack.getDisplayName());
        }
    }

    public void breakBlock(World world, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block block, int p_149749_6_)
    {
        if (!field_149934_M)
        {
        	TileEntityDeepoidFurnace tileentityfurnace = (TileEntityDeepoidFurnace)world.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

            if (tileentityfurnace != null)
            {
                for (int i1 = 0; i1 < tileentityfurnace.getSizeInventory(); ++i1)
                {
                    ItemStack itemstack = tileentityfurnace.getStackInSlot(i1);

                    if (itemstack != null)
                    {
                        float f = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int j1 = this.rand.nextInt(21) + 10;

                            if (j1 > itemstack.stackSize)
                            {
                                j1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(world, (double)((float)p_149749_2_ + f), (double)((float)p_149749_3_ + f1), (double)((float)p_149749_4_ + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                world.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, block);
            }
        }

        super.breakBlock(world, p_149749_2_, p_149749_3_, p_149749_4_, block, p_149749_6_);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random random)
    {
        if (this.smelting)
        {
            int l = world.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
            float f = (float)p_149734_2_ + 0.5F;
            float f1 = (float)p_149734_3_ + 0.0F + random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)p_149734_4_ + 0.5F;
            float f3 = 0.52F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
                world.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5)
            {
                world.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World world, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_)
    {
        return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(p_149736_2_, p_149736_3_, p_149736_4_));
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemFromBlock(NovaCraftBlocks.deepoid_furnace);
    }
}
