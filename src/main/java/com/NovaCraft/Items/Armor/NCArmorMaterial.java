package com.NovaCraft.Items.Armor;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class NCArmorMaterial {
	
	public static ItemArmor.ArmorMaterial PHERITHIUM;
	public static ItemArmor.ArmorMaterial SCULK;
	public static ItemArmor.ArmorMaterial PHANTOM;
	
	public static ItemArmor.ArmorMaterial TOPHINITE;
	public static ItemArmor.ArmorMaterial CRYSTALLIZED_VANITE;
	public static ItemArmor.ArmorMaterial OPHIDIAN;
		
	public static ItemArmor.ArmorMaterial KLANGITE;
	public static ItemArmor.ArmorMaterial KYLAZITE;
	
	public static ItemArmor.ArmorMaterial IRIDIUM;
	public static ItemArmor.ArmorMaterial WARDEN;
	
	public static ItemArmor.ArmorMaterial BASE_CROWN;
	public static ItemArmor.ArmorMaterial SPECIAL_CROWN;
	public static ItemArmor.ArmorMaterial SERPENT_CROWN;

	public static ItemArmor.ArmorMaterial ANCIENT;
	
	/*CLOTH(5, new int[]{1, 3, 2, 1}, 15),
    CHAIN(15, new int[]{2, 5, 4, 1}, 12),
    IRON(15, new int[]{2, 6, 5, 2}, 9),
    GOLD(7, new int[]{2, 5, 3, 1}, 25),
    DIAMOND(33, new int[]{3, 8, 6, 3}, 10);*/
	
	static {													//name, durability, reductionAmounts, enchantability
		NCArmorMaterial.PHERITHIUM = EnumHelper.addArmorMaterial("PHERITHIUM", 17, new int[]{2, 6, 5, 2}, 11);
		NCArmorMaterial.SCULK = EnumHelper.addArmorMaterial("SCULK", 7, new int[]{2, 5, 4, 1}, 8);
		NCArmorMaterial.PHANTOM = EnumHelper.addArmorMaterial("PHANTOM", 14, new int[]{2, 6, 5, 2}, 10);
				
		NCArmorMaterial.TOPHINITE = EnumHelper.addArmorMaterial("TOPHINITE", 45, new int[]{3, 9, 6, 3}, 18);
		NCArmorMaterial.CRYSTALLIZED_VANITE = EnumHelper.addArmorMaterial("CRYSTALLIZED_VANITE", 65, new int[]{3, 9, 6, 3}, 20);
		NCArmorMaterial.OPHIDIAN = EnumHelper.addArmorMaterial("OPHIDIAN", 80, new int[]{3, 10, 7, 3}, 22);
		
		NCArmorMaterial.KLANGITE = EnumHelper.addArmorMaterial("KLANGITE", 85, new int[]{3, 9, 6, 3}, 15);
		NCArmorMaterial.KYLAZITE = EnumHelper.addArmorMaterial("KYLAZITE", 100, new int[]{3, 10, 7, 3}, 17);
		
		NCArmorMaterial.IRIDIUM = EnumHelper.addArmorMaterial("IRIDIUM", 70, new int[]{3, 9, 6, 3}, 19);
		NCArmorMaterial.WARDEN = EnumHelper.addArmorMaterial("WARDEN", 125, new int[]{4, 10, 7, 4}, 20);
		
		
		NCArmorMaterial.ANCIENT = EnumHelper.addArmorMaterial("ANCIENT", 90, new int[]{3, 8, 6, 3}, 18);		
		NCArmorMaterial.BASE_CROWN = EnumHelper.addArmorMaterial("BASE_CROWN", 45, new int[]{2, 9, 6, 3}, 19);
		NCArmorMaterial.SPECIAL_CROWN = EnumHelper.addArmorMaterial("SPECIAL_CROWN", 75, new int[]{3, 9, 6, 3}, 22);
		NCArmorMaterial.SERPENT_CROWN = EnumHelper.addArmorMaterial("SERPENT_CROWN", 35, new int[]{1, 9, 6, 3}, 24);
		
	}
}
