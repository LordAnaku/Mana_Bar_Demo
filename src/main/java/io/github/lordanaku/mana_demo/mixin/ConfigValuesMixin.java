package io.github.lordanaku.mana_demo.mixin;

import io.github.lordanaku.anakus_status_bars.screen.gui.config.ConfigValues;
import io.github.lordanaku.anakus_status_bars.screen.gui.config.Settings;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import me.shedaniel.clothconfig2.gui.entries.ColorEntry;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConfigValues.class)
public class ConfigValuesMixin {

    @Inject(at = @At("TAIL"), method = "buildMain", remap = false)
    private static void buildMain(ConfigCategory category, ConfigEntryBuilder builder, CallbackInfo ci) {
        BooleanListEntry enableManaBar = builder.startBooleanToggle(Text.translatable("option.mana_demo.enable_mana_bar"), Settings.shouldRenderSettings.get("Mana"))
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> Settings.shouldRenderSettings.replace("Mana", newValue))
                .build();
        category.addEntry(enableManaBar);
    }

    @Inject(at = @At("TAIL"), method = "buildColors", remap = false)
    private static void buildColors(ConfigCategory category, ConfigEntryBuilder builder, CallbackInfo ci) {
        ColorEntry manaBarColor = builder.startColorField(Text.translatable("option.mana_demo.enable_mana_bar"), Settings.colorSettings.get("Mana"))
                .setDefaultValue(0x007FFF)
                .setSaveConsumer(newValue -> Settings.colorSettings.replace("Mana", newValue))
                .build();
        category.addEntry(manaBarColor);
    }
}
