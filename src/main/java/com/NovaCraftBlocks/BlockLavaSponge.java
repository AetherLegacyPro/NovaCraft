package com.NovaCraftBlocks;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLavaSponge extends Block {

    private static final int MAX_DISTANCE = 6;
    private static final int MAX_BLOCKS = 64;

    private IIcon[] icons = new IIcon[2];
    private static final String[] types;

    public BlockLavaSponge() {
        super(Material.cloth);
        this.setHardness(0.5F);
        this.setResistance(8F);
        this.setStepSound(soundTypeCloth);
        this.setHarvestLevel("shovel", 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.icons[0] = iconRegister.registerIcon("nova_craft:lava_sponge");
        this.icons[1] = iconRegister.registerIcon("nova_craft:lava_sponge_wet");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta >= this.icons.length) {
            meta = 0;
        }

        return this.icons[meta];
    }

    public void getSubBlocks(final Item block, final CreativeTabs creativeTabs, final List list) {
        for (int i = 0; i < BlockLavaSponge.types.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    static {
        types = new String[] { "lava_sponge", "lava_sponge_wet" };
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 1) {
            return 14;
        }
        else {
            return 0;
        }
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);

        if (!world.isRemote) {
            int meta = world.getBlockMetadata(x, y, z);

            if (meta == 0) {
                boolean absorbLava = aborb(world, x, y, z);

                if (absorbLava) {
                    world.playSoundEffect(x + .5D, y + .5D, z + .5D, "random.fizz", 1, 1);
                    world.setBlockMetadataWithNotify(x, y, z, 1, 3);
                }
            }
        }
    }

    private boolean aborb(World world, int x, int y, int z) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(x, y, z, 0));

        int converted = 0;

        while (!queue.isEmpty() && converted < MAX_BLOCKS) {
            Node node = queue.poll();

            if (node.distance >= MAX_DISTANCE) {
                continue;
            }

            for (int i = 0; i < 6; i++) {
                int nx = node.x;
                int ny = node.y;
                int nz = node.z;

                if (i == 0) {
                    nx++;
                } else if (i == 1) {
                    nx--;
                } else if (i == 2) {
                    ny++;
                } else if (i == 3) {
                    ny--;
                } else if (i == 4) {
                    nz++;
                } else if (i == 5) {
                    nz--;
                }

                Block block = world.getBlock(nx, ny, nz);

                if (block == Blocks.lava || block == Blocks.flowing_lava) {
                    world.setBlock(nx, ny, nz, Blocks.cobblestone, 0, 3);
                    converted++;

                    queue.add(new Node(nx, ny, nz, node.distance + 1));

                    if (converted >= MAX_BLOCKS) {
                        break;
                    }
                }
            }
        }

        return converted > 0;
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    private static class Node {
        public int x;
        public int y;
        public int z;
        public int distance;

        public Node(int x, int y, int z, int distance) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.distance = distance;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
        super.randomDisplayTick(world, x, y, z, rand);

        final int meta = world.getBlockMetadata(x, y, z);

        if (rand.nextInt(20) == 0 && meta == 1)
        {
            world.spawnParticle("smoke", (double)((float)x + rand.nextFloat()), (double)((float)y + 1.1F), (double)((float)z + rand.nextFloat()), 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", (double)((float)x + rand.nextFloat()), (double)((float)y + 1.1F), (double)((float)z + rand.nextFloat()), 0.0D, 0.0D, 0.0D);
        }
    }
}