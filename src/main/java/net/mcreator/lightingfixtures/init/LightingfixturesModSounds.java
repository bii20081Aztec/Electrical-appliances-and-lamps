
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lightingfixtures.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.lightingfixtures.LightingfixturesMod;

public class LightingfixturesModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LightingfixturesMod.MODID);
	public static final RegistryObject<SoundEvent> CALLING_SOUNDS = REGISTRY.register("calling_sounds", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("lightingfixtures", "calling_sounds")));
	public static final RegistryObject<SoundEvent> AZXS = REGISTRY.register("azxs", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("lightingfixtures", "azxs")));
	public static final RegistryObject<SoundEvent> LIKE = REGISTRY.register("like", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("lightingfixtures", "like")));
	public static final RegistryObject<SoundEvent> GTA = REGISTRY.register("gta", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("lightingfixtures", "gta")));
}
