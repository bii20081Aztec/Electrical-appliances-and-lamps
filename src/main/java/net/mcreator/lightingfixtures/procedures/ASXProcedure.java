package net.mcreator.lightingfixtures.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.lightingfixtures.init.LightingfixturesModBlocks;
import net.mcreator.lightingfixtures.LightingfixturesMod;

import java.util.Map;

public class ASXProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double previousRecipe = 0;
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A79\u6B63\u5728\u547C\u53EB\u4E2D"), false);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lightingfixtures:azxs")), SoundSource.VOICE, 4, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("lightingfixtures:azxs")), SoundSource.VOICE, 4, 1, false);
			}
		}
		LightingfixturesMod.queueServerWork(80, () -> {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = LightingfixturesModBlocks.ACCESSCONTROLINTERCOMEXTENSION_ON.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7a\u547C\u53EB\u6210\u529F"), false);
		});
	}
}
