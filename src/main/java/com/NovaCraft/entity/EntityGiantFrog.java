package com.NovaCraft.entity;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.misc.EnumGiantFrogType;
import net.minecraft.entity.ai.EntityAITargetNonTamed;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityGiantFrog extends EntityMob {

    private boolean isJumping;
    private boolean isCroaking;
    private boolean isSwimming;

    private float jumpTimer;
    private float croakTimer;
    private float swimTimer;

    public boolean isJumpingAnim() { return isJumping; }
    public boolean isCroakingAnim() { return isCroaking; }
    public boolean isSwimmingAnim() { return isSwimming; }

    public float getJumpTimer() { return jumpTimer; }
    public float getCroakTimer() { return croakTimer; }
    public float getSwimTimer() { return swimTimer; }

    private int frogJumpDelay;

    public EntityGiantFrog(final World world) {
        super(world);
        this.frogJumpDelay = this.rand.nextInt(10) + 10;
        this.experienceValue = 3;
        this.setSize(2.0f, 2.0f);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.30);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
        this.setHealth(26.0f);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIWander(this, 0.8D));

    }

    @Override
    public boolean isInWater() {
        return this.worldObj.getBlock((int)this.posX, (int)this.boundingBox.minY, (int)this.posZ).getMaterial().isLiquid();
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(21, (byte) this.rand.nextInt(EnumGiantFrogType.values().length));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        this.fallDistance = 0.0f;

        if (!onGround && motionY > 0.15 && !isJumping) {
            isJumping = true;
            jumpTimer = 0f;
        }
        if (isJumping) {
            jumpTimer += 1.0f / 20.0f;
            if (jumpTimer > 0.5f) isJumping = false;
        }

        isSwimming = this.isInWater();

        if (isSwimming) {
            swimTimer += 1.0f / 20.0f;
        } else {
            swimTimer = 0f;
        }

        if (!isCroaking && rand.nextInt(100) == 0) {
            isCroaking = true;
            croakTimer = 0f;
        }
        if (isCroaking) {
            croakTimer += 1.0f / 20.0f;
            if (croakTimer > 0.7f) isCroaking = false;
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.isCroaking) {
            this.croakTimer += 1.0F / 20.0F;
            if (this.croakTimer >= 0.7F) {
                this.isCroaking = false;
                this.croakTimer = 0;
            }
        } else if (this.rand.nextInt(200) == 0 && !this.isInWater()) {
            this.isCroaking = true;
            this.croakTimer = 0;
        }

        if (this.isJumping && (this.onGround || this.isInWater())) {
            this.jumpTimer += 1.0F / 20.0F;
            if (this.jumpTimer >= 0.25F) {
                this.motionY += 1.0;
                this.isJumping = false;
                this.jumpTimer = 0;
            }
        }

        if (this.isInWater()) {
            this.isSwimming = true;
            this.swimTimer += 1.0F / 20.0F;
        } else {
            this.isSwimming = false;
            this.swimTimer = 0;
        }

    }

    protected int getJumpDelay()
    {
        return this.rand.nextInt(10) + 10;
    }

    @Override
    protected void updateEntityActionState() {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

        if (entityplayer != null) {
            this.faceEntity(entityplayer, 10.0F, 20.0F);

            if (this.onGround && this.frogJumpDelay-- <= 0) {
                this.frogJumpDelay = this.getJumpDelay();

                this.isJumping = true;

                this.playSound(this.getLivingSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);

                double dx = entityplayer.posX - this.posX;
                double dz = entityplayer.posZ - this.posZ;
                double dist = MathHelper.sqrt_double(dx * dx + dz * dz);

                if (dist > 0.0001D) {
                    this.motionX = dx / dist * 0.8D;
                    this.motionZ = dz / dist * 0.8D;
                    this.motionY = 1.0D;
                }
            }
        } else {
            this.frogJumpDelay = this.rand.nextInt(10) + 10;
            if (this.onGround && this.frogJumpDelay-- <= 0) {
                this.frogJumpDelay = this.rand.nextInt(10) + 10; // wait longer between random moves

                // Pick random direction
                float angle = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                double speed = 1.0D; // wandering speed
                this.motionX = -Math.sin(angle) * speed;
                this.motionZ =  Math.cos(angle) * speed;

                // Small hop to keep movement noticeable
                this.motionY = 0.3D;
            }
        }
    }

    public void onCollideWithPlayer(EntityPlayer p_70100_1_) {
        if (this.canEntityBeSeen(p_70100_1_) && this.getDistanceSqToEntity(p_70100_1_) < 16D && p_70100_1_.attackEntityFrom(DamageSource.causeMobDamage(this), 2))
        {
            this.playSound("minecraft:mob.attack", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
        }
    }

    protected String getLivingSound() {
        return "nova_craft:frog.living";
    }

    protected String getHurtSound() {
        return "nova_craft:frog.hurt";
    }

    protected String getDeathSound() {
        return "nova_craft:frog.death";
    }

    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
        this.playSound("nova_craft:frog.step", 0.25f, 1.0f);
    }

    public boolean isPotionApplicable(PotionEffect p_70687_1_)
    {
        return p_70687_1_.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(p_70687_1_);
    }

    public EnumGiantFrogType getType()
    {
        int id = this.dataWatcher.getWatchableObjectByte(21);

        return EnumGiantFrogType.get(id);
    }

    public void setType(int id)
    {
        this.dataWatcher.updateObject(21, (byte) id);
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger("GiantFrogType", this.getType().getId());
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.setType(p_70037_1_.getInteger("GiantFrogType"));
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
            if (this.isBurning())
            {
                this.dropItem(NovaCraftItems.cooked_frog_leg, 1);
            }
            else
            {
                this.dropItem(NovaCraftItems.raw_frog_leg, 1);
            }
    }

    @Override
    public boolean canDespawn() {
        return true;
    }
}
