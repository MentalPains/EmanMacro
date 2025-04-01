/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.cn;
import baritone.cp;
import baritone.eb;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public abstract class cc
extends AbstractCollection<Double>
implements cn {
    protected cc() {
    }

    @Override
    public Object[] toArray() {
        Object[] objectArray = new Object[this.size()];
        eb.a(this.a(), objectArray);
        return objectArray;
    }

    @Override
    public <T> T[] toArray(T[] objectArray) {
        int n = this.size();
        if (objectArray.length < n) {
            objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n);
        }
        eb.a(this.a(), objectArray);
        if (n < objectArray.length) {
            objectArray[n] = null;
        }
        return objectArray;
    }

    @Override
    public boolean addAll(Collection<? extends Double> collection) {
        boolean bl = false;
        Iterator<? extends Double> iterator = collection.iterator();
        int n = collection.size();
        while (n-- != 0) {
            if (!this.a(iterator.next())) continue;
            bl = true;
        }
        return bl;
    }

    public boolean a(double d) {
        throw new UnsupportedOperationException();
    }

    public abstract cp a();

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            return false;
        }
        return this.c((Double)object);
    }

    private boolean a(Double d) {
        return this.a((double)d);
    }

    @Override
    public boolean contains(Object object) {
        if (object == null) {
            return false;
        }
        return this.b((Double)object);
    }

    public boolean b(double d) {
        cp cp2 = this.a();
        while (cp2.hasNext()) {
            if (d != cp2.b()) continue;
            return true;
        }
        return false;
    }

    public boolean c(double d) {
        cp cp2 = this.a();
        while (cp2.hasNext()) {
            if (d != cp2.b()) continue;
            cp2.remove();
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> object) {
        int n = object.size();
        object = object.iterator();
        while (n-- != 0) {
            if (this.contains(object.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean bl = false;
        int n = this.size();
        cp cp2 = this.a();
        while (n-- != 0) {
            if (collection.contains(cp2.next())) continue;
            cp2.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean removeAll(Collection<?> object) {
        boolean bl = false;
        int n = object.size();
        object = object.iterator();
        while (n-- != 0) {
            if (!this.remove(object.next())) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        cp cp2 = this.a();
        int n = this.size();
        boolean bl = true;
        stringBuilder.append("{");
        while (n-- != 0) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            double d = cp2.b();
            stringBuilder.append(String.valueOf(d));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ boolean add(Object object) {
        return this.a((Double)object);
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.a();
    }
}
