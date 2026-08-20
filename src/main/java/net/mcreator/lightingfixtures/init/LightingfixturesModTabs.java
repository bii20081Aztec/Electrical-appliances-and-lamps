
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lightingfixtures.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.lightingfixtures.LightingfixturesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LightingfixturesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LightingfixturesMod.MODID);
	public static final RegistryObject<CreativeModeTab> LE_DLUMINAIRES = REGISTRY.register("le_dluminaires",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.lightingfixtures.le_dluminaires")).icon(() -> new ItemStack(LightingfixturesModBlocks.ALUMINUMGUSSET.get())).displayItems((parameters, tabData) -> {
				tabData.accept(LightingfixturesModBlocks.CEILING.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LE_DPANELLIGHT.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LE_DCANOPYLIGHT_1_X_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LE_DCANOPYLIGHT_2_X_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ALUMINUMGUSSET.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ALUMINUMGUSSET_1_X_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ALUMINUMGUSSET_2_X_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LE_DFLOODLIGHTS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LED_FLOOD_LIGHT_TOP.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LARGECYLINDERLAMP.get().asItem());
				tabData.accept(LightingfixturesModBlocks.MEDIUMDOWNLIGHT.get().asItem());
				tabData.accept(LightingfixturesModBlocks.SMALLDOWNLIGHTS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.TRACKSPOTLIGHTS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.TRACKSPOTLIGHTS_1.get().asItem());
				tabData.accept(LightingfixturesModBlocks.TUNGSTENBULBS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LAMPWARMTHBATH.get().asItem());
				tabData.accept(LightingfixturesModBlocks.CEMOSPALCEPA.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FIRE_EMERGENCY_LIGHT.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ALUMINUM_GRILLE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ALUMINUM_GRILLE_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.TRACK.get().asItem());
				tabData.accept(LightingfixturesModBlocks.TRACK_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.PSG.get().asItem());
				tabData.accept(LightingfixturesModBlocks.PSGA.get().asItem());
				tabData.accept(LightingfixturesModBlocks.PSGB.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HFBH.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LE_DILH.get().asItem());
				tabData.accept(LightingfixturesModBlocks.SLE_DBC.get().asItem());
				tabData.accept(LightingfixturesModBlocks.MLE_DBC.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LLE_DBC.get().asItem());
			}).build());
	public static final RegistryObject<CreativeModeTab> LIGHTINGFIXTURES = REGISTRY.register("lightingfixtures",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.lightingfixtures.lightingfixtures")).icon(() -> new ItemStack(LightingfixturesModBlocks.ESLS.get())).displayItems((parameters, tabData) -> {
				tabData.accept(LightingfixturesModBlocks.SINGLETUBEFLUORESCENTLAMPS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.SINGLETUBEFLUORESCENTLAMPS_1.get().asItem());
				tabData.accept(LightingfixturesModBlocks.DOUBLETUBEFLUORESCENTLAMPS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.THREETUBEFLUORESCENTLAMP.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FLUORESCENTCEILINGLIGHTS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FLUORESCENTCEILINGLIGHTS_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FLUORESCENTCEILINGLIGHTS_1.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRONICSINGLETUBEFLUORESCENTAMPS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRONICDOUBLETUBEFLUORESCENTLAMPS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.METALHALIDEFLOODLIGHTS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.METALHALIDEFLOODLIGHT.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FLUORESCENTLUMINAIRES.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ALUMINUMTUBESAREFLUORESCENT.get().asItem());
				tabData.accept(LightingfixturesModBlocks.IODINETUNGSTENLAMP.get().asItem());
				tabData.accept(LightingfixturesModBlocks.DOUBLETUBECEILINGLIGHT.get().asItem());
				tabData.accept(LightingfixturesModBlocks.DTUBECEILINGLIGHT.get().asItem());
				tabData.accept(LightingfixturesModBlocks.SINGLE_TUBE_FLUORESCENT_LAMP_WITH_LAMPSHADE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.DOUBLE_TUBE_SINGLESTAND_FLUORESCENT_LAMP_WITH_LAMPSHADE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.DOUBLE_TUBE_FLUORESCENT_LAMPWITH_LAMPSHADE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.THREE_LAMP_FLUORESCENT_LAMPWITH_LAMPSHADE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FLUORESCENT_LAMP_HOLDERS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FLUORESCENTDOUBLEBRACKET.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ALUMINUM_TUBESARE_FLUORESCENT_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.CORNER_TYPE_FLUORESCENT_LAMP.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FOUR_TUBE_FLUORESCENT_LAMP.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FOUR_TUBE_FLUORESCENT_LIGHT_WITH_LAMPSHADE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.TPFLST.get().asItem());
				tabData.accept(LightingfixturesModBlocks.TPFLDT.get().asItem());
				tabData.accept(LightingfixturesModBlocks.EPLST.get().asItem());
				tabData.accept(LightingfixturesModBlocks.EPLDT.get().asItem());
				tabData.accept(LightingfixturesModBlocks.EPLEHB.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LETFLL.get().asItem());
				tabData.accept(LightingfixturesModBlocks.LETFLS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ESLS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ESLL.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ESLM.get().asItem());
			}).withTabsBefore(LE_DLUMINAIRES.getId()).build());
	public static final RegistryObject<CreativeModeTab> SWITCHSOCKETSANDFANS = REGISTRY.register("switchsocketsandfans",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.lightingfixtures.switchsocketsandfans")).icon(() -> new ItemStack(LightingfixturesModBlocks.SINGLESWITCHSWITCH.get())).displayItems((parameters, tabData) -> {
				tabData.accept(LightingfixturesModBlocks.SINGLESWITCHSWITCH.get().asItem());
				tabData.accept(LightingfixturesModBlocks.DOUBLEOPENSWITCH.get().asItem());
				tabData.accept(LightingfixturesModBlocks.THREEONSWITCH.get().asItem());
				tabData.accept(LightingfixturesModBlocks.QUADRUPLESWITCH.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ONEOPENTHREEPINSOCKET.get().asItem());
				tabData.accept(LightingfixturesModBlocks.TWOOPENTHREEPINSOCKET.get().asItem());
				tabData.accept(LightingfixturesModBlocks.SEVENPINSOCKET.get().asItem());
				tabData.accept(LightingfixturesModBlocks.T_VSOCKET.get().asItem());
				tabData.accept(LightingfixturesModBlocks.INTERNETOUTLETS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.GASMETERS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICALCABINETS_1X_1.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICALCABINETS_1_X_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICALCABINETS_2X_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICALCABINETS_2X_3.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICALBOXWITHELECTRICITYMETER.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICALBOXWITHELECTRICITYMETER_1X_1.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICALBOXWITHELECTRICITYMETER_2X_1.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICALBOXWITHELECTRICITYMETER_2X_2.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ACCESSCONTROLINTERCOMHOST.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ACCESSCONTROLINTERCOMEXTENSION.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICALBOXWITHELECTRICITYMETER_2X_3.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICALBOXWITHELECTRICITYMETER_2X_380.get().asItem());
				tabData.accept(LightingfixturesModBlocks.WATERMETER.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FIVEPINSOCKET.get().asItem());
				tabData.accept(LightingfixturesModBlocks.T_VNETWORKSOCKET.get().asItem());
				tabData.accept(LightingfixturesModBlocks.DUALNETWORKOUTLETS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HIGHPOWEROUTLETS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HEATINGPIPES.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HEATINGPIPE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HEATINGBRANCHPIPE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.THEHEATINGIS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HEATINGINTERCONNECTIONPIPES.get().asItem());
				tabData.accept(LightingfixturesModBlocks.THEMAINCORNERPIPEOFTHEHEATER.get().asItem());
				tabData.accept(LightingfixturesModBlocks.THEMAINHEATINGISTHE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.THEMAINBRANCHPIPEOFTHEHEATER.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HEATINGSUPERVISOR.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HEATINGMAINVALVE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HEATINGBLEEDVALVE.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HEATINGA.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HEATINGB.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HEATINGC.get().asItem());
				tabData.accept(LightingfixturesModBlocks.SMOKE_DETECTOR.get().asItem());
				tabData.accept(LightingfixturesModBlocks.FIRE_ALARM_BUTTON.get().asItem());
				tabData.accept(LightingfixturesModBlocks.SUPERMARKE_TANTITHEFT_SYSTEM.get().asItem());
				tabData.accept(LightingfixturesModBlocks.SUPERMARKET_SELF_CHECKOUT_SYSTEM.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HIGH_POWER_ELECTRIC_METER_BOX.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICAL_CABINETS_1X1_380.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELECTRICAL_CABINETS_1X2_380.get().asItem());
				tabData.accept(LightingfixturesModBlocks.UHPEC.get().asItem());
				tabData.accept(LightingfixturesModBlocks.OTEMBWTM.get().asItem());
				tabData.accept(LightingfixturesModBlocks.EBWEM.get().asItem());
				tabData.accept(LightingfixturesModBlocks.OEMBWTM.get().asItem());
				tabData.accept(LightingfixturesModBlocks.OEMBWSM.get().asItem());
				tabData.accept(LightingfixturesModBlocks.OEMBWFM.get().asItem());
				tabData.accept(LightingfixturesModBlocks.OTEMBWAEM.get().asItem());
				tabData.accept(LightingfixturesModBlocks.OVEMV.get().asItem());
				tabData.accept(LightingfixturesModBlocks.HFS.get().asItem());
				tabData.accept(LightingfixturesModBlocks.EBWEM_2_X_3_LCD.get().asItem());
				tabData.accept(LightingfixturesModBlocks.EBWEM_LCD.get().asItem());
				tabData.accept(LightingfixturesModBlocks.OVEMVLCD.get().asItem());
				tabData.accept(LightingfixturesModItems.ELECTRIC_CARD.get());
				tabData.accept(LightingfixturesModBlocks.EBWM_2_X_3.get().asItem());
				tabData.accept(LightingfixturesModBlocks.E_LBWEM_2_X_3_LCD.get().asItem());
				tabData.accept(LightingfixturesModBlocks.ELBWEM_2_X_3.get().asItem());
				tabData.accept(LightingfixturesModBlocks.EBWELM_2_X_3_LCD.get().asItem());
			}).withTabsBefore(LIGHTINGFIXTURES.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(LightingfixturesModItems.LIKE.get());
		}
	}
}
