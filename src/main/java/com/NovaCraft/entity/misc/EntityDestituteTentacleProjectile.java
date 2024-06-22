package com.NovaCraft.entity.misc;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import com.NovaCraft.config.Configs;
import com.NovaCraft.particles.ParticleHandler;

public class EntityDestituteTentacleProjectile extends EntityArrow implements IThrowableEntity {

	private int timeInGround;

	private boolean hitGround;
	
	public int ticksInAir;

	public EntityDestituteTentacleProjectile(World worldIn) {
		super(worldIn);
		setSize(2F, 2F);
	}

	public EntityDestituteTentacleProjectile(World worldIn, EntityLivingBase shooter, float distance) {
		super(worldIn, shooter, distance);
	}

	@Override
	public void onUpdate() {

		if (this.hitGround) {
			++this.timeInGround;
			
		} 
		
		if (this.ticksInAir > 200) {
			this.setDead();
		} else {
			this.ticksInAir++;
		}

		Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
		Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
		MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
		vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
		vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

		if (movingobjectposition != null)
		{
			vec3 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
		}

		Entity entity = null;
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
		double d0 = 0.0D;
		int i;
		float f1;

		for (i = 0; i < list.size(); ++i)
		{
			Entity entity1 = (Entity)list.get(i);

			if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity))
			{
				f1 = 0.3F;
				AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand((double)f1, (double)f1, (double)f1);
				MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec31, vec3);

				if (movingobjectposition1 != null)
				{
					double d1 = vec31.distanceTo(movingobjectposition1.hitVec);

					if (d1 < d0 || d0 == 0.0D)
					{
						entity = entity1;
						d0 = d1;
					}
				}
			}
		}

		if (entity != null)
		{
			movingobjectposition = new MovingObjectPosition(entity);
		}

		if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer)
		{
			EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;

			if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer))
			{
				movingobjectposition = null;
			}
		}

		super.onUpdate();
	}
	
	@SideOnly(Side.CLIENT)
    public void onEntityUpdate() {
    	super.onEntityUpdate();
    	if (this.worldObj.isRemote) {
    	int k;
    	final float f = MathHelper.cos((48 + this.ticksExisted) * 0.13f + 3.1415927f);
        final float f2 = MathHelper.cos((48 + this.ticksExisted + 1) * 0.13f + 3.1415927f);
        if (f > 0.0f && f2 <= 0.0f) {
    	this.playSound("nova_craft:sculk.break", 2.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
        }
    	for (k = 0; k < 1; ++k)
        {
        	ParticleHandler.VOID.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
        }
        
        for (k = 0; k < 1; ++k)
        {
        	ParticleHandler.VOID.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height + 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
        	}
    	  }
    }

	@Override
	public void setThrower(Entity entity) {
		this.shootingEntity = entity;
	}

	@Override
	public Entity getThrower() {
		return this.shootingEntity;
	}
	
	protected float getGravityVelocity() {
		return 0.0F;
	}

}
