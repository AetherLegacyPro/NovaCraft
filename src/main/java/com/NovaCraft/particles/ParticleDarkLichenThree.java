package com.NovaCraft.particles;

import com.NovaCraft.particles.entity.EntityDarkLichenParticleTwo;

import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.world.World;

public class ParticleDarkLichenThree extends EntityDarkLichenParticleTwo {

	public ParticleDarkLichenThree(World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed) {
		super(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);

		this.particleBlue = 0F;
		this.particleRed = 0F;
		this.particleGreen = 0F;
	}
	
	//this.particleBlue = 0.3988764045F;
	//this.particleRed = 0.3258426966F;
	//this.particleGreen = 0.2752808989F;

}
