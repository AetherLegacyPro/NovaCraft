package com.NovaCraftBlocks.stalagmites;

import java.util.Random;
import com.NovaCraft.Items.NovaCraftItems;
import com.NovaCraft.particles.ParticleHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.common.util.ForgeDirection;

public class BlockLargePherithiumStalagmite extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon iconFace, iconTop;

	public BlockLargePherithiumStalagmite() {
		super(Material.rock);
		this.setHardness(3F);
		this.setResistance(4F);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.9F, 0.8F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 2);
		this.setTickRandomly(true);
	}

	protected boolean canPlaceBlockOn(Block block) {
		return block == Blocks.stone;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return y > 0 && world.isSideSolid(x, y - 1, z, ForgeDirection.UP);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.checkAndDropBlock(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock) {
		super.onNeighborBlockChange(world, x, y, z, neighborBlock);
		this.checkAndDropBlock(world, x, y, z);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		this.checkAndDropBlock(world, x, y, z);
		super.updateTick(world, x, y, z, rand);
	}

	private void checkAndDropBlock(World world, int x, int y, int z) {
		if (!this.canBlockStay(world, x, y, z)) {
			if (!world.isRemote) {
				this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 0 || side == 1 ? iconTop : meta >= 1 && side - 1 == meta ? iconFace : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("nova_craft:pherithium_stalagmite_large");
		iconFace = iconRegister.registerIcon("nova_craft:pherithium_stalagmite_large");
		iconTop = iconRegister.registerIcon("nova_craft:pherithium_stalagmite_large");
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public int quantityDropped(final Random random) {
		return 1 + random.nextInt(3);
	}

	@Override
	public Item getItemDropped(final int metadata, final Random rand, final int fortune) {
		return NovaCraftItems.pherithium_scraps;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, random, fortune)) {
			int j = random.nextInt(fortune + 2) - 1;

			if (j < 0) {
				j = 0;
			}

			return this.quantityDropped(random) * (j + 2);
		} else {
			return this.quantityDropped(random);
		}
	}

	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune) {
		Random random = new Random();

		if (this.getItemDropped(metadata, random, fortune) != Item.getItemFromBlock(this)) {
			return MathHelper.getRandomIntegerInRange(random, 3, 5);
		}

		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random rand) {
		super.randomDisplayTick(world, x, y, z, rand);

		if (rand.nextInt(25) == 0) {
			ParticleHandler.PHERITHIUM.spawn(world, x + rand.nextFloat(), y + 0.1F, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0F, new Object[0]);
			ParticleHandler.PHERITHIUM.spawn(world, x + rand.nextFloat(), y + 0.4F, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0F, new Object[0]);
			ParticleHandler.PHERITHIUM.spawn(world, x + rand.nextFloat(), y + 0.6F, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0F, new Object[0]);
			ParticleHandler.PHERITHIUM.spawn(world, x + rand.nextFloat(), y + 0.9F, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0F, new Object[0]);
			ParticleHandler.PHERITHIUM.spawn(world, x + rand.nextFloat(), y + 1.1F, z + rand.nextFloat(), 0.0, 0.0, 0.0, 0.0F, new Object[0]);
		}
	}
}
