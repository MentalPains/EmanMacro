/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.dp;
import baritone.dr;
import baritone.eb;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public abstract class db
extends AbstractCollection<Long>
implements dp {
    protected db() {
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
    public boolean addAll(Collection<? extends Long> collection) {
        boolean bl = false;
        Iterator<? extends Long> iterator = collection.iterator();
        int n = collection.size();
        while (n-- != 0) {
            if (!this.a(iterator.next())) continue;
            bl = true;
        }
        return bl;
    }

    public boolean b(long l) {
        throw new UnsupportedOperationException();
    }

    public abstract dr a();

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            return false;
        }
        return this.c((Long)object);
    }

    private boolean a(Long l) {
        return this.b(l);
    }

    @Override
    public boolean contains(Object object) {
        if (object == null) {
            return false;
        }
        return this.a((long)((Long)object));
    }

    @Override
    public boolean a(long l) {
        dr dr2 = this.a();
        while (dr2.hasNext()) {
            if (l != dr2.a()) continue;
            return true;
        }
        return false;
    }

    public boolean c(long l) {
        dr dr2 = this.a();
        while (dr2.hasNext()) {
            if (l != dr2.a()) continue;
            dr2.remove();
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
        dr dr2 = this.a();
        while (n-- != 0) {
            if (collection.contains(dr2.next())) continue;
            dr2.remove();
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
        dr dr2 = this.a();
        int n = this.size();
        boolean bl = true;
        stringBuilder.append("{");
        while (n-- != 0) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            long l = dr2.a();
            stringBuilder.append(String.valueOf(l));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ boolean add(Object object) {
        return this.a((Long)object);
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.a();
    }
}
