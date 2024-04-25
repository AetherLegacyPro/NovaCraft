package com.NovaCraft.world.sculkshaft;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenSculkMineshaft extends MapGenStructure {

	private double spawnChance = 0.0008D;

	public MapGenSculkMineshaft() {}

	@Override
	public String func_143025_a()
	{
		return "SculkMineshaft";
	}

	public MapGenSculkMineshaft(Map<?, ?> par1Map)
	{
		Iterator<?> iterator = par1Map.entrySet().iterator();

		while (iterator.hasNext())
		{
			Entry<?, ?> entry = (Entry<?, ?>)iterator.next();

			if (((String)entry.getKey()).equals("chance"))
				spawnChance = MathHelper.parseDoubleWithDefault((String)entry.getValue(), spawnChance);
		}
	}

	@Override
	protected boolean canSpawnStructureAtCoords(int par1, int par2)
	{
		return rand.nextDouble() < spawnChance && rand.nextInt(80) < Math.max(Math.abs(par1), Math.abs(par2));
	}

	@Override
	protected StructureStart getStructureStart(int par1, int par2)
	{
		return new StructureSculkMineshaftStart(worldObj, rand, par1, par2);
	}
}
