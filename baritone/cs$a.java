/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ca;
import baritone.cd;
import baritone.cj;
import baritone.cs;
import java.util.NoSuchElementException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class cs.a
extends cd {
    private int a;
    private int b = -1;
    private int c;
    private boolean a;
    private cj a;
    private /* synthetic */ cs a;

    private cs.a(cs cs2) {
        this.a = cs2;
        this.a = this.a.b;
        this.c = this.a.c;
        this.a = this.a.a;
    }

    @Override
    public final boolean hasNext() {
        return this.c != 0;
    }

    @Override
    public final double b() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        --this.c;
        if (this.a) {
            this.a = false;
            this.b = this.a.b;
            return this.a.a[this.a.b];
        }
        double[] dArray = this.a.a;
        do {
            if (--this.a >= 0) continue;
            this.b = Integer.MIN_VALUE;
            return this.a.b(-this.a - 1);
        } while (Double.doubleToLongBits(dArray[this.a]) == 0L);
        this.b = this.a;
        return dArray[this.b];
    }

    private final void a(int n) {
        double[] dArray = this.a.a;
        while (true) {
            double d;
            int n2 = n;
            n = n2 + 1 & this.a.a;
            while (true) {
                if (Double.doubleToLongBits(d = dArray[n]) == 0L) {
                    dArray[n2] = 0.0;
                    return;
                }
                int n3 = (int)ca.a(Double.doubleToRawLongBits(d)) & this.a.a;
                if (n2 > n ? n2 >= n3 && n3 > n : n2 >= n3 || n3 > n) break;
                n = n + 1 & this.a.a;
            }
            if (n < n2) {
                if (this.a == null) {
                    this.a = new cj(2);
                }
                this.a.a(dArray[n]);
            }
            dArray[n2] = d;
        }
    }

    @Override
    public final void remove() {
        if (this.b == -1) {
            throw new IllegalStateException();
        }
        if (this.b == this.a.b) {
            this.a.a = false;
            this.a.a[this.a.b] = 0.0;
        } else if (this.a >= 0) {
            cs.a a2 = this;
            a2.a(a2.b);
        } else {
            this.a.c(this.a.b(-this.a - 1));
            this.b = -1;
            return;
        }
        --this.a.c;
        this.b = -1;
    }

    /* synthetic */ cs.a(cs cs2, byte by) {
        this(cs2);
    }
}
