package com.NovaCraft.entity;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDeathStalker extends EntityMob {

    public EntityDeathStalker(World par1World) {
        super(par1World);
        this.setSize(0.75F, 1F);
        if (!needsSpecialAI())
			addBasicAI();
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, 0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.5D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.05D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2D);
    }
    
    protected void addAttackingAI() {
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, getAIMoveSpeed() * 6, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	protected void addBasicAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0F));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}
	
	@Override
	public boolean attackEntityAsMob(final Entity entity) {
		final boolean flag = super.attackEntityAsMob(entity);
		if (flag) {
			final int i = this.worldObj.difficultySetting.getDifficultyId();			
		}
		               
        ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, 80, 1));
                                     
		return flag;
	}

    protected void playStepSound(int x, int y, int z, Block b) {}

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.spider.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.spider.say";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.spider.death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.spider.step", 0.15F, 1.0F);   
    }
    
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.55f;
    }

    @Override
    public void addVelocity(double x, double y, double z) {
        if(this.getProvoked())super.addVelocity(x, y, z);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!getProvoked()) {
            this.renderYawOffset=0;
            if(this.worldObj.getClosestVulnerablePlayerToEntity(this, 4) != null) {
                this.setProvoked();
                this.motionY=0.2;
            }
        }
    }
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    public boolean isPotionApplicable(PotionEffect p_70687_1_)
    {
        return p_70687_1_.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(p_70687_1_);
    }

    public boolean needsSpecialAI() {
        return true;
    }

    public boolean getProvoked() {
        return this.dataWatcher.getWatchableObjectInt(18)==1;
    }

    public void setProvoked() {
        this.dataWatcher.updateObject(18, 1);
        addBasicAI();
        addAttackingAI();
    }

    @Override
    protected Item getDropItem() {
        return Item.getItemFromBlock(Blocks.sand);
    }
    
    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        final boolean canSpawn = this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);          
        return (this.worldObj.getBlock(i, j - 1, k) == Blocks.sand || this.worldObj.getBlock(i, j - 1, k) == Blocks.dirt || this.worldObj.getBlock(i, j - 1, k) == Blocks.grass) && this.worldObj.getBlockLightValue(i, j, k) < 8 && this.posY >= 50.0D && canSpawn;
                          
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setBoolean("Provoked", this.getProvoked());
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        if(tag.getBoolean("Provoked"))setProvoked();
    }
}
