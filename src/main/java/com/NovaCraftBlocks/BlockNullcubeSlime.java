package com.NovaCraftBlocks;

import com.NovaCraft.renderer.RenderIDs;
import com.NovaCraft.sounds.ModSounds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class BlockNullcubeSlime extends Block {

	public BlockNullcubeSlime() {
		super(Material.clay);
		this.setHardness(0.1F);
		this.setResistance(1F);
		this.setStepSound(ModSounds.soundWarpedSlime);
		this.setHarvestLevel("shovel", 0);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		float f = 0.125F;
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1 - f, z + 1);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		//Copartz
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y - 1, z) == NovaCraftBlocks.copartz_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY + 5.0D, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y + 2, z) == NovaCraftBlocks.copartz_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY - 5.0D, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y, z + 1) == NovaCraftBlocks.copartz_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ - 5.0D);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y, z - 1) == NovaCraftBlocks.copartz_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ + 5.0D);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x + 1, y, z) == NovaCraftBlocks.copartz_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX - 5.0D, entity.posY, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x - 1, y, z) == NovaCraftBlocks.copartz_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX + 5.0D, entity.posY, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		
		//Tsavorokite
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y - 1, z) == NovaCraftBlocks.tsavorokite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY + 8.0D, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y + 2, z) == NovaCraftBlocks.tsavorokite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY - 8.0D, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y, z + 1) == NovaCraftBlocks.tsavorokite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ - 8.0D);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y, z - 1) == NovaCraftBlocks.tsavorokite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ + 8.0D);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x + 1, y, z) == NovaCraftBlocks.tsavorokite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX - 8.0D, entity.posY, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x - 1, y, z) == NovaCraftBlocks.tsavorokite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX + 8.0D, entity.posY, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		
		//Larimar
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y - 1, z) == NovaCraftBlocks.larimar_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY + 12.0D, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y + 2, z) == NovaCraftBlocks.larimar_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY - 12.0D, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y, z + 1) == NovaCraftBlocks.larimar_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ - 12.0D);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y, z - 1) == NovaCraftBlocks.larimar_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ + 12.0D);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x + 1, y, z) == NovaCraftBlocks.larimar_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX - 12.0D, entity.posY, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x - 1, y, z) == NovaCraftBlocks.larimar_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX + 12.0D, entity.posY, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		
		//Yttrlinsite
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y - 1, z) == NovaCraftBlocks.yttrlinsite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY + 16.0D, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y + 2, z) == NovaCraftBlocks.yttrlinsite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY - 16.0D, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y, z + 1) == NovaCraftBlocks.yttrlinsite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ - 16.0D);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y, z - 1) == NovaCraftBlocks.yttrlinsite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ + 16.0D);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x + 1, y, z) == NovaCraftBlocks.yttrlinsite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX - 16.0D, entity.posY, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x - 1, y, z) == NovaCraftBlocks.yttrlinsite_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX + 16.0D, entity.posY, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		
		//Null
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y - 1, z) == NovaCraftBlocks.null_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY + 64.0D, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y + 2, z) == NovaCraftBlocks.null_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY - 64.0D, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y, z + 1) == NovaCraftBlocks.null_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ - 64.0D);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y, z - 1) == NovaCraftBlocks.null_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ + 64.0D);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x + 1, y, z) == NovaCraftBlocks.null_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX - 64.0D, entity.posY, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x - 1, y, z) == NovaCraftBlocks.null_block) {
			Vec3 positionVector = Vec3.createVectorHelper(entity.posX + 64.0D, entity.posY, entity.posZ);
			entity.setPosition(positionVector.xCoord, positionVector.yCoord, positionVector.zCoord);
		}
		
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public int getRenderType() {
		return RenderIDs.NULLCUBE;
	}

}
