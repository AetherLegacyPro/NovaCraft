package com.NovaCraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class WitherBossAlterations {

    private static final String INITIAL_SPAWN_TAG = "InitialSpawn";
    private static final double SUPPORT_CHANCE = 0.05D; //Chance Wither Skeletons are summoned below 1/2 HP
    private static final double HALF_HP = 0.5D;
    private static final int BLOCK_BURST_COOLDOWN = 100; //In Ticks so about 5 second cooldown between block breaking
    private static final double BLOCK_BURST_CHANCE = 0.025D;

    @SubscribeEvent
    public void onWitherDamaged(LivingHurtEvent event) {
        if (!(event.entityLiving instanceof EntityWither)) return;

        EntityWither wither = (EntityWither) event.entityLiving;
        World world = wither.worldObj;
        if (world.isRemote) return;

        if (!(event.source.getEntity() instanceof EntityPlayer)) return;

        NBTTagCompound data = wither.getEntityData();
        double maxHP = wither.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
        double prevHP = wither.getHealth();
        double newHP = prevHP - event.ammount;
        double halfHP = maxHP * HALF_HP;

        boolean belowHalf = newHP <= halfHP;
        boolean alreadyTriggered = data.getBoolean("WitherSkeletonsSummoned");

        if (belowHalf && !alreadyTriggered) {
            summonWitherSkeletons(world, wither, 3);
            data.setBoolean("WitherSkeletonsSummoned", true);
        } else if (belowHalf && world.rand.nextDouble() < SUPPORT_CHANCE) {
            summonWitherSkeletons(world, wither, 2 + world.rand.nextInt(2));
        }
    }

    private void summonWitherSkeletons(World world, EntityWither wither, int count) {
        int skeletonCount = 3;
        double radius = 2.0D;

        for (int i = 0; i < skeletonCount; i++) {
            double angle = (2 * Math.PI / skeletonCount) * i;
            double offsetX = Math.cos(angle) * radius;
            double offsetZ = Math.sin(angle) * radius;

            EntitySkeleton mob = new EntitySkeleton(world);
            mob.setSkeletonType(1);
            mob.setLocationAndAngles(wither.posX + offsetX, wither.posY, wither.posZ + offsetZ, world.rand.nextFloat() * 360F, 0.0F);
            mob.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
            world.spawnEntityInWorld(mob);
        }
    }

    @SubscribeEvent
    public void onWitherSpawn(EntityJoinWorldEvent event) {
        if (event.world.isRemote) return;
        if (!(event.entity instanceof EntityWither)) return;

        EntityWither wither = (EntityWither) event.entity;

        //Total HP
        wither.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(600.0D);

        //Upon spawn the Wither Charges up to full HP, do not want to alter the timer to as I am lazy so the Wither is set to 380HP and powers up to 600HP
        if (!wither.getEntityData().getBoolean(INITIAL_SPAWN_TAG)) {
            wither.setHealth(380.0F);

            wither.getEntityData().setBoolean(INITIAL_SPAWN_TAG, true);
        }
        if (wither.getHealth() < 300.0D) {
            wither.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
        } else {
            wither.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45D);
        }
    }

    @SubscribeEvent
    public void onEntitySpawn(EntityJoinWorldEvent event) {
        if (!event.world.isRemote && event.entity instanceof EntityWither) {
            EntityWither wither = (EntityWither) event.entity;
            modifyWitherStats(wither);
        }
    }

    private void modifyWitherStats(EntityWither wither) {
        try {
            wither.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(600.0D);
            //If I do not have the if statement upon reloading the world the Wither's HP would be reset to full
            if (wither.getHealth() > wither.getMaxHealth()) {
                wither.setHealth(wither.getMaxHealth());
            }
            if (wither.getHealth() < 300.0D) {
                wither.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
            } else {
                wither.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45D);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SubscribeEvent
    public void onWitherTick(LivingEvent.LivingUpdateEvent event) {
        if (!(event.entityLiving instanceof EntityWither)) return;

        EntityWither wither = (EntityWither) event.entityLiving;
        World world = wither.worldObj;
        if (world.isRemote) return;

        NBTTagCompound data = wither.getEntityData();
        double maxHP = wither.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
        double currentHP = wither.getHealth();

        if (currentHP > (maxHP * 0.63D)) {
            return;
        }

        int burstCooldown = data.getInteger("BlockBurstCooldown");

        if (burstCooldown > 0) {
            data.setInteger("BlockBurstCooldown", burstCooldown - 1);
            return;
        }

        //Break Blocks around the Wither
        if (world.rand.nextDouble() < BLOCK_BURST_CHANCE) {
            destroyNearbyBlocks(wither, world, 4);

            data.setInteger("BlockBurstCooldown", BLOCK_BURST_COOLDOWN);
        }
    }

    private void destroyNearbyBlocks(EntityWither wither, World world, int radius) {
        int baseX = (int) Math.floor(wither.posX);
        int baseY = (int) Math.floor(wither.posY);
        int baseZ = (int) Math.floor(wither.posZ);

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    Block block = world.getBlock(baseX + x, baseY + y, baseZ + z);
                    if (block == Blocks.air) continue;

                    if (block == Blocks.bedrock || block == Blocks.command_block ||
                            block == Blocks.end_portal || block == Blocks.end_portal_frame) continue;

                    float hardness = block.getBlockHardness(world, baseX + x, baseY + y, baseZ + z);
                    if (hardness >= 0.0F && hardness <= 50.0F) {
                        world.setBlockToAir(baseX + x, baseY + y, baseZ + z);
                        world.playAuxSFX(2001, baseX + x, baseY + y, baseZ + z, Block.getIdFromBlock(block));
                    }
                }
            }
        }

        world.playSoundAtEntity(wither, "random.explode", 1.5F, 0.8F);
        world.newExplosion(wither, wither.posX, wither.posY, wither.posZ, 0.0F, false, false);
    }

}
