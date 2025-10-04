package com.NovaCraft.entity;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.misc.EnumGolemType;
import com.NovaCraft.registry.OtherModItems;

import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIDefendVillage;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookAtVillager;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class EntityCrystalGolem extends EntityGolem
{
    private int homeCheckTimer;
    Village villageObj;
    private int attackTimer;

    public EntityCrystalGolem(World p_i1694_1_)
    {
        super(p_i1694_1_);
        this.setSize(0.7F, 1.45F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.6D, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, IMob.mobSelector));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(21, (byte) this.rand.nextInt(EnumGolemType.values().length));
    }

    public boolean isAIEnabled()
    {
        return true;
    }
    
    public boolean canDespawn() {
        return false;
    }

    protected void updateAITick()
    {
        if (--this.homeCheckTimer <= 0)
        {
            this.homeCheckTimer = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);

            if (this.villageObj == null)
            {
                this.detachHome();
            }
            else
            {
                ChunkCoordinates chunkcoordinates = this.villageObj.getCenter();
                this.setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, (int)((float)this.villageObj.getVillageRadius() * 0.6F));
            }
        }

        super.updateAITick();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        if (this.getType() != EnumGolemType.NULLSTONE) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
            this.setHealth(40.0F);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23D);
            this.setHealth(40.0F);
        }

    }

    protected int decreaseAirSupply(int p_70682_1_)
    {
        return p_70682_1_;
    }

    protected void collideWithEntity(Entity p_82167_1_)
    {
        if (p_82167_1_ instanceof IMob && this.getRNG().nextInt(20) == 0)
        {
            this.setAttackTarget((EntityLivingBase)p_82167_1_);
        }

        super.collideWithEntity(p_82167_1_);
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.attackTimer > 0)
        {
            --this.attackTimer;
        }

        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0)
        {
            int i = MathHelper.floor_double(this.posX);
            int j = MathHelper.floor_double(this.posY - 0.20000000298023224D - (double)this.yOffset);
            int k = MathHelper.floor_double(this.posZ);
            Block block = this.worldObj.getBlock(i, j, k);

            if (block.getMaterial() != Material.air)
            {
                this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.boundingBox.minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
            }
        }
        
        if(Configs.enableCrystalGolemAura == true) {
            if (this.getType() == EnumGolemType.COPARTZ) {
            	List<Entity> volume = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(2, 3, 2));
            	for(Entity entity : volume) {
            		if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 250, 0, true));
            		if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 250, 0, true));	
            		}
            	}
            else if (this.getType() == EnumGolemType.LARIMAR) {
            	List<Entity> volume = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(2, 3, 2));
                for(Entity entity : volume) {
                	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 250, 1, true));
                	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 250, 0, true));
                	}
                }
            else if (this.getType() == EnumGolemType.TSAVOROKITE) {
            	List<Entity> volume = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(2, 3, 2));
                for(Entity entity : volume) {
                	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 250, 1, true));
                	}
                }
            else if (this.getType() == EnumGolemType.YTTRLINISTE) {
            	List<Entity> volume = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(2, 3, 2));
                for(Entity entity : volume) {
                	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0, true));
                	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).setFire(8);
                	}
                }
            else if (this.getType() == EnumGolemType.AMETHYST) {
            	List<Entity> volume = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(2, 3, 2));
                for(Entity entity : volume) {
                	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 250, 0, true));
                	}
                }
            else if (this.getType() == EnumGolemType.AETHER) {
            	List<Entity> volume = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(2, 3, 2));
                for(Entity entity : volume) {
                	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 250, 0, true));
                	if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 250, 2, true));
                	}
                }
        	 }
            
            super.onLivingUpdate();
    }
    
    public EnumGolemType getType()
    {
        int id = this.dataWatcher.getWatchableObjectByte(21);

        return EnumGolemType.get(id);
    }

    public void setType(int id)
    {
        this.dataWatcher.updateObject(21, (byte) id);
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
    	if (source == DamageSource.drown || source == DamageSource.wither || source == DamageSource.inWall || source.isProjectile())
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

    public boolean canAttackClass(Class p_70686_1_)
    {
        return this.isPlayerCreated() && EntityPlayer.class.isAssignableFrom(p_70686_1_) ? false : super.canAttackClass(p_70686_1_);
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setBoolean("PlayerCreated", this.isPlayerCreated());
        p_70014_1_.setInteger("GolemType", this.getType().getId());
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.setPlayerCreated(p_70037_1_.getBoolean("PlayerCreated"));
        this.setType(p_70037_1_.getInteger("GolemType"));
    }

    public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        this.attackTimer = 30;
        this.worldObj.setEntityState(this, (byte)4);
        boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(6 + this.rand.nextInt(3)));

        if (flag)
        {
            p_70652_1_.motionY += 0.2000000059604645D;
        }

        this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
        return flag;
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_)
    {
        if (p_70103_1_ == 4)
        {
            this.attackTimer = 30;
            this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
        }
        else
        {
            super.handleHealthUpdate(p_70103_1_);
        }
    }

    public Village getVillage()
    {
        return this.villageObj;
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer()
    {
        return this.attackTimer;
    }

    protected String getHurtSound()
    {
        return "nova_craft:crystal.break";
    }
    
    protected String getLivingSound()
    {
        return null;
    }

    protected String getDeathSound()
    {
        return "mob.irongolem.death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.irongolem.walk", 0.25F, 0.25F);
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int k;
        int l;
        if (this.getType() == EnumGolemType.COPARTZ) {
            k = 3 + this.rand.nextInt(3);

            for(l = 0; l < k; ++l) {
                this.dropItem(NovaCraftItems.copartz_shard, 1);
            }
        }

        if (this.getType() == EnumGolemType.LARIMAR) {
            k = 3 + this.rand.nextInt(3);

            for(l = 0; l < k; ++l) {
                this.dropItem(NovaCraftItems.larimar_shard, 1);
            }
        }

        if (this.getType() == EnumGolemType.TSAVOROKITE) {
            k = 3 + this.rand.nextInt(3);

            for(l = 0; l < k; ++l) {
                this.dropItem(NovaCraftItems.tsavorokite_shard, 1);
            }
        }

        if (this.getType() == EnumGolemType.YTTRLINISTE) {
            k = 3 + this.rand.nextInt(3);

            for(l = 0; l < k; ++l) {
                this.dropItem(NovaCraftItems.yttrlinsite_shard, 1);
            }
        }

        if (this.getType() == EnumGolemType.AMETHYST) {
            k = 3 + this.rand.nextInt(3);

            for(l = 0; l < k; ++l) {
                this.dropItem(OtherModItems.amethyst_shard, 1);
            }
        }

        if (this.getType() == EnumGolemType.AETHER) {
            k = 1 + this.rand.nextInt(1);

            for(l = 0; l < k; ++l) {
                this.dropItem(NovaCraftItems.aether_shard, 1);
            }
        }

        if (this.getType() == EnumGolemType.NULLSTONE) {
            k = 1 + this.rand.nextInt(1);

            for(l = 0; l < k; ++l) {
                this.dropItem(Item.getItemFromBlock(NovaCraftBlocks.cobbled_nullstone), 1);
            }
        }

    }


    public boolean isPlayerCreated()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setPlayerCreated(boolean p_70849_1_)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (p_70849_1_)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
        }
    }

    public void onDeath(DamageSource p_70645_1_)
    {
        if (!this.isPlayerCreated() && this.attackingPlayer != null && this.villageObj != null)
        {
            this.villageObj.setReputationForPlayer(this.attackingPlayer.getCommandSenderName(), -5);
        }

        super.onDeath(p_70645_1_);
    }
}
