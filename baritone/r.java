/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.aa;
import baritone.ab;
import baritone.ac;
import baritone.ad;
import baritone.ae;
import baritone.af;
import baritone.ag;
import baritone.ah;
import baritone.ai;
import baritone.aj;
import baritone.ak;
import baritone.al;
import baritone.api.utils.BetterBlockPos;
import baritone.bv;
import baritone.o;
import baritone.pathing.movement.CalculationContext;
import baritone.s;
import baritone.t;
import baritone.u;
import baritone.v;
import baritone.w;
import baritone.x;
import baritone.y;
import baritone.z;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class r
extends Enum<r> {
    private static /* enum */ r a = new s();
    private static /* enum */ r b = new ad();
    private static /* enum */ r c = new af();
    private static /* enum */ r d = new ag();
    private static /* enum */ r e = new ah();
    private static /* enum */ r f = new ai();
    private static /* enum */ r g = new aj();
    private static /* enum */ r h = new ak();
    private static /* enum */ r i = new al();
    private static /* enum */ r j = new t();
    private static /* enum */ r k = new u();
    private static /* enum */ r l = new v();
    private static /* enum */ r m = new w();
    private static /* enum */ r n = new x();
    private static /* enum */ r o = new y();
    private static /* enum */ r p = new z();
    private static /* enum */ r q = new aa();
    private static /* enum */ r r = new ab();
    private static /* enum */ r s = new ac();
    private static /* enum */ r t = new ae();
    public final boolean a;
    public final boolean b;
    public final int a;
    public final int b;
    public final int c;
    private static final /* synthetic */ r[] a;

    public static r[] values() {
        return (r[])a.clone();
    }

    public static r valueOf(String string) {
        return Enum.valueOf(r.class, string);
    }

    private r(int n2, int n3, int n4, boolean bl, boolean bl2) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.a = bl;
        this.b = bl2;
    }

    private r(int n2, int n3, int n4) {
        this(n2, n3, n4, false, false);
    }

    public abstract o a(CalculationContext var1, BetterBlockPos var2);

    public void a(CalculationContext calculationContext, int n, int n2, int n3, bv bv2) {
        if (this.a || this.b) {
            throw new UnsupportedOperationException();
        }
        bv2.a = n + this.a;
        bv2.b = n2 + this.b;
        bv2.c = n3 + this.c;
        bv2.a = this.a(calculationContext, n, n2, n3);
    }

    public double a(CalculationContext calculationContext, int n, int n2, int n3) {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ r(String string, int n, int n2, int n3, int n4, byte by) {
        this(n2, n3, n4);
    }

    /* synthetic */ r(String string, int n, int n2, int n3, int n4, boolean bl) {
        this(n2, n3, n4, bl, true);
    }

    static {
        a = new r[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t};
    }
}
