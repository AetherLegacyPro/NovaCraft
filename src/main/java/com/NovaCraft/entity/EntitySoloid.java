package com.NovaCraft.entity;

import java.util.Random;

import com.NovaCraft.Hardmode;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.AI.EntityAIDeepoidBreathAttack;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntitySoloid extends EntityMob {

    public EntitySoloid(World p_i1743_1_) {
        super(p_i1743_1_);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0F, false));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        setSize(0.6F, 1.8F);
        this.isImmuneToFire = true;
        this.experienceValue = 10;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.20D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
        this.setHealth(80);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }

    @Override
    protected boolean isAIEnabled()
    {
        return true;
    }

    public int getTotalArmorValue() {
        return 7;
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
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    public boolean attackEntityAsMob(final Entity entity) {
        final boolean flag = super.attackEntityAsMob(entity);
        if (flag) {
            final int i = this.worldObj.difficultySetting.getDifficultyId();
            if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < i * 0.3f) {
                entity.setFire(0 * i);
            }
        }

        ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 120, 3));

        return flag;
    }

    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    public void fall(float distance) {
    }

    @Override
    protected String getHurtSound() {
        return "nova_craft:deepoid.hurt";
    }

    @Override
    protected String getDeathSound() {
        return "nova_craft:deepoid.death";
    }

    protected String getLivingSound() {
        return null;
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
        return (this.posY >= 100.0D && canSpawn);

    }
}
