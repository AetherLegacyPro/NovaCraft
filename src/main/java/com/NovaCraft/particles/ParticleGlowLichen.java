package com.NovaCraft.particles;

import com.NovaCraft.particles.entity.EntityGlowLichenParticle;

import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.world.World;

public class ParticleGlowLichen extends EntityGlowLichenParticle {

	public ParticleGlowLichen(World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed) {
		super(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);

		this.particleBlue = 0.2862985685F;
		this.particleRed = 0.3558282209F;
		this.particleGreen = 0.3578732106F;
	}

}
