package com.NovaCraft.Items;

import com.NovaCraft.registry.NovaCraftCreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemNovaCraftFood extends ItemFood {

	public ItemNovaCraftFood(int healAmmount) {
		super(healAmmount, false);
		this.setCreativeTab(NovaCraftCreativeTabs.items);
	}

	public ItemNovaCraftFood(int healAmmount, float saturationAmmount) {
		super(healAmmount, saturationAmmount, false);
		this.setCreativeTab(NovaCraftCreativeTabs.items);
	}

}
