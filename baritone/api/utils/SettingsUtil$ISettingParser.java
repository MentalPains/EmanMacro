/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.utils;

import baritone.api.utils.SettingsUtil;
import java.lang.reflect.Type;

static interface SettingsUtil.ISettingParser<T> {
    public T parse(SettingsUtil.ParserContext var1, String var2);

    public String toString(SettingsUtil.ParserContext var1, T var2);

    public boolean accepts(Type var1);
}
