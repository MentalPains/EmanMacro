/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ca;
import baritone.di;
import baritone.dj;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class dj.d
implements di.a<V>,
Map.Entry<Long, V> {
    int a;
    private /* synthetic */ dj a;

    dj.d(dj dj2, int n) {
        this.a = dj2;
        this.a = n;
    }

    @Override
    public final long a() {
        return this.a.a[this.a];
    }

    @Override
    public final V getValue() {
        return this.a.a[this.a];
    }

    @Override
    public final V setValue(V v) {
        long l = this.a.a[this.a];
        this.a.a[this.a] = (long)v;
        return l;
    }

    @Override
    public final boolean equals(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        return this.a.a[this.a] == (Long)(object = (Map.Entry)object).getKey() && (this.a.a[this.a] == null ? object.getValue() == null : this.a.a[this.a].equals(object.getValue()));
    }

    @Override
    public final int hashCode() {
        return ca.a(this.a.a[this.a]) ^ (this.a.a[this.a] == null ? 0 : this.a.a[this.a].hashCode());
    }

    public final String toString() {
        return this.a.a[this.a] + "=>" + this.a.a[this.a];
    }

    @Override
    @Deprecated
    public final /* synthetic */ Object getKey() {
        dj.d d2 = this;
        return d2.a.a[d2.a];
    }
}
