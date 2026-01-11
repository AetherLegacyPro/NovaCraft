package com.NovaCraft.entity;


import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.achievements.AchievementsNovaCraft;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityRelik extends EntityMob
{
    public EntityRelik(final World p_i1745_1_) {
        super(p_i1745_1_);
        getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        addRandomArmor();
        setSize(0.6F, 1.8F);
        this.experienceValue = 10;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.65D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.20D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10D);
        this.setHealth(40);
    }

    public int getTotalArmorValue() {
        return 8;
    }

    @Override
    protected void addRandomArmor() {
        int armor_type = (int)(1 + Math.random() * 14);

        switch (armor_type) {
            case 1:
                this.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
                this.setCurrentItemOrArmor(3, new ItemStack(Items.iron_chestplate));
                break;

            case 2:
                this.setCurrentItemOrArmor(4, new ItemStack(Items.golden_helmet));
                this.setCurrentItemOrArmor(3, new ItemStack(Items.golden_chestplate));
                break;

            case 3:
                break;

            case 4:
                this.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
                this.setCurrentItemOrArmor(3, new ItemStack(Items.chainmail_chestplate));
                break;

            case 5:
                if (rand.nextBoolean()) {
                    this.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_helmet));
                    this.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_chestplate));
                }
                break;

            case 6:
                this.setCurrentItemOrArmor(4, new ItemStack(Items.leather_helmet));
                this.setCurrentItemOrArmor(3, new ItemStack(Items.leather_chestplate));
                break;

            case 7:
                this.setCurrentItemOrArmor(4, new ItemStack(NovaCraftItems.phantom_helmet));
                this.setCurrentItemOrArmor(3, new ItemStack(NovaCraftItems.phantom_chestplate));
                break;

            default:
                this.setCurrentItemOrArmor(4, new ItemStack(Items.chainmail_helmet));
                this.setCurrentItemOrArmor(3, new ItemStack(Items.chainmail_chestplate));
                break;

        }

        int weapon_type = (int)(1 + Math.random() * 12);

        switch(weapon_type) {
            case 1:
                this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
                break;

            case 2:
                this.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
                break;

            case 3:
                break;

            case 4:
                this.setCurrentItemOrArmor(0, new ItemStack(NovaCraftItems.eerie_sword));

                break;
            case 5:
                if (rand.nextBoolean()) {
                    this.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
                }
                break;

            case 6:
                if (rand.nextBoolean()) {
                    if (rand.nextBoolean()) {
                        this.setCurrentItemOrArmor(0, new ItemStack(NovaCraftItems.iridium_sword));
                    }
                }
                break;

            default:
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
                break;
        }


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
        return flag;
    }

    public void onLivingUpdate() {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && this.worldObj.provider.dimensionId != 1 && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
            this.damageEntity(DamageSource.drown, 4.0f);
            this.setFire(4);
        }

        super.onLivingUpdate();
    }

    public float getBrightness(float p_70013_1_)
    {
        return super.getBrightness(p_70013_1_);
    }

    protected Item getDropItem() {
        return NovaCraftItems.relik_dust;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        this.worldObj.spawnParticle("townaura", this.posX + (this.rand.nextGaussian() / 5D), this.posY + (this.rand.nextGaussian() / 5D) + 1D, this.posZ + (this.rand.nextGaussian() / 3D), 0.0D, 0.0D, 0.0D);
        this.worldObj.spawnParticle("townaura", this.posX + (this.rand.nextGaussian() / 5D), this.posY + (this.rand.nextGaussian() / 5D) + 1D, this.posZ + (this.rand.nextGaussian() / 3D), 0.0D, 0.0D, 0.0D);
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Override
    protected String getLivingSound() {
        return "nova_craft:outsider.living";
    }

    @Override
    protected String getHurtSound() {
        return "nova_craft:outsider.living";
    }

    @Override
    protected String getDeathSound() {
        return "nova_craft:outsider.living";
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }

    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
        return (this.worldObj.getBlock(i, j - 1, k) == Blocks.stonebrick) && this.worldObj.getBlockLightValue(i, j, k) < 8 && this.worldObj.provider.dimensionId == 0 && this.posY <= 45.0D && canSpawn;

    }

}
