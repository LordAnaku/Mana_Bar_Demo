package io.github.lordanaku.mana_demo.hud;

import io.github.lordanaku.anakus_status_bars.api.hudelements.HudElements;

public class ManaHudElement implements HudElements {
    @Override
    public void renderBar() {

    }

    @Override
    public void renderIcon() {

    }

    @Override
    public boolean getSide() {
        return false;
    }

    @Override
    public HudElements setSide(boolean side) {
        return null;
    }

    @Override
    public boolean shouldRender() {
        return false;
    }

    @Override
    public boolean shouldRenderIcon() {
        return false;
    }

    @Override
    public String name() {
        return null;
    }
}
