package com.NovaCraft.entity;

import java.util.List;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.misc.EnumFrogType;
import net.minecraft.entity.ai.EntityAITargetNonTamed;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityFrog extends EntityAnimal {

	private boolean isJumping;
	private boolean isCroaking;
	private boolean isSwimming;
	
	private float jumpTimer;
	private float croakTimer;
	private float swimTimer;

	public boolean isJumpingAnim() { return isJumping; }
	public boolean isCroakingAnim() { return isCroaking; }
	public boolean isSwimmingAnim() { return isSwimming; }

	public float getJumpTimer() { return jumpTimer; }
	public float getCroakTimer() { return croakTimer; }
	public float getSwimTimer() { return swimTimer; }

    public EntityFrog(final World world) {
        super(world);
        
        if (this.getType() == EnumFrogType.BROWN || this.getType() == EnumFrogType.GREEN || this.getType() == EnumFrogType.YELLOW || this.getType() == EnumFrogType.LIGHT_BLUE || this.getType() == EnumFrogType.TREE_1 || this.getType() == EnumFrogType.TREE_2 || this.getType() == EnumFrogType.TREE_3) {
        	this.setSize(0.75f, 0.75f); 
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0);
        	this.setHealth(4.0f);
        } else {
        	this.setSize(0.1f, 0.1f); 
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25);
        	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2.0);
        	this.setHealth(2.0f);
        }
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 0.25D, Items.slime_ball, false));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(6, new EntityAIFollowParent(this, 1.1D));
    }
    
    @Override
    public boolean isInWater() {
        return this.worldObj.getBlock((int)this.posX, (int)this.boundingBox.minY, (int)this.posZ).getMaterial().isLiquid();
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(21, (byte) this.rand.nextInt(EnumFrogType.values().length));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        
        this.fallDistance = 0.0f;
        
        if (!onGround && motionY > 0.15 && !isJumping) {
        	isJumping = true;
            jumpTimer = 0f;
        }
        if (isJumping) {
            jumpTimer += 1.0f / 20.0f;
            if (jumpTimer > 0.5f) isJumping = false;
        }
        
        isSwimming = this.isInWater();

        if (isSwimming) {
            swimTimer += 1.0f / 20.0f;
        } else {
            swimTimer = 0f;
        }

        if (!isCroaking && rand.nextInt(100) == 0) {
        	isCroaking = true;
            croakTimer = 0f;
        }
        if (isCroaking) {
            croakTimer += 1.0f / 20.0f;
            if (croakTimer > 0.7f) isCroaking = false;
        }
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.isCroaking) {
            this.croakTimer += 1.0F / 20.0F;
            if (this.croakTimer >= 0.7F) {
                this.isCroaking = false;
                this.croakTimer = 0;
            }
        } else if (this.rand.nextInt(200) == 0 && !this.isInWater()) {
            this.isCroaking = true;
            this.croakTimer = 0;
        }

        if (this.isJumping && (this.onGround || this.isInWater())) {
            this.jumpTimer += 1.0F / 20.0F;
            if (this.jumpTimer >= 0.25F) {
            	this.motionY += 1.0;
                this.isJumping = false;
                this.jumpTimer = 0;
            }
        }

        if (this.isInWater()) {
            this.isSwimming = true;
            this.swimTimer += 1.0F / 20.0F;
        } else {
            this.isSwimming = false;
            this.swimTimer = 0;
        }
        
        if (this.getType() == EnumFrogType.POSION_1 || this.getType() == EnumFrogType.POSION_2 || this.getType() == EnumFrogType.POSION_3 || this.getType() == EnumFrogType.POSION_4) {
        List<Entity> volume = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1, 1, 1));
    	for(Entity entity : volume) {
    		if(entity instanceof EntityPlayer && this.canEntityBeSeen(entity)) ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 80, 2, true));
    		}
        }
    }
    
    protected String getLivingSound() {
        return "nova_craft:frog.living";
    }
    
    protected String getHurtSound() {
        return "nova_craft:frog.hurt";
    }
    
    protected String getDeathSound() {
        return "nova_craft:frog.death";
    }
    
    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
        this.playSound("nova_craft:frog.step", 0.25f, 1.0f);
    }
    
    public boolean isPotionApplicable(PotionEffect p_70687_1_)
    {
        return p_70687_1_.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(p_70687_1_);
    }
    
    public EnumFrogType getType()
    {
        int id = this.dataWatcher.getWatchableObjectByte(21);

        return EnumFrogType.get(id);
    }

    public void setType(int id)
    {
        this.dataWatcher.updateObject(21, (byte) id);
    }
    
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger("FrogType", this.getType().getId());
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.setType(p_70037_1_.getInteger("FrogType"));
    }
    
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {        
        if (!(this.getType() == EnumFrogType.POSION_1) && !(this.getType() == EnumFrogType.POSION_2) && !(this.getType() == EnumFrogType.POSION_3) && !(this.getType() == EnumFrogType.POSION_4)) {
            if (this.isBurning())
            {
                this.dropItem(NovaCraftItems.cooked_frog_leg, 1);
            }
            else
            {
                this.dropItem(NovaCraftItems.raw_frog_leg, 1);
            }
        }
    }
    
  //Credit to Roadhog360 or the original Et Futurum author for this code
    @Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData livingdata) {
		BiomeGenBase biome = worldObj.getBiomeGenForCoords((int) posX, (int) posZ);
		if (biome == BiomeGenBase.forest || biome == BiomeGenBase.forestHills || biome == BiomeGenBase.birchForest || biome == BiomeGenBase.birchForestHills || biome == BiomeGenBase.river) {
			int typeTemperate = rand.nextInt(10);
			if (typeTemperate <= 3) {
				setType(EnumFrogType.TREE_1.ordinal());
			} else if (typeTemperate > 3 && typeTemperate < 7) {
				setType(EnumFrogType.TREE_2.ordinal());
			} else {
				setType(EnumFrogType.TREE_3.ordinal());
			}
		} else if (biome == BiomeGenBase.swampland) {
			int typeSwamp = rand.nextInt(12);
			if (typeSwamp <= 3) {
				setType(EnumFrogType.GREEN.ordinal());
			} else if (typeSwamp > 3 && typeSwamp <= 7) {
				setType(EnumFrogType.BROWN.ordinal());
			} else if (typeSwamp > 7 && typeSwamp <= 10)  {
				setType(EnumFrogType.YELLOW.ordinal());
			} else {
				setType(EnumFrogType.LIGHT_BLUE.ordinal());
			}
		} else if (biome == BiomeGenBase.jungle || biome == BiomeGenBase.jungleHills || biome == BiomeGenBase.jungleEdge) {
			int typeJungle = rand.nextInt(12);
			if (typeJungle <= 3) {
				setType(EnumFrogType.POSION_1.ordinal());
			} else if (typeJungle > 3 && typeJungle <= 7) {
				setType(EnumFrogType.POSION_2.ordinal());
			} else if (typeJungle > 7 && typeJungle <= 10)  {
				setType(EnumFrogType.POSION_3.ordinal());
			} else {
				setType(EnumFrogType.POSION_4.ordinal());
			}
		}
        else {
            setType(rand.nextInt(7));
        }
			int type = rand.nextInt(11);
			switch (type) {
				case 0:
					type = EnumFrogType.GREEN.ordinal();
					break;
				case 1:
					type = EnumFrogType.BROWN.ordinal();
					break;
				case 2:
					type = EnumFrogType.YELLOW.ordinal();
					break;
				case 3:
					type = EnumFrogType.LIGHT_BLUE.ordinal();
					break;
				case 4:
					type = EnumFrogType.TREE_1.ordinal();
					break;
				case 5:
					type = EnumFrogType.TREE_2.ordinal();
					break;
				case 6:
					type = EnumFrogType.TREE_3.ordinal();
					break;
				case 7:
					type = EnumFrogType.POSION_1.ordinal();
					break;
				case 8:
					type = EnumFrogType.POSION_2.ordinal();
					break;
				case 9:
					type = EnumFrogType.POSION_3.ordinal();
					break;
				case 10:
					type = EnumFrogType.POSION_4.ordinal();
					break;
				default:
					setType(4 + rand.nextInt(2));
			}

		return super.onSpawnWithEgg(livingdata);
	}
    
    @Override
	public EntityAgeable createChild(EntityAgeable parent) {
    	EntityFrog child = new EntityFrog(this.worldObj);
    	int otherParentType = this.getType().getId();
    	int parentType = parent instanceof EntityFrog ? ((EntityFrog) parent).getType().getId() : -1;
    	
    	boolean SwampFrog = (otherParentType >= 0 && otherParentType <= 3) || (parentType >= 0 && parentType <= 3);
    	boolean TreeFrog = (otherParentType >= 4 && otherParentType <= 6) || (parentType >= 4 && parentType <= 6);
    	boolean PosionFrog = (otherParentType > 6 && otherParentType > 6) || (parentType > 6 && parentType > 6);
    	
    	if (SwampFrog && !TreeFrog && !PosionFrog) {
    		child.setType(this.rand.nextInt(4));
    	} else if (TreeFrog && !PosionFrog) {
    		child.setType(4 + this.rand.nextInt(3));
    	} else if (PosionFrog) {
    		child.setType(7 + this.rand.nextInt(4));
    	}
    	
    	return child;
	}

    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack != null && itemStack.getItem() == Items.slime_ball;
    }

    @Override
    public boolean canDespawn() {
        return false;
    }
}
