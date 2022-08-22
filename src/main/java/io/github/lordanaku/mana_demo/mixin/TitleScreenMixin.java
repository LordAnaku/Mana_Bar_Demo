package io.github.lordanaku.mana_demo.mixin;

import io.github.lordanaku.mana_demo.hud.RegisterHudElement;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        /* * Best place I have found to call function to garuntee that the config is loaded before we try to access it. */
        RegisterHudElement.registerHudElement();
    }
}
