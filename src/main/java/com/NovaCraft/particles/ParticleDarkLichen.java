package com.NovaCraft.particles;

import com.NovaCraft.particles.entity.EntityDarkLichenParticleOne;

import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.world.World;

public class ParticleDarkLichen extends EntityDarkLichenParticleOne {

	public ParticleDarkLichen(World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed) {
		super(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);

		this.particleBlue = 0.3556149733F;
		this.particleRed = 0.3275862069F;
		this.particleGreen = 0.3275862069F;
	}

}
