package com.NovaCraft;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class PlayerNovaCraft implements IPlayerNovaCraft {

	private EntityPlayer player;
	
	private boolean isJumping;

	private boolean isMountSneaking;
	
	public float wingSinage;
	
	@Override
	public void onUpdate() {
		
		if (!this.getEntity().onGround) {
			this.wingSinage += 0.75F;
		} else {
			this.wingSinage += 0.15F;
		}

		if (this.wingSinage > 3.141593F * 2F) {
			this.wingSinage -= 3.141593F * 2F;
		} else {
			this.wingSinage += 0.1F;
		}

		boolean hasJumped = ReflectionHelper.getPrivateValue(EntityLivingBase.class, this.getEntity(), "isJumping", "field_70703_bu");

		this.setJumping(hasJumped);
		
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound novacraftTag = new NBTTagCompound();
		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound novacraftTag = compound.getCompoundTag("nova_craft");
		
	}
	
	public static PlayerNovaCraft get(EntityPlayer player) {
		return (PlayerNovaCraft) player.getExtendedProperties("nova_craft:player_novacraft");
	}

	@Override
	public void init(Entity entity, World world) {
		this.player = (EntityPlayer) entity;
	}
	
	@Override
	public EntityPlayer getEntity() {
		return this.player;
	}

	@Override
	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	@Override
	public boolean isJumping() {
		return this.isJumping;
	}

	@Override
	public void setMountSneaking(boolean isSneaking) {
		this.isMountSneaking = isSneaking;
	}

	@Override
	public boolean isMountSneaking() {
		return this.isMountSneaking;
	}

}
