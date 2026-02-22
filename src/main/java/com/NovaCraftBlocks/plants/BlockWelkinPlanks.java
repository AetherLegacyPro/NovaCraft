package com.NovaCraftBlocks.plants;

import java.util.Random;

import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockWelkinPlanks extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconFace, iconTop;

    public BlockWelkinPlanks() {
        super(Material.wood);
        this.setHardness(5);
        this.setResistance(4.5F);
        this.setStepSound(soundTypeWood);
        this.setHarvestLevel("axe", 3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        blockIcon = iconRegister.registerIcon("nova_craft:welkin_planks");
        iconFace = iconRegister.registerIcon("nova_craft:welkin_planks");
        iconTop = iconRegister.registerIcon("nova_craft:welkin_planks");
    }

    public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return Item.getItemFromBlock(NovaCraftBlocks.welkin_planks);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        if (!p_149734_1_.isRemote) {
            return;
        }

        if (net.minecraft.client.Minecraft.getMinecraft().gameSettings.particleSetting == 2) {
            return;
        }

        if (p_149734_5_.nextInt(100) == 0) {
            int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
            double d0 = (double)((float)p_149734_2_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
            double d1 = (double)((float)p_149734_3_ + 1.01F);
            double d2 = (double)((float)p_149734_4_ + 0.5F + (p_149734_5_.nextFloat()) - (p_149734_5_.nextFloat()));
            double d3 = 0.2199999988079071D;
            double d4 = 0.27000001072883606D;

            if (l == 1)
            {
                ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]);
            }
            else if (l == 2)
            {
                ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]);
            }
            else if (l == 3)
            {
                ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]);
            }
            else if (l == 4)
            {
                ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]);
            }
            else
            {
                ParticleHandler.TREASURE_SMALL.spawn(p_149734_1_, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D, 0.0f, new Object[0]);
            }
        }
    }

}
