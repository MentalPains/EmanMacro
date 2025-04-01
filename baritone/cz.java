/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.cy;
import baritone.di;
import baritone.dv;
import baritone.ea;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Exception performing whole class analysis ignored.
 */
final class cz
extends dv<V> {
    private ea<Map.Entry<Long, V>> a;
    private /* synthetic */ cy a;

    cz(cy cy2) {
        this.a = cy2;
        this.a = this.a.a.a().a();
    }

    @Override
    @Deprecated
    public final V next() {
        return ((di.a)this.a.next()).getValue();
    }

    @Override
    public final boolean hasNext() {
        return this.a.hasNext();
    }
}
