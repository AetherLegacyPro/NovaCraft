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
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemGeodeStaff extends ItemPickaxe {
    private static final int SEARCH_SIZE = 32;
    private static final int SEARCH_HALF = SEARCH_SIZE / 2;

    private static final int MIN_PARTICLES = 1;
    private static final int MAX_PARTICLES = 9;

    private static final int GEODE_COUNT = 6;

    private static final int AMETHYST = 0;
    private static final int RED = 1;
    private static final int BLUE = 2;
    private static final int GREEN = 3;
    private static final int ORANGE = 4;
    private static final int AETHER = 5;

    public ItemGeodeStaff() {
        super(NCToolMaterial.PRIMEVAL_HORN);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
        tooltip.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("tooltip.geode_staff.desc"));
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            stack.damageItem(1, player);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            return true;
        }

        int[] nearestDistances = this.findNearestProspectorTargets(world, x, y, z);

        for (int oreType = 0; oreType < GEODE_COUNT; ++oreType) {
            this.spawnForDetectedOre(world, x, y, z, nearestDistances[oreType], oreType);
        }

        return true;
    }

    private int[] findNearestProspectorTargets(World world, int centerX, int centerY, int centerZ) {
        int[] nearestDistances = new int[GEODE_COUNT];
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
            case AMETHYST:
                ParticleHandler.SMALLIONFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case BLUE:
                ParticleHandler.BLUEFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case RED:
                ParticleHandler.SMALLREDFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case GREEN:
                ParticleHandler.GLOWFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case ORANGE:
                ParticleHandler.REGULARFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case AETHER:
                ParticleHandler.LEGENDARYFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            default:
                break;
        }
    }

    private int getTargetType(Block block, int metadata) {
        if (block == OtherModBlocks.budding_amethyst) {
            return AMETHYST;
        }

        if (block == NovaCraftBlocks.budding_copartz_block) {
            return RED;
        }

        if (block == NovaCraftBlocks.budding_larimar_block) {
            return BLUE;
        }

        if (block == NovaCraftBlocks.budding_tsavorokite_block) {
            return GREEN;
        }

        if (block == NovaCraftBlocks.budding_yttrlinsite_block) {
            return ORANGE;
        }

        if (block == NovaCraftBlocks.budding_aether_block) {
            return AETHER;
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
        return EnumRarity.uncommon;
    }
}
