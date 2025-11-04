package com.NovaCraft.entity;

import com.NovaCraft.Items.NovaCraftItems;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityGoat extends EntityAnimal
{

    public EntityGoat(World p_i1683_1_)
    {
        super(p_i1683_1_);
        this.setSize(0.7F, 0.9F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000298023224D);
    }

    protected String getLivingSound()
    {
        return "nova_craft:goat.living";
    }

    protected String getHurtSound()
    {
        return "nova_craft:goat.hurt";
    }

    protected String getDeathSound()
    {
        return "nova_craft:goat.death";
    }
    
    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
        this.playSound("nova_craft:goat.step", 0.15f, 1.0f);
    }

    protected float getSoundVolume()
    {
        return 0.5F;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.isBurning()) {
            this.dropItem(NovaCraftItems.cooked_chevon, 1 + this.rand.nextInt(2));
        } else {
            this.dropItem(NovaCraftItems.raw_chevon, 1 + this.rand.nextInt(2));
        }
    }
    
    protected void dropRareDrop(int p_70600_1_)
    {
    	int rand = (int)(1 + Math.random() * 8);
		switch (rand)
        {
        case 1:
            this.entityDropItem(new ItemStack(NovaCraftItems.goat_horn_ponder), 0.0F);
            break;
        case 2:
            this.entityDropItem(new ItemStack(NovaCraftItems.goat_horn_admire), 0.0F);
            break;
        case 3:
            this.entityDropItem(new ItemStack(NovaCraftItems.goat_horn_call), 0.0F);
            break;
        case 4:
            this.entityDropItem(new ItemStack(NovaCraftItems.goat_horn_dream), 0.0F);
            break;
        case 5:
            this.entityDropItem(new ItemStack(NovaCraftItems.goat_horn_feel), 0.0F);
            break;
        case 6:
            this.entityDropItem(new ItemStack(NovaCraftItems.goat_horn_seek), 0.0F);
            break;
        case 7:
            this.entityDropItem(new ItemStack(NovaCraftItems.goat_horn_sing), 0.0F);
            break;
        case 8:
            this.entityDropItem(new ItemStack(NovaCraftItems.goat_horn_yearn), 0.0F);
            break;
        }
    }

    public boolean interact(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() == Items.bucket && !p_70085_1_.capabilities.isCreativeMode)
        {
            if (itemstack.stackSize-- == 1)
            {
                p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, new ItemStack(Items.milk_bucket));
            }
            else if (!p_70085_1_.inventory.addItemStackToInventory(new ItemStack(Items.milk_bucket)))
            {
                p_70085_1_.dropPlayerItemWithRandomChoice(new ItemStack(Items.milk_bucket, 1, 0), false);
            }

            return true;
        }
        else
        {
            return super.interact(p_70085_1_);
        }
    }

    public EntityGoat createChild(EntityAgeable p_90011_1_)
    {
        return new EntityGoat(this.worldObj);
    }
}
