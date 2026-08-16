package net.mcreator.lightingfixtures.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.lightingfixtures.init.LightingfixturesModItems;
import net.mcreator.lightingfixtures.LightingfixturesMod;

public class PowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LightingfixturesModItems.ELECTRIC_CARD.get())) : false) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.EMERALD)) : false) {
				LightingfixturesMod.queueServerWork(60, () -> {
					new ItemStack(Items.EMERALD).shrink(50);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your electricity bill has been successfully recharged, 100 kWh has been added."), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u60A8\u7535\u8D39\u5DF2\u5145\u503C\u6210\u529F\u5DF2\u5145\u503C\u4E00\u767E\u5EA6\u7535"), false);
				});
			} else {
				LightingfixturesMod.queueServerWork(20, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lightingfixtures:gta")), SoundSource.NEUTRAL, 16, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lightingfixtures:gta")), SoundSource.NEUTRAL, 16, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u4F60\u6B63\u5728\u975E\u6CD5\u5077\u7535\uFF0C\u5077\u7535\u884C\u4E3A\u5DF2\u8BB0\u5F55 "), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You are illegally stealing electricity, and your actions have been recorded."), false);
					LightingfixturesMod.queueServerWork(10, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\"Article 71 of the Electricity Law... please do not imitate\""), false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u300A\u7535\u529B\u6CD5\u300B\u7B2C71\u6761......\u8BF7\u52FF\u6A21\u4EFF"), false);
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.CACTUS)), 2);
					});
				});
			}
		}
	}
}
