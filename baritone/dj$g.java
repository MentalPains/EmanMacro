/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.dj;
import baritone.ea;

final class dj.g
extends dj.f
implements ea<V> {
    private /* synthetic */ dj a;

    public dj.g(dj dj2) {
        this.a = dj2;
        super(dj2, (byte)0);
    }

    @Override
    public final V next() {
        return this.a.a[this.a()];
    }
}
