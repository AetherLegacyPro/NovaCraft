package com.NovaCraft.Items.Tools;

import net.minecraftforge.common.util.EnumHelper;

import com.NovaCraft.config.Configs;

import net.minecraft.item.Item;

public class NCToolMaterial
{
	public static Item.ToolMaterial PHERITHIUM;
	public static Item.ToolMaterial PHERITHIUM_SWORD;
	public static Item.ToolMaterial PHERITHIUM_SHICKAXE;
	public static Item.ToolMaterial REINFORCED_PHERITHIUM_SHICKAXE;
	public static Item.ToolMaterial KLANGITE;
	public static Item.ToolMaterial KLANGITE_SWORD;
	public static Item.ToolMaterial TOPHINITE;
	public static Item.ToolMaterial TOPHINITE_SWORD;
	public static Item.ToolMaterial TOPHINITE_HAMMER;
	public static Item.ToolMaterial CRYSTALLIZED_VANITE;
	public static Item.ToolMaterial CRYSTALLIZED_VANITE_SWORD;
	public static Item.ToolMaterial OPHIDIAN;
	public static Item.ToolMaterial OPHIDIAN_SWORD;	
	public static Item.ToolMaterial KYLAZITE_SWORD;
	public static Item.ToolMaterial KYLAZITE;	
	public static Item.ToolMaterial WARDEN;
	public static Item.ToolMaterial WARDEN_SWORD;
	public static Item.ToolMaterial CRYSTALITE;
	public static Item.ToolMaterial CRYSTALITE_SWORD;
	public static Item.ToolMaterial SCYTHE;
	public static Item.ToolMaterial DIABLO;
	public static Item.ToolMaterial EERIE_SWORD;
	public static Item.ToolMaterial VANITE_TRIDENT;
	public static Item.ToolMaterial PHOENIX_RAZOR;
	
	 static {
		 
		 {
		   if (Configs.enableWeaponsToAllignWithVanilla == false) {
		 NCToolMaterial.PHERITHIUM = EnumHelper.addToolMaterial("PHERITHIUM", 2, 1040, 32.0f, 2.0f, 15);
		 NCToolMaterial.PHERITHIUM_SHICKAXE = EnumHelper.addToolMaterial("PHERITHIUM_SHICKAXE", 2, 4540, 33.0f, 2.5f, 15);
		 NCToolMaterial.PHERITHIUM_SWORD = EnumHelper.addToolMaterial("PHERITHIUM_SWORD", 0, 1040, 0.0f, 2.0f, 15);			 
		 NCToolMaterial.TOPHINITE = EnumHelper.addToolMaterial("TOPHINITE", 15, 5822, 16.0f, 4.0f, 22);
		 NCToolMaterial.TOPHINITE_SWORD = EnumHelper.addToolMaterial("TOPHINITE_SWORD", 0, 5822, 0.0f, 8.0f, 22);
		 NCToolMaterial.TOPHINITE_HAMMER = EnumHelper.addToolMaterial("TOPHINITE_HAMMER", 0, 3522, 0.0f, 9.0f, 22);
		 NCToolMaterial.REINFORCED_PHERITHIUM_SHICKAXE = EnumHelper.addToolMaterial("REINFORCED_PHERITHIUM_SHICKAXE", 15, 11822, 34.0f, 6.0f, 18);		 
		 NCToolMaterial.CRYSTALLIZED_VANITE = EnumHelper.addToolMaterial("CRYSTALLIZED_VANITE", 15, 12822, 19.0f, 6.0f, 18);
		 NCToolMaterial.CRYSTALLIZED_VANITE_SWORD = EnumHelper.addToolMaterial("CRYSTALLIZED_VANITE_SWORD", 0, 12822, 0.0f, 10.0f, 18);			 
		 NCToolMaterial.OPHIDIAN = EnumHelper.addToolMaterial("OPHIDIAN", 15, 11822, 23.0f, 6.5f, 22);
		 NCToolMaterial.OPHIDIAN_SWORD = EnumHelper.addToolMaterial("OPHIDIAN_SWORD", 0, 11822, 0.0f, 21.0f, 22);		 
		 NCToolMaterial.KLANGITE = EnumHelper.addToolMaterial("KLANGITE", 15, 15822, 18.0f, 6.0f, 20);
		 NCToolMaterial.KLANGITE_SWORD = EnumHelper.addToolMaterial("KLANGITE_SWORD", 0, 15822, 0.0f, 10.0f, 20);		 
		 NCToolMaterial.KYLAZITE = EnumHelper.addToolMaterial("KYLAZITE", 13, 10822, 17.0f, 5.0f, 22);
		 NCToolMaterial.KYLAZITE_SWORD = EnumHelper.addToolMaterial("KYLAZITE_SWORD", 0, 10822, 0.0f, 25.0f, 22);		 
		 NCToolMaterial.WARDEN = EnumHelper.addToolMaterial("WARDEN", 15, 18822, 22.0f, 6.5f, 20);
		 NCToolMaterial.WARDEN_SWORD = EnumHelper.addToolMaterial("WARDEN_SWORD", 0, 18822, 0.0f, 22.0f, 20);		 
		 NCToolMaterial.CRYSTALITE = EnumHelper.addToolMaterial("CRYSTALITE", 15, 30822, 28.0f, 7.0f, 21);
		 NCToolMaterial.CRYSTALITE_SWORD = EnumHelper.addToolMaterial("CRYSTALITE_SWORD", 0, 30822, 0.0f, 40.0f, 21);
		 NCToolMaterial.SCYTHE = EnumHelper.addToolMaterial("SCYTHE", 0, 2041, 0.0f, 8.0f, 18);
		 NCToolMaterial.DIABLO = EnumHelper.addToolMaterial("DIABLO", 0, 2041, 0.0f, 28.0f, 19);
		 NCToolMaterial.EERIE_SWORD = EnumHelper.addToolMaterial("EERIE_SWORD", 0, 574, 0.0f, 2.0f, 12);
		 NCToolMaterial.VANITE_TRIDENT = EnumHelper.addToolMaterial("VANITE_TRIDENT", 0, 2374, 0.0f, 4.0f, 12);
		 NCToolMaterial.PHOENIX_RAZOR = EnumHelper.addToolMaterial("PHOENIX_RAZOR", 0, 1174, 0.0f, 3.0f, 15);
		   	}
		   else {
	     NCToolMaterial.PHERITHIUM = EnumHelper.addToolMaterial("PHERITHIUM", 2, 1040, 32.0f, 2.0f, 15);
	     NCToolMaterial.PHERITHIUM_SHICKAXE = EnumHelper.addToolMaterial("PHERITHIUM_SHICKAXE", 2, 2840, 33.0f, 2.5f, 15);
		 NCToolMaterial.PHERITHIUM_SWORD = EnumHelper.addToolMaterial("PHERITHIUM_SWORD", 0, 1040, 0.0f, 2.0f, 15);		 
		 NCToolMaterial.TOPHINITE = EnumHelper.addToolMaterial("TOPHINITE", 15, 4222, 16.0f, 3.0f, 18);
		 NCToolMaterial.TOPHINITE_SWORD = EnumHelper.addToolMaterial("TOPHINITE_SWORD", 0, 4222, 0.0f, 5.0f, 18);
		 NCToolMaterial.TOPHINITE_HAMMER = EnumHelper.addToolMaterial("TOPHINITE_HAMMER", 0, 2222, 0.0f, 6.0f, 21);
		 NCToolMaterial.OPHIDIAN = EnumHelper.addToolMaterial("OPHIDIAN", 15, 8822, 23.0f, 4.5f, 22);
		 NCToolMaterial.OPHIDIAN_SWORD = EnumHelper.addToolMaterial("OPHIDIAN_SWORD", 0, 8822, 0.0f, 7.0f, 22);
		 NCToolMaterial.REINFORCED_PHERITHIUM_SHICKAXE = EnumHelper.addToolMaterial("REINFORCED_PHERITHIUM_SHICKAXE", 15, 8322, 34.0f, 6.0f, 18);	
		 NCToolMaterial.CRYSTALLIZED_VANITE = EnumHelper.addToolMaterial("CRYSTALLIZED_VANITE", 15, 8822, 19.0f, 4.0f, 20);
		 NCToolMaterial.CRYSTALLIZED_VANITE_SWORD = EnumHelper.addToolMaterial("CRYSTALLIZED_VANITE_SWORD", 0, 8822, 0.0f, 6.0f, 20);		 
		 NCToolMaterial.KYLAZITE = EnumHelper.addToolMaterial("KYLAZITE", 13, 6822, 17.0f, 4.0f, 22);
		 NCToolMaterial.KYLAZITE_SWORD = EnumHelper.addToolMaterial("KYLAZITE_SWORD", 0, 6822, 0.0f, 9.0f, 22);	 
		 NCToolMaterial.KLANGITE = EnumHelper.addToolMaterial("KLANGITE", 15, 10822, 18.0f, 4.0f, 20);
		 NCToolMaterial.KLANGITE_SWORD = EnumHelper.addToolMaterial("KLANGITE_SWORD", 0, 10822, 0.0f, 6.0f, 20);	 
		 NCToolMaterial.WARDEN = EnumHelper.addToolMaterial("WARDEN", 15, 16822, 18.0f, 4.5f, 20);
		 NCToolMaterial.WARDEN_SWORD = EnumHelper.addToolMaterial("WARDEN_SWORD", 0, 16822, 0.0f, 8.0f, 20);	 
		 NCToolMaterial.CRYSTALITE = EnumHelper.addToolMaterial("CRYSTALITE", 15, 25822, 28.0f, 5.0f, 21);
		 NCToolMaterial.CRYSTALITE_SWORD = EnumHelper.addToolMaterial("CRYSTALITE_SWORD", 0, 25822, 0.0f, 12.0f, 21);
		 NCToolMaterial.SCYTHE = EnumHelper.addToolMaterial("SCYTHE", 0, 1541, 0.0f, 7.0f, 18);
		 NCToolMaterial.DIABLO = EnumHelper.addToolMaterial("DIABLO", 0, 1541, 0.0f, 9.0f, 19);
		 NCToolMaterial.EERIE_SWORD = EnumHelper.addToolMaterial("EERIE_SWORD", 0, 574, 0.0f, 2.0f, 12);
		 NCToolMaterial.VANITE_TRIDENT = EnumHelper.addToolMaterial("VANITE_TRIDENT", 0, 1974, 0.0f, 2.5f, 12);
		 NCToolMaterial.PHOENIX_RAZOR = EnumHelper.addToolMaterial("PHOENIX_RAZOR", 0, 674, 0.0f, 2.0f, 15);
		  }
		}
	 }
}
