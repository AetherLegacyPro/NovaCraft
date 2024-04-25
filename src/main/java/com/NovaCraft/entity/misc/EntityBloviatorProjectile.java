package com.NovaCraft.entity.misc;

import java.util.Random;

import com.NovaCraftBlocks.NovaCraftBlocks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBloviatorProjectile extends EntityProjectileBase {

	public EntityBloviatorProjectile(World world) {
		super(world);
	}

	public EntityBloviatorProjectile(World world, EntityLivingBase thrower, double x, double y, double z) {
		super(world, thrower);

		this.setPosition(x, y, z);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		this.worldObj.spawnParticle("portal", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		
		if (this.ticksInAir > 150) {
			this.setDead();
		} else {
			this.ticksInAir++;
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition object) {
		if (object.entityHit instanceof EntityLivingBase) {

			object.entityHit.motionX += this.motionX * 1.7F;
			object.entityHit.motionY += 0.5D;
			object.entityHit.motionZ += this.motionZ * 1.7F;
			
			((EntityLivingBase)object.entityHit).addPotionEffect(new PotionEffect(Potion.blindness.id, 40, 0));

			if (object.entityHit instanceof EntityPlayerMP) {
				((EntityPlayerMP) object.entityHit).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(object.entityHit));
			}

			this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 2.0f, false);
			
			this.setDead();
		}
		else if (object.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && !this.worldObj.isRemote)
		{
			if (this.worldObj.getBlock(object.blockX, object.blockY, object.blockZ).getCollisionBoundingBoxFromPool(this.worldObj, object.blockX, object.blockY, object.blockZ) != null)
			{
				this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 4.0f, false);
				 int i = object.blockX;
	             int j = object.blockY;
	             int k = object.blockZ;
	             
				if (this.worldObj.isAirBlock(i, j + 1, k))
                {
                    this.worldObj.setBlock(i, j + 1, k, NovaCraftBlocks.crystallized_end);                
                }
			}
			
			this.setDead();
			}
	}

	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}

}
