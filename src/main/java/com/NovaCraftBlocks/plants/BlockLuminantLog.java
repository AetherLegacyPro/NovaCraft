package com.NovaCraftBlocks.plants;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLuminantLog extends BlockLog {

	public BlockLuminantLog() {
		super();
		this.setHardness(3);
		this.setResistance(1.5F);
		this.setLightLevel(0.3375F);
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

}
