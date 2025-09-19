package com.NovaCraft.entity.AI;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class EntityAIDeepoidBreathAttack extends EntityAIBase {

	private EntityLiving entityHost;
    private EntityLivingBase attackTarget;
    
	protected double breathX;
	protected double breathY;
	protected double breathZ;
    
	private int maxDuration;
	private float attackChance;
	private float breathRange;
	
	private int durationLeft;

	public EntityAIDeepoidBreathAttack(EntityLiving par1EntityLiving, float speed, float range, int time, float chance)
    {
        this.entityHost = par1EntityLiving;
        this.breathRange = range;
        this.maxDuration = time;
        this.attackChance = chance;
        this.setMutexBits(7);
    }

	@Override
	public boolean shouldExecute() 
	{
        this.attackTarget = this.entityHost.getAttackTarget();

        if (this.attackTarget == null || this.entityHost.getDistanceToEntity(attackTarget) > this.breathRange || !this.entityHost.canEntityBeSeen(attackTarget)) 
        {
            return false;
        }
        else
        {
        	breathX = attackTarget.posX;
        	breathY = attackTarget.posY + attackTarget.getEyeHeight();
        	breathZ = attackTarget.posZ;
        	
        	return this.entityHost.getRNG().nextFloat() < this.attackChance;
        }
	}

	@Override
	public void startExecuting() 
	{
		this.durationLeft = this.maxDuration;
		
		if (this.entityHost instanceof IDeepoidBreathAttacker)
		{
			((IDeepoidBreathAttacker) entityHost).setBreathing(true);
		}
	}

	@Override
	public boolean continueExecuting() 
	{
		return this.durationLeft > 0 && !this.entityHost.isDead && !this.attackTarget.isDead 
				&& this.entityHost.getDistanceToEntity(attackTarget) <= this.breathRange 
				&& this.entityHost.canEntityBeSeen(attackTarget);
	}

	@Override
	public void updateTask() 
	{
		this.durationLeft--;

        this.entityHost.getLookHelper().setLookPosition(breathX, breathY, breathZ, 100.0F, 100.0F);
		faceVec(breathX, breathY, breathZ, 100.0F, 100.0F);
		
		if ((this.maxDuration - this.durationLeft) > 5)
		{
	        Entity target = getHeadLookTarget();
			
	        if (target != null)
	        {
				((IDeepoidBreathAttacker) entityHost).doBreathAttack(target);
	        }
		}

	}

	@Override
	public void resetTask() 
	{
		this.durationLeft = 0;
		
		if (this.entityHost instanceof IDeepoidBreathAttacker)
		{
			((IDeepoidBreathAttacker) entityHost).setBreathing(false);
		}
	}

	@SuppressWarnings("unchecked")
	private Entity getHeadLookTarget() {
		Entity pointedEntity = null;
		double range = 30.0D;
        Vec3 srcVec = Vec3.createVectorHelper(this.entityHost.posX, this.entityHost.posY + 0.25, this.entityHost.posZ); //0.25
        Vec3 lookVec = this.entityHost.getLook(1.0F);
        Vec3 destVec = srcVec.addVector(lookVec.xCoord * range, lookVec.yCoord * range, lookVec.zCoord * range);
        float var9 = 3.0F;
        List<Entity> possibleList = this.entityHost.worldObj.getEntitiesWithinAABBExcludingEntity(this.entityHost, this.entityHost.boundingBox.addCoord(lookVec.xCoord * range, lookVec.yCoord * range, lookVec.zCoord * range).expand(var9, var9, var9));
        double hitDist = 0;

        for (Entity possibleEntity : possibleList)
        {
            if (possibleEntity.canBeCollidedWith() && possibleEntity != this.entityHost)
            {
                float borderSize = possibleEntity.getCollisionBorderSize();
                AxisAlignedBB collisionBB = possibleEntity.boundingBox.expand((double)borderSize, (double)borderSize, (double)borderSize);
                MovingObjectPosition interceptPos = collisionBB.calculateIntercept(srcVec, destVec);

                if (collisionBB.isVecInside(srcVec))
                {
                    if (0.0D < hitDist || hitDist == 0.0D)
                    {
                        pointedEntity = possibleEntity;
                        hitDist = 0.0D;
                    }
                }
                else if (interceptPos != null)
                {
                    double possibleDist = srcVec.distanceTo(interceptPos.hitVec);

                    if (possibleDist < hitDist || hitDist == 0.0D)
                    {
                        pointedEntity = possibleEntity;
                        hitDist = possibleDist;
                    }
                }
            }
        }
		return pointedEntity;
	}
	
	public void faceVec(double xCoord, double yCoord, double zCoord, float yawConstraint, float pitchConstraint) {
		double xOffset = xCoord - entityHost.posX;
		double zOffset = zCoord - entityHost.posZ;
		double yOffset = (entityHost.posY + 0.25) - yCoord;

		double distance = MathHelper.sqrt_double(xOffset * xOffset + zOffset * zOffset);
		float xyAngle = (float)((Math.atan2(zOffset, xOffset) * 180D) / Math.PI) - 90F;
		float zdAngle = (float)(-((Math.atan2(yOffset, distance) * 180D) / Math.PI));
		entityHost.rotationPitch = -updateRotation(entityHost.rotationPitch, zdAngle, pitchConstraint);
		entityHost.rotationYaw = updateRotation(entityHost.rotationYaw, xyAngle, yawConstraint);
        
	}

    private float updateRotation(float par1, float par2, float par3) 
	{
        float var4 = MathHelper.wrapAngleTo180_float(par2 - par1);

        if (var4 > par3)
        {
            var4 = par3;
        }

        if (var4 < -par3)
        {
            var4 = -par3;
        }

        return par1 + var4;
	}
	
	
}
