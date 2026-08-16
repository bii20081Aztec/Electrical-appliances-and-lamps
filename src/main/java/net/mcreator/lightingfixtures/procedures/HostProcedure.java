package net.mcreator.lightingfixtures.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.lightingfixtures.LightingfixturesMod;

public class HostProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double previousRecipe = 0;
		if (previousRecipe == 0) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A79\u6B63\u5728\u547C\u53EB\u4E2D"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lightingfixtures:calling_sounds")), SoundSource.VOICE, 4, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lightingfixtures:calling_sounds")), SoundSource.VOICE, 4, 1, false);
				}
			}
			LightingfixturesMod.queueServerWork(80, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7a\u547C\u53EB\u6210\u529F"), false);
			});
		}
		if (previousRecipe == 1) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A79\u6B63\u5728\u547C\u53EB\u4E2D"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lightingfixtures:calling_sounds")), SoundSource.VOICE, 4, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lightingfixtures:calling_sounds")), SoundSource.VOICE, 4, 1, false);
				}
			}
			LightingfixturesMod.queueServerWork(80, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A74\u547C\u53EB\u5931\u8D25"), false);
			});
		}
	}
}
