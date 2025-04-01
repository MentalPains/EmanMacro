/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ca;
import baritone.db;
import baritone.di;
import baritone.dr;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class dh
extends db
implements di.b,
Cloneable {
    protected dh() {
    }

    @Override
    public abstract dr a();

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
        dr dr2 = this.a();
        while (n2-- != 0) {
            long l = dr2.a();
            n += ca.a(l);
        }
        return n;
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.a();
    }
}
