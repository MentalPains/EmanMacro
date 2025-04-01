/*
 * Decompiled with CFR 0.152.
 */
package baritone.api;

import baritone.api.utils.SettingsUtil;
import baritone.api.utils.TypeUtils;
import java.lang.reflect.Type;

public final class Settings.Setting<T> {
    public T value;
    public final T defaultValue;
    private String name;
    private boolean javaOnly;

    private Settings.Setting(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Cannot determine value type class from null");
        }
        this.value = t;
        this.defaultValue = t;
        this.javaOnly = false;
    }

    public final String getName() {
        return this.name;
    }

    public final Class<T> getValueClass() {
        return TypeUtils.resolveBaseClass(this.getType());
    }

    public final String toString() {
        return SettingsUtil.settingToString(this);
    }

    public final void reset() {
        this.value = this.defaultValue;
    }

    public final Type getType() {
        return Settings.this.settingTypes.get(this);
    }

    public final boolean isJavaOnly() {
        return this.javaOnly;
    }

    static /* synthetic */ String access$102(Settings.Setting setting, String string) {
        setting.name = string;
        return setting.name;
    }

    static /* synthetic */ boolean access$202(Settings.Setting setting, boolean bl) {
        setting.javaOnly = bl;
        return setting.javaOnly;
    }
}
