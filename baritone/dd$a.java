/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.cr;
import baritone.dd;
import baritone.df;
import baritone.ds;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public static final class dd.a
extends dd
implements Serializable {
    protected final ds a;
    protected final int a;
    private int b;

    public dd.a(ds ds2, int n, int n2) {
        this.a = ds2;
        this.a = n;
        this.b = n2;
    }

    @Override
    public final boolean b(long l) {
        this.a.a(this.b, l);
        ++this.b;
        return true;
    }

    @Override
    public final void a(int n, long l) {
        this.a(n);
        this.a.a(this.a + n, l);
        ++this.b;
    }

    @Override
    public final boolean addAll(int n, Collection<? extends Long> collection) {
        this.a(n);
        this.b += collection.size();
        return this.a.addAll(this.a + n, collection);
    }

    @Override
    public final long b(int n) {
        this.b(n);
        return this.a.b(this.a + n);
    }

    @Override
    public final long a(int n) {
        this.b(n);
        --this.b;
        return this.a.a(this.a + n);
    }

    @Override
    public final long a(int n, long l) {
        this.b(n);
        return this.a.a(this.a + n, l);
    }

    @Override
    public final void clear() {
        this.a(0, this.size());
    }

    @Override
    public final int size() {
        return this.b - this.a;
    }

    @Override
    public final void a(int n, int n2) {
        this.a(n);
        this.a(n2);
        this.a.a(this.a + n, this.a + n2);
        this.b -= n2 - n;
    }

    @Override
    public final cr a(int n) {
        this.a(n);
        return new df(this, n);
    }

    @Override
    public final ds a(int n, int n2) {
        this.a(n);
        this.a(n2);
        if (n > n2) {
            throw new IllegalArgumentException("Start index (" + n + ") is greater than end index (" + n2 + ")");
        }
        return new dd.a(this, n, n2);
    }

    @Override
    public final boolean c(long l) {
        int n = this.a(l);
        if (n == -1) {
            return false;
        }
        --this.b;
        this.a.a(this.a + n);
        return true;
    }

    @Override
    public final boolean remove(Object object) {
        return this.c((Long)object);
    }

    @Override
    public final /* synthetic */ List subList(int n, int n2) {
        return this.a(n, n2);
    }

    @Override
    public final /* synthetic */ ListIterator listIterator(int n) {
        return this.a(n);
    }

    @Override
    public final /* synthetic */ ListIterator listIterator() {
        return ((dd)this).a(0);
    }

    @Override
    @Deprecated
    public final /* synthetic */ Object remove(int n) {
        return super.b(n);
    }

    @Override
    public final /* synthetic */ void add(int n, Object object) {
        super.a(n, (Long)object);
    }

    @Override
    @Deprecated
    public final /* synthetic */ Object set(int n, Object object) {
        return super.a(n, (Long)object);
    }

    @Override
    @Deprecated
    public final /* synthetic */ Object get(int n) {
        return super.a(n);
    }

    @Override
    public final /* synthetic */ Iterator iterator() {
        return ((dd)this).a(0);
    }

    @Override
    public final /* synthetic */ int compareTo(Object object) {
        return super.a((List)object);
    }
}
