package com.NovaCraftBlocks.plants.end;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.entity.EntityDestitumite;
import com.NovaCraft.entity.EntityDestituteTentacle;
import com.NovaCraft.entity.EntityRealityDistorter;
import com.NovaCraft.entity.EntitySculkAbomination;
import com.NovaCraft.entity.EntitySculkSymbiote;
import com.NovaCraft.particles.ParticleHandler;
import com.NovaCraft.sounds.ModSounds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLivingEnder extends Block {

	@SideOnly(Side.CLIENT)
    private IIcon blockTop;
    @SideOnly(Side.CLIENT)
    private IIcon blockBottom;
	
	public BlockLivingEnder() {
		super(Material.iron);

		this.setTickRandomly(true);
		this.setHardness(3.0F);
		this.setResistance(3.5F);
		this.setStepSound(ModSounds.soundNullstone);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.blockTop : (p_149691_1_ == 0 ? this.blockBottom : this.blockIcon);
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
	    this.blockIcon = p_149651_1_.registerIcon("nova_craft:living_ender_side");
	    this.blockTop = p_149651_1_.registerIcon("nova_craft:living_ender_top");
	    this.blockBottom = p_149651_1_.registerIcon("minecraft:end_stone");
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return Item.getItemFromBlock(Blocks.end_stone);
	}
	
	protected boolean canSilkHarvest() {
	    return true;
	 }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World p_149734_1_, final int p_149734_2_, final int p_149734_3_, final int p_149734_4_, final Random p_149734_5_) {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
        if (p_149734_5_.nextInt(20) == 0) {
            ParticleHandler.ENDERLORD.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.ENDERLORD.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.4f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.ENDERLORD.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.6f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.ENDERLORD.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 0.9f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
            ParticleHandler.ENDERLORD.spawn(p_149734_1_, p_149734_2_ + p_149734_5_.nextFloat(), p_149734_3_ + 1.1f, p_149734_4_ + p_149734_5_.nextFloat(), 0.0, 0.0, 0.0, 0.0f, new Object[0]);
        }	
        
    }


}
