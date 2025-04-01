/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.du;
import baritone.ea;
import baritone.ec;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class dx<K>
extends du<K>
implements ec<K>,
Cloneable {
    protected dx() {
    }

    @Override
    public abstract ea<K> a();

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        if ((object = (Set)object).size() != this.size()) {
            return false;
        }
        return this.containsAll((Collection<?>)object);
    }

    @Override
    public int hashCode() {
        int n = 0;
        int n2 = this.size();
        ea<K> ea2 = this.a();
        while (n2-- != 0) {
            Object e = ea2.next();
            n += e == null ? 0 : e.hashCode();
        }
        return n;
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.a();
    }
}
