package io.github.lordanaku.mana_demo.hud;

import io.github.lordanaku.anakus_status_bars.api.ModRegisterFunctions;
import io.github.lordanaku.anakus_status_bars.api.hudelements.HudElementType;
import io.github.lordanaku.anakus_status_bars.api.hudelements.RenderHudFunctions;
import io.github.lordanaku.anakus_status_bars.screen.gui.config.Settings;
import io.github.lordanaku.anakus_status_bars.utils.TextureRecord;
import net.minecraft.util.Identifier;

public class RegisterHudElement {

    public static final HudElementType MANA = new HudElementType("mana", true, true, true, false, 0x007FFF, 1);
    public static final Identifier MANA_HUD_ELEMENT = new Identifier("mana_demo", "textures/gui/mana_hud_element.png");
    public static final TextureRecord MANA_ICON = new TextureRecord(MANA_HUD_ELEMENT, 99, 0, 9, 9, 256, 256);

    /* * Register calls must be made before setupHudElements() to work at start * */
    /* * Register calls must be made after readFromConfig() if you wish to use Anaku's Status Bars Mod Menu instead of your own * */
    public static void registerHudElement() {
        ModRegisterFunctions.registerShouldRenderModSettings(MANA.name(), MANA.shouldRender());
        ModRegisterFunctions.registerIconModSettings(MANA.name(), MANA.shouldRenderIcon());
        ModRegisterFunctions.registerTextModSettings(MANA.name(), MANA.shouldRenderText());
        ModRegisterFunctions.registerColorModSettings(MANA.name(), MANA.color());
        ModRegisterFunctions.registerTextColorModSettings(MANA.name(), MANA.color());
        ModRegisterFunctions.registerAlphaModSettings(MANA.name(), MANA.alpha());
        ModRegisterFunctions.registerHudElementSide(MANA.name(), MANA.side());
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
