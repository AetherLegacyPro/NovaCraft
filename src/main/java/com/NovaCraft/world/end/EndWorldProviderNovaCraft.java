package com.NovaCraft.world.end;

import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class EndWorldProviderNovaCraft extends WorldProviderEnd {
	@Override
	public void registerWorldChunkManager() {
		BiomeGenBase.sky.theBiomeDecorator = new EndBiomeDecoratorNovaCraft();
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.sky, 0.0F);
		this.dimensionId = 1;
		this.hasNoSky = true;
	}

	@Override
	public IChunkProvider createChunkGenerator() {
			return new EndChunkProviderNovaCraft(this.worldObj, this.worldObj.getSeed());
	}

}
