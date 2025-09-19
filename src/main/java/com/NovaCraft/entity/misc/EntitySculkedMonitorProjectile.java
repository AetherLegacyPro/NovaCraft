package com.NovaCraft.entity.misc;

import com.NovaCraft.config.Configs;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySculkedMonitorProjectile extends EntityProjectileBase {
	
	public EntitySculkedMonitorProjectile(World world) {
		super(world);
	}

	public EntitySculkedMonitorProjectile(World world, EntityLivingBase thrower, double x, double y, double z) {
		super(world, thrower);

		this.setPosition(x, y, z);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (this.worldObj.isRemote) {
	    int k;
		if (Configs.enableWardenParticles) {
	    	for (k = 0; k < 1; ++k)
	        {
	        	ParticleHandler.WARDEN.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
	        }
		  }
		}
		
		if (this.ticksInAir > 300) {
			this.setDead();
		} else {
			this.ticksInAir++;
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition object) {
		if (object.entityHit instanceof EntityLivingBase) {						
			
			object.entityHit.motionX += this.motionX * 1.1F;
			object.entityHit.motionY += 0.5D;
			object.entityHit.motionZ += this.motionZ * 1.1F;

			if (object.entityHit instanceof EntityPlayerMP) {
				((EntityPlayerMP) object.entityHit).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(object.entityHit));
			}

			this.setDead();
		}
		if (!this.worldObj.isRemote)
		{
			if (object.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY)
			{
				
				object.entityHit.attackEntityFrom(DamageSource.generic, 5.0F);
				((EntityLivingBase)object.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 120, 1));
				((EntityLivingBase)object.entityHit).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 120, 1));		
				
				if (this.worldObj.getBlock(object.blockX, object.blockY, object.blockZ).getCollisionBoundingBoxFromPool(this.worldObj, object.blockX, object.blockY, object.blockZ) != null)
				{
					 int i = object.blockX;
		             int j = object.blockY;
		             int k = object.blockZ;
					if (this.worldObj.isAirBlock(i, j, k))
	                {
	                    this.worldObj.setBlock(i, j, k, NovaCraftBlocks.sculk_tendrils);	                
	                	}
					}
				
				}
			}
			else if (object.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
			{
				if (this.worldObj.getBlock(object.blockX, object.blockY, object.blockZ).getCollisionBoundingBoxFromPool(this.worldObj, object.blockX, object.blockY, object.blockZ) != null)
				{
					 int i = object.blockX;
		             int j = object.blockY;
		             int k = object.blockZ;
					if (this.worldObj.isAirBlock(i, j, k))
	                {
	                    this.worldObj.setBlock(i, j, k, NovaCraftBlocks.sculk_tendrils);
	                
				}
			}
		}
	}

	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}

}
