/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aui
 */
package baritone;

import baritone.api.utils.IPlayerContext;
import baritone.api.utils.input.Input;
import baritone.br;
import java.util.Arrays;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bl
extends Enum<bl> {
    private static /* enum */ bl a = new bl(0, new Input[0]);
    private static /* enum */ bl b = new bl(0, Input.MOVE_FORWARD);
    private static /* enum */ bl c = new bl(0, Input.MOVE_FORWARD, Input.SPRINT);
    private static /* enum */ bl d = new bl(180, Input.MOVE_BACK);
    private static /* enum */ bl e = new bl(-90, Input.MOVE_LEFT);
    private static /* enum */ bl f = new bl(90, Input.MOVE_RIGHT);
    private static /* enum */ bl g = new bl(-45, Input.MOVE_FORWARD, Input.MOVE_LEFT);
    private static /* enum */ bl h = new bl(-45, Input.MOVE_FORWARD, Input.MOVE_LEFT, Input.SPRINT);
    private static /* enum */ bl i = new bl(45, Input.MOVE_FORWARD, Input.MOVE_RIGHT);
    private static /* enum */ bl j = new bl(45, Input.MOVE_FORWARD, Input.MOVE_RIGHT, Input.SPRINT);
    private static /* enum */ bl k = new bl(-135, Input.MOVE_BACK, Input.MOVE_LEFT);
    private static /* enum */ bl l = new bl(135, Input.MOVE_BACK, Input.MOVE_RIGHT);
    private final int a;
    public final Input[] a;
    private static final /* synthetic */ bl[] a;

    public static bl[] values() {
        return (bl[])a.clone();
    }

    public static bl valueOf(String string) {
        return Enum.valueOf(bl.class, string);
    }

    private bl(int n2, Input ... inputArray) {
        this.a = n2;
        this.a = inputArray;
    }

    private static float a(List<Input> list, double d) {
        double d2 = 1.0;
        if (list.contains((Object)Input.SPRINT)) {
            d2 = 1.3;
        }
        return (float)(d2 * 0.1 * d);
    }

    private static float a(IPlayerContext iPlayerContext) {
        return iPlayerContext.player().bI() / (0.1f * (iPlayerContext.player().aw() ? 1.3f : 1.0f));
    }

    public final aui a(br br2, IPlayerContext iPlayerContext) {
        List<Input> list = Arrays.asList(this.a);
        float f = 0.0f;
        float f2 = 0.0f;
        if (list.contains((Object)Input.MOVE_FORWARD)) {
            f2 = 1.0f;
        }
        if (list.contains((Object)Input.MOVE_BACK)) {
            f2 -= 1.0f;
        }
        if (list.contains((Object)Input.MOVE_LEFT)) {
            f = 1.0f;
        }
        if (list.contains((Object)Input.MOVE_RIGHT)) {
            f -= 1.0f;
        }
        if (list.contains((Object)Input.SNEAK)) {
            f = (float)((double)f * 0.3);
            f2 = (float)((double)f2 * 0.3);
        }
        br2.d = f2;
        br2.c = f;
        br2.b = bl.a(list, bl.a(iPlayerContext));
        br2.a = list.contains((Object)Input.SNEAK);
        if (list.contains((Object)Input.SPRINT)) {
            br2.a = (float)((double)br2.a * 1.3);
        }
        br2.a();
        return new aui(br2.a, br2.b, br2.c);
    }

    static {
        a = new bl[]{a, b, c, d, e, f, g, h, i, j, k, l};
    }
}
