package com.NovaCraft.entity;

import java.util.Random;

import com.NovaCraft.Hardmode;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityCaveMonitor extends EntityMob
{

    public EntityCaveMonitor(World p_i1743_1_)
    {
        super(p_i1743_1_);
        setSize(0.6F, 1.2F);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }

    public void onUpdate()
    {
        super.onUpdate();

        if (!this.worldObj.isRemote)
        {
            this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        //World world = MinecraftServer.getServer().worldServers[0];
        //Hardmode data = Hardmode.get(world);
        //if (data.getHardmode() == true) {
        	//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
            ///this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
            //this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.100000011920929D);
        //} else {
        	this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.000000011920929D);
         //}
    }
    
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    protected Entity findPlayerToAttack()
    {
        float f = this.getBrightness(1.0F);

        if (f < 0.5F)
        {
            double d0 = 32.0D;
            return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
        }
        else
        {
            return null;
        }
    }

    protected String getHurtSound() {
        return "nova_craft:blazing_serpent.hurt";
    }
    
    protected String getDeathSound() {
        return "nova_craft:blazing_serpent.hurt";
    }
    
    protected String getLivingSound() {
    	return null;
    }

    protected void attackEntity(Entity p_70785_1_, float p_70785_2_)
    {
        float f1 = this.getBrightness(1.0F);

        if (f1 > 0.5F && this.rand.nextInt(100) == 0)
        {
            this.entityToAttack = null;
        }
        else
        {
            if (p_70785_2_ > 2.0F && p_70785_2_ < 6.0F && this.rand.nextInt(10) == 0)
            {
                if (this.onGround)
                {
                    double d0 = p_70785_1_.posX - this.posX;
                    double d1 = p_70785_1_.posZ - this.posZ;
                    float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
                    this.motionX = d0 / (double)f2 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                    this.motionZ = d1 / (double)f2 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                    this.motionY = 0.4000000059604645D;
                }
            }
            else
            {
                super.attackEntity(p_70785_1_, p_70785_2_);
            }
        }
    }

    protected Item getDropItem()
    {
        return NovaCraftItems.cave_monitor_scales;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        super.dropFewItems(p_70628_1_, p_70628_2_);

        if (p_70628_1_ && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0))
        {
            this.dropItem(NovaCraftItems.cave_monitor_tongue, 1);
        }
    }

    public boolean isOnLadder()
    {
        return this.isBesideClimbableBlock();
    }

    public void setInWeb() {}

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }

    public boolean isPotionApplicable(PotionEffect p_70687_1_)
    {
        return p_70687_1_.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(p_70687_1_);
    }

    public boolean isBesideClimbableBlock()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean p_70839_1_)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (p_70839_1_)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 &= -2;
        }

        this.dataWatcher.updateObject(16, Byte.valueOf(b0));
    }

    public static class GroupData implements IEntityLivingData
        {
            public int field_111105_a;

            public void func_111104_a(Random p_111104_1_)
            {
                int i = p_111104_1_.nextInt(5);

                if (i <= 1)
                {
                    this.field_111105_a = Potion.moveSpeed.id;
                }
                else if (i <= 2)
                {
                    this.field_111105_a = Potion.damageBoost.id;
                }
                else if (i <= 3)
                {
                    this.field_111105_a = Potion.regeneration.id;
                }
                else if (i <= 4)
                {
                    this.field_111105_a = Potion.invisibility.id;
                }
            }
        }
    
    @Override
	public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);          
        return (this.posY <= 40.0D && this.worldObj.getBlockLightValue(i, j, k) < 7 && canSpawn);
                       
    }
}
