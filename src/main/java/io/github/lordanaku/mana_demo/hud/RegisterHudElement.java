package io.github.lordanaku.mana_demo.hud;

import io.github.lordanaku.anakus_status_bars.api.ModRegisterFunctions;
import io.github.lordanaku.anakus_status_bars.screen.gui.config.ConfigFileHandler;
import io.github.lordanaku.anakus_status_bars.screen.gui.config.Settings;

public class RegisterHudElement {

    /* * Register calls must be made before setupHudElements() to work at start * */
    /* * Register calls must be made after readFromConfig() if you wish to use Anaku's Status Bars Mod Menu instead of your own * */
    public static void registerHudElement() {
        ConfigFileHandler.readFromConfig();
        ModRegisterFunctions.registerShouldRenderModSettings("Mana", true);
        ModRegisterFunctions.registerColorModSettings("Mana", 0x007FFF);
        ModRegisterFunctions.registerAlphaModSettings("Mana", 1.0f);
        ModRegisterFunctions.registerIconModSettings("Mana", true);
        ModRegisterFunctions.registerHudElementSide("Mana", true);
        ModRegisterFunctions.registerModHudElements(new ManaHudElement());
        Settings.setupHudElements();
    }
}
