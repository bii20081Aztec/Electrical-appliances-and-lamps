package net.mcreator.lightingfixtures.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class DeepSeekProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(
					"\u6211\u662F DeepSeek\uFF0C\u5F88\u9AD8\u5174\u89C1\u5230\u4F60\uFF01 \u6211\u53EF\u4EE5\u5E2E\u4F60\u5199\u4EE3\u7801\u3001\u8BFB\u6587\u4EF6\u3001\u5199\u4F5C\u5404\u79CD\u521B\u610F\u5185\u5BB9\uFF0C\u8BF7\u628A\u4F60\u7684\u4EFB\u52A1\u4EA4\u7ED9\u6211\u5427~"),
					true);
	}
}
