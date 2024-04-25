package com.NovaCraft.Items.Buckets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class ItemVaniteBucket extends Item
{
    /** field for checking if the bucket has been filled. */
    private Block isFull;
    private static final String __OBFID = "CL_00000000";

    public ItemVaniteBucket(Block p_i45331_1_)
    {
        this.maxStackSize = 1;
        this.isFull = p_i45331_1_;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        boolean flag = this.isFull == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, flag);

        if (movingobjectposition == null)
        {
            return p_77659_1_;
        }
        else
        {
            FillBucketEvent event = new FillBucketEvent(p_77659_3_, p_77659_1_, p_77659_2_, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return p_77659_1_;
            }

            if (event.getResult() == Event.Result.ALLOW)
            {
                if (p_77659_3_.capabilities.isCreativeMode)
                {
                    return p_77659_1_;
                }

                if (--p_77659_1_.stackSize <= 0)
                {
                    return event.result;
                }

                if (!p_77659_3_.inventory.addItemStackToInventory(event.result))
                {
                    p_77659_3_.dropPlayerItemWithRandomChoice(event.result, false);
                }

                return p_77659_1_;
            }
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!p_77659_2_.canMineBlock(p_77659_3_, i, j, k))
                {
                    return p_77659_1_;
                }

                if (flag)
                {
                    if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
                    {
                        return p_77659_1_;
                    }

                    Block block = p_77659_2_.getBlock(i, j, k);
                    int l = p_77659_2_.getBlockMetadata(i, j, k);
                    	if (block == Blocks.water && l == 0)
                    	{
                    		p_77659_2_.setBlockToAir(i, j, k);
                    		return this.fillBucket(p_77659_1_, p_77659_3_, NovaCraftItems.vanite_bucket_water);
                    	}

                    	else if (block == Blocks.lava && l == 0) 
                        {
                    		p_77659_2_.setBlockToAir(i, j, k);
                            return this.fillBucket(p_77659_1_, p_77659_3_, NovaCraftItems.vanite_bucket_lava);
                        }
                    	
                    	else if (block == NovaCraftBlocks.blazlinite && l == 0) 
                        {
                    		p_77659_2_.setBlockToAir(i, j, k);
                    		p_77659_3_.triggerAchievement(AchievementsNovaCraft.extreme_heat);
                            return this.fillBucket(p_77659_1_, p_77659_3_, NovaCraftItems.vanite_bucket_blazlinite);
                        }
                    	
                    	else if (block == NovaCraftBlocks.molten_vanite && l == 0) 
                        {
                    		p_77659_2_.setBlockToAir(i, j, k);
                    		p_77659_3_.triggerAchievement(AchievementsNovaCraft.molten_vanite);
                            return this.fillBucket(p_77659_1_, p_77659_3_, NovaCraftItems.vanite_bucket_molten_vanite);
                        }
                }
                else
                {
                    if (this.isFull == Blocks.air)
                    {
                        return new ItemStack(NovaCraftItems.vanite_bucket);
                    }

                    if (movingobjectposition.sideHit == 0)
                    {
                        --j;
                    }

                    if (movingobjectposition.sideHit == 1)
                    {
                        ++j;
                    }

                    if (movingobjectposition.sideHit == 2)
                    {
                        --k;
                    }

                    if (movingobjectposition.sideHit == 3)
                    {
                        ++k;
                    }

                    if (movingobjectposition.sideHit == 4)
                    {
                        --i;
                    }

                    if (movingobjectposition.sideHit == 5)
                    {
                        ++i;
                    }

                    if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
                    {
                        return p_77659_1_;
                    }

                    if (this.tryPlaceContainedLiquid(p_77659_2_, i, j, k) && !p_77659_3_.capabilities.isCreativeMode)
                    {
                        return new ItemStack(NovaCraftItems.vanite_bucket);
                    }
                }
            }

            return p_77659_1_;
        }
    }

    private ItemStack fillBucket(ItemStack p_150910_1_, EntityPlayer p_150910_2_, Item p_150910_3_)
    {
        if (p_150910_2_.capabilities.isCreativeMode)
        {
            return p_150910_1_;
        }
        else if (--p_150910_1_.stackSize <= 0)
        {
            return new ItemStack(p_150910_3_);
        }
        else
        {
            if (!p_150910_2_.inventory.addItemStackToInventory(new ItemStack(p_150910_3_)))
            {
                p_150910_2_.dropPlayerItemWithRandomChoice(new ItemStack(p_150910_3_, 1, 0), false);
            }

            return p_150910_1_;
        }
    }

    /**
     * Attempts to place the liquid contained inside the bucket.
     */
    public boolean tryPlaceContainedLiquid(World p_77875_1_, int p_77875_2_, int p_77875_3_, int p_77875_4_)
    {
        if (this.isFull == Blocks.air)
        {
            return false;
        }
        else
        {
        	Material material = p_77875_1_.getBlock(p_77875_2_, p_77875_3_, p_77875_4_).getMaterial();
            boolean flag = !material.isSolid();

            if (!p_77875_1_.isAirBlock(p_77875_2_, p_77875_3_, p_77875_4_) && !flag)
            {
                return false;
            }
            else
            {
                if (p_77875_1_.provider.isHellWorld && this.isFull == Blocks.flowing_water)
                {
                    p_77875_1_.playSoundEffect((double)((float)p_77875_2_ + 0.5F), (double)((float)p_77875_3_ + 0.5F), (double)((float)p_77875_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_77875_1_.rand.nextFloat() - p_77875_1_.rand.nextFloat()) * 0.8F);

                    for (int l = 0; l < 8; ++l)
                    {
                        p_77875_1_.spawnParticle("largesmoke", (double)p_77875_2_ + Math.random(), (double)p_77875_3_ + Math.random(), (double)p_77875_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
                    }
                }
                else if (this.isFull == Blocks.flowing_water)
                {
                    if (!p_77875_1_.isRemote && flag && !material.isLiquid())
                    {
                    	p_77875_1_.func_147480_a(p_77875_2_, p_77875_3_, p_77875_4_, true);
                    }

                    p_77875_1_.setBlock(p_77875_2_, p_77875_3_, p_77875_4_, this.isFull, 0, 3);
                }
                else if (this.isFull == Blocks.flowing_lava)
                {
                    if (!p_77875_1_.isRemote && flag && !material.isLiquid())
                    {
                    	p_77875_1_.func_147480_a(p_77875_2_, p_77875_3_, p_77875_4_, true);
                    }

                    p_77875_1_.setBlock(p_77875_2_, p_77875_3_, p_77875_4_, this.isFull, 0, 3);
                }                             

                return true;
            }
        }
    }
  
}
