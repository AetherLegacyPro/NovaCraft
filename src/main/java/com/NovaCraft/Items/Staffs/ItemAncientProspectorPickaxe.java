package com.NovaCraft.Items.Staffs;

import java.util.List;

import com.NovaCraft.Items.Tools.NCToolMaterial;
import com.NovaCraft.entity.EntityFireProofItemNovaCraft;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemAncientProspectorPickaxe extends ItemPickaxe {
    private static final int SEARCH_SIZE = 32;
    private static final int SEARCH_HALF = SEARCH_SIZE / 2;

    private static final int MIN_PARTICLES = 1;
    private static final int MAX_PARTICLES = 9;

    private static final int ORE_TYPE_COUNT = 7;

    private static final int TRILLINT = 0;
    private static final int KREENOVITE = 1;
    private static final int XIFESONITE = 2;
    private static final int IRIDIUM = 3;
    private static final int TOPHINITE = 4;
    private static final int KLANGITE = 5;
    private static final int CRYSTALLIZED_END = 6;

    public ItemAncientProspectorPickaxe() {
        super(NCToolMaterial.ANCIENT_PROSPECTOR_PICK);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
        tooltip.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("tooltip.ancient_prospector_pickaxe.desc"));
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            stack.damageItem(1, player);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            return true;
        }

        int[] nearestDistances = this.findNearestProspectorTargets(world, x, y, z);

        for (int oreType = 0; oreType < ORE_TYPE_COUNT; ++oreType) {
            this.spawnForDetectedOre(world, x, y, z, nearestDistances[oreType], oreType);
        }

        return true;
    }

    private int[] findNearestProspectorTargets(World world, int centerX, int centerY, int centerZ) {
        int[] nearestDistances = new int[ORE_TYPE_COUNT];
        for (int i = 0; i < nearestDistances.length; ++i) {
            nearestDistances[i] = Integer.MAX_VALUE;
        }

        int minimumX = centerX - SEARCH_HALF;
        int maximumX = minimumX + SEARCH_SIZE - 1;

        int minimumY = Math.max(0, centerY - SEARCH_HALF);
        int maximumY = Math.min(255, centerY - SEARCH_HALF + SEARCH_SIZE - 1);

        int minimumZ = centerZ - SEARCH_HALF;
        int maximumZ = minimumZ + SEARCH_SIZE - 1;

        for (int blockX = minimumX; blockX <= maximumX; ++blockX) {
            for (int blockY = minimumY; blockY <= maximumY; ++blockY) {
                for (int blockZ = minimumZ; blockZ <= maximumZ; ++blockZ) {
                    Block block = world.getBlock(blockX, blockY, blockZ);
                    int metadata = world.getBlockMetadata(blockX, blockY, blockZ);

                    int oreType = this.getTargetType(block, metadata);
                    if (oreType < 0) {
                        continue;
                    }

                    int differenceX = Math.abs(blockX - centerX);
                    int differenceY = Math.abs(blockY - centerY);
                    int differenceZ = Math.abs(blockZ - centerZ);

                    int distance = Math.max(differenceX, Math.max(differenceY, differenceZ));

                    if (distance < nearestDistances[oreType]) {
                        nearestDistances[oreType] = distance;
                    }
                }
            }
        }

        return nearestDistances;
    }


    //Add additional flame every two blocks closer to the ore
    private int getParticleCount(int distance) {
        if (distance == Integer.MAX_VALUE) {
            return 0;
        }

        int blocksCloser = SEARCH_HALF - distance;
        if (blocksCloser < 0) {
            blocksCloser = 0;
        }

        int particleCount = MIN_PARTICLES + blocksCloser / 2;

        if (particleCount < MIN_PARTICLES) {
            particleCount = MIN_PARTICLES;
        }

        if (particleCount > MAX_PARTICLES) {
            particleCount = MAX_PARTICLES;
        }

        return particleCount;
    }

    private void spawnForDetectedOre(World world, int blockX, int blockY, int blockZ, int distance, int oreType) {
        int particleCount = this.getParticleCount(distance);
        for (int i = 0; i < particleCount; ++i) {
            this.spawnOreParticle(world, blockX, blockY, blockZ, oreType);
        }
    }

    private void spawnOreParticle(World world, int x, int y, int z, int oreType) {
        double particleX = (double)x + 0.1D + world.rand.nextDouble() * 0.8D;
        double particleY = (double)y + 1.02D + world.rand.nextDouble() * 0.45D;
        double particleZ = (double)z + 0.1D + world.rand.nextDouble() * 0.8D;

        double motionX = (world.rand.nextDouble() - 0.5D) * 0.08D;
        double motionY = 0.01D + world.rand.nextDouble() * 0.06D;
        double motionZ = (world.rand.nextDouble() - 0.5D) * 0.08D;

        switch (oreType) {
            case TRILLINT:
            case XIFESONITE:
            case KREENOVITE:
                ParticleHandler.LEGENDARYFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case IRIDIUM:
                ParticleHandler.IRIDIUMFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case TOPHINITE:
                ParticleHandler.TOPHINITEFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case KLANGITE:
                ParticleHandler.KLANGITEFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case CRYSTALLIZED_END:
                ParticleHandler.CRYSTALENDFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            default:
                break;
        }
    }

    private int getTargetType(Block block, int metadata) {
        if (block == NovaCraftBlocks.unbreakable_legendary_ore && metadata == 0) {
            return TRILLINT;
        }

        if (block == NovaCraftBlocks.unbreakable_legendary_ore && metadata == 1) {
            return KREENOVITE;
        }

        if (block == NovaCraftBlocks.unbreakable_legendary_ore && metadata == 2) {
            return XIFESONITE;
        }

        if (block == NovaCraftBlocks.iridium_ore) {
            return IRIDIUM;
        }

        if (block == NovaCraftBlocks.nether_tophinite_ore) {
            return TOPHINITE;
        }

        if (block == NovaCraftBlocks.frontierslate_klangite_ore || block == NovaCraftBlocks.end_klangite_ore) {
            return KLANGITE;
        }

        if (block == NovaCraftBlocks.crystallized_end) {
            return CRYSTALLIZED_END;
        }

        return -1;
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Override
    public Entity createEntity(World world, Entity location, ItemStack stack) {
        return new EntityFireProofItemNovaCraft(world, location, stack);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.epic;
    }
}