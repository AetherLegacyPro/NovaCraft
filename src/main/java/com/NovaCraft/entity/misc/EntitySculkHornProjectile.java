package com.NovaCraft.entity.misc;

import java.util.ArrayList;

import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.EntityWarden;
import com.NovaCraft.particles.ParticleHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntitySculkHornProjectile extends EntityProjectileBase {

	public ArrayList<Block> harvestBlockBans = new ArrayList<Block>();

	public EntitySculkHornProjectile(World worldIn) {
		super(worldIn);
	}

	public EntitySculkHornProjectile(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if (this.ticksInAir > 50) {
			this.setDead();
		} else {
			this.ticksInAir++;
		}
	}
	
	@SideOnly(Side.CLIENT)
    public void onEntityUpdate() {
    	super.onEntityUpdate();
    	if (this.worldObj.isRemote) {
    	int k;
    	if (Configs.enableWardenParticles) {
    	for (k = 0; k < 1; ++k)
        {
        	ParticleHandler.VIBRATION.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
        }
        
        for (k = 0; k < 1; ++k)
        {
        	ParticleHandler.VIBRATION.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height + 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
        	}
    	  }
    	}
    }

	@Override
	@SuppressWarnings("deprecation")
	protected void onImpact(MovingObjectPosition object) {
		if (object.typeOfHit == MovingObjectType.ENTITY) {
			 if (object.entityHit != this.getThrower() && !(object.entityHit instanceof EntityWarden)) {
				object.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.getThrower()), 7);
				object.entityHit.addVelocity(this.motionX, 0.2D, this.motionZ);
			}
		}
	}

	@Override
	protected float getBoundingBoxExpansion() {
		return 1.1F;
	}

	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}

}
