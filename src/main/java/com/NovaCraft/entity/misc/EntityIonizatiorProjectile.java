package com.NovaCraft.entity.misc;

import java.util.List;

import com.NovaCraft.config.Configs;
import com.NovaCraft.entity.EntityIonizatior;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityIonizatiorProjectile extends EntityFireball
{
    private static final String __OBFID = "CL_00001721";

    public EntityIonizatiorProjectile(World p_i1770_1_)
    {
        super(p_i1770_1_);
        this.setSize(0.0125F, 0.0125F);
    }

    public EntityIonizatiorProjectile(World p_i1771_1_, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_)
    {
        super(p_i1771_1_, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntityIonizatiorProjectile(World p_i1772_1_, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_)
    {
        super(p_i1772_1_, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
        this.setSize(0.3125F, 0.3125F);
    }
    
    @SideOnly(Side.CLIENT)
    public void onEntityUpdate() {
    	super.onEntityUpdate();
    	if (this.worldObj.isRemote) {
    	int k;
        if (Configs.enableIonizatiorParticles) {
        	for (k = 0; k < 4; ++k)
        	{
        		ParticleHandler.IONFLAME.spawn(worldObj, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width);
        		}
        	}
    	}
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70227_1_)
    {
        if (!this.worldObj.isRemote)
        {
            if (p_70227_1_.entityHit != null)
            {              
                if (p_70227_1_.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 2.0F))
                {
                    p_70227_1_.entityHit.setFire(15);
                	}           	
                
                //p_70227_1_.entityHit.attackEntityFrom(DamageSource.magic, 3.0F);
                
                List<?> entityList = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.0D, 4.0D, 0.0D));
                for (int ammount = 0; ammount < entityList.size(); ++ammount) {
                    Entity entity = (Entity) entityList.get(ammount);
                    {
               if (!(entity instanceof EntityIonizatior)) {
                if (entity.isImmuneToFire()) {
                	p_70227_1_.entityHit.attackEntityFrom(DamageSource.generic, 5.0F);
                	p_70227_1_.entityHit.attackEntityFrom(DamageSource.magic, 3.0F);
                	}
                else {
                	p_70227_1_.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 3.0F);
                	p_70227_1_.entityHit.attackEntityFrom(DamageSource.magic, 3.0F);
                	}
                    	}
                    }
                	
                }
            }
            else
            {
                int i = p_70227_1_.blockX;
                int j = p_70227_1_.blockY;
                int k = p_70227_1_.blockZ;

                switch (p_70227_1_.sideHit)
                {
                    case 0:
                        --j;
                        break;
                    case 1:
                        ++j;
                        break;
                    case 2:
                        --k;
                        break;
                    case 3:
                        ++k;
                        break;
                    case 4:
                        --i;
                        break;
                    case 5:
                        ++i;
                }

                if (this.worldObj.isAirBlock(i, j, k))
                {
                    this.worldObj.setBlock(i, j, k, NovaCraftBlocks.deepfire);
                }
            }
            
            if (p_70227_1_.entityHit instanceof EntityPlayerMP) {
				((EntityPlayerMP) p_70227_1_.entityHit).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(p_70227_1_.entityHit));
			}

            this.setDead();
        }
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return false;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        return false;
    }
}
