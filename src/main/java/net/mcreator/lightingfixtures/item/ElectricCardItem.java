
package net.mcreator.lightingfixtures.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ElectricCardItem extends Item {
	public ElectricCardItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
