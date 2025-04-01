/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.dw;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class eb {
    public static final a a = new a();

    public static <K> int a(Iterator<? extends K> iterator, K[] KArray) {
        int n = KArray.length;
        int n2 = 0;
        if (n < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + n + ") is negative");
        }
        if (n > KArray.length) {
            throw new IllegalArgumentException();
        }
        int n3 = n;
        while (n3-- != 0 && iterator.hasNext()) {
            KArray[n2++] = iterator.next();
        }
        return n - n3 - 1;
    }

    public static final class a<K>
    extends dw<K>
    implements Serializable,
    Cloneable {
        protected a() {
        }

        @Override
        public final boolean hasNext() {
            return false;
        }

        @Override
        public final boolean hasPrevious() {
            return false;
        }

        @Override
        public final K next() {
            throw new NoSuchElementException();
        }

        @Override
        public final K previous() {
            throw new NoSuchElementException();
        }

        @Override
        public final int nextIndex() {
            return 0;
        }

        @Override
        public final int previousIndex() {
            return -1;
        }

        public final Object clone() {
            return a;
        }
    }
}
