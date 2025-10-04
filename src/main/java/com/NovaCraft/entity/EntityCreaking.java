package com.NovaCraft.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.misc.EnumCreakingType;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraft.entity.EntityLivingBase;

public class EntityCreaking extends EntityMob
{
	private int attackTimer;

    public EntityCreaking(World p_i1743_1_)
    {
        super(p_i1743_1_);
        this.setSize(0.7F, 1.45F);
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, IMob.mobSelector));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
        this.dataWatcher.addObject(21, (byte) this.rand.nextInt(EnumCreakingType.values().length));
    }

    public void onUpdate()
    {
        super.onUpdate();

        if (!this.worldObj.isRemote)
        {
            this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.setHealth(30.0F);
    }
    
    protected void collideWithEntity(Entity p_82167_1_)
    {
        if (p_82167_1_ instanceof IMob && this.getRNG().nextInt(20) == 0)
        {
            this.setAttackTarget((EntityLivingBase)p_82167_1_);
        }

        super.collideWithEntity(p_82167_1_);
    }
    
    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        this.attackTimer = 30;
        this.worldObj.setEntityState(this, (byte) 4);
        boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(3 + this.rand.nextInt(3)));

        if (flag)
        {
            entity.motionY += 0.1500000059604645D;
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 80, 1));
            this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
        }

        return flag;
    }
    
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.attackTimer > 0)
        {
            --this.attackTimer;
        }
        if (this.rand.nextInt(80) == 0) {
        if (this.isWet()) {
        	this.heal(3.0F);
        }
        else {
        	this.heal(1.0F);
        	}
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_)
    {
        if (p_70103_1_ == 4)
        {
            this.attackTimer = 10;
            this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
        }
        else
        {
            super.handleHealthUpdate(p_70103_1_);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getAttackTimer()
    {
        return this.attackTimer;
    }

    protected Entity findPlayerToAttack()
    {
        float f = this.getBrightness(1.0F);

        if (f < 0.5F)
        {
            double d0 = 24.0D;
            return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
        }
        else
        {
            return null;
        }
    }

    protected String getHurtSound()
    {
        return "nova_craft:creaking.hurt";
    }
    
    protected String getLivingSound()
    {
        return "nova_craft:creaking.living";
    }

    protected String getDeathSound()
    {
        return "nova_craft:creaking.death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("nova_craft:creaking.step", 0.25F, 0.25F);
    }
    
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.55f;
    }

    public void attackEntity(Entity p_70785_1_, float p_70785_2_)
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
                    this.motionX = d0 / (double)f2 * 0.5D * 0.900000011920929D + this.motionX * 0.30000000298023224D;
                    this.motionZ = d1 / (double)f2 * 0.5D * 0.900000011920929D + this.motionZ * 0.30000000298023224D;
                }
            }
            else
            {
                super.attackEntity(p_70785_1_, p_70785_2_);
            }
        }
    }
    
    public boolean canDespawn() {
    	if (this.getType() == EnumCreakingType.LUMINANT) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
     if (this.getType() == EnumCreakingType.OAK)
       {
        int k;
        k = 1 + this.rand.nextInt(1);
        for (int l = 0; l < k; ++l)
        {
          this.entityDropItem(new ItemStack(Blocks.log, k, 0), 1.0F);
        }
       }
     
     if (this.getType() == EnumCreakingType.BIRCH)
     {
      int k;
      k = 1 + this.rand.nextInt(1);
      for (int l = 0; l < k; ++l)
      	{
    	  this.entityDropItem(new ItemStack(Blocks.log, k, 2), 1.0F);
      	}
     }
     
     if (this.getType() == EnumCreakingType.SPRUCE)
     {
      int k;
      k = 1 + this.rand.nextInt(1);
      for (int l = 0; l < k; ++l)
      	{
    	  this.entityDropItem(new ItemStack(Blocks.log, k, 1), 1.0F);
      	}
     }
     
     if (this.getType() == EnumCreakingType.JUNGLE)
     {
      int k;
      k = 1 + this.rand.nextInt(1);
      for (int l = 0; l < k; ++l)
      	{
    	  this.entityDropItem(new ItemStack(Blocks.log, k, 3), 1.0F);
      	}
     }
     
     if (this.getType() == EnumCreakingType.DARK_OAK)
     {
      int k;
      k = 1 + this.rand.nextInt(1);
      for (int l = 0; l < k; ++l)
      	{
    	  this.entityDropItem(new ItemStack(Blocks.log2, k, 1), 1.0F);
      	}
     }
     
     if (this.getType() == EnumCreakingType.LUMINANT)
     {
      int k;
      k = 1 + this.rand.nextInt(1);
      for (int l = 0; l < k; ++l)
      	{
    	  this.entityDropItem(new ItemStack(NovaCraftBlocks.luminant_log, k, 0), 1.0F);
      	}
     }

    }
    
    public float getBrightness(float p_70013_1_)
    {
      if (this.getType() == EnumCreakingType.LUMINANT) {
    	  return 0.3375F;
      }
      else {
    	  return 0.0F; 
      }
    }
    
    protected void dropRareDrop(int p_70600_1_)
    {
    	if (this.getType() == EnumCreakingType.LUMINANT) {
    		this.dropItem(NovaCraftItems.luminant_apple, 1);
    	}
    	else {
    		this.dropItem(Items.apple, 1);
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
    
    //Credit to Roadhog360 or the original Et Futurum author for this code
    @Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData livingdata) {
		BiomeGenBase biome = worldObj.getBiomeGenForCoords((int) posX, (int) posZ);
		if (biome == BiomeGenBase.forest || biome == BiomeGenBase.forestHills) {
			setType(EnumCreakingType.OAK.ordinal());
		} else if (biome == BiomeGenBase.taiga || biome == BiomeGenBase.taigaHills || biome == BiomeGenBase.megaTaiga || biome == BiomeGenBase.megaTaigaHills) {
			setType(EnumCreakingType.SPRUCE.ordinal());
		} else if (biome == BiomeGenBase.birchForest || biome == BiomeGenBase.birchForestHills) {
			setType(EnumCreakingType.BIRCH.ordinal());
		} else if (biome == BiomeGenBase.jungle || biome == BiomeGenBase.jungleHills || biome == BiomeGenBase.jungleEdge) {
			setType(EnumCreakingType.JUNGLE.ordinal());
		} else if (biome == BiomeGenBase.roofedForest) {
			setType(EnumCreakingType.DARK_OAK.ordinal());
		}
			int type = rand.nextInt(5);
			switch (type) {
				case 0:
					type = EnumCreakingType.OAK.ordinal();
					break;
				case 1:
					type = EnumCreakingType.BIRCH.ordinal();
					break;
				case 2:
					type = EnumCreakingType.SPRUCE.ordinal();
					break;
				case 3:
					type = EnumCreakingType.JUNGLE.ordinal();
					break;
				case 4:
					type = EnumCreakingType.DARK_OAK.ordinal();
					break;
				default:
					setType(rand.nextInt(6));
			}

		return super.onSpawnWithEgg(livingdata);
	}
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
    	if (source.isProjectile())
        {
            return false;
        }
    	
    	Entity entity;
		entity = source.getSourceOfDamage();

		if (entity instanceof EntityArrow)
        {
            return false;
        }
    	
    	 return super.attackEntityFrom(source, amount);
    }
    
    public EnumCreakingType getType()
    {
        int id = this.dataWatcher.getWatchableObjectByte(21);

        return EnumCreakingType.get(id);
    }

    public void setType(int id)
    {
        this.dataWatcher.updateObject(21, (byte) id);
    }
    
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger("CreakingType", this.getType().getId());
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.setType(p_70037_1_.getInteger("CreakingType"));
    }
    
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    public boolean getCanSpawnHere() {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
        Block blockBelow = this.worldObj.getBlock(i, j - 1, k);
        if (blockBelow != Blocks.grass && blockBelow != Blocks.dirt) {
            return false;
        } else if (this.posY < 55.0D) {
            return false;
        } else {
            int blockLight = this.worldObj.getBlockLightValue(i, j, k);
            int skyLight = this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k);
            return blockLight < 8 && skyLight <= this.rand.nextInt(32) ? canSpawn : false;
        }
    }
}
