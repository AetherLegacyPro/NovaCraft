package com.NovaCraft.world;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import com.NovaCraft.config.Configs;
import com.NovaCraftBlocks.NovaCraftBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class NCWorldGeneratorPost implements IWorldGenerator {
	
	public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
	if ((ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {   
			this.generateSurface(random, chunkX * 16, chunkZ * 16, world);
		} else {
			switch (world.provider.dimensionId) {
            case 0: {
                this.generateSurface(random, chunkX * 16, chunkZ * 16, world);
                break;
            }
            case 1: {
                this.generateEnd(random, chunkX * 16, chunkZ * 16, world);
                break;
            }
            case -1: {
                this.generateNether(random, chunkX * 16, chunkZ * 16, world);
                break;
            	}
        	}
		}
    }
	
	public void generateNether(final Random random, final int chunkX, final int chunkZ, final World world) {
		
		this.addNetherOres(NovaCraftBlocks.nether_tophinite_ore, world, random, chunkX, chunkZ, 2, 4, 5, 0, 10);		
	}
	
	public void addOreSpawnEnd(final Block block, final World world, final Random random, final int blockXPos, final int blockZPos, final int minVeinSize, final int maxVeinSize, final int chancesToSpawn, final int minY, final int maxY) {
        final WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), Blocks.end_stone);
        for (int i = 0; i < chancesToSpawn; ++i) {
            final int posX = blockXPos + random.nextInt(16);
            final int posY = minY + random.nextInt(maxY - minY);
            final int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
    }
	
	public void addOreSpawnFrontierslate(final Block block, final World world, final Random random, final int blockXPos, final int blockZPos, final int minVeinSize, final int maxVeinSize, final int chancesToSpawn, final int minY, final int maxY) {
        final WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), NovaCraftBlocks.frontierslate);
        for (int i = 0; i < chancesToSpawn; ++i) {
            final int posX = blockXPos + random.nextInt(16);
            final int posY = minY + random.nextInt(maxY - minY);
            final int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
    }	
	
	public void generateEnd(final Random random, final int chunkX, final int chunkZ, final World world) {
		
		this.addOreSpawnEnd(NovaCraftBlocks.xancium_ore, world, random, chunkX, chunkZ, 8, 10, 9, 0, 90);
		this.addOreSpawnEnd(NovaCraftBlocks.crystallized_end, world, random, chunkX, chunkZ, 2, 4, 4, 0, 12);
		this.addOreSpawnEnd(NovaCraftBlocks.end_klangite_ore, world, random, chunkX, chunkZ, 2, 3, 4, 0, 75);
		this.addOreSpawnFrontierslate(NovaCraftBlocks.frontierslate_klangite_ore, world, random, chunkX, chunkZ, 2, 5, 6, 0, 10);
	}
	    
	public void addNullstoneOres(final Block block, final World world, final Random random, final int blockXPos, final int blockZPos, final int minVeinSize, final int maxVeinSize, final int chancesToSpawn, final int minY, final int maxY) {
        final WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), NovaCraftBlocks.nullstone);
        for (int i = 0; i < chancesToSpawn; ++i) {
            final int posX = blockXPos + random.nextInt(16);
            final int posY = minY + random.nextInt(maxY - minY);
            final int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
    }
	
	
	public void addVanillaOres(final Block block, final World world, final Random random, final int blockXPos, final int blockZPos, final int minVeinSize, final int maxVeinSize, final int chancesToSpawn, final int minY, final int maxY) {
        final WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), Blocks.stone);
        for (int i = 0; i < chancesToSpawn; ++i) {
            final int posX = blockXPos + random.nextInt(16);
            final int posY = minY + random.nextInt(maxY - minY);
            final int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
    }
	
	public void addNetherOres(final Block block, final World world, final Random random, final int blockXPos, final int blockZPos, final int minVeinSize, final int maxVeinSize, final int chancesToSpawn, final int minY, final int maxY) {
        final WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), Blocks.netherrack);
        for (int i = 0; i < chancesToSpawn; ++i) {
            final int posX = blockXPos + random.nextInt(16);
            final int posY = minY + random.nextInt(maxY - minY);
            final int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
    }
	
	public void addGrimstoneOres(final Block block, final World world, final Random random, final int blockXPos, final int blockZPos, final int minVeinSize, final int maxVeinSize, final int chancesToSpawn, final int minY, final int maxY) {
        final WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), NovaCraftBlocks.grimstone);
        for (int i = 0; i < chancesToSpawn; ++i) {
            final int posX = blockXPos + random.nextInt(16);
            final int posY = minY + random.nextInt(maxY - minY);
            final int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
    }
	
	public void addEtherstoneOres(final Block block, final World world, final Random random, final int blockXPos, final int blockZPos, final int minVeinSize, final int maxVeinSize, final int chancesToSpawn, final int minY, final int maxY) {
        final WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), NovaCraftBlocks.etherstone);
        for (int i = 0; i < chancesToSpawn; ++i) {
            final int posX = blockXPos + random.nextInt(16);
            final int posY = minY + random.nextInt(maxY - minY);
            final int posZ = blockZPos + random.nextInt(16);
            minable.generate(world, random, posX, posY, posZ);
        }
    }
	
	public void generateSurface(final Random random, final int chunkX, final int chunkZ, final World world) {
		
		if (Configs.disableRegularVanillaGen == true) {
			
			//Override of vanilla ore generation
			this.addVanillaOres(Blocks.coal_ore, world, random, chunkX, chunkZ, 12, 14, 18, 24, 128);
			this.addVanillaOres(Blocks.iron_ore, world, random, chunkX, chunkZ, 8, 9, 10, 0, 64);
			this.addVanillaOres(Blocks.gold_ore, world, random, chunkX, chunkZ, 2, 3, 4, 0, 32);
			this.addVanillaOres(Blocks.redstone_ore, world, random, chunkX, chunkZ, 5, 8, 10, 0, 24);
			this.addVanillaOres(Blocks.lapis_ore, world, random, chunkX, chunkZ, 2, 4, 6, 0, 32);
			this.addVanillaOres(Blocks.diamond_ore, world, random, chunkX, chunkZ, 2, 4, 6, 0, 16);
			
			if (Configs.enableExtraEmeraldOreGeneration) {
			this.addVanillaOres(Blocks.emerald_ore, world, random, chunkX, chunkZ, 1, 3, 7, 20, 90);
			}
			
			this.addVanillaOres(Blocks.gravel, world, random, chunkX, chunkZ, 10, 13, 15, 32, 64);
			
			}
		if (Configs.enableMountainOres) {
			//Extra Ores at y levels above 90
				this.addVanillaOres(Blocks.coal_ore, world, random, chunkX, chunkZ, 16, 17, 18, 90, 256);
				this.addVanillaOres(Blocks.iron_ore, world, random, chunkX, chunkZ, 10, 12, 14, 90, 256);
				this.addVanillaOres(Blocks.gold_ore, world, random, chunkX, chunkZ, 1, 3, 7, 100, 256);	
		}
		
		//Does this first so klangite is not impossible to find
		if (Configs.enableNullstone == true) {
		this.addNullstoneOres(NovaCraftBlocks.klangite_ore, world, random, chunkX, chunkZ, 2, 3, 7, 0, 16);
		this.addNullstoneOres(NovaCraftBlocks.nullstone_tophinite_ore, world, random, chunkX, chunkZ, 1, 2, 6, 0, 16);	
		this.addNullstoneOres(NovaCraftBlocks.nullstone_vanite_ore, world, random, chunkX, chunkZ, 5, 6, 10, 0, 16);
		
		if (ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist) {
		this.addNullstoneOres(NovaCraftBlocks.klangite_ore, world, random, chunkX, chunkZ, 1, 2, 7, 0, 256);
		this.addNullstoneOres(NovaCraftBlocks.nullstone_tophinite_ore, world, random, chunkX, chunkZ, 1, 2, 6, 0, 256);	
		this.addNullstoneOres(NovaCraftBlocks.nullstone_vanite_ore, world, random, chunkX, chunkZ, 5, 6, 10, 0, 256);	
		}
		}
		
		if (Configs.enableNullstone == false && Loader.isModLoaded("etfuturum") && Configs.enableDeepslateOreGeneration == true) {
		this.addVanillaOres(NovaCraftBlocks.deepslate_klangite_ore, world, random, chunkX, chunkZ, 2, 3, 7, 0, 16);
		this.addVanillaOres(NovaCraftBlocks.deepslate_tophinite_ore, world, random, chunkX, chunkZ, 1, 2, 4, 0, 10);	
		}
		
		if (Configs.enableNullstone == false && Configs.enableDeepslateOreGeneration == false) {
		this.addVanillaOres(NovaCraftBlocks.stone_klangite_ore, world, random, chunkX, chunkZ, 3, 5, 6, 0, 16);
		this.addVanillaOres(NovaCraftBlocks.stone_tophinite_ore, world, random, chunkX, chunkZ, 1, 2, 6, 0, 16);
		}
		
		if (Configs.enableGrimstone == true) {
		this.addGrimstoneOres(NovaCraftBlocks.grimstone_vanite_ore, world, random, chunkX, chunkZ, 5, 6, 10, 0, 18);
		}
		
		if (Configs.enableGrimstone == false && Configs.enableNullstone == false && Loader.isModLoaded("etfuturum") && Configs.enableDeepslateOreGeneration == true) {
		this.addVanillaOres(NovaCraftBlocks.deepslate_vanite_ore, world, random, chunkX, chunkZ, 5, 6, 10, 0, 18);		
		}
		
		if (Configs.enableGrimstone == false && Configs.enableNullstone == false && Configs.enableDeepslateOreGeneration == false) {
		this.addVanillaOres(NovaCraftBlocks.stone_vanite_ore, world, random, chunkX, chunkZ, 5, 6, 10, 0, 18);	
		}
		
		if (Configs.enableBrimstoneOre == true && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
		this.addVanillaOres(NovaCraftBlocks.brimstone_ore, world, random, chunkX, chunkZ, 4, 5, 8, 42, 196);
		}
		
		if (Configs.enablePherithiumOreGeneration) {
		this.addVanillaOres(NovaCraftBlocks.pherithium_ore, world, random, chunkX, chunkZ, 5, 6, 8, 25, 64);
		}
		
		if (!(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
		if (Configs.enableGrimstoneIron && Configs.enableGrimstone) {
		this.addGrimstoneOres(NovaCraftBlocks.grimstone_iron, world, random, chunkX, chunkZ, 9, 12, 14, 0, 24);
		}
		
		if (Configs.enableGrimstoneGold && Configs.enableGrimstone) {
		this.addGrimstoneOres(NovaCraftBlocks.grimstone_gold, world, random, chunkX, chunkZ, 5, 7, 9, 0, 24);
		}
		
		if (Configs.enableGrimstoneRedstone && Configs.enableGrimstone) {
		this.addGrimstoneOres(NovaCraftBlocks.grimstone_redstone, world, random, chunkX, chunkZ, 5, 9, 12, 0, 24);
		}
		
		if (Configs.enableGrimstoneLapis && Configs.enableGrimstone) {
		this.addGrimstoneOres(NovaCraftBlocks.grimstone_lapis, world, random, chunkX, chunkZ, 2, 5, 8, 18, 24);
		}
		
		if (Configs.enableGrimstoneDiamond && Configs.enableGrimstone) {
		this.addGrimstoneOres(NovaCraftBlocks.grimstone_diamond, world, random, chunkX, chunkZ, 2, 3, 7, 0, 14);
		}
		
		if (Configs.enableGrimstoneEmerald && Configs.enableGrimstone) {
		this.addGrimstoneOres(NovaCraftBlocks.grimstone_emerald, world, random, chunkX, chunkZ, 2, 3, 5, 0, 24);
		}
		
		if (Configs.enableNullstoneIron && Configs.enableNullstone) {
		this.addNullstoneOres(NovaCraftBlocks.nullstone_iron, world, random, chunkX, chunkZ, 9, 12, 14, 0, 18);
		}
		
		if (Configs.enableNullstoneGold && Configs.enableNullstone) {
		this.addNullstoneOres(NovaCraftBlocks.nullstone_gold, world, random, chunkX, chunkZ, 5, 7, 9, 0, 18);
		}
		
		if (Configs.enableNullstoneRedstone && Configs.enableNullstone) {
		this.addNullstoneOres(NovaCraftBlocks.nullstone_redstone, world, random, chunkX, chunkZ, 7, 10, 12, 0, 18);
		}
		
		if (Configs.enableNullstoneLapis && Configs.enableNullstone) {
		this.addNullstoneOres(NovaCraftBlocks.nullstone_lapis, world, random, chunkX, chunkZ, 2, 5, 8, 14, 18);
		}
		
		if (Configs.enableNullstoneDiamond && Configs.enableNullstone) {
		this.addNullstoneOres(NovaCraftBlocks.nullstone_diamond, world, random, chunkX, chunkZ, 2, 4, 6, 0, 14);
		}
		
		if (Configs.enableNullstoneEmerald && Configs.enableNullstone) {
			this.addNullstoneOres(NovaCraftBlocks.nullstone_emerald, world, random, chunkX, chunkZ, 2, 3, 5, 0, 14);
		 }
		
		}
		
		
		if ((ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
			if (Configs.enableGrimstoneIron && Configs.enableGrimstone) {
			this.addGrimstoneOres(NovaCraftBlocks.grimstone_iron, world, random, chunkX, chunkZ, 9, 12, 14, 0, 256);
			}
			
			if (Configs.enableGrimstoneGold && Configs.enableGrimstone) {
			this.addGrimstoneOres(NovaCraftBlocks.grimstone_gold, world, random, chunkX, chunkZ, 5, 7, 9, 0, 256);
			}
			
			if (Configs.enableGrimstoneRedstone && Configs.enableGrimstone) {
			this.addGrimstoneOres(NovaCraftBlocks.grimstone_redstone, world, random, chunkX, chunkZ, 5, 9, 12, 0, 256);
			}
			
			if (Configs.enableGrimstoneLapis && Configs.enableGrimstone) {
			this.addGrimstoneOres(NovaCraftBlocks.grimstone_lapis, world, random, chunkX, chunkZ, 2, 5, 8, 18, 256);
			}
			
			if (Configs.enableGrimstoneDiamond && Configs.enableGrimstone) {
			this.addGrimstoneOres(NovaCraftBlocks.grimstone_diamond, world, random, chunkX, chunkZ, 2, 3, 7, 0, 256);
			}
			
			if (Configs.enableGrimstoneEmerald && Configs.enableGrimstone) {
			this.addGrimstoneOres(NovaCraftBlocks.grimstone_emerald, world, random, chunkX, chunkZ, 2, 3, 5, 0, 256);
			}
			
			if (Configs.enableNullstoneIron && Configs.enableNullstone) {
			this.addNullstoneOres(NovaCraftBlocks.nullstone_iron, world, random, chunkX, chunkZ, 9, 12, 14, 0, 256);
			}
			
			if (Configs.enableNullstoneGold && Configs.enableNullstone) {
			this.addNullstoneOres(NovaCraftBlocks.nullstone_gold, world, random, chunkX, chunkZ, 5, 7, 9, 0, 256);
			}
			
			if (Configs.enableNullstoneRedstone && Configs.enableNullstone) {
			this.addNullstoneOres(NovaCraftBlocks.nullstone_redstone, world, random, chunkX, chunkZ, 7, 10, 12, 0, 256);
			}
			
			if (Configs.enableNullstoneLapis && Configs.enableNullstone) {
			this.addNullstoneOres(NovaCraftBlocks.nullstone_lapis, world, random, chunkX, chunkZ, 2, 5, 8, 14, 256);
			}
			
			if (Configs.enableNullstoneDiamond && Configs.enableNullstone) {
			this.addNullstoneOres(NovaCraftBlocks.nullstone_diamond, world, random, chunkX, chunkZ, 2, 4, 6, 0, 256);
			}
			
			if (Configs.enableNullstoneEmerald && Configs.enableNullstone) {
				this.addNullstoneOres(NovaCraftBlocks.nullstone_emerald, world, random, chunkX, chunkZ, 2, 3, 5, 0, 256);
			}
			
		}
		
	if (Configs.enableEtherstone == true && !(ArrayUtils.contains(Configs.DeeperCavesBlacklist, world.provider.dimensionId) == Configs.DeeperCavesBlacklistAsWhitelist)) {
		if (Configs.enableEtherstoneCoal) {
		this.addEtherstoneOres(NovaCraftBlocks.etherstone_coal, world, random, chunkX, chunkZ, 9, 12, 14, 80, 256);
		}
		
		if (Configs.enableBrimstoneOre == true) {
		this.addEtherstoneOres(NovaCraftBlocks.etherstone_brimstone, world, random, chunkX, chunkZ, 7, 8, 10, 85, 196);
		}
		
		if (Configs.enableEtherstoneIron) {
		this.addEtherstoneOres(NovaCraftBlocks.etherstone_iron, world, random, chunkX, chunkZ, 5, 7, 9, 80, 256);
		}
		
		if (Configs.enableEtherstoneEmerald) {
		this.addEtherstoneOres(NovaCraftBlocks.etherstone_emerald, world, random, chunkX, chunkZ, 3, 4, 5, 85, 256);
		}
		
		if (Configs.enableEtherstoneGold) {
		this.addEtherstoneOres(NovaCraftBlocks.etherstone_gold, world, random, chunkX, chunkZ, 2, 5, 6, 90, 256);
		}
	}
		
	}
	   	   

}
