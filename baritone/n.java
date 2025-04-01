/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.m;
import java.util.Arrays;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class n {
    private m[] a;
    public int a = new m[1024];

    public n() {
        this(0);
    }

    private n(byte by) {
    }

    public final void a(m m2) {
        if (this.a >= this.a.length - 1) {
            this.a = Arrays.copyOf(this.a, this.a.length << 1);
        }
        ++this.a;
        m2.d = this.a;
        this.a[this.a] = m2;
        this.b(m2);
    }

    public final void b(m m2) {
        int n2 = m2.d;
        int n3 = n2 >>> 1;
        double d = m2.c;
        m m3 = this.a[n3];
        while (n2 > 1 && m3.c > d) {
            this.a[n2] = m3;
            this.a[n3] = m2;
            m2.d = n3;
            m3.d = n2;
            n2 = n3;
            n3 = n2 >>> 1;
            m3 = this.a[n3];
        }
    }

    public final boolean a() {
        return this.a == 0;
    }

    public final m a() {
        m m2;
        if (this.a == 0) {
            throw new IllegalStateException();
        }
        m m3 = this.a[1];
        this.a[1] = m2 = this.a[this.a];
        m2.d = 1;
        this.a[this.a] = null;
        --this.a;
        m3.d = -1;
        if (this.a < 2) {
            return m3;
        }
        int n2 = 1;
        int n3 = 2;
        double d = m2.c;
        do {
            m m4 = this.a[n3];
            double d2 = m4.c;
            if (n3 < this.a) {
                m m5 = this.a[n3 + 1];
                double d3 = m5.c;
                if (d2 > d3) {
                    ++n3;
                    d2 = d3;
                    m4 = m5;
                }
            }
            if (d <= d2) break;
            this.a[n2] = m4;
            this.a[n3] = m2;
            m2.d = n3;
            m4.d = n2;
            n2 = n3;
        } while ((n3 <<= 1) <= this.a);
        return m3;
    }
}
