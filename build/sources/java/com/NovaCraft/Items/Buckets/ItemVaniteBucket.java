package com.NovaCraft.Items.Buckets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class ItemVaniteBucket extends Item
{
    private Block isFull;

    public ItemVaniteBucket(Block block)
    {
        this.maxStackSize = 1;
        this.isFull = block;
        this.setCreativeTab(NovaCraftCreativeTabs.items);
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        boolean flag = this.isFull == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, entityPlayer, flag);

        if (movingobjectposition == null)
        {
            return itemStack;
        }
        else
        {
            FillBucketEvent event = new FillBucketEvent(entityPlayer, itemStack, world, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return itemStack;
            }

            if (event.getResult() == Event.Result.ALLOW)
            {
                if (entityPlayer.capabilities.isCreativeMode)
                {
                    return itemStack;
                }

                if (--itemStack.stackSize <= 0)
                {
                    return event.result;
                }

                if (!entityPlayer.inventory.addItemStackToInventory(event.result))
                {
                    entityPlayer.dropPlayerItemWithRandomChoice(event.result, false);
                }

                return itemStack;
            }
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!world.canMineBlock(entityPlayer, i, j, k))
                {
                    return itemStack;
                }

                if (flag)
                {
                    if (!entityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack))
                    {
                        return itemStack;
                    }

                    Block block = world.getBlock(i, j, k);
                    int l = world.getBlockMetadata(i, j, k);
                    	if (block == Blocks.water && l == 0)
                    	{
                    		world.setBlockToAir(i, j, k);
                    		return this.fillBucket(itemStack, entityPlayer, NovaCraftItems.vanite_bucket_water);
                    	}

                    	else if (block == Blocks.lava && l == 0) 
                        {
                    		world.setBlockToAir(i, j, k);
                            return this.fillBucket(itemStack, entityPlayer, NovaCraftItems.vanite_bucket_lava);
                        }

                        else if (block == NovaCraftBlocks.mercury && l == 0)
                        {
                            world.setBlockToAir(i, j, k);
                            return this.fillBucket(itemStack, entityPlayer, NovaCraftItems.vanite_bucket_mercury);
                        }
                    	
                    	else if (block == NovaCraftBlocks.blazlinite && l == 0 && world.getBlock(i,j - 1,k) != NovaCraftBlocks.iridium_bricks)
                        {
                    		world.setBlockToAir(i, j, k);
                    		entityPlayer.triggerAchievement(AchievementsNovaCraft.extreme_heat);
                            return this.fillBucket(itemStack, entityPlayer, NovaCraftItems.vanite_bucket_blazlinite);
                        }
                    	
                    	else if (block == NovaCraftBlocks.molten_vanite && l == 0) 
                        {
                    		world.setBlockToAir(i, j, k);
                    		entityPlayer.triggerAchievement(AchievementsNovaCraft.molten_vanite);
                            return this.fillBucket(itemStack, entityPlayer, NovaCraftItems.vanite_bucket_molten_vanite);
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

                    if (!entityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack))
                    {
                        return itemStack;
                    }

                    if (this.tryPlaceContainedLiquid(world, i, j, k) && !entityPlayer.capabilities.isCreativeMode)
                    {
                        return new ItemStack(NovaCraftItems.vanite_bucket);
                    }
                }
            }

            return itemStack;
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
