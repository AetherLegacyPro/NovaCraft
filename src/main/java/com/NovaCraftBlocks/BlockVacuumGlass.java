package com.NovaCraftBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockVacuumGlass extends BlockBreakable
{
	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;

    public BlockVacuumGlass(Material material, boolean p_i45408_2_)
    {
        super("vacuum_glass", material, p_i45408_2_);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(0.45F);
		this.setResistance(0.45F);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(soundTypeGlass);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
		return null;
	}
    
    @Override
   	@SideOnly(Side.CLIENT)
   	public IIcon getIcon(int side, int meta){
   		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
   	}

   	@Override
   	@SideOnly(Side.CLIENT)
   	public void registerBlockIcons(IIconRegister iconRegister){
   		blockIcon = iconRegister.registerIcon("nova_craft:vacuum_glass");
   		iconFace = iconRegister.registerIcon("nova_craft:vacuum_glass");
   		iconTop = iconRegister.registerIcon("nova_craft:vacuum_glass");
   	}

    public int quantityDropped(Random random)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random random)
    {
        super.randomDisplayTick(world, p_149734_2_, p_149734_3_, p_149734_4_, random);

        if (random.nextInt(2) == 0)
        {
            world.spawnParticle("townaura", (double)((float)p_149734_2_ + random.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + random.nextFloat()), 0.0D, 0.0D, 0.0D);
        }
    }
}
