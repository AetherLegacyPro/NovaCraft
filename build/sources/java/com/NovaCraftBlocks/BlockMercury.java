package com.NovaCraftBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.FluidRegistry;
import java.util.List;
import java.util.Random;

public class BlockMercury extends BlockFluidClassic {

    public static IIcon MoltenMercuryStillIcon;
    public static IIcon MoltenMercuryFlowingIcon;

    public static final Material mercuryMaterial = new MaterialLiquid(MapColor.ironColor);

    public static final DamageSource MERCURY_DAMAGE = new DamageSource("mercury").setDamageBypassesArmor();

    public BlockMercury() {
        super(FluidRegistry.getFluid("mercury"), mercuryMaterial);
        this.lightOpacity = 1;
    }

    @Override
    public void registerBlockIcons(final IIconRegister iconRegister) {
        BlockMercury.MoltenMercuryStillIcon = iconRegister.registerIcon("nova_craft:mercury_still");
        BlockMercury.MoltenMercuryFlowingIcon = iconRegister.registerIcon("nova_craft:mercury_flow");
    }

    @Override
    public IIcon getIcon(final int side, final int meta) {
        return side != 0 && side != 1 ? BlockMercury.MoltenMercuryFlowingIcon : BlockMercury.MoltenMercuryStillIcon;
    }

    @Override
    //Mercury has special collision based on the velocity of the entity in the X and Z directions
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity) {
        if (entity == null) {
            return;
        }

        if (!canEntityStandOnMercury(world, x, y, z, entity)) {
            return;
        }

        double surfaceY = getMercurySurfaceY(world, x, y, z);
        double platformTop = surfaceY - 0.03D;

        AxisAlignedBB mercuryPlatform = AxisAlignedBB.getBoundingBox(x, platformTop - 0.06D, z, x + 1, platformTop, z + 1);

        if (mask.intersectsWith(mercuryPlatform)) {
            list.add(mercuryPlatform);
        }
    }

    private boolean canEntityStandOnMercury(World world, int x, int y, int z, Entity entity) {
        if (!(entity instanceof EntityLivingBase)) {
            return false;
        }

        EntityLivingBase living = (EntityLivingBase) entity;

        if (living instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) living;

            if (player.capabilities.isFlying) {
                return false;
            }
        }

        //Removes collision for the liquid if the player is jumping
        if (living.motionY > 0.0D) {
            return false;
        }

        //Entities cannot sink if they have any X or Z velocity
        if (!hasXZMovement(living)) {
            return false;
        }

        double surfaceY = getMercurySurfaceY(world, x, y, z);

        //If submerged too deep the entity cannot walk on it easily
        return living.boundingBox.minY >= surfaceY - 0.35D;
    }

    private boolean hasXZMovement(EntityLivingBase living) {
        double horizontalMotionSq = (living.motionX * living.motionX) + (living.motionZ * living.motionZ);

        //Entities cannot sink if they have any X or Z velocity
        if (horizontalMotionSq > 0.0000001D) {
            return true;
        }

        return Math.abs(living.moveForward) > 0.01F || Math.abs(living.moveStrafing) > 0.01F;
    }

    private double getMercurySurfaceY(World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        int level = meta & 7;

        return y + 1.0D - ((double) level / 8.0D);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        super.onEntityCollidedWithBlock(world, x, y, z, entity);

        //Puts out fires due to lack of air if not in the Nether
        //I do not like liquids that can put out fires in the Nether...
        if (world.provider.dimensionId != -1) {
            entity.extinguish();
        } else {
            entity.setFire(10);
        }

        //If submerged damage the entity
        if (!world.isRemote && entity instanceof EntityLivingBase) {
            EntityLivingBase living = (EntityLivingBase) entity;

            if (isEntitySubmergedInMercury(world, x, y, z, living)) {
                if (living.ticksExisted % 60 == 0) {
                    living.attackEntityFrom(MERCURY_DAMAGE, 2.0F);
                    living.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
                }
            }
        }

        if (!(entity instanceof EntityLivingBase)) {
            return;
        }

        EntityLivingBase living = (EntityLivingBase) entity;

        if (living instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) living;

            if (player.capabilities.isFlying) {
                return;
            }
        }

        double surfaceY = getMercurySurfaceY(world, x, y, z);

        boolean movingInXZ = hasXZMovement(living);
        boolean rising = living.motionY > 0.0D;

        if (movingInXZ) {
            if (!rising) {
                double walkY = surfaceY - 0.03D;

                if (living.posY < walkY && living.posY > surfaceY - 0.35D) {
                    living.motionY = Math.max(living.motionY, 0.04D);
                }

                if (living.motionY < 0.0D) {
                    living.motionY = 0.0D;
                }

                living.onGround = true;
                living.fallDistance = 0.0F;
            }

            living.motionX *= 0.98D;
            living.motionZ *= 0.98D;

        } else {
            if (!rising) {
                living.onGround = false;

                living.motionY -= 0.004D;

                if (living.motionY < -0.018D) {
                    living.motionY = -0.018D;
                }

                living.fallDistance = 0.0F;
            }

            living.motionX *= 0.85D;
            living.motionZ *= 0.85D;
        }

        //Helper to allow entities to get out of the liquid if near an edge
        if (living.isCollidedHorizontally && movingInXZ) {
            living.motionY += 0.10D;

            if (living.motionY > 0.24D) {
                living.motionY = 0.24D;
            }

            living.fallDistance = 0.0F;
        }

        if (living.motionY > 0.0D) {
            living.fallDistance = 0.0F;
        }

        living.velocityChanged = true;
    }

    private boolean isEntitySubmergedInMercury(World world, int x, int y, int z, Entity entity) {
        double surfaceY = getMercurySurfaceY(world, x, y, z);
        double entityHeadY;

        if (entity instanceof EntityLivingBase) {
            EntityLivingBase living = (EntityLivingBase) entity;
            entityHeadY = entity.posY + living.getEyeHeight();
        } else {
            entityHeadY = entity.boundingBox.maxY;
        }

        return entityHeadY < surfaceY;
    }

    @Override
    public void updateTick(final World world, final int x, final int y, final int z, final Random rand) {
        super.updateTick(world, x, y, z, rand);
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
    }

    @Override
    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        super.onBlockAdded(world, x, y, z);
    }

    @Override
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        super.onNeighborBlockChange(world, x, y, z, block);
    }
}