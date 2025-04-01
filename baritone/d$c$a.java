/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.a;
import baritone.api.Settings;

static final class d.c.a
extends Enum<d.c.a> {
    public static final int a = 2;
    public static final int b = 3;

    static int a(boolean bl) {
        Settings settings = baritone.a.a();
        boolean bl2 = (Boolean)settings.antiCheatCompatibility.value;
        boolean bl3 = (Boolean)settings.blockFreeLook.value;
        if (((Boolean)settings.freeLook.value).booleanValue()) {
            if (bl) {
                if (bl3) {
                    return 2;
                }
                return 1;
            }
            if (bl2) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    static {
        int[] nArray = new int[]{1, 2, 3};
    }
}
