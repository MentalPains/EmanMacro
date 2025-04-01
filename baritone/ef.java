/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ed;
import baritone.ee;
import baritone.eg;
import baritone.en;
import baritone.eo;
import baritone.ep;
import baritone.er;
import baritone.es;
import baritone.ev;
import java.util.Arrays;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ef
implements ed {
    private final double[] a;
    private final ee[] a;
    private final int a;

    public ef(double[] dArray, ee[] eeArray) {
        if (dArray == null) {
            throw new en();
        }
        if (dArray.length < 2) {
            throw new eo((er)es.d, (Number)2, dArray.length);
        }
        if (dArray.length - 1 != eeArray.length) {
            throw new eg(eeArray.length, dArray.length);
        }
        ev.a(dArray, ev.a.a);
        this.a = dArray.length - 1;
        this.a = new double[this.a + 1];
        System.arraycopy(dArray, 0, this.a, 0, this.a + 1);
        this.a = new ee[this.a];
        System.arraycopy(eeArray, 0, this.a, 0, this.a);
    }

    public final double a(double d) {
        if (d < this.a[0] || d > this.a[this.a]) {
            throw new ep(d, (Number)this.a[0], this.a[this.a]);
        }
        int n = Arrays.binarySearch(this.a, d);
        if (n < 0) {
            n = -n - 2;
        }
        if (n >= this.a.length) {
            --n;
        }
        return this.a[n].a(d - this.a[n]);
    }

    public final ef a() {
        ee[] eeArray = new ee[this.a];
        for (int i = 0; i < this.a; ++i) {
            eeArray[i] = this.a[i].a();
        }
        return new ef(this.a, eeArray);
    }
}
