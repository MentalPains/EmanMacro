/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.cw;
import baritone.dc;
import baritone.di;
import baritone.ea;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Exception performing whole class analysis ignored.
 */
final class cx
extends dc {
    private ea<Map.Entry<Long, V>> a;
    private /* synthetic */ cw a;

    cx(cw cw2) {
        this.a = cw2;
        this.a = this.a.a.a().a();
    }

    @Override
    public final long a() {
        return ((di.a)this.a.next()).a();
    }

    @Override
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override
    public final void remove() {
        this.a.remove();
    }
}
