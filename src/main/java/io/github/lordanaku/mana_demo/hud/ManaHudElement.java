package io.github.lordanaku.mana_demo.hud;

import io.github.lordanaku.anakus_status_bars.api.hudelements.HudElements;
import io.github.lordanaku.anakus_status_bars.api.hudelements.RenderHudFunctions;
import io.github.lordanaku.anakus_status_bars.screen.gui.config.Settings;
import io.github.lordanaku.anakus_status_bars.utils.ASBModUtils;
import io.github.lordanaku.anakus_status_bars.utils.TextureRecords;
import net.minecraft.util.math.MathHelper;

public class ManaHudElement implements HudElements {
    private boolean renderSide;
    private int progress;

    @Override
    public void renderBar() {
        getManaProgress();
        RenderHudFunctions.drawDefaultBar(getSide(), ASBModUtils.getPosYMod(getSide()), TextureRecords.DEFAULT_BAR);
        RenderHudFunctions.drawProgressBar(getSide(), ASBModUtils.getPosYMod(getSide()), TextureRecords.PROGRESS_BAR, progress, Settings.colorSettings.get("Mana"), Settings.alphaSettings.get("Mana"));
    }

    @Override
    public void renderIcon() {
        RenderHudFunctions.drawIcon(getSide(), ASBModUtils.getPosYMod(getSide()), RegisterHudElement.MANA_ICON, 81);
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
        int maxProgress = 81;
        progress = Math.min(maxProgress, MathHelper.ceil(ratio * maxProgress) + 2);
    }
}
