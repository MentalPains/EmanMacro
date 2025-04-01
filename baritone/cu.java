/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.bz;
import java.io.Serializable;

public abstract class cu<V>
implements bz<V>,
Serializable {
    protected cu() {
    }

    @Override
    public V a(long l, V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V b(long l) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object object) {
        if (object == null) {
            return false;
        }
        return this.a((Long)object);
    }

    public V get(Object object) {
        if (object == null) {
            return null;
        }
        long l = (Long)object;
        if (this.a(l)) {
            return this.a(l);
        }
        return null;
    }

    @Deprecated
    public V a(Long l, V v) {
        long l2 = l;
        boolean bl = this.a(l2);
        v = this.a(l2, v);
        if (bl) {
            return v;
        }
        return null;
    }

    public V remove(Object object) {
        if (object == null) {
            return null;
        }
        long l = (Long)object;
        boolean bl = this.a(l);
        V v = this.b(l);
        if (bl) {
            return v;
        }
        return null;
    }

    @Deprecated
    public /* synthetic */ Object put(Object object, Object object2) {
        return this.a((Long)object, (V)object2);
    }
}
