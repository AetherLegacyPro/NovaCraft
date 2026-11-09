package com.NovaCraftBlocks.container;

import java.util.Random;
import com.NovaCraft.NovaCraft;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.sounds.ModSounds;
import com.NovaCraftBlocks.NovaCraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSculkBrickBookshelf extends Block {

	public BlockSculkBrickBookshelf() {
		super(Material.rock);
		this.setHardness(30F);
		this.setResistance(22F);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(ModSounds.soundSculkBricks);
		this.setBlockTextureName(NovaCraft.find("sculk_brick_bookshelf"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return p_149691_1_ != 1 && p_149691_1_ != 0 ? super.getIcon(p_149691_1_, p_149691_2_) : NovaCraftBlocks.sculk_tiles.getBlockTextureFromSide(p_149691_1_);
	}

	@Override
	public float getEnchantPowerBonus(World world, int x, int y, int z) {
		return 3;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World world, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random random) {
        super.randomDisplayTick(world, p_149734_2_, p_149734_3_, p_149734_4_, random);
        if (random.nextInt(15) == 0) {
            ParticleHandler.SCULK.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.4f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.6f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 0.9f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.SCULK.spawn(world, p_149734_2_ + random.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + random.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }	
        
    }
	
}
