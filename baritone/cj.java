/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ce;
import baritone.ck;
import baritone.cl;
import baritone.cr;
import java.io.Serializable;
import java.util.Collection;
import java.util.ListIterator;
import java.util.RandomAccess;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class cj
extends ce
implements Serializable,
Cloneable,
RandomAccess {
    protected transient double[] a;
    protected int a;

    public cj(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Initial capacity (" + n + ") is negative");
        }
        this.a = new double[n];
    }

    public cj() {
        this(16);
    }

    private void c(int n) {
        this.a = cl.a(this.a, n, this.a);
    }

    @Override
    public final void a(int n, double d) {
        this.a(n);
        cj cj2 = this;
        cj2.c(cj2.a + 1);
        if (n != this.a) {
            System.arraycopy(this.a, n, this.a, n + 1, this.a - n);
        }
        this.a[n] = d;
        ++this.a;
    }

    @Override
    public final boolean a(double d) {
        cj cj2 = this;
        cj2.c(cj2.a + 1);
        this.a[this.a++] = d;
        return true;
    }

    @Override
    public final double b(int n) {
        if (n >= this.a) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is greater than or equal to list size (" + this.a + ")");
        }
        return this.a[n];
    }

    @Override
    public final int a(double d) {
        for (int i = 0; i < this.a; ++i) {
            if (Double.doubleToLongBits(d) != Double.doubleToLongBits(this.a[i])) continue;
            return i;
        }
        return -1;
    }

    @Override
    public final int b(double d) {
        int n = this.a;
        while (n-- != 0) {
            if (Double.doubleToLongBits(d) != Double.doubleToLongBits(this.a[n])) continue;
            return n;
        }
        return -1;
    }

    @Override
    public final double a(int n) {
        if (n >= this.a) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is greater than or equal to list size (" + this.a + ")");
        }
        double d = this.a[n];
        --this.a;
        if (n != this.a) {
            System.arraycopy(this.a, n + 1, this.a, n, this.a - n);
        }
        return d;
    }

    @Override
    public final boolean c(double d) {
        int n = this.a(d);
        if (n == -1) {
            return false;
        }
        this.a(n);
        return true;
    }

    @Override
    public final double a(int n, double d) {
        if (n >= this.a) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is greater than or equal to list size (" + this.a + ")");
        }
        double d2 = this.a[n];
        this.a[n] = d;
        return d2;
    }

    @Override
    public final void clear() {
        this.a = 0;
    }

    @Override
    public final int size() {
        return this.a;
    }

    @Override
    public final boolean isEmpty() {
        return this.a == 0;
    }

    @Override
    public final void a(int n, int n2) {
        cl.b.a(this.a, n, n2);
        System.arraycopy(this.a, n2, this.a, n, this.a - n2);
        this.a -= n2 - n;
    }

    @Override
    public final boolean removeAll(Collection<?> collection) {
        int n;
        double[] dArray = this.a;
        int n2 = 0;
        for (n = 0; n < this.a; ++n) {
            if (collection.contains(dArray[n])) continue;
            dArray[n2++] = dArray[n];
        }
        n = this.a != n2 ? 1 : 0;
        this.a = n2;
        return n != 0;
    }

    @Override
    public final cr a(int n) {
        this.a(n);
        return new ck(this, n);
    }

    @Override
    public final /* synthetic */ ListIterator listIterator(int n) {
        return this.a(n);
    }

    public final /* synthetic */ Object clone() {
        cj cj2 = this;
        cj cj3 = new cj(cj2.a);
        System.arraycopy(cj2.a, 0, cj3.a, 0, cj2.a);
        cj3.a = cj2.a;
        return cj3;
    }
}
