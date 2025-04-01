/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.utils;

import baritone.api.Settings;

static class SettingsUtil.ParserContext {
    private final Settings.Setting<?> setting;

    private SettingsUtil.ParserContext(Settings.Setting<?> setting) {
        this.setting = setting;
    }

    private Settings.Setting<?> getSetting() {
        return this.setting;
    }

    static /* synthetic */ Settings.Setting access$200(SettingsUtil.ParserContext parserContext) {
        return parserContext.getSetting();
    }
}
