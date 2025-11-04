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
	public static Item.ToolMaterial IRIDIUM;
	public static Item.ToolMaterial IRIDIUM_SWORD;
	public static Item.ToolMaterial WARDEN;
	public static Item.ToolMaterial WARDEN_SWORD;
	public static Item.ToolMaterial CRYSTALITE;
	public static Item.ToolMaterial CRYSTALITE_SWORD;
	
	
	public static Item.ToolMaterial KLANGITE;
	public static Item.ToolMaterial KLANGITE_SWORD;
	public static Item.ToolMaterial KYLAZITE_SWORD;
	public static Item.ToolMaterial KYLAZITE;
	
	
	public static Item.ToolMaterial TOPHINITE;
	public static Item.ToolMaterial TOPHINITE_SWORD;
	public static Item.ToolMaterial TOPHINITE_HAMMER;
	public static Item.ToolMaterial CRYSTALLIZED_VANITE;
	public static Item.ToolMaterial CRYSTALLIZED_VANITE_SWORD;
	public static Item.ToolMaterial OPHIDIAN;
	public static Item.ToolMaterial OPHIDIAN_SWORD;
		
	public static Item.ToolMaterial SCYTHE;
	public static Item.ToolMaterial VANITE_SCYTHE;
	public static Item.ToolMaterial DIABLO;
	public static Item.ToolMaterial EERIE_SWORD;
	public static Item.ToolMaterial VANITE_TRIDENT;
	public static Item.ToolMaterial PHOENIX_RAZOR;
	public static Item.ToolMaterial SCULKED_BLADE;
	public static Item.ToolMaterial PRIMEVAL_MACE;
	
	public static Item.ToolMaterial PRIMEVAL_HORN;
	public static Item.ToolMaterial SCULK_HORN;
	
	 static {		 
		   if (Configs.enableWeaponsToAllignWithVanilla == true) {
			   														//name, harvestLevel, maxUses, efficiency, damage, enchantability
			NCToolMaterial.PHERITHIUM = EnumHelper.addToolMaterial("PHERITHIUM", 2, 1040, 32.0f, 2.0f, 15);
			NCToolMaterial.PHERITHIUM_SWORD = EnumHelper.addToolMaterial("PHERITHIUM_SWORD", 0, 1040, 0.0f, 2.0f, 15);
			
			NCToolMaterial.TOPHINITE = EnumHelper.addToolMaterial("TOPHINITE", 15, 4222, 16.0f, 3.0f, 18);
			NCToolMaterial.TOPHINITE_SWORD = EnumHelper.addToolMaterial("TOPHINITE_SWORD", 0, 4222, 0.0f, 5.0f, 18);
			
	     	NCToolMaterial.CRYSTALLIZED_VANITE = EnumHelper.addToolMaterial("CRYSTALLIZED_VANITE", 15, 6117, 17.0f, 3.5f, 20);
	     	NCToolMaterial.CRYSTALLIZED_VANITE_SWORD = EnumHelper.addToolMaterial("CRYSTALLIZED_VANITE_SWORD", 0, 6117, 0.0f, 6.0f, 20);
	     	
	     	NCToolMaterial.OPHIDIAN = EnumHelper.addToolMaterial("OPHIDIAN", 15, 9822, 18.0f, 4.0f, 22);
	     	NCToolMaterial.OPHIDIAN_SWORD = EnumHelper.addToolMaterial("OPHIDIAN_SWORD", 0, 9822, 0.0f, 8.0f, 22);
	     	
	     	NCToolMaterial.KLANGITE = EnumHelper.addToolMaterial("KLANGITE", 15, 10822, 18.0f, 3.0f, 20);
	     	NCToolMaterial.KLANGITE_SWORD = EnumHelper.addToolMaterial("KLANGITE_SWORD", 0, 10822, 0.0f, 6.0f, 20);
	     	
	     	NCToolMaterial.KYLAZITE = EnumHelper.addToolMaterial("KYLAZITE", 13, 6822, 17.0f, 3.5f, 20);
	     	NCToolMaterial.KYLAZITE_SWORD = EnumHelper.addToolMaterial("KYLAZITE_SWORD", 0, 6822, 0.0f, 7.0f, 20);	
	     	
	     	NCToolMaterial.IRIDIUM = EnumHelper.addToolMaterial("IRIDIUM", 15, 7822, 16.0f, 3.0f, 19);
	     	NCToolMaterial.IRIDIUM_SWORD = EnumHelper.addToolMaterial("IRIDIUM_SWORD", 0, 7822, 0.0f, 5.0f, 19);
	     	
	     	NCToolMaterial.WARDEN = EnumHelper.addToolMaterial("WARDEN", 15, 16822, 24.0f, 4.0f, 20);
	     	NCToolMaterial.WARDEN_SWORD = EnumHelper.addToolMaterial("WARDEN_SWORD", 0, 16822, 0.0f, 8.0f, 20);
		 
	     	NCToolMaterial.CRYSTALITE = EnumHelper.addToolMaterial("CRYSTALITE", 15, 25822, 28.0f, 5.0f, 21);
		 	NCToolMaterial.CRYSTALITE_SWORD = EnumHelper.addToolMaterial("CRYSTALITE_SWORD", 0, 25822, 0.0f, 8.0f, 21);
		 
		 	NCToolMaterial.TOPHINITE_HAMMER = EnumHelper.addToolMaterial("TOPHINITE_HAMMER", 0, 2222, 0.0f, 6.0f, 21);
			NCToolMaterial.PHERITHIUM_SHICKAXE = EnumHelper.addToolMaterial("PHERITHIUM_SHICKAXE", 2, 2840, 32.0f, 2.5f, 15);
			NCToolMaterial.REINFORCED_PHERITHIUM_SHICKAXE = EnumHelper.addToolMaterial("REINFORCED_PHERITHIUM_SHICKAXE", 15, 8322, 34.0f, 3.0f, 18);
		 	NCToolMaterial.SCYTHE = EnumHelper.addToolMaterial("SCYTHE", 0, 1541, 0.0f, 5.0f, 18);
		 	NCToolMaterial.DIABLO = EnumHelper.addToolMaterial("DIABLO", 0, 1541, 0.0f, 7.0f, 19);
		 	NCToolMaterial.EERIE_SWORD = EnumHelper.addToolMaterial("EERIE_SWORD", 0, 574, 0.0f, 2.0f, 12);
		 	NCToolMaterial.VANITE_TRIDENT = EnumHelper.addToolMaterial("VANITE_TRIDENT", 0, 1974, 0.0f, 3.0f, 12);
			 NCToolMaterial.VANITE_SCYTHE = EnumHelper.addToolMaterial("VANITE_SCYTHE", 0, 1974, 0.0f, 3.0f, 12);
		 	NCToolMaterial.PHOENIX_RAZOR = EnumHelper.addToolMaterial("PHOENIX_RAZOR", 0, 674, 0.0f, 2.0f, 15);
		 	NCToolMaterial.SCULKED_BLADE = EnumHelper.addToolMaterial("SCULKED_BLADE", 0, 1074, 0.0f, 2.0f, 15);
		 	NCToolMaterial.PRIMEVAL_MACE = EnumHelper.addToolMaterial("PRIMEVAL_MACE", 0, 6822, 0.0f, 6.0f, 22);
		 	
		 	NCToolMaterial.PRIMEVAL_HORN = EnumHelper.addToolMaterial("PRIMEVAL_HORN", 0, 952, 0.0f, 0.0f, 15);
		 	NCToolMaterial.SCULK_HORN = EnumHelper.addToolMaterial("SCULK_HORN", 0, 1966, 0.0f, 0.0f, 25);
		   	}
		   
		   else { 
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
				 NCToolMaterial.SCULKED_BLADE = EnumHelper.addToolMaterial("SCULKED_BLADE", 0, 1074, 0.0f, 2.0f, 15);
				 NCToolMaterial.VANITE_TRIDENT = EnumHelper.addToolMaterial("VANITE_TRIDENT", 0, 2374, 0.0f, 4.0f, 12);
			     NCToolMaterial.VANITE_SCYTHE = EnumHelper.addToolMaterial("VANITE_SCYTHE", 0, 2374, 0.0f, 4.0f, 12);
				 NCToolMaterial.PHOENIX_RAZOR = EnumHelper.addToolMaterial("PHOENIX_RAZOR", 0, 1174, 0.0f, 3.0f, 15);
				 NCToolMaterial.PRIMEVAL_MACE = EnumHelper.addToolMaterial("PRIMEVAL_MACE", 0, 10822, 0.0f, 10.0f, 22);				 
				 NCToolMaterial.IRIDIUM = EnumHelper.addToolMaterial("IRIDIUM", 15, 9222, 16.0f, 4.0f, 19);
			     NCToolMaterial.IRIDIUM_SWORD = EnumHelper.addToolMaterial("IRIDIUM_SWORD", 0, 9222, 0.0f, 8.0f, 19);
				 
				 NCToolMaterial.PRIMEVAL_HORN = EnumHelper.addToolMaterial("PRIMEVAL_HORN", 0, 3952, 0.0f, 0.0f, 15);
				 NCToolMaterial.SCULK_HORN = EnumHelper.addToolMaterial("SCULK_HORN", 0, 8966, 0.0f, 0.0f, 25);
		  }
	 }
}
