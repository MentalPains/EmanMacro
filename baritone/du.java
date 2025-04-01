/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.dy;
import baritone.ea;
import baritone.eb;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public abstract class du<K>
extends AbstractCollection<K>
implements dy<K> {
    protected du() {
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
    public boolean addAll(Collection<? extends K> collection) {
        boolean bl = false;
        Iterator<K> iterator = collection.iterator();
        int n = collection.size();
        while (n-- != 0) {
            if (!this.add(iterator.next())) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public abstract ea<K> a();

    @Override
    public boolean remove(Object object) {
        return this.a(object);
    }

    public boolean a(Object object) {
        ea<K> ea2 = this.a();
        while (ea2.hasNext()) {
            if (object != ea2.next()) continue;
            ea2.remove();
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
        ea<K> ea2 = this.a();
        while (n-- != 0) {
            if (collection.contains(ea2.next())) continue;
            ea2.remove();
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
        ea<K> ea2 = this.a();
        int n = this.size();
        boolean bl = true;
        stringBuilder.append("{");
        while (n-- != 0) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            Object e = ea2.next();
            if (this == e) {
                stringBuilder.append("(this collection)");
                continue;
            }
            stringBuilder.append(String.valueOf(e));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.a();
    }
}
