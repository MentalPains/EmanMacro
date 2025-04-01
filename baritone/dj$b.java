/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.dj;
import baritone.dr;

final class dj.b
extends dj.f
implements dr {
    private /* synthetic */ dj a;

    public dj.b(dj dj2) {
        this.a = dj2;
        super(dj2, (byte)0);
    }

    @Override
    public final long a() {
        return this.a.a[this.a()];
    }

    @Override
    public final /* synthetic */ Object next() {
        dj.b b2 = this;
        return b2.a.a[b2.a()];
    }
}
