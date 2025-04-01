/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.dd;
import baritone.dg;
import java.util.NoSuchElementException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Exception performing whole class analysis ignored.
 */
final class df
extends dg {
    private int a;
    private int b = -1;
    private /* synthetic */ int c;
    private /* synthetic */ dd.a a;

    df(dd.a a2, int n) {
        this.a = a2;
        this.c = n;
        this.a = this.c;
    }

    @Override
    public final boolean hasNext() {
        return this.a < this.a.size();
    }

    @Override
    public final boolean hasPrevious() {
        return this.a > 0;
    }

    @Override
    public final long a() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.b = this.a++;
        return this.a.a.b(this.a.a + this.b);
    }

    @Override
    public final long b() {
        if (!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.b = --this.a;
        return this.a.a.b(this.a.a + this.a);
    }

    @Override
    public final int nextIndex() {
        return this.a;
    }

    @Override
    public final int previousIndex() {
        return this.a - 1;
    }

    @Override
    public final void a(long l) {
        if (this.b == -1) {
            throw new IllegalStateException();
        }
        this.a.a(this.a++, l);
        this.b = -1;
    }

    @Override
    public final void b(long l) {
        if (this.b == -1) {
            throw new IllegalStateException();
        }
        this.a.a(this.b, l);
    }

    @Override
    public final void remove() {
        if (this.b == -1) {
            throw new IllegalStateException();
        }
        this.a.a(this.b);
        if (this.b < this.a) {
            --this.a;
        }
        this.b = -1;
    }
}
