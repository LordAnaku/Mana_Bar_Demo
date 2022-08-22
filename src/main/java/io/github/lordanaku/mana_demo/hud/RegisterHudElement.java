package io.github.lordanaku.mana_demo.hud;

import io.github.lordanaku.anakus_status_bars.api.ModRegisterFunctions;
import io.github.lordanaku.anakus_status_bars.api.hudelements.RenderHudFunctions;
import io.github.lordanaku.anakus_status_bars.screen.gui.config.ConfigFileHandler;
import io.github.lordanaku.anakus_status_bars.screen.gui.config.Settings;
import net.minecraft.util.Identifier;

public class RegisterHudElement {

    public static final Identifier MANA_HUD_ELEMENT = new Identifier("mana_demo", "textures/gui/mana_hud_element.png");

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

    /* * if you wish to add your own custom textures look here if you wish to replace defaults * */
    public static void setNewTextures() {
        /* * Set new textures for mana hud element * */
        RenderHudFunctions.setDefaultTexture(MANA_HUD_ELEMENT);

        /* * set new Y mod for mana hud element (needs to be bar height + 1) * */
        RenderHudFunctions.setYModIncrement(10);
    }
}
