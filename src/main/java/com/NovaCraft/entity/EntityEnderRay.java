package com.NovaCraft.entity;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.misc.EntityRayfireball;

import net.minecraft.item.Item;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import java.util.Iterator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Items;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.EntityFlying;

public class EntityEnderRay extends EntityFlying implements IMob
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    public boolean hasSpecialTexture;
    private Entity targetedEntity;
    private Entity attackedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    private final float base;
    
    public EntityEnderRay(final World par1World) {
        super(par1World);
        this.courseChangeCooldown = 0;
        this.hasSpecialTexture = false;
        this.targetedEntity = null;
        this.attackedEntity = null;
        this.aggroCooldown = 0;
        this.prevAttackCounter = 0;
        this.attackCounter = 0;
        this.setSize(6.0f, 1.0f);
        this.hasSpecialTexture = (this.rand.nextInt(2) == 0);
        this.experienceValue = 10;
        this.base = (this.getRNG().nextFloat() - this.getRNG().nextFloat()) * 0.2F + 1.0F;
    }
    
    @SideOnly(Side.CLIENT)
    public String func_70073_O() {
        if (this.hasSpecialTexture) {
            return "novacraft:textures/entity/ender_ray/ender_ray_scars.png";
        }
        return "novacraft:textures/entity/ender_ray/ender_ray.png";
    }
    
    public int func_70667_aM() {
        return 40;
    }
    
    public void onUpdate() {
    	if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        super.onUpdate();
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity target) {			

        if (target instanceof EntityPlayer) {

            ItemStack helmet = ((EntityPlayer) target).getCurrentArmor(3);
            ItemStack chest = ((EntityPlayer) target).getCurrentArmor(2);
            ItemStack legs = ((EntityPlayer) target).getCurrentArmor(1);
            ItemStack boots = ((EntityPlayer) target).getCurrentArmor(0);

            boolean hasphantomHelmet = false;
            boolean hasphantomChest = false;
            boolean hasphantomLegs = false;
            boolean hasphantomBoots = false;


            if(helmet != null)
                hasphantomHelmet = helmet.getItem() == NovaCraftItems.phantom_helmet;

            if(chest != null)
                hasphantomChest = chest.getItem() == NovaCraftItems.phantom_chestplate;

            if(legs != null)
                hasphantomLegs = legs.getItem() == NovaCraftItems.phantom_leggings;

            if(boots != null)
                hasphantomBoots = boots.getItem() == NovaCraftItems.phantom_boots;

            if (hasphantomHelmet || hasphantomChest || hasphantomLegs || hasphantomBoots) {

            	target.attackEntityFrom(DamageSource.magic, 4.0F);
            }
            
            else {
            	target.attackEntityFrom(DamageSource.magic, 10.0F);
            }
             
        }
        
        return true;
    }
    
    protected void updateEntityActionState() {
    	if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)
		{
			this.setDead();
		}

		this.despawnEntity();
		this.prevAttackCounter = this.attackCounter;
		double d0 = this.waypointX - this.posX;
		double d1 = this.waypointY - this.posY;
		double d2 = this.waypointZ - this.posZ;
		double d3 = d0 * d0 + d1 * d1 + d2 * d2;

		if (d3 < 1.0D || d3 > 3600.0D)
		{
			this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
		}

		if (this.courseChangeCooldown-- <= 0)
		{
			this.courseChangeCooldown += this.rand.nextInt(5) + 2;
			d3 = (double)MathHelper.sqrt_double(d3);

			if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3))
			{
				this.motionX += d0 / d3 * 0.1D;
				this.motionY += d1 / d3 * 0.1D;
				this.motionZ += d2 / d3 * 0.1D;
			}
			else
			{
				this.waypointX = this.posX;
				this.waypointY = this.posY;
				this.waypointZ = this.posZ;
			}
		}

		this.prevAttackCounter = this.attackCounter;

		if (this.getAttackTarget() == null) {
			if (this.attackCounter > 0) {
				this.attackCounter--;
			}

			this.setAttackTarget(this.worldObj.getClosestVulnerablePlayerToEntity(this, 100D));
		} else {
			if (this.getAttackTarget() instanceof EntityPlayer && (((EntityPlayer) this.getAttackTarget()).capabilities.isCreativeMode)) {
				this.setAttackTarget(null);
				return;
			}

			if (this.getAttackTarget().getDistanceSqToEntity(this) < 4096.0D && this.canEntityBeSeen(this.getAttackTarget())) {
				double x = this.getAttackTarget().posX - this.posX;
				double y = (this.getAttackTarget().boundingBox.minY + (this.getAttackTarget().height / 2.0F)) - (this.posY + (this.height / 2.0F));
				double z = this.getAttackTarget().posZ - this.posZ;

				this.rotationYaw = (-(float) Math.atan2(x, z) * 180F) / 3.141593F;

				++this.attackCounter;

				if (this.attackCounter == 10) {
					this.playSound("nova_craft:ender_ray.charge", 10F, this.base);
				} else if (this.attackCounter == 20) {
					this.playSound("nova_craft:ender_ray.charge", 10F, this.base);

					EntityRayfireball projectile = new EntityRayfireball(this.worldObj, this, x, y, z);
					Vec3 lookVector = this.getLook(1.0F);

					projectile.posX = this.posX + lookVector.xCoord * 4D;
					projectile.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
					projectile.posZ = this.posZ + lookVector.zCoord * 4D;

					if (!this.worldObj.isRemote) {
						projectile.setThrowableHeading(x, y, z, 1.2F, 1.0F);
						this.worldObj.spawnEntityInWorld(projectile);
					}

					this.attackCounter = -20;
				}
			} else if (this.attackCounter > 0) {
				this.attackCounter--;
			}
		}
      
    }
    
    public boolean attackEntityFrom(final DamageSource par1DamageSource, final int par2) {
        if (par1DamageSource.getSourceOfDamage() instanceof EntityPlayer) {
            this.attackedEntity = par1DamageSource.getSourceOfDamage();
        }
        if (par1DamageSource.getSourceOfDamage() instanceof EntityArrow) {
            this.attackedEntity = ((EntityArrow)par1DamageSource.getSourceOfDamage()).shootingEntity;
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }
    
    private boolean isCourseTraversable(final double x, final double y, final double z, final double distance) {
    	double d4 = (this.waypointX - this.posX) / distance;
		double d5 = (this.waypointY - this.posY) / distance;
		double d6 = (this.waypointZ - this.posZ) / distance;
		AxisAlignedBB axisalignedbb = this.boundingBox.copy();

		for (int i = 1; (double)i < distance; ++i)
		{
			axisalignedbb.offset(d4, d5, d6);

			if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty())
			{
				return false;
			}
		}
        return true;
    }
    
    protected String getLivingSound() {
        return "nova_craft:ender_ray.living";
    }
    
    protected String getHurtSound() {
        return "nova_craft:ender_ray.hurt";
    }
    
    protected String getDeathSound() {
        return "nova_craft:ender_ray.death";
    }
    
    protected String getChargeSound() {
        return "nova_craft:ender_ray.charge";
    }
    
    protected float getSoundVolume() {
        return 6.0f;
    }
    
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        Item item = this.getDropItem();

        if (item != null)
        {
            int j = this.rand.nextInt(2 + p_70628_2_);

            for (int k = 0; k < j; ++k)
            {
                this.dropItem(item, 1);
            }
        }
    }
    
    protected Item getDropItem()
    {
        return Items.ender_pearl;
    }
    
    protected void dropRareDrop(int p_70600_1_)
    {

       this.dropItem(NovaCraftItems.fractured_heart_of_the_end, 1);

    }
}
