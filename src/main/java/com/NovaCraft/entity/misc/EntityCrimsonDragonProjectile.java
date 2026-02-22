package com.NovaCraft.entity.misc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCrimsonDragonProjectile extends EntityProjectileBase {

    public EntityCrimsonDragonProjectile(World world) {
        super(world);
    }

    public EntityCrimsonDragonProjectile(World world, EntityLivingBase thrower, double x, double y, double z) {
        super(world, thrower);

        this.setPosition(x, y, z);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

        if (this.ticksInAir > 150) {
            this.setDead();
        } else {
            this.ticksInAir++;
        }
    }

    @Override
    protected void onImpact(MovingObjectPosition object) {
        if (object.entityHit instanceof EntityLivingBase) {

            object.entityHit.motionX += this.motionX * 2.0F;
            object.entityHit.motionY += 0.5D;
            object.entityHit.motionZ += this.motionZ * 2.0F;

            ((EntityLivingBase)object.entityHit).addPotionEffect(new PotionEffect(Potion.poison.id, 160, 0));

            if (object.entityHit instanceof EntityPlayerMP) {
                ((EntityPlayerMP) object.entityHit).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(object.entityHit));
            }

            this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 1.6f, false);

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
                    this.worldObj.setBlock(i, j + 1, k, Blocks.fire);
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
