/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.Settings;
import baritone.api.utils.Rotation;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public static final class d.c {
    public final Rotation a;
    public final Rotation b;
    public final int a;

    public d.c(Rotation rotation, Rotation rotation2, int n) {
        this.a = rotation;
        this.b = rotation2;
        this.a = n;
    }

    static final class a
    extends Enum<a> {
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
}
