package com.NovaCraft.TileEntity;

import cpw.mods.fml.common.registry.GameRegistry;

public class NovaCraftTileEntities {
	
	public static void initialization() {
		GameRegistry.registerTileEntity(TileEntityDeepOneEgg.class, "deep_one_egg");
		GameRegistry.registerTileEntity(TileEntityDeepOneEggActivated.class, "deep_one_egg_activated");
		GameRegistry.registerTileEntity(TileEntityLegendaryBeacon.class, "legendary_beacon");
		GameRegistry.registerTileEntity(TileEntityLegendaryEnchantmentTable.class, "legendary_enchantment_table");
		GameRegistry.registerTileEntity(TileEntityAdvancedEnchantmentTable.class, "advanced_enchantment_table");
		GameRegistry.registerTileEntity(TileEntityAncientChest.class, "ancient_chest");
		GameRegistry.registerTileEntity(TileEntityUnbreakbleAncientChest.class, "unbreakable_ancient_chest");
		GameRegistry.registerTileEntity(TileEntityDeepoidFurnace.class, "deepoid_furnace");
		GameRegistry.registerTileEntity(TileEntityIridiumFurnace.class, "iridium_furnace");
		GameRegistry.registerTileEntity(TileEntityDeepoidBrewingStand.class, "deepoid_brewing_stand");
	}

}
