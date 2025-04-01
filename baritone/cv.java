/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.cu;
import baritone.cw;
import baritone.cy;
import baritone.di;
import baritone.dy;
import baritone.ea;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class cv<V>
extends cu<V>
implements di<V>,
Serializable {
    protected cv() {
    }

    @Override
    public boolean containsValue(Object object) {
        return this.a().contains(object);
    }

    @Override
    public boolean a(long l) {
        return this.a().a(l);
    }

    @Override
    public void putAll(Map<? extends Long, ? extends V> entry) {
        int n = entry.size();
        Iterator<Map.Entry<Long, V>> iterator = entry.entrySet().iterator();
        if (entry instanceof di) {
            while (n-- != 0) {
                entry = (di.a)iterator.next();
                this.a(entry.a(), entry.getValue());
            }
            return;
        }
        while (n-- != 0) {
            entry = iterator.next();
            this.a(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    public di.b a() {
        return new cw(this);
    }

    public dy<V> a() {
        return new cy(this);
    }

    @Override
    public int hashCode() {
        int n = 0;
        int n2 = this.size();
        ea ea2 = this.a().a();
        while (n2-- != 0) {
            n += ((Map.Entry)ea2.next()).hashCode();
        }
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        if ((object = (Map)object).size() != this.size()) {
            return false;
        }
        return this.a().containsAll(object.entrySet());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ea ea2 = this.a().a();
        int n = this.size();
        boolean bl = true;
        stringBuilder.append("{");
        while (n-- != 0) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            di.a a2 = (di.a)ea2.next();
            stringBuilder.append(String.valueOf(a2.a()));
            stringBuilder.append("=>");
            if (this == a2.getValue()) {
                stringBuilder.append("(this map)");
                continue;
            }
            stringBuilder.append(String.valueOf(a2.getValue()));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ Set entrySet() {
        return this.a();
    }

    @Override
    public /* synthetic */ Collection values() {
        return this.a();
    }

    @Override
    public /* synthetic */ Set keySet() {
        return this.a();
    }
}
