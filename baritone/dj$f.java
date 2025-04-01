/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ca;
import baritone.dj;
import baritone.dl;
import java.util.NoSuchElementException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class dj.f {
    private int a;
    private int b = -1;
    private int c;
    private boolean a;
    private dl a;
    private /* synthetic */ dj a;

    private dj.f(dj dj2) {
        this.a = dj2;
        this.a = this.a.b;
        this.c = this.a.c;
        this.a = this.a.a;
    }

    public boolean hasNext() {
        return this.c != 0;
    }

    public final int a() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        --this.c;
        if (this.a) {
            this.a = false;
            this.b = this.a.b;
            return this.b;
        }
        long[] lArray = this.a.a;
        do {
            if (--this.a >= 0) continue;
            this.b = Integer.MIN_VALUE;
            long l = this.a.b(-this.a - 1);
            int n = (int)ca.a(l) & this.a.a;
            while (l != lArray[n]) {
                n = n + 1 & this.a.a;
            }
            return n;
        } while (lArray[this.a] == 0L);
        this.b = this.a;
        return this.b;
    }

    private final void a(int n) {
        long[] lArray = this.a.a;
        while (true) {
            long l;
            int n2 = n;
            n = n2 + 1 & this.a.a;
            while (true) {
                if ((l = lArray[n]) == 0L) {
                    lArray[n2] = 0L;
                    this.a.a[n2] = (long)null;
                    return;
                }
                int n3 = (int)ca.a(l) & this.a.a;
                if (n2 > n ? n2 >= n3 && n3 > n : n2 >= n3 || n3 > n) break;
                n = n + 1 & this.a.a;
            }
            if (n < n2) {
                if (this.a == null) {
                    this.a = new dl(2);
                }
                this.a.b(lArray[n]);
            }
            lArray[n2] = l;
            this.a.a[n2] = this.a.a[n];
        }
    }

    public void remove() {
        if (this.b == -1) {
            throw new IllegalStateException();
        }
        if (this.b == this.a.b) {
            this.a.a = false;
            this.a.a[this.a.b] = (long)null;
        } else if (this.a >= 0) {
            dj.f f2 = this;
            f2.a(f2.b);
        } else {
            this.a.b(this.a.b(-this.a - 1));
            this.b = -1;
            return;
        }
        --this.a.c;
        this.b = -1;
    }

    /* synthetic */ dj.f(dj dj2, byte by) {
        this(dj2);
    }
}
