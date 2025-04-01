/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ave
 *  bfd
 *  bfx
 *  biu
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.Settings;
import java.awt.Color;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface bm {
    public static final bfx a = bfx.a();
    public static final bfd a = a.c();
    public static final biu a = ave.A().af();
    public static final Settings a;
    public static final float[] a;

    public static void a(Color object, float f) {
        object = ((Color)object).getColorComponents(null);
        bm.a[0] = (float)object[0];
        bm.a[1] = (float)object[1];
        bm.a[2] = (float)object[2];
        bm.a[3] = f;
    }

    static {
        ave.A().P();
        a = BaritoneAPI.getSettings();
        a = new float[]{1.0f, 1.0f, 1.0f, 255.0f};
    }
}
