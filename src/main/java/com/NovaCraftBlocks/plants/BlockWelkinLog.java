package com.NovaCraftBlocks.plants;

import com.NovaCraft.particles.ParticleHandler;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;

import java.util.Random;

public class BlockWelkinLog extends BlockLog {

    public BlockWelkinLog() {
        super();
        this.setHardness(5);
        this.setResistance(4.5F);
        this.setStepSound(soundTypeWood);
        this.setHarvestLevel("axe", 3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister registry) {
        this.field_150167_a = new IIcon[1];
        this.field_150166_b = new IIcon[1];

        for (int i = 0; i < this.field_150167_a.length; ++i) {
            this.field_150167_a[i] = registry.registerIcon(this.getTextureName() + "_side");
            this.field_150166_b[i] = registry.registerIcon(this.getTextureName() + "_top");
        }
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

        if (p_149734_5_.nextInt(25) == 0) {
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
