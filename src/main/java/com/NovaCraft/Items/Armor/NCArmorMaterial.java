package com.NovaCraft.Items.Armor;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class NCArmorMaterial {
	
	public static ItemArmor.ArmorMaterial PHERITHIUM;
	public static ItemArmor.ArmorMaterial SCULK;
	public static ItemArmor.ArmorMaterial PHANTOM;
	
	public static ItemArmor.ArmorMaterial TOPHINITE;
	public static ItemArmor.ArmorMaterial KLANGITE;

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
		NCArmorMaterial.KLANGITE = EnumHelper.addArmorMaterial("KLANGITE", 85, new int[]{3, 9, 6, 3}, 15);
		NCArmorMaterial.ANCIENT = EnumHelper.addArmorMaterial("ANCIENT", 90, new int[]{3, 8, 6, 3}, 18);
		
	}
}
