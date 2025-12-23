package com.NovaCraft.entity;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.illager.EntityVindicator;
import com.NovaCraft.entity.misc.EnumRavagerType;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityRavager extends EntityMob implements IBossDisplayData {
    public EntityRavager(final World world) {
        super(world);
        EnumRavagerType type = this.getType();
        if (type == EnumRavagerType.BASE) {
            this.experienceValue = 20;
        } else {
            this.experienceValue = 100;
        }

        this.setSize(2.8f, 1.5f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(4.25D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(21, (byte) this.rand.nextInt(EnumRavagerType.values().length));
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.worldObj.isRemote && this.getType() == EnumRavagerType.BOSS) {
            BossStatus.setBossStatus(this, true);
        }
    }

    @Override
    public String getCommandSenderName() {
        if (this.getType() == EnumRavagerType.BOSS) {
            return "The Beast";
        }
        return super.getCommandSenderName();
    }

    protected String getLivingSound() {
        return "nova_craft:ravager.living";
    }

    protected String getHurtSound() {
        return "nova_craft:ravager.hurt";
    }

    protected String getDeathSound() {
        return "nova_craft:ravager.death";
    }

    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.55f;
    }

    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
        this.playSound("nova_craft:ravager.step", 0.15f, 1.0f);
    }

    @Override
    public double getMountedYOffset() {
        return this.height + 0.2D;
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
        Object p_110161_1_1 = super.onSpawnWithEgg(p_110161_1_);
        setType(0);

        int mob = this.worldObj.rand.nextInt(8);
        if (mob <= 3) {
            EntityVindicator entity = new EntityVindicator(this.worldObj);
            entity.setLocationAndAngles(this.posX, this.posY + 0.2D, this.posZ, this.rotationYaw, 0.0F);
            entity.onSpawnWithEgg(null);
            this.worldObj.spawnEntityInWorld(entity);
            entity.mountEntity(this);

            return (IEntityLivingData)p_110161_1_1;
        } else if (mob == 4 || mob == 5 || mob == 6) {
            EntityCorruptist entity = new EntityCorruptist(this.worldObj);
            entity.setLocationAndAngles(this.posX, this.posY + 0.2D, this.posZ, this.rotationYaw, 0.0F);
            entity.onSpawnWithEgg(null);
            this.worldObj.spawnEntityInWorld(entity);
            entity.mountEntity(this);

            return (IEntityLivingData)p_110161_1_1;
        } else {
            return (IEntityLivingData)p_110161_1_1;
        }
    }

    public int getTotalArmorValue() {
        EnumRavagerType type = this.getType();
        if (type == EnumRavagerType.BASE) {
            return 7;
        } else {
            return 17;
        }
    }

    protected Item getDropItem()
    {
        return Items.leather;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if (this.isBurning()) {
            this.dropItem(Items.cooked_porkchop, 1 + this.rand.nextInt(2));
        } else {
            this.dropItem(Items.porkchop, 1 + this.rand.nextInt(2));
        }
        EnumRavagerType type = this.getType();
        if (type == EnumRavagerType.BASE) {
            this.dropItem(Items.leather, 8 + this.rand.nextInt(8));
        } else {
            this.dropItem(NovaCraftItems.beastly_leather, 8 + this.rand.nextInt(8));
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        this.worldObj.setEntityState((Entity)this, (byte)4);
        final boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)(14 + this.rand.nextInt(3)));
        if (flag) {
            par1Entity.motionY += 0.5000000059604645;
        }
        this.playSound("mob.irongolem.throw", 1.0f, 1.0f);
        return flag;
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }

    public EnumRavagerType getType() {
        int id = this.dataWatcher.getWatchableObjectByte(21);

        return EnumRavagerType.get(id);
    }

    public void setType(int id)
    {
        this.dataWatcher.updateObject(21, (byte) id);
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger("RavagerType", this.getType().getId());
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.setType(p_70037_1_.getInteger("RavagerType"));
    }

    @Override
    public boolean canDespawn() {
        return false;
    }
}
