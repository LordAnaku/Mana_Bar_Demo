package io.github.lordanaku.mana_demo;

import io.github.lordanaku.mana_demo.hud.RegisterHudElement;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManaBarDemoCore implements ModInitializer {

	public static final String MOD_ID = "mana_demo";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Mana Bar Demo...");
		RegisterHudElement.setNewTextures();
	}
}
