package com.NovaCraft.particles;

import com.NovaCraft.particles.entity.EntityDarkLichenParticleOne;

import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.world.World;

public class ParticleDarkLichenTwo extends EntityDarkLichenParticleOne {

	public ParticleDarkLichenTwo(World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed) {
		super(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);

		this.particleBlue = 0.396039604F;
		this.particleRed = 0.3267326733F;
		this.particleGreen = 0.2772277228F;
	}

}

