/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ca;
import baritone.cc;
import baritone.cp;
import baritone.di;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class ci
extends cc
implements di.b,
Cloneable {
    protected ci() {
    }

    @Override
    public abstract cp a();

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
        cp cp2 = this.a();
        while (n2-- != 0) {
            double d = cp2.b();
            n += ca.a(d);
        }
        return n;
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.a();
    }
}
