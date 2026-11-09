package com.NovaCraft.Items.Staffs;

import java.util.List;
import com.NovaCraft.Items.Tools.NCToolMaterial;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.registry.NovaCraftCreativeTabs;
import com.NovaCraft.registry.OtherModBlocks;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemDegradedProspectorPickaxe extends ItemPickaxe {
    private static final int ORE_TYPE_COUNT = 7;

    private static final int DIAMOND = 0;
    private static final int VANITE = 1;
    private static final int ANCIENT_DEBRIS = 2;
    private static final int IRIDIUM = 3;
    private static final int TOPHINITE = 4;
    private static final int KLANGITE = 5;
    private static final int CRYSTALLIZED_END = 6;

    private static final int SEARCH_RADIUS = 3;

    public ItemDegradedProspectorPickaxe() {
        super(NCToolMaterial.PROSPECTOR_PICK);
        this.setCreativeTab(NovaCraftCreativeTabs.tools);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
        tooltip.add(EnumChatFormatting.WHITE + StatCollector.translateToLocal("tooltip.degraded_prospector_pickaxe.desc"));
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            stack.damageItem(1, player);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 2.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            return true;
        }

        boolean[] foundTypes = this.findProspectorTargets(world, x, y, z);

        for (int oreType = 0; oreType < ORE_TYPE_COUNT; ++oreType) {
            if (foundTypes[oreType]) {
                this.spawnOreParticle(world, x, y, z, oreType);
            }
        }

        return true;
    }

    private boolean[] findProspectorTargets(World world, int centerX, int centerY, int centerZ) {
        boolean[] foundTypes = new boolean[ORE_TYPE_COUNT];

        int minimumY = Math.max(0, centerY - SEARCH_RADIUS);
        int maximumY = Math.min(255, centerY + SEARCH_RADIUS);

        for (int blockX = centerX - SEARCH_RADIUS; blockX <= centerX + SEARCH_RADIUS; ++blockX) {
            for (int blockY = minimumY; blockY <= maximumY; ++blockY) {
                for (int blockZ = centerZ - SEARCH_RADIUS; blockZ <= centerZ + SEARCH_RADIUS; ++blockZ) {
                    Block block = world.getBlock(blockX, blockY, blockZ);
                    int metadata = world.getBlockMetadata(blockX, blockY, blockZ);
                    int oreType = this.getTargetType(block, metadata);
                    if (oreType >= 0) {
                        foundTypes[oreType] = true;
                    }
                }
            }
        }

        return foundTypes;
    }

    private void spawnOreParticle(World world, int x, int y, int z, int oreType) {
        double particleX = (double)x + 0.1D + world.rand.nextDouble() * 0.8D;
        double particleY = (double)y + 1.02D + world.rand.nextDouble() * 0.45D;
        double particleZ = (double)z + 0.1D + world.rand.nextDouble() * 0.8D;

        double motionX = (world.rand.nextDouble() - 0.5D) * 0.08D;
        double motionY = 0.01D + world.rand.nextDouble() * 0.06D;
        double motionZ = (world.rand.nextDouble() - 0.5D) * 0.08D;

        switch (oreType) {
            case DIAMOND:
                ParticleHandler.BLUEFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case VANITE:
                ParticleHandler.IONFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
                break;

            case ANCIENT_DEBRIS:
                ParticleHandler.SMALLREDFLAME.spawn(world, particleX, particleY, particleZ, motionX, motionY, motionZ, 0.0F, new Object[0]);
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
        if (block == Blocks.diamond_ore || block == NovaCraftBlocks.grimstone_diamond || block == NovaCraftBlocks.nullstone_diamond || block == OtherModBlocks.deepslate_diamond_ore) {
            return DIAMOND;
        }

        if (block == NovaCraftBlocks.grimstone_vanite_ore || block == NovaCraftBlocks.nullstone_vanite_ore) {
            return VANITE;
        }

        if (block == OtherModBlocks.ancient_debris) {
            return ANCIENT_DEBRIS;
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
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.uncommon;
    }
}
