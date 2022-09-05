package io.github.lordanaku.mana_demo.hud;

import io.github.lordanaku.anakus_status_bars.api.hudelements.IHudElement;
import io.github.lordanaku.anakus_status_bars.api.hudelements.RenderHudFunctions;
import io.github.lordanaku.anakus_status_bars.screen.gui.config.Settings;
import io.github.lordanaku.anakus_status_bars.utils.ASBModUtils;
import io.github.lordanaku.anakus_status_bars.utils.TextureRecords;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import me.shedaniel.clothconfig2.gui.entries.ColorEntry;
import me.shedaniel.clothconfig2.gui.entries.FloatListEntry;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

import static io.github.lordanaku.mana_demo.hud.RegisterHudElement.MANA;

public class ManaHudElement implements IHudElement {
    private boolean renderSide;

    @Override
    public void renderBar() {
        RenderHudFunctions.drawDefaultBar(getSide(), ASBModUtils.getPosYMod(getSide()), TextureRecords.DEFAULT_BAR);
        RenderHudFunctions.drawProgressBar(getSide(), ASBModUtils.getPosYMod(getSide()), TextureRecords.PROGRESS_BAR, getManaProgress(), Settings.colorSettings.get(MANA.name()), Settings.alphaSettings.get(MANA.name()));
    }

    @Override
    public void renderIcon() {
        RenderHudFunctions.drawIcon(getSide(), ASBModUtils.getPosYMod(getSide()), RegisterHudElement.MANA_ICON, 81);
    }

    @Override
    public void renderText() {
        RenderHudFunctions.drawText("Text", getSide(), shouldRenderIcon(), ASBModUtils.getPosYMod(getSide()), Settings.textColorSettings.get(MANA.name()), 81);
    }

    @Override
    public boolean getSide() {
        return renderSide;
    }

    @Override
    public IHudElement setSide(boolean side) {
        this.renderSide = side;
        return this;
    }

    @Override
    public boolean shouldRender() {
        return Settings.shouldRenderSettings.get(MANA.name());
    }

    @Override
    public boolean shouldRenderIcon() {
        return shouldRender() && Settings.iconSettings.get(MANA.name());
    }

    @Override
    public boolean shouldRenderText() {
        return shouldRender() && Settings.textSettings.get(MANA.name());
    }

    @Override
    public void registerSettings(ConfigCategory mainCategory, ConfigCategory iconCategory, ConfigCategory textCategory, ConfigCategory colorCategory, ConfigCategory textColorSettings, ConfigCategory alphaCategory, ConfigEntryBuilder entryBuilder) {
        BooleanListEntry toggleManaBar = entryBuilder.startBooleanToggle(Text.translatable("option.mana_demo.mana_bar"), Settings.shouldRenderSettings.get(MANA.name()))
                .setDefaultValue(MANA.shouldRender())
                .setSaveConsumer(newValue -> Settings.shouldRenderSettings.replace(MANA.name(), newValue))
                .build();
        mainCategory.addEntry(toggleManaBar);

        BooleanListEntry toggleManaIcon = entryBuilder.startBooleanToggle(Text.translatable("option.mana_demo.mana_icon"), Settings.iconSettings.get(MANA.name()))
                .setDefaultValue(MANA.shouldRenderIcon())
                .setSaveConsumer(newValue -> Settings.iconSettings.replace(MANA.name(), newValue))
                .build();
        iconCategory.addEntry(toggleManaIcon);

        BooleanListEntry toggleManaText = entryBuilder.startBooleanToggle(Text.translatable("option.mana_demo.mana_text"), Settings.textSettings.get(MANA.name()))
                .setDefaultValue(MANA.shouldRenderText())
                .setSaveConsumer(newValue -> Settings.textSettings.replace(MANA.name(), newValue))
                .build();
        textCategory.addEntry(toggleManaText);

        ColorEntry manaColor = entryBuilder.startColorField(Text.translatable("option.mana_demo.mana_color"), Settings.colorSettings.get(MANA.name()))
                .setDefaultValue(MANA.color())
                .setSaveConsumer(newValue -> Settings.colorSettings.replace(MANA.name(), newValue))
                .build();
        colorCategory.addEntry(manaColor);

        ColorEntry manaTextColor = entryBuilder.startColorField(Text.translatable("option.mana_demo.mana_text_color"), Settings.textColorSettings.get(MANA.name()))
                .setDefaultValue(MANA.color())
                .setSaveConsumer(newValue -> Settings.textColorSettings.replace(MANA.name(), newValue))
                .build();
        textColorSettings.addEntry(manaTextColor);

        FloatListEntry manaAlpha = entryBuilder.startFloatField(Text.translatable("option.mana_demo.mana_alpha"), Settings.alphaSettings.get(MANA.name()))
                .setDefaultValue(MANA.alpha())
                .setMin(0.0f)
                .setMax(1.0f)
                .setTooltip(Text.translatable("option.anakus_status_bars.alpha_tooltip"))
                .setSaveConsumer(newValue -> Settings.alphaSettings.replace(MANA.name(), MathHelper.clamp(newValue, 0, 1)))
                .build();
        alphaCategory.addEntry(manaAlpha);
    }

    @Override
    public String name() {
        return MANA.name();
    }

    private int getManaProgress() {
        float mana = 10f;
        float manaMax = 20f;
        float ratio = Math.min(1, Math.max(0, mana / manaMax));
        int maxProgress = 81;
        return Math.min(maxProgress, MathHelper.ceil(ratio * maxProgress) + 2);
    }
}
