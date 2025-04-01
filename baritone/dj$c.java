/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.dh;
import baritone.dj;
import baritone.dr;
import java.util.Iterator;

final class dj.c
extends dh {
    private /* synthetic */ dj a;

    private dj.c(dj dj2) {
        this.a = dj2;
    }

    @Override
    public final dr a() {
        return new dj.b(this.a);
    }

    @Override
    public final int size() {
        return this.a.c;
    }

    @Override
    public final boolean a(long l) {
        return this.a.a(l);
    }

    @Override
    public final boolean c(long l) {
        int n = this.a.c;
        this.a.b(l);
        return this.a.c != n;
    }

    @Override
    public final void clear() {
        this.a.clear();
    }

    @Override
    public final /* synthetic */ Iterator iterator() {
        return this.a();
    }

    /* synthetic */ dj.c(dj dj2, byte by) {
        this(dj2);
    }
}
