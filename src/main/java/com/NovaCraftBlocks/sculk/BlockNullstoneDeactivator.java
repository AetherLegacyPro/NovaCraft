package com.NovaCraftBlocks.sculk;

import com.NovaCraft.sounds.ModSounds;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
public class BlockNullstoneDeactivator extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;
	
	public BlockNullstoneDeactivator() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setResistance(10000000);
		this.setStepSound(ModSounds.soundNullstoneBricks);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side-1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon("nova_craft:nullstone_deactivator");
		iconFace = iconRegister.registerIcon("nova_craft:nullstone_deactivator");
		iconTop = iconRegister.registerIcon("nova_craft:nullstone_deactivator");
	}

}
