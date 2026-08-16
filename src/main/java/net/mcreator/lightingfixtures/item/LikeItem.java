
package net.mcreator.lightingfixtures.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class LikeItem extends RecordItem {
	public LikeItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lightingfixtures:like")), new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), 260);
	}
}
