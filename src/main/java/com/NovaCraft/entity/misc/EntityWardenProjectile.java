package com.NovaCraft.entity.misc;

import java.util.List;

import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.EntityPrisoner;
import com.NovaCraft.entity.EntityWarden;
import com.NovaCraft.entity.EntityWardenVessel;
import com.NovaCraft.particles.ParticleHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityWardenProjectile extends Entity {

	private EntityLivingBase shooter;
	private int life;
	private int particleCooldown = 0;

	public EntityWardenProjectile(World world) {
		super(world);
		this.noClip = true;
		this.setSize(3.0F, 3.0F);
	}

	public EntityWardenProjectile(World world, EntityLivingBase shooter) {
		this(world);
		this.shooter = shooter;
		this.setLocationAndAngles(shooter.posX, shooter.posY + shooter.getEyeHeight(), shooter.posZ, shooter.rotationYaw, shooter.rotationPitch);

		this.motionX = -Math.sin(Math.toRadians(shooter.rotationYaw)) * Math.cos(Math.toRadians(shooter.rotationPitch));
		this.motionZ =  Math.cos(Math.toRadians(shooter.rotationYaw)) * Math.cos(Math.toRadians(shooter.rotationPitch));
		this.motionY = -Math.sin(Math.toRadians(shooter.rotationPitch));

		double speed = 1.6D;
		this.motionX *= speed;
		this.motionY *= speed;
		this.motionZ *= speed;
	}

	@Override
	protected void entityInit() {}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if (++life > 120) {
			this.setDead();
			return;
		}

		if (worldObj.isRemote && Configs.enableWardenParticles) {
			spawnTrailParticles();
		}

		Vec3 start = Vec3.createVectorHelper(posX, posY, posZ);
		Vec3 end = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);

		Entity hit = null;
		double closest = Double.MAX_VALUE;

		List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(motionX, motionY, motionZ).expand(3.0D, 3.0D, 3.0D));

		for (int i = 0; i < list.size(); i++) {
			Entity e = (Entity) list.get(i);

			if (!e.canBeCollidedWith() || e == shooter) continue;

			AxisAlignedBB bb = e.boundingBox.expand(3.0D, 3.0D, 3.0D);
			MovingObjectPosition mop = bb.calculateIntercept(start, end);

			if (mop != null) {
				double d = start.distanceTo(mop.hitVec);
				if (d < closest) {
					closest = d;
					hit = e;
				}
			}
		}

		if (hit != null) {
			dealDamage(hit);
			setDead();
			return;
		}

		posX += motionX;
		posY += motionY;
		posZ += motionZ;
		setPosition(posX, posY, posZ);
	}

	private void dealDamage(Entity target) {

		float damage = 0.0F;

		if (this.shooter instanceof EntityWarden) {
			damage = 14.0F;
		}
		else if (this.shooter instanceof EntityWardenVessel) {
			damage = 8.0F;
		}
		else if (this.shooter instanceof EntityPrisoner) {
			damage = 24.0F;
		}

		if (damage <= 0.0F) return;

		if (target instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) target;
			if (!player.capabilities.disableDamage) {
				player.attackEntityFrom(DamageSource.magic, damage);
			}
		}
		else if (target instanceof EntityLivingBase) {
			target.attackEntityFrom(DamageSource.magic, damage);
		}
	}


	// === PARTICLES (LOW DENSITY) ===
	@SideOnly(Side.CLIENT)
	private void spawnTrailParticles() {
		// spawn a short trail along motion vector
		for (int i = 0; i < 2; i++) {
			double t = i / 2.0D;

			double px = posX - motionX * t;
			double py = posY - motionY * t;
			double pz = posZ - motionZ * t;

			ParticleHandler.VIBRATION_WARDEN.spawn(worldObj, px, py, pz);
		}
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag) {
		life = tag.getInteger("Life");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag) {
		tag.setInteger("Life", life);
	}
}
