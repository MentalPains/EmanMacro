/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ams
 */
package baritone;

public final class bu {
    private final double a;
    private final double b;
    private final double c;
    private final double d;

    public bu(ams ams2) {
        this.a = ams2.b();
        this.b = ams2.d();
        this.c = ams2.c();
        this.d = ams2.e();
    }

    public final boolean a(int n, int n2) {
        return (double)(n + 1) > this.a && (double)n < this.b && (double)(n2 + 1) > this.c && (double)n2 < this.d;
    }
}
