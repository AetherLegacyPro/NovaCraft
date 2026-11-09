package com.NovaCraftBlocks.plants.end;

import java.util.Random;
import com.NovaCraftBlocks.NovaCraftBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockLacunaPlanks extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockLacunaPlanks() {
		super(Material.wood);
		this.setHardness(3);
		this.setResistance(1);
		this.setStepSound(soundTypeWood);
		this.setHarvestLevel("axe", 0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:lacuna_planks");
		iconFace = iconRegister.registerIcon("nova_craft:lacuna_planks");
		iconTop = iconRegister.registerIcon("nova_craft:lacuna_planks");
	}
	
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
        return Item.getItemFromBlock(NovaCraftBlocks.lacuna_planks);
    }
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random random)
    {
        super.randomDisplayTick(world, p_149734_2_, p_149734_3_, p_149734_4_, random);

        if (random.nextInt(4) == 0)
        {
			world.spawnParticle("townaura", (double)((float)p_149734_2_ + random.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + random.nextFloat()), 0.0D, 0.0D, 0.0D);
        }
    }

}
