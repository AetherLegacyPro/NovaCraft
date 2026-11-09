package com.NovaCraft.world.sculkshaft;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Random;
import com.NovaCraft.config.ConfigsStructures;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraftforge.common.BiomeDictionary;

public class MapGenSculkMineshaft extends MapGenMineshaft {

	static final String EFR_MESA_GENERATOR = "ganymedes01.etfuturum.world.structure.MapGenMesaMineshaft";

	private final boolean placeMesaMineshafts;

	public MapGenSculkMineshaft(boolean placeMesaMineshafts) {
		this.placeMesaMineshafts = placeMesaMineshafts;
	}

	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ) {
		Random rand = new Random(this.worldObj.getSeed() ^ ((long)chunkX << 32) ^ chunkZ);

		if (rand.nextInt(ConfigsStructures.sculkMineshaftChance) == 0) {
			return new StructureSculkMineshaftStart(this.worldObj, rand, chunkX, chunkZ);
		}

		if (this.placeMesaMineshafts && BiomeDictionary.isBiomeOfType(this.worldObj.getBiomeGenForCoords((chunkX << 4) + 8, (chunkZ << 4) + 8), BiomeDictionary.Type.MESA)) {
			try {
				return (StructureStart) EFRMesaStart.CONSTRUCTOR.invokeExact(this.worldObj, this.rand, chunkX, chunkZ);
			} catch (Throwable t) {
				throw new RuntimeException("Failed to generate Et Futurum mesa mineshaft", t);
			}
		}

		return super.getStructureStart(chunkX, chunkZ);
	}

	private static final class EFRMesaStart {
		static final MethodHandle CONSTRUCTOR;

		static {
			try {
				CONSTRUCTOR = MethodHandles.publicLookup().findConstructor(Class.forName("ganymedes01.etfuturum.world.structure.StructureMesaMineshaftStart"), MethodType.methodType(void.class, World.class, Random.class, int.class, int.class)).asType(MethodType.methodType(StructureStart.class, World.class, Random.class, int.class, int.class));
			} catch (ReflectiveOperationException e) {
				throw new IllegalStateException("Et Futurum mesa mineshaft start class not found", e);
			}
		}
	}
}