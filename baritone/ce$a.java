/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ce;
import baritone.cg;
import baritone.cq;
import baritone.cr;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public static final class ce.a
extends ce
implements Serializable {
    protected final cq a;
    protected final int a;
    private int b;

    public ce.a(cq cq2, int n, int n2) {
        this.a = cq2;
        this.a = n;
        this.b = n2;
    }

    @Override
    public final boolean a(double d) {
        this.a.a(this.b, d);
        ++this.b;
        return true;
    }

    @Override
    public final void a(int n, double d) {
        this.a(n);
        this.a.a(this.a + n, d);
        ++this.b;
    }

    @Override
    public final boolean addAll(int n, Collection<? extends Double> collection) {
        this.a(n);
        this.b += collection.size();
        return this.a.addAll(this.a + n, collection);
    }

    @Override
    public final double b(int n) {
        this.b(n);
        return this.a.b(this.a + n);
    }

    @Override
    public final double a(int n) {
        this.b(n);
        --this.b;
        return this.a.a(this.a + n);
    }

    @Override
    public final double a(int n, double d) {
        this.b(n);
        return this.a.a(this.a + n, d);
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
        return new cg(this, n);
    }

    @Override
    public final cq a(int n, int n2) {
        this.a(n);
        this.a(n2);
        if (n > n2) {
            throw new IllegalArgumentException("Start index (" + n + ") is greater than end index (" + n2 + ")");
        }
        return new ce.a(this, n, n2);
    }

    @Override
    public final boolean c(double d) {
        int n = this.a(d);
        if (n == -1) {
            return false;
        }
        --this.b;
        this.a.a(this.a + n);
        return true;
    }

    @Override
    public final boolean remove(Object object) {
        return this.c((Double)object);
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
        return ((ce)this).a(0);
    }

    @Override
    @Deprecated
    public final /* synthetic */ Object remove(int n) {
        return super.b(n);
    }

    @Override
    public final /* synthetic */ void add(int n, Object object) {
        super.a(n, (Double)object);
    }

    @Override
    @Deprecated
    public final /* synthetic */ Object set(int n, Object object) {
        return super.a(n, (Double)object);
    }

    @Override
    @Deprecated
    public final /* synthetic */ Object get(int n) {
        return super.a(n);
    }

    @Override
    public final /* synthetic */ Iterator iterator() {
        return ((ce)this).a(0);
    }

    @Override
    public final /* synthetic */ int compareTo(Object object) {
        return super.a((List)object);
    }
}
