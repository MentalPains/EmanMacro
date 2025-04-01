/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.an;
import baritone.ao;
import baritone.ap;
import baritone.api.utils.BetterBlockPos;
import baritone.aq;
import baritone.ar;
import baritone.as;
import baritone.o;
import baritone.pathing.movement.CalculationContext;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class am
extends Enum<am> {
    private static /* enum */ am a = new an();
    private static /* enum */ am b = new ao();
    private static /* enum */ am c = new ap();
    private static /* enum */ am d = new aq();
    private static /* enum */ am e = new ar();
    private static /* enum */ am f = new as();
    public final int a;
    public final int b;
    public final int c;
    private static final /* synthetic */ am[] a;

    public static am[] values() {
        return (am[])a.clone();
    }

    public static am valueOf(String string) {
        return Enum.valueOf(am.class, string);
    }

    private am(int n2, int n3, int n4) {
        this.a = n2;
        this.b = n3;
        this.c = n4;
    }

    public abstract o a(CalculationContext var1, BetterBlockPos var2);

    public double a(CalculationContext calculationContext, int n, int n2, int n3) {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ am(String string, int n, int n2, int n3, int n4, byte by) {
        this(n2, n3, n4);
    }

    static {
        a = new am[]{a, b, c, d, e, f};
    }
}
