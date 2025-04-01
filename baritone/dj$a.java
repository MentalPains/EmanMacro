/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.di;
import baritone.dj;
import baritone.ea;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class dj.a
extends dj.f
implements ea<di.a<V>> {
    private dj.d a;
    private /* synthetic */ dj a;

    private dj.a(dj dj2) {
        this.a = dj2;
        super(dj2, (byte)0);
    }

    @Override
    public final void remove() {
        super.remove();
        this.a.a = -1;
    }

    @Override
    public final /* synthetic */ Object next() {
        dj.a a2 = this;
        this.a = new dj.d(a2.a, a2.a());
        return this.a;
    }

    /* synthetic */ dj.a(dj dj2, byte by) {
        this(dj2);
    }
}
