package io.github.lordanaku.mana_demo.hud;

import io.github.lordanaku.anakus_status_bars.api.hudelements.HudElements;
import io.github.lordanaku.anakus_status_bars.screen.gui.config.Settings;
import io.github.lordanaku.anakus_status_bars.screen.hud.RenderHudElements;
import io.github.lordanaku.anakus_status_bars.utils.ASBModUtils;
import io.github.lordanaku.anakus_status_bars.utils.TextureUtils;
import net.minecraft.util.math.MathHelper;

public class ManaHudElement implements HudElements {
    private boolean renderSide;
    private int progress;

    @Override
    public void renderBar() {
        getManaProgress();
        RenderHudElements.drawDefaultBar(getSide(), ASBModUtils.getPosYMod(getSide()));
        RenderHudElements.drawProgressBar(getSide(), ASBModUtils.getPosYMod(getSide()), progress, Settings.colorSettings.get("Mana"), Settings.alphaSettings.get("Mana"));
    }

    @Override
    public void renderIcon() {
        RenderHudElements.drawIcon(getSide(), ASBModUtils.getPosYMod(getSide()), TextureUtils.BUBBLE_ICON);
    }

    @Override
    public boolean getSide() {
        return renderSide;
    }

    @Override
    public HudElements setSide(boolean side) {
        this.renderSide = side;
        return this;
    }

    @Override
    public boolean shouldRender() {
        return Settings.shouldRenderSettings.get("Mana");
    }

    @Override
    public boolean shouldRenderIcon() {
        return shouldRender() && Settings.iconSettings.get("Mana");
    }

    @Override
    public String name() {
        return "Mana";
    }

    private void getManaProgress() {
        float mana = 50;
        float manaMax = 100;
        float ratio = Math.min(1, Math.max(0, mana / manaMax));
        int maxProgress = TextureUtils.PROGRESS_BAR.getWidth();
        progress = Math.min(maxProgress, MathHelper.ceil(ratio * maxProgress) + 2);
    }
}
