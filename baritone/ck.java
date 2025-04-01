/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ch;
import baritone.cj;
import java.util.NoSuchElementException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Exception performing whole class analysis ignored.
 */
final class ck
extends ch {
    private int a;
    private int b = -1;
    private /* synthetic */ int c;
    private /* synthetic */ cj a;

    ck(cj cj2, int n) {
        this.a = cj2;
        this.c = n;
        this.a = this.c;
    }

    @Override
    public final boolean hasNext() {
        return this.a < this.a.a;
    }

    @Override
    public final boolean hasPrevious() {
        return this.a > 0;
    }

    @Override
    public final double b() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.b = this.a++;
        return this.a.a[this.b];
    }

    @Override
    public final double a() {
        if (!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.b = --this.a;
        return this.a.a[this.a];
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
    public final void a(double d) {
        this.a.a(this.a++, d);
        this.b = -1;
    }

    @Override
    public final void b(double d) {
        if (this.b == -1) {
            throw new IllegalStateException();
        }
        this.a.a(this.b, d);
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
