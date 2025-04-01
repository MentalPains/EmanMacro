/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.dj;
import baritone.du;
import baritone.ea;
import java.util.Iterator;

/*
 * Exception performing whole class analysis ignored.
 */
final class dk
extends du<V> {
    private /* synthetic */ dj a;

    dk(dj dj2) {
        this.a = dj2;
    }

    @Override
    public final ea<V> a() {
        return new dj.g(this.a);
    }

    @Override
    public final int size() {
        return this.a.c;
    }

    @Override
    public final boolean contains(Object object) {
        return this.a.containsValue(object);
    }

    @Override
    public final void clear() {
        this.a.clear();
    }

    @Override
    public final /* synthetic */ Iterator iterator() {
        return this.a();
    }
}
