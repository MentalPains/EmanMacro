/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.cl;
import baritone.cr;
import baritone.dd;
import baritone.dm;
import baritone.dn;
import java.io.Serializable;
import java.util.Collection;
import java.util.ListIterator;
import java.util.RandomAccess;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dl
extends dd
implements Serializable,
Cloneable,
RandomAccess {
    protected transient long[] a;
    protected int a;

    public dl(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Initial capacity (" + n + ") is negative");
        }
        this.a = new long[n];
    }

    public dl() {
        this(16);
    }

    private void c(int n) {
        this.a = dn.a(this.a, n, this.a);
    }

    @Override
    public final void a(int n, long l) {
        this.a(n);
        dl dl2 = this;
        dl2.c(dl2.a + 1);
        if (n != this.a) {
            System.arraycopy(this.a, n, this.a, n + 1, this.a - n);
        }
        this.a[n] = l;
        ++this.a;
    }

    @Override
    public final boolean b(long l) {
        dl dl2 = this;
        dl2.c(dl2.a + 1);
        this.a[this.a++] = l;
        return true;
    }

    @Override
    public final long b(int n) {
        if (n >= this.a) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is greater than or equal to list size (" + this.a + ")");
        }
        return this.a[n];
    }

    @Override
    public final int a(long l) {
        for (int i = 0; i < this.a; ++i) {
            if (l != this.a[i]) continue;
            return i;
        }
        return -1;
    }

    @Override
    public final int b(long l) {
        int n = this.a;
        while (n-- != 0) {
            if (l != this.a[n]) continue;
            return n;
        }
        return -1;
    }

    @Override
    public final long a(int n) {
        if (n >= this.a) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is greater than or equal to list size (" + this.a + ")");
        }
        long l = this.a[n];
        --this.a;
        if (n != this.a) {
            System.arraycopy(this.a, n + 1, this.a, n, this.a - n);
        }
        return l;
    }

    @Override
    public final boolean c(long l) {
        int n = this.a(l);
        if (n == -1) {
            return false;
        }
        this.a(n);
        return true;
    }

    @Override
    public final long a(int n, long l) {
        if (n >= this.a) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is greater than or equal to list size (" + this.a + ")");
        }
        long l2 = this.a[n];
        this.a[n] = l;
        return l2;
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
        long[] lArray = this.a;
        int n2 = 0;
        for (n = 0; n < this.a; ++n) {
            if (collection.contains(lArray[n])) continue;
            lArray[n2++] = lArray[n];
        }
        n = this.a != n2 ? 1 : 0;
        this.a = n2;
        return n != 0;
    }

    @Override
    public final cr a(int n) {
        this.a(n);
        return new dm(this, n);
    }

    @Override
    public final /* synthetic */ ListIterator listIterator(int n) {
        return this.a(n);
    }

    public final /* synthetic */ Object clone() {
        dl dl2 = this;
        dl dl3 = new dl(dl2.a);
        System.arraycopy(dl2.a, 0, dl3.a, 0, dl2.a);
        dl3.a = dl2.a;
        return dl3;
    }
}
