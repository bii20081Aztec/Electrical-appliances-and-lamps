package net.mcreator.lightingfixtures.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.lightingfixtures.LightingfixturesMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DeepSeeknoProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u62B1\u6B49\uFF0C\u6211\u65E0\u6CD5\u56DE\u7B54\u4F60\u7684\u95EE\u9898\u3002"), false);
		LightingfixturesMod.queueServerWork(100, () -> {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u670D\u52A1\u5668\u7E41\u5FD9\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5"), false);
		});
	}
}
