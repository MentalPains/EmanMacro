/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ca;
import baritone.di;
import baritone.dj;
import baritone.dx;
import baritone.ea;
import java.util.Iterator;
import java.util.Map;

final class dj.e
extends dx<di.a<V>>
implements di.b<V> {
    private /* synthetic */ dj a;

    private dj.e(dj dj2) {
        this.a = dj2;
    }

    @Override
    public final ea<di.a<V>> a() {
        return new dj.a(this.a, 0);
    }

    @Override
    public final boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        if ((object = (Map.Entry)object).getKey() == null || !(object.getKey() instanceof Long)) {
            return false;
        }
        long l = (Long)object.getKey();
        object = object.getValue();
        if (l == 0L) {
            return this.a.a && (this.a.a[this.a.b] == null ? object == null : this.a.a[this.a.b].equals(object));
        }
        long[] lArray = this.a.a;
        int n = (int)ca.a(l) & this.a.a;
        long l2 = this.a.a[n];
        if (l2 == 0L) {
            return false;
        }
        if (l == l2) {
            if (this.a.a[n] == null) {
                return object == null;
            }
            return this.a.a[n].equals(object);
        }
        do {
            if ((l2 = lArray[n = n + 1 & this.a.a]) != 0L) continue;
            return false;
        } while (l != l2);
        if (this.a.a[n] == null) {
            return object == null;
        }
        return this.a.a[n].equals(object);
    }

    @Override
    public final boolean a(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        if ((object = (Map.Entry)object).getKey() == null || !(object.getKey() instanceof Long)) {
            return false;
        }
        long l = (Long)object.getKey();
        object = object.getValue();
        if (l == 0L) {
            if (this.a.a && (this.a.a[this.a.b] == null ? object == null : this.a.a[this.a.b].equals(object))) {
                this.a.a();
                return true;
            }
            return false;
        }
        long[] lArray = this.a.a;
        int n = (int)ca.a(l) & this.a.a;
        long l2 = this.a.a[n];
        if (l2 == 0L) {
            return false;
        }
        if (l2 == l) {
            if (this.a.a[n] == null ? object == null : this.a.a[n].equals(object)) {
                this.a.a(n);
                return true;
            }
            return false;
        }
        do {
            if ((l2 = lArray[n = n + 1 & this.a.a]) != 0L) continue;
            return false;
        } while (l2 != l || !(this.a.a[n] == null ? object == null : this.a.a[n].equals(object)));
        this.a.a(n);
        return true;
    }

    @Override
    public final int size() {
        return this.a.c;
    }

    @Override
    public final void clear() {
        this.a.clear();
    }

    @Override
    public final /* synthetic */ Iterator iterator() {
        return this.a();
    }

    /* synthetic */ dj.e(dj dj2, byte by) {
        this(dj2);
    }
}
