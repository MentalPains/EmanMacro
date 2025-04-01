/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 *  cq
 *  df
 *  javax.annotation.Nonnull
 *  ns
 */
package baritone.api.utils;

import javax.annotation.Nonnull;

public final class BetterBlockPos
extends cj {
    public static final BetterBlockPos ORIGIN = new BetterBlockPos(0, 0, 0);
    public final int a;
    public final int c;
    public final int d;

    public BetterBlockPos(int n, int n2, int n3) {
        super(n, n2, n3);
        this.a = n;
        this.c = n2;
        this.d = n3;
    }

    public BetterBlockPos(double d, double d2, double d3) {
        this(ns.c((double)d), ns.c((double)d2), ns.c((double)d3));
    }

    public BetterBlockPos(cj cj2) {
        this(cj2.n(), cj2.o(), cj2.p());
    }

    public static BetterBlockPos from(cj cj2) {
        if (cj2 == null) {
            return null;
        }
        return new BetterBlockPos(cj2);
    }

    public final int hashCode() {
        return (int)BetterBlockPos.longHash(this.a, this.c, this.d);
    }

    public static long longHash(BetterBlockPos betterBlockPos) {
        return BetterBlockPos.longHash(betterBlockPos.a, betterBlockPos.c, betterBlockPos.d);
    }

    public static long longHash(int n, int n2, int n3) {
        long l = 11206370049L + (long)n;
        l = 8734625L * l + (long)n2;
        return 2873465L * l + (long)n3;
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof BetterBlockPos) {
            object = (BetterBlockPos)((Object)object);
            return ((BetterBlockPos)((Object)object)).a == this.a && ((BetterBlockPos)((Object)object)).c == this.c && ((BetterBlockPos)((Object)object)).d == this.d;
        }
        return (object = (cj)object).n() == this.a && object.o() == this.c && object.p() == this.d;
    }

    public final BetterBlockPos up() {
        return new BetterBlockPos(this.a, this.c + 1, this.d);
    }

    public final BetterBlockPos up(int n) {
        if (n == 0) {
            return this;
        }
        return new BetterBlockPos(this.a, this.c + n, this.d);
    }

    public final BetterBlockPos down() {
        return new BetterBlockPos(this.a, this.c - 1, this.d);
    }

    public final BetterBlockPos down(int n) {
        if (n == 0) {
            return this;
        }
        return new BetterBlockPos(this.a, this.c - n, this.d);
    }

    public final BetterBlockPos offset(cq cq2) {
        cq2 = cq2.m();
        return new BetterBlockPos(this.a + cq2.n(), this.c + cq2.o(), this.d + cq2.p());
    }

    public final BetterBlockPos offset(cq cq2, int n) {
        if (n == 0) {
            return this;
        }
        cq2 = cq2.m();
        return new BetterBlockPos(this.a + cq2.n() * n, this.c + cq2.o() * n, this.d + cq2.p() * n);
    }

    public final BetterBlockPos north() {
        return new BetterBlockPos(this.a, this.c, this.d - 1);
    }

    public final BetterBlockPos north(int n) {
        if (n == 0) {
            return this;
        }
        return new BetterBlockPos(this.a, this.c, this.d - n);
    }

    public final BetterBlockPos south() {
        return new BetterBlockPos(this.a, this.c, this.d + 1);
    }

    public final BetterBlockPos south(int n) {
        if (n == 0) {
            return this;
        }
        return new BetterBlockPos(this.a, this.c, this.d + n);
    }

    public final BetterBlockPos east() {
        return new BetterBlockPos(this.a + 1, this.c, this.d);
    }

    public final BetterBlockPos east(int n) {
        if (n == 0) {
            return this;
        }
        return new BetterBlockPos(this.a + n, this.c, this.d);
    }

    public final BetterBlockPos west() {
        return new BetterBlockPos(this.a - 1, this.c, this.d);
    }

    public final BetterBlockPos west(int n) {
        if (n == 0) {
            return this;
        }
        return new BetterBlockPos(this.a - n, this.c, this.d);
    }

    @Nonnull
    public final String toString() {
        return String.format("BetterBlockPos{x=%s,y=%s,z=%s}", this.a, this.c, this.d);
    }

    public final /* synthetic */ cj a(cq cq2, int n) {
        return this.offset(cq2, n);
    }

    public final /* synthetic */ cj a(cq cq2) {
        return this.offset(cq2);
    }

    public final /* synthetic */ cj g(int n) {
        return this.east(n);
    }

    public final /* synthetic */ cj f() {
        return this.east();
    }

    public final /* synthetic */ cj f(int n) {
        return this.west(n);
    }

    public final /* synthetic */ cj e() {
        return this.west();
    }

    public final /* synthetic */ cj e(int n) {
        return this.south(n);
    }

    public final /* synthetic */ cj d() {
        return this.south();
    }

    public final /* synthetic */ cj d(int n) {
        return this.north(n);
    }

    public final /* synthetic */ cj c() {
        return this.north();
    }

    public final /* synthetic */ cj c(int n) {
        return this.down(n);
    }

    public final /* synthetic */ cj b() {
        return this.down();
    }

    public final /* synthetic */ cj b(int n) {
        return this.up(n);
    }

    public final /* synthetic */ cj a() {
        return this.up();
    }

    public final /* synthetic */ df d(df df2) {
        return super.c(df2);
    }

    public final /* synthetic */ int compareTo(Object object) {
        return super.g((df)object);
    }
}
